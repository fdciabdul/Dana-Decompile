package id.dana.contract.globalsearch;

import android.location.Location;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.base.AbstractContractKt;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.RecentAutoComplete;
import id.dana.globalsearch.model.SearchResultModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchContract;", "", "Companion", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GlobalSearchContract {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0017H\u0016J\"\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010+\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0016\u0010-\u001a\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0!H\u0016J\b\u00100\u001a\u00020\u0003H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0017H\u0016J\u0016\u00104\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00170!H\u0016J\u0016\u00106\u001a\u00020\u00032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00170!H\u0016J\b\u00108\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00069À\u0006\u0001"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "hideBannerEntryPointPersonalizationPage", "", "onGetAvailableCategories", "categories", "", "Lcom/alibaba/fastjson/JSONObject;", "onGetDFRestaurant", "searchResult", "Lid/dana/globalsearch/model/SearchResultModel;", "onGetDFSku", "onGetFeatureEnableSuccess", "enable", "", "isHintSwipeVisible", "onGetGlobalSearchConfig", "globalSearchConfig", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "onGetOfflineMerchantCategory", "onGetOnlineMerchantCategory", "onGetPopularSearchPlaceholder", "popularSearchPlaceholder", "", "onGetPrepaidCheckoutUrl", "result", "onGetSearchBarHomeVisibility", "searchBarHomeEnabled", "onGetSearchByCategory", "onGetSeeAll", "onGetServiceCategory", "onGetSkuServices", "defaultSkuList", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "onGetTrendingOnlineMerchant", "trendingOnlineMerchant", "onMaintenanceAction", "onOpenServiceGet", "thirdPartyService", "url", "onOpenServicePost", "authCode", "onSuccess", "resetView", "showAutoCompleteData", "recentAutoCompleteList", "Lid/dana/globalsearch/model/RecentAutoComplete;", "showAutoCompleteNotFound", "showBannerEntryPointPersonalizationPage", "showKeyword", "keyword", "showPopularSearch", "populars", "showRecentSearch", "recents", "showUserPersonalizationPage", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.globalsearch.GlobalSearchContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(GlobalSearchConfig globalSearchConfig) {
                Intrinsics.checkNotNullParameter(globalSearchConfig, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyServiceResponse thirdPartyServiceResponse, String str) {
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(ThirdPartyServiceResponse thirdPartyServiceResponse, String str) {
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void MyBillsEntityDataFactory(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }

            public static void MyBillsEntityDataFactory(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            }

            public static void PlaceComponentResult() {
            }

            public static void PlaceComponentResult(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }

            public static void PlaceComponentResult(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void PlaceComponentResult(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }

            public static void getAuthRequestContext(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void lookAheadTest() {
            }

            public static void moveToNextValue() {
            }

            public static void moveToNextValue(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }

            public static void scheduleImpl() {
            }

            public static void scheduleImpl(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(SearchResultModel searchResultModel);

        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(SearchResultModel searchResultModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyServiceResponse> list);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(GlobalSearchConfig globalSearchConfig);

        void MyBillsEntityDataFactory(SearchResultModel searchResultModel);

        void MyBillsEntityDataFactory(List<String> list);

        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult(ThirdPartyServiceResponse thirdPartyServiceResponse, String str, String str2);

        void PlaceComponentResult(SearchResultModel searchResultModel);

        void PlaceComponentResult(String str);

        void PlaceComponentResult(List<RecentAutoComplete> list);

        void getAuthRequestContext();

        void getAuthRequestContext(ThirdPartyServiceResponse thirdPartyServiceResponse, String str);

        void getAuthRequestContext(SearchResultModel searchResultModel);

        void getAuthRequestContext(List<String> list);

        void getAuthRequestContext(boolean z);

        void lookAheadTest();

        void lookAheadTest(SearchResultModel searchResultModel);

        void moveToNextValue();

        void scheduleImpl();

        void scheduleImpl(SearchResultModel searchResultModel);
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J+\u0010\u0004\u001a\u00020\u00032!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0006H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J@\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J>\u0010!\u001a*\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00170\"j\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0017`#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0017H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u000eH&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0003H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0007H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "checkShouldShowUserPersonalization", "", "consultLocationPermissionSuggestionDialog", "onShouldSuggest", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldSuggest", "disposeGetSearchExecutor", "fetchAutoComplete", "keyword", "", "fetchPopularSearch", "fetchPopularSearchPlaceholder", "fetchRecentSearch", "fetchSearch", "page", "", GriverMonitorConstants.KEY_SIZE, "categories", "", "location", "Landroid/location/Location;", "fetchSearchByCategory", "category", "getAvailableServices", "getGlobalSearchConfig", "getHomeSearchBarVisibility", "getTrendingOnlineMerchant", "isFeatureEnabled", "mapPostPaidProfileKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "defaultSkuList", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "openPrepaidPage", "checkoutUrl", "openService", "paySearchInfoModel", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "refreshSearch", "removeRecentItem", "saveLocationPermissionSuggestionState", "neverShow", "setHintSwipeVisibilityState", "isVisible", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void NetworkUserEntityData$$ExternalSyntheticLambda1();

        HashMap<String, List<String>> PlaceComponentResult(List<ThirdPartyServiceResponse> list);

        void PlaceComponentResult();

        void PlaceComponentResult(String str, int i, int i2, List<String> list, Location location);

        void PlaceComponentResult(Function1<? super Boolean, Unit> function1);

        void getAuthRequestContext();

        void getAuthRequestContext(PaySearchInfoModel paySearchInfoModel);

        void getAuthRequestContext(String str);

        void getAuthRequestContext(String str, String str2);

        void getErrorConfigVersion();

        void lookAheadTest();

        void moveToNextValue();

        void scheduleImpl();

        /* renamed from: id.dana.contract.globalsearch.GlobalSearchContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static /* synthetic */ void getAuthRequestContext(Presenter presenter, String str, int i, int i2, List list, Location location, int i3) {
                int i4 = (i3 & 2) != 0 ? 1 : i;
                int i5 = (i3 & 4) != 0 ? 8 : i2;
                List list2 = list;
                if ((i3 & 8) != 0) {
                    list2 = CollectionsKt.emptyList();
                }
                List list3 = list2;
                if ((i3 & 16) != 0) {
                    location = null;
                }
                presenter.PlaceComponentResult(str, i4, i5, list3, location);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchContract$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}
