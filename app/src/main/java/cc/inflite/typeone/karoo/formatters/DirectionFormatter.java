package cc.inflite.typeone.karoo.formatters;

import android.content.Context;

import androidx.annotation.NonNull;

import cc.inflite.typeone.data.SGVServiceData;
import cc.inflite.typeone.service.BackgroundServiceClient;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;

public class DirectionFormatter extends SdkFormatter {

    private final SdkContext context;

    public DirectionFormatter(SdkContext context) {
        this.context = context;
    }

    @NonNull
    @Override
    public String formatValue(double v) {
        SGVServiceData data = BackgroundServiceClient.DEFAULT.getValue().getSGVData(context);

        if (data.isError()) {
            if (data.getErrorMessage() != null &&
                    data.getErrorMessage().contains("Unable to resolve host")){
                return "NO INTERNET";
            } else {
                return "ERROR";
            }
        }

        if (data.getData() == null) {
            return "N/A";
        }

        return data.getData().getDirection();
    }
}