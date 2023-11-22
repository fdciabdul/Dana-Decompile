package com.rd;

import com.rd.animation.AnimationManager;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.Value;
import com.rd.draw.DrawManager;
import com.rd.draw.data.Indicator;

/* loaded from: classes3.dex */
public class IndicatorManager implements ValueController.UpdateListener {
    AnimationManager BuiltInFictitiousFunctionClassFactory;
    DrawManager KClassImpl$Data$declaredNonStaticMembers$2;
    Listener getAuthRequestContext;

    /* loaded from: classes3.dex */
    interface Listener {
        void onIndicatorUpdated();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IndicatorManager(Listener listener) {
        this.getAuthRequestContext = listener;
        DrawManager drawManager = new DrawManager();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = drawManager;
        if (drawManager.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            drawManager.KClassImpl$Data$declaredNonStaticMembers$2 = new Indicator();
        }
        this.BuiltInFictitiousFunctionClassFactory = new AnimationManager(drawManager.KClassImpl$Data$declaredNonStaticMembers$2, this);
    }

    @Override // com.rd.animation.controller.ValueController.UpdateListener
    public final void BuiltInFictitiousFunctionClassFactory(Value value) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = value;
        Listener listener = this.getAuthRequestContext;
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
    }
}
