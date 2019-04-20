package songpatechnicalhighschool.motivation.ctlw.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

import songpatechnicalhighschool.motivation.ctlw.Module.Post;
import songpatechnicalhighschool.motivation.ctlw.PostDetailActivity;
import songpatechnicalhighschool.motivation.ctlw.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;
    private Context context;
    private String topic;

    public PostAdapter(List<Post> posts, Context context, String topic) {
        this.posts = posts;
        this.context = context;
        this.topic = topic;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme_post_card, viewGroup, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int i) {
        final Post post = posts.get(i);
        holder.titleText.setText(post.getTitle());
        holder.dateText.setText(post.getDate());
        holder.previewText.setText(post.getPreview());
        final String title = post.getTitle();
        holder.postLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostDetailActivity.class);
                intent.putExtra("topic", topic);
                intent.putExtra("title", title);
                intent.putExtra("key", post.getKey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleText;
        public TextView dateText;
        public TextView previewText;
        public CardView postLayout;
        public TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.post_title_text);
            dateText = itemView.findViewById(R.id.post_time_text);
            previewText = itemView.findViewById(R.id.post_preview_text);
            postLayout = itemView.findViewById(R.id.post_post_layout);
        }
    }
}
