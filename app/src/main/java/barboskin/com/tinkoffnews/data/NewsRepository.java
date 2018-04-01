package barboskin.com.tinkoffnews.data;

import java.util.List;




import barboskin.com.tinkoffnews.data.local.NewsDatabase;
import barboskin.com.tinkoffnews.data.model.News;
import barboskin.com.tinkoffnews.data.network.TinkoffNewsApiService;
import io.reactivex.Single;

/**
 * Created by Maestro on 30.03.2018.
 */

public class NewsRepository {

    private TinkoffNewsApiService newsApiService;
    private NewsDatabase newsDatabase;

    public NewsRepository(TinkoffNewsApiService newsApiService, NewsDatabase newsDatabase) {
        this.newsApiService = newsApiService;
        this.newsDatabase = newsDatabase;
    }

    public Single<List<News>> getNews(){
        return newsApiService.getNews()
                .doAfterSuccess(x -> newsDatabase.newsDao().insert(x))
                .onErrorResumeNext(newsDatabase.newsDao().getAll().toSingle());
    }

    public Single<News> getDetailNews(int id){
        return newsDatabase.newsDao().getNews(id)
                .filter(x -> x.getContent() != null && !x.getContent().isEmpty())
                .switchIfEmpty(newsApiService.getDetailNews(id))
                .doAfterSuccess(x -> newsDatabase.newsDao().update(x));
    }

    public Single<List<News>> updateNews(){
        return newsApiService.getNews()
                .doAfterSuccess(x -> newsDatabase.newsDao().insert(x));
    }
}
