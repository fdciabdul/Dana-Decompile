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
public class ExposureMeter extends BaseMeter {
    private static final CameraLogger PlaceComponentResult = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("ExposureMeter");
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean getAuthRequestContext;

    public ExposureMeter(List<MeteringRectangle> list, boolean z) {
        super(list, z);
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final boolean moveToNextValue(ActionHolder actionHolder) {
        boolean z = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().get(CaptureRequest.CONTROL_AE_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.BuiltInFictitiousFunctionClassFactory = !z;
        boolean z3 = ((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.getAuthRequestContext = z3;
        boolean z4 = z2 && (this.BuiltInFictitiousFunctionClassFactory || z3);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkIsSupported:", Boolean.valueOf(z4), "trigger:", Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory), "areas:", Boolean.valueOf(this.getAuthRequestContext));
        return z4;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final boolean lookAheadTest(ActionHolder actionHolder) {
        TotalCaptureResult GetContactSyncConfig = actionHolder.GetContactSyncConfig();
        if (GetContactSyncConfig != null) {
            Integer num = (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AE_STATE);
            boolean z = num != null && num.intValue() == 2;
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip:", Boolean.valueOf(z));
            return z;
        }
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "checkShouldSkip: false - lastResult is null.");
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.meter.BaseMeter
    protected final void PlaceComponentResult(ActionHolder actionHolder, List<MeteringRectangle> list) {
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStarted:", "with areas:", list);
        if (this.getAuthRequestContext && !list.isEmpty()) {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_REGIONS, list.subList(0, Math.min(((Integer) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        actionHolder.PlaceComponentResult();
        if (this.BuiltInFictitiousFunctionClassFactory) {
            MyBillsEntityDataFactory(0);
        } else {
            MyBillsEntityDataFactory(1);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder) {
        super.BuiltInFictitiousFunctionClassFactory(actionHolder);
        actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num == null) {
            return;
        }
        if (PlaceComponentResult() == 0) {
            int intValue = num.intValue();
            if (intValue != 2) {
                if (intValue == 3) {
                    getAuthRequestContext(false);
                    MyBillsEntityDataFactory(Integer.MAX_VALUE);
                } else if (intValue != 4) {
                    if (intValue == 5) {
                        MyBillsEntityDataFactory(1);
                    }
                }
            }
            if (num2 != null && num2.intValue() == 1) {
                getAuthRequestContext(true);
                MyBillsEntityDataFactory(Integer.MAX_VALUE);
            }
        }
        if (PlaceComponentResult() == 1) {
            int intValue2 = num.intValue();
            if (intValue2 != 2) {
                if (intValue2 == 3) {
                    getAuthRequestContext(false);
                    MyBillsEntityDataFactory(Integer.MAX_VALUE);
                    return;
                } else if (intValue2 != 4) {
                    return;
                }
            }
            getAuthRequestContext(true);
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
