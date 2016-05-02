package edu.uw.drawdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity {

    private static final String TAG = "Button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Clicked!");

                button.animate().scaleX(10).scaleY(10).x(400).y(500).alpha(0);

//                ObjectAnimator animX = ObjectAnimator.ofFloat(button, "scaleX", 10);
//                ObjectAnimator animY = ObjectAnimator.ofFloat(button, "scaleY", 10);
//
//                AnimatorSet anim = new AnimatorSet();
//                anim.playTogether(animX, animY);
//                anim.setDuration(1000);
//                anim.start();

            }
        });
    }
}
