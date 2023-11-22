package com.alibaba.ariver.resource.api;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;

/* loaded from: classes6.dex */
public class DownloadInstallCallback implements PackageDownloadCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6197a;
    private boolean b;
    private PackageInstallCallback c;
    private AppModel d;

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onPrepare(String str) {
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onProgress(String str, int i) {
    }

    public DownloadInstallCallback(AppModel appModel) {
        this(appModel, false, false, null);
    }

    public DownloadInstallCallback(AppModel appModel, boolean z, boolean z2, PackageInstallCallback packageInstallCallback) {
        this.d = appModel;
        this.f6197a = z;
        this.b = z2;
        this.c = packageInstallCallback;
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onCancel(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onCancel, url: ");
        sb.append(str);
        RVLogger.d("AriverRes:DownloadInstallCallback", sb.toString());
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onFinish(String str) {
        final RVResourceManager rVResourceManager;
        StringBuilder sb = new StringBuilder();
        sb.append("onFinish, url: ");
        sb.append(str);
        RVLogger.d("AriverRes:DownloadInstallCallback", sb.toString());
        if (!this.f6197a || (rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class)) == null) {
            return;
        }
        ExecutorUtils.execute(this.b ? ExecutorType.URGENT_DISPLAY : ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.resource.api.DownloadInstallCallback.1
            @Override // java.lang.Runnable
            public void run() {
                rVResourceManager.installApp(DownloadInstallCallback.this.d, DownloadInstallCallback.this.c);
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onFailed(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onFinish, url: ");
        sb.append(str);
        sb.append(", errorCode: ");
        sb.append(i);
        sb.append(", errorMsg: ");
        sb.append(str2);
        RVLogger.d("AriverRes:DownloadInstallCallback", sb.toString());
        PackageInstallCallback packageInstallCallback = this.c;
        if (packageInstallCallback != null) {
            packageInstallCallback.onResult(false, null);
        }
    }
}
