package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class TimeoutAction extends ActionWrapper {
    private long KClassImpl$Data$declaredNonStaticMembers$2;
    private BaseAction MyBillsEntityDataFactory;
    private long getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeoutAction(long j, BaseAction baseAction) {
        this.getAuthRequestContext = j;
        this.MyBillsEntityDataFactory = baseAction;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    public final BaseAction BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
        super.MyBillsEntityDataFactory(actionHolder);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        if (KClassImpl$Data$declaredNonStaticMembers$2() || System.currentTimeMillis() <= this.KClassImpl$Data$declaredNonStaticMembers$2 + this.getAuthRequestContext) {
            return;
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext(actionHolder);
    }
}
