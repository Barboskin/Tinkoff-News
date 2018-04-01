package barboskin.com.tinkoffnews.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import barboskin.com.tinkoffnews.data.local.NewsDatabase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Maestro on 31.03.2018.
 */
@Module(includes = ContextModule.class)
public class LocalStorageModule {

    @Provides
    @Singleton
    public NewsDatabase provideNewsDatabase(Context context){
        return Room.databaseBuilder(context, NewsDatabase.class, "newsDatabase")
                .build();
    }
}
