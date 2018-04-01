package barboskin.com.tinkoffnews.data.network.response.news_content;

/**
 * Created by Maestro on 29.03.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("creationDate")
    @Expose
    private Date creationDate;
    @SerializedName("lastModificationDate")
    @Expose
    private Date lastModificationDate;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("bankInfoTypeId")
    @Expose
    private Integer bankInfoTypeId;
    @SerializedName("typeId")
    @Expose
    private String typeId;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Payload withTitle(Title title) {
        this.title = title;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Payload withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Payload withLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Payload withContent(String content) {
        this.content = content;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Payload withTypeId(String typeId) {
        this.typeId = typeId;
        return this;
    }

}
