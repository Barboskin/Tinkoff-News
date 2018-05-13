package barboskin.com.tinkoffnews.newsdetail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import barboskin.com.tinkoffnews.App;
import barboskin.com.tinkoffnews.R;
import barboskin.com.tinkoffnews.data.model.News;
import barboskin.com.tinkoffnews.utils.StringUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements NewsDetailContract.View {

    public static final String NEWS_ID = "NEWS_ID";

    @BindView(R.id.news_detail_text)
    TextView newsDetailText;

    @BindView(R.id.news_detail_title)
    TextView newsDetailTitle;

    @BindView(R.id.detail_progress)
    ProgressBar progressBar;

    @BindView(R.id.detail_error)
    TextView errorMessage;

    @Inject
    NewsDetailContract.Presenter presenter;

    public static void startActivity(Context context, int newsId){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(NEWS_ID, newsId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        int id = getIntent().getIntExtra(NEWS_ID, 0);

        App.getComponentsHolder().getNewsDetailComponent().inject(this);
        presenter.takeView(this);
        presenter.loadNews(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        presenter.dropView();

        if (isFinishing()){
            App.getComponentsHolder().releaseNewsDetailComponent();
        }
    }

    @Override
    public void setPresenter(NewsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showDetailNews(News news) {
        newsDetailText.setText(StringUtils.fromHtml(news.getContent()));
        newsDetailTitle.setText(StringUtils.fromHtml(news.getTitle()));
    }

    @Override
    public void showLoadProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        errorMessage.setText(getString(R.string.detail_error));
        errorMessage.setVisibility(View.VISIBLE);
    }
}
