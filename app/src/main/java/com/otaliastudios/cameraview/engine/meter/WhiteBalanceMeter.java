package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import java.util.List;

/* loaded from: classes8.dex */
public class WhiteBalanceMeter extends BaseMeter {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("WhiteBalanceMeter");

    public WhiteBalanceMeter(List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final boolean moveToNextValue(ActionHolder actionHolder) {
        boolean z = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z2 = z && num != null && num.intValue() == 1;
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final boolean lookAheadTest(ActionHolder actionHolder) {
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        if (GetContactSyncConfig != null) {
            Integer num = (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AWB_STATE);
            boolean z = num != null && num.intValue() == 2;
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final void PlaceComponentResult(ActionHolder actionHolder, List<MeteringRectangle> list) {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStarted:", "with areas:", list);
        int intValue = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (list.isEmpty() || intValue <= 0) {
            return;
        }
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AWB_REGIONS, list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
        actionHolder.PlaceComponentResult();
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCaptureCompleted:", "awbState:", num);
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 2) {
            getAuthRequestContext(true);
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        } else if (intValue == 3) {
            getAuthRequestContext(false);
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
