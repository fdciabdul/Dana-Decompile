package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.interactor.GetBlockedFollower;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationship;
import id.dana.feeds.domain.relationship.interactor.StartFollowerFullSync;
import id.dana.social.contract.BlockedFragmentContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BlockedFragmentPresenter_Factory implements Factory<BlockedFragmentPresenter> {
    private final Provider<ModifyFollowerRelationship> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetBlockedFollower> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<StartFollowerFullSync> PlaceComponentResult;
    private final Provider<BlockedFragmentContract.View> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BlockedFragmentPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
