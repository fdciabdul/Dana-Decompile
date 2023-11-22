package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.interactor.GetMutedFollowing;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationship;
import id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync;
import id.dana.social.contract.MutedFragmentContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MutedFragmentPresenter_Factory implements Factory<MutedFragmentPresenter> {
    private final Provider<MutedFragmentContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetMutedFollowing> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ModifyFollowingRelationship> MyBillsEntityDataFactory;
    private final Provider<StartFollowingFullSync> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MutedFragmentPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
