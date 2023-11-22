package id.dana.sendmoney.recipient.recent;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RecentRecipientModule_ProvidePresenterFactory implements Factory<RecentRecipientContract.Presenter> {
    private final RecentRecipientModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<RecentRecipientPresenter> getAuthRequestContext;

    private RecentRecipientModule_ProvidePresenterFactory(RecentRecipientModule recentRecipientModule, Provider<RecentRecipientPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = recentRecipientModule;
        this.getAuthRequestContext = provider;
    }

    public static RecentRecipientModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(RecentRecipientModule recentRecipientModule, Provider<RecentRecipientPresenter> provider) {
        return new RecentRecipientModule_ProvidePresenterFactory(recentRecipientModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RecentRecipientContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
