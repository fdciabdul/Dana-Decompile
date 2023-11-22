package com.otaliastudios.cameraview.engine.meter;

import android.hardware.camera2.params.MeteringRectangle;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class BaseMeter extends BaseAction {
    private static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("BaseMeter");
    private final List<MeteringRectangle> MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private boolean getAuthRequestContext;

    protected abstract void PlaceComponentResult(ActionHolder actionHolder, List<MeteringRectangle> list);

    protected abstract boolean lookAheadTest(ActionHolder actionHolder);

    protected abstract boolean moveToNextValue(ActionHolder actionHolder);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMeter(List<MeteringRectangle> list, boolean z) {
        this.MyBillsEntityDataFactory = list;
        this.PlaceComponentResult = z;
    }

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        super.MyBillsEntityDataFactory(actionHolder);
        boolean z = this.PlaceComponentResult && lookAheadTest(actionHolder);
        if (moveToNextValue(actionHolder) && !z) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStart:", "supported and not skipped. Dispatching onStarted.");
            PlaceComponentResult(actionHolder, this.MyBillsEntityDataFactory);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStart:", "not supported or skipped. Dispatching COMPLETED state.");
        this.getAuthRequestContext = true;
        MyBillsEntityDataFactory(Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(boolean z) {
        this.getAuthRequestContext = z;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}
