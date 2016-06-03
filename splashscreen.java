package rkapoors.apppractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * Created by KAPOOR's on 31-05-2016.
 */

//reference from coderefer.com

public class splashscreen extends Activity{
@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread time=new Thread()
        {
            public void run()
            {
                try{
                    sleep(2000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally{
                    Intent intent=new Intent(splashscreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        time.start();
    }
    @Override
protected void onPause()
{
    super.onPause();
    finish();
}

}
