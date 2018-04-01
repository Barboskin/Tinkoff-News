package barboskin.com.tinkoffnews.data.network.response.news_content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsContentResponse {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payload")
    @Expose
    private Payload payload;
    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public NewsContentResponse withResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public NewsContentResponse withPayload(Payload payload) {
        this.payload = payload;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public NewsContentResponse withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

}
