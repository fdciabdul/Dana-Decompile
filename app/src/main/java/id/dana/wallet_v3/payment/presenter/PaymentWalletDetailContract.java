package id.dana.wallet_v3.payment.presenter;

import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.SceneType;
import id.dana.model.ThirdPartyService;
import id.dana.wallet_v3.model.PaymentCardModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface PaymentWalletDetailContract {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "getPaymentAssets", "()V", "getPaymentServices"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void getPaymentAssets();

        void getPaymentServices();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\r\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onErrorGetPaymentServices", "()V", "", "Lid/dana/wallet_v3/model/PaymentCardModel;", SceneType.ASSETS, "onGetPaymentAsset", "(Ljava/util/List;)V", "", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "onSuccessGetPaymentServices"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onErrorGetPaymentServices();

        void onGetPaymentAsset(List<? extends PaymentCardModel> assets);

        void onSuccessGetPaymentServices(List<ThirdPartyService> thirdPartyService);
    }
}
