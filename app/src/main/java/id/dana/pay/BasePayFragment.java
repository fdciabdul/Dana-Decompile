package id.dana.pay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.animation.view.QrRefreshNotification;
import id.dana.animation.view.ZoomDialog;
import id.dana.base.BaseFragment;
import id.dana.contract.payasset.ChangePayMethodContract;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.PayQrContract;
import id.dana.domain.payasset.model.CardScheme;
import id.dana.pay.view.BasePayView;
import id.dana.utils.TextUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class BasePayFragment extends BaseFragment implements PayQrFacade, PaymentMethodListener {
    private ChangePayMethodContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2;
    protected PayQrContract.Presenter MyBillsEntityDataFactory;
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;
    private OfflinePayContract.Presenter PlaceComponentResult;
    @BindView(R.id.card_background)
    ImageView cardBackground;
    @BindView(R.id.iv_card_scheme_logo)
    ImageView cardSchemeLogo;
    @BindView(R.id.tv_fee_info)
    TextView feeInfoText;
    private String getErrorConfigVersion;
    @BindView(R.id.iv_expresspay)
    ImageView ivExpressPay;
    private PayCardInfo lookAheadTest;
    private int moveToNextValue = 0;
    @BindView(R.id.pay_content)
    TextView payContent;
    @BindView(R.id.pay_content_identifier)
    TextView payContentIdentifier;
    @BindView(R.id.pay_id)
    TextView payId;
    @BindView(R.id.pay_logo)
    ImageView payLogo;
    @BindView(R.id.pay_title)
    TextView payTitle;
    @BindView(R.id.tv_preferred)
    TextView preferredText;
    @BindView(R.id.pay_qr_barcode)
    BasePayView qrBarcodePayView;
    @BindView(R.id.layout_parent)
    ConstraintLayout root;
    @BindView(R.id.tv_scan_info)
    TextView scanInfoText;
    private PayCardViewItem scheduleImpl;

    static /* synthetic */ int getAuthRequestContext(BasePayFragment basePayFragment) {
        int i = basePayFragment.moveToNextValue + 1;
        basePayFragment.moveToNextValue = i;
        return i;
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        BasePayView basePayView = this.qrBarcodePayView;
        if (basePayView != null) {
            basePayView.setOnClickListener(new BasePayView.OnClickListener() { // from class: id.dana.pay.BasePayFragment.1
                @Override // id.dana.pay.view.BasePayView.OnClickListener
                public final void getAuthRequestContext() {
                    if ((BasePayFragment.this.getErrorConfigVersion == null || BasePayFragment.this.getErrorConfigVersion.isEmpty()) && !BasePayFragment.this.qrBarcodePayView.getIsLoading()) {
                        BasePayFragment.this.KClassImpl$Data$declaredNonStaticMembers$2();
                        BasePayFragment.this.qrBarcodePayView.startRefresh();
                        BasePayFragment.getAuthRequestContext(BasePayFragment.this);
                    }
                    if (BasePayFragment.this.scheduleImpl()) {
                        BasePayFragment.this.MyBillsEntityDataFactory.lookAheadTest();
                    } else {
                        BasePayFragment.this.MyBillsEntityDataFactory.scheduleImpl();
                    }
                }

                @Override // id.dana.pay.view.BasePayView.OnClickListener
                public final void PlaceComponentResult() {
                    BasePayFragment.KClassImpl$Data$declaredNonStaticMembers$2(BasePayFragment.this, false);
                }

                @Override // id.dana.pay.view.BasePayView.OnClickListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    BasePayFragment.KClassImpl$Data$declaredNonStaticMembers$2(BasePayFragment.this, true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean scheduleImpl() {
        OfflinePayContract.Presenter presenter = this.PlaceComponentResult;
        if (presenter != null) {
            return presenter.MyBillsEntityDataFactory().booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(PayQrContract.Presenter presenter) {
        this.MyBillsEntityDataFactory = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(OfflinePayContract.Presenter presenter) {
        this.PlaceComponentResult = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(ChangePayMethodContract.Presenter presenter) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = presenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(null, str, str2);
    }

    protected void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public void moveToNextValue() {
        this.MyBillsEntityDataFactory.getAuthRequestContext(this.lookAheadTest.moveToNextValue);
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest.DatabaseTableConfigUtil, this.lookAheadTest.GetContactSyncConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PlaceComponentResult(boolean z) {
        int i;
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getParcelable("CARD_INFO") == null) {
            return;
        }
        PayCardInfo payCardInfo = (PayCardInfo) arguments.getParcelable("CARD_INFO");
        this.lookAheadTest = payCardInfo;
        String str = payCardInfo.getErrorConfigVersion;
        String str2 = this.lookAheadTest.scheduleImpl;
        String str3 = this.lookAheadTest.PlaceComponentResult;
        boolean MyBillsEntityDataFactory = this.lookAheadTest.MyBillsEntityDataFactory();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.scheduleImpl = PayCardViewItemFactory.getAuthRequestContext(str, str3, MyBillsEntityDataFactory);
        this.root.setContentDescription(getString(R.string.sdet_item_institution_id, str2));
        int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.scheduleImpl.scheduleImpl);
        int BuiltInFictitiousFunctionClassFactory2 = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.scheduleImpl.PlaceComponentResult);
        InstrumentInjector.Resources_setImageResource(this.cardBackground, this.scheduleImpl.getErrorConfigVersion);
        InstrumentInjector.Resources_setImageResource(this.payLogo, this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2);
        this.payTitle.setTextColor(BuiltInFictitiousFunctionClassFactory);
        this.payId.setTextColor(BuiltInFictitiousFunctionClassFactory2);
        this.preferredText.setTextColor(BuiltInFictitiousFunctionClassFactory);
        this.payContentIdentifier.setTextColor(BuiltInFictitiousFunctionClassFactory);
        this.payContentIdentifier.setText(R.string.valid_thru);
        this.payContent.setTextColor(BuiltInFictitiousFunctionClassFactory2);
        TextView textView = this.scanInfoText;
        if (textView != null) {
            textView.setTextColor(BuiltInFictitiousFunctionClassFactory);
        }
        TextView textView2 = this.payTitle;
        String str4 = this.lookAheadTest.PlaceComponentResult;
        if ("DEBIT_CARD".equals(str4)) {
            i = R.string.debit_card;
        } else {
            i = "CREDIT_CARD".equals(str4) ? R.string.credit_card : 0;
        }
        textView2.setText(i);
        this.preferredText.setVisibility(this.lookAheadTest.BuiltInFictitiousFunctionClassFactory() ? 0 : 8);
        if (this.lookAheadTest.MyBillsEntityDataFactory()) {
            this.preferredText.setVisibility(8);
            this.ivExpressPay.setVisibility(0);
            InstrumentInjector.Resources_setImageResource(this.ivExpressPay, this.scheduleImpl.MyBillsEntityDataFactory);
        }
        String str5 = this.lookAheadTest.getAuthRequestContext;
        ImageView imageView = this.cardSchemeLogo;
        str5.hashCode();
        char c = 65535;
        switch (str5.hashCode()) {
            case -1934979172:
                if (str5.equals(CardScheme.VISA)) {
                    c = 0;
                    break;
                }
                break;
            case -1062451836:
                if (str5.equals(CardScheme.JCB)) {
                    c = 1;
                    break;
                }
                break;
            case -1003810246:
                if (str5.equals(CardScheme.AMERICAN_EXPRESS)) {
                    c = 2;
                    break;
                }
                break;
            case 70789:
                if (str5.equals(CardScheme.GPN)) {
                    c = 3;
                    break;
                }
                break;
            case 425933967:
                if (str5.equals(CardScheme.BCA)) {
                    c = 4;
                    break;
                }
                break;
            case 1067049040:
                if (str5.equals(CardScheme.MASTERCARD)) {
                    c = 5;
                    break;
                }
                break;
        }
        InstrumentInjector.Resources_setImageResource(imageView, c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c != 5 ? 0 : R.drawable.mastercard_with_border : R.drawable.bca_card_with_border : R.drawable.gpn_with_border : R.drawable.american_express_with_border : R.drawable.jcb_with_border : R.drawable.visa_with_border);
        int i2 = this.lookAheadTest.MyBillsEntityDataFactory;
        String str6 = this.lookAheadTest.lookAheadTest;
        StringBuilder sb = new StringBuilder(str6 != null ? str6 : "");
        while (sb.length() < i2) {
            sb.insert(0, "•");
        }
        this.payId.setText(new StringBuilder(TextUtil.BuiltInFictitiousFunctionClassFactory(sb.toString(), i2 - 1)).toString());
        String str7 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2;
        String str8 = this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str8.length() == 4) {
            str8 = str8.substring(2);
        }
        this.payContent.setText(String.format(getString(R.string.validity), str7, str8));
    }

    public void MyBillsEntityDataFactory() {
        if (!scheduleImpl()) {
            if (this.moveToNextValue >= 3) {
                this.qrBarcodePayView.disableCode();
            } else {
                BasePayView basePayView = this.qrBarcodePayView;
                if (basePayView != null) {
                    basePayView.invalidCode();
                }
            }
        }
        PayQrContract.Presenter presenter = this.MyBillsEntityDataFactory;
        if (presenter != null) {
            presenter.getErrorConfigVersion();
        }
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void PlaceComponentResult() {
        if (!scheduleImpl()) {
            BasePayView basePayView = this.qrBarcodePayView;
            if (basePayView != null) {
                basePayView.fetchCode();
            }
            if (this.MyBillsEntityDataFactory != null) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Observable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.pay.BasePayFragment$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        Long l = (Long) obj;
                        BasePayFragment.this.moveToNextValue();
                    }
                });
            }
        } else if (this.MyBillsEntityDataFactory != null) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            moveToNextValue();
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void getAuthRequestContext(String str) {
        BasePayView basePayView = this.qrBarcodePayView;
        if (basePayView != null) {
            basePayView.setCode(str);
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void lookAheadTest() {
        PayQrContract.Presenter presenter = this.MyBillsEntityDataFactory;
        if (presenter != null) {
            presenter.scheduleImpl();
        }
    }

    public final void getErrorConfigVersion() {
        PayQrContract.Presenter presenter = this.MyBillsEntityDataFactory;
        if (presenter != null) {
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        BasePayView basePayView = this.qrBarcodePayView;
        if (basePayView != null) {
            basePayView.startRefresh();
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        BasePayView basePayView = this.qrBarcodePayView;
        if (basePayView != null) {
            basePayView.stopRefresh();
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void getAuthRequestContext() {
        if (this.moveToNextValue >= 3) {
            this.qrBarcodePayView.disableCode();
            return;
        }
        BasePayView basePayView = this.qrBarcodePayView;
        if (basePayView != null) {
            basePayView.invalidCode();
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void PlaceComponentResult(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(QrRefreshNotification.ACTION);
        intent.putExtra(QrRefreshNotification.STATE, str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(QrRefreshNotification.DATA, str2);
        }
        if (getActivity() != null) {
            getActivity().sendBroadcast(intent);
        }
    }

    @Override // id.dana.pay.PayQrFacade
    public final void MyBillsEntityDataFactory(String str) {
        this.getErrorConfigVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PayCardInfo NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.lookAheadTest;
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BasePayFragment basePayFragment, boolean z) {
        Intent intent = new Intent(basePayFragment.getActivity(), ZoomDialog.class);
        intent.putExtra(ZoomDialog.QR_BAR_CODE, basePayFragment.qrBarcodePayView.getCode());
        intent.putExtra(ZoomDialog.QR_DISPLAYED, z);
        intent.setFlags(536870912);
        basePayFragment.startActivity(intent);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        PayQrContract.Presenter presenter = this.MyBillsEntityDataFactory;
        if (presenter != null) {
            presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        super.onDestroyView();
    }
}
