package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* loaded from: classes6.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float KClassImpl$Data$declaredNonStaticMembers$2 = 3.0f;

    @Override // androidx.transition.TransitionPropagation
    public final long KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int[] iArr;
        int round;
        int i2;
        int[] iArr2;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        int i3 = -1;
        if (transitionValues2 == null || MyBillsEntityDataFactory(transitionValues) == 0) {
            i = -1;
        } else {
            transitionValues = transitionValues2;
            i = 1;
        }
        int i4 = (transitionValues == null || (iArr = (int[]) transitionValues.getAuthRequestContext.get("android:visibilityPropagation:center")) == null) ? -1 : iArr[0];
        if (transitionValues != null && (iArr2 = (int[]) transitionValues.getAuthRequestContext.get("android:visibilityPropagation:center")) != null) {
            i3 = iArr2[1];
        }
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i2 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int round2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            round = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            i2 = round2;
        }
        float f = i2 - i4;
        float f2 = round - i3;
        float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        float width = viewGroup.getWidth() - 0.0f;
        float height = viewGroup.getHeight() - 0.0f;
        float sqrt2 = sqrt / ((float) Math.sqrt((width * width) + (height * height)));
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i)) / this.KClassImpl$Data$declaredNonStaticMembers$2) * sqrt2);
    }
}
