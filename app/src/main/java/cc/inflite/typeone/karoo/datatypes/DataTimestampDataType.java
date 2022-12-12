package cc.inflite.typeone.karoo.datatypes;

import androidx.annotation.NonNull;

import cc.inflite.typeone.karoo.formatters.DataTimestampFormatter;
import cc.inflite.typeone.karoo.formatters.MMollFormatter;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.SdkDataType;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;
import io.hammerhead.sdk.v0.datatype.transformer.BuiltInTransformer;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;
import io.hammerhead.sdk.v0.datatype.view.BuiltInView;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class DataTimestampDataType extends SdkDataType {

    private static final String ID = "IFTO::text-update-timestamp";

    public DataTimestampDataType(@NonNull SdkContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getDescription() {
        return "Last data timestamp";
    }

    @NonNull
    @Override
    public String getDisplayName() {
        return "Data time";
    }

    @NonNull
    @Override
    public String getTypeId() {
        return ID;
    }

    @NonNull
    @Override
    public SdkFormatter newFormatter() {
        return new DataTimestampFormatter(getContext());
    }

    @NonNull
    @Override
    public SdkTransformer newTransformer() {
        return new BuiltInTransformer.Identity(getContext());
    }

    @NonNull
    @Override
    public SdkView newView() {
        return new BuiltInView.Numeric(getContext());
    }
}