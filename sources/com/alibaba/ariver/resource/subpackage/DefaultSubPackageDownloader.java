package com.alibaba.ariver.resource.subpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ZipUtils;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.subpackage.ISubPackageDownloader;
import com.alibaba.fastjson.JSONObject;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;

/* loaded from: classes2.dex */
public class DefaultSubPackageDownloader implements ISubPackageDownloader {

    /* renamed from: a  reason: collision with root package name */
    private RVTransportService f6245a;
    private AppModel b;
    private String c;
    private App d;
    private JSONObject e;
    private ISubPackageDownloader.Callback f;

    @Override // com.alibaba.ariver.resource.subpackage.ISubPackageDownloader
    public void prepareSubpackage(Bundle bundle, App app, AppModel appModel, JSONObject jSONObject, String str, ISubPackageDownloader.Callback callback) {
        this.d = app;
        this.b = appModel;
        this.e = jSONObject;
        this.f6245a = (RVTransportService) RVProxy.get(RVTransportService.class);
        this.f = callback;
        this.c = str;
        StringBuilder sb = new StringBuilder();
        sb.append("SubPackageDownloader for appId = ");
        sb.append(appModel.getAppId());
        RVLogger.d("AriverRes:SubPackageDownloader", sb.toString());
        String string = JSONUtils.getString(this.e, this.c);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (e()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("prepareSubpackage Package has been downloaded and installed, mAppModel: ");
            sb2.append(this.b);
            sb2.append(" url:");
            sb2.append(string);
            RVLogger.d("AriverRes:SubPackageDownloader", sb2.toString());
            this.f.onSuccess(c());
        } else if (f(string)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("prepareSubpackage Package downloaded not installed, to install, mAppModel: ");
            sb3.append(this.b);
            sb3.append(" url:");
            sb3.append(string);
            RVLogger.d("AriverRes:SubPackageDownloader", sb3.toString());
            if (a()) {
                this.f.onSuccess(c());
                return;
            }
            this.f.onFail("install failed!");
            RVLogger.e("AriverRes:SubPackageDownloader", "prepareSubpackage install failed");
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("prepareSubpackage Package not downloaded not installed, to download and install, mAppModel: ");
            sb4.append(this.b);
            sb4.append(" url:");
            sb4.append(string);
            RVLogger.d("AriverRes:SubPackageDownloader", sb4.toString());
            a(string);
        }
    }

    private void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("addDownload subpackage url:");
        sb.append(str);
        RVLogger.d("AriverRes:SubPackageDownloader", sb.toString());
        if (!str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP) || this.f6245a == null) {
            return;
        }
        RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
        rVDownloadRequest.getTags().put("bizId", "nebula_app");
        rVDownloadRequest.setDownloadUrl(str);
        rVDownloadRequest.setDownloadDir(b());
        rVDownloadRequest.setDownloadFileName(d(str));
        rVDownloadRequest.setIsUrgentResource(true);
        this.f6245a.addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.ariver.resource.subpackage.DefaultSubPackageDownloader.1
            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onPrepare(String str2) {
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onProgress(String str2, int i) {
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onCancel(String str2) {
                if (DefaultSubPackageDownloader.this.d != null) {
                    ((EventTracker) RVProxy.get(EventTracker.class)).error(DefaultSubPackageDownloader.this.d, TrackId.Error_Resource_SubPackageFail, "download canceled!");
                }
                DefaultSubPackageDownloader.this.f.onFail("download canceled!");
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onFinish(String str2) {
                if (DefaultSubPackageDownloader.this.a()) {
                    DefaultSubPackageDownloader.this.f.onSuccess(DefaultSubPackageDownloader.this.c());
                } else {
                    DefaultSubPackageDownloader.this.f.onFail("install failed!");
                }
            }

            @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
            public void onFailed(String str2, int i, String str3) {
                if (DefaultSubPackageDownloader.this.d != null) {
                    EventTracker eventTracker = (EventTracker) RVProxy.get(EventTracker.class);
                    App app = DefaultSubPackageDownloader.this.d;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("download failed!");
                    sb2.append(str3);
                    eventTracker.error(app, TrackId.Error_Resource_SubPackageFail, sb2.toString());
                }
                ISubPackageDownloader.Callback callback = DefaultSubPackageDownloader.this.f;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("download failed!");
                sb3.append(str3);
                callback.onFail(sb3.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        String string = JSONUtils.getString(this.e, this.c);
        if (f(string)) {
            boolean b = b(e(string));
            if (b || this.d == null) {
                return b;
            }
            ((EventTracker) RVProxy.get(EventTracker.class)).error(this.d, TrackId.Error_Resource_SubPackageFail, "install failed!");
            return b;
        }
        return e();
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e("AriverRes:SubPackageDownloader", "installSubPackage failed, download file path is null");
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                if (e()) {
                    return true;
                }
                c(c());
                if (ZipUtils.unZip(str, c()) && e()) {
                    RVLogger.d("AriverRes:SubPackageDownloader", "installSubPackage success!");
                    FileUtils.delete(file);
                    return true;
                }
                RVLogger.e("AriverRes:SubPackageDownloader", "subpackage unzip fail");
                FileUtils.delete(file);
                RVLogger.e("AriverRes:SubPackageDownloader", "installSubPackage unZipResult || isInstalled() return false");
                return false;
            }
            return false;
        } catch (Exception e) {
            RVLogger.e("AriverRes:SubPackageDownloader", "subpackage parse error: ", e);
            return false;
        }
    }

    private void c(String str) {
        if (FileUtils.exists(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("deleteOldPkgByFullInstall ");
            sb.append(str);
            RVLogger.d("AriverRes:SubPackageDownloader", sb.toString());
            FileUtils.delete(str);
        }
    }

    private String b() {
        String path = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getCacheDir().getPath();
        return !TextUtils.isEmpty(path) ? path : "";
    }

    private String d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(RVConstants.SUB_PACKAGE_DIR_PREFIX);
        sb.append(this.b.getAppId());
        sb.append("-");
        sb.append(FileUtils.getMD5(str));
        return sb.toString();
    }

    private String e(String str) {
        String b = b();
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(str)) {
            return "";
        }
        String combinePath = FileUtils.combinePath(b, d(str));
        StringBuilder sb = new StringBuilder();
        sb.append("downloadedFilePath:");
        sb.append(combinePath);
        RVLogger.d("AriverRes:SubPackageDownloader", sb.toString());
        return combinePath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        File extDirectory = RVResourceUtils.getExtDirectory(this.b, true);
        return extDirectory == null ? "" : FileUtils.combinePath(extDirectory.getAbsolutePath(), d());
    }

    private String d() {
        if (TextUtils.isEmpty(this.c)) {
            return "";
        }
        String replace = this.c.replace('/', '_');
        StringBuilder sb = new StringBuilder();
        sb.append(RVConstants.SUB_PACKAGE_DIR_PREFIX);
        sb.append(replace);
        return sb.toString();
    }

    private boolean f(String str) {
        String e = e(str);
        boolean exists = FileUtils.exists(e);
        StringBuilder sb = new StringBuilder();
        sb.append("isPkgAvailable: path:");
        sb.append(e);
        sb.append(" isExist:");
        sb.append(exists);
        RVLogger.d("AriverRes:SubPackageDownloader", sb.toString());
        return exists;
    }

    private boolean e() {
        String c = c();
        if (TextUtils.isEmpty(c)) {
            RVLogger.e("AriverRes:SubPackageDownloader", "getInstalledPath() is empty");
            return false;
        }
        try {
            File file = new File(c);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                StringBuilder sb = new StringBuilder();
                sb.append("isInstalled length:");
                sb.append(length);
                RVLogger.d("AriverRes:SubPackageDownloader", sb.toString());
                if (length > 0) {
                    boolean z = false;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("installed dir file ");
                        sb2.append(name);
                        RVLogger.d("AriverRes:SubPackageDownloader", sb2.toString());
                        if (name.contains("tar")) {
                            z = true;
                        }
                    }
                    if (length < 4 && !z) {
                        RVLogger.e("AriverRes:SubPackageDownloader", "installSubPackage files broken, delete broken files");
                        c(c);
                        return false;
                    } else if (z) {
                        return true;
                    } else {
                        RVLogger.e("AriverRes:SubPackageDownloader", "installSubPackage files broken, delete broken files");
                        c(c);
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            RVLogger.e("AriverRes:SubPackageDownloader", e);
        }
        return false;
    }
}
