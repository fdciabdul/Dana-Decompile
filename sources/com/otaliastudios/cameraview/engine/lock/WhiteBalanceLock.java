package com.otaliastudios.cameraview.engine.lock;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

/* loaded from: classes8.dex */
public class WhiteBalanceLock extends BaseLock {
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("WhiteBalanceLock");

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    protected final boolean lookAheadTest(ActionHolder actionHolder) {
        boolean z = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z2 = z && num != null && num.intValue() == 1;
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    protected final boolean NetworkUserEntityData$$ExternalSyntheticLambda0(ActionHolder actionHolder) {
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        if (GetContactSyncConfig != null) {
            Integer num = (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AWB_STATE);
            boolean z = num != null && num.intValue() == 3;
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    protected final void moveToNextValue(ActionHolder actionHolder) {
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
        actionHolder.PlaceComponentResult();
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "processCapture:", "awbState:", num);
        if (num != null && num.intValue() == 3) {
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
