package id.dana.cashier;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/CashierExitConfirmationDialog;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierExitConfirmationDialog {
    public static final CashierExitConfirmationDialog INSTANCE = new CashierExitConfirmationDialog();

    private CashierExitConfirmationDialog() {
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Function1 function1) {
        CashierExitConfirmationDialog$show$2 cashierExitConfirmationDialog$show$2 = new Function1<View, Unit>() { // from class: id.dana.cashier.CashierExitConfirmationDialog$show$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(cashierExitConfirmationDialog$show$2, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = id.dana.R.drawable.ic_warning_red;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = 24;
        builder.SubSequence = context.getString(id.dana.R.string.exit_confirmation_dialog_title);
        builder.GetContactSyncConfig = context.getString(id.dana.R.string.exit_confirmation_dialog_content);
        String string = context.getString(id.dana.R.string.exit_confirmation_dialog_positive_label);
        Intrinsics.checkNotNullParameter(function1, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        builder.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        String string2 = context.getString(id.dana.R.string.cancel_action);
        Intrinsics.checkNotNullParameter(cashierExitConfirmationDialog$show$2, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$02 = new CustomDialog$sam$android_view_View_OnClickListener$0(cashierExitConfirmationDialog$show$2);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = string2;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = customDialog$sam$android_view_View_OnClickListener$02;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(true).KClassImpl$Data$declaredNonStaticMembers$2(true);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        MaterialDialog BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        DialogLayout view = BuiltInFictitiousFunctionClassFactory.getView();
        int BuiltInFictitiousFunctionClassFactory2 = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, id.dana.R.color.f24002131099997);
        ((TextView) view.findViewById(16908310)).setTextColor(BuiltInFictitiousFunctionClassFactory2);
        TextView textView = (TextView) view.findViewById(16908304);
        textView.setTextColor(BuiltInFictitiousFunctionClassFactory2);
        textView.setTypeface(ResourcesCompat.PlaceComponentResult(context, (int) id.dana.R.font.sf_pro_regular));
        BuiltInFictitiousFunctionClassFactory.show();
    }
}
