package id.dana.savings.withdrawal;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.dialog.TwoButtonWithImageDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0006*\u00020\u00000\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/dialog/TwoButtonWithImageDialog;", BridgeDSL.INVOKE, "()Lid/dana/dialog/TwoButtonWithImageDialog;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawalSavingBottomSheetDialog$userKycDialog$2 extends Lambda implements Function0<TwoButtonWithImageDialog> {
    final /* synthetic */ WithdrawalSavingBottomSheetDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithdrawalSavingBottomSheetDialog$userKycDialog$2(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog) {
        super(0);
        this.this$0 = withdrawalSavingBottomSheetDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2892invoke$lambda0(View view) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TwoButtonWithImageDialog invoke() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this.this$0.getContext());
        builder.FragmentBottomSheetPaymentSettingBinding = this.this$0.getString(R.string.saving_withdrawal_title_dialog);
        builder.getErrorConfigVersion = this.this$0.getString(R.string.saving_withdrawal_message_dialog);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_premium_feature;
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = this.this$0.getString(R.string.saving_withdrawal_negative_dialog);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog$userKycDialog$2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WithdrawalSavingBottomSheetDialog$userKycDialog$2.m2892invoke$lambda0(view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener;
        String string2 = this.this$0.getString(R.string.upgrade);
        final WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog = this.this$0;
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.savings.withdrawal.WithdrawalSavingBottomSheetDialog$userKycDialog$2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WithdrawalSavingBottomSheetDialog$userKycDialog$2.m2893invoke$lambda1(WithdrawalSavingBottomSheetDialog.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string2;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener2;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
        return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m2893invoke$lambda1(WithdrawalSavingBottomSheetDialog withdrawalSavingBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(withdrawalSavingBottomSheetDialog, "");
        WithdrawalSavingBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(withdrawalSavingBottomSheetDialog);
    }
}
