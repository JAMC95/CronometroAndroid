package jsproyectos.cronometro;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*Variables privadas*/
    private int seconds;
    private boolean active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        runTimer();


    }
/*Eventos de boton */
    public void btnStartOnClick(View view){

        active=true;
    }
    public void btnStopOnClick(View view){
        active=false;
    }
    public void btnResetOnClick(View view){

        active=false;
        seconds=0;

    }
    /*Runtime*/
    private void runTimer() {
        final TextView timetxt = (TextView) findViewById(R.id.txtTime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timetxt.setText(time);

                if (active) {
                    seconds++;
                }

                handler.postDelayed(this,1000);

            }

        });



    }
}
