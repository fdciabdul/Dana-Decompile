package id.dana.investment.presenter;

import dagger.Lazy;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.investment.interactor.CheckFeatureInvestment;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.model.UserInvestmentModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000e"}, d2 = {"Lid/dana/investment/presenter/DanaPlusInvestmentPresenter;", "Lid/dana/investment/contract/InvestmentContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/investment/interactor/CheckFeatureInvestment;", "Ldagger/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/investment/contract/InvestmentContract$View;", "Lid/dana/investment/contract/InvestmentContract$View;", "p0", "p1", "p2", "<init>", "(Lid/dana/investment/contract/InvestmentContract$View;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class DanaPlusInvestmentPresenter implements InvestmentContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<GetUserInvestmentSummary> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final InvestmentContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<CheckFeatureInvestment> MyBillsEntityDataFactory;

    @Inject
    public DanaPlusInvestmentPresenter(InvestmentContract.View view, Lazy<CheckFeatureInvestment> lazy, Lazy<GetUserInvestmentSummary> lazy2) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
    }

    @Override // id.dana.investment.contract.InvestmentContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.investment.presenter.DanaPlusInvestmentPresenter$checkInvestmentFeatureEnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                InvestmentContract.View view;
                view = DanaPlusInvestmentPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.getAuthRequestContext(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.investment.presenter.DanaPlusInvestmentPresenter$checkInvestmentFeatureEnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                InvestmentContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = DanaPlusInvestmentPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
                DanaLog.BuiltInFictitiousFunctionClassFactory("INVESTMENT", "Fail to check feature investment", th);
            }
        });
    }

    @Override // id.dana.investment.contract.InvestmentContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(GetUserInvestmentSummary.Params.INSTANCE.forDanaPlus(), new Function1<UserInvestmentInfo, Unit>() { // from class: id.dana.investment.presenter.DanaPlusInvestmentPresenter$getUserInvestmentSummary$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInvestmentInfo userInvestmentInfo) {
                invoke2(userInvestmentInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInvestmentInfo userInvestmentInfo) {
                InvestmentContract.View view;
                InvestmentContract.View view2;
                Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
                view = DanaPlusInvestmentPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = DanaPlusInvestmentPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.MyBillsEntityDataFactory(UserInvestmentModelKt.KClassImpl$Data$declaredNonStaticMembers$2(userInvestmentInfo));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.investment.presenter.DanaPlusInvestmentPresenter$getUserInvestmentSummary$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                InvestmentContract.View view;
                InvestmentContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = DanaPlusInvestmentPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = DanaPlusInvestmentPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.BuiltInFictitiousFunctionClassFactory();
                DanaLog.BuiltInFictitiousFunctionClassFactory("INVESTMENT", "Fail to get investment summary", th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
