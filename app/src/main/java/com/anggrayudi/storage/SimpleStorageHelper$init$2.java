package com.anggrayudi.storage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.StorageAccessCallback;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.file.StorageType;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\u0011J7\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\n"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$init$2;", "Lcom/anggrayudi/storage/callback/StorageAccessCallback;", "", "p0", "Landroid/content/Intent;", "p1", "", "getAuthRequestContext", "(Landroid/content/Intent;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Landroidx/documentfile/provider/DocumentFile;", "Lcom/anggrayudi/storage/file/StorageType;", "p2", "", "p3", "p4", "(Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/file/StorageType;Ljava/lang/String;Lcom/anggrayudi/storage/file/StorageType;)V", "Landroid/net/Uri;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/net/Uri;Lcom/anggrayudi/storage/file/StorageType;Lcom/anggrayudi/storage/file/StorageType;)V", "(ILandroidx/documentfile/provider/DocumentFile;)V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleStorageHelper$init$2 implements StorageAccessCallback {
    final /* synthetic */ SimpleStorageHelper BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[StorageType.values().length];
            iArr[StorageType.EXTERNAL.ordinal()] = 1;
            iArr[StorageType.SD_CARD.ordinal()] = 2;
            PlaceComponentResult = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleStorageHelper$init$2(SimpleStorageHelper simpleStorageHelper) {
        this.BuiltInFictitiousFunctionClassFactory = simpleStorageHelper;
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public final void BuiltInFictitiousFunctionClassFactory(String str, Uri uri, final StorageType storageType, final StorageType storageType2) {
        String string;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(storageType, "");
        Intrinsics.checkNotNullParameter(storageType2, "");
        if (!storageType2.isExpected(storageType)) {
            storageType = storageType2;
        }
        if (str.length() == 0) {
            string = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2().getString(storageType == StorageType.SD_CARD ? R.string.NetworkUserEntityData$$ExternalSyntheticLambda0 : R.string.lookAheadTest);
        } else {
            string = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2().getString(storageType == StorageType.SD_CARD ? R.string.moveToNextValue : R.string.scheduleImpl, str);
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        AlertDialog.Builder message = new AlertDialog.Builder(this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2()).setCancelable(false).setMessage(string);
        final SimpleStorageHelper simpleStorageHelper = this.BuiltInFictitiousFunctionClassFactory;
        AlertDialog.Builder negativeButton = message.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$init$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SimpleStorageHelper$init$2.getAuthRequestContext(SimpleStorageHelper.this);
            }
        });
        final SimpleStorageHelper simpleStorageHelper2 = this.BuiltInFictitiousFunctionClassFactory;
        negativeButton.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$init$2$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SimpleStorageHelper$init$2.MyBillsEntityDataFactory(SimpleStorageHelper.this, storageType, storageType2);
            }
        }).show();
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, final DocumentFile p1) {
        int i;
        int i2;
        Set set;
        Intrinsics.checkNotNullParameter(p1, "");
        i = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        if (p0 == i) {
            SimpleStorageHelper.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory);
            Function2<? super Integer, ? super DocumentFile, Unit> function2 = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(p0), p1);
                return;
            }
            return;
        }
        final Context KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2();
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.anggrayudi.storage.SimpleStorageHelper$init$2$onRootPathPermissionGranted$toastFilePicker$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context context = KClassImpl$Data$declaredNonStaticMembers$2;
                Toast.makeText(context, context.getString(R.string.getErrorConfigVersion, DocumentFileUtils.KClassImpl$Data$declaredNonStaticMembers$2(p1, KClassImpl$Data$declaredNonStaticMembers$2)), 1).show();
            }
        };
        i2 = this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
        if (i2 == 1) {
            SimpleStorage simpleStorage = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
            set = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            if (set == null) {
                set = SetsKt.emptySet();
            }
            Object[] array = set.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                SimpleStorage.KClassImpl$Data$declaredNonStaticMembers$2(simpleStorage, (String[]) Arrays.copyOf(strArr, strArr.length));
                function0.invoke();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else if (i2 == 2) {
            SimpleStorage.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.lookAheadTest);
            function0.invoke();
        } else {
            Toast.makeText(KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.GetContactSyncConfig, DocumentFileUtils.KClassImpl$Data$declaredNonStaticMembers$2(p1, KClassImpl$Data$declaredNonStaticMembers$2)), 0).show();
        }
        SimpleStorageHelper.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public final void getAuthRequestContext(DocumentFile documentFile, StorageType storageType, final String str, final StorageType storageType2) {
        int i;
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(storageType, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(storageType2, "");
        Context KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2();
        int i2 = WhenMappings.PlaceComponentResult[storageType2.ordinal()];
        if (i2 == 1) {
            i = R.string.getAuthRequestContext;
        } else if (i2 == 2) {
            i = R.string.BuiltInFictitiousFunctionClassFactory;
        } else {
            i = R.string.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        String string = KClassImpl$Data$declaredNonStaticMembers$2.getString(i, str);
        Intrinsics.checkNotNullExpressionValue(string, "");
        AlertDialog.Builder message = new AlertDialog.Builder(this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2()).setCancelable(false).setMessage(string);
        final SimpleStorageHelper simpleStorageHelper = this.BuiltInFictitiousFunctionClassFactory;
        AlertDialog.Builder negativeButton = message.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$init$2$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SimpleStorageHelper$init$2.PlaceComponentResult(SimpleStorageHelper.this);
            }
        });
        final SimpleStorageHelper simpleStorageHelper2 = this.BuiltInFictitiousFunctionClassFactory;
        negativeButton.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$init$2$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SimpleStorageHelper$init$2.getAuthRequestContext(SimpleStorageHelper.this, storageType2, str);
            }
        }).show();
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public final void MyBillsEntityDataFactory() {
        SimpleStorageHelper simpleStorageHelper = this.BuiltInFictitiousFunctionClassFactory;
        final SimpleStorageHelper simpleStorageHelper2 = this.BuiltInFictitiousFunctionClassFactory;
        SimpleStorageHelper.getAuthRequestContext(simpleStorageHelper, new Function1<Boolean, Unit>() { // from class: com.anggrayudi.storage.SimpleStorageHelper$init$2$onStoragePermissionDenied$1
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
                    SimpleStorage.PlaceComponentResult(SimpleStorageHelper.this.lookAheadTest);
                } else {
                    SimpleStorageHelper.moveToNextValue(SimpleStorageHelper.this);
                }
            }
        });
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        SimpleStorageHelper.moveToNextValue(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // com.anggrayudi.storage.callback.StorageAccessCallback
    public final void getAuthRequestContext(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        SimpleStorageHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
    }

    public static /* synthetic */ void getAuthRequestContext(SimpleStorageHelper simpleStorageHelper, StorageType storageType, String str) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
        Intrinsics.checkNotNullParameter(storageType, "");
        Intrinsics.checkNotNullParameter(str, "");
        SimpleStorage.getAuthRequestContext(simpleStorageHelper.lookAheadTest, 0, storageType, storageType, str, 1);
    }

    public static /* synthetic */ void PlaceComponentResult(SimpleStorageHelper simpleStorageHelper) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
        SimpleStorageHelper.moveToNextValue(simpleStorageHelper);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SimpleStorageHelper simpleStorageHelper, StorageType storageType, StorageType storageType2) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
        Intrinsics.checkNotNullParameter(storageType, "");
        Intrinsics.checkNotNullParameter(storageType2, "");
        SimpleStorage.getAuthRequestContext(simpleStorageHelper.lookAheadTest, 0, storageType, storageType2, null, 9);
    }

    public static /* synthetic */ void getAuthRequestContext(SimpleStorageHelper simpleStorageHelper) {
        Intrinsics.checkNotNullParameter(simpleStorageHelper, "");
        SimpleStorageHelper.moveToNextValue(simpleStorageHelper);
    }
}
