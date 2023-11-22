package com.otaliastudios.cameraview.engine.meter;

import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;

/* loaded from: classes8.dex */
public class MeterResetAction extends ActionWrapper {
    private final BaseAction KClassImpl$Data$declaredNonStaticMembers$2 = Actions.KClassImpl$Data$declaredNonStaticMembers$2(new ExposureReset(), new FocusReset(), new WhiteBalanceReset());

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    public final BaseAction BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
