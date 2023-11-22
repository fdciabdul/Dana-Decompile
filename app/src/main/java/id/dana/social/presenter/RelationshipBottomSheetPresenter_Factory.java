package id.dana.social.presenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckFeedInboxTabFeature;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.relationship.interactor.GetReciprocalFriend;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationship;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationship;
import id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync;
import id.dana.social.contract.RelationshipBottomSheetContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class RelationshipBottomSheetPresenter_Factory implements Factory<RelationshipBottomSheetPresenter> {
    private final Provider<CheckFeedInboxTabFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ModifyFollowerRelationship> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetReciprocalFriend> MyBillsEntityDataFactory;
    private final Provider<GetSettingByKey> PlaceComponentResult;
    private final Provider<GetFeedConfig> getAuthRequestContext;
    private final Provider<ModifyFollowingRelationship> getErrorConfigVersion;
    private final Provider<StartFollowingFullSync> lookAheadTest;
    private final Provider<RelationshipBottomSheetContract.View> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RelationshipBottomSheetPresenter(DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
