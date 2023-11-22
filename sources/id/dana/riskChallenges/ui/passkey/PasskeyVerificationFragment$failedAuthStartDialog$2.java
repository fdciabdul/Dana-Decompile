package id.dana.riskChallenges.ui.passkey;

import android.content.Context;
import android.content.DialogInterface;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.dialog.CommonDialog;
import id.dana.riskChallenges.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/core/ui/dialog/CommonDialog;", BridgeDSL.INVOKE, "()Lid/dana/core/ui/dialog/CommonDialog;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyVerificationFragment$failedAuthStartDialog$2 extends Lambda implements Function0<CommonDialog> {
    final /* synthetic */ PasskeyVerificationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasskeyVerificationFragment$failedAuthStartDialog$2(PasskeyVerificationFragment passkeyVerificationFragment) {
        super(0);
        this.this$0 = passkeyVerificationFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CommonDialog invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CommonDialog.Builder builder = new CommonDialog.Builder(requireContext);
        builder.getAuthRequestContext = true;
        DialogType dialogType = DialogType.WARNING;
        Intrinsics.checkNotNullParameter(dialogType, "");
        builder.DatabaseTableConfigUtil = dialogType;
        builder.lookAheadTest = this.this$0.getString(R.string.passkey_enrollment_failed_enrollment_start_dialog);
        final PasskeyVerificationFragment passkeyVerificationFragment = this.this$0;
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnDismissListener() { // from class: id.dana.riskChallenges.ui.passkey.PasskeyVerificationFragment$failedAuthStartDialog$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                PasskeyVerificationFragment$failedAuthStartDialog$2.m2877invoke$lambda0(PasskeyVerificationFragment.this, dialogInterface);
            }
        };
        return new CommonDialog(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2877invoke$lambda0(PasskeyVerificationFragment passkeyVerificationFragment, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(passkeyVerificationFragment, "");
        passkeyVerificationFragment.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) null);
    }
}
