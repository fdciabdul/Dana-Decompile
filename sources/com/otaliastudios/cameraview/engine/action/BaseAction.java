package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class BaseAction implements Action {
    private final List<ActionCallback> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private ActionHolder MyBillsEntityDataFactory;
    private int PlaceComponentResult;

    public void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KClassImpl$Data$declaredNonStaticMembers$2(ActionHolder actionHolder) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void PlaceComponentResult(ActionHolder actionHolder, CaptureRequest captureRequest, CaptureResult captureResult) {
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
    }

    public final int PlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void PlaceComponentResult(ActionHolder actionHolder) {
        this.MyBillsEntityDataFactory = actionHolder;
        actionHolder.PlaceComponentResult(this);
        if (actionHolder.GetContactSyncConfig() != null) {
            MyBillsEntityDataFactory(actionHolder);
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder) {
        actionHolder.getAuthRequestContext(this);
        if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
            KClassImpl$Data$declaredNonStaticMembers$2(actionHolder);
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    public void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        this.MyBillsEntityDataFactory = actionHolder;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            MyBillsEntityDataFactory(actionHolder);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(int i) {
        if (i != this.PlaceComponentResult) {
            this.PlaceComponentResult = i;
            Iterator<ActionCallback> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                it.next().PlaceComponentResult(this, this.PlaceComponentResult);
            }
            if (this.PlaceComponentResult == Integer.MAX_VALUE) {
                this.MyBillsEntityDataFactory.getAuthRequestContext(this);
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult == Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ActionHolder getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.Key<T> key, T t) {
        T t2 = (T) this.MyBillsEntityDataFactory.DatabaseTableConfigUtil().get(key);
        return t2 != null ? t2 : t;
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void PlaceComponentResult(ActionCallback actionCallback) {
        if (this.BuiltInFictitiousFunctionClassFactory.contains(actionCallback)) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.add(actionCallback);
        actionCallback.PlaceComponentResult(this, this.PlaceComponentResult);
    }

    @Override // com.otaliastudios.cameraview.engine.action.Action
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ActionCallback actionCallback) {
        this.BuiltInFictitiousFunctionClassFactory.remove(actionCallback);
    }
}
