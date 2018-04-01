package barboskin.com.tinkoffnews.data;

import java.util.ArrayList;
import java.util.List;

import barboskin.com.tinkoffnews.data.model.News;
import barboskin.com.tinkoffnews.data.network.response.news.NewsResponse;
import barboskin.com.tinkoffnews.data.network.response.news.Payload;
import barboskin.com.tinkoffnews.data.network.response.news_content.NewsContentResponse;
import barboskin.com.tinkoffnews.data.network.response.news_content.Title;

/**
 * Created by Maestro on 30.03.2018.
 */

public class DataConverter {

    public static List<News> getNewsFromNewsResponse(NewsResponse newsResponse){
        List<News> result = new ArrayList<>();
        News news;

        for (Payload payload : newsResponse.getPayload()){
             news = new News();
             news.setId(payload.getId());
             news.setTitle(payload.getText());
             news.setPublicationDate(payload.getPublicationDate().getMilliseconds());

             result.add(news);
        }

        return result;
    }

    public static News getNewsFromNewsContentResposnse(NewsContentResponse newsContentResponse){
        News news = new News();
        Title title = newsContentResponse.getPayload().getTitle();
        news.setId(title.getId());
        news.setTitle(title.getText());
        news.setPublicationDate(title.getPublicationDate().getMilliseconds());
        news.setContent(newsContentResponse.getPayload().getContent());

        return news;
    }
}
