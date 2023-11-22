package id.dana.cashier.fragment;

import android.os.Bundle;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.presenter.CashierRiskChallengePresenter;
import id.dana.domain.core.usecase.NoParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierOtpChallengeFragment$listenSmsReceiver$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CashierOtpChallengeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierOtpChallengeFragment$listenSmsReceiver$1$1(CashierOtpChallengeFragment cashierOtpChallengeFragment) {
        super(0);
        this.this$0 = cashierOtpChallengeFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final CashierRiskChallengePresenter cashierRiskChallengePresenter = this.this$0.cashierRiskChallengePresenter;
        if (cashierRiskChallengePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cashierRiskChallengePresenter = null;
        }
        cashierRiskChallengePresenter.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Bundle, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$receiveSms$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                invoke2(bundle);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Bundle bundle) {
                CashierRiskChallengeContract.View view;
                Intrinsics.checkNotNullParameter(bundle, "");
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view.PlaceComponentResult(bundle);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$receiveSms$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                CashierRiskChallengeContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view.onError(th.getMessage());
            }
        });
    }
}
