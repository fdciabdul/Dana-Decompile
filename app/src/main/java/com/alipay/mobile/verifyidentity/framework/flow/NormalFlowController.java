package com.alipay.mobile.verifyidentity.framework.flow;

import com.alipay.mobile.verifyidentity.framework.module.VIModule;

/* loaded from: classes3.dex */
public class NormalFlowController implements IFlowController {
    private VIModule.Callback callback;
    private VIModule module;

    public NormalFlowController(VIModule vIModule, VIModule.Callback callback) {
        this.module = vIModule;
        this.callback = callback;
    }

    @Override // com.alipay.mobile.verifyidentity.framework.flow.IFlowController
    public void start() {
        VIModule vIModule = this.module;
        if (vIModule != null) {
            vIModule.start(this.callback);
        }
    }
}
