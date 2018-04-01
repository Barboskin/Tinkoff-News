package barboskin.com.tinkoffnews.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Maestro on 30.03.2018.
 */

@Entity
public class News implements Comparable {

    @PrimaryKey
    private int id;

    private String title;

    private String content;

    private long publicationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(long publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        News compareObject = (News) o;
        if (publicationDate == compareObject.getPublicationDate()){
            return 0;
        }

        if (publicationDate > compareObject.getPublicationDate()){
            return 1;
        } else {
            return -1;
        }
    }
}
