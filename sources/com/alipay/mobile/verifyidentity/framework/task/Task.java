package com.alipay.mobile.verifyidentity.framework.task;

import com.alipay.mobile.verifyidentity.framework.flow.IFlowController;

/* loaded from: classes3.dex */
public class Task implements Runnable {
    private IFlowController flowController;

    public Task(IFlowController iFlowController) {
        this.flowController = iFlowController;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.flowController.start();
    }
}
