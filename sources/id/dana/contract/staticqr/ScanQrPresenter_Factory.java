package id.dana.contract.staticqr;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.featureconfig.interactor.GetCashierNativeConfig;
import id.dana.domain.featureconfig.interactor.IsFeaturePaylaterCicilScannerEnabled;
import id.dana.domain.oauth.interactor.GetQrBindingConfig;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrBarcode;
import id.dana.domain.qrbarcode.interactor.GetDecodedQrisTopUp;
import id.dana.domain.qrbarcode.interactor.GetMerchantQrWhitelist;
import id.dana.domain.qrbarcode.interactor.GetNativelyDecodedQr;
import id.dana.domain.qrbarcode.interactor.GetQrisCpmSendmoneyConfig;
import id.dana.domain.qrbarcode.interactor.IsNativeDecodeEnabled;
import id.dana.domain.qrbarcode.interactor.ValidateNativelyDecodedQr;
import id.dana.domain.user.interactor.GetUserStatusInfo;
import id.dana.domain.usereducation.interactor.SaveShowDialog;
import id.dana.mapper.ScanResultMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ScanQrPresenter_Factory implements Factory<ScanQrPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserStatusInfo> DatabaseTableConfigUtil;
    private final Provider<IsNativeDecodeEnabled> GetContactSyncConfig;
    private final Provider<GetCashierNativeConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetDecodedQrBarcode> MyBillsEntityDataFactory;
    private final Provider<GetUserLoanInfo> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ScanResultMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<IsFeaturePaylaterCicilScannerEnabled> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<ValidateNativelyDecodedQr> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<DeviceInformationProvider> PlaceComponentResult;
    private final Provider<GetDecodedQrisTopUp> getAuthRequestContext;
    private final Provider<GetQrisCpmSendmoneyConfig> getErrorConfigVersion;
    private final Provider<SaveShowDialog> initRecordTimeStamp;
    private final Provider<ScanQrContract.View> isLayoutRequested;
    private final Provider<GetMerchantQrWhitelist> lookAheadTest;
    private final Provider<GetNativelyDecodedQr> moveToNextValue;
    private final Provider<GetQrBindingConfig> scheduleImpl;

    private ScanQrPresenter_Factory(Provider<Context> provider, Provider<ScanQrContract.View> provider2, Provider<GetDecodedQrBarcode> provider3, Provider<GetDecodedQrisTopUp> provider4, Provider<ScanResultMapper> provider5, Provider<DeviceInformationProvider> provider6, Provider<GetUserStatusInfo> provider7, Provider<GetCashierNativeConfig> provider8, Provider<GetNativelyDecodedQr> provider9, Provider<IsNativeDecodeEnabled> provider10, Provider<ValidateNativelyDecodedQr> provider11, Provider<GetMerchantQrWhitelist> provider12, Provider<GetQrBindingConfig> provider13, Provider<IsFeaturePaylaterCicilScannerEnabled> provider14, Provider<GetUserLoanInfo> provider15, Provider<GetQrisCpmSendmoneyConfig> provider16, Provider<SaveShowDialog> provider17) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.isLayoutRequested = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.getAuthRequestContext = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider5;
        this.PlaceComponentResult = provider6;
        this.DatabaseTableConfigUtil = provider7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider8;
        this.moveToNextValue = provider9;
        this.GetContactSyncConfig = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider11;
        this.lookAheadTest = provider12;
        this.scheduleImpl = provider13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider15;
        this.getErrorConfigVersion = provider16;
        this.initRecordTimeStamp = provider17;
    }

    public static ScanQrPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<ScanQrContract.View> provider2, Provider<GetDecodedQrBarcode> provider3, Provider<GetDecodedQrisTopUp> provider4, Provider<ScanResultMapper> provider5, Provider<DeviceInformationProvider> provider6, Provider<GetUserStatusInfo> provider7, Provider<GetCashierNativeConfig> provider8, Provider<GetNativelyDecodedQr> provider9, Provider<IsNativeDecodeEnabled> provider10, Provider<ValidateNativelyDecodedQr> provider11, Provider<GetMerchantQrWhitelist> provider12, Provider<GetQrBindingConfig> provider13, Provider<IsFeaturePaylaterCicilScannerEnabled> provider14, Provider<GetUserLoanInfo> provider15, Provider<GetQrisCpmSendmoneyConfig> provider16, Provider<SaveShowDialog> provider17) {
        return new ScanQrPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ScanQrPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp));
    }
}
