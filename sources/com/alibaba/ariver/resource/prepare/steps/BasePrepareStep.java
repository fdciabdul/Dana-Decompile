package com.alibaba.ariver.resource.prepare.steps;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;

/* loaded from: classes6.dex */
abstract class BasePrepareStep implements PrepareStep {
    String LOG_TAG;
    RVAppInfoManager appInfoManager;
    RVResourceManager resourceManager;

    /* renamed from: a  reason: collision with root package name */
    private boolean f6238a = false;
    private boolean b = false;

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        this.appInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        this.resourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (this.appInfoManager == null) {
            throw new PrepareException("0", "ERROR_UNKNOWN with appInfoManager == null");
        }
        if (prepareContext == null) {
            throw new PrepareException("0", "ERROR_UNKNOWN with context == null");
        }
        if (this.f6238a) {
            return;
        }
        this.f6238a = true;
        StringBuilder sb = new StringBuilder();
        sb.append("AriverRes:PrepareStep_");
        sb.append(prepareContext.getAppId());
        sb.append("_");
        sb.append(getType());
        this.LOG_TAG = sb.toString();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void finish() {
        this.b = true;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public boolean isFinished() {
        return this.b;
    }
}
