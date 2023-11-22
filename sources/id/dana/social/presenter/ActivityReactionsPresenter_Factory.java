package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.reactions.interactor.GetActivityReactions;
import id.dana.feeds.domain.reactions.interactor.GetMyActivityReactionInfo;
import id.dana.social.contract.ActivityReactionsContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class ActivityReactionsPresenter_Factory implements Factory<ActivityReactionsPresenter> {
    private final Provider<GetActivityReactions> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ActivityReactionsContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMyActivityReactionInfo> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ActivityReactionsPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
