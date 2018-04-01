package barboskin.com.tinkoffnews.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import barboskin.com.tinkoffnews.data.model.News;

/**
 * Created by Maestro on 31.03.2018.
 */
@Database(entities = {News.class}, version =  1)
public abstract class NewsDatabase extends RoomDatabase{
    public abstract NewsDao newsDao();
}
