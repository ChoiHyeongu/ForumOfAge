package songpatechnicalhighschool.motivation.ctlw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import songpatechnicalhighschool.motivation.ctlw.Adapter.CategoryAdapter;
import songpatechnicalhighschool.motivation.ctlw.Adapter.PostAdapter;
import songpatechnicalhighschool.motivation.ctlw.Module.Category;
import songpatechnicalhighschool.motivation.ctlw.Module.Post;

public class PostActivity extends AppCompatActivity {

    private RecyclerView postView;
    private PostAdapter postAdapter;
    private List<Post> posts;
    private String content = "저는 고3 여학생입니다.\n" +
            "전문계 식품과를 다니는데 토요일에 학교에서 어찌저찌하여";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        postView = findViewById(R.id.post_post_view);
        postView.setHasFixedSize(true);
        postView.setLayoutManager(new LinearLayoutManager(this));

        posts = new ArrayList<>();

        addPost();

        postAdapter = new PostAdapter(posts, this);
        postView.setAdapter(postAdapter);
    }

    private void addPost() {
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));
        posts.add(new Post("엄마랑 싸웠는데 어떻게하죠?", "09:30", content, ""));


    }
}
