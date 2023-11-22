package id.dana.nearbyme.merchantdetail;

import id.dana.base.AbstractContractKt;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailPromoConfigModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantDetailConfigContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "merchantDetailConfig", "", "onGetActionConfig", "(Lid/dana/domain/nearbyme/model/MerchantDetailConfig;)V", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "config", "onGetMerchantDetailPromoConfig", "(Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onGetActionConfig(MerchantDetailConfig merchantDetailConfig);

        void onGetMerchantDetailPromoConfig(MerchantDetailPromoConfigModel config);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "promoConfigModel", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "getPromoConfigModel", "()Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "setPromoConfigModel", "(Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;)V", "getActionConfig", "", "fromNearbyRevamp", "", "getMerchantDetailPromoConfigModel", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult(boolean z);

        MerchantDetailPromoConfigModel getAuthRequestContext();

        /* renamed from: id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }
}
