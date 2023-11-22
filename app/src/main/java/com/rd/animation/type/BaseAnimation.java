package com.rd.animation.type;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.rd.animation.controller.ValueController;

/* loaded from: classes3.dex */
public abstract class BaseAnimation<T extends Animator> {
    protected ValueController.UpdateListener MyBillsEntityDataFactory;
    protected long KClassImpl$Data$declaredNonStaticMembers$2 = 350;
    protected T PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract T KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract BaseAnimation getAuthRequestContext(float f);

    public BaseAnimation(ValueController.UpdateListener updateListener) {
        this.MyBillsEntityDataFactory = updateListener;
    }

    public BaseAnimation MyBillsEntityDataFactory(long j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        T t = this.PlaceComponentResult;
        if (t instanceof ValueAnimator) {
            t.setDuration(j);
        }
        return this;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        T t = this.PlaceComponentResult;
        if (t == null || t.isRunning()) {
            return;
        }
        this.PlaceComponentResult.start();
    }

    public final void MyBillsEntityDataFactory() {
        T t = this.PlaceComponentResult;
        if (t == null || !t.isStarted()) {
            return;
        }
        this.PlaceComponentResult.end();
    }
}
