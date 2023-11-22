package com.rd.animation.type;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.WormAnimationValue;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class WormAnimation extends BaseAnimation<AnimatorSet> {
    int BuiltInFictitiousFunctionClassFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    int getAuthRequestContext;
    private WormAnimationValue getErrorConfigVersion;
    int lookAheadTest;
    boolean moveToNextValue;
    int scheduleImpl;

    public WormAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.getErrorConfigVersion = new WormAnimationValue();
    }

    @Override // com.rd.animation.type.BaseAnimation
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public WormAnimation MyBillsEntityDataFactory(long j) {
        super.MyBillsEntityDataFactory(j);
        return this;
    }

    public WormAnimation BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, boolean z) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, z)) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            this.PlaceComponentResult = animatorSet;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.lookAheadTest = i3;
            this.moveToNextValue = z;
            int i4 = i - i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i4;
            this.scheduleImpl = i + i3;
            this.getErrorConfigVersion.MyBillsEntityDataFactory = i4;
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory = this.scheduleImpl;
            RectValues KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(z);
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
            ((AnimatorSet) this.PlaceComponentResult).playSequentially(getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, j, false, this.getErrorConfigVersion), getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, j, true, this.getErrorConfigVersion));
        }
        return this;
    }

    @Override // com.rd.animation.type.BaseAnimation
    /* renamed from: MyBillsEntityDataFactory */
    public WormAnimation getAuthRequestContext(float f) {
        if (this.PlaceComponentResult == 0) {
            return this;
        }
        long j = f * ((float) this.KClassImpl$Data$declaredNonStaticMembers$2);
        Iterator<Animator> it = ((AnimatorSet) this.PlaceComponentResult).getChildAnimations().iterator();
        while (it.hasNext()) {
            ValueAnimator valueAnimator = (ValueAnimator) it.next();
            long duration = valueAnimator.getDuration();
            if (j <= duration) {
                duration = j;
            }
            valueAnimator.setCurrentPlayTime(duration);
            j -= duration;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ValueAnimator getAuthRequestContext(int i, int i2, long j, final boolean z, final WormAnimationValue wormAnimationValue) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.WormAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WormAnimation.getAuthRequestContext(WormAnimation.this, wormAnimationValue, valueAnimator, z);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, boolean z) {
        return (this.getAuthRequestContext == i && this.BuiltInFictitiousFunctionClassFactory == i2 && this.lookAheadTest == i3 && this.moveToNextValue == z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RectValues KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.getAuthRequestContext;
            int i6 = this.lookAheadTest;
            i = i5 + i6;
            int i7 = this.BuiltInFictitiousFunctionClassFactory;
            i2 = i7 + i6;
            i3 = i5 - i6;
            i4 = i7 - i6;
        } else {
            int i8 = this.getAuthRequestContext;
            int i9 = this.lookAheadTest;
            i = i8 - i9;
            int i10 = this.BuiltInFictitiousFunctionClassFactory;
            i2 = i10 - i9;
            i3 = i8 + i9;
            i4 = i10 + i9;
        }
        return new RectValues(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class RectValues {
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final int MyBillsEntityDataFactory;
        final int PlaceComponentResult;
        final int getAuthRequestContext;

        RectValues(int i, int i2, int i3, int i4) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.getAuthRequestContext = i2;
            this.MyBillsEntityDataFactory = i3;
            this.PlaceComponentResult = i4;
        }
    }

    static /* synthetic */ void getAuthRequestContext(WormAnimation wormAnimation, WormAnimationValue wormAnimationValue, ValueAnimator valueAnimator, boolean z) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (wormAnimation.moveToNextValue) {
            if (z) {
                wormAnimationValue.MyBillsEntityDataFactory = intValue;
            }
            wormAnimationValue.BuiltInFictitiousFunctionClassFactory = intValue;
        } else {
            if (!z) {
                wormAnimationValue.MyBillsEntityDataFactory = intValue;
            }
            wormAnimationValue.BuiltInFictitiousFunctionClassFactory = intValue;
        }
        if (wormAnimation.MyBillsEntityDataFactory != null) {
            wormAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(wormAnimationValue);
        }
    }

    @Override // com.rd.animation.type.BaseAnimation
    public final /* synthetic */ AnimatorSet KClassImpl$Data$declaredNonStaticMembers$2() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        return animatorSet;
    }
}
