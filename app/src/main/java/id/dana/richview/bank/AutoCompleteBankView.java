package id.dana.richview.bank;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import com.google.android.material.textfield.TextInputEditText;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.core.ui.constant.DialogType;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.AutoCompleteBankComponent;
import id.dana.di.component.DaggerAutoCompleteBankComponent;
import id.dana.di.modules.AutoCompleteBankModule;
import id.dana.dialog.CommonDialog;
import id.dana.richview.bank.AutoCompleteBankContract;
import id.dana.sendmoney.model.BankModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class AutoCompleteBankView extends BaseRichView implements AutoCompleteBankContract.View {
    private AutoCompleteBankComponent BuiltInFictitiousFunctionClassFactory;
    private AutoCompleteBankAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    private PublishSubject<Boolean> MyBillsEntityDataFactory;
    private PublishSubject<Boolean> PlaceComponentResult;
    @BindView(R.id.et_bank_name)
    TextInputEditText bankName;
    private boolean getAuthRequestContext;
    @BindView(R.id.iv_clear_bank_name)
    ImageView ivClearInput;
    private OnAutoCompleteBankViewListener lookAheadTest;
    @Inject
    AutoCompleteBankContract.Presenter presenter;
    @BindView(R.id.rv_bank_list)
    RecyclerView rvBankList;
    private BankModel scheduleImpl;

    /* loaded from: classes9.dex */
    public interface OnAutoCompleteBankViewListener {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_auto_complete_bank;
    }

    public AutoCompleteBankView(Context context) {
        super(context);
        this.PlaceComponentResult = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = true;
        this.MyBillsEntityDataFactory = PublishSubject.PlaceComponentResult();
    }

    public AutoCompleteBankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = true;
        this.MyBillsEntityDataFactory = PublishSubject.PlaceComponentResult();
    }

    public AutoCompleteBankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PlaceComponentResult = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = true;
        this.MyBillsEntityDataFactory = PublishSubject.PlaceComponentResult();
    }

    public AutoCompleteBankView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.PlaceComponentResult = PublishSubject.PlaceComponentResult();
        this.getAuthRequestContext = true;
        this.MyBillsEntityDataFactory = PublishSubject.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            DaggerAutoCompleteBankComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerAutoCompleteBankComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (AutoCompleteBankModule) Preconditions.getAuthRequestContext(new AutoCompleteBankModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, AutoCompleteBankModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.BuiltInFictitiousFunctionClassFactory = new DaggerAutoCompleteBankComponent.AutoCompleteBankComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, b);
        }
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this);
        registerPresenter(this.presenter);
    }

    public void performQuery(String str) {
        if (this.getAuthRequestContext) {
            if (str.length() >= 3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getFilter().filter(str);
                this.rvBankList.setVisibility(0);
                return;
            }
            this.rvBankList.setVisibility(8);
            return;
        }
        this.getAuthRequestContext = true;
    }

    public PublishSubject<Boolean> getNeedSenderNameSubject() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.richview.bank.AutoCompleteBankContract.View
    public void onGetAvailableBanksSuccess(List<BankModel> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = list;
    }

    @Override // id.dana.richview.bank.AutoCompleteBankContract.View
    public void onGetSenderNameSuccess(boolean z) {
        this.MyBillsEntityDataFactory.onNext(Boolean.valueOf(z));
    }

    @Override // id.dana.richview.bank.AutoCompleteBankContract.View
    public void onGetAvailableBanksFail(String str) {
        CommonDialog.Builder builder = new CommonDialog.Builder(getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        builder.DatabaseTableConfigUtil = DialogType.WARNING;
        new CommonDialog(builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder.scheduleImpl, builder).MyBillsEntityDataFactory();
    }

    public PublishSubject<Boolean> getBankNameVerifiedSubject() {
        return this.PlaceComponentResult;
    }

    public BankModel getSelectedBankModel() {
        return this.scheduleImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory(BankModel bankModel) {
        this.scheduleImpl = bankModel;
        this.getAuthRequestContext = false;
        this.bankName.setText(bankModel.scheduleImpl);
        this.PlaceComponentResult.onNext(Boolean.TRUE);
        this.rvBankList.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.iv_clear_bank_name})
    public void clearBankNameClick() {
        clearData();
    }

    public void clearData() {
        this.bankName.setText("");
        this.scheduleImpl = null;
        this.PlaceComponentResult.onNext(Boolean.FALSE);
        this.rvBankList.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnFocusChange({R.id.et_bank_name})
    public void editTextFocusChange(View view, boolean z) {
        this.ivClearInput.setVisibility(MyBillsEntityDataFactory(view, z) ? 0 : 8);
    }

    private boolean MyBillsEntityDataFactory(View view, boolean z) {
        return view == this.bankName && z;
    }

    public void setOnAutoCompleteBankViewListener(OnAutoCompleteBankViewListener onAutoCompleteBankViewListener) {
        this.lookAheadTest = onAutoCompleteBankViewListener;
    }

    public void setBankModels(List<BankModel> list) {
        if (list == null || list.size() <= 0) {
            this.presenter.PlaceComponentResult();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = list;
        }
    }

    public void setBankById(String str) {
        List<BankModel> items = this.KClassImpl$Data$declaredNonStaticMembers$2.getItems();
        if (items == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (BankModel bankModel : items) {
            if (str.equals(bankModel.lookAheadTest)) {
                MyBillsEntityDataFactory(bankModel);
                return;
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        AutoCompleteBankAdapter autoCompleteBankAdapter = new AutoCompleteBankAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = autoCompleteBankAdapter;
        autoCompleteBankAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.richview.bank.AutoCompleteBankView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                r0.MyBillsEntityDataFactory(AutoCompleteBankView.this.KClassImpl$Data$declaredNonStaticMembers$2.getItem(i));
            }
        });
        this.rvBankList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvBankList.setAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.rvBankList.setNestedScrollingEnabled(false);
        addDisposable(RxTextView.textChanges(this.bankName).skipInitialValue().debounce(500L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).map(new Function() { // from class: id.dana.richview.bank.AutoCompleteBankView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CharSequence) obj).toString();
            }
        }).subscribe(new Consumer() { // from class: id.dana.richview.bank.AutoCompleteBankView$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoCompleteBankView.this.performQuery((String) obj);
            }
        }));
    }
}
