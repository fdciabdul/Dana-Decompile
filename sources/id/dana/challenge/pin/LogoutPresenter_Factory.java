package id.dana.challenge.pin;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.challenge.pin.LogoutContract;
import id.dana.domain.auth.face.interactor.ClearFaceAuthSuggestionState;
import id.dana.utils.session.SessionManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class LogoutPresenter_Factory implements Factory<LogoutPresenter> {
    private final Provider<ClearFaceAuthSuggestionState> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SessionManager> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<LogoutContract.View> getAuthRequestContext;

    private LogoutPresenter_Factory(Provider<LogoutContract.View> provider, Provider<SessionManager> provider2, Provider<ClearFaceAuthSuggestionState> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static LogoutPresenter_Factory getAuthRequestContext(Provider<LogoutContract.View> provider, Provider<SessionManager> provider2, Provider<ClearFaceAuthSuggestionState> provider3) {
        return new LogoutPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LogoutPresenter(this.getAuthRequestContext.get(), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
