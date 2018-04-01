package barboskin.com.tinkoffnews.data.network;

import java.util.List;
import java.util.concurrent.TimeUnit;

import barboskin.com.tinkoffnews.BuildConfig;
import barboskin.com.tinkoffnews.data.DataConverter;
import barboskin.com.tinkoffnews.data.model.News;
import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Maestro on 28.03.2018.
 */

public class TinkoffNewsApiService {

    private TinkoffNewsApi newsApiService;

    public TinkoffNewsApiService(TinkoffNewsApi newsApiService) {
        this.newsApiService = newsApiService;
    }

    public Single<List<News>> getNews(){
        return newsApiService.getNews()
                .map(DataConverter::getNewsFromNewsResponse);
    }

    public Single<News> getDetailNews(int id){
        return newsApiService.getDetailNews(id)
                .map(DataConverter::getNewsFromNewsContentResposnse);
    }
}
