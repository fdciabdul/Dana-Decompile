package id.dana.appwidget;

import id.dana.appwidget.DanaAppWidgetContract;
import id.dana.appwidget.mapper.IncomeAndExpenseEntryChartModelMapper;
import id.dana.appwidget.model.IncomeAndExpenseEntryChartModel;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.HasAccount;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetAllStatementSummarySynchronously;
import id.dana.domain.statement.interactor.GetCustomStatementSummary;
import id.dana.domain.statement.model.IncomeAndExpenseStatementSummary;
import id.dana.domain.statement.model.UserStatement;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.interactor.GetBalance;
import id.dana.model.CurrencyAmountModel;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.statement.TimeUnitInterval;
import id.dana.statement.model.StatementSummaryInit;
import id.dana.statement.model.StatementViewModelKt;
import id.dana.statement.model.UserStatementModel;
import id.dana.statement.model.UserStatementModelKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\u0019\u0012\u0006\u0010)\u001a\u00020\u0011\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0013\u0012\u0006\u0010,\u001a\u00020\u001b\u0012\u0006\u0010-\u001a\u00020\u0017\u0012\u0006\u0010.\u001a\u00020#\u0012\u0006\u0010/\u001a\u00020\u001f¢\u0006\u0004\b0\u00101J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\bR\u0014\u0010\t\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\f\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010$R\u0014\u0010 \u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010'"}, d2 = {"Lid/dana/appwidget/DanaAppWidgetPresenter;", "Lid/dana/appwidget/DanaAppWidgetContract$Presenter;", "", "Lid/dana/domain/statement/model/UserStatement;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "", "p0", "getAuthRequestContext", "Lkotlin/Function0;", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "Lid/dana/domain/statement/interactor/GetAllStatementDetail;", "Lid/dana/domain/statement/interactor/GetAllStatementDetail;", "Lid/dana/domain/statement/interactor/GetAllStatementSummary;", "Lid/dana/domain/statement/interactor/GetAllStatementSummary;", "Lid/dana/domain/statement/interactor/GetAllStatementSummarySynchronously;", "Lid/dana/domain/statement/interactor/GetAllStatementSummarySynchronously;", "Lid/dana/domain/user/interactor/GetBalance;", "Lid/dana/domain/user/interactor/GetBalance;", "Lid/dana/domain/statement/interactor/GetCustomStatementSummary;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/statement/interactor/GetCustomStatementSummary;", "moveToNextValue", "Lid/dana/domain/account/interactor/HasAccount;", "lookAheadTest", "Lid/dana/domain/account/interactor/HasAccount;", "scheduleImpl", "Lid/dana/appwidget/mapper/IncomeAndExpenseEntryChartModelMapper;", "Lid/dana/appwidget/mapper/IncomeAndExpenseEntryChartModelMapper;", "getErrorConfigVersion", "Lid/dana/appwidget/DanaAppWidgetContract$View;", "Lid/dana/appwidget/DanaAppWidgetContract$View;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Lid/dana/appwidget/DanaAppWidgetContract$View;Lid/dana/domain/user/interactor/GetBalance;Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;Lid/dana/domain/statement/interactor/GetAllStatementSummary;Lid/dana/domain/statement/interactor/GetAllStatementDetail;Lid/dana/domain/statement/interactor/GetCustomStatementSummary;Lid/dana/domain/statement/interactor/GetAllStatementSummarySynchronously;Lid/dana/appwidget/mapper/IncomeAndExpenseEntryChartModelMapper;Lid/dana/domain/account/interactor/HasAccount;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DanaAppWidgetPresenter implements DanaAppWidgetContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CurrencyAmountModelMapper PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetAllStatementDetail BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetAllStatementSummary KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetCustomStatementSummary moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetAllStatementSummarySynchronously getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetBalance MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final DanaAppWidgetContract.View lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final HasAccount scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final IncomeAndExpenseEntryChartModelMapper getErrorConfigVersion;

    @Inject
    public DanaAppWidgetPresenter(DanaAppWidgetContract.View view, GetBalance getBalance, CurrencyAmountModelMapper currencyAmountModelMapper, GetAllStatementSummary getAllStatementSummary, GetAllStatementDetail getAllStatementDetail, GetCustomStatementSummary getCustomStatementSummary, GetAllStatementSummarySynchronously getAllStatementSummarySynchronously, IncomeAndExpenseEntryChartModelMapper incomeAndExpenseEntryChartModelMapper, HasAccount hasAccount) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getBalance, "");
        Intrinsics.checkNotNullParameter(currencyAmountModelMapper, "");
        Intrinsics.checkNotNullParameter(getAllStatementSummary, "");
        Intrinsics.checkNotNullParameter(getAllStatementDetail, "");
        Intrinsics.checkNotNullParameter(getCustomStatementSummary, "");
        Intrinsics.checkNotNullParameter(getAllStatementSummarySynchronously, "");
        Intrinsics.checkNotNullParameter(incomeAndExpenseEntryChartModelMapper, "");
        Intrinsics.checkNotNullParameter(hasAccount, "");
        this.lookAheadTest = view;
        this.MyBillsEntityDataFactory = getBalance;
        this.PlaceComponentResult = currencyAmountModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getAllStatementSummary;
        this.BuiltInFictitiousFunctionClassFactory = getAllStatementDetail;
        this.moveToNextValue = getCustomStatementSummary;
        this.getAuthRequestContext = getAllStatementSummarySynchronously;
        this.getErrorConfigVersion = incomeAndExpenseEntryChartModelMapper;
        this.scheduleImpl = hasAccount;
    }

    @Override // id.dana.appwidget.DanaAppWidgetContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<CurrencyAmount>() { // from class: id.dana.appwidget.DanaAppWidgetPresenter$getBalance$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                DanaAppWidgetContract.View view;
                CurrencyAmountModelMapper currencyAmountModelMapper;
                CurrencyAmount currencyAmount = (CurrencyAmount) obj;
                Intrinsics.checkNotNullParameter(currencyAmount, "");
                view = DanaAppWidgetPresenter.this.lookAheadTest;
                currencyAmountModelMapper = DanaAppWidgetPresenter.this.PlaceComponentResult;
                CurrencyAmountModel apply = currencyAmountModelMapper.apply(currencyAmount);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.MyBillsEntityDataFactory(apply);
            }
        });
    }

    @Override // id.dana.appwidget.DanaAppWidgetContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        StatementSummaryInit statementSummaryInit = new StatementSummaryInit(Calendar.getInstance().getTimeInMillis(), TimeUnitInterval.MONTH, StatementType.EXPENSE);
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new GetAllStatementSummary.Params(statementSummaryInit.BuiltInFictitiousFunctionClassFactory(), statementSummaryInit.BuiltInFictitiousFunctionClassFactory.name()), new Function1<List<? extends UserStatement>, Unit>() { // from class: id.dana.appwidget.DanaAppWidgetPresenter$getAllDanaStatementSummary$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserStatement> list) {
                invoke2((List<UserStatement>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserStatement> list) {
                DanaAppWidgetContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                List<UserStatementModel> MyBillsEntityDataFactory = UserStatementModelKt.MyBillsEntityDataFactory(list);
                view = DanaAppWidgetPresenter.this.lookAheadTest;
                view.getAuthRequestContext(StatementViewModelKt.PlaceComponentResult(MyBillsEntityDataFactory));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.appwidget.DanaAppWidgetPresenter$getAllDanaStatementSummary$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
            }
        });
    }

    @Override // id.dana.appwidget.DanaAppWidgetContract.Presenter
    public final void getAuthRequestContext() {
        List<String> KClassImpl$Data$declaredNonStaticMembers$2 = DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(), 3, "MMyyyy", Boolean.TRUE);
        this.lookAheadTest.showProgress();
        this.moveToNextValue.execute(new GetCustomStatementSummary.Params((ArrayList) KClassImpl$Data$declaredNonStaticMembers$2, TimeUnitInterval.MONTH.name()), new Function1<IncomeAndExpenseStatementSummary, Unit>() { // from class: id.dana.appwidget.DanaAppWidgetPresenter$getStatementSummaryForEveryMonthFromNMonthAgo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(IncomeAndExpenseStatementSummary incomeAndExpenseStatementSummary) {
                invoke2(incomeAndExpenseStatementSummary);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(IncomeAndExpenseStatementSummary incomeAndExpenseStatementSummary) {
                DanaAppWidgetContract.View view;
                IncomeAndExpenseEntryChartModelMapper incomeAndExpenseEntryChartModelMapper;
                Intrinsics.checkNotNullParameter(incomeAndExpenseStatementSummary, "");
                view = DanaAppWidgetPresenter.this.lookAheadTest;
                incomeAndExpenseEntryChartModelMapper = DanaAppWidgetPresenter.this.getErrorConfigVersion;
                IncomeAndExpenseEntryChartModel apply = incomeAndExpenseEntryChartModelMapper.apply(incomeAndExpenseStatementSummary);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.KClassImpl$Data$declaredNonStaticMembers$2(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.appwidget.DanaAppWidgetPresenter$getStatementSummaryForEveryMonthFromNMonthAgo$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
            }
        });
    }

    @Override // id.dana.appwidget.DanaAppWidgetContract.Presenter
    public final void MyBillsEntityDataFactory(final Function0<Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.scheduleImpl.execute(new DefaultObserver<Boolean>() { // from class: id.dana.appwidget.DanaAppWidgetPresenter$loadLoginStatus$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                DanaAppWidgetContract.View view;
                if (!((Boolean) obj).booleanValue()) {
                    view = this.lookAheadTest;
                    view.KClassImpl$Data$declaredNonStaticMembers$2();
                    return;
                }
                p0.invoke();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                DanaAppWidgetContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = this.lookAheadTest;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.appwidget.DanaAppWidgetContract.Presenter
    public final List<UserStatement> KClassImpl$Data$declaredNonStaticMembers$2() {
        StatementSummaryInit statementSummaryInit = new StatementSummaryInit(Calendar.getInstance().getTimeInMillis(), TimeUnitInterval.MONTH, StatementType.EXPENSE);
        return this.getAuthRequestContext.execute(statementSummaryInit.BuiltInFictitiousFunctionClassFactory(), statementSummaryInit.BuiltInFictitiousFunctionClassFactory.name());
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.scheduleImpl.dispose();
        this.moveToNextValue.dispose();
    }
}
