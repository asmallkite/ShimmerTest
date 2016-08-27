package com.lizheng.www.shimmertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {
    private ShimmerTextView shimmerTextView;
    private ShimmerButton shimmerButton;
    private Shimmer shimmer;
    private Shimmer shimmer_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shimmerTextView = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        shimmerButton = (ShimmerButton)findViewById(R.id.shimmer_btn);

        setShimmerText();
        setShimmerBtn();


    }
   private void setShimmerText() {
       shimmer = new Shimmer();
       shimmer.setRepeatCount(5);//闪烁的次数，0-一次  1-两次    2-三次    以此类推
       shimmer.setDuration(1000);//每次闪烁的时间长短
       shimmer.setStartDelay(2000);//开始闪烁前间隔的时间
       shimmer.setDirection(Shimmer.ANIMATION_DIRECTION_RTL);//闪烁的方向,接受int值，Shimmer.ANIMATION_DIRECTION_RTL=1，表示right turn left        Shimmer.ANIMATION_DIRECTION_LTR=0,left turn right
       shimmer.start(shimmerTextView);
   }

    private void setShimmerBtn() {
        shimmer_btn = new Shimmer();

        shimmer_btn.setRepeatCount(10).
                setDuration(1500).
                setStartDelay(1000).
                setDirection(Shimmer.ANIMATION_DIRECTION_RTL);

        shimmer_btn.start(shimmerButton);
    }

    public void toggleAnimation (View target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        }else {
           setShimmerText();
        }

        if (shimmer_btn != null && shimmer_btn.isAnimating()) {
            shimmer_btn.cancel();
        } else {
            setShimmerBtn();
        }



    }
}
