package rkapoors.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//reference from hackpundit.com

public class login extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_button;
    int attempt_counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbutton();
    }

    public void loginbutton() {
        username = findViewById(R.id.editText_user);
        password = findViewById(R.id.editText_password);
        attempt = findViewById(R.id.textView_attempt);
        login_button = findViewById(R.id.login_button);

        attempt.setText(Integer.toString(attempt_counter));

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("student") && password.getText().toString().equals("student")) {
                            Toast.makeText(login.this, "Username and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("rkapoors.loginapp.user");
                            startActivity(intent);

                        } else {
                            Toast.makeText(login.this, "Username and password are INCORRECT",
                                    Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            attempt.setText(Integer.toString(attempt_counter));
                            if (attempt_counter == 0) {
                                login_button.setEnabled(false);
                                Toast.makeText(login.this, "Access Denied.You have no permission to login now",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
