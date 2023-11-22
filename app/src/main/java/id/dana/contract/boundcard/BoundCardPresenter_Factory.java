package id.dana.contract.boundcard;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.contract.boundcard.BoundCardContract;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.card.interactor.GetDefaultCard;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption;
import id.dana.richview.boundcard.mapper.BoundCardMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class BoundCardPresenter_Factory implements Factory<BoundCardPresenter> {
    private final Provider<GetDefaultCard> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetIsCardBindingV2Enabled> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckEnableExpressPayFeature> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<BoundCardMapper> getAuthRequestContext;
    private final Provider<GetPhoneNumber> getErrorConfigVersion;
    private final Provider<SaveLastCardUsed> lookAheadTest;
    private final Provider<GetSendMoneyOption> moveToNextValue;
    private final Provider<BoundCardContract.View> scheduleImpl;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BoundCardPresenter(this.PlaceComponentResult.get(), this.scheduleImpl.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getErrorConfigVersion.get(), this.moveToNextValue.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
