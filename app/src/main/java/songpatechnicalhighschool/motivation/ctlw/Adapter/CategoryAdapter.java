package songpatechnicalhighschool.motivation.ctlw.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import songpatechnicalhighschool.motivation.ctlw.Module.Category;
import songpatechnicalhighschool.motivation.ctlw.PostActivity;
import songpatechnicalhighschool.motivation.ctlw.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categories;
    private Context context;

    public CategoryAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_topic_card, viewGroup, false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int i) {
        final Category category = categories.get(i);

        holder.topicText.setText(category.getTopic());
        holder.topicLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("topic", category.getTopic());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView topicText;
        public CardView topicLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            topicLayout = itemView.findViewById(R.id.item_cardview_background);
            topicText = itemView.findViewById(R.id.item_topic_text);
        }
    }
}
