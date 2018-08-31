package ir.mohsenafshar.android.myfirstproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        heightSpec = MeasureSpec.makeMeasureSpec((int) pxFromDp(240f), MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }

    private float pxFromDp(float dp)
    {
        return dp * this.getContext().getResources().getDisplayMetrics().density;
    }
}
