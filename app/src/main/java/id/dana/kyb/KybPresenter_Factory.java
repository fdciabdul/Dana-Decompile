package id.dana.kyb;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.kyb.KybContract;
import id.dana.kyb.domain.interactor.GetKybBanner;
import id.dana.kyb.domain.interactor.GetKybCompressQrConfig;
import id.dana.kyb.domain.interactor.GetKybMerchantInfo;
import id.dana.kyb.domain.interactor.GetKybPaymentRequest;
import id.dana.kyb.domain.interactor.GetKybQrisPoster;
import id.dana.kyb.domain.interactor.GetKybServiceList;
import id.dana.kyb.domain.interactor.GetKybStartupConfig;
import id.dana.kyb.domain.interactor.GetKybTopServices;
import id.dana.kyb.domain.interactor.GetKybTransactionHistory;
import id.dana.kyb.domain.interactor.GetKybUrlsConfig;
import id.dana.kyb.domain.interactor.RefreshKybInfo;
import id.dana.kyb.domain.interactor.SaveLastKybTransactionId;
import id.dana.kyb.helper.service.strategy.KybServiceActionStrategyFactory;
import id.dana.kyb.tracker.KybTracker;
import id.dana.mapper.PromotionMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KybPresenter_Factory implements Factory<KybPresenter> {
    private final Provider<GetKybBanner> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PromotionMapper> DatabaseTableConfigUtil;
    private final Provider<KybServiceActionStrategyFactory> GetContactSyncConfig;
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetKybCompressQrConfig> MyBillsEntityDataFactory;
    private final Provider<GetKybPaymentRequest> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetKybTransactionHistory> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetKybMerchantInfo> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<SaveLastKybTransactionId> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<KybTracker> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<GetKybMerchantInfo> PlaceComponentResult;
    private final Provider<RefreshKybInfo> PrepareContext;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<GetKybStartupConfig> getErrorConfigVersion;
    private final Provider<GetKybUrlsConfig> initRecordTimeStamp;
    private final Provider<GetKybServiceList> lookAheadTest;
    private final Provider<GetKybTopServices> moveToNextValue;
    private final Provider<KybContract.View> newProxyInstance;
    private final Provider<GetKybQrisPoster> scheduleImpl;

    private KybPresenter_Factory(Provider<Context> provider, Provider<KybContract.View> provider2, Provider<GetKybStartupConfig> provider3, Provider<GetKybMerchantInfo> provider4, Provider<GetKybMerchantInfo> provider5, Provider<GetKybCompressQrConfig> provider6, Provider<GetKybTopServices> provider7, Provider<GetKybTransactionHistory> provider8, Provider<RefreshKybInfo> provider9, Provider<GetKybBanner> provider10, Provider<GetKybPaymentRequest> provider11, Provider<GetKybServiceList> provider12, Provider<GetKybQrisPoster> provider13, Provider<DeviceInformationProvider> provider14, Provider<PromotionMapper> provider15, Provider<SaveLastKybTransactionId> provider16, Provider<GetKybUrlsConfig> provider17, Provider<KybServiceActionStrategyFactory> provider18, Provider<KybTracker> provider19) {
        this.getAuthRequestContext = provider;
        this.newProxyInstance = provider2;
        this.getErrorConfigVersion = provider3;
        this.PlaceComponentResult = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.moveToNextValue = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider8;
        this.PrepareContext = provider9;
        this.BuiltInFictitiousFunctionClassFactory = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider11;
        this.lookAheadTest = provider12;
        this.scheduleImpl = provider13;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider14;
        this.DatabaseTableConfigUtil = provider15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider16;
        this.initRecordTimeStamp = provider17;
        this.GetContactSyncConfig = provider18;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider19;
    }

    public static KybPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<KybContract.View> provider2, Provider<GetKybStartupConfig> provider3, Provider<GetKybMerchantInfo> provider4, Provider<GetKybMerchantInfo> provider5, Provider<GetKybCompressQrConfig> provider6, Provider<GetKybTopServices> provider7, Provider<GetKybTransactionHistory> provider8, Provider<RefreshKybInfo> provider9, Provider<GetKybBanner> provider10, Provider<GetKybPaymentRequest> provider11, Provider<GetKybServiceList> provider12, Provider<GetKybQrisPoster> provider13, Provider<DeviceInformationProvider> provider14, Provider<PromotionMapper> provider15, Provider<SaveLastKybTransactionId> provider16, Provider<GetKybUrlsConfig> provider17, Provider<KybServiceActionStrategyFactory> provider18, Provider<KybTracker> provider19) {
        return new KybPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybPresenter(this.getAuthRequestContext.get(), this.newProxyInstance.get(), this.getErrorConfigVersion.get(), this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.PrepareContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.lookAheadTest.get(), this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.DatabaseTableConfigUtil.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), this.initRecordTimeStamp.get(), this.GetContactSyncConfig.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8));
    }
}
