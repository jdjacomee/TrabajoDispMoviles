package ec.edu.uce.dispmoviles.cap2.ejer16;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

public class DragTouchActivity extends Activity implements OnLongClickListener {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cap2_ejer16_main);
        //Attach long-press listener to each ImageView
        findViewById(R.id.image1).setOnLongClickListener(this);
        findViewById(R.id.image2).setOnLongClickListener(this);
        findViewById(R.id.image3).setOnLongClickListener(this);
    }

	@Override
	public boolean onLongClick(View v) {
		DragShadowBuilder shadowBuilder = new DragShadowBuilder(v);
//	    DragShadowBuilder shadowBuilder = new DrawableDragShadowBuilder(v,
//	            getResources().getDrawable(R.drawable.ic_launcher));
        //v.startDragAndDrop(null, shadowBuilder, ((ImageView) v).getDrawable(), 0);
	    v.startDrag(null, shadowBuilder, ((ImageView) v).getDrawable(), 0);
		return true;
	}

}