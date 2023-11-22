package id.dana.requestmoney.bank;

import android.content.Context;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.qrbarcode.QrUserBankResult;
import id.dana.domain.qrbarcode.interactor.GetBankQr;
import id.dana.domain.qrbarcode.interactor.GetBankTransferQr;
import id.dana.network.exception.NetworkException;
import id.dana.requestmoney.bank.UserBankQrContract;
import id.dana.requestmoney.model.QrUserBankModelKt;
import id.dana.requestmoney.model.UserBankModel;
import id.dana.requestmoney.model.UserBankModelKt;
import id.dana.requestmoney.util.RequestMoneyErrorHelper;
import id.dana.sendmoney.Amount;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001a"}, d2 = {"Lid/dana/requestmoney/bank/UserBankQrPresenter;", "Lid/dana/requestmoney/bank/UserBankQrContract$Presenter;", "Lid/dana/requestmoney/model/UserBankModel;", "p0", "Lid/dana/sendmoney/Amount;", "p1", "", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/requestmoney/model/UserBankModel;Lid/dana/sendmoney/Amount;Ljava/lang/String;)V", "onDestroy", "()V", "Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "getAuthRequestContext", "Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/domain/qrbarcode/interactor/GetBankQr;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/qrbarcode/interactor/GetBankQr;", "Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr;", "MyBillsEntityDataFactory", "Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr;", "Lid/dana/requestmoney/bank/UserBankQrContract$View;", "Lid/dana/requestmoney/bank/UserBankQrContract$View;", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/requestmoney/bank/UserBankQrContract$View;Lid/dana/domain/qrbarcode/interactor/GetBankQr;Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr;Lid/dana/sendmoney_v2/tracker/ApiHitTimer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserBankQrPresenter implements UserBankQrContract.Presenter {
    private final GetBankQr BuiltInFictitiousFunctionClassFactory;
    private final UserBankQrContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetBankTransferQr MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final ApiHitTimer getAuthRequestContext;

    @Inject
    public UserBankQrPresenter(Context context, UserBankQrContract.View view, GetBankQr getBankQr, GetBankTransferQr getBankTransferQr, ApiHitTimer apiHitTimer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getBankQr, "");
        Intrinsics.checkNotNullParameter(getBankTransferQr, "");
        Intrinsics.checkNotNullParameter(apiHitTimer, "");
        this.PlaceComponentResult = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = getBankQr;
        this.MyBillsEntityDataFactory = getBankTransferQr;
        this.getAuthRequestContext = apiHitTimer;
    }

    @Override // id.dana.requestmoney.bank.UserBankQrContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(UserBankModel p0, Amount p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.getAuthRequestContext.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        if (p1.getAuthRequestContext > 0) {
            String obj = p1.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            this.MyBillsEntityDataFactory.execute(UserBankModelKt.KClassImpl$Data$declaredNonStaticMembers$2(p0, obj, p2), new Function1<QrUserBankResult, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankTransferQr$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(QrUserBankResult qrUserBankResult) {
                    invoke2(qrUserBankResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(QrUserBankResult qrUserBankResult) {
                    ApiHitTimer apiHitTimer;
                    UserBankQrContract.View view;
                    Intrinsics.checkNotNullParameter(qrUserBankResult, "");
                    apiHitTimer = UserBankQrPresenter.this.getAuthRequestContext;
                    final UserBankQrPresenter userBankQrPresenter = UserBankQrPresenter.this;
                    Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankTransferQr$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j) {
                            UserBankQrContract.View view2;
                            view2 = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            view2.PlaceComponentResult(j);
                        }
                    };
                    Intrinsics.checkNotNullParameter(function1, "");
                    apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                    apiHitTimer.PlaceComponentResult = 0L;
                    apiHitTimer.getAuthRequestContext = 0L;
                    view = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view.MyBillsEntityDataFactory(QrUserBankModelKt.PlaceComponentResult(qrUserBankResult));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankTransferQr$2
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
                    ApiHitTimer apiHitTimer;
                    Context context;
                    UserBankQrContract.View view;
                    Intrinsics.checkNotNullParameter(th, "");
                    apiHitTimer = UserBankQrPresenter.this.getAuthRequestContext;
                    final UserBankQrPresenter userBankQrPresenter = UserBankQrPresenter.this;
                    Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankTransferQr$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Long l) {
                            invoke(l.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j) {
                            UserBankQrContract.View view2;
                            view2 = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            view2.PlaceComponentResult(j);
                        }
                    };
                    Intrinsics.checkNotNullParameter(function1, "");
                    apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                    apiHitTimer.PlaceComponentResult = 0L;
                    apiHitTimer.getAuthRequestContext = 0L;
                    RequestMoneyErrorHelper requestMoneyErrorHelper = RequestMoneyErrorHelper.INSTANCE;
                    UiTextModel uiTextModel = RequestMoneyErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(th).PlaceComponentResult;
                    context = UserBankQrPresenter.this.PlaceComponentResult;
                    String asString = uiTextModel.asString(context);
                    view = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    view.MyBillsEntityDataFactory(asString);
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.REQUEST_MONEY_QR_PREFIX);
                    sb.append(UserBankQrPresenter.this.getClass().getName());
                    sb.append(":onError");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, sb.toString(), th);
                    UserBankQrPresenter.MyBillsEntityDataFactory(UserBankQrPresenter.this, TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_TRANSFER_BANK, asString, th);
                }
            });
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.execute(UserBankModelKt.getAuthRequestContext(p0), new Function1<QrUserBankResult, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankQr$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QrUserBankResult qrUserBankResult) {
                invoke2(qrUserBankResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QrUserBankResult qrUserBankResult) {
                ApiHitTimer apiHitTimer;
                UserBankQrContract.View view;
                Intrinsics.checkNotNullParameter(qrUserBankResult, "");
                apiHitTimer = UserBankQrPresenter.this.getAuthRequestContext;
                final UserBankQrPresenter userBankQrPresenter = UserBankQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankQr$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        UserBankQrContract.View view2;
                        view2 = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        view2.getAuthRequestContext(j);
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                view = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory(QrUserBankModelKt.PlaceComponentResult(qrUserBankResult));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankQr$2
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
                ApiHitTimer apiHitTimer;
                Context context;
                UserBankQrContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                apiHitTimer = UserBankQrPresenter.this.getAuthRequestContext;
                final UserBankQrPresenter userBankQrPresenter = UserBankQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.bank.UserBankQrPresenter$getBankQr$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        UserBankQrContract.View view2;
                        view2 = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        view2.getAuthRequestContext(j);
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                RequestMoneyErrorHelper requestMoneyErrorHelper = RequestMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = RequestMoneyErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(th).PlaceComponentResult;
                context = UserBankQrPresenter.this.PlaceComponentResult;
                String asString = uiTextModel.asString(context);
                view = UserBankQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.MyBillsEntityDataFactory(asString);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.REQUEST_MONEY_QR_PREFIX);
                sb.append(UserBankQrPresenter.this.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, sb.toString(), th);
                UserBankQrPresenter.MyBillsEntityDataFactory(UserBankQrPresenter.this, TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_USER_BANK, asString, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(UserBankQrPresenter userBankQrPresenter, String str, String str2, Throwable th) {
        Throwable cause = th.getCause();
        NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
        if (networkException != null) {
            UserBankQrContract.View view = userBankQrPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            String message = networkException.getMessage();
            String errorCode = networkException.getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            String traceId = networkException.getTraceId();
            Intrinsics.checkNotNullExpressionValue(traceId, "");
            view.PlaceComponentResult(str, str2, message, errorCode, traceId);
            return;
        }
        userBankQrPresenter.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(str, str2, th.getMessage(), "", "");
    }
}
