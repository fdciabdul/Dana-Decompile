package id.dana.mybills.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.mybills.interactor.CheckSplitService;
import id.dana.domain.mybills.interactor.GetBizProductOrder;
import id.dana.domain.mybills.interactor.GetHighlightPayTransaction;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.domain.mybills.interactor.GetListHighlightMyBills;
import id.dana.domain.mybills.interactor.GetMonthlyAmountMyBills;
import id.dana.domain.mybills.interactor.GetMonthlyWithConsultView;
import id.dana.domain.mybills.interactor.GetQuickBuyMyBills;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.mybills.di.MyBillsContract;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyBillsPresenter_Factory implements Factory<MyBillsPresenter> {
    private final Provider<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetListHighlightMyBills> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckSplitService> MyBillsEntityDataFactory;
    private final Provider<GetInquirySubscriptionPaylaterWithDestination> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetSingleBalance> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<CurrencyAmountModelMapper> PlaceComponentResult;
    private final Provider<GetBizProductOrder> getAuthRequestContext;
    private final Provider<GetQuickBuyMyBills> getErrorConfigVersion;
    private final Provider<MyBillsContract.View> initRecordTimeStamp;
    private final Provider<GetMonthlyWithConsultView> lookAheadTest;
    private final Provider<GetMonthlyAmountMyBills> moveToNextValue;
    private final Provider<GetHighlightPayTransaction> scheduleImpl;

    private MyBillsPresenter_Factory(Provider<MyBillsContract.View> provider, Provider<DeviceInformationProvider> provider2, Provider<GetMonthlyAmountMyBills> provider3, Provider<GetListHighlightMyBills> provider4, Provider<GetQuickBuyMyBills> provider5, Provider<CheckSplitService> provider6, Provider<GetBizProductOrder> provider7, Provider<GetHighlightPayTransaction> provider8, Provider<GetSingleBalance> provider9, Provider<CurrencyAmountModelMapper> provider10, Provider<GetMonthlyWithConsultView> provider11, Provider<GetInquirySubscriptionPaylaterWithDestination> provider12) {
        this.initRecordTimeStamp = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.moveToNextValue = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.getErrorConfigVersion = provider5;
        this.MyBillsEntityDataFactory = provider6;
        this.getAuthRequestContext = provider7;
        this.scheduleImpl = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider9;
        this.PlaceComponentResult = provider10;
        this.lookAheadTest = provider11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider12;
    }

    public static MyBillsPresenter_Factory getAuthRequestContext(Provider<MyBillsContract.View> provider, Provider<DeviceInformationProvider> provider2, Provider<GetMonthlyAmountMyBills> provider3, Provider<GetListHighlightMyBills> provider4, Provider<GetQuickBuyMyBills> provider5, Provider<CheckSplitService> provider6, Provider<GetBizProductOrder> provider7, Provider<GetHighlightPayTransaction> provider8, Provider<GetSingleBalance> provider9, Provider<CurrencyAmountModelMapper> provider10, Provider<GetMonthlyWithConsultView> provider11, Provider<GetInquirySubscriptionPaylaterWithDestination> provider12) {
        return new MyBillsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MyBillsPresenter(this.initRecordTimeStamp.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }
}
