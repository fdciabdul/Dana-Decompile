package com.alibaba.griver.v8;

import android.content.Context;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ProcessLock;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.LogData;

/* loaded from: classes6.dex */
public class AriverJSEngineDelegate extends Delegate {
    @Override // com.alipay.mobile.jsengine.Delegate
    public String getWebViewCoreSoPath() {
        return "";
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public void log(LogData logData) {
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public void unzipWebViewCoreSo() {
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public Context getContext() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public String getConfig(String str, String str2) {
        return ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig(str, str2);
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public Object takeProcessLock(String str) {
        return Boolean.valueOf(new ProcessLock(str).tryLock());
    }

    @Override // com.alipay.mobile.jsengine.Delegate
    public void releaseProcessLock(Object obj) {
        if (obj instanceof ProcessLock) {
            ((ProcessLock) obj).unlock();
        }
    }
}
