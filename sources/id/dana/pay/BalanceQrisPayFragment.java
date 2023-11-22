package id.dana.pay;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payasset.ChangePayMethodModule;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.contract.payqr.GetPaymentResultModule;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.payqr.PayQrModule;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.contract.user.GetUserInfoModule;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.BalancePayComponent;
import id.dana.di.component.DaggerBalancePayComponent;
import id.dana.model.UserInfo;
import id.dana.pay.view.BasePayView;
import id.dana.richview.ToggleBalanceView;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class BalanceQrisPayFragment extends BasePayFragment {
    private BalancePayComponent KClassImpl$Data$declaredNonStaticMembers$2;
    private String PlaceComponentResult;
    @Inject
    ChangePayMethodContract.Presenter changePayMethodPresenter;
    @Inject
    DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    GetPaymentResultContract.Presenter getPaymentResultPresenter;
    @Inject
    GetUserInfoContract.Presenter getUserInfoPresenter;
    private boolean lookAheadTest;
    @Inject
    OfflinePayContract.Presenter offlinePayPresenter;
    @BindView(R.id.pay_id)
    TextView payIdView;
    @Inject
    PayQrContract.Presenter payQrPresenter;
    @BindView(R.id.pay_qr_barcode)
    BasePayView qrBarcodePayView;
    @BindView(R.id.tbv_pay_content)
    ToggleBalanceView tbvPayContent;

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_qris_balance_pay;
    }

    static /* synthetic */ boolean getAuthRequestContext(BalanceQrisPayFragment balanceQrisPayFragment) {
        balanceQrisPayFragment.lookAheadTest = true;
        return true;
    }

    public static BalanceQrisPayFragment KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("balance_key", str);
        BalanceQrisPayFragment balanceQrisPayFragment = new BalanceQrisPayFragment();
        balanceQrisPayFragment.setArguments(bundle);
        return balanceQrisPayFragment;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.lookAheadTest) {
            this.lookAheadTest = false;
            this.qrBarcodePayView.resetQrCode();
            ToggleBalanceView toggleBalanceView = this.tbvPayContent;
            if (toggleBalanceView != null) {
                toggleBalanceView.getBalance();
            }
            GetUserInfoContract.Presenter presenter = this.getUserInfoPresenter;
            if (presenter != null) {
                presenter.PlaceComponentResult(false);
            }
            lookAheadTest();
        }
    }

    @Override // id.dana.pay.BasePayFragment
    protected final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.payQrPresenter.getAuthRequestContext(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.pay.BasePayFragment
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final void moveToNextValue() {
        this.payQrPresenter.getAuthRequestContext(this.PlaceComponentResult);
        BuiltInFictitiousFunctionClassFactory("BALANCE", "BALANCE");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.pay.BasePayFragment
    public final void PlaceComponentResult(boolean z) {
        super.init();
        try {
            this.PlaceComponentResult = getArguments().getString("balance_key");
        } catch (Exception unused) {
            if (z) {
                this.qrBarcodePayView.disableCode();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, "Error get balance pay");
            }
        }
        if (z && TextUtils.isEmpty(this.PlaceComponentResult)) {
            this.qrBarcodePayView.disableCode();
        }
    }

    @Override // id.dana.pay.BasePayFragment, id.dana.pay.PaymentMethodListener
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        super.onUnSelected();
    }

    @Override // id.dana.pay.BasePayFragment, id.dana.pay.PaymentMethodListener
    public final void PlaceComponentResult() {
        super.PlaceComponentResult();
        ToggleBalanceView toggleBalanceView = this.tbvPayContent;
        if (toggleBalanceView != null) {
            toggleBalanceView.getBalance();
        }
        GetUserInfoContract.Presenter presenter = this.getUserInfoPresenter;
        if (presenter != null) {
            presenter.PlaceComponentResult(false);
        }
        super.onSelected();
    }

    @OnClick({R.id.pay_topup_button})
    public void onClickTopup() {
        DanaH5.startContainerFullUrl(this.dynamicUrlWrapper.getTopupUrl(TopupSource.DANA_PAY));
    }

    @Override // id.dana.pay.BasePayFragment, id.dana.base.BaseFragment
    public void init() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        DaggerBalancePayComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerBalancePayComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (GetPaymentResultModule) Preconditions.getAuthRequestContext(new GetPaymentResultModule(new GetPaymentResultContract.View() { // from class: id.dana.pay.BalanceQrisPayFragment.3
            @Override // id.dana.contract.payqr.GetPaymentResultContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4) {
            }

            @Override // id.dana.contract.payqr.GetPaymentResultContract.View
            public final void PlaceComponentResult(String str, String str2, String str3) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
            }

            @Override // id.dana.contract.payqr.GetPaymentResultContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, String str4) {
                BalanceQrisPayFragment.getAuthRequestContext(BalanceQrisPayFragment.this);
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (OfflinePayModule) Preconditions.getAuthRequestContext(new OfflinePayModule(new OfflinePayContract.View() { // from class: id.dana.pay.BalanceQrisPayFragment.2
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
            }

            @Override // id.dana.contract.payqr.OfflinePayContract.View
            public final void MyBillsEntityDataFactory(Boolean bool) {
                BalanceQrisPayFragment.this.PlaceComponentResult(bool.booleanValue());
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (PayQrModule) Preconditions.getAuthRequestContext(new PayQrModule(new PaymentCodeHolder(this)));
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (GetUserInfoModule) Preconditions.getAuthRequestContext(new GetUserInfoModule(new GetUserInfoContract.View() { // from class: id.dana.pay.BalanceQrisPayFragment.1
            @Override // id.dana.contract.user.GetUserInfoContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(UserInfo userInfo) {
                BalanceQrisPayFragment.this.payIdView.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(userInfo.GetContactSyncConfig, false));
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
                if (BalanceQrisPayFragment.this.scheduleImpl()) {
                    return;
                }
                BalanceQrisPayFragment.this.qrBarcodePayView.startRefresh();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
                if (BalanceQrisPayFragment.this.scheduleImpl()) {
                    return;
                }
                BalanceQrisPayFragment.this.qrBarcodePayView.stopRefresh();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
                if (BalanceQrisPayFragment.this.scheduleImpl()) {
                    return;
                }
                BalanceQrisPayFragment.this.qrBarcodePayView.invalidCode();
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ChangePayMethodModule) Preconditions.getAuthRequestContext(new ChangePayMethodModule(new ChangePayMethodHolder(this)));
        BalancePayComponent authRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        authRequestContext.MyBillsEntityDataFactory(this);
        registerPresenter(this.getPaymentResultPresenter, this.payQrPresenter, this.getUserInfoPresenter, this.changePayMethodPresenter, this.offlinePayPresenter);
        getAuthRequestContext(this.payQrPresenter);
        getAuthRequestContext(this.offlinePayPresenter);
        BuiltInFictitiousFunctionClassFactory(this.changePayMethodPresenter);
        this.offlinePayPresenter.BuiltInFictitiousFunctionClassFactory();
        this.getPaymentResultPresenter.MyBillsEntityDataFactory();
    }
}
