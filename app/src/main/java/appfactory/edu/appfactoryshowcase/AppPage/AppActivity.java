package appfactory.edu.appfactoryshowcase.AppPage;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import appfactory.edu.appfactoryshowcase.IdleClass;
import appfactory.edu.appfactoryshowcase.R;


/**
 * Created by elliottcrifasi on 3/9/18.
 */

public class  AppActivity extends AppCompatActivity {
     // Idle time
     private int idleTime = 60000;
     private IdleClass idle;
     //Handle and Runnable
     private Handler handler;
     private Runnable runnable;

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_showcase);
        mRecyclerView = findViewById(R.id.recycler_view);
        // Set hide status bar
        int uiOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOption);
        // Create idle function
        idle = new IdleClass(getApplicationContext(),this,runnable,handler);
        idle.setIdle(idleTime);

        // vertical and cycle layout
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        int[] images = { R.drawable.elliott_min, R.drawable.collin_min,
                R.drawable.derrick_min, R.drawable.mia_min,
                R.drawable.joe_min, R.drawable.jordan_min,
                R.drawable.michael_min, R.drawable.mingxi_min,
                R.drawable.sterling_min, R.drawable.tony_min,
                R.drawable.ying_min, R.drawable.z_min};
        String[] text = {"Elliott", "Collin", "Derrick",
                        "Mia", "Joe","Jordan","Michael",
                        "Mingxi", "Sterling", "Tony",
                        "Sterling", "Tony", "Ying", "Z"};
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new AppAdapter(images, text));
        mRecyclerView.addOnScrollListener(new CenterScrollListener());


    }





    @Override
    protected void onResume(){
        super.onResume();
        idle.resetIdleTimes(idleTime);

    }


    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        // When user touch the screen -> reset idle time
        Log.d("TAG","Touched");
        idle.resetIdleTimes(5000);
    }

   @Override
    protected void onPause(){
        super.onPause();
       idle.removeRunnable();
   }
}
