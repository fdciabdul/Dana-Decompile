package id.dana.contract.nearbyme;

import android.location.Location;
import id.dana.base.AbstractContractKt;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface NearbyMerchantLocationSearchContract {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0016J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0016J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "getNearbyMerchantListErrorTitle", "", "onErrorGetListLocations", "", "onErrorGetNearbyMerchantList", "onSuccessGetListLocations", "nearbyLocations", "", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "onSuccessGetMerchantListPromo", "shopsWithPromo", "Lid/dana/nearbyme/model/ShopModel;", "onSuccessGetNearbyMerchantList", "shops", "onSuccessGetReverseGeocodeByLocation", "address", "Lid/dana/domain/miniprogram/model/Address;", "onSuccessLoadMoreNearbyMerchantList", "hasMore", "", "onSuccessSearchNearbyMerchantList", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static String BuiltInFictitiousFunctionClassFactory() {
                return "";
            }

            public static void BuiltInFictitiousFunctionClassFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory(Address address) {
                Intrinsics.checkNotNullParameter(address, "");
            }

            public static void PlaceComponentResult(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void getAuthRequestContext(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }
        }

        String getNearbyMerchantListErrorTitle();

        void onErrorGetListLocations();

        void onErrorGetNearbyMerchantList();

        void onSuccessGetListLocations(List<NearbyLocation> nearbyLocations);

        void onSuccessGetMerchantListPromo(List<? extends ShopModel> shopsWithPromo);

        void onSuccessGetNearbyMerchantList(List<? extends ShopModel> shops);

        void onSuccessGetReverseGeocodeByLocation(Address address);

        void onSuccessLoadMoreNearbyMerchantList(boolean hasMore, List<? extends ShopModel> shops);

        void onSuccessSearchNearbyMerchantList(boolean hasMore, List<? extends ShopModel> shops);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0015\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\tH&J \u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH&J\"\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u0003H&J\u0016\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH&J\b\u0010\u001e\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "currentMerchantSearchPage", "", "getCurrentMerchantSearchPage", "()I", "setCurrentMerchantSearchPage", "(I)V", "getChainQueryDetail", "", "keyword", "", "currentLocation", "Landroid/location/Location;", "ontology", "appLayerCaller", "source", "getNearbyMerchantList", "getNearbyRankingConfig", "getReverseGeocodeByLocation", "location", "initUuid", "resetSearchMerchant", "searchListNearbyLocations", "searchListShop", "lastShopRanking", "setPublishSubject", "shopModels", "", "Lid/dana/nearbyme/model/ShopModel;", "subscribeToPublishSubject", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(String str, Location location, String str2);

        /* renamed from: PlaceComponentResult */
        int getKClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(String str, Location location, int i);

        void PlaceComponentResult(String str, Location location, String str2, String str3, String str4);

        void PlaceComponentResult(List<? extends ShopModel> list);

        void getAuthRequestContext();

        /* renamed from: id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
        }
    }
}
