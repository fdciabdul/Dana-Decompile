package id.dana.pay.screen;

import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.AddNewCardContract;
import id.dana.contract.payqr.AddNewCardModule;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.AddNewCardComponent;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerAddNewCardComponent;
import id.dana.pay.BasePayFragment;
import id.dana.richview.DanaProtectionView;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AddNewCardFragment extends BasePayFragment implements AddNewCardContract.View {
    private AddNewCardComponent KClassImpl$Data$declaredNonStaticMembers$2;
    private OnClickListener PlaceComponentResult;
    @Inject
    AddNewCardContract.Presenter addNewCardPresenter;
    @BindView(R.id.view_dana_protection)
    DanaProtectionView danaProtectionView;
    @BindView(R.id.iv_expresspay)
    ImageView expressPayView;
    @Inject
    OfflinePayContract.Presenter offlinePayPresenter;

    /* loaded from: classes5.dex */
    public interface OnClickListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_add_card;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public static AddNewCardFragment getAuthRequestContext(OnClickListener onClickListener) {
        AddNewCardFragment addNewCardFragment = new AddNewCardFragment();
        addNewCardFragment.PlaceComponentResult = onClickListener;
        return addNewCardFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.card_add})
    public void onParentLayoutClicked() {
        OnClickListener onClickListener = this.PlaceComponentResult;
        if (onClickListener != null) {
            onClickListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // id.dana.pay.BasePayFragment
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final void moveToNextValue() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.pay.BasePayFragment
    public final void PlaceComponentResult(boolean z) {
        this.danaProtectionView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pay.screen.AddNewCardFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaH5.startContainerFullUrl(DanaUrl.ONE_HUNDRED_PERCENT_GUARANTEE);
            }
        });
    }

    @Override // id.dana.contract.payasset.AddNewCardContract.View
    public final void PlaceComponentResult(Boolean bool) {
        this.expressPayView.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    @Override // id.dana.pay.BasePayFragment, id.dana.base.BaseFragment
    public void init() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        DaggerAddNewCardComponent.Builder PlaceComponentResult = DaggerAddNewCardComponent.PlaceComponentResult();
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (AddNewCardModule) Preconditions.getAuthRequestContext(new AddNewCardModule(this));
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (OfflinePayModule) Preconditions.getAuthRequestContext(new OfflinePayModule(new OfflinePayContract.View() { // from class: id.dana.pay.screen.AddNewCardFragment.1
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
                AddNewCardFragment.this.PlaceComponentResult(bool.booleanValue());
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, AddNewCardModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, OfflinePayModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, ApplicationComponent.class);
        DaggerAddNewCardComponent.AddNewCardComponentImpl addNewCardComponentImpl = new DaggerAddNewCardComponent.AddNewCardComponentImpl(PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.PlaceComponentResult, (byte) 0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addNewCardComponentImpl;
        addNewCardComponentImpl.PlaceComponentResult(this);
        registerPresenter(this.addNewCardPresenter, this.offlinePayPresenter);
        this.addNewCardPresenter.BuiltInFictitiousFunctionClassFactory();
        this.offlinePayPresenter.BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext(this.offlinePayPresenter);
    }
}
