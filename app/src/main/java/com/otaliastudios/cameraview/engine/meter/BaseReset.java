package com.otaliastudios.cameraview.engine.meter;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;

/* loaded from: classes8.dex */
public abstract class BaseReset extends BaseAction {
    private boolean MyBillsEntityDataFactory = true;

    protected abstract void BuiltInFictitiousFunctionClassFactory(ActionHolder actionHolder, MeteringRectangle meteringRectangle);

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        super.MyBillsEntityDataFactory(actionHolder);
        BuiltInFictitiousFunctionClassFactory(actionHolder, this.MyBillsEntityDataFactory ? new MeteringRectangle((Rect) KClassImpl$Data$declaredNonStaticMembers$2(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }
}
