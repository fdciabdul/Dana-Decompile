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
public class FocusMeter extends BaseMeter {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("FocusMeter");

    public FocusMeter(List<MeteringRectangle> list, boolean z) {
        super(list, z);
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final boolean moveToNextValue(ActionHolder actionHolder) {
        Integer num = (Integer) actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().get(CaptureRequest.CONTROL_AF_MODE);
        boolean z = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkIsSupported:", Boolean.valueOf(z));
        return z;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final boolean lookAheadTest(ActionHolder actionHolder) {
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        if (GetContactSyncConfig != null) {
            Integer num = (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AF_STATE);
            boolean z = num != null && (num.intValue() == 4 || num.intValue() == 2);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final void PlaceComponentResult(ActionHolder actionHolder, List<MeteringRectangle> list) {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStarted:", "with areas:", list);
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int intValue = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && intValue > 0) {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_REGIONS, list.subList(0, Math.min(intValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        actionHolder.PlaceComponentResult();
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder) {
        super.BuiltInFictitiousFunctionClassFactory(actionHolder);
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCaptureCompleted:", "afState:", num);
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == 4) {
            getAuthRequestContext(true);
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        } else if (intValue == 5) {
            getAuthRequestContext(false);
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
