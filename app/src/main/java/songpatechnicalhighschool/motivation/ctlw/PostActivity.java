package songpatechnicalhighschool.motivation.ctlw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

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
    private DatabaseReference reference;
    private String topic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        Intent getIntent = getIntent();
        topic = getIntent.getExtras().getString("topic");
        reference = FirebaseDatabase.getInstance().getReference("Post");

        postView = findViewById(R.id.post_post_view);
        postView.setHasFixedSize(true);
        postView.setLayoutManager(new LinearLayoutManager(this));

        posts = new ArrayList<>();

        addPost();

        postAdapter = new PostAdapter(posts, this, topic);
        postView.setAdapter(postAdapter);
    }

    private void addPost() {

        reference.child(topic).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                posts.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Post post = snapshot.getValue(Post.class);
                    posts.add(post);
                }

                postAdapter = new PostAdapter(posts, PostActivity.this, topic);
                postView.setAdapter(postAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
