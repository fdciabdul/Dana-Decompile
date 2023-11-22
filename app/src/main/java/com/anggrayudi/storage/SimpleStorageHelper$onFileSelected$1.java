package com.anggrayudi.storage;

import android.content.Intent;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FilePickerCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\n"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$onFileSelected$1;", "Lcom/anggrayudi/storage/callback/FilePickerCallback;", "", "p0", "Landroid/content/Intent;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Intent;)V", "MyBillsEntityDataFactory", "()V", "", "Landroidx/documentfile/provider/DocumentFile;", "(ILjava/util/List;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class SimpleStorageHelper$onFileSelected$1 implements FilePickerCallback {
    final /* synthetic */ Function2<Integer, List<? extends DocumentFile>, Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ SimpleStorageHelper PlaceComponentResult;

    @Override // com.anggrayudi.storage.callback.FilePickerCallback
    public final void BuiltInFictitiousFunctionClassFactory() {
        SimpleStorageHelper simpleStorageHelper = this.PlaceComponentResult;
        final SimpleStorageHelper simpleStorageHelper2 = this.PlaceComponentResult;
        SimpleStorageHelper.getAuthRequestContext(simpleStorageHelper, new Function1<Boolean, Unit>() { // from class: com.anggrayudi.storage.SimpleStorageHelper$onFileSelected$1$onStoragePermissionDenied$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    SimpleStorage.KClassImpl$Data$declaredNonStaticMembers$2(SimpleStorageHelper.this.lookAheadTest, new String[0]);
                } else {
                    SimpleStorageHelper.moveToNextValue(SimpleStorageHelper.this);
                }
            }
        });
    }

    @Override // com.anggrayudi.storage.callback.FilePickerCallback
    public final void BuiltInFictitiousFunctionClassFactory(int p0, List<? extends DocumentFile> p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        SimpleStorageHelper.moveToNextValue(this.PlaceComponentResult);
        Function2<Integer, List<? extends DocumentFile>, Unit> function2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(p0), p1);
        }
    }

    @Override // com.anggrayudi.storage.callback.FilePickerCallback
    public final void MyBillsEntityDataFactory() {
        SimpleStorageHelper.moveToNextValue(this.PlaceComponentResult);
    }

    @Override // com.anggrayudi.storage.callback.FilePickerCallback
    public final void BuiltInFictitiousFunctionClassFactory(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        SimpleStorageHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
    }
}
