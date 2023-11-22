package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;

/* loaded from: classes8.dex */
public class WhiteBalanceReset extends BaseReset {
    private static final CameraLogger BuiltInFictitiousFunctionClassFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("WhiteBalanceReset");

    @Override // com.otaliastudios.cameraview.engine.meter.BaseReset
    protected final void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder, MeteringRectangle meteringRectangle) {
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(2, "onStarted:", "with area:", meteringRectangle);
        int intValue = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && intValue > 0) {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            actionHolder.PlaceComponentResult();
        }
        MyBillsEntityDataFactory(Integer.MAX_VALUE);
    }
}
