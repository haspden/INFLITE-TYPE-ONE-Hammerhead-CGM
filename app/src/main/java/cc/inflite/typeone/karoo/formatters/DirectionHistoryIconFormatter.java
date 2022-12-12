package cc.inflite.typeone.karoo.formatters;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cc.inflite.typeone.data.SGVData;
import cc.inflite.typeone.data.SGVServiceData;
import cc.inflite.typeone.service.BackgroundServiceClient;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;

public class DirectionHistoryIconFormatter extends SdkFormatter {

    private static final Map<String, String> DIRECTION_ICON_MAP = new HashMap<>();

    static {
        DIRECTION_ICON_MAP.put("DoubleDown", "↓↓");
        DIRECTION_ICON_MAP.put("SingleDown", "↓");
        DIRECTION_ICON_MAP.put("FortyFiveDown", "↘");
        DIRECTION_ICON_MAP.put("Flat", "→");
        DIRECTION_ICON_MAP.put("SingleUp", "↑");
        DIRECTION_ICON_MAP.put("FortyFiveUp", "↗");
        DIRECTION_ICON_MAP.put("DoubleUp", "↑↑");
    }

    private final Context context;
    private final List<String> history;
    private SGVData lastData;

    public DirectionHistoryIconFormatter(Context context) {
        this.context = context;
        history = new LinkedList<>();
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

        if (history.isEmpty() || !data.getData().getId().equals(lastData.getId())) {
            history.add(DIRECTION_ICON_MAP.getOrDefault(data.getData().getDirection(), "X"));
        }

        lastData = data.getData();
        if (history.size() > 5) {
            history.remove(0);
        }

        return String.join(" ", history);
    }
}