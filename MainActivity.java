package rkapoors.torchapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    ToggleButton tb;
    SeekBar sb;
    TextView t1;
    Button bt;
String a="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb=(ToggleButton)findViewById(R.id.tb1);
        sb=(SeekBar)findViewById(R.id.sb);
        t1=(TextView)findViewById(R.id.t1);
        bt=(Button)findViewById(R.id.bt);
        t1.setText("Brightness : " + sb.getProgress()+"/"+sb.getMax());
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    a="ON";
                    sb.setProgress(sb.getMax());
                }
                else a="OFF";

                Toast.makeText(MainActivity.this,"It is : "+a,Toast.LENGTH_SHORT).show();
            }

    });
sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    t1.setText("Brightness : " + progress+"/"+sb.getMax());
                             //sb.getProgress()
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
//when user just touch the seekbar
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
//when user stopped touching seekbar
    }
});
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });
    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure,you want to exit");
        alertDialogBuilder.setTitle("Exit !");
        alertDialogBuilder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
               System.exit(0);
            }
        });

        alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You clicked no button",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
