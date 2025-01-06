package com.example.mindbodyearth.Activities;

/*import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mindbodyearth.Dao.UserDao;
import com.example.mindbodyearth.Entities.User;
import com.example.mindbodyearth.InitDb;
import com.example.mindbodyearth.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userDao = InitDb.appDatabase.userDao;

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        insertTestUser();
    }

    private void login() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter login credentials", Toast.LENGTH_SHORT).show();
            return;
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                final User user = userDao.getUserByEmail(email);

                //Handle the result on the main thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (user != null && password.equals(user.getPassword())) {
                            //can login, go to activity_main
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            //login fail
                            Toast.makeText(LoginActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void insertTestUser() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //check admin existence in db
                if(userDao.getUserByEmail("khairanafisa4@gmail.com") == null) {
                    //Insert the test user
                    User testUser = new User();
                    testUser.setEmail("khairanafisa4@gmail.com");
                    testUser.setPassword("abcd1234");
                    testUser.setUsername("khairanafisa4");

                    userDao.insert(testUser);
                }
            }
        });
    }

}*/