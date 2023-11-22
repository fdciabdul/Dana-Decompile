package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import id.dana.R;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.dialog.DialogPermission;
import id.dana.utils.UrlUtil;

/* loaded from: classes2.dex */
public final class DialogPermissionFactory {
    private DialogPermissionFactory() {
    }

    public static DialogPermission BuiltInFictitiousFunctionClassFactory(Context context, String str, final DialogPermission.DialogListener dialogListener) {
        str.hashCode();
        byte b = 0;
        if (!str.equals("contact")) {
            if (str.equals("location")) {
                DialogPermission.Builder builder = new DialogPermission.Builder(context, new DialogInterface.OnDismissListener() { // from class: id.dana.dialog.DialogPermissionFactory$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        DialogPermission.DialogListener.this.onDialogDismissed();
                    }
                });
                builder.scheduleImpl = R.drawable.ic_location_graphic;
                String string = context.getString(R.string.t_n_c);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.dialog.DialogPermissionFactory$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION));
                    }
                };
                builder.MyBillsEntityDataFactory = string;
                builder.getAuthRequestContext = onClickListener;
                builder.lookAheadTest = context.getString(R.string.msg_location_dialog_desc);
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = context.getString(R.string.msg_check_permission);
                builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = dialogListener;
                DialogPermission.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(false);
                return new DialogPermission(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$2, b);
            }
            return null;
        }
        DialogPermission.Builder builder2 = new DialogPermission.Builder(context, new DialogInterface.OnDismissListener() { // from class: id.dana.dialog.DialogPermissionFactory$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogPermission.DialogListener.this.onDialogDismissed();
            }
        });
        builder2.scheduleImpl = R.drawable.ic_feed_no_contact;
        builder2.NetworkUserEntityData$$ExternalSyntheticLambda1 = context.getString(R.string.allow_contact_access);
        builder2.lookAheadTest = context.getString(R.string.please_allow_access);
        builder2.KClassImpl$Data$declaredNonStaticMembers$2 = context.getString(R.string.confirm_allow_contact);
        builder2.getErrorConfigVersion = -11908534;
        builder2.GetContactSyncConfig = ResourcesCompat.PlaceComponentResult(context, (int) R.font.f34282131296266);
        builder2.DatabaseTableConfigUtil = -13553359;
        builder2.GetContactSyncConfig = ResourcesCompat.PlaceComponentResult(context, (int) R.font.sf_pro_regular);
        builder2.PlaceComponentResult = context.getString(R.string.cancel_allow_contact);
        builder2.initRecordTimeStamp = 1;
        builder2.NetworkUserEntityData$$ExternalSyntheticLambda0 = dialogListener;
        DialogPermission.Builder KClassImpl$Data$declaredNonStaticMembers$22 = builder2.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(false);
        return new DialogPermission(KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue, KClassImpl$Data$declaredNonStaticMembers$22, b);
    }
}
