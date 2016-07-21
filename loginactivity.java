package rkapoors.loginpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends Activity {

    EditText etname,etpass;
    Button lb;
    LoginAdapter loginadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        loginadapter=new LoginAdapter(this);
        loginadapter=loginadapter.open();

        etname=(EditText)findViewById(R.id.name);
        etpass=(EditText)findViewById(R.id.pass);
        lb=(Button)findViewById(R.id.button);

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=etname.getText().toString();
                String pass=etpass.getText().toString();

                String opass=loginadapter.getPassword(user);

                if(opass.equals(pass))
                {
                    Toast.makeText(loginactivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(loginactivity.this,"Unsuccessful Attempt!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        loginadapter.close();
    }
}
