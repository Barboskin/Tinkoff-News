package barboskin.com.tinkoffnews.data.network.response.news_content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("milliseconds")
    @Expose
    private Long milliseconds;

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Date withMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
        return this;
    }

}