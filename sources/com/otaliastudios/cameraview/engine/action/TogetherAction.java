package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class TogetherAction extends BaseAction {
    private final List<BaseAction> MyBillsEntityDataFactory;
    private final List<BaseAction> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TogetherAction(List<BaseAction> list) {
        this.MyBillsEntityDataFactory = new ArrayList(list);
        this.getAuthRequestContext = new ArrayList(list);
        Iterator<BaseAction> it = list.iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult(new ActionCallback() { // from class: com.otaliastudios.cameraview.engine.action.TogetherAction.1
                @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
                public final void PlaceComponentResult(Action action, int i) {
                    if (i == Integer.MAX_VALUE) {
                        TogetherAction.this.getAuthRequestContext.remove(action);
                    }
                    if (TogetherAction.this.getAuthRequestContext.isEmpty()) {
                        TogetherAction.this.MyBillsEntityDataFactory(Integer.MAX_VALUE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        super.MyBillsEntityDataFactory(actionHolder);
        for (BaseAction baseAction : this.MyBillsEntityDataFactory) {
            if (!baseAction.KClassImpl$Data$declaredNonStaticMembers$2()) {
                baseAction.MyBillsEntityDataFactory(actionHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ActionHolder actionHolder) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
        for (BaseAction baseAction : this.MyBillsEntityDataFactory) {
            if (!baseAction.KClassImpl$Data$declaredNonStaticMembers$2()) {
                baseAction.KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest) {
        super.getAuthRequestContext(actionHolder, captureRequest);
        for (BaseAction baseAction : this.MyBillsEntityDataFactory) {
            if (!baseAction.KClassImpl$Data$declaredNonStaticMembers$2()) {
                baseAction.getAuthRequestContext(actionHolder, captureRequest);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void PlaceComponentResult(ActionHolder actionHolder, CaptureRequest captureRequest, CaptureResult captureResult) {
        super.PlaceComponentResult(actionHolder, captureRequest, captureResult);
        for (BaseAction baseAction : this.MyBillsEntityDataFactory) {
            if (!baseAction.KClassImpl$Data$declaredNonStaticMembers$2()) {
                baseAction.PlaceComponentResult(actionHolder, captureRequest, captureResult);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        for (BaseAction baseAction : this.MyBillsEntityDataFactory) {
            if (!baseAction.KClassImpl$Data$declaredNonStaticMembers$2()) {
                baseAction.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
            }
        }
    }
}
