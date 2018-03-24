package appfactory.edu.appfactoryshowcase.Main;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import appfactory.edu.appfactoryshowcase.AlumPage.AlumActivity;
import appfactory.edu.appfactoryshowcase.AppPage.AppActivity;
import appfactory.edu.appfactoryshowcase.AppPage.AppAdapter;
import appfactory.edu.appfactoryshowcase.IdleClass;
import appfactory.edu.appfactoryshowcase.R;

public class MainActivity extends AppCompatActivity {
    private int idleTime = 60000;
    private Handler handler;
    private Runnable runnable;
    private IdleClass idle;
    private RecyclerView mRecyclerView;

    private Button alumniButton;
    private Button appButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.emp_recycler_view);
        // Set hide status bar
        int uiOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOption);

         //Create idle function
         idle = new IdleClass(getApplicationContext(),this,runnable,handler);
         idle.setIdle(idleTime);


         //set up recycler view
        // vertical and cycle layout
        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());

        int[] images = { R.drawable.elliott_min, R.drawable.collin_min,
                R.drawable.derrick_min, R.drawable.mia_min,
                R.drawable.joe_min, R.drawable.jordan_min,
                R.drawable.michael_min, R.drawable.mingxi_min,
                R.drawable.sterling_min, R.drawable.tony_min,
                R.drawable.ying_min, R.drawable.z_min};
        String[] text = {"Elliott - Dev", "Collin - Dev", "Derrick - Dev",
                "Mia - Dev", "Joe - Dev","Jordan -Dev","Michael - Dev",
                "Mingxi - Dev", "Sterling - Dev", "Tony - Dev", "Ying - Dev", "Z - Dev"};
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new AppAdapter(images, text));
        mRecyclerView.addOnScrollListener(new CenterScrollListener());

        alumniButton = (Button) findViewById(R.id.alumni_button);
        appButton = (Button) findViewById(R.id.app_button);

        alumniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AlumActivity.class));
            }
        });

        appButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AppActivity.class));
            }
        });

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("TAG","Paused");
        idle.removeRunnable();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        idle.resetIdleTimes(idleTime);
    }

    @Override
    protected void onResume(){
        super.onResume();
        idle.resetIdleTimes(idleTime);
    }
}
