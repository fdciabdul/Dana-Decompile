package id.dana.onboarding.splash;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.sslpinning.interactor.PinCertificates;
import id.dana.domain.sslpinning.interactor.SSLPinningHotUpdate;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SslPinningHelper_Factory implements Factory<SslPinningHelper> {
    private final Provider<SSLPinningHotUpdate> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PinCertificates> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SslPinningHelper(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
