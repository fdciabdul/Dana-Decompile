package com.anggrayudi.storage.callback;

import android.content.Intent;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.file.StorageType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH&J0\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "", "onActivityHandlerNotFound", "", RequestPermission.REQUEST_CODE, "", "intent", "Landroid/content/Intent;", "onCanceledByUser", "onExpectedStorageNotSelected", "selectedFolder", "Landroidx/documentfile/provider/DocumentFile;", "selectedStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "expectedBasePath", "", "expectedStorageType", "onRootPathNotSelected", "rootPath", "uri", "Landroid/net/Uri;", "onRootPathPermissionGranted", "root", "onStoragePermissionDenied", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface StorageAccessCallback {
    void BuiltInFictitiousFunctionClassFactory(String str, Uri uri, StorageType storageType, StorageType storageType2);

    void KClassImpl$Data$declaredNonStaticMembers$2();

    void KClassImpl$Data$declaredNonStaticMembers$2(int i, DocumentFile documentFile);

    void MyBillsEntityDataFactory();

    void getAuthRequestContext(Intent intent);

    void getAuthRequestContext(DocumentFile documentFile, StorageType storageType, String str, StorageType storageType2);
}
