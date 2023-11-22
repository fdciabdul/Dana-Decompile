package id.dana.core.ui.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import id.dana.core.ui.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/core/ui/util/PermissionHelper;", "", "Landroid/content/Context;", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "getAuthRequestContext", "(Landroid/content/Context;)V", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PermissionHelper {
    public static final PermissionHelper INSTANCE = new PermissionHelper();

    private PermissionHelper() {
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(final Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r3 = 0;
        MaterialDialog.positiveButton$default(MaterialDialog.negativeButton$default(MaterialDialog.icon$default(MaterialDialog.message$default(MaterialDialog.title$default(new MaterialDialog(p0, r3, 2, r3), Integer.valueOf(R.string.permission_title_general), null, 2, null), Integer.valueOf(R.string.permission_message), null, null, 6, null), Integer.valueOf(R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2), null, 2, null), null, null, null, 7, null), Integer.valueOf(R.string.permission_setting), null, new Function1<MaterialDialog, Unit>() { // from class: id.dana.core.ui.util.PermissionHelper$showDialogRedirectToSystemSettings$1
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

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1) == 0;
    }

    @JvmStatic
    public static final void getAuthRequestContext(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(p0.getPackageName());
        Intent flags = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString())).addCategory("android.intent.category.DEFAULT").setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Intrinsics.checkNotNullExpressionValue(flags, "");
        p0.startActivity(flags);
    }
}
