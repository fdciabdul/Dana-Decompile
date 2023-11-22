package androidx.legacy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.fullstory.instrumentation.FSDraw;

@Deprecated
/* loaded from: classes3.dex */
public class Space extends View implements FSDraw {
    @Override // android.view.View
    @Deprecated
    public void draw(Canvas canvas) {
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    @Deprecated
    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Space(Context context) {
        this(context, null);
    }

    private static int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode == 1073741824 ? size : i;
        }
        return Math.min(i, size);
    }

    @Override // android.view.View
    @Deprecated
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(BuiltInFictitiousFunctionClassFactory(getSuggestedMinimumWidth(), i), BuiltInFictitiousFunctionClassFactory(getSuggestedMinimumHeight(), i2));
    }
}
