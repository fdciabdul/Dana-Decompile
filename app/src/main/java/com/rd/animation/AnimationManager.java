package com.rd.animation;

import com.rd.animation.controller.AnimationController;
import com.rd.animation.controller.ValueController;
import com.rd.draw.data.Indicator;

/* loaded from: classes3.dex */
public class AnimationManager {
    public AnimationController MyBillsEntityDataFactory;

    public AnimationManager(Indicator indicator, ValueController.UpdateListener updateListener) {
        this.MyBillsEntityDataFactory = new AnimationController(indicator, updateListener);
    }
}
