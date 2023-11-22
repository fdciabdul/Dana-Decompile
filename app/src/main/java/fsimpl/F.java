package fsimpl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public class F extends EdgeEffect {
    public F(Context context) {
        super(context);
    }

    public F(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas canvas) {
        if (canvas instanceof C0223aa) {
            return false;
        }
        return super.draw(canvas);
    }
}
