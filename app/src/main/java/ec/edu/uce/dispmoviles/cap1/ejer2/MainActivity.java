package ec.edu.uce.dispmoviles.cap1.ejer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private String[] mActivities = new String[] {
            "Dark Mode", "Hide Navigation", "Fullscreen Mode",
            "Immersive Mode", "Immersive Sticky Mode"};
    private ArrayAdapter<String> mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ListView list = new ListView(this);
        
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mActivities);
        list.setAdapter(mAdapter);
        list.setOnItemClickListener(this);
        setContentView(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        Intent i;
        switch (position) {
            case 0:
                i = new Intent(this, DarkActivity.class);
                break;
            case 1:
                i = new Intent(this, HideActivity.class);
                break;
            case 2:
                i = new Intent(this, FullActivity.class);
                break;
            case 3:
                i = new Intent(this, ImmersiveActivity.class);
                break;
            case 4:
                i = new Intent(this, ImmersiveStickyActivity.class);
                break;
            default:
                return;
        }
        startActivity(i);
    }
}
