package ec.edu.uce.dispmoviles.cap2.ejer13_14;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

public class PanScrollActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PanScrollView scrollView = new PanScrollView(this);
//        TwoDimensionGestureScrollView scrollView = new TwoDimensionGestureScrollView(this);

//		ImageView iv = new ImageView(this);
//		iv.setImageResource(R.drawable.ic_launcher);
//
//		FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(800, 1500);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        for(int i=0; i < 5; i++) {
    		ImageView iv = new ImageButton(this);
	    	iv.setImageResource(R.drawable.ic_launcher);
            layout.addView(iv, new LinearLayout.LayoutParams(1000, 500));
        }

		scrollView.addView(layout);
		setContentView(scrollView);
	}
}
