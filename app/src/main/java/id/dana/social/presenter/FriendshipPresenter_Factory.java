package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.relationship.interactor.GetActiveFollower;
import id.dana.feeds.domain.relationship.interactor.GetActiveFollowing;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationship;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationship;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.StartFollowerFullSync;
import id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync;
import id.dana.social.contract.FriendshipContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FriendshipPresenter_Factory implements Factory<FriendshipPresenter> {
    private final Provider<GetActiveFollowing> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ModifyFollowingRelationship> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ModifyFollowerRelationshipWithPublishResult> MyBillsEntityDataFactory;
    private final Provider<FriendshipContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ModifyFollowerRelationship> PlaceComponentResult;
    private final Provider<GetActiveFollower> getAuthRequestContext;
    private final Provider<ModifyFollowingRelationshipWithPublishResult> getErrorConfigVersion;
    private final Provider<StartFollowingFullSync> lookAheadTest;
    private final Provider<StartFollowerFullSync> moveToNextValue;

    private FriendshipPresenter_Factory(Provider<FriendshipContract.View> provider, Provider<StartFollowerFullSync> provider2, Provider<StartFollowingFullSync> provider3, Provider<GetActiveFollower> provider4, Provider<GetActiveFollowing> provider5, Provider<ModifyFollowerRelationship> provider6, Provider<ModifyFollowingRelationship> provider7, Provider<ModifyFollowingRelationshipWithPublishResult> provider8, Provider<ModifyFollowerRelationshipWithPublishResult> provider9) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider;
        this.moveToNextValue = provider2;
        this.lookAheadTest = provider3;
        this.getAuthRequestContext = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.PlaceComponentResult = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.getErrorConfigVersion = provider8;
        this.MyBillsEntityDataFactory = provider9;
    }

    public static FriendshipPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<FriendshipContract.View> provider, Provider<StartFollowerFullSync> provider2, Provider<StartFollowingFullSync> provider3, Provider<GetActiveFollower> provider4, Provider<GetActiveFollowing> provider5, Provider<ModifyFollowerRelationship> provider6, Provider<ModifyFollowingRelationship> provider7, Provider<ModifyFollowingRelationshipWithPublishResult> provider8, Provider<ModifyFollowerRelationshipWithPublishResult> provider9) {
        return new FriendshipPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FriendshipPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.moveToNextValue.get(), this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getErrorConfigVersion.get(), this.MyBillsEntityDataFactory.get());
    }
}
