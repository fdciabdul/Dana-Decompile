package id.dana.utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.anggrayudi.storage.permission.PermissionRequest;
import id.dana.R;
import id.dana.dialog.DialogPermission;
import id.dana.utils.OSUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\fJ\u001f\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0007¢\u0006\u0004\b\t\u0010\u000eJ\u001f\u0010\t\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\t\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/utils/permission/PermissionHelper;", "", "Landroid/content/Context;", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)Z", "getAuthRequestContext", "(Landroid/content/Context;)Z", "", "(Landroid/content/Context;)V", "", "(Landroid/content/Context;I)V", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "(Landroid/content/Context;Lcom/anggrayudi/storage/permission/PermissionRequest;)V", "Landroid/app/Activity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionHelper {
    public static final PermissionHelper INSTANCE = new PermissionHelper();

    private PermissionHelper() {
    }

    @JvmStatic
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        boolean z = !ActivityCompat.MyBillsEntityDataFactory(p0, p1) && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1) == -1;
        if (z) {
            Activity activity = p0;
            Intrinsics.checkNotNullParameter(activity, "");
            getAuthRequestContext(activity, (int) R.string.permission_title);
        }
        return z;
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getAuthRequestContext(p0, (int) R.string.permission_title);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    @JvmStatic
    public static final void getAuthRequestContext(final Context p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r3 = 0;
        MaterialDialog.positiveButton$default(MaterialDialog.negativeButton$default(MaterialDialog.icon$default(MaterialDialog.message$default(MaterialDialog.title$default(new MaterialDialog(p0, r3, 2, r3), Integer.valueOf(p1), null, 2, null), Integer.valueOf((int) R.string.permission_message), null, null, 6, null), Integer.valueOf((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2), null, 2, null), null, null, null, 7, null), Integer.valueOf((int) R.string.permission_setting), null, new Function1<MaterialDialog, Unit>() { // from class: id.dana.utils.permission.PermissionHelper$redirectToSystemSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog) {
                invoke2(materialDialog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog) {
                Intrinsics.checkNotNullParameter(materialDialog, "");
                StringBuilder sb = new StringBuilder();
                sb.append("package:");
                sb.append(p0.getPackageName());
                Intent flags = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString())).addCategory("android.intent.category.DEFAULT").setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Intrinsics.checkNotNullExpressionValue(flags, "");
                p0.startActivity(flags);
            }
        }, 2, null).show();
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, id.dana.dialog.DialogPermission] */
    @JvmStatic
    public static final void getAuthRequestContext(Context p0, final PermissionRequest p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DialogPermission.Builder builder = new DialogPermission.Builder(p0, new DialogInterface.OnDismissListener() { // from class: id.dana.utils.permission.PermissionHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PermissionHelper.MyBillsEntityDataFactory(Ref.ObjectRef.this);
            }
        });
        builder.scheduleImpl = R.drawable.ic_request_location;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0.getString(R.string.request_permission_title);
        builder.lookAheadTest = p0.getString(R.string.request_permission_desc);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getString(R.string.allow_permission_services);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DialogPermission.DialogListener() { // from class: id.dana.utils.permission.PermissionHelper$showLocationPermissionConsentDialog$2
            @Override // id.dana.dialog.DialogPermission.DialogListener
            public final void onDialogDismissed() {
            }

            @Override // id.dana.dialog.DialogPermission.DialogListener
            public final void onPositiveButtonClicked() {
                DialogPermission dialogPermission = objectRef.element;
                if (dialogPermission != null) {
                    dialogPermission.getAuthRequestContext();
                }
                p1.continueToPermissionRequest();
            }

            @Override // id.dana.dialog.DialogPermission.DialogListener
            public final void onNegativeButtonClicked() {
                DialogPermission dialogPermission = objectRef.element;
                if (dialogPermission != null) {
                    dialogPermission.getAuthRequestContext();
                }
            }
        };
        objectRef.element = new DialogPermission(builder.BuiltInFictitiousFunctionClassFactory, builder.moveToNextValue, builder, (byte) 0);
        DialogPermission dialogPermission = (DialogPermission) objectRef.element;
        if (dialogPermission != null) {
            dialogPermission.MyBillsEntityDataFactory();
        }
    }

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1) == 0;
    }

    @JvmStatic
    public static final boolean getAuthRequestContext(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (OSUtil.MyBillsEntityDataFactory()) {
            return true;
        }
        return MyBillsEntityDataFactory(p0, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Ref.ObjectRef objectRef) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        objectRef.element = null;
    }
}
