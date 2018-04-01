package barboskin.com.tinkoffnews.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import barboskin.com.tinkoffnews.data.model.News;
import io.reactivex.Maybe;

/**
 * Created by Maestro on 31.03.2018.
 */
@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    Maybe<List<News>> getAll();

    @Query("SELECT * FROM news WHERE id = :id")
    Maybe<News> getNews(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<News> news);

    @Update
    void update(News news);
}
