package id.dana.challenge.pin.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PinFamilyAccountPresenter_Factory implements Factory<PinFamilyAccountPresenter> {
    private final Provider<AcceptFamilyInvitation> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RemoveFamilyAccount> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<AbstractPinContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<RemoveFamilyMember> PlaceComponentResult;
    private final Provider<InviteFamilyAccount> getAuthRequestContext;
    private final Provider<TwilioVerifySecurityProduct> getErrorConfigVersion;

    private PinFamilyAccountPresenter_Factory(Provider<Context> provider, Provider<InviteFamilyAccount> provider2, Provider<RemoveFamilyAccount> provider3, Provider<RemoveFamilyMember> provider4, Provider<AcceptFamilyInvitation> provider5, Provider<TwilioVerifySecurityProduct> provider6, Provider<AbstractPinContract.View> provider7) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
        this.BuiltInFictitiousFunctionClassFactory = provider5;
        this.getErrorConfigVersion = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
    }

    public static PinFamilyAccountPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<InviteFamilyAccount> provider2, Provider<RemoveFamilyAccount> provider3, Provider<RemoveFamilyMember> provider4, Provider<AcceptFamilyInvitation> provider5, Provider<TwilioVerifySecurityProduct> provider6, Provider<AbstractPinContract.View> provider7) {
        return new PinFamilyAccountPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PinFamilyAccountPresenter(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
    }
}
