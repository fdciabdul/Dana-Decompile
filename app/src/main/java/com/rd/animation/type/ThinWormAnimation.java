package com.rd.animation.type;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.type.WormAnimation;

/* loaded from: classes3.dex */
public class ThinWormAnimation extends WormAnimation {
    private ThinWormAnimationValue getErrorConfigVersion;

    public ThinWormAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
        this.getErrorConfigVersion = new ThinWormAnimationValue();
    }

    @Override // com.rd.animation.type.WormAnimation
    public final WormAnimation BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, boolean z) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(i, i2, i3, z)) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            this.PlaceComponentResult = animatorSet;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.lookAheadTest = i3;
            this.moveToNextValue = z;
            int i4 = i3 * 2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i - i3;
            this.scheduleImpl = i + i3;
            this.getErrorConfigVersion.MyBillsEntityDataFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory = this.scheduleImpl;
            this.getErrorConfigVersion.getAuthRequestContext = i4;
            WormAnimation.RectValues KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(z);
            double d = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Double.isNaN(d);
            long j = (long) (d * 0.8d);
            double d2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Double.isNaN(d2);
            long j2 = (long) (d2 * 0.2d);
            double d3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Double.isNaN(d3);
            long j3 = (long) (d3 * 0.5d);
            double d4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Double.isNaN(d4);
            long j4 = (long) (d4 * 0.5d);
            ValueAnimator authRequestContext = getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, j, false, this.getErrorConfigVersion);
            ValueAnimator authRequestContext2 = getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, j, true, this.getErrorConfigVersion);
            authRequestContext2.setStartDelay(j2);
            ValueAnimator authRequestContext3 = getAuthRequestContext(i4, i3, j3);
            ValueAnimator authRequestContext4 = getAuthRequestContext(i3, i4, j3);
            authRequestContext4.setStartDelay(j4);
            ((AnimatorSet) this.PlaceComponentResult).playTogether(authRequestContext, authRequestContext2, authRequestContext3, authRequestContext4);
        }
        return this;
    }

    private ValueAnimator getAuthRequestContext(int i, int i2, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rd.animation.type.ThinWormAnimation.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ThinWormAnimation.getAuthRequestContext(ThinWormAnimation.this, valueAnimator);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.rd.animation.type.WormAnimation, com.rd.animation.type.BaseAnimation
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ThinWormAnimation getAuthRequestContext(float f) {
        if (this.PlaceComponentResult != 0) {
            long j = f * ((float) this.KClassImpl$Data$declaredNonStaticMembers$2);
            int size = ((AnimatorSet) this.PlaceComponentResult).getChildAnimations().size();
            for (int i = 0; i < size; i++) {
                ValueAnimator valueAnimator = (ValueAnimator) ((AnimatorSet) this.PlaceComponentResult).getChildAnimations().get(i);
                long startDelay = j - valueAnimator.getStartDelay();
                long duration = valueAnimator.getDuration();
                if (startDelay > duration) {
                    startDelay = duration;
                } else if (startDelay < 0) {
                    startDelay = 0;
                }
                if ((i != size - 1 || startDelay > 0) && valueAnimator.getValues() != null && valueAnimator.getValues().length > 0) {
                    valueAnimator.setCurrentPlayTime(startDelay);
                }
            }
        }
        return this;
    }

    static /* synthetic */ void getAuthRequestContext(ThinWormAnimation thinWormAnimation, ValueAnimator valueAnimator) {
        thinWormAnimation.getErrorConfigVersion.getAuthRequestContext = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (thinWormAnimation.MyBillsEntityDataFactory != null) {
            thinWormAnimation.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(thinWormAnimation.getErrorConfigVersion);
        }
    }

    @Override // com.rd.animation.type.WormAnimation, com.rd.animation.type.BaseAnimation
    public final /* synthetic */ BaseAnimation MyBillsEntityDataFactory(long j) {
        super.MyBillsEntityDataFactory(j);
        return this;
    }

    @Override // com.rd.animation.type.WormAnimation
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final /* bridge */ /* synthetic */ WormAnimation MyBillsEntityDataFactory(long j) {
        super.MyBillsEntityDataFactory(j);
        return this;
    }
}
