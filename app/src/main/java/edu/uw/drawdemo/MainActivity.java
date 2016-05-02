package edu.uw.drawdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";

    private DrawingView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (DrawingView)findViewById(R.id.drawingView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v(TAG, event.toString());
        int action = MotionEventCompat.getActionMasked(event);

        float x = event.getX();
        float y = event.getY() - getSupportActionBar().getHeight();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //ball moves to where I clicked
                //interpolation
                //finds setRadius() in ball
                ObjectAnimator animX = ObjectAnimator.ofFloat(view.ball, "x", x);
                ObjectAnimator animY = ObjectAnimator.ofFloat(view.ball, "y", y);

                AnimatorSet anim = new AnimatorSet();
                anim.playTogether(animX, animY);
                anim.setDuration(1000);
                anim.start();




//                view.ball.cx = x;
//                view.ball.cy = y;
                return true;
            case MotionEvent.ACTION_MOVE:
//                view.ball.cx = x;
//                view.ball.cy = y;
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    /** Menus **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_pulse:
                //redraw
                ObjectAnimator animation = ObjectAnimator.ofFloat(view.ball, "radius", 100.0f, 200.0f);
                animation.setDuration(1000);
                animation.setRepeatCount(ValueAnimator.INFINITE);
                animation.setRepeatMode(ValueAnimator.REVERSE);
                animation.start();

                return true;
            case R.id.menu_button:
                startActivity(new Intent(MainActivity.this, ButtonActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
