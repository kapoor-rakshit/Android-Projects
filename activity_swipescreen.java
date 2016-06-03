package rkapoors.swipepractice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by KAPOOR's on 02-06-2016.
 */

//reference from mkyong.com

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageadapter adapter=new pageadapter(this,imagearr);
        ViewPager page=(ViewPager) findViewById(R.id.fivepager);
        page.setAdapter(adapter);
        page.setCurrentItem(0);
    }

    private int imagearr[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5};

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.activity_main,menu);
        return true;
    }
}
