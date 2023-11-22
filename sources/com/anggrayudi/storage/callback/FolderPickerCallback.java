package com.anggrayudi.storage.callback;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.file.StorageType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "", "onActivityHandlerNotFound", "", RequestPermission.REQUEST_CODE, "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onFolderSelected", "folder", "Landroidx/documentfile/provider/DocumentFile;", "onStorageAccessDenied", "storageType", "Lcom/anggrayudi/storage/file/StorageType;", "onStoragePermissionDenied", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface FolderPickerCallback {
    void BuiltInFictitiousFunctionClassFactory();

    void KClassImpl$Data$declaredNonStaticMembers$2(StorageType storageType);

    void MyBillsEntityDataFactory(Intent intent);

    void getAuthRequestContext();

    void getAuthRequestContext(int i, DocumentFile documentFile);
}
