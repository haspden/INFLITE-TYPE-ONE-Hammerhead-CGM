package cc.inflite.typeone.data;

public class PreferenceData {

    private final String serverAddress;
    private final String apiSecret;
    private final int updateFrequency;

    public PreferenceData(String serverAddress, int updateFrequency, String apiSecret) {
        this.serverAddress = serverAddress;
        this.updateFrequency = updateFrequency;
        this.apiSecret = apiSecret;
    }

    public String getServerAddress() {
        return serverAddress;
    }
    public String getApiSecret() {
        return apiSecret;
    }

    public int getUpdateFrequency() {
        return updateFrequency;
    }
}
