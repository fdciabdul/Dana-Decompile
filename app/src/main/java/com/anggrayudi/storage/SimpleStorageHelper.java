package com.anggrayudi.storage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.documentfile.provider.DocumentFile;
import androidx.view.ComponentActivity;
import com.anggrayudi.storage.SimpleStorageHelper;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u001d\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR4\u0010\u0004\u001a$\u0012\u000b\u0012\t\u0018\u00010\u000e¢\u0006\u0002\b\u000f\u0012\u000b\u0012\t\u0018\u00010\u0010¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0011\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u001a"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper;", "", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Set;", "PlaceComponentResult", "Lkotlin/Function1;", "", "", "lookAheadTest", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "Landroidx/documentfile/provider/DocumentFile;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function2;", "I", "MyBillsEntityDataFactory", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "moveToNextValue", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "getErrorConfigVersion", "Lcom/anggrayudi/storage/SimpleStorage;", "Lcom/anggrayudi/storage/SimpleStorage;", "Landroidx/activity/ComponentActivity;", "p0", "Landroid/os/Bundle;", "p1", "<init>", "(Landroidx/activity/ComponentActivity;Landroid/os/Bundle;)V", "Companion", "OnFileReceived"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleStorageHelper {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Set<String> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    Function2<? super Integer, ? super DocumentFile, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final SimpleStorage lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function1<? super Boolean, Unit> getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final PermissionRequest KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$OnFileReceived;", "", "onFileReceived", "", "files", "", "Landroidx/documentfile/provider/DocumentFile;", "onNonFileReceived", "intent", "Landroid/content/Intent;", "storage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public interface OnFileReceived {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.os.Bundle, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public SimpleStorageHelper(ComponentActivity componentActivity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(componentActivity, "");
        this.lookAheadTest = new SimpleStorage(componentActivity, r3, 2, r3);
        if (bundle != null) {
            Intrinsics.checkNotNullParameter(bundle, "");
            this.lookAheadTest.PlaceComponentResult(bundle);
            this.MyBillsEntityDataFactory = bundle.getInt("com.anggrayudi.storage.originalRequestCode");
            this.getErrorConfigVersion = bundle.getInt("com.anggrayudi.storage.pickerToOpenOnceGranted");
            String[] stringArray = bundle.getStringArray("com.anggrayudi.storage.filterMimeTypes");
            this.PlaceComponentResult = stringArray != null ? ArraysKt.toSet(stringArray) : 0;
        }
        this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SimpleStorageHelper$init$2(this);
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder(componentActivity);
        String[] strArr = (String[]) Arrays.copyOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 2);
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: com.anggrayudi.storage.SimpleStorageHelper$permissionCallback$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(p0, "");
                boolean MyBillsEntityDataFactory = p0.MyBillsEntityDataFactory();
                if (!MyBillsEntityDataFactory) {
                    Toast.makeText(SimpleStorageHelper.this.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), R.string.PlaceComponentResult, 0).show();
                }
                function1 = SimpleStorageHelper.this.getAuthRequestContext;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(MyBillsEntityDataFactory));
                }
                SimpleStorageHelper.this.getAuthRequestContext = null;
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(p0, "");
                SimpleStorageHelper.Companion companion = SimpleStorageHelper.INSTANCE;
                SimpleStorageHelper.Companion.MyBillsEntityDataFactory(SimpleStorageHelper.this.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2());
                function1 = SimpleStorageHelper.this.getAuthRequestContext;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
                SimpleStorageHelper.this.getAuthRequestContext = null;
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/anggrayudi/storage/SimpleStorageHelper$Companion;", "", "Landroid/content/Context;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        }

        private Companion() {
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(final Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            new AlertDialog.Builder(p0).setMessage(R.string.initRecordTimeStamp).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$Companion$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper.Companion.BuiltInFictitiousFunctionClassFactory();
                }
            }).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.anggrayudi.storage.SimpleStorageHelper$Companion$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SimpleStorageHelper.Companion.getAuthRequestContext(p0);
                }
            }).show();
        }

        public static /* synthetic */ void getAuthRequestContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            Intent flags = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(Intrinsics.stringPlus("package:", context.getPackageName()))).addCategory("android.intent.category.DEFAULT").setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            Intrinsics.checkNotNullExpressionValue(flags, "");
            context.startActivity(flags);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SimpleStorageHelper simpleStorageHelper) {
        simpleStorageHelper.getErrorConfigVersion = 0;
        simpleStorageHelper.MyBillsEntityDataFactory = 0;
        simpleStorageHelper.PlaceComponentResult = null;
        Toast.makeText(simpleStorageHelper.lookAheadTest.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(), R.string.MyBillsEntityDataFactory, 0).show();
    }

    public static final /* synthetic */ void getAuthRequestContext(SimpleStorageHelper simpleStorageHelper, Function1 function1) {
        simpleStorageHelper.getAuthRequestContext = function1;
        simpleStorageHelper.KClassImpl$Data$declaredNonStaticMembers$2.check();
    }

    public static final /* synthetic */ void moveToNextValue(SimpleStorageHelper simpleStorageHelper) {
        simpleStorageHelper.getErrorConfigVersion = 0;
        simpleStorageHelper.MyBillsEntityDataFactory = 0;
        simpleStorageHelper.PlaceComponentResult = null;
    }
}
