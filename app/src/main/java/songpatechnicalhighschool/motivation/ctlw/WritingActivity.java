package songpatechnicalhighschool.motivation.ctlw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class WritingActivity extends AppCompatActivity {

    EditText youngMin, youngMax, oldMin, oldMax, title, content, user1, user2;
    Spinner topic;
    Button postingBtn;
    DatabaseReference reference;
    String topicText, youngMinText, youngMaxText, oldMinText, oldMaxText, titleText, contentText, user1Text, user2Text, key;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        init();

        postingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youngMinText = youngMin.getText().toString();
                youngMaxText = youngMax.getText().toString();
                oldMinText = youngMin.getText().toString();
                oldMaxText = youngMin.getText().toString();
                titleText = title.getText().toString();
                contentText = content.getText().toString();
                user1Text = user1.getText().toString();
                user2Text = user2.getText().toString();

                doPosting(firebaseUser.getEmail(), topicText, youngMinText, youngMaxText, oldMinText, oldMaxText, titleText, contentText, user1Text, user2Text);
            }
        });

        topic.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                topicText = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void doPosting(String uploader, String topic, String youngMin, String youngMax, String oldMin,
                           String oldMax, String title, String content, String user1, String user2) {

        reference = FirebaseDatabase.getInstance().getReference("Post").child(topic).push();
        String previewText;
        //Toast.makeText(this, reference.getKey(), Toast.LENGTH_SHORT).show();
        key = reference.getKey();
        if(content.length() < 70) {
            previewText = content;
        } else {
            previewText = content.substring(0, 70);
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Uploader", uploader);
        hashMap.put("topic", topic);
        hashMap.put("youngMin", youngMin);
        hashMap.put("youngMax", youngMax);
        hashMap.put("oldMin", oldMin);
        hashMap.put("oldMax", oldMax);
        hashMap.put("title", title);
        hashMap.put("content", content);
        hashMap.put("preview", previewText);
        hashMap.put("user1", user1Text);
        hashMap.put("user2", user2Text);
        hashMap.put("user1Vote", "0");
        hashMap.put("user2Vote", "0");
        hashMap.put("key", key);

        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    finish();
                }
            }
        });
    }

    private void init() {
        topic = findViewById(R.id.writing_topic_spinner);
        youngMin = findViewById(R.id.writing_youngMin_edit);
        youngMax = findViewById(R.id.writing_youngMax_edit);
        oldMin = findViewById(R.id.writing_oldMin_edit);
        oldMax = findViewById(R.id.writing_oldMax_edit);
        title = findViewById(R.id.writing_title_edit);
        content = findViewById(R.id.writing_content_edit);
        postingBtn = findViewById(R.id.writing_posting_btn);
        user1 = findViewById(R.id.writing_user1_edit);
        user2 = findViewById(R.id.writing_user2_edit);
    }
}
