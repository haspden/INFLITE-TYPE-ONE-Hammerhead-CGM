package cc.inflite.typeone.data;

import java.time.Instant;

public class SGVServiceData {

    private final SGVData data;
    private final Instant timestamp;
    private final boolean error;
    private final String errorMessage;

    public SGVServiceData(SGVData data, Instant timestamp, boolean error, String errorMessage) {
        this.data = data;
        this.timestamp = timestamp;
        this.error = error;
        this.errorMessage = errorMessage;
    }

    public SGVServiceData(SGVData data, Instant timestamp) {
        this.data = data;
        this.timestamp = timestamp;
        this.error = false;
        this.errorMessage = null;
    }

    public SGVData getData() {
        return data;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
