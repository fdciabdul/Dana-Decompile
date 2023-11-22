package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.data.username.UsernameCheckManager;
import id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact;
import id.dana.feeds.domain.username.interactor.ChangeUsername;
import id.dana.feeds.domain.username.interactor.CheckUsername;
import id.dana.social.contract.UsernameContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class UsernamePresenter_Factory implements Factory<UsernamePresenter> {
    private final Provider<CheckUsername> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ChangeUsername> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<InitFeedWithoutContact> MyBillsEntityDataFactory;
    private final Provider<UsernameCheckManager> PlaceComponentResult;
    private final Provider<UsernameContract.View> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UsernamePresenter(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
