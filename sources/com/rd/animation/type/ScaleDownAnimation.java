package com.rd.animation.type;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import com.rd.animation.controller.ValueController;

/* loaded from: classes3.dex */
public class ScaleDownAnimation extends ScaleAnimation {
    public ScaleDownAnimation(ValueController.UpdateListener updateListener) {
        super(updateListener);
    }

    @Override // com.rd.animation.type.ScaleAnimation
    protected final PropertyValuesHolder getAuthRequestContext(boolean z) {
        int i;
        int i2;
        String str;
        if (z) {
            i = (int) (this.getErrorConfigVersion * this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            i2 = this.getErrorConfigVersion;
            str = "ANIMATION_SCALE_REVERSE";
        } else {
            i = this.getErrorConfigVersion;
            i2 = (int) (this.getErrorConfigVersion * this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            str = "ANIMATION_SCALE";
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(str, i, i2);
        ofInt.setEvaluator(new IntEvaluator());
        return ofInt;
    }
}
