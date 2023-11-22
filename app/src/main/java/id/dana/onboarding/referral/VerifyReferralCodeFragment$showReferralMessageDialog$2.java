package id.dana.onboarding.referral;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.databinding.FragmentVerifyReferralCodeBinding;
import id.dana.extension.view.InputExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", BridgeDSL.INVOKE, "(Landroid/view/View;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyReferralCodeFragment$showReferralMessageDialog$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ VerifyReferralCodeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyReferralCodeFragment$showReferralMessageDialog$2(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        super(1);
        this.this$0 = verifyReferralCodeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        AppCompatEditText appCompatEditText;
        AppCompatEditText appCompatEditText2;
        Intrinsics.checkNotNullParameter(view, "");
        FragmentVerifyReferralCodeBinding MyBillsEntityDataFactory = VerifyReferralCodeFragment.MyBillsEntityDataFactory(this.this$0);
        if (MyBillsEntityDataFactory != null && (appCompatEditText2 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) != null) {
            InputExtKt.MyBillsEntityDataFactory(appCompatEditText2);
        }
        FragmentVerifyReferralCodeBinding MyBillsEntityDataFactory2 = VerifyReferralCodeFragment.MyBillsEntityDataFactory(this.this$0);
        if (MyBillsEntityDataFactory2 == null || (appCompatEditText = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        final VerifyReferralCodeFragment verifyReferralCodeFragment = this.this$0;
        appCompatEditText.postDelayed(new Runnable() { // from class: id.dana.onboarding.referral.VerifyReferralCodeFragment$showReferralMessageDialog$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerifyReferralCodeFragment$showReferralMessageDialog$2.m2760invoke$lambda0(VerifyReferralCodeFragment.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2760invoke$lambda0(VerifyReferralCodeFragment verifyReferralCodeFragment) {
        AppCompatEditText appCompatEditText;
        Intrinsics.checkNotNullParameter(verifyReferralCodeFragment, "");
        FragmentVerifyReferralCodeBinding MyBillsEntityDataFactory = VerifyReferralCodeFragment.MyBillsEntityDataFactory(verifyReferralCodeFragment);
        if (MyBillsEntityDataFactory == null || (appCompatEditText = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        InputExtKt.PlaceComponentResult(appCompatEditText);
    }
}
