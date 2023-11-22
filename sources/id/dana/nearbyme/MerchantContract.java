package id.dana.nearbyme;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/MerchantContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantContract {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/MerchantContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "checkMerchantFilterFeatureEnable", "", "getMerchantCategories", "getNewMerchantCategories", "merchantCategoryType", "Lid/dana/domain/merchant/MerchantCategoryType;", "initNewMerchantCategories", "setShopModels", "shopModels", "", "Lid/dana/nearbyme/model/ShopModel;", "currentPage", "", "setupMerchantMapsObservable", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult(List<ShopModel> list, int i);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/MerchantContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onCheckMerchantFilterFeatureEnableSuccess", "", "enable", "", "onErrorGetNewMerchantCategories", "merchantCategoryType", "Lid/dana/domain/merchant/MerchantCategoryType;", "onFinishInitMerchantCategories", "onGetMerchantCategories", "merchantCategoryModels", "", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "onGetNewMerchantListCategories", "onGetNewMerchantMapsCategories", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.nearbyme.MerchantContract$View$-CC  reason: invalid class name */
        /* loaded from: classes9.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(MerchantCategoryType merchantCategoryType) {
                Intrinsics.checkNotNullParameter(merchantCategoryType, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void PlaceComponentResult(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }
        }

        void onCheckMerchantFilterFeatureEnableSuccess(boolean enable);

        void onErrorGetNewMerchantCategories(MerchantCategoryType merchantCategoryType);

        void onGetMerchantCategories(List<MerchantCategoryModel> merchantCategoryModels);

        void onGetNewMerchantListCategories(List<MerchantCategoryModel> merchantCategoryModels);

        void onGetNewMerchantMapsCategories(List<MerchantCategoryModel> merchantCategoryModels);
    }
}
