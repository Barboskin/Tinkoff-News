package barboskin.com.tinkoffnews.data.network.response.news;

/**
 * Created by Maestro on 29.03.2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import barboskin.com.tinkoffnews.data.network.response.news_content.Date;


public class Payload {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("publicationDate")
    @Expose
    private Date publicationDate;
    @SerializedName("bankInfoTypeId")
    @Expose
    private Integer bankInfoTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Payload withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Payload withName(String name) {
        this.name = name;
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Payload withText(String text) {
        this.text = text;
        return this;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Payload withPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public Payload withBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
        return this;
    }

}
