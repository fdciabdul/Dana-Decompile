package id.dana.wallet_v3.presenter;

import id.dana.base.AbstractContractKt;
import id.dana.wallet_v3.model.KtpInfoModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/presenter/KtpDetailContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface KtpDetailContract {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/presenter/KtpDetailContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "deleteKtp", "()V", "getKtpDetailAsset"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void deleteKtp();

        void getKtpDetailAsset();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/presenter/KtpDetailContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onDeleteKtpError", "()V", "onDeleteKtpSuccess", "onGetKtpDetailFailed", "Lid/dana/wallet_v3/model/KtpInfoModel;", "ktpDetail", "onGetKtpDetailSuccess", "(Lid/dana/wallet_v3/model/KtpInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onDeleteKtpError();

        void onDeleteKtpSuccess();

        void onGetKtpDetailFailed();

        void onGetKtpDetailSuccess(KtpInfoModel ktpDetail);
    }
}
