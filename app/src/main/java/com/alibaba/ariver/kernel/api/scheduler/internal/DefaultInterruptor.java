package com.alibaba.ariver.kernel.api.scheduler.internal;

import com.alibaba.ariver.kernel.api.scheduler.Interruptor;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class DefaultInterruptor implements Interruptor {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6104a = false;

    @Override // com.alibaba.ariver.kernel.api.scheduler.Interruptor
    public void interrupt() {
        StringBuilder sb = new StringBuilder();
        sb.append("interrupt on ");
        sb.append(this);
        RVLogger.d("AriverKernel:ExtensionInvoker:Interruptor", sb.toString());
        this.f6104a = true;
    }

    public boolean isInterrupted() {
        return this.f6104a;
    }

    public void setInterrupted(boolean z) {
        this.f6104a = z;
    }
}
