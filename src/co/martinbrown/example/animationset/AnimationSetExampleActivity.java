package co.martinbrown.example.animationset;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class AnimationSetExampleActivity extends Activity {

    Button theButton;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv = (TextView) findViewById(R.id.textView1);
        theButton = (Button) findViewById(R.id.button1);

        tv.setText("Some Text");

        theButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AnimationSet animSet = new AnimationSet(true);

                TranslateAnimation mover = new TranslateAnimation(0, 0, 0, 300);
                AlphaAnimation fader = new AlphaAnimation(1.0f, 0.0f);

                animSet.addAnimation(mover);
                animSet.addAnimation(fader);
                animSet.setDuration(4000);
                animSet.setInterpolator(new CycleInterpolator(2.0f));

                tv.startAnimation(animSet);
            }
        });
    }
}