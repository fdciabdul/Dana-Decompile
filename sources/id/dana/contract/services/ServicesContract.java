package id.dana.contract.services;

import android.content.Intent;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.model.ThirdPartyService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/services/ServicesContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ServicesContract {

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lid/dana/contract/services/ServicesContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onActionFailed", "", "message", "", "onActionGet", "thirdPartyService", "Lid/dana/model/ThirdPartyService;", "onActionMiniApp", "onActionPost", "authCode", "onCheckFavoriteServicesFeature", "enable", "", "onDirectOpen", "params", "", "onEmptySearchService", "onFeatureServices", "thirdPartyServices", "", "onGetFilteredThirdPartyServices", "", "onGetInitThirdPartyServices", "onGetThirdPartyServices", "onMaintenanceAction", "onShowTooltip", ContainerUIProvider.KEY_SHOW, "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.services.ServicesContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            public static void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void PlaceComponentResult() {
            }

            public static void PlaceComponentResult(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            public static void PlaceComponentResult(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void getAuthRequestContext(ThirdPartyService thirdPartyService) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            public static void getAuthRequestContext(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }
        }

        void onActionFailed(String message);

        void onActionGet(ThirdPartyService thirdPartyService);

        void onActionMiniApp(ThirdPartyService thirdPartyService);

        void onActionPost(ThirdPartyService thirdPartyService, String authCode);

        void onCheckFavoriteServicesFeature(boolean enable);

        void onDirectOpen(ThirdPartyService thirdPartyService, Map<String, String> params);

        void onEmptySearchService();

        void onFeatureServices(List<ThirdPartyService> thirdPartyServices);

        void onGetFilteredThirdPartyServices(List<ThirdPartyService> thirdPartyServices);

        void onGetInitThirdPartyServices(List<ThirdPartyService> thirdPartyServices);

        void onGetThirdPartyServices(List<ThirdPartyService> thirdPartyServices);

        void onMaintenanceAction(ThirdPartyService thirdPartyService);

        void onShowTooltip(boolean show);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&JL\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH&J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH&J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\nH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\nH&J\u001e\u0010\u0017\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u001b2\u0006\u0010\u0018\u001a\u00020\nH&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\rH&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH&J\u001e\u0010!\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u001b2\u0006\u0010#\u001a\u00020\rH\u0016J&\u0010!\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u001b2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\nH&J\b\u0010%\u001a\u00020\u0003H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\rH&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H&J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\n2\u0006\u0010'\u001a\u00020\rH&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\nH&J\b\u00101\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00062À\u0006\u0001"}, d2 = {"Lid/dana/contract/services/ServicesContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkFavoriteServicesFeature", "", "consultAndOpenEmoney", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "immediateOpen", "", "consultAndOpenMiniProgram", "action", "", "params", "", BranchLinkConstant.PayloadKey.EXTENDED_INFO, "Lorg/json/JSONObject;", "destinationPath", "orderId", "doAction", "thirdPartyService", "Lid/dana/model/ThirdPartyService;", "getCategoryServices", "isExcludeHeader", "categoryKey", "categoryKeys", "", "getFeatureServices", "getFeatureServicesRemote", "getInitThirdPartyServices", "getSearchedServices", "query", "getThirdPartyServicesFilterBy", "csvNames", "filterBy", "names", "initDataWatcherObservable", "isNeedToShowToolTip", "scenario", "mapAndCleanThirdPartyCategoryService", "thirdPartyCategoryService", "Lid/dana/domain/services/model/ThirdPartyCategoryService;", "notifyFinishCheckSession", "notifyFinishLoadCache", "saveShowToolTip", "hasShown", "setNeedToShowUi", "refresh", "updateServiceHighlighted", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(Intent intent, boolean z);

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(String str, boolean z);

        void BuiltInFictitiousFunctionClassFactory(List<String> list);

        void BuiltInFictitiousFunctionClassFactory(List<String> list, String str, boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(ThirdPartyService thirdPartyService, Map<String, String> map);

        void MyBillsEntityDataFactory(String str, String str2);

        void PlaceComponentResult();

        void PlaceComponentResult(String str);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext();

        void getAuthRequestContext(String str);

        void getAuthRequestContext(boolean z);

        void getErrorConfigVersion();

        void lookAheadTest();

        void moveToNextValue();

        void scheduleImpl();

        /* renamed from: id.dana.contract.services.ServicesContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void getAuthRequestContext(Presenter presenter, List list, String str) {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(str, "");
                presenter.BuiltInFictitiousFunctionClassFactory(list, str, false);
            }

            public static void BuiltInFictitiousFunctionClassFactory(Presenter presenter) {
                presenter.PlaceComponentResult(false);
            }

            public static void PlaceComponentResult(Presenter presenter, String str) {
                Intrinsics.checkNotNullParameter(str, "");
                presenter.BuiltInFictitiousFunctionClassFactory(str, false);
            }
        }
    }
}
