package com.alibaba.ariver.resource.template;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.models.TemplateExtModel;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class TemplateExtLoader implements Future<TemplateExtModel> {

    /* renamed from: a  reason: collision with root package name */
    private AppModel f6248a;
    private TemplateConfigModel b;
    private TemplateExtModel c;

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    public TemplateExtLoader(AppModel appModel) {
        this.f6248a = appModel;
        this.b = appModel.getAppInfoModel().getTemplateConfig();
    }

    private TemplateExtModel a() {
        if (this.b.isTemplateValid()) {
            if (!TextUtils.isEmpty(this.b.getExtUrl())) {
                File extDirectory = RVResourceUtils.getExtDirectory(this.f6248a, true);
                if (extDirectory == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("template_ext_");
                sb.append(FileUtils.getMD5(this.b.getExtUrl()));
                String obj = sb.toString();
                final String combinePath = FileUtils.combinePath(extDirectory.getAbsolutePath(), obj);
                if (FileUtils.exists(combinePath)) {
                    String read = IOUtils.read(combinePath);
                    if (read == null) {
                        FileUtils.delete(combinePath);
                    } else {
                        this.c = (TemplateExtModel) JSONUtils.parseObject(read.getBytes(), TemplateExtModel.class);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("got downloaded template from ");
                        sb2.append(combinePath);
                        sb2.append(", value: ");
                        sb2.append(this.c);
                        RVLogger.d("AriverRes:TemplateExtLoader", sb2.toString());
                        TemplateExtModel templateExtModel = this.c;
                        if (templateExtModel != null) {
                            return templateExtModel;
                        }
                    }
                }
                RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
                rVDownloadRequest.setDownloadDir(extDirectory.getAbsolutePath());
                rVDownloadRequest.setDownloadFileName(obj);
                rVDownloadRequest.setDownloadUrl(this.b.getExtUrl());
                rVDownloadRequest.setIsUrgentResource(true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("begin download template config to ");
                sb3.append(combinePath);
                RVLogger.d("AriverRes:TemplateExtLoader", sb3.toString());
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                ((RVTransportService) RVProxy.get(RVTransportService.class)).addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.ariver.resource.template.TemplateExtLoader.1
                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onPrepare(String str) {
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onProgress(String str, int i) {
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onCancel(String str) {
                        RVLogger.w("AriverRes:TemplateExtLoader", "download onCancel");
                        FileUtils.delete(combinePath);
                        countDownLatch.countDown();
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onFinish(String str) {
                        String read2 = IOUtils.read(combinePath);
                        if (read2 == null) {
                            onFailed(str, 0, "extObject read exception!");
                            return;
                        }
                        TemplateExtLoader.this.c = (TemplateExtModel) JSONUtils.parseObject(read2.getBytes(), TemplateExtModel.class);
                        if (TemplateExtLoader.this.c == null) {
                            onFailed(str, 0, "extObject parse fail!");
                            return;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("download onFinish extObject: ");
                        sb4.append(TemplateExtLoader.this.c);
                        RVLogger.d("AriverRes:TemplateExtLoader", sb4.toString());
                        countDownLatch.countDown();
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onFailed(String str, int i, String str2) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("download onFailed: ");
                        sb4.append(i);
                        sb4.append(" ");
                        sb4.append(str2);
                        RVLogger.e("AriverRes:TemplateExtLoader", sb4.toString());
                        FileUtils.delete(combinePath);
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    RVLogger.e("AriverRes:TemplateExtLoader", "await exception!", e);
                    return null;
                }
            } else {
                this.c = this.b.getExtModel();
            }
            return this.c;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.c != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Future
    public TemplateExtModel get() throws InterruptedException, ExecutionException {
        return a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Future
    public TemplateExtModel get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a();
    }
}
