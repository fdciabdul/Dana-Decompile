package com.otaliastudios.cameraview.engine.lock;

import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;

/* loaded from: classes8.dex */
public abstract class BaseLock extends BaseAction {
    protected abstract boolean NetworkUserEntityData$$ExternalSyntheticLambda0(ActionHolder actionHolder);

    protected abstract boolean lookAheadTest(ActionHolder actionHolder);

    protected abstract void moveToNextValue(ActionHolder actionHolder);

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
        super.MyBillsEntityDataFactory(actionHolder);
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(actionHolder);
        if (lookAheadTest(actionHolder) && !NetworkUserEntityData$$ExternalSyntheticLambda0) {
            moveToNextValue(actionHolder);
        } else {
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }
}
