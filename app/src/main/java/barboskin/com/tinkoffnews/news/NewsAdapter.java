package barboskin.com.tinkoffnews.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import barboskin.com.tinkoffnews.R;
import barboskin.com.tinkoffnews.data.model.News;
import barboskin.com.tinkoffnews.utils.DateUtils;
import barboskin.com.tinkoffnews.utils.StringUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Maestro on 28.03.2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private LayoutInflater inflater;
    private List<News> news;
    private OnItemClickListener listener;

    public NewsAdapter(Context context, List<News> news){
        inflater = LayoutInflater.from(context);
        this.news = news;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        News currentNews = news.get(position);

        holder.date.setText(DateUtils.getFormatDate(currentNews.getPublicationDate(), "dd.MM.YYYY"));
        holder.title.setText(StringUtils.fromHtml(currentNews.getTitle()));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void addOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void setNews(List<News> news){
        this.news = news;
        notifyDataSetChanged();
    }

    public class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.news_list_date)
        TextView date;
        @BindView(R.id.news_list_title)
        TextView title;

        public NewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            NewsAdapter.this.listener.onItemClick(itemView, getLayoutPosition(), v);
        }
    }



    public interface OnItemClickListener{
        void onItemClick(View itemView, int position, View view);
    }

}
