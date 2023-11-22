package id.dana.pushverify.view.verificationlist;

import dagger.internal.Factory;
import id.dana.domain.pushverify.interactor.IsNotificationPromptDisabled;
import id.dana.domain.pushverify.interactor.SaveDisabledNotificationPromptPreference;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerificationListMainPresenter_Factory implements Factory<VerificationListMainPresenter> {
    private final Provider<SaveDisabledNotificationPromptPreference> BuiltInFictitiousFunctionClassFactory;
    private final Provider<VerificationListMainContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<IsNotificationPromptDisabled> getAuthRequestContext;

    private VerificationListMainPresenter_Factory(Provider<VerificationListMainContract.View> provider, Provider<IsNotificationPromptDisabled> provider2, Provider<SaveDisabledNotificationPromptPreference> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static VerificationListMainPresenter_Factory PlaceComponentResult(Provider<VerificationListMainContract.View> provider, Provider<IsNotificationPromptDisabled> provider2, Provider<SaveDisabledNotificationPromptPreference> provider3) {
        return new VerificationListMainPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerificationListMainPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
