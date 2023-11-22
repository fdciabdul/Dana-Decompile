package id.dana.statement;

import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.interactor.CheckFeatureDownloadStatement;
import id.dana.domain.statement.interactor.GetAllStatementDetail;
import id.dana.domain.statement.interactor.GetAllStatementSummary;
import id.dana.domain.statement.interactor.GetStatementDetail;
import id.dana.domain.statement.interactor.GetStatementDisableDetail;
import id.dana.domain.statement.interactor.GetStatementSummary;
import id.dana.domain.statement.interactor.GetTotalStatements;
import id.dana.domain.statement.model.TotalStatement;
import id.dana.domain.statement.model.UserStatement;
import id.dana.domain.statement.model.UserStatementDetail;
import id.dana.statement.UserStatementContract;
import id.dana.statement.model.StatementSummaryInit;
import id.dana.statement.model.StatementViewModelKt;
import id.dana.statement.model.UserStatementDetailModelKt;
import id.dana.statement.model.UserStatementModel;
import id.dana.statement.model.UserStatementModelKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020$\u0012\u0006\u0010\u0007\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020\u0019\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020!\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010+\u001a\u00020\u0012\u0012\u0006\u0010,\u001a\u00020\u001b¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\rH\u0002¢\u0006\u0004\b\f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0014\u0010\u0013\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u001e\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/statement/UserStatementPresenter;", "Lid/dana/statement/UserStatementContract$Presenter;", "", "getAuthRequestContext", "()V", "", "p0", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(JJ)V", "Lid/dana/statement/model/StatementSummaryInit;", "(Lid/dana/statement/model/StatementSummaryInit;)V", "PlaceComponentResult", "Lid/dana/domain/statement/StatementType;", "", "MyBillsEntityDataFactory", "(Lid/dana/domain/statement/StatementType;)Z", "onDestroy", "Lid/dana/domain/statement/interactor/CheckFeatureDownloadStatement;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/statement/interactor/CheckFeatureDownloadStatement;", "Lid/dana/domain/statement/interactor/GetAllStatementDetail;", "Lid/dana/domain/statement/interactor/GetAllStatementDetail;", "Lid/dana/domain/statement/interactor/GetAllStatementSummary;", "Lid/dana/domain/statement/interactor/GetAllStatementSummary;", "Lid/dana/domain/statement/interactor/GetStatementDetail;", "Lid/dana/domain/statement/interactor/GetStatementDetail;", "Lid/dana/domain/statement/interactor/GetStatementDisableDetail;", "Lid/dana/domain/statement/interactor/GetStatementDisableDetail;", "Lid/dana/domain/statement/interactor/GetStatementSummary;", "moveToNextValue", "Lid/dana/domain/statement/interactor/GetStatementSummary;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/statement/interactor/GetTotalStatements;", "getErrorConfigVersion", "Lid/dana/domain/statement/interactor/GetTotalStatements;", "Lid/dana/statement/UserStatementContract$View;", "scheduleImpl", "Lid/dana/statement/UserStatementContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/statement/UserStatementContract$View;Lid/dana/domain/statement/interactor/GetStatementSummary;Lid/dana/domain/statement/interactor/GetStatementDetail;Lid/dana/domain/statement/interactor/GetAllStatementSummary;Lid/dana/domain/statement/interactor/GetTotalStatements;Lid/dana/domain/statement/interactor/GetAllStatementDetail;Lid/dana/domain/statement/interactor/CheckFeatureDownloadStatement;Lid/dana/domain/statement/interactor/GetStatementDisableDetail;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class UserStatementPresenter implements UserStatementContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CheckFeatureDownloadStatement getAuthRequestContext;
    private final GetAllStatementSummary KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetAllStatementDetail PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetStatementDetail BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetStatementDisableDetail MyBillsEntityDataFactory;
    private final GetTotalStatements getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetStatementSummary NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final UserStatementContract.View moveToNextValue;

    @Inject
    public UserStatementPresenter(UserStatementContract.View view, GetStatementSummary getStatementSummary, GetStatementDetail getStatementDetail, GetAllStatementSummary getAllStatementSummary, GetTotalStatements getTotalStatements, GetAllStatementDetail getAllStatementDetail, CheckFeatureDownloadStatement checkFeatureDownloadStatement, GetStatementDisableDetail getStatementDisableDetail) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getStatementSummary, "");
        Intrinsics.checkNotNullParameter(getStatementDetail, "");
        Intrinsics.checkNotNullParameter(getAllStatementSummary, "");
        Intrinsics.checkNotNullParameter(getTotalStatements, "");
        Intrinsics.checkNotNullParameter(getAllStatementDetail, "");
        Intrinsics.checkNotNullParameter(checkFeatureDownloadStatement, "");
        Intrinsics.checkNotNullParameter(getStatementDisableDetail, "");
        this.moveToNextValue = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getStatementSummary;
        this.BuiltInFictitiousFunctionClassFactory = getStatementDetail;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getAllStatementSummary;
        this.getErrorConfigVersion = getTotalStatements;
        this.PlaceComponentResult = getAllStatementDetail;
        this.getAuthRequestContext = checkFeatureDownloadStatement;
        this.MyBillsEntityDataFactory = getStatementDisableDetail;
    }

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final StatementSummaryInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.moveToNextValue.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new GetStatementSummary.Params(p0.BuiltInFictitiousFunctionClassFactory(), p0.BuiltInFictitiousFunctionClassFactory.name(), p0.getAuthRequestContext.name()), new Function1<UserStatement, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getStatementSummary$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserStatement userStatement) {
                invoke2(userStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserStatement userStatement) {
                UserStatementContract.View view;
                boolean PlaceComponentResult;
                boolean MyBillsEntityDataFactory;
                UserStatementContract.View view2;
                UserStatementContract.View view3;
                Intrinsics.checkNotNullParameter(userStatement, "");
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
                PlaceComponentResult = UserStatementPresenter.PlaceComponentResult(p0.getAuthRequestContext);
                if (PlaceComponentResult) {
                    view3 = UserStatementPresenter.this.moveToNextValue;
                    view3.MyBillsEntityDataFactory(UserStatementModelKt.BuiltInFictitiousFunctionClassFactory(userStatement));
                    return;
                }
                MyBillsEntityDataFactory = UserStatementPresenter.MyBillsEntityDataFactory(p0.getAuthRequestContext);
                if (MyBillsEntityDataFactory) {
                    view2 = UserStatementPresenter.this.moveToNextValue;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(UserStatementModelKt.BuiltInFictitiousFunctionClassFactory(userStatement));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getStatementSummary$2
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
                UserStatementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
            }
        });
    }

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long p0, long p1) {
        this.moveToNextValue.showProgress();
        this.PlaceComponentResult.execute(new GetAllStatementDetail.Params(p0, p1), new Function1<List<? extends UserStatementDetail>, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getAllStatementDetail$1

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] MyBillsEntityDataFactory;

                static {
                    int[] iArr = new int[StatementType.values().length];
                    iArr[StatementType.INCOME.ordinal()] = 1;
                    iArr[StatementType.EXPENSE.ordinal()] = 2;
                    MyBillsEntityDataFactory = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserStatementDetail> list) {
                invoke2((List<UserStatementDetail>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserStatementDetail> list) {
                UserStatementContract.View view;
                UserStatementContract.View view2;
                UserStatementContract.View view3;
                Intrinsics.checkNotNullParameter(list, "");
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
                UserStatementPresenter userStatementPresenter = UserStatementPresenter.this;
                for (UserStatementDetail userStatementDetail : list) {
                    int i = WhenMappings.MyBillsEntityDataFactory[userStatementDetail.getStatementType().ordinal()];
                    if (i == 1) {
                        view3 = userStatementPresenter.moveToNextValue;
                        view3.MyBillsEntityDataFactory(UserStatementDetailModelKt.getAuthRequestContext(userStatementDetail));
                    } else if (i == 2) {
                        view2 = userStatementPresenter.moveToNextValue;
                        view2.getAuthRequestContext(UserStatementDetailModelKt.getAuthRequestContext(userStatementDetail));
                    }
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getAllStatementDetail$2
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
                UserStatementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
            }
        });
    }

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void getAuthRequestContext(StatementSummaryInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.moveToNextValue.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new GetAllStatementSummary.Params(p0.BuiltInFictitiousFunctionClassFactory(), p0.BuiltInFictitiousFunctionClassFactory.name()), new Function1<List<? extends UserStatement>, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getAllStatementSummary$1
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
                UserStatementContract.View view;
                UserStatementContract.View view2;
                Intrinsics.checkNotNullParameter(list, "");
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
                List<UserStatementModel> MyBillsEntityDataFactory = UserStatementModelKt.MyBillsEntityDataFactory(list);
                view2 = UserStatementPresenter.this.moveToNextValue;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(StatementViewModelKt.PlaceComponentResult(MyBillsEntityDataFactory));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getAllStatementSummary$2
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
                UserStatementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
            }
        });
    }

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void PlaceComponentResult(StatementSummaryInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.moveToNextValue.showProgress();
        this.getErrorConfigVersion.execute(new GetTotalStatements.Params(p0.BuiltInFictitiousFunctionClassFactory(), p0.BuiltInFictitiousFunctionClassFactory.name()), new Function1<List<? extends TotalStatement>, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getTotalStatement$1

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] getAuthRequestContext;

                static {
                    int[] iArr = new int[StatementType.values().length];
                    iArr[StatementType.INCOME.ordinal()] = 1;
                    iArr[StatementType.EXPENSE.ordinal()] = 2;
                    getAuthRequestContext = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends TotalStatement> list) {
                invoke2((List<TotalStatement>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<TotalStatement> list) {
                UserStatementContract.View view;
                UserStatementContract.View view2;
                UserStatementContract.View view3;
                Intrinsics.checkNotNullParameter(list, "");
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
                UserStatementPresenter userStatementPresenter = UserStatementPresenter.this;
                for (TotalStatement totalStatement : list) {
                    int i = WhenMappings.getAuthRequestContext[totalStatement.getType().ordinal()];
                    if (i == 1) {
                        view3 = userStatementPresenter.moveToNextValue;
                        view3.KClassImpl$Data$declaredNonStaticMembers$2(totalStatement.getAmount(), totalStatement.getCurrency());
                    } else if (i == 2) {
                        view2 = userStatementPresenter.moveToNextValue;
                        view2.BuiltInFictitiousFunctionClassFactory(totalStatement.getAmount(), totalStatement.getCurrency());
                    }
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getTotalStatement$2
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
                UserStatementContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.scheduleImpl(DanaLogConstants.TAG.STATEMENT, th.getMessage());
                view = UserStatementPresenter.this.moveToNextValue;
                view.dismissProgress();
            }
        });
    }

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void PlaceComponentResult() {
        int i;
        i = Calendar.getInstance().get(2);
        KClassImpl$Data$declaredNonStaticMembers$2(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(i + 1, DateTimeUtil.moveToNextValue()), DateTimeUtil.lookAheadTest());
    }

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.statement.UserStatementPresenter$checkFeatureDownloadStatementEnable$1
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
                UserStatementContract.View view;
                view = UserStatementPresenter.this.moveToNextValue;
                view.MyBillsEntityDataFactory(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.statement.UserStatementPresenter$checkFeatureDownloadStatementEnable$2
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

    @Override // id.dana.statement.UserStatementContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<List<? extends String>, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getStatementDisableDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                UserStatementContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = UserStatementPresenter.this.moveToNextValue;
                view.MyBillsEntityDataFactory(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.statement.UserStatementPresenter$getStatementDisableDetail$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MyBillsEntityDataFactory(StatementType p0) {
        return StatementType.EXPENSE == p0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(StatementType p0) {
        return StatementType.INCOME == p0;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getErrorConfigVersion.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }
}
