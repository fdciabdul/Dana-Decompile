package id.dana.contract.homeinfo;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetPaylaterChannel;
import id.dana.domain.homeinfo.interactor.GetProcessingTransaction;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.homeinfo.interactor.GetUpdatedHomeData;
import id.dana.domain.homeinfo.interactor.GetUserConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.paylater.interactor.SetPaylaterChannel;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.mapper.HomeDataModelMapper;
import id.dana.mapper.HomeInfoMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HomeInfoPresenter_Factory implements Factory<HomeInfoPresenter> {
    private final Provider<GetMerchantReviewSummary> BuiltInFictitiousFunctionClassFactory;
    private final Provider<IsNeedToShowToolTip> DatabaseTableConfigUtil;
    private final Provider<MerchantAverageRatingMapper> GetContactSyncConfig;
    private final Provider<GetConfigRepeatBackgroundJobUseCase> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetHomeInfo> MyBillsEntityDataFactory;
    private final Provider<GetSyncPermissionConfigUseCase> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetUserConfig> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<HomeDataModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<HomeInfoContract.View> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Provider<NearbyShopsModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<SaveShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<GetIsSyncPermission> PlaceComponentResult;
    private final Provider<StartupConfigEntityData> PrepareContext;
    private final Provider<GetPaylaterChannel> getAuthRequestContext;
    private final Provider<GetSurveyInfo> getErrorConfigVersion;
    private final Provider<HomeInfoMapper> initRecordTimeStamp;
    private final Provider<SetPaylaterChannel> isLayoutRequested;
    private final Provider<GetProcessingTransaction> lookAheadTest;
    private final Provider<GetReviewableMerchantForm> moveToNextValue;
    private final Provider<SaveIsSyncPermission> newProxyInstance;
    private final Provider<GetUpdatedHomeData> scheduleImpl;

    private HomeInfoPresenter_Factory(Provider<HomeInfoContract.View> provider, Provider<GetHomeInfo> provider2, Provider<HomeInfoMapper> provider3, Provider<GetUpdatedHomeData> provider4, Provider<HomeDataModelMapper> provider5, Provider<IsNeedToShowToolTip> provider6, Provider<SaveShowToolTip> provider7, Provider<GetReviewableMerchantForm> provider8, Provider<NearbyShopsModelMapper> provider9, Provider<GetUserConfig> provider10, Provider<GetMerchantReviewSummary> provider11, Provider<GetSyncPermissionConfigUseCase> provider12, Provider<GetIsSyncPermission> provider13, Provider<SaveIsSyncPermission> provider14, Provider<GetConfigRepeatBackgroundJobUseCase> provider15, Provider<MerchantAverageRatingMapper> provider16, Provider<SetPaylaterChannel> provider17, Provider<StartupConfigEntityData> provider18, Provider<GetSurveyInfo> provider19, Provider<GetPaylaterChannel> provider20, Provider<GetProcessingTransaction> provider21) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.initRecordTimeStamp = provider3;
        this.scheduleImpl = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider5;
        this.DatabaseTableConfigUtil = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider7;
        this.moveToNextValue = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider10;
        this.BuiltInFictitiousFunctionClassFactory = provider11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider12;
        this.PlaceComponentResult = provider13;
        this.newProxyInstance = provider14;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider15;
        this.GetContactSyncConfig = provider16;
        this.isLayoutRequested = provider17;
        this.PrepareContext = provider18;
        this.getErrorConfigVersion = provider19;
        this.getAuthRequestContext = provider20;
        this.lookAheadTest = provider21;
    }

    public static HomeInfoPresenter_Factory getAuthRequestContext(Provider<HomeInfoContract.View> provider, Provider<GetHomeInfo> provider2, Provider<HomeInfoMapper> provider3, Provider<GetUpdatedHomeData> provider4, Provider<HomeDataModelMapper> provider5, Provider<IsNeedToShowToolTip> provider6, Provider<SaveShowToolTip> provider7, Provider<GetReviewableMerchantForm> provider8, Provider<NearbyShopsModelMapper> provider9, Provider<GetUserConfig> provider10, Provider<GetMerchantReviewSummary> provider11, Provider<GetSyncPermissionConfigUseCase> provider12, Provider<GetIsSyncPermission> provider13, Provider<SaveIsSyncPermission> provider14, Provider<GetConfigRepeatBackgroundJobUseCase> provider15, Provider<MerchantAverageRatingMapper> provider16, Provider<SetPaylaterChannel> provider17, Provider<StartupConfigEntityData> provider18, Provider<GetSurveyInfo> provider19, Provider<GetPaylaterChannel> provider20, Provider<GetProcessingTransaction> provider21) {
        return new HomeInfoPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeInfoPresenter(DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest));
    }
}
