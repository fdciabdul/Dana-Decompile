package id.dana.splitbill.view;

import android.content.Context;
import android.util.AttributeSet;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillSectionComponent;
import id.dana.di.component.SplitBillSectionComponent;
import id.dana.di.modules.SplitBillSectionModule;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.splitbill.SplitBillSectionContract;
import id.dana.splitbill.view.SplitBillHistoryView;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class SplitBillSectionView extends BaseRichView implements SplitBillSectionContract.View {
    private SetOnSplitBillButtonClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    private SplitBillSectionComponent PlaceComponentResult;
    private int getAuthRequestContext;
    @Inject
    public SplitBillSectionContract.Presenter presenter;
    @BindView(R.id.sbhv_bill_histories)
    SplitBillHistoryView sbhvBillHistories;

    /* loaded from: classes9.dex */
    public interface SetOnSplitBillButtonClickListener {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_split_bill_section;
    }

    @OnClick({R.id.btn_init_split_bill})
    public void onSplitBillButtonClick() {
    }

    public SplitBillSectionView(Context context) {
        super(context);
    }

    public SplitBillSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplitBillSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.PlaceComponentResult == null) {
            DaggerSplitBillSectionComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerSplitBillSectionComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (SplitBillSectionModule) Preconditions.getAuthRequestContext(new SplitBillSectionModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, SplitBillSectionModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            this.PlaceComponentResult = new DaggerSplitBillSectionComponent.SplitBillSectionComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, b);
        }
        this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.sbhvBillHistories.setListener(new SplitBillHistoryView.Listener() { // from class: id.dana.splitbill.view.SplitBillSectionView.1
            @Override // id.dana.splitbill.view.SplitBillHistoryView.Listener
            public final void PlaceComponentResult() {
            }

            @Override // id.dana.splitbill.view.SplitBillHistoryView.Listener
            public final void getAuthRequestContext(boolean z) {
                SplitBillSectionView.this.sbhvBillHistories.setVisibility(z ? 0 : 8);
            }
        });
        this.presenter.MyBillsEntityDataFactory();
    }

    public int getMaxRecipient() {
        return this.getAuthRequestContext;
    }

    public void setOnSplitBillButtonClickListener(SetOnSplitBillButtonClickListener setOnSplitBillButtonClickListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = setOnSplitBillButtonClickListener;
    }

    @Override // id.dana.splitbill.SplitBillSectionContract.View
    public void onFinishGetSplitBillConfig(SplitBillConfig splitBillConfig) {
        setVisibility(splitBillConfig.isFeatureEnable() ? 0 : 8);
        this.getAuthRequestContext = splitBillConfig.getMaxRecipient();
    }
}
