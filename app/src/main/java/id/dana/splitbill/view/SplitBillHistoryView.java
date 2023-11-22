package id.dana.splitbill.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseRichView;
import id.dana.base.SingleItemClickListener;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillHistoryComponent;
import id.dana.di.component.SplitBillHistoryComponent;
import id.dana.di.modules.SplitBillHistoryModule;
import id.dana.domain.account.Account;
import id.dana.domain.splitbill.model.SplitBillHistory;
import id.dana.splitbill.SplitBillHistoryContract;
import id.dana.splitbill.adapter.SplitBillHistoryAdapter;
import id.dana.splitbill.adapter.SplitBillHistoryAdapter$$ExternalSyntheticLambda0;
import id.dana.splitbill.mapper.SplitBillPayerToPayerModelMapper;
import id.dana.tracker.mixpanel.MixPanelTracker;
import j$.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillHistoryView extends BaseRichView implements SplitBillHistoryContract.View {
    private Account BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Listener PlaceComponentResult;
    private SkeletonScreen getAuthRequestContext;
    @BindView(R.id.ll_history_empty_state)
    LinearLayout llBillHistoryEmptyState;
    @BindView(R.id.ll_split_bill_history_container)
    ConstraintLayout llSplitBillHistoryContainer;
    @Inject
    SplitBillHistoryContract.Presenter presenter;
    @BindView(R.id.rv_split_bill_history)
    RecyclerView rvSplitBillHistory;
    SplitBillHistoryAdapter splitBillHistoryAdapter;
    SplitBillHistoryComponent splitBillHistoryComponent;
    @Inject
    SplitBillPayerToPayerModelMapper splitBillPayerToPayerModelMapper;

    /* loaded from: classes5.dex */
    public interface Listener {
        void PlaceComponentResult();

        void getAuthRequestContext(boolean z);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_split_bill_history;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    public SplitBillHistoryView(Context context) {
        super(context);
    }

    public SplitBillHistoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplitBillHistoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.splitBillHistoryComponent == null) {
            DaggerSplitBillHistoryComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSplitBillHistoryComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (SplitBillHistoryModule) Preconditions.getAuthRequestContext(new SplitBillHistoryModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, SplitBillHistoryModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            this.splitBillHistoryComponent = new DaggerSplitBillHistoryComponent.SplitBillHistoryComponentImpl(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, b);
        }
        this.splitBillHistoryComponent.PlaceComponentResult(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DaggerLoyaltyWalletDetailComponent$LoyaltyWalletDetailComponentImpl$AccountRepositoryProvider);
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(0, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        if (z) {
            this.presenter.PlaceComponentResult();
        }
    }

    public void getSplitBillHistories() {
        this.presenter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public void setListener(Listener listener) {
        this.PlaceComponentResult = listener;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen == null) {
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.rvSplitBillHistory);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.splitBillHistoryAdapter;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_split_bill_history_skeleton;
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 5;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            this.getAuthRequestContext = recyclerViewSkeletonScreen;
            return;
        }
        skeletonScreen.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
            this.getAuthRequestContext = null;
        }
    }

    private void PlaceComponentResult() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            showHistoriesSection(true);
            this.llSplitBillHistoryContainer.setVisibility(0);
            this.rvSplitBillHistory.setVisibility(8);
            this.llBillHistoryEmptyState.setVisibility(0);
            return;
        }
        showHistoriesSection(false);
        this.llSplitBillHistoryContainer.setVisibility(8);
    }

    @Override // id.dana.splitbill.SplitBillHistoryContract.View
    public void onSuccessGetAccount(Account account) {
        this.BuiltInFictitiousFunctionClassFactory = account;
    }

    public void showHistoriesSection(boolean z) {
        Listener listener = this.PlaceComponentResult;
        if (listener != null) {
            listener.getAuthRequestContext(z);
        }
    }

    @Override // id.dana.splitbill.SplitBillHistoryContract.View
    public void hideSplitBillHistories() {
        dismissProgress();
        PlaceComponentResult();
    }

    @Override // id.dana.splitbill.SplitBillHistoryContract.View
    public void onTrackDisplayedError(String str, String str2, String str3, String str4, String str5) {
        MixPanelTracker.BuiltInFictitiousFunctionClassFactory(getContext(), str, str3, str2, TrackerDataKey.Source.SPLIT_BILL_HISTORY, str5);
    }

    public Long getSuccessSplitBillCount() {
        return Long.valueOf(Collection.EL.getAuthRequestContext(this.splitBillHistoryAdapter.getItems()).getAuthRequestContext(new SplitBillHistoryAdapter$$ExternalSyntheticLambda0("SUCCESS")).GetContactSyncConfig());
    }

    public Long getInProgressSplitBillCount() {
        return Long.valueOf(Collection.EL.getAuthRequestContext(this.splitBillHistoryAdapter.getItems()).getAuthRequestContext(new SplitBillHistoryAdapter$$ExternalSyntheticLambda0("IN_PROGRESS")).GetContactSyncConfig());
    }

    public Long getExpiredSplitBillCount() {
        return Long.valueOf(Collection.EL.getAuthRequestContext(this.splitBillHistoryAdapter.getItems()).getAuthRequestContext(new SplitBillHistoryAdapter$$ExternalSyntheticLambda0("EXPIRED")).GetContactSyncConfig());
    }

    static /* synthetic */ void access$000(SplitBillHistoryView splitBillHistoryView, SplitBillHistory splitBillHistory) {
        splitBillHistoryView.getBaseActivity().startActivity(SplitBillSummaryActivity.createIntent(splitBillHistoryView.getBaseActivity(), splitBillHistory.getSplitBillId(), TrackerKey.SourceType.FROM_SPLIT_BILL_HISTORY));
    }

    @Override // id.dana.splitbill.SplitBillHistoryContract.View
    public void onSuccessGetSplitBillHistory(List<SplitBillHistory> list) {
        if (!list.isEmpty()) {
            showHistoriesSection(true);
            this.llSplitBillHistoryContainer.setVisibility(0);
            this.splitBillHistoryAdapter.setItems(list);
        } else {
            PlaceComponentResult();
        }
        this.PlaceComponentResult.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        if (this.splitBillHistoryAdapter == null) {
            SplitBillHistoryAdapter splitBillHistoryAdapter = new SplitBillHistoryAdapter();
            this.splitBillHistoryAdapter = splitBillHistoryAdapter;
            splitBillHistoryAdapter.setOnItemClickListener(new SingleItemClickListener(getBaseActivity()) { // from class: id.dana.splitbill.view.SplitBillHistoryView.1
                @Override // id.dana.base.SingleItemClickListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                    SplitBillHistoryView splitBillHistoryView = SplitBillHistoryView.this;
                    SplitBillHistoryView.access$000(splitBillHistoryView, splitBillHistoryView.splitBillHistoryAdapter.getItem(i));
                }
            });
        }
        this.rvSplitBillHistory.setNestedScrollingEnabled(false);
        this.rvSplitBillHistory.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rvSplitBillHistory.setAdapter(this.splitBillHistoryAdapter);
    }
}
