package id.dana.cashier.presenter;

import android.content.Context;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.tracker.danaviz.DanaVizTracker;
import id.dana.analytics.tracker.danaviz.DanaVizTrackerImpl;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.domain.interactor.DoTopUpSubmit;
import id.dana.cashier.domain.interactor.DoTopUpVerify;
import id.dana.cashier.domain.interactor.GetTopUpAgent;
import id.dana.cashier.domain.interactor.GetTopUpConsult;
import id.dana.cashier.domain.interactor.PayQueryCashier;
import id.dana.cashier.domain.interactor.TopUpPayCashier;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.cashier.domain.model.TopUpPay;
import id.dana.cashier.helper.CashierErrorHelper;
import id.dana.cashier.mapper.CashierPayModelMapper;
import id.dana.cashier.mapper.TopUpConsultModelMapper;
import id.dana.cashier.mapper.TopUpPayModelMapper;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.FaceAuthModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.TopUpSubmitRequestModel;
import id.dana.cashier.model.TopUpSubmitRequestModelKt;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.model.TopUpVerifyRequestModelKt;
import id.dana.cashier.utils.CashierPayQueryCounter;
import id.dana.lib.bio.faceauth.FaceAuthentication;
import id.dana.lib.bio.faceauth.FaceAuthenticationCallback;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002Bq\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\"\u0012\u0006\u0010\n\u001a\u00020B\u0012\u0006\u0010\f\u001a\u000208\u0012\u0006\u0010\u0019\u001a\u00020?\u0012\u0006\u0010\u001a\u001a\u000204\u0012\u0006\u0010D\u001a\u00020'\u0012\u0006\u0010E\u001a\u00020*\u0012\u0006\u0010F\u001a\u000201\u0012\u0006\u0010G\u001a\u00020;\u0012\u0006\u0010H\u001a\u000206\u0012\u0006\u0010I\u001a\u00020 \u0012\u0006\u0010J\u001a\u00020-\u0012\u0006\u0010K\u001a\u00020$¢\u0006\u0004\bL\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u001bJ=\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\r\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u001dH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0010\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010!R\u0014\u0010\u0013\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010%R\u0014\u0010\u0006\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\r\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00102R\u0014\u0010.\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u00105R\u0014\u0010(\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00107R\u0014\u0010+\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010<\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u00109\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010C"}, d2 = {"Lid/dana/cashier/presenter/TopUpAndPayPresenter;", "Lid/dana/cashier/TopUpAndPayContract$Presenter;", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker;", "Lid/dana/cashier/model/FaceAuthModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/cashier/model/FaceAuthModel;)V", "Lid/dana/cashier/domain/model/CashierPayRequest;", "", "p1", "", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/CashierPayRequest;IZ)V", "Lid/dana/cashier/model/TopUpSubmitRequestModel;", "PlaceComponentResult", "(Lid/dana/cashier/model/TopUpSubmitRequestModel;)V", "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/TopUpVerifyRequestModel;)V", "(Lid/dana/cashier/domain/model/CashierPayRequest;I)V", "onDestroy", "()V", "", "p3", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;", "setSource", "(Lid/dana/analytics/tracker/danaviz/DanaVizTracker$Source;)V", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Lid/dana/cashier/mapper/CashierPayModelMapper;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;", "MyBillsEntityDataFactory", "Lid/dana/cashier/domain/interactor/DoTopUpSubmit;", "getErrorConfigVersion", "Lid/dana/cashier/domain/interactor/DoTopUpSubmit;", "Lid/dana/cashier/domain/interactor/DoTopUpVerify;", "lookAheadTest", "Lid/dana/cashier/domain/interactor/DoTopUpVerify;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "moveToNextValue", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/cashier/domain/interactor/GetTopUpAgent;", "Lid/dana/cashier/domain/interactor/GetTopUpAgent;", "scheduleImpl", "Lid/dana/cashier/domain/interactor/GetTopUpConsult;", "Lid/dana/cashier/domain/interactor/GetTopUpConsult;", "Lid/dana/cashier/domain/interactor/PayQueryCashier;", "Lid/dana/cashier/domain/interactor/PayQueryCashier;", "Lid/dana/cashier/mapper/TopUpConsultModelMapper;", "GetContactSyncConfig", "Lid/dana/cashier/mapper/TopUpConsultModelMapper;", "Lid/dana/cashier/domain/interactor/TopUpPayCashier;", "initRecordTimeStamp", "Lid/dana/cashier/domain/interactor/TopUpPayCashier;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/mapper/TopUpPayModelMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/cashier/mapper/TopUpPayModelMapper;", "Lid/dana/cashier/TopUpAndPayContract$View;", "Lid/dana/cashier/TopUpAndPayContract$View;", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Landroid/content/Context;Lid/dana/cashier/TopUpAndPayContract$View;Lid/dana/cashier/mapper/TopUpConsultModelMapper;Lid/dana/cashier/mapper/TopUpPayModelMapper;Lid/dana/cashier/domain/interactor/GetTopUpConsult;Lid/dana/cashier/domain/interactor/DoTopUpSubmit;Lid/dana/cashier/domain/interactor/DoTopUpVerify;Lid/dana/cashier/domain/interactor/GetTopUpAgent;Lid/dana/cashier/domain/interactor/TopUpPayCashier;Lid/dana/cashier/domain/interactor/PayQueryCashier;Lid/dana/cashier/mapper/CashierPayModelMapper;Lid/dana/lib/bio/faceauth/FaceAuthentication;Lid/dana/analytics/tracker/danaviz/DanaVizTrackerImpl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayPresenter implements TopUpAndPayContract.Presenter, DanaVizTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final TopUpConsultModelMapper lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CashierPayModelMapper PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetTopUpConsult moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetTopUpAgent scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final TopUpPayModelMapper initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final DanaVizTrackerImpl MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final TopUpAndPayContract.View GetContactSyncConfig;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final DoTopUpSubmit getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final TopUpPayCashier NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final DoTopUpVerify BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final FaceAuthentication NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final PayQueryCashier getErrorConfigVersion;

    @Override // id.dana.analytics.tracker.danaviz.DanaVizTracker
    public final void setSource(DanaVizTracker.Source p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.setSource(p0);
    }

    @Inject
    public TopUpAndPayPresenter(Context context, TopUpAndPayContract.View view, TopUpConsultModelMapper topUpConsultModelMapper, TopUpPayModelMapper topUpPayModelMapper, GetTopUpConsult getTopUpConsult, DoTopUpSubmit doTopUpSubmit, DoTopUpVerify doTopUpVerify, GetTopUpAgent getTopUpAgent, TopUpPayCashier topUpPayCashier, PayQueryCashier payQueryCashier, CashierPayModelMapper cashierPayModelMapper, FaceAuthentication faceAuthentication, DanaVizTrackerImpl danaVizTrackerImpl) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(topUpConsultModelMapper, "");
        Intrinsics.checkNotNullParameter(topUpPayModelMapper, "");
        Intrinsics.checkNotNullParameter(getTopUpConsult, "");
        Intrinsics.checkNotNullParameter(doTopUpSubmit, "");
        Intrinsics.checkNotNullParameter(doTopUpVerify, "");
        Intrinsics.checkNotNullParameter(getTopUpAgent, "");
        Intrinsics.checkNotNullParameter(topUpPayCashier, "");
        Intrinsics.checkNotNullParameter(payQueryCashier, "");
        Intrinsics.checkNotNullParameter(cashierPayModelMapper, "");
        Intrinsics.checkNotNullParameter(faceAuthentication, "");
        Intrinsics.checkNotNullParameter(danaVizTrackerImpl, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.GetContactSyncConfig = view;
        this.lookAheadTest = topUpConsultModelMapper;
        this.initRecordTimeStamp = topUpPayModelMapper;
        this.moveToNextValue = getTopUpConsult;
        this.getAuthRequestContext = doTopUpSubmit;
        this.BuiltInFictitiousFunctionClassFactory = doTopUpVerify;
        this.scheduleImpl = getTopUpAgent;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = topUpPayCashier;
        this.getErrorConfigVersion = payQueryCashier;
        this.PlaceComponentResult = cashierPayModelMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = faceAuthentication;
        this.MyBillsEntityDataFactory = danaVizTrackerImpl;
        setSource(DanaVizTracker.Source.TOP_UP);
    }

    @Override // id.dana.cashier.TopUpAndPayContract.Presenter
    public final void PlaceComponentResult(TopUpSubmitRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.showProgress();
        this.getAuthRequestContext.execute(DoTopUpSubmit.Params.INSTANCE.createTopUpSubmitRequest(TopUpSubmitRequestModelKt.KClassImpl$Data$declaredNonStaticMembers$2(p0)), new Function1<TopUpPay, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doTopUpSubmit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TopUpPay topUpPay) {
                invoke2(topUpPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TopUpPay topUpPay) {
                TopUpAndPayContract.View view;
                TopUpAndPayContract.View view2;
                TopUpPayModelMapper topUpPayModelMapper;
                TopUpAndPayContract.View view3;
                TopUpAndPayContract.View view4;
                Intrinsics.checkNotNullParameter(topUpPay, "");
                if (Intrinsics.areEqual(topUpPay.getSuccess(), Boolean.TRUE)) {
                    topUpPayModelMapper = TopUpAndPayPresenter.this.initRecordTimeStamp;
                    TopUpPayModel apply = topUpPayModelMapper.apply(topUpPay);
                    view3 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                    view3.dismissProgress();
                    view4 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                    Intrinsics.checkNotNullExpressionValue(apply, "");
                    view4.getAuthRequestContext(apply);
                    return;
                }
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view2.onError(topUpPay.getErrorMessage());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doTopUpSubmit$2
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
                TopUpAndPayContract.View view;
                TopUpAndPayContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                context = TopUpAndPayPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
            }
        });
    }

    @Override // id.dana.cashier.TopUpAndPayContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(TopUpVerifyRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(DoTopUpVerify.Params.INSTANCE.createTopUpVerifyRequest(TopUpVerifyRequestModelKt.BuiltInFictitiousFunctionClassFactory(p0)), new Function1<TopUpPay, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doTopUpVerify$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TopUpPay topUpPay) {
                invoke2(topUpPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TopUpPay topUpPay) {
                TopUpAndPayContract.View view;
                TopUpAndPayContract.View view2;
                TopUpPayModelMapper topUpPayModelMapper;
                Intrinsics.checkNotNullParameter(topUpPay, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                topUpPayModelMapper = TopUpAndPayPresenter.this.initRecordTimeStamp;
                TopUpPayModel apply = topUpPayModelMapper.apply(topUpPay);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view2.MyBillsEntityDataFactory(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doTopUpVerify$2
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
                TopUpAndPayContract.View view;
                TopUpAndPayContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                view2.lookAheadTest(CashierErrorHelper.MyBillsEntityDataFactory(th));
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final CashierPayRequest p0, final int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.showProgress();
        this.scheduleImpl.execute(GetTopUpAgent.Params.INSTANCE.createTopUpConsultParams(p0.getPayMethod(), p0.getChannelIndex()), new Function1<TopUpConsult, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$getTopUpAgentOrBankVa$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TopUpConsult topUpConsult) {
                invoke2(topUpConsult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TopUpConsult topUpConsult) {
                Intrinsics.checkNotNullParameter(topUpConsult, "");
                TopUpAndPayPresenter.this.BuiltInFictitiousFunctionClassFactory(p0, p1, false);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$getTopUpAgentOrBankVa$2
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
                TopUpAndPayContract.View view;
                TopUpAndPayContract.View view2;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                context = TopUpAndPayPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(ErrorUtil.PlaceComponentResult(th, context));
            }
        });
    }

    @Override // id.dana.cashier.TopUpAndPayContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(CashierPayRequest p0, final int p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p2) {
            this.GetContactSyncConfig.showProgress();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.execute(TopUpPayCashier.Params.INSTANCE.createPayCashierRequest(p0, this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2()), new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doTopUpPayCashier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                TopUpAndPayContract.View view;
                TopUpAndPayContract.View view2;
                CashierPayModelMapper cashierPayModelMapper;
                Intrinsics.checkNotNullParameter(cashierPay, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = TopUpAndPayPresenter.this.GetContactSyncConfig;
                cashierPayModelMapper = TopUpAndPayPresenter.this.PlaceComponentResult;
                CashierPayModel apply = cashierPayModelMapper.apply(cashierPay);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view2.BuiltInFictitiousFunctionClassFactory(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doTopUpPayCashier$2
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
                TopUpAndPayContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                TopUpAndPayPresenter.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayPresenter.this, th);
            }
        });
    }

    @Override // id.dana.cashier.TopUpAndPayContract.Presenter
    public final void PlaceComponentResult(final String str, final String str2, final String str3, final String str4) {
        PayQueryCashier.Params createPayQueryRequest;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getErrorConfigVersion.dispose();
        this.GetContactSyncConfig.showProgress();
        String str5 = str2.length() > 0 ? str2 : str;
        PayQueryCashier payQueryCashier = this.getErrorConfigVersion;
        createPayQueryRequest = PayQueryCashier.Params.INSTANCE.createPayQueryRequest(str5, (r27 & 2) != 0 ? null : null, (r27 & 4) != 0 ? null : null, (r27 & 8) != 0 ? null : null, (r27 & 16) != 0 ? null : str3, this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(), (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? false : false, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null);
        payQueryCashier.execute(createPayQueryRequest, new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$payQueryCashier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                TopUpAndPayPresenter.getAuthRequestContext(TopUpAndPayPresenter.this, cashierPay, str, str2, str4, str3);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$payQueryCashier$2
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
                Intrinsics.checkNotNullParameter(th, "");
                TopUpAndPayPresenter.getAuthRequestContext(TopUpAndPayPresenter.this, th);
            }
        });
        CashierPayQueryCounter cashierPayQueryCounter = CashierPayQueryCounter.INSTANCE;
        CashierPayQueryCounter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.cashier.TopUpAndPayContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final String p2, String p3, String p4) {
        PayQueryCashier.Params createPayQueryRequest;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.GetContactSyncConfig.showProgress();
        PayQueryCashier payQueryCashier = this.getErrorConfigVersion;
        createPayQueryRequest = PayQueryCashier.Params.INSTANCE.createPayQueryRequest(p1, (r27 & 2) != 0 ? null : p3, (r27 & 4) != 0 ? null : p4, (r27 & 8) != 0 ? null : null, (r27 & 16) != 0 ? null : null, this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(), (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : null, (r27 & 256) != 0 ? false : false, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? null : null);
        payQueryCashier.execute(createPayQueryRequest, new Function1<CashierPay, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$payQueryCashierWithRisk$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPay cashierPay) {
                invoke2(cashierPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPay cashierPay) {
                Intrinsics.checkNotNullParameter(cashierPay, "");
                TopUpAndPayPresenter.getAuthRequestContext(TopUpAndPayPresenter.this, cashierPay, p0, p1, p2, null);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$payQueryCashierWithRisk$2
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
                Intrinsics.checkNotNullParameter(th, "");
                TopUpAndPayPresenter.getAuthRequestContext(TopUpAndPayPresenter.this, th);
            }
        });
        CashierPayQueryCounter cashierPayQueryCounter = CashierPayQueryCounter.INSTANCE;
        CashierPayQueryCounter.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.moveToNextValue.dispose();
        this.scheduleImpl.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getErrorConfigVersion.dispose();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayPresenter topUpAndPayPresenter, Throwable th) {
        Throwable cause = th.getCause();
        NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
        if (networkException != null) {
            TopUpAndPayContract.View view = topUpAndPayPresenter.GetContactSyncConfig;
            String message = networkException.getMessage();
            networkException.getErrorCode();
            view.lookAheadTest(message);
            return;
        }
        topUpAndPayPresenter.GetContactSyncConfig.lookAheadTest(th.getMessage());
    }

    public static final /* synthetic */ void getAuthRequestContext(TopUpAndPayPresenter topUpAndPayPresenter, Throwable th) {
        topUpAndPayPresenter.GetContactSyncConfig.dismissProgress();
        TopUpAndPayContract.View view = topUpAndPayPresenter.GetContactSyncConfig;
        CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
        view.BuiltInFictitiousFunctionClassFactory(CashierErrorHelper.MyBillsEntityDataFactory(th));
        StringBuilder sb = new StringBuilder();
        sb.append("[PayQuery]: cashier_native_fail");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
    }

    public static final /* synthetic */ void getAuthRequestContext(TopUpAndPayPresenter topUpAndPayPresenter, CashierPay cashierPay, String str, String str2, String str3, String str4) {
        AttributeCashierPayModel attributeCashierPayModel;
        CashierPayModel apply = topUpAndPayPresenter.PlaceComponentResult.apply(cashierPay);
        if (apply == null || (attributeCashierPayModel = apply.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2(str3);
        if (Intrinsics.areEqual(attributeCashierPayModel.Q, Boolean.TRUE) || KClassImpl$Data$declaredNonStaticMembers$2) {
            topUpAndPayPresenter.PlaceComponentResult(str, str2, str4, str3);
            return;
        }
        topUpAndPayPresenter.GetContactSyncConfig.dismissProgress();
        TopUpAndPayContract.View view = topUpAndPayPresenter.GetContactSyncConfig;
        CashierPayModel apply2 = topUpAndPayPresenter.PlaceComponentResult.apply(cashierPay);
        Intrinsics.checkNotNullExpressionValue(apply2, "");
        view.MyBillsEntityDataFactory(apply2);
    }

    @Override // id.dana.cashier.TopUpAndPayContract.Presenter
    public final void getAuthRequestContext(final FaceAuthModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.getErrorConfigVersion();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(p0.MyBillsEntityDataFactory, p0.moveToNextValue, new FaceAuthenticationCallback() { // from class: id.dana.cashier.presenter.TopUpAndPayPresenter$doFaceAuth$1
            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onCancel() {
                TopUpAndPayContract.View view;
                TopUpAndPayPresenter.this.MyBillsEntityDataFactory.lookAheadTest();
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.getAuthRequestContext();
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onFailed(DanaBioException.FaceAuthenticationException p02) {
                TopUpAndPayContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.scheduleImpl();
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.UAP_FACE_AUTHENTICATION_PREFIX);
                sb.append(getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.UAP_FACE_AUTHENTICATION, sb.toString(), p02);
                TopUpAndPayPresenter topUpAndPayPresenter = TopUpAndPayPresenter.this;
                int errorCode = p02.getErrorCode();
                String message = p02.getMessage();
                Intrinsics.checkNotNullParameter(message, "");
                topUpAndPayPresenter.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(errorCode, message);
            }

            @Override // id.dana.lib.bio.faceauth.FaceAuthenticationCallback
            public final void onSuccess(String p02) {
                TopUpAndPayContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = TopUpAndPayPresenter.this.GetContactSyncConfig;
                view.getErrorConfigVersion();
                TopUpAndPayPresenter.this.MyBillsEntityDataFactory.scheduleImpl();
                TopUpAndPayPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(new TopUpVerifyRequestModel(p0.getAuthRequestContext, p0.BuiltInFictitiousFunctionClassFactory, p0.PlaceComponentResult, p0.getErrorConfigVersion, p02, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.scheduleImpl, null, null, null, 896, null));
            }
        });
    }
}
