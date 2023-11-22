package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerToggleBalanceVisibilityComponent;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.BalanceUtil;
import id.dana.utils.ForeignCurrencySymbolUtil;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ToggleBalanceView extends BaseRichView {
    public static final String DANA_BALANCE_TYPE = "dana";
    private MoneyViewModel MyBillsEntityDataFactory;
    private ToggleBalanceClickListener PlaceComponentResult;
    private int getAuthRequestContext;
    @Inject
    GetBalanceContract.Presenter getBalancePresenter;
    @BindView(R.id.f3902iv_hide_balance)
    ImageView ivHideBalance;
    @BindView(R.id.f4378tv_currency)
    TextView tvCurrency;
    @BindView(R.id.tv_hidden_balance)
    TextView tvHiddenBalance;
    @BindView(R.id.tv_shown_balance)
    TextView tvShownBalance;

    /* loaded from: classes5.dex */
    public interface ToggleBalanceClickListener {
        void PlaceComponentResult(boolean z);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_toggle_balance;
    }

    public ToggleBalanceView(Context context) {
        super(context);
    }

    public ToggleBalanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ToggleBalanceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ToggleBalanceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerToggleBalanceVisibilityComponent.Builder authRequestContext = DaggerToggleBalanceVisibilityComponent.getAuthRequestContext();
        authRequestContext.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.MyBillsEntityDataFactory = (GetBalanceModule) Preconditions.getAuthRequestContext(new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.richview.ToggleBalanceView.1
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

            @Override // id.dana.contract.user.GetBalanceContract.View
            public void onGetAllBalanceState(List<Boolean> list) {
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public /* synthetic */ void onGetBalanceDanaPlusActive(String str, String str2, DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                GetBalanceContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public /* synthetic */ void onGetBalanceDanaPlusError() {
                GetBalanceContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public /* synthetic */ void onGetBalanceDanaPlusUnActive(DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                GetBalanceContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public /* synthetic */ void onGetBalanceError() {
                GetBalanceContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public void onGetBalance(CurrencyAmountModel currencyAmountModel) {
                ToggleBalanceView toggleBalanceView = ToggleBalanceView.this;
                MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
                toggleBalanceView.setActiveBalance(MoneyViewModel.Companion.getAuthRequestContext(currencyAmountModel));
                ToggleBalanceView.this.tvShownBalance.setText(BalanceUtil.BuiltInFictitiousFunctionClassFactory(currencyAmountModel.MyBillsEntityDataFactory));
                ToggleBalanceView.this.tvCurrency.setText(ForeignCurrencySymbolUtil.MyBillsEntityDataFactory(""));
            }

            @Override // id.dana.contract.user.GetBalanceContract.View
            public void onGetBalanceState(Boolean bool) {
                ToggleBalanceView.access$100(ToggleBalanceView.this, bool.booleanValue(), ToggleBalanceView.this.getAuthRequestContext);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.MyBillsEntityDataFactory, GetBalanceModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, ApplicationComponent.class);
        new DaggerToggleBalanceVisibilityComponent.ToggleBalanceVisibilityComponentImpl(authRequestContext.MyBillsEntityDataFactory, authRequestContext.PlaceComponentResult, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(this.getBalancePresenter);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.BarcodeUtil$$ExternalSyntheticLambda0, 0, 0);
            try {
                this.getAuthRequestContext = obtainStyledAttributes.getInt(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        GetBalanceContract.Presenter presenter = this.getBalancePresenter;
        if (presenter != null) {
            presenter.PlaceComponentResult(Boolean.TRUE);
            this.getBalancePresenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @OnClick({R.id.f3902iv_hide_balance})
    public void onHideBalanceClick() {
        GetBalanceContract.Presenter presenter = this.getBalancePresenter;
        if (presenter != null) {
            presenter.MyBillsEntityDataFactory("dana");
        }
    }

    private void MyBillsEntityDataFactory(boolean z, int i, int i2, int i3) {
        this.tvCurrency.setTextColor(getResources().getColor(i));
        this.tvShownBalance.setTextColor(getResources().getColor(i));
        this.tvHiddenBalance.setTextColor(getResources().getColor(i));
        ImageView imageView = this.ivHideBalance;
        if (!z) {
            i2 = i3;
        }
        InstrumentInjector.Resources_setImageResource(imageView, i2);
    }

    public void getBalance() {
        GetBalanceContract.Presenter presenter = this.getBalancePresenter;
        if (presenter != null) {
            presenter.PlaceComponentResult(Boolean.TRUE);
        }
    }

    public MoneyViewModel getActiveBalance() {
        return this.MyBillsEntityDataFactory;
    }

    public void setActiveBalance(MoneyViewModel moneyViewModel) {
        this.MyBillsEntityDataFactory = moneyViewModel;
    }

    public void setToggleBalanceClickListener(ToggleBalanceClickListener toggleBalanceClickListener) {
        this.PlaceComponentResult = toggleBalanceClickListener;
    }

    static /* synthetic */ void access$100(ToggleBalanceView toggleBalanceView, boolean z, int i) {
        ToggleBalanceClickListener toggleBalanceClickListener = toggleBalanceView.PlaceComponentResult;
        if (toggleBalanceClickListener != null) {
            toggleBalanceClickListener.PlaceComponentResult(z);
        }
        toggleBalanceView.tvShownBalance.setVisibility(z ? 0 : 8);
        toggleBalanceView.tvHiddenBalance.setVisibility(z ? 8 : 0);
        if (i == 0) {
            toggleBalanceView.MyBillsEntityDataFactory(z, R.color.f27072131100488, R.drawable.ic_hide_balance, R.drawable.ic_show_balance);
        } else if (i == 1) {
            toggleBalanceView.MyBillsEntityDataFactory(z, R.color.f22832131099732, R.drawable.ic_hide_balance_gn, R.drawable.ic_show_balance_gn);
        }
    }
}
