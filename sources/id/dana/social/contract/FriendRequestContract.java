package id.dana.social.contract;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.base.AbstractContractKt;
import id.dana.feeds.ui.model.FriendModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendRequestContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FriendRequestContract {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendRequestContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onFailApproveFriendRequest", "", "targetFriendModel", "Lid/dana/feeds/ui/model/FriendModel;", "onFailDeclineFriendRequest", "onFailedFetchFriendRequest", "onSuccessApproveFriendRequest", "onSuccessDeclineFriendRequest", "onSuccessFetchFriendRequest", "friendModels", "", "isFirstPage", "", "onTrackDisplayedError", "throwable", "", "operationType", "", "source", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.social.contract.FriendRequestContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory(FriendModel friendModel) {
                Intrinsics.checkNotNullParameter(friendModel, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void MyBillsEntityDataFactory(FriendModel friendModel) {
                Intrinsics.checkNotNullParameter(friendModel, "");
            }

            public static void PlaceComponentResult() {
            }

            public static void PlaceComponentResult(Throwable th, String str, String str2) {
                Intrinsics.checkNotNullParameter(th, "");
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
            }

            public static void getAuthRequestContext(FriendModel friendModel) {
                Intrinsics.checkNotNullParameter(friendModel, "");
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel friendModel);

        void MyBillsEntityDataFactory(FriendModel friendModel);

        void MyBillsEntityDataFactory(Throwable th, String str, String str2);

        void PlaceComponentResult(FriendModel friendModel);

        void PlaceComponentResult(List<FriendModel> list, boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(FriendModel friendModel);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H&J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H&J\u0012\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001bH&J\u0012\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001d\u001a\u00020\u0016H&R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lid/dana/social/contract/FriendRequestContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "friendRequestListFirstPage", "", "Lid/dana/feeds/ui/model/FriendModel;", "getFriendRequestListFirstPage", "()Ljava/util/List;", "setFriendRequestListFirstPage", "(Ljava/util/List;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "minId", "", "getMinId", "()Ljava/lang/String;", "setMinId", "(Ljava/lang/String;)V", "approveFriendRequest", "", "targetFriendModel", "declineFriendRequest", "fetchFriendRequest", SecurityConstants.KEY_PAGE_SIZE, "", "fetchFriendRequestWithDelay", "resetFriendRequest", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(FriendModel friendModel);

        void BuiltInFictitiousFunctionClassFactory(String str);

        String KClassImpl$Data$declaredNonStaticMembers$2();

        boolean MyBillsEntityDataFactory();

        void PlaceComponentResult();

        List<FriendModel> getAuthRequestContext();

        void getAuthRequestContext(int i);

        void getAuthRequestContext(FriendModel friendModel);

        void getAuthRequestContext(boolean z);

        /* renamed from: id.dana.social.contract.FriendRequestContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }
}
