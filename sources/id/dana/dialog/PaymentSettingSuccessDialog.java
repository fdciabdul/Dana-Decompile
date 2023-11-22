package id.dana.dialog;

import android.content.Context;
import android.view.View;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/dialog/PaymentSettingSuccessDialog;", "", "", "PlaceComponentResult", "()V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "p0", "p1", "<init>", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentSettingSuccessDialog {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final View.OnClickListener BuiltInFictitiousFunctionClassFactory;

    public PaymentSettingSuccessDialog(Context context, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = onClickListener;
    }

    public final void PlaceComponentResult() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this.KClassImpl$Data$declaredNonStaticMembers$2);
        builder.DatabaseTableConfigUtil = R.drawable.ic_payment_setting_success_dialog;
        builder.SubSequence = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.payment_setting_success_dialog_title);
        builder.GetContactSyncConfig = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.payment_setting_success_dialog_message);
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.face_verification_info_button);
        View.OnClickListener onClickListener = this.BuiltInFictitiousFunctionClassFactory;
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode = onClickListener;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }
}
