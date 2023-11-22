package id.dana.social.contract;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.model.FeedViewHolderModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/SocialProfileContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SocialProfileContract {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&J0\u0010\u000b\u001a\u00020\u00032&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000ej\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\u0017H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0017H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/SocialProfileContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "addFriend", "", "userId", "", "approveFriendRequest", "targetUserId", "username", "cancelFriendRequest", "declineFriendRequest", "doFeedsContentAction", ShareToFeedBridge.REDIRECT_VALUE, "redirectType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getFeedConfig", "getFriendStatus", "getProfileCta", "getProfileSettingModel", "getTimelineWithDelay", "getUserProfileHeaderById", "shouldFetchFollowingCount", "", "getUserTimelineFeedByUserId", "isCurrentUserKyc", "isHasMore", "modifyFollowerRelationshipAction", "status", "Lid/dana/domain/social/ModifyRelationOperationType;", "modifyFollowingRelationshipAction", "refreshTimeline", "setShouldUseDateSection", "useDateSection", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, ModifyRelationOperationType modifyRelationOperationType);

        /* renamed from: MyBillsEntityDataFactory */
        boolean getIsLayoutRequested();

        void NetworkUserEntityData$$ExternalSyntheticLambda0(String str);

        void PlaceComponentResult();

        void PlaceComponentResult(String str);

        void PlaceComponentResult(String str, ModifyRelationOperationType modifyRelationOperationType);

        void PlaceComponentResult(String str, boolean z);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(String str, String str2);

        boolean getAuthRequestContext();

        void moveToNextValue(String str);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u000eJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000eJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000fH&¢\u0006\u0004\b\u000b\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0012H&¢\u0006\u0004\b\u0006\u0010\u0013J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&¢\u0006\u0004\b\b\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0018H&¢\u0006\u0004\b\u000b\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001bH&¢\u0006\u0004\b\u0006\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001d\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H&¢\u0006\u0004\b\n\u0010\u0016J\u0017\u0010\u0004\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001fH&¢\u0006\u0004\b\u0004\u0010 J\u000f\u0010!\u001a\u00020\u0007H&¢\u0006\u0004\b!\u0010\tJ\u001d\u0010\u0004\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014H&¢\u0006\u0004\b\u0004\u0010\u0016J\u0017\u0010\u0004\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010#J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/SocialProfileContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/utils/DisplayedErrorMessage;", "PlaceComponentResult", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "MyBillsEntityDataFactory", "scheduleImpl", "p0", "(Ljava/lang/String;)V", "Lid/dana/domain/social/model/FeedConfig;", "(Lid/dana/domain/social/model/FeedConfig;)V", "lookAheadTest", "Lid/dana/feeds/ui/model/FriendModel;", "(Lid/dana/feeds/ui/model/FriendModel;)V", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "(Ljava/util/List;)V", "moveToNextValue", "Lid/dana/domain/profilemenu/model/SettingModel;", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "(Lid/dana/feeds/ui/model/RelationshipItemModel;)V", "getErrorConfigVersion", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/domain/social/ModifyRelationOperationType;", "(Lid/dana/domain/social/ModifyRelationOperationType;)V", "DatabaseTableConfigUtil", "p1", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        String BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(FriendModel p0);

        void BuiltInFictitiousFunctionClassFactory(RelationshipItemModel p0);

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void DatabaseTableConfigUtil();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<ProfileCtaConfig> p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(SettingModel p0);

        void MyBillsEntityDataFactory(FeedConfig p0);

        void MyBillsEntityDataFactory(String p0);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        String PlaceComponentResult();

        void PlaceComponentResult(ModifyRelationOperationType p0);

        void PlaceComponentResult(String p0);

        void PlaceComponentResult(List<FeedViewHolderModel> p0);

        void getAuthRequestContext();

        void getAuthRequestContext(String p0);

        void getAuthRequestContext(List<FeedViewHolderModel> p0);

        void getErrorConfigVersion();

        void lookAheadTest();

        void moveToNextValue();

        void scheduleImpl();
    }
}
