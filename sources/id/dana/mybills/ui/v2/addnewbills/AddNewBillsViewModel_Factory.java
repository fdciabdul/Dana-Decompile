package id.dana.mybills.ui.v2.addnewbills;

import dagger.internal.Factory;
import id.dana.domain.services.interactor.GetServicesWithCategory;
import id.dana.domain.usereducation.interactor.GetBottomSheetOnBoardingFlow;
import id.dana.domain.usereducation.interactor.SaveDisplayBottomSheetOnBoardingFlow;
import id.dana.mybills.domain.interactor.CheckBillsUniqueValue;
import id.dana.mybills.domain.interactor.CheckUniqueValueAndInquiry;
import id.dana.mybills.domain.interactor.GetBizProductOrder;
import id.dana.mybills.domain.interactor.GetGeneralProducts;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.interactor.GetProductMobileRecharge;
import id.dana.mybills.domain.interactor.GetQuickBuyMyBills;
import id.dana.mybills.domain.interactor.GetUserCurrentBalance;
import id.dana.mybills.domain.interactor.MyBillsDateRange;
import id.dana.mybills.domain.interactor.SaveSubscription;
import id.dana.mybills.domain.interactor.SubscriptionQueryById;
import id.dana.mybills.domain.interactor.ValidateFormUseCase;
import id.dana.mybills.ui.mapper.ServiceItemMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AddNewBillsViewModel_Factory implements Factory<AddNewBillsViewModel> {
    private final Provider<CheckBillsUniqueValue> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MyBillsDateRange> DatabaseTableConfigUtil;
    private final Provider<SubscriptionQueryById> GetContactSyncConfig;
    private final Provider<GetGeneralProducts> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetBottomSheetOnBoardingFlow> MyBillsEntityDataFactory;
    private final Provider<GetProductMobileRecharge> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveSubscription> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SaveDisplayBottomSheetOnBoardingFlow> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<ValidateFormUseCase> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<GetBizProductOrder> PlaceComponentResult;
    private final Provider<CheckUniqueValueAndInquiry> getAuthRequestContext;
    private final Provider<GetQuickBuyMyBills> getErrorConfigVersion;
    private final Provider<ServiceItemMapper> initRecordTimeStamp;
    private final Provider<GetServicesWithCategory> lookAheadTest;
    private final Provider<GetUserCurrentBalance> moveToNextValue;
    private final Provider<GetHighlightPayTransaction> scheduleImpl;

    private AddNewBillsViewModel_Factory(Provider<ServiceItemMapper> provider, Provider<GetServicesWithCategory> provider2, Provider<SaveDisplayBottomSheetOnBoardingFlow> provider3, Provider<GetBottomSheetOnBoardingFlow> provider4, Provider<SaveSubscription> provider5, Provider<CheckBillsUniqueValue> provider6, Provider<GetHighlightPayTransaction> provider7, Provider<GetProductMobileRecharge> provider8, Provider<GetQuickBuyMyBills> provider9, Provider<GetBizProductOrder> provider10, Provider<GetUserCurrentBalance> provider11, Provider<GetGeneralProducts> provider12, Provider<ValidateFormUseCase> provider13, Provider<CheckUniqueValueAndInquiry> provider14, Provider<SubscriptionQueryById> provider15, Provider<MyBillsDateRange> provider16) {
        this.initRecordTimeStamp = provider;
        this.lookAheadTest = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.scheduleImpl = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider8;
        this.getErrorConfigVersion = provider9;
        this.PlaceComponentResult = provider10;
        this.moveToNextValue = provider11;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider13;
        this.getAuthRequestContext = provider14;
        this.GetContactSyncConfig = provider15;
        this.DatabaseTableConfigUtil = provider16;
    }

    public static AddNewBillsViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<ServiceItemMapper> provider, Provider<GetServicesWithCategory> provider2, Provider<SaveDisplayBottomSheetOnBoardingFlow> provider3, Provider<GetBottomSheetOnBoardingFlow> provider4, Provider<SaveSubscription> provider5, Provider<CheckBillsUniqueValue> provider6, Provider<GetHighlightPayTransaction> provider7, Provider<GetProductMobileRecharge> provider8, Provider<GetQuickBuyMyBills> provider9, Provider<GetBizProductOrder> provider10, Provider<GetUserCurrentBalance> provider11, Provider<GetGeneralProducts> provider12, Provider<ValidateFormUseCase> provider13, Provider<CheckUniqueValueAndInquiry> provider14, Provider<SubscriptionQueryById> provider15, Provider<MyBillsDateRange> provider16) {
        return new AddNewBillsViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AddNewBillsViewModel(this.initRecordTimeStamp.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.MyBillsEntityDataFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get(), this.PlaceComponentResult.get(), this.moveToNextValue.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), this.getAuthRequestContext.get(), this.GetContactSyncConfig.get(), this.DatabaseTableConfigUtil.get());
    }
}
