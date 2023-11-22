package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes6.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator BuiltInFictitiousFunctionClassFactory = new DecelerateInterpolator();
    private static final TimeInterpolator PlaceComponentResult = new AccelerateInterpolator();
    private int[] MyBillsEntityDataFactory;

    public Explode() {
        this.MyBillsEntityDataFactory = new int[2];
        setPropagation(new CircularPropagation());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = new int[2];
        setPropagation(new CircularPropagation());
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(TransitionValues transitionValues) {
        View view = transitionValues.MyBillsEntityDataFactory;
        view.getLocationOnScreen(this.MyBillsEntityDataFactory);
        int[] iArr = this.MyBillsEntityDataFactory;
        int i = iArr[0];
        int i2 = iArr[1];
        transitionValues.getAuthRequestContext.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        KClassImpl$Data$declaredNonStaticMembers$2(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        KClassImpl$Data$declaredNonStaticMembers$2(transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.getAuthRequestContext.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        MyBillsEntityDataFactory(viewGroup, rect, this.MyBillsEntityDataFactory);
        int[] iArr = this.MyBillsEntityDataFactory;
        return TranslationAnimationCreator.getAuthRequestContext(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, BuiltInFictitiousFunctionClassFactory, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.getAuthRequestContext.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.MyBillsEntityDataFactory.getTag(R.id.scheduleImpl);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        MyBillsEntityDataFactory(viewGroup, rect, this.MyBillsEntityDataFactory);
        int[] iArr2 = this.MyBillsEntityDataFactory;
        return TranslationAnimationCreator.getAuthRequestContext(view, transitionValues, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], PlaceComponentResult, this);
    }

    private void MyBillsEntityDataFactory(View view, Rect rect, int[] iArr) {
        int centerY;
        int i;
        view.getLocationOnScreen(this.MyBillsEntityDataFactory);
        int[] iArr2 = this.MyBillsEntityDataFactory;
        int i2 = iArr2[0];
        int i3 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i = (view.getWidth() / 2) + i2 + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i3 + Math.round(view.getTranslationY());
        } else {
            int centerX = epicenter.centerX();
            centerY = epicenter.centerY();
            i = centerX;
        }
        float centerX2 = rect.centerX() - i;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float sqrt = (float) Math.sqrt((centerX2 * centerX2) + (centerY2 * centerY2));
        int i4 = i - i2;
        int i5 = centerY - i3;
        float max = Math.max(i4, view.getWidth() - i4);
        float max2 = Math.max(i5, view.getHeight() - i5);
        float sqrt2 = (float) Math.sqrt((max * max) + (max2 * max2));
        iArr[0] = Math.round((centerX2 / sqrt) * sqrt2);
        iArr[1] = Math.round(sqrt2 * (centerY2 / sqrt));
    }
}
