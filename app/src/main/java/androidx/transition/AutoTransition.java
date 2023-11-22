package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult(1);
        getAuthRequestContext(new Fade(2)).getAuthRequestContext(new ChangeBounds()).getAuthRequestContext(new Fade(1));
    }
}
