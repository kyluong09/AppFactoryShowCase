package appfactory.edu.appfactoryshowcase.Main;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import appfactory.edu.appfactoryshowcase.AppPage.AppActivity;
import appfactory.edu.appfactoryshowcase.IdleClass;
import appfactory.edu.appfactoryshowcase.R;

public class MainActivity extends AppCompatActivity {
    private int idleTime = 5000;
    private Handler handler;
    private Runnable runnable;
    private IdleClass idle;

    private Button alumniButton;
    private Button appButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set hide status bar
        int uiOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOption);

//        //Create idle function
         idle = new IdleClass(getApplicationContext(),this,runnable,handler);
         idle.setIdle(idleTime);

        alumniButton = (Button) findViewById(R.id.alumni_button);
        appButton = (Button) findViewById(R.id.app_button);

        alumniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AppActivity.class));
            }
        });

        appButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AppActivity.class));
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
