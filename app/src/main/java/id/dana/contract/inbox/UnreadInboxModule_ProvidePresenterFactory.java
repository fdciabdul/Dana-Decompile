package id.dana.contract.inbox;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.inbox.UnreadInboxContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UnreadInboxModule_ProvidePresenterFactory implements Factory<UnreadInboxContract.Presenter> {
    private final UnreadInboxModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UnreadInboxPresenter> getAuthRequestContext;

    private UnreadInboxModule_ProvidePresenterFactory(UnreadInboxModule unreadInboxModule, Provider<UnreadInboxPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = unreadInboxModule;
        this.getAuthRequestContext = provider;
    }

    public static UnreadInboxModule_ProvidePresenterFactory getAuthRequestContext(UnreadInboxModule unreadInboxModule, Provider<UnreadInboxPresenter> provider) {
        return new UnreadInboxModule_ProvidePresenterFactory(unreadInboxModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UnreadInboxContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
