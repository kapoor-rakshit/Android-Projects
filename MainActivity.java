package rkapoors.loginpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button lb,sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lb=(Button)findViewById(R.id.loginbutton);
        sb=(Button)findViewById(R.id.signupbutton);

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent li=new Intent(MainActivity.this,loginactivity.class);
                startActivity(li);
            }
        });

        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si=new Intent(MainActivity.this,signupactivity.class);
                startActivity(si);
            }
        });
    }
}
