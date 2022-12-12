package cc.inflite.typeone.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SGVData {

    @Expose
    @SerializedName("_id")
    private final String id;

    @Expose
    private final String device;

    @Expose
    private final long date;

    @Expose
    private final String dateString;

    @Expose
    @SerializedName("isValid")
    private final boolean valid;

    @Expose
    private final int sgv;

    @Expose
    private final String direction;

    @Expose
    private final String type;

    @Expose
    @SerializedName("created_at")
    private final String createdAt;

    @Expose
    private final long mills;

    public SGVData(String id, String device, long date, String dateString, boolean valid, int sgv, String direction, String type, String createdAt, long mills) {
        this.id = id;
        this.device = device;
        this.date = date;
        this.dateString = dateString;
        this.valid = valid;
        this.sgv = sgv;
        this.direction = direction;
        this.type = type;
        this.createdAt = createdAt;
        this.mills = mills;
    }

    public String getId() {
        return id;
    }

    public String getDevice() {
        return device;
    }

    public long getDate() {
        return date;
    }

    public String getDateString() {
        return dateString;
    }

    public boolean isValid() {
        return valid;
    }

    public int getSgv() {
        return sgv;
    }

    public String getDirection() {
        return direction;
    }

    public String getType() {
        return type;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public long getMills() {
        return mills;
    }
}
