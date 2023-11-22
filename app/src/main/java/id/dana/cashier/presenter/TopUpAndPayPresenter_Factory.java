package id.dana.cashier.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.domain.interactor.DoTopUpSubmit;
import id.dana.cashier.domain.interactor.DoTopUpVerify;
import id.dana.cashier.domain.interactor.GetTopUpAgent;
import id.dana.cashier.domain.interactor.GetTopUpConsult;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.TopUpPayCashier;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.TopUpConsultModelMapper;
import id.dana.cashier.mapper.TopUpPayModelMapper;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TopUpAndPayPresenter_Factory implements Factory<TopUpAndPayPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TopUpAndPayContract.View> DatabaseTableConfigUtil;
    private final Provider<CashierPayModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DoTopUpVerify> MyBillsEntityDataFactory;
    private final Provider<PayQueryCashier> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<TopUpPayModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<DoTopUpSubmit> PlaceComponentResult;
    private final Provider<DanaVizTrackerImpl> getAuthRequestContext;
    private final Provider<TopUpConsultModelMapper> getErrorConfigVersion;
    private final Provider<TopUpPayCashier> initRecordTimeStamp;
    private final Provider<GetTopUpConsult> lookAheadTest;
    private final Provider<FaceAuthentication> moveToNextValue;
    private final Provider<GetTopUpAgent> scheduleImpl;

    private TopUpAndPayPresenter_Factory(Provider<Context> provider, Provider<TopUpAndPayContract.View> provider2, Provider<TopUpConsultModelMapper> provider3, Provider<TopUpPayModelMapper> provider4, Provider<GetTopUpConsult> provider5, Provider<DoTopUpSubmit> provider6, Provider<DoTopUpVerify> provider7, Provider<GetTopUpAgent> provider8, Provider<TopUpPayCashier> provider9, Provider<PayQueryCashier> provider10, Provider<CashierPayModelMapper> provider11, Provider<FaceAuthentication> provider12, Provider<DanaVizTrackerImpl> provider13) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.DatabaseTableConfigUtil = provider2;
        this.getErrorConfigVersion = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider4;
        this.lookAheadTest = provider5;
        this.PlaceComponentResult = provider6;
        this.MyBillsEntityDataFactory = provider7;
        this.scheduleImpl = provider8;
        this.initRecordTimeStamp = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider11;
        this.moveToNextValue = provider12;
        this.getAuthRequestContext = provider13;
    }

    public static TopUpAndPayPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<TopUpAndPayContract.View> provider2, Provider<TopUpConsultModelMapper> provider3, Provider<TopUpPayModelMapper> provider4, Provider<GetTopUpConsult> provider5, Provider<DoTopUpSubmit> provider6, Provider<DoTopUpVerify> provider7, Provider<GetTopUpAgent> provider8, Provider<TopUpPayCashier> provider9, Provider<PayQueryCashier> provider10, Provider<CashierPayModelMapper> provider11, Provider<FaceAuthentication> provider12, Provider<DanaVizTrackerImpl> provider13) {
        return new TopUpAndPayPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TopUpAndPayPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.DatabaseTableConfigUtil.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.lookAheadTest.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.initRecordTimeStamp.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.moveToNextValue.get(), this.getAuthRequestContext.get());
    }
}
