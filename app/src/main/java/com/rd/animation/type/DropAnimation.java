package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.DropAnimationValue;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DropAnimation extends BaseAnimation<AnimatorSet> {
    private int BuiltInFictitiousFunctionClassFactory;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private int lookAheadTest;
    private DropAnimationValue moveToNextValue;
    private int scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum AnimationType {
        Width,
        Height,
        Radius
    }

    public DropAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.moveToNextValue = new DropAnimationValue();
    }

    public final DropAnimation getAuthRequestContext(long j) {
        super.MyBillsEntityDataFactory(j);
        return this;
    }

    public final DropAnimation KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, int i4, int i5) {
        if (BuiltInFictitiousFunctionClassFactory(i, i2, i3, i4, i5)) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            this.PlaceComponentResult = animatorSet;
            this.getErrorConfigVersion = i;
            this.lookAheadTest = i2;
            this.getAuthRequestContext = i3;
            this.BuiltInFictitiousFunctionClassFactory = i4;
            this.scheduleImpl = i5;
            double d = i5;
            Double.isNaN(d);
            int i6 = (int) (d / 1.5d);
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
            ValueAnimator PlaceComponentResult = PlaceComponentResult(i, i2, this.KClassImpl$Data$declaredNonStaticMembers$2, AnimationType.Width);
            ValueAnimator PlaceComponentResult2 = PlaceComponentResult(i3, i4, j, AnimationType.Height);
            ValueAnimator PlaceComponentResult3 = PlaceComponentResult(i5, i6, j, AnimationType.Radius);
            ((AnimatorSet) this.PlaceComponentResult).play(PlaceComponentResult2).with(PlaceComponentResult3).with(PlaceComponentResult).before(PlaceComponentResult(i4, i3, j, AnimationType.Height)).before(PlaceComponentResult(i6, i5, j, AnimationType.Radius));
        }
        return this;
    }

    private ValueAnimator PlaceComponentResult(int i, int i2, long j, final AnimationType animationType) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.DropAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropAnimation.PlaceComponentResult(DropAnimation.this, valueAnimator, animationType);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rd.animation.type.DropAnimation$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[AnimationType.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[AnimationType.Width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[AnimationType.Height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[AnimationType.Radius.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4, int i5) {
        return (this.getErrorConfigVersion == i && this.lookAheadTest == i2 && this.getAuthRequestContext == i3 && this.BuiltInFictitiousFunctionClassFactory == i4 && this.scheduleImpl == i5) ? false : true;
    }

    static /* synthetic */ void PlaceComponentResult(DropAnimation dropAnimation, ValueAnimator valueAnimator, AnimationType animationType) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int i = AnonymousClass2.BuiltInFictitiousFunctionClassFactory[animationType.ordinal()];
        if (i == 1) {
            dropAnimation.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 = intValue;
        } else if (i == 2) {
            dropAnimation.moveToNextValue.getAuthRequestContext = intValue;
        } else if (i == 3) {
            dropAnimation.moveToNextValue.MyBillsEntityDataFactory = intValue;
        }
        if (dropAnimation.MyBillsEntityDataFactory != null) {
            dropAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(dropAnimation.moveToNextValue);
        }
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* synthetic */ AnimatorSet KClassImpl$Data$declaredNonStaticMembers$2() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* bridge */ /* synthetic */ BaseAnimation MyBillsEntityDataFactory(long j) {
        super.MyBillsEntityDataFactory(j);
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* synthetic */ BaseAnimation getAuthRequestContext(float f) {
        if (this.PlaceComponentResult != 0) {
            long j = f * ((float) this.KClassImpl$Data$declaredNonStaticMembers$2);
            boolean z = false;
            Iterator<Animator> it = ((AnimatorSet) this.PlaceComponentResult).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                long duration = valueAnimator.getDuration();
                long j2 = z ? j - duration : j;
                if (j2 >= 0) {
                    if (j2 >= duration) {
                        j2 = duration;
                    }
                    if (valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                        valueAnimator.setCurrentPlayTime(j2);
                    }
                    if (!z && duration >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        z = true;
                    }
                }
            }
        }
        return this;
    }
}
