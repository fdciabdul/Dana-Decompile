package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.ui.model.RelationshipItemModel;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/RelationshipBottomSheetContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface RelationshipBottomSheetContract {

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/RelationshipBottomSheetContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onGetFeedInboxTabEnableSuccess", "", "enable", "", "onGetProfileSettingModelFail", "onGetProfileSettingModelSuccess", "setting", "Lid/dana/domain/profilemenu/model/SettingModel;", "onGetReciprocalItem", "relationshipItemModelList", "", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "onGetSocialFeedConfigError", "onGetSocialFeedConfigSuccess", "config", "Lid/dana/domain/social/model/FeedConfig;", "onModifyRelationshipFailed", "", "onModifyRelationshipSuccess", "operationType", "Lid/dana/domain/social/ModifyRelationOperationType;", "updateReciprocalList", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.social.contract.RelationshipBottomSheetContract$View$-CC */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(SettingModel settingModel) {
                Intrinsics.checkNotNullParameter(settingModel, "");
            }

            public static void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static String PlaceComponentResult() {
                return "";
            }

            public static void getAuthRequestContext(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }
        }

        String BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(SettingModel settingModel);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(FeedConfig feedConfig);

        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult();

        void PlaceComponentResult(List<RelationshipItemModel> list);

        void getAuthRequestContext(ModifyRelationOperationType modifyRelationOperationType);

        void getAuthRequestContext(List<RelationshipItemModel> list);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkFeedInboxTabEnable", "", "createDebouncerForSearch", "searchViewPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "", "getActiveReciprocal", "getOriginalRelationshipList", "", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "getProfileSettingModel", "key", "getSocialFeedConfig", "modifyRelationship", "userId", "operationType", "Lid/dana/domain/social/ModifyRelationOperationType;", "refreshReciprocalList", "startFetchingReciprocal", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(PublishSubject<String> publishSubject);

        void PlaceComponentResult(String str, ModifyRelationOperationType modifyRelationOperationType);

        List<RelationshipItemModel> getAuthRequestContext();

        /* renamed from: id.dana.social.contract.RelationshipBottomSheetContract$Presenter$-CC */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Presenter presenter) {
                presenter.KClassImpl$Data$declaredNonStaticMembers$2("setting_more");
            }
        }
    }
}
