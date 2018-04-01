package barboskin.com.tinkoffnews.data.network;



import barboskin.com.tinkoffnews.data.network.response.news.NewsResponse;
import barboskin.com.tinkoffnews.data.network.response.news_content.NewsContentResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Maestro on 27.03.2018.
 */

public interface TinkoffNewsApi {

    @GET("v1/news")
    Single<NewsResponse> getNews();

    @GET("v1/news_content")
    Single<NewsContentResponse> getDetailNews(@Query("id") int id);
}
