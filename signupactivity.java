package rkapoors.loginpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupactivity extends Activity {

    EditText etuser,etpass1,etpass2;
    Button sb;
    LoginAdapter loginadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);

        etuser=(EditText)findViewById(R.id.user);
        etpass1=(EditText)findViewById(R.id.pass1);
        etpass2=(EditText)findViewById(R.id.pass2);
        sb=(Button)findViewById(R.id.sb);

        loginadapter=new LoginAdapter(this);
        loginadapter=loginadapter.open();

        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=etuser.getText().toString();
                String pass=etpass1.getText().toString();
                String cpass=etpass2.getText().toString();

                if(user.equals("")||pass.equals("")||cpass.equals(""))
                {
                    Toast.makeText(signupactivity.this,"Field(s) is(are) vacant !!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(cpass))
                {
                    Toast.makeText(signupactivity.this,"Passwords don't match !!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    loginadapter.insertentry(user,pass);
                    Toast.makeText(signupactivity.this,"Account Successfully Created",Toast.LENGTH_SHORT).show();

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
