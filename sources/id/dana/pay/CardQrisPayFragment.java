package id.dana.pay;

import android.os.Bundle;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payasset.ChangePayMethodModule;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.payqr.PayQrModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.CardPayComponent;
import id.dana.di.component.DaggerCardPayComponent;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class CardQrisPayFragment extends BasePayFragment {
    private CardPayComponent KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    ChangePayMethodContract.Presenter changePayMethodPresenter;
    @Inject
    OfflinePayContract.Presenter offlinePayPresenter;
    @Inject
    PayQrContract.Presenter payQrPresenter;

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_qris_card_pay;
    }

    public static CardQrisPayFragment MyBillsEntityDataFactory(PayCardInfo payCardInfo) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CARD_INFO", payCardInfo);
        CardQrisPayFragment cardQrisPayFragment = new CardQrisPayFragment();
        cardQrisPayFragment.setArguments(bundle);
        return cardQrisPayFragment;
    }

    @Override // id.dana.pay.BasePayFragment, id.dana.base.BaseFragment
    public void init() {
        super.init();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        DaggerCardPayComponent.Builder MyBillsEntityDataFactory = DaggerCardPayComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (PayQrModule) Preconditions.getAuthRequestContext(new PayQrModule(new PaymentCodeHolder(this)));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (OfflinePayModule) Preconditions.getAuthRequestContext(new OfflinePayModule(new OfflinePayContract.View() { // from class: id.dana.pay.CardQrisPayFragment$$ExternalSyntheticLambda0
            @Override // id.dana.contract.payqr.OfflinePayContract.View
            public final void MyBillsEntityDataFactory(Boolean bool) {
                CardQrisPayFragment.this.PlaceComponentResult(bool.booleanValue());
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ChangePayMethodModule) Preconditions.getAuthRequestContext(new ChangePayMethodModule(new ChangePayMethodHolder(this)));
        CardPayComponent KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.payQrPresenter, this.changePayMethodPresenter, this.offlinePayPresenter);
        getAuthRequestContext(this.payQrPresenter);
        BuiltInFictitiousFunctionClassFactory(this.changePayMethodPresenter);
        getAuthRequestContext(this.offlinePayPresenter);
        this.offlinePayPresenter.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.pay.BasePayFragment
    protected final void KClassImpl$Data$declaredNonStaticMembers$2() {
        PayQrContract.Presenter presenter = this.payQrPresenter;
        String str = NetworkUserEntityData$$ExternalSyntheticLambda0().PlaceComponentResult;
        str.hashCode();
        presenter.getAuthRequestContext(!str.equals("DEBIT_CARD") ? !str.equals("CREDIT_CARD") ? 3 : 2 : 1);
    }
}
