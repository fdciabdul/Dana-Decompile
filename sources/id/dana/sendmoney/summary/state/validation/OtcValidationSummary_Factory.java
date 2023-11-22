package id.dana.sendmoney.summary.state.validation;

import dagger.internal.Factory;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class OtcValidationSummary_Factory implements Factory<OtcValidationSummary> {
    private final Provider<SendMoneySummaryContract.Presenter> BuiltInFictitiousFunctionClassFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtcValidationSummary(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
