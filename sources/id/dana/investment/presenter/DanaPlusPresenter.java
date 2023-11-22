package id.dana.investment.presenter;

import dagger.Lazy;
import id.dana.domain.investment.interactor.GetUserInvestmentSummary;
import id.dana.domain.investment.model.UserInvestmentInfo;
import id.dana.investment.contract.DanaPlusContract;
import id.dana.investment.model.UserInvestmentModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b"}, d2 = {"Lid/dana/investment/presenter/DanaPlusPresenter;", "Lid/dana/investment/contract/DanaPlusContract$Presenter;", "", "PlaceComponentResult", "()V", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/investment/interactor/GetUserInvestmentSummary;", "Ldagger/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/investment/contract/DanaPlusContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaPlusPresenter implements DanaPlusContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<DanaPlusContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<GetUserInvestmentSummary> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DanaPlusPresenter(Lazy<DanaPlusContract.View> lazy, Lazy<GetUserInvestmentSummary> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
    }

    @Override // id.dana.investment.contract.DanaPlusContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().showProgress();
        this.BuiltInFictitiousFunctionClassFactory.get().execute(GetUserInvestmentSummary.Params.INSTANCE.forDanaPlusStarAm(), new Function1<UserInvestmentInfo, Unit>() { // from class: id.dana.investment.presenter.DanaPlusPresenter$getUserDanaPlusSummary$1
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
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(userInvestmentInfo, "");
                lazy = DanaPlusPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((DanaPlusContract.View) lazy.get()).dismissProgress();
                lazy2 = DanaPlusPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((DanaPlusContract.View) lazy2.get()).MyBillsEntityDataFactory(UserInvestmentModelKt.KClassImpl$Data$declaredNonStaticMembers$2(userInvestmentInfo));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.investment.presenter.DanaPlusPresenter$getUserDanaPlusSummary$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = DanaPlusPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((DanaPlusContract.View) lazy.get()).dismissProgress();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DANA_PLUS, "Fail to get dana plus summary", th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
