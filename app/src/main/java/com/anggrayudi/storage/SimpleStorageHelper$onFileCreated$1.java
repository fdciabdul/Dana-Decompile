package com.anggrayudi.storage;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.CreateFileCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$onFileCreated$1;", "Lcom/anggrayudi/storage/callback/CreateFileCallback;", "", "p0", "", "MyBillsEntityDataFactory", "()V", "Landroidx/documentfile/provider/DocumentFile;", "p1", "getAuthRequestContext", "(ILandroidx/documentfile/provider/DocumentFile;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleStorageHelper$onFileCreated$1 implements CreateFileCallback {
    final /* synthetic */ Function2<Integer, DocumentFile, Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ SimpleStorageHelper PlaceComponentResult;

    @Override // com.anggrayudi.storage.callback.CreateFileCallback
    public final void MyBillsEntityDataFactory() {
        SimpleStorageHelper.moveToNextValue(this.PlaceComponentResult);
    }

    @Override // com.anggrayudi.storage.callback.CreateFileCallback
    public final void getAuthRequestContext(int p0, DocumentFile p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        SimpleStorageHelper.moveToNextValue(this.PlaceComponentResult);
        Function2<Integer, DocumentFile, Unit> function2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(p0), p1);
        }
    }
}
