package id.dana.requestmoney.bank;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.qrbarcode.interactor.GetBankQr;
import id.dana.domain.qrbarcode.interactor.GetBankTransferQr;
import id.dana.requestmoney.bank.UserBankQrContract;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class UserBankQrPresenter_Factory implements Factory<UserBankQrPresenter> {
    private final Provider<GetBankQr> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UserBankQrContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetBankTransferQr> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<ApiHitTimer> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserBankQrPresenter(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
