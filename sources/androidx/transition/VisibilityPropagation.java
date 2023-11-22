package androidx.transition;

import android.view.View;

/* loaded from: classes3.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String[] MyBillsEntityDataFactory = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // androidx.transition.TransitionPropagation
    public final void PlaceComponentResult(TransitionValues transitionValues) {
        View view = transitionValues.MyBillsEntityDataFactory;
        Integer num = (Integer) transitionValues.getAuthRequestContext.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        transitionValues.getAuthRequestContext.put("android:visibilityPropagation:visibility", num);
        view.getLocationOnScreen(r2);
        int round = r2[0] + Math.round(view.getTranslationX());
        int[] iArr = {round};
        iArr[0] = round + (view.getWidth() / 2);
        int round2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = round2;
        iArr[1] = round2 + (view.getHeight() / 2);
        transitionValues.getAuthRequestContext.put("android:visibilityPropagation:center", iArr);
    }

    @Override // androidx.transition.TransitionPropagation
    public final String[] PlaceComponentResult() {
        return MyBillsEntityDataFactory;
    }

    public static int MyBillsEntityDataFactory(TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.getAuthRequestContext.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }
}
