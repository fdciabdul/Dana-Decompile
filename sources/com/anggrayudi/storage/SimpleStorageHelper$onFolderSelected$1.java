package com.anggrayudi.storage;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderPickerCallback;
import com.anggrayudi.storage.file.StorageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\n"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$onFolderSelected$1;", "Lcom/anggrayudi/storage/callback/FolderPickerCallback;", "", "p0", "Landroid/content/Intent;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Intent;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroidx/documentfile/provider/DocumentFile;", "getAuthRequestContext", "(ILandroidx/documentfile/provider/DocumentFile;)V", "Lcom/anggrayudi/storage/file/StorageType;", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/anggrayudi/storage/file/StorageType;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class SimpleStorageHelper$onFolderSelected$1 implements FolderPickerCallback {
    final /* synthetic */ SimpleStorageHelper BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ Function2<Integer, DocumentFile, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public final void getAuthRequestContext(int p0, DocumentFile p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        SimpleStorageHelper.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory);
        Function2<Integer, DocumentFile, Unit> function2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(p0), p1);
        }
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final StorageType storageType) {
        Intrinsics.checkNotNullParameter(storageType, "");
        if (storageType != StorageType.UNKNOWN) {
            AlertDialog.Builder message = new AlertDialog.Builder(this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2()).setCancelable(false).setMessage(R.string.NetworkUserEntityData$$ExternalSyntheticLambda1);
            final SimpleStorageHelper simpleStorageHelper = this.BuiltInFictitiousFunctionClassFactory;
            AlertDialog.Builder negativeButton = message.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$onFolderSelected$1$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper$onFolderSelected$1.BuiltInFictitiousFunctionClassFactory(SimpleStorageHelper.this);
                }
            });
            final SimpleStorageHelper simpleStorageHelper2 = this.BuiltInFictitiousFunctionClassFactory;
            negativeButton.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$onFolderSelected$1$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper$onFolderSelected$1.KClassImpl$Data$declaredNonStaticMembers$2(SimpleStorageHelper.this, storageType);
                }
            }).show();
            return;
        }
        SimpleStorageHelper.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, new SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1(this.BuiltInFictitiousFunctionClassFactory));
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public final void getAuthRequestContext() {
        SimpleStorageHelper.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, new SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1(this.BuiltInFictitiousFunctionClassFactory));
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public final void BuiltInFictitiousFunctionClassFactory() {
        SimpleStorageHelper.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // com.anggrayudi.storage.callback.FolderPickerCallback
    public final void MyBillsEntityDataFactory(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        SimpleStorageHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SimpleStorageHelper simpleStorageHelper, StorageType storageType) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
        Intrinsics.checkNotNullParameter(storageType, "");
        SimpleStorage.getAuthRequestContext(simpleStorageHelper.lookAheadTest, 0, storageType, null, null, 13);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SimpleStorageHelper simpleStorageHelper) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
        SimpleStorageHelper.moveToNextValue(simpleStorageHelper);
    }
}
