package ec.edu.uce.dispmoviles.cap2.ejer13_14;

import android.app.Activity;
import android.os.Bundle;

public class DelegateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TouchDelegateLayout layout = new TouchDelegateLayout(this);

        setContentView(layout);
    }
}
