package rkapoors.apppractice;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1=new TextView(this);
        t1.setText("Hello NITJians");
        //t1.setBackgroundColor(Color.BLUE);
        setContentView(t1);
    }
}
