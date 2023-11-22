package id.dana.pushverify.view.verificationlist.list;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.pushverify.interactor.GetActivePushVerificationList;
import id.dana.domain.pushverify.interactor.GetHistoryPushVerificationList;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class VerificationListPresenter_Factory implements Factory<VerificationListPresenter> {
    private final Provider<PushVerifyTracker> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetActivePushVerificationList> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetHistoryPushVerificationList> MyBillsEntityDataFactory;
    private final Provider<VerificationListContract.View> getAuthRequestContext;

    private VerificationListPresenter_Factory(Provider<VerificationListContract.View> provider, Provider<PushVerifyTracker> provider2, Provider<GetActivePushVerificationList> provider3, Provider<GetHistoryPushVerificationList> provider4) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static VerificationListPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<VerificationListContract.View> provider, Provider<PushVerifyTracker> provider2, Provider<GetActivePushVerificationList> provider3, Provider<GetHistoryPushVerificationList> provider4) {
        return new VerificationListPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new VerificationListPresenter(this.getAuthRequestContext.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
