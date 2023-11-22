package id.dana.social.contract.reaction;

import dagger.internal.Factory;
import id.dana.feeds.domain.reactions.interactor.AddReactions;
import id.dana.feeds.domain.reactions.interactor.DeleteReaction;
import id.dana.feeds.domain.reactions.interactor.GetReactions;
import id.dana.social.contract.reaction.ReactionsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ReactionsPresenter_Factory implements Factory<ReactionsPresenter> {
    private final Provider<ReactionsContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AddReactions> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetReactions> MyBillsEntityDataFactory;
    private final Provider<DeleteReaction> PlaceComponentResult;

    private ReactionsPresenter_Factory(Provider<ReactionsContract.View> provider, Provider<GetReactions> provider2, Provider<AddReactions> provider3, Provider<DeleteReaction> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static ReactionsPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<ReactionsContract.View> provider, Provider<GetReactions> provider2, Provider<AddReactions> provider3, Provider<DeleteReaction> provider4) {
        return new ReactionsPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ReactionsPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
    }
}
