package barboskin.com.tinkoffnews.data.network.response.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("payload")
    @Expose
    private List<Payload> payload = null;
    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public NewsResponse withResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public NewsResponse withPayload(List<Payload> payload) {
        this.payload = payload;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public NewsResponse withTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

}
