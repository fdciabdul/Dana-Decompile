package com.otaliastudios.cameraview.engine.lock;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

/* loaded from: classes8.dex */
public class FocusLock extends BaseLock {
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("FocusLock");

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    protected final boolean lookAheadTest(ActionHolder actionHolder) {
        for (int i : (int[]) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    protected final boolean NetworkUserEntityData$$ExternalSyntheticLambda0(ActionHolder actionHolder) {
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        if (GetContactSyncConfig != null) {
            Integer num = (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AF_STATE);
            boolean z = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
            Integer num2 = (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AF_MODE);
            boolean z2 = z && (num2 != null && num2.intValue() == 1);
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip:", Boolean.valueOf(z2));
            return z2;
        }
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.lock.BaseLock
    protected final void moveToNextValue(ActionHolder actionHolder) {
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_MODE, 1);
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        actionHolder.PlaceComponentResult();
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCapture:", "afState:", num, "afMode:", num2);
        if (num == null || num2 == null || num2.intValue() != 1) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 2 || intValue == 4 || intValue == 5 || intValue == 6) {
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
