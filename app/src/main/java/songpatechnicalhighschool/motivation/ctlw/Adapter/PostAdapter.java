package songpatechnicalhighschool.motivation.ctlw.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import songpatechnicalhighschool.motivation.ctlw.Module.Post;
import songpatechnicalhighschool.motivation.ctlw.R;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;
    private Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.itme_post, viewGroup, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int i) {
        Post post = posts.get(i);
        holder.titleText.setText(post.getTitle());
        holder.dateText.setText(post.getDate());
        holder.previewText.setText(post.getPreview());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleText;
        public TextView dateText;
        public TextView previewText;
        public TextView content;

        public ViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.post_title_text);
            dateText = itemView.findViewById(R.id.post_time_text);
            previewText = itemView.findViewById(R.id.post_preview_text);
        }
    }
}
