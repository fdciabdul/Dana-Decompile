package id.dana.riskChallenges.ui.passkey.main;

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

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/core/ui/dialog/CommonDialog;", BridgeDSL.INVOKE, "()Lid/dana/core/ui/dialog/CommonDialog;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnrollmentMainFragment$failedEnrollmentStartDialog$2 extends Lambda implements Function0<CommonDialog> {
    final /* synthetic */ EnrollmentMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrollmentMainFragment$failedEnrollmentStartDialog$2(EnrollmentMainFragment enrollmentMainFragment) {
        super(0);
        this.this$0 = enrollmentMainFragment;
    }

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
        final EnrollmentMainFragment enrollmentMainFragment = this.this$0;
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnDismissListener() { // from class: id.dana.riskChallenges.ui.passkey.main.EnrollmentMainFragment$failedEnrollmentStartDialog$2$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EnrollmentMainFragment$failedEnrollmentStartDialog$2.m2878invoke$lambda0(EnrollmentMainFragment.this, dialogInterface);
            }
        };
        return new CommonDialog(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m2878invoke$lambda0(EnrollmentMainFragment enrollmentMainFragment, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(enrollmentMainFragment, "");
        enrollmentMainFragment.getParentFragmentManager().popBackStack();
    }
}
