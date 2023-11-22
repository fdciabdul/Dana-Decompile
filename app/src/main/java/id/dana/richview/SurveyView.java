package id.dana.richview;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.OnClick;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.contract.homeinfo.HomeInfoModule;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSurveyComponent;
import id.dana.di.component.SurveyComponent;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import id.dana.model.HomeDataModel;
import id.dana.model.HomeInfo;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.sync_engine.domain.model.ConfigRepeatBackgroundJob;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;
import id.dana.utils.danah5.DanaH5Listener;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class SurveyView extends BaseRichView implements HomeInfoContract.View {
    private String MyBillsEntityDataFactory;
    @BindView(R.id.fl_home_survey)
    FrameLayout flhomeSurvey;
    private SurveyComponent getAuthRequestContext;
    @Inject
    HomeInfoContract.Presenter presenter;
    @Inject
    StartupConfigEntityData sharedPrefStartupConfig;

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_survey;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetConfigSyncContact(ConfigRepeatBackgroundJob configRepeatBackgroundJob) {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetHomeData(HomeDataModel homeDataModel) {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetIsSyncPermission() {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetProcessingTransaction(ProcessingTransactionModel processingTransactionModel) {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetSyncPermissionConfig(SyncPermissionAndChangeConfig syncPermissionAndChangeConfig) {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onShouldShowMerchant(MerchantConsultReviewModel merchantConsultReviewModel, MerchantReviewModel merchantReviewModel) {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onShowMerchantReviewCheckingError() {
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onShowTooltip(boolean z) {
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public SurveyView(Context context) {
        super(context);
    }

    public SurveyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SurveyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SurveyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.getAuthRequestContext == null) {
            DaggerSurveyComponent.Builder PlaceComponentResult = DaggerSurveyComponent.PlaceComponentResult();
            PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (HomeInfoModule) Preconditions.getAuthRequestContext(new HomeInfoModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, HomeInfoModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, ApplicationComponent.class);
            this.getAuthRequestContext = new DaggerSurveyComponent.SurveyComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.PlaceComponentResult, b);
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        super.injected(z);
    }

    public void getSurvey() {
        this.presenter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetHomeInfo(HomeInfo homeInfo) {
        if (this.sharedPrefStartupConfig.getQueryUserDataConfig().getSeperateSurveyInfo()) {
            this.presenter.getAuthRequestContext();
        } else if (homeInfo.scheduleImpl != null) {
            MyBillsEntityDataFactory(homeInfo.scheduleImpl.getAuthRequestContext(), homeInfo.scheduleImpl.PlaceComponentResult);
        } else {
            FrameLayout frameLayout = this.flhomeSurvey;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.View
    public void onGetSurveyInfo(SurveyInfoModel surveyInfoModel) {
        if (surveyInfoModel == null) {
            FrameLayout frameLayout = this.flhomeSurvey;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                return;
            }
            return;
        }
        MyBillsEntityDataFactory(surveyInfoModel.getHasActiveSurvey(), surveyInfoModel.getInnerUrl());
    }

    private void MyBillsEntityDataFactory(boolean z, String str) {
        if (z && str != null) {
            this.MyBillsEntityDataFactory = str;
            FrameLayout frameLayout = this.flhomeSurvey;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.flhomeSurvey;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    @OnClick({R.id.fl_home_survey})
    public void onClickSurvey() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(this.MyBillsEntityDataFactory);
        DanaH5.startContainerFullUrl(sb.toString(), new DanaH5Listener() { // from class: id.dana.richview.SurveyView.1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerCreated(Bundle bundle) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerDestroyed(Bundle bundle) {
                SurveyView.this.getSurvey();
            }
        });
    }
}
