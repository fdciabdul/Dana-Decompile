package id.dana.nearbyme.merchantdetail.viewcomponent;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.base.AbstractContractKt;
import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.model.ProductOrderModel;
import id.dana.nearbyme.model.PromoInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantDanaDealsContract {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onCreateDanaDealsVoucherFail", "", "onCreateDanaDealsVoucherSuccess", "productOrder", "Lid/dana/nearbyme/merchantdetail/model/ProductOrderModel;", "onFailedGetMerchantPromoAndDeals", "onLoadingMerchantDanaDealFail", "onLoadingMerchantDanaDealSuccess", "listOfProductInfo", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "onSuccessGetMerchantPromoAndDeals", "shouldUpdatePromoBadge", "", "promoInfoModels", "Lid/dana/nearbyme/model/PromoInfoModel;", "productInfoModels", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(List list, List list2) {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(list2, "");
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantProductInfoModel> list);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(ProductOrderModel productOrderModel);

        void PlaceComponentResult(boolean z, List<? extends PromoInfoModel> list, List<MerchantProductInfoModel> list2);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH&J*\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "createDanaDealsVoucherOrder", "", "merchantProductInfoModel", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "disposeMerchantPromoDeals", "getMerchantDanaDealsVoucher", "merchantId", "", FeatureParams.SHOP_ID, SecurityConstants.KEY_PAGE_SIZE, "", "getMerchantPromoAndDanaDeals", "dealsPageSize", "shouldFetchPromo", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(String str, String str2, int i, boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(MerchantProductInfoModel merchantProductInfoModel);

        void getAuthRequestContext();

        void getAuthRequestContext(String str, String str2);

        /* renamed from: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }
}
