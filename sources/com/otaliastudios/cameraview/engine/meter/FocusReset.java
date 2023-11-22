package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

/* loaded from: classes8.dex */
public class FocusReset extends BaseReset {
    private static final CameraLogger getAuthRequestContext = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("FocusReset");

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    protected final void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder, MeteringRectangle meteringRectangle) {
        boolean z;
        int intValue = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z2 = true;
        if (meteringRectangle == null || intValue <= 0) {
            z = false;
        } else {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z = true;
        }
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        Integer num = GetContactSyncConfig == null ? null : (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AF_TRIGGER);
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z2 = z;
        } else {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z2) {
            actionHolder.PlaceComponentResult();
        }
        MyBillsEntityDataFactory(Integer.MAX_VALUE);
    }
}
