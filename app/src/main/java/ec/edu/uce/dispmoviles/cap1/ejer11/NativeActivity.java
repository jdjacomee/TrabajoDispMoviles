package ec.edu.uce.dispmoviles.cap1.ejer11;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.View;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

@SuppressLint("NewApi")
public class NativeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cap1_ejer11_main);
    }
    
    public void onAddClick(View v) {
        NativeFragment fragment = new NativeFragment();
        
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //Must be called first!
//        ft.setCustomAnimations(R.animator.fragment_enter, R.animator.fragment_exit, R.animator.fragment_pop_enter, R.animator.fragment_pop_exit);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.container_fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
