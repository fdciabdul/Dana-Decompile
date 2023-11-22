package id.dana.contract.staticqr;

import android.content.Context;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.core.ui.model.UiTextModel;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.model.QrisTciCoConfig;
import id.dana.domain.qrbarcode.QrUserResult;
import id.dana.domain.qrbarcode.interactor.GetUserDynamicQr;
import id.dana.domain.qrbarcode.interactor.GetUserStaticQr;
import id.dana.myprofile.model.QrisTciCoConfigModelKt;
import id.dana.network.exception.NetworkException;
import id.dana.requestmoney.util.RequestMoneyErrorHelper;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u0006\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/contract/staticqr/GetStaticQrPresenter;", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "onDestroy", "PlaceComponentResult", "Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Lid/dana/domain/featureconfig/interactor/GetQrisTcicoConfig;", "Lid/dana/domain/featureconfig/interactor/GetQrisTcicoConfig;", "Lid/dana/domain/qrbarcode/interactor/GetUserDynamicQr;", "Lid/dana/domain/qrbarcode/interactor/GetUserDynamicQr;", "Lid/dana/domain/qrbarcode/interactor/GetUserStaticQr;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/qrbarcode/interactor/GetUserStaticQr;", "", "Ljava/lang/String;", "Lid/dana/contract/staticqr/GetStaticQrContract$View;", "lookAheadTest", "Lid/dana/contract/staticqr/GetStaticQrContract$View;", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Landroid/content/Context;Lid/dana/contract/staticqr/GetStaticQrContract$View;Lid/dana/domain/qrbarcode/interactor/GetUserStaticQr;Lid/dana/domain/qrbarcode/interactor/GetUserDynamicQr;Lid/dana/domain/featureconfig/interactor/GetQrisTcicoConfig;Lid/dana/sendmoney_v2/tracker/ApiHitTimer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class GetStaticQrPresenter implements GetStaticQrContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ApiHitTimer getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetUserStaticQr MyBillsEntityDataFactory;
    private final GetQrisTcicoConfig PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetUserDynamicQr BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetStaticQrContract.View moveToNextValue;

    @Inject
    public GetStaticQrPresenter(Context context, GetStaticQrContract.View view, GetUserStaticQr getUserStaticQr, GetUserDynamicQr getUserDynamicQr, GetQrisTcicoConfig getQrisTcicoConfig, ApiHitTimer apiHitTimer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserStaticQr, "");
        Intrinsics.checkNotNullParameter(getUserDynamicQr, "");
        Intrinsics.checkNotNullParameter(getQrisTcicoConfig, "");
        Intrinsics.checkNotNullParameter(apiHitTimer, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.moveToNextValue = view;
        this.MyBillsEntityDataFactory = getUserStaticQr;
        this.BuiltInFictitiousFunctionClassFactory = getUserDynamicQr;
        this.PlaceComponentResult = getQrisTcicoConfig;
        this.getAuthRequestContext = apiHitTimer;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
    }

    @Override // id.dana.contract.staticqr.GetStaticQrContract.Presenter
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<QrUserResult, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getDynamicProfileQr$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QrUserResult qrUserResult) {
                invoke2(qrUserResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QrUserResult qrUserResult) {
                ApiHitTimer apiHitTimer;
                GetStaticQrContract.View view;
                GetUserDynamicQr getUserDynamicQr;
                GetStaticQrContract.View view2;
                GetStaticQrContract.View view3;
                Intrinsics.checkNotNullParameter(qrUserResult, "");
                apiHitTimer = GetStaticQrPresenter.this.getAuthRequestContext;
                final GetStaticQrPresenter getStaticQrPresenter = GetStaticQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getDynamicProfileQr$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        GetStaticQrContract.View view4;
                        view4 = GetStaticQrPresenter.this.moveToNextValue;
                        view4.getAuthRequestContext(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                if (!Intrinsics.areEqual(GetStaticQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0, qrUserResult.getQrCode())) {
                    view2 = GetStaticQrPresenter.this.moveToNextValue;
                    view2.dismissProgress();
                    view3 = GetStaticQrPresenter.this.moveToNextValue;
                    view3.KClassImpl$Data$declaredNonStaticMembers$2(qrUserResult.getQrCode());
                    StringBuilder sb = new StringBuilder();
                    sb.append(DanaLogConstants.Prefix.STATIC_QRCODE_PREFIX);
                    sb.append(GetStaticQrPresenter.this.getClass().getName());
                    sb.append("onNext");
                    sb.append(qrUserResult.getQrCode());
                    DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
                } else {
                    view = GetStaticQrPresenter.this.moveToNextValue;
                    view.KClassImpl$Data$declaredNonStaticMembers$2("");
                    getUserDynamicQr = GetStaticQrPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    getUserDynamicQr.dispose();
                    GetStaticQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
                }
                GetStaticQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = qrUserResult.getQrCode();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getDynamicProfileQr$2
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
                GetStaticQrContract.View view;
                GetStaticQrContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                apiHitTimer = GetStaticQrPresenter.this.getAuthRequestContext;
                final GetStaticQrPresenter getStaticQrPresenter = GetStaticQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getDynamicProfileQr$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        GetStaticQrContract.View view3;
                        view3 = GetStaticQrPresenter.this.moveToNextValue;
                        view3.getAuthRequestContext(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.STATIC_QRCODE_PREFIX);
                sb.append(GetStaticQrPresenter.this.getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
                RequestMoneyErrorHelper requestMoneyErrorHelper = RequestMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = RequestMoneyErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(th).PlaceComponentResult;
                context = GetStaticQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String asString = uiTextModel.asString(context);
                view = GetStaticQrPresenter.this.moveToNextValue;
                view.dismissProgress();
                view2 = GetStaticQrPresenter.this.moveToNextValue;
                view2.onError(asString);
                GetStaticQrPresenter.getAuthRequestContext(GetStaticQrPresenter.this, asString, th);
            }
        });
    }

    @Override // id.dana.contract.staticqr.GetStaticQrContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<QrUserResult, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getStaticProfileQr$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QrUserResult qrUserResult) {
                invoke2(qrUserResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QrUserResult qrUserResult) {
                ApiHitTimer apiHitTimer;
                GetStaticQrContract.View view;
                GetStaticQrContract.View view2;
                Intrinsics.checkNotNullParameter(qrUserResult, "");
                apiHitTimer = GetStaticQrPresenter.this.getAuthRequestContext;
                final GetStaticQrPresenter getStaticQrPresenter = GetStaticQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getStaticProfileQr$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        GetStaticQrContract.View view3;
                        view3 = GetStaticQrPresenter.this.moveToNextValue;
                        view3.getAuthRequestContext(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                view = GetStaticQrPresenter.this.moveToNextValue;
                view.dismissProgress();
                view2 = GetStaticQrPresenter.this.moveToNextValue;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(qrUserResult.getQrCode());
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.STATIC_QRCODE_PREFIX);
                sb.append(GetStaticQrPresenter.this.getClass().getName());
                sb.append("onNext");
                sb.append(qrUserResult.getQrCode());
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getStaticProfileQr$2
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
                GetStaticQrContract.View view;
                GetStaticQrContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                apiHitTimer = GetStaticQrPresenter.this.getAuthRequestContext;
                final GetStaticQrPresenter getStaticQrPresenter = GetStaticQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getStaticProfileQr$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        GetStaticQrContract.View view3;
                        view3 = GetStaticQrPresenter.this.moveToNextValue;
                        view3.getAuthRequestContext(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.STATIC_QRCODE_PREFIX);
                sb.append(GetStaticQrPresenter.this.getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
                RequestMoneyErrorHelper requestMoneyErrorHelper = RequestMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = RequestMoneyErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(th).PlaceComponentResult;
                context = GetStaticQrPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String asString = uiTextModel.asString(context);
                view = GetStaticQrPresenter.this.moveToNextValue;
                view.dismissProgress();
                view2 = GetStaticQrPresenter.this.moveToNextValue;
                view2.onError(asString);
                GetStaticQrPresenter.getAuthRequestContext(GetStaticQrPresenter.this, asString, th);
            }
        });
    }

    @Override // id.dana.contract.staticqr.GetStaticQrContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<QrisTciCoConfig, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getQrisTcicoConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QrisTciCoConfig qrisTciCoConfig) {
                invoke2(qrisTciCoConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QrisTciCoConfig qrisTciCoConfig) {
                GetStaticQrContract.View view;
                Intrinsics.checkNotNullParameter(qrisTciCoConfig, "");
                view = GetStaticQrPresenter.this.moveToNextValue;
                view.getAuthRequestContext(QrisTciCoConfigModelKt.BuiltInFictitiousFunctionClassFactory(qrisTciCoConfig));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.staticqr.GetStaticQrPresenter$getQrisTcicoConfig$2
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
                GetStaticQrContract.View view;
                GetStaticQrContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.STATIC_QRCODE_PREFIX);
                sb.append(GetStaticQrPresenter.this.getClass().getName());
                sb.append(RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, sb.toString(), th);
                view = GetStaticQrPresenter.this.moveToNextValue;
                view.dismissProgress();
                view2 = GetStaticQrPresenter.this.moveToNextValue;
                view2.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.contract.staticqr.GetStaticQrContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(GetStaticQrPresenter getStaticQrPresenter, String str, Throwable th) {
        Throwable cause = th.getCause();
        NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
        if (networkException != null) {
            getStaticQrPresenter.moveToNextValue.PlaceComponentResult(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_USER, str, networkException.getMessage(), networkException.getErrorCode(), networkException.getTraceId());
        } else {
            getStaticQrPresenter.moveToNextValue.PlaceComponentResult(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_USER, str, th.getMessage(), "", "");
        }
    }
}
