package id.dana.contract.payasset;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.featureconfig.interactor.GetPayCardConfig;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.payasset.interactor.GetEnableAddNewCard;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.qrpay.interactor.InitOfflinePay;
import id.dana.domain.qrpay.interactor.IsOfflinePayInitialized;
import id.dana.domain.qrpay.interactor.StopOfflinePay;
import id.dana.pay.PayCardInfoMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class QueryPayMethodPresenter_Factory implements Factory<QueryPayMethodPresenter> {
    private final Provider<InitOfflinePay> BuiltInFictitiousFunctionClassFactory;
    private final Provider<QueryPayMethodContract.View> GetContactSyncConfig;
    private final Provider<GetPayCardConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<PayCardInfoMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetEnableAddNewCard> PlaceComponentResult;
    private final Provider<DeviceInformationProvider> getAuthRequestContext;
    private final Provider<IsOfflineF2FPay> getErrorConfigVersion;
    private final Provider<StopOfflinePay> lookAheadTest;
    private final Provider<IsOfflinePayInitialized> moveToNextValue;
    private final Provider<QueryPayMethod> scheduleImpl;

    private QueryPayMethodPresenter_Factory(Provider<QueryPayMethodContract.View> provider, Provider<GetEnableAddNewCard> provider2, Provider<QueryPayMethod> provider3, Provider<PayCardInfoMapper> provider4, Provider<IsOfflineF2FPay> provider5, Provider<InitOfflinePay> provider6, Provider<DeviceInformationProvider> provider7, Provider<StopOfflinePay> provider8, Provider<IsOfflinePayInitialized> provider9, Provider<Context> provider10, Provider<GetPayCardConfig> provider11) {
        this.GetContactSyncConfig = provider;
        this.PlaceComponentResult = provider2;
        this.scheduleImpl = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider4;
        this.getErrorConfigVersion = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.getAuthRequestContext = provider7;
        this.lookAheadTest = provider8;
        this.moveToNextValue = provider9;
        this.MyBillsEntityDataFactory = provider10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider11;
    }

    public static QueryPayMethodPresenter_Factory MyBillsEntityDataFactory(Provider<QueryPayMethodContract.View> provider, Provider<GetEnableAddNewCard> provider2, Provider<QueryPayMethod> provider3, Provider<PayCardInfoMapper> provider4, Provider<IsOfflineF2FPay> provider5, Provider<InitOfflinePay> provider6, Provider<DeviceInformationProvider> provider7, Provider<StopOfflinePay> provider8, Provider<IsOfflinePayInitialized> provider9, Provider<Context> provider10, Provider<GetPayCardConfig> provider11) {
        return new QueryPayMethodPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QueryPayMethodPresenter(DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
