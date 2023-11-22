package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes6.dex */
public final /* synthetic */ class DragStartHelper$$ExternalSyntheticLambda1 implements View.OnTouchListener {
    public final /* synthetic */ DragStartHelper PlaceComponentResult;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.PlaceComponentResult.getAuthRequestContext(motionEvent);
    }
}
