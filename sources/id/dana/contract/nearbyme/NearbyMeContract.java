package id.dana.contract.nearbyme;

import android.content.IntentSender;
import android.location.Location;
import id.dana.base.AbstractContract;
import id.dana.domain.account.Account;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.nearbyme.LocationSourceTrackerWrapper;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.NearbyShopsModel;
import id.dana.nearbyme.model.ShopModel;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public interface NearbyMeContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(Location location);

        void BuiltInFictitiousFunctionClassFactory(NearbyShopsModel nearbyShopsModel);

        void BuiltInFictitiousFunctionClassFactory(List<MerchantCategoryModel> list, MerchantCategoryType merchantCategoryType);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void DatabaseTableConfigUtil();

        void GetContactSyncConfig();

        int KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(LocationSourceTrackerWrapper locationSourceTrackerWrapper);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<ShopModel> list);

        List<ShopModel> MyBillsEntityDataFactory(List<ShopModel> list);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(boolean z);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        String PlaceComponentResult();

        List<ShopModel> PlaceComponentResult(List<ShopModel> list, String str);

        void PlaceComponentResult(Location location);

        void PlaceComponentResult(Observable<String> observable);

        void PlaceComponentResult(String str);

        void getAuthRequestContext();

        void getAuthRequestContext(Location location);

        void getAuthRequestContext(Location location, int i, boolean z);

        void getAuthRequestContext(List<MerchantCategoryModel> list);

        void getErrorConfigVersion();

        void initRecordTimeStamp();

        boolean lookAheadTest();

        void moveToNextValue();

        boolean scheduleImpl();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {

        /* renamed from: id.dana.contract.nearbyme.NearbyMeContract$View$-CC  reason: invalid class name */
        /* loaded from: classes8.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static String MyBillsEntityDataFactory() {
                return "";
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }

            public static void getErrorConfigVersion() {
            }

            public static void scheduleImpl() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(IntentSender intentSender);

        void BuiltInFictitiousFunctionClassFactory(List<ShopModel> list);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        String KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(List<ShopModel> list);

        void MyBillsEntityDataFactory(List<ShopModel> list, boolean z);

        void MyBillsEntityDataFactory(boolean z);

        String PlaceComponentResult();

        void PlaceComponentResult(String str);

        void PlaceComponentResult(List<ShopModel> list);

        String getAuthRequestContext();

        void getAuthRequestContext(Account account);

        void getAuthRequestContext(boolean z);
    }
}
