package com.alibaba.ariver.resource.subpackage;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes2.dex */
public interface DownloadQueryPoint extends Extension {
    ISubPackageDownloader getSubDownloader(AppModel appModel, Bundle bundle);
}
