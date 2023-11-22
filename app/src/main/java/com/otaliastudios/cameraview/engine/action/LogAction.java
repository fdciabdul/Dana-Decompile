package com.otaliastudios.cameraview.engine.action;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.otaliastudios.cameraview.CameraLogger;

/* loaded from: classes8.dex */
public class LogAction extends BaseAction {
    private static final CameraLogger BuiltInFictitiousFunctionClassFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("CameraEngine");
    private String getAuthRequestContext;

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num3 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Boolean bool = (Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK);
        Integer num4 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        Integer num5 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        StringBuilder sb = new StringBuilder();
        sb.append("aeMode: ");
        sb.append(num);
        sb.append(" aeLock: ");
        sb.append(bool);
        sb.append(" aeState: ");
        sb.append(num2);
        sb.append(" aeTriggerState: ");
        sb.append(num4);
        sb.append(" afState: ");
        sb.append(num3);
        sb.append(" afTriggerState: ");
        sb.append(num5);
        String obj = sb.toString();
        if (obj.equals(this.getAuthRequestContext)) {
            return;
        }
        this.getAuthRequestContext = obj;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(0, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder) {
        super.BuiltInFictitiousFunctionClassFactory(actionHolder);
        MyBillsEntityDataFactory(0);
        PlaceComponentResult(actionHolder);
    }
}
