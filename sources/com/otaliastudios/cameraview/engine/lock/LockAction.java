package com.otaliastudios.cameraview.engine.lock;

import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;

/* loaded from: classes8.dex */
public class LockAction extends ActionWrapper {
    private final BaseAction getAuthRequestContext = Actions.KClassImpl$Data$declaredNonStaticMembers$2(new ExposureLock(), new FocusLock(), new WhiteBalanceLock());

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    public final BaseAction BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}
