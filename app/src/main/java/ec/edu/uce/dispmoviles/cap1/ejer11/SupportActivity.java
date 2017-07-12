package ec.edu.uce.dispmoviles.cap1.ejer11;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

public class SupportActivity extends ActionBarActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cap1_ejer11_main);
    }
    
    public void onAddClick(View v) {
        SupportFragment fragment = new SupportFragment();
        
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //Must be called first!
//        ft.setCustomAnimations(R.anim.activity_open_enter, R.anim.activity_open_exit, R.anim.activity_close_enter, R.anim.activity_close_exit);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.container_fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
