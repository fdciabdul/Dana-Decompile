package com.alibaba.ariver.resource.api.proxy;

import android.os.Bundle;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes3.dex */
public interface RVResourceManager extends Proxiable {
    void deleteDownloadPackage(AppModel appModel);

    void deleteInstallStatus(String str);

    void downloadApp(AppModel appModel, boolean z, PackageDownloadCallback packageDownloadCallback);

    void downloadApp(AppModel appModel, boolean z, PackageDownloadCallback packageDownloadCallback, Bundle bundle);

    String getInstallPath(AppModel appModel);

    String getInstalledAppVersion(String str);

    String getRootInstallPath(String str);

    void installApp(AppModel appModel, PackageInstallCallback packageInstallCallback);

    boolean isAvailable(AppModel appModel);

    boolean isDownloaded(AppModel appModel);
}
