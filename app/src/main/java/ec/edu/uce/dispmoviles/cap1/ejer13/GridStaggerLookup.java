package ec.edu.uce.dispmoviles.cap1.ejer13;

import android.support.v7.widget.GridLayoutManager;

public class GridStaggerLookup extends GridLayoutManager.SpanSizeLookup {

    @Override
    public int getSpanSize(int position) {
        return (position % 3 == 0 ? 2 : 1);
    }
}
