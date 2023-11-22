package id.dana.investment.presenter;

import id.dana.base.AbstractContractKt;
import id.dana.di.PerActivity;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.investment.contract.GoldInvestmentContract;
import id.dana.investment.model.UserInvestmentModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\n"}, d2 = {"Lid/dana/investment/presenter/GoldInvestmentPresenter;", "Lid/dana/investment/contract/GoldInvestmentContract$Presenter;", "", "PlaceComponentResult", "()V", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/investment/contract/GoldInvestmentContract$View;", "Lid/dana/investment/contract/GoldInvestmentContract$View;", "p0", "p1", "<init>", "(Lid/dana/investment/contract/GoldInvestmentContract$View;Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class GoldInvestmentPresenter implements GoldInvestmentContract.Presenter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetUserInvestmentSummary BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GoldInvestmentContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public GoldInvestmentPresenter(GoldInvestmentContract.View view, GetUserInvestmentSummary getUserInvestmentSummary) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInvestmentSummary, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = getUserInvestmentSummary;
    }

    @Override // id.dana.investment.contract.GoldInvestmentContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(GetUserInvestmentSummary.Params.INSTANCE.forDanaEmas(), new Function1<UserInvestmentInfo, Unit>() { // from class: id.dana.investment.presenter.GoldInvestmentPresenter$fetchGoldUserInvestmentSummary$1
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
                GoldInvestmentContract.View view;
                GoldInvestmentContract.View view2;
                Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
                view = GoldInvestmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = GoldInvestmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.BuiltInFictitiousFunctionClassFactory(UserInvestmentModelKt.KClassImpl$Data$declaredNonStaticMembers$2(userInvestmentInfo));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.investment.presenter.GoldInvestmentPresenter$fetchGoldUserInvestmentSummary$2
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
                GoldInvestmentContract.View view;
                GoldInvestmentContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = GoldInvestmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = GoldInvestmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
                DanaLog.BuiltInFictitiousFunctionClassFactory("INVESTMENT", "Fail to get gold investment summary", th);
            }
        });
    }
}
