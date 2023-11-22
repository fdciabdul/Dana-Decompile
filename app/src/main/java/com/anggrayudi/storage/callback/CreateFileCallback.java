package com.anggrayudi.storage.callback;

import androidx.documentfile.provider.DocumentFile;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/CreateFileCallback;", "", "onActivityHandlerNotFound", "", RequestPermission.REQUEST_CODE, "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFileCreated", "file", "Landroidx/documentfile/provider/DocumentFile;", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface CreateFileCallback {
    void MyBillsEntityDataFactory();

    void getAuthRequestContext(int i, DocumentFile documentFile);
}
