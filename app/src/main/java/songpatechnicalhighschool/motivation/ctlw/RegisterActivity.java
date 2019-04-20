package songpatechnicalhighschool.motivation.ctlw;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText email, name, gender, age, birth, password;
    Button signup;
    FirebaseAuth firebaseAuth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.register_email_edit);
        name = findViewById(R.id.register_name_edit);
        gender = findViewById(R.id.register_gender_edit);
        age = findViewById(R.id.register_age_edit);
        birth = findViewById(R.id.register_birth_edit);
        password = findViewById(R.id.register_password_edit);
        signup = findViewById(R.id.register_signup_btn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String nameText = name.getText().toString();
                String genderText = gender.getText().toString();
                String ageText = age.getText().toString();
                String birthText = birth.getText().toString();

                if(TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText) || TextUtils.isEmpty(emailText)){
                    Toast.makeText(RegisterActivity.this, "All fileds are required", Toast.LENGTH_LONG).show();
                } else if(passwordText.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password must be at least 6 characters", Toast.LENGTH_LONG).show();
                } else {
                    register(emailText, passwordText, nameText, genderText, ageText, birthText);
                }
            }
        });
    }

    public void register(final String email, String password, final String username, final String gender, final String age, final String birthText) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            String userid = ((FirebaseUser) firebaseUser).getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("ageText", age);
                            hashMap.put("gender", gender);
                            hashMap.put("birth", birthText);
                            hashMap.put("imageURL", "default");


                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "You can't register with this email or password", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

