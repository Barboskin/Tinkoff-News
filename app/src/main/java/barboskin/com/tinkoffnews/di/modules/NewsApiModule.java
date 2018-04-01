package barboskin.com.tinkoffnews.di.modules;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import barboskin.com.tinkoffnews.BuildConfig;
import barboskin.com.tinkoffnews.data.network.TinkoffNewsApi;
import barboskin.com.tinkoffnews.data.network.TinkoffNewsApiService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Maestro on 31.03.2018.
 */

@Module
public class NewsApiModule {

    @Provides
    @Singleton
    public TinkoffNewsApiService provideTinkoffNewsApiService(TinkoffNewsApi tinkoffNewsApi){
        return new TinkoffNewsApiService(tinkoffNewsApi);
    }

    @Provides
    @Singleton
    public TinkoffNewsApi provideTinkoffNewsApi(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.TINKOFF_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(TinkoffNewsApi.class);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }
}
