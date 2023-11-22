package com.alibaba.griver.file.extension;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.file.GriverFileExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.OuterFileUtils;
import com.alibaba.griver.file.ui.FileViewerActivity;
import com.alibaba.griver.file.utils.FileManager;
import com.alibaba.griver.image.photo.PhotoContext;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;

/* loaded from: classes6.dex */
public class GriverFileExtensionImpl implements GriverFileExtension {
    @Override // com.alibaba.griver.api.file.GriverFileExtension
    public void downloadFile(String str, String str2, String str3, String str4, long j, DownloadCallback downloadCallback) {
        FileManager.downloadFileByHttp(str, downloadPath(), str, downloadCallback);
    }

    @Override // com.alibaba.griver.api.file.GriverFileExtension
    public String downloadPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(OuterFileUtils.getOuterRootFileDir(GriverEnv.getApplicationContext()));
        sb.append(File.separator);
        sb.append(SemanticAttributes.DbSystemValues.CACHE);
        return sb.toString();
    }

    @Override // com.alibaba.griver.api.file.GriverFileExtension
    public void openDocument(Activity activity, String str) {
        String filePath = FileManager.getFilePath(str);
        if (filePath == null) {
            return;
        }
        int lastIndexOf = filePath.lastIndexOf(".");
        String substring = lastIndexOf > 0 ? filePath.substring(lastIndexOf + 1) : "";
        String replace = filePath.replace(PhotoContext.FILE_SCHEME, "");
        if (new File(replace).exists()) {
            Intent intent = new Intent();
            intent.setClass(activity, FileViewerActivity.class);
            intent.putExtra("fileType", substring);
            intent.putExtra(BridgeKey.FILE_PATH, replace);
            activity.startActivity(intent);
        }
    }
}
