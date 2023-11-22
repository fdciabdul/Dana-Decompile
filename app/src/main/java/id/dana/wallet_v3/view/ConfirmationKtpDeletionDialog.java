package id.dana.wallet_v3.view;

import android.content.Context;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/wallet_v3/view/ConfirmationKtpDeletionDialog;", "", "", "showDialog", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lkotlin/Function1;", "Landroid/view/View;", "onPositiveButtonClickListener", "Lkotlin/jvm/functions/Function1;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ConfirmationKtpDeletionDialog {
    private final Context context;
    private final Function1<View, Unit> onPositiveButtonClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    public ConfirmationKtpDeletionDialog(Context context, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.context = context;
        this.onPositiveButtonClickListener = function1;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    public final void showDialog() {
        CustomDialog.Builder builder = new CustomDialog.Builder(this.context);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning;
        builder.SubSequence = this.context.getString(R.string.delete_card_dialog_title);
        builder.GetContactSyncConfig = this.context.getString(R.string.delete_card_dialog_desc);
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.context.getString(R.string.delete_card_dialog_positive_button), this.onPositiveButtonClickListener).KClassImpl$Data$declaredNonStaticMembers$2(this.context.getString(R.string.delete_card_dialog_negative_button), new Function1<View, Unit>() { // from class: id.dana.wallet_v3.view.ConfirmationKtpDeletionDialog$showDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory().show();
    }
}
