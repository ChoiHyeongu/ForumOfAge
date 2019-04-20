package songpatechnicalhighschool.motivation.ctlw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import songpatechnicalhighschool.motivation.ctlw.Module.Post;

public class PostDetailActivity extends AppCompatActivity {

    TextView title, content;
    TextView user1Ratio, user2Ratio;
    Button user1, user2;

    String topic;
    String getTitle;
    String vote1, vote2;
    String key;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        user1Ratio = findViewById(R.id.detail_user1_ratio);
        user2Ratio = findViewById(R.id.detail_user2_ratio);

        Intent getIntent = getIntent();
        getTitle = getIntent.getExtras().getString("title");
        topic = getIntent.getExtras().getString("topic");
        key = getIntent.getExtras().getString("key");

        reference = FirebaseDatabase.getInstance().getReference("Post").child(topic).child(key);

        title = findViewById(R.id.detail_title_text);
        content = findViewById(R.id.detail_content_text);
        content.setMovementMethod(new ScrollingMovementMethod());
        user1 = findViewById(R.id.detail_user1_btn);
        user1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int tmpVote = Integer.parseInt(vote1) + 1;
                reference.child("user1Vote").setValue(Integer.toString(tmpVote));
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) user1Ratio.getLayoutParams();
                params.weight=tmpVote;
                user1Ratio.setLayoutParams(params);
            }
        });

        user2 = findViewById(R.id.detail_user2_btn);
        user2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmpVote = Integer.parseInt(vote2) + 1;
                reference.child("user2Vote").setValue(Integer.toString(tmpVote));
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) user2Ratio.getLayoutParams();
                params.weight = tmpVote;
                user2Ratio.setLayoutParams(params);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
                if (post.getTitle().equals(getTitle)) {
                    title.setText(post.getTitle());
                    content.setText(post.getContent());
                    user1.setText(post.getUser1());
                    user2.setText(post.getUser2());
                    user1Ratio.setText(post.getUser1Vote());
                    user2Ratio.setText(post.getUser2Vote());
                    vote1 = post.getUser1Vote();
                    vote2 = post.getUser2Vote();
                    post.setUser1Vote(vote1);
                    post.setUser2Vote(vote2);

                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) user1Ratio.getLayoutParams();
                    params.weight=Integer.parseInt(post.getUser1Vote());
                    user1Ratio.setLayoutParams(params);

                    params = (LinearLayout.LayoutParams) user2Ratio.getLayoutParams();
                    params.weight=Integer.parseInt(post.getUser2Vote());
                    user2Ratio.setLayoutParams(params);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
