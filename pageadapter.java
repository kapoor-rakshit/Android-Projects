package rkapoors.swipepractice;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * Created by KAPOOR's on 02-06-2016.
 */

public class pageadapter extends PagerAdapter {
    Activity activity;
    int imagearr[];
    public pageadapter (Activity act,int img[])
    {
        imagearr=img;
        activity=act;
    }

    public int getCount()
    {
        return imagearr.length;
    }

    public Object instantiateItem(View collection,int pos)
    {
        ImageView view=new ImageView(activity);
        view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        view.setScaleType(ScaleType.FIT_XY);
        view.setBackgroundResource(imagearr[pos]);
        ((ViewPager) collection).addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(View a0,int a1,Object a2)
    {
        ((ViewPager) a0).removeView((View) a2);
    }

@Override
    public boolean isViewFromObject(View a0,Object a1)
    {
        return a0==((View) a1);
    }

@Override
    public Parcelable saveState()
    {
        return null;
    }
}
