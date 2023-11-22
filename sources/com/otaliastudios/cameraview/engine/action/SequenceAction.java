package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import java.util.List;

/* loaded from: classes8.dex */
class SequenceAction extends BaseAction {
    private final List<BaseAction> BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequenceAction(List<BaseAction> list) {
        this.BuiltInFictitiousFunctionClassFactory = list;
        MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        boolean z = i == -1;
        if (i == this.BuiltInFictitiousFunctionClassFactory.size() - 1) {
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        this.BuiltInFictitiousFunctionClassFactory.get(i2).PlaceComponentResult(new ActionCallback() { // from class: com.otaliastudios.cameraview.engine.action.SequenceAction.1
            @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
            public final void PlaceComponentResult(Action action, int i3) {
                if (i3 == Integer.MAX_VALUE) {
                    action.KClassImpl$Data$declaredNonStaticMembers$2(this);
                    SequenceAction.this.MyBillsEntityDataFactory();
                }
            }
        });
        if (z) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.get(this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(getAuthRequestContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        super.MyBillsEntityDataFactory(actionHolder);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i >= 0) {
            this.BuiltInFictitiousFunctionClassFactory.get(i).MyBillsEntityDataFactory(actionHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ActionHolder actionHolder) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i >= 0) {
            this.BuiltInFictitiousFunctionClassFactory.get(i).KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest) {
        super.getAuthRequestContext(actionHolder, captureRequest);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i >= 0) {
            this.BuiltInFictitiousFunctionClassFactory.get(i).getAuthRequestContext(actionHolder, captureRequest);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void PlaceComponentResult(ActionHolder actionHolder, CaptureRequest captureRequest, CaptureResult captureResult) {
        super.PlaceComponentResult(actionHolder, captureRequest, captureResult);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i >= 0) {
            this.BuiltInFictitiousFunctionClassFactory.get(i).PlaceComponentResult(actionHolder, captureRequest, captureResult);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i >= 0) {
            this.BuiltInFictitiousFunctionClassFactory.get(i).getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        }
    }
}
