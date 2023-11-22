package id.dana.expresspurchase.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.expresspurchase.interaction.DealsExpressOrderQueryByCondition;
import id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.GetDealsShopLocation;
import id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyDeals;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyGold;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyInsurance;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import id.dana.domain.expresspurchase.interaction.ValidateGoldProduct;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ExpressPurchasePresenter_Factory implements Factory<ExpressPurchasePresenter> {
    private final Provider<GetPaylaterOfferExpressPurchase> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetAddOnOfferExpressPurchase> MyBillsEntityDataFactory;
    private final Provider<GetQuickBuyDeals> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<ValidateGoldProduct> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<DealsExpressOrderQueryByCondition> PlaceComponentResult;
    private final Provider<GetDealsShopLocation> getAuthRequestContext;
    private final Provider<GetQuickBuyGold> getErrorConfigVersion;
    private final Provider<ExpressPurchaseContract.View> initRecordTimeStamp;
    private final Provider<GetQuickBuyInsurance> lookAheadTest;
    private final Provider<SplitFacade> moveToNextValue;
    private final Provider<SaveLastActionToPreference> scheduleImpl;

    private ExpressPurchasePresenter_Factory(Provider<ExpressPurchaseContract.View> provider, Provider<Context> provider2, Provider<GetAddOnOfferExpressPurchase> provider3, Provider<SaveLastActionToPreference> provider4, Provider<GetQuickBuyInsurance> provider5, Provider<GetQuickBuyDeals> provider6, Provider<ValidateGoldProduct> provider7, Provider<GetQuickBuyGold> provider8, Provider<SplitFacade> provider9, Provider<GetPaylaterOfferExpressPurchase> provider10, Provider<DealsExpressOrderQueryByCondition> provider11, Provider<GetDealsShopLocation> provider12) {
        this.initRecordTimeStamp = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.scheduleImpl = provider4;
        this.lookAheadTest = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider7;
        this.getErrorConfigVersion = provider8;
        this.moveToNextValue = provider9;
        this.BuiltInFictitiousFunctionClassFactory = provider10;
        this.PlaceComponentResult = provider11;
        this.getAuthRequestContext = provider12;
    }

    public static ExpressPurchasePresenter_Factory PlaceComponentResult(Provider<ExpressPurchaseContract.View> provider, Provider<Context> provider2, Provider<GetAddOnOfferExpressPurchase> provider3, Provider<SaveLastActionToPreference> provider4, Provider<GetQuickBuyInsurance> provider5, Provider<GetQuickBuyDeals> provider6, Provider<ValidateGoldProduct> provider7, Provider<GetQuickBuyGold> provider8, Provider<SplitFacade> provider9, Provider<GetPaylaterOfferExpressPurchase> provider10, Provider<DealsExpressOrderQueryByCondition> provider11, Provider<GetDealsShopLocation> provider12) {
        return new ExpressPurchasePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ExpressPurchasePresenter(this.initRecordTimeStamp.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.lookAheadTest.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.getErrorConfigVersion.get(), this.moveToNextValue.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
