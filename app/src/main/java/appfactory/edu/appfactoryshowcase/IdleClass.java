package appfactory.edu.appfactoryshowcase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import appfactory.edu.appfactoryshowcase.SlideShow.SlideShowActivity;

/**
 * Created by kyluong09 on 3/11/18.
 */

public class IdleClass {
    Context context;
    Handler handler;
    Runnable runnable;
    Activity activity;

    public IdleClass(Context context, Activity activity,Runnable runnable, Handler handler){
        this.context = context;
        this.activity = activity;
        this.runnable = runnable;
        this.handler = handler;

    }


    public void setIdle(int idleTime){
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //If app is idle in specific amount of time then go back to slideShowActivity
                        context.startActivity(new Intent(context, SlideShowActivity.class));
                    }
                });
            }
        }, idleTime);

    }



    public void resetIdleTimes(int idleTime){
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, idleTime);

    }

    public void removeRunnable(){
        handler.removeCallbacksAndMessages(null);
    }


}
