package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;

/* loaded from: classes8.dex */
public abstract class ActionWrapper extends BaseAction {
    public abstract BaseAction BuiltInFictitiousFunctionClassFactory();

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        super.MyBillsEntityDataFactory(actionHolder);
        BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(new ActionCallback() { // from class: com.otaliastudios.cameraview.engine.action.ActionWrapper.1
            @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
            public final void PlaceComponentResult(Action action, int i) {
                ActionWrapper.this.MyBillsEntityDataFactory(i);
                if (i == Integer.MAX_VALUE) {
                    action.KClassImpl$Data$declaredNonStaticMembers$2(this);
                }
            }
        });
        BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(actionHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ActionHolder actionHolder) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
        BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest) {
        super.getAuthRequestContext(actionHolder, captureRequest);
        BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(actionHolder, captureRequest);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void PlaceComponentResult(ActionHolder actionHolder, CaptureRequest captureRequest, CaptureResult captureResult) {
        super.PlaceComponentResult(actionHolder, captureRequest, captureResult);
        BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(actionHolder, captureRequest, captureResult);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
    }
}
