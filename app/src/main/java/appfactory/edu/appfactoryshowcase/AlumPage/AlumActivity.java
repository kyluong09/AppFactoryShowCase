package appfactory.edu.appfactoryshowcase.AlumPage;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import appfactory.edu.appfactoryshowcase.IdleClass;
import appfactory.edu.appfactoryshowcase.R;
import appfactory.edu.appfactoryshowcase.SlideShow.ViewPagerAdapter;

/**
 * Created by elliottcrifasi on 3/24/18.
 */

public class AlumActivity extends AppCompatActivity {
    // Idle time
    private int idleTime = 60000;
    private IdleClass idle;
    //Handle and Runnable
    private Handler handler;
    private Runnable runnable;

    private RecyclerView mRecyclerView;
    private ViewPager mViewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_showcase);
        // View Pager and Adapter
        int[] image = {R.drawable.logo_milwaukee, R.drawable.logo_milwaukee,R.drawable.logo_milwaukee};
        mViewPager = findViewById(R.id.main_view_pager);
        DynamicViewPagerAdapter viewPagerAdapter = new DynamicViewPagerAdapter(getApplicationContext(), image);
        mViewPager.setAdapter(viewPagerAdapter);

        mRecyclerView = findViewById(R.id.recycler_view);
        // Set hide status bar
        int uiOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOption);
        // Create idle function
        idle = new IdleClass(getApplicationContext(),this,runnable,handler);
        idle.setIdle(idleTime);

        // vertical and cycle layout
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        int[] images = { R.drawable.jeremiah_alum, R.drawable.kyle_alum,
                R.drawable.max_alum};
        String[] text = {"Jeramiah Van Offren", "Kyle Zawacki", "Max Rogers"};
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new AlumAdapter(images, text));
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
