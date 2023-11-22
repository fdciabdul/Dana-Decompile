package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class Slide extends Visibility {
    private CalculateSlide getErrorConfigVersion;
    private int moveToNextValue;
    private static final TimeInterpolator lookAheadTest = new DecelerateInterpolator();
    private static final TimeInterpolator getAuthRequestContext = new AccelerateInterpolator();
    private static final CalculateSlide MyBillsEntityDataFactory = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.1
        @Override // androidx.transition.Slide.CalculateSlide
        public final float KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final CalculateSlide scheduleImpl = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.2
        @Override // androidx.transition.Slide.CalculateSlide
        public final float KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, View view) {
            if (ViewCompat.initRecordTimeStamp(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final CalculateSlide NetworkUserEntityData$$ExternalSyntheticLambda0 = new CalculateSlideVertical() { // from class: androidx.transition.Slide.3
        @Override // androidx.transition.Slide.CalculateSlide
        public final float getAuthRequestContext(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    };
    private static final CalculateSlide KClassImpl$Data$declaredNonStaticMembers$2 = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.4
        @Override // androidx.transition.Slide.CalculateSlide
        public final float KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final CalculateSlide PlaceComponentResult = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.5
        @Override // androidx.transition.Slide.CalculateSlide
        public final float KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, View view) {
            if (ViewCompat.initRecordTimeStamp(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final CalculateSlide BuiltInFictitiousFunctionClassFactory = new CalculateSlideVertical() { // from class: androidx.transition.Slide.6
        @Override // androidx.transition.Slide.CalculateSlide
        public final float getAuthRequestContext(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface CalculateSlide {
        float KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, View view);

        float getAuthRequestContext(ViewGroup viewGroup, View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GravityFlag {
    }

    /* loaded from: classes3.dex */
    static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        /* synthetic */ CalculateSlideHorizontal(byte b) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public final float getAuthRequestContext(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    /* loaded from: classes3.dex */
    static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        /* synthetic */ CalculateSlideVertical(byte b) {
            this();
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public final float KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
        this.moveToNextValue = 80;
        getAuthRequestContext(80);
    }

    public Slide(byte b) {
        this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
        this.moveToNextValue = 80;
        getAuthRequestContext(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
        this.moveToNextValue = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.lookAheadTest);
        int authRequestContext = TypedArrayUtils.getAuthRequestContext(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        getAuthRequestContext(authRequestContext);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.MyBillsEntityDataFactory.getLocationOnScreen(iArr);
        transitionValues.getAuthRequestContext.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        int[] iArr = new int[2];
        transitionValues.MyBillsEntityDataFactory.getLocationOnScreen(iArr);
        transitionValues.getAuthRequestContext.put("android:slide:screenPosition", iArr);
    }

    private void getAuthRequestContext(int i) {
        if (i == 3) {
            this.getErrorConfigVersion = MyBillsEntityDataFactory;
        } else if (i == 5) {
            this.getErrorConfigVersion = KClassImpl$Data$declaredNonStaticMembers$2;
        } else if (i == 48) {
            this.getErrorConfigVersion = NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else if (i == 80) {
            this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
        } else if (i == 8388611) {
            this.getErrorConfigVersion = scheduleImpl;
        } else if (i == 8388613) {
            this.getErrorConfigVersion = PlaceComponentResult;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.moveToNextValue = i;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.MyBillsEntityDataFactory = i;
        setPropagation(sidePropagation);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.getAuthRequestContext.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return TranslationAnimationCreator.getAuthRequestContext(view, transitionValues2, iArr[0], iArr[1], this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup, view), this.getErrorConfigVersion.getAuthRequestContext(viewGroup, view), translationX, translationY, lookAheadTest, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.getAuthRequestContext.get("android:slide:screenPosition");
        return TranslationAnimationCreator.getAuthRequestContext(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup, view), this.getErrorConfigVersion.getAuthRequestContext(viewGroup, view), getAuthRequestContext, this);
    }
}
