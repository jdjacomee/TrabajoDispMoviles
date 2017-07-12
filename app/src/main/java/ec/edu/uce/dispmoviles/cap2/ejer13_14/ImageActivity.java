package ec.edu.uce.dispmoviles.cap2.ejer13_14;

import android.app.Activity;
import android.os.Bundle;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RotateZoomImageView imageView = new RotateZoomImageView(this);
        imageView.setImageResource(R.drawable.ic_launcher);
        
        setContentView(imageView);
    }
}
