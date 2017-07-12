package ec.edu.uce.dispmoviles.cap1.ejer2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

public class HideActivity extends ActionBarActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cap1_ejer2_main);

    }
    
    public void onToggleClick(View v) {
        //Here we only need to hide the controls on a tap because
        // the system will make the controls re-appear automatically
        // anytime the screen is tapped after they are hidden.
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
