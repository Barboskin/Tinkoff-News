package barboskin.com.tinkoffnews.news;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import barboskin.com.tinkoffnews.App;
import barboskin.com.tinkoffnews.newsdetail.DetailActivity;
import barboskin.com.tinkoffnews.R;
import barboskin.com.tinkoffnews.data.model.News;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NewsContract.View{

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.news_list)
    RecyclerView recyclerView;

    @BindView(R.id.main_progress)
    ProgressBar progressBar;

    @BindView(R.id.main_error)
    TextView errorMessage;

    List<News> news = new ArrayList<>();
    NewsAdapter adapter;

    @Inject
    NewsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        App.getAppComponent().inject(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter = new NewsAdapter(this, news);
        adapter.addOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position, View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.NEWS_ID, news.get(position).getId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

        presenter.takeView(this);
        presenter.loadNews();

        swipeRefreshLayout.setOnRefreshListener(() ->
            presenter.updateNews()
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
        presenter.dropView();
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showNews(List<News> news) {
        adapter.setNews(news);
        this.news = news;
    }

    @Override
    public void showError() {
        errorMessage.setText(getString(R.string.list_news_error));
        errorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUpdateError() {
        Toast.makeText(this, getString(R.string.list_news_update_error), Toast.LENGTH_LONG).show();
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
    public void showUpdateProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideUpdateProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }
}

