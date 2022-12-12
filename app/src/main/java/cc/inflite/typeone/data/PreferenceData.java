package cc.inflite.typeone.data;

public class PreferenceData {

    private final String serverAddress;
    private final int updateFrequency;

    public PreferenceData(String serverAddress, int updateFrequency) {
        this.serverAddress = serverAddress;
        this.updateFrequency = updateFrequency;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public int getUpdateFrequency() {
        return updateFrequency;
    }
}
