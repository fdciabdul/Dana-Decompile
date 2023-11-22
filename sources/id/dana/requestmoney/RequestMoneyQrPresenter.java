package id.dana.requestmoney;

import android.content.Context;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckBranchDeepLinkFeature;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.model.QrisTciCoConfig;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.qrbarcode.QrUserResult;
import id.dana.domain.qrbarcode.interactor.GetTransferQr;
import id.dana.mapper.HomeInfoMapper;
import id.dana.myprofile.model.QrisTciCoConfigModelKt;
import id.dana.network.exception.NetworkException;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.requestmoney.util.RequestMoneyErrorHelper;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0016\u0012\u0006\u0010+\u001a\u00020\u001f\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u0010-\u001a\u00020\u0010\u0012\u0006\u0010.\u001a\u00020\u0019\u0012\u0006\u0010/\u001a\u00020\u000e¢\u0006\u0004\b0\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\r\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010\u0014\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010\u001a\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0016\u0010\u0017\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010$R\u0016\u0010\u0011\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010&R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/requestmoney/RequestMoneyQrPresenter;", "Lid/dana/requestmoney/RequestMoneyQrContract$Presenter;", "", "PlaceComponentResult", "()V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "p0", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "Lid/dana/sendmoney_v2/tracker/ApiHitTimer;", "Lid/dana/domain/featureconfig/interactor/CheckBranchDeepLinkFeature;", "lookAheadTest", "Lid/dana/domain/featureconfig/interactor/CheckBranchDeepLinkFeature;", "Landroid/content/Context;", "scheduleImpl", "Landroid/content/Context;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "Lid/dana/domain/featureconfig/interactor/GetQrisTcicoConfig;", "moveToNextValue", "Lid/dana/domain/featureconfig/interactor/GetQrisTcicoConfig;", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "getErrorConfigVersion", "Lid/dana/domain/qrbarcode/interactor/GetTransferQr;", "Lid/dana/domain/qrbarcode/interactor/GetTransferQr;", "Lid/dana/domain/homeinfo/interactor/GetHomeInfo;", "Lid/dana/domain/homeinfo/interactor/GetHomeInfo;", "Lid/dana/mapper/HomeInfoMapper;", "Lid/dana/mapper/HomeInfoMapper;", "Lid/dana/requestmoney/mapper/RequestMoneyInfoModelMapper;", "Lid/dana/requestmoney/mapper/RequestMoneyInfoModelMapper;", "Lid/dana/requestmoney/RequestMoneyQrContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/requestmoney/RequestMoneyQrContract$View;", "GetContactSyncConfig", "p2", "p3", "p4", "p5", "p6", "<init>", "(Landroid/content/Context;Lid/dana/domain/account/interactor/GetAvatarUrl;Lid/dana/domain/qrbarcode/interactor/GetTransferQr;Lid/dana/requestmoney/RequestMoneyQrContract$View;Lid/dana/domain/featureconfig/interactor/CheckBranchDeepLinkFeature;Lid/dana/domain/featureconfig/interactor/GetQrisTcicoConfig;Lid/dana/sendmoney_v2/tracker/ApiHitTimer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyQrPresenter implements RequestMoneyQrContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    GetHomeInfo moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    HomeInfoMapper NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    RequestMoneyInfoModelMapper lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetAvatarUrl PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final RequestMoneyQrContract.View GetContactSyncConfig;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ApiHitTimer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    GetRequestMoneyInfoFeature getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetTransferQr scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CheckBranchDeepLinkFeature KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetQrisTcicoConfig getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    @Inject
    public RequestMoneyQrPresenter(Context context, GetAvatarUrl getAvatarUrl, GetTransferQr getTransferQr, RequestMoneyQrContract.View view, CheckBranchDeepLinkFeature checkBranchDeepLinkFeature, GetQrisTcicoConfig getQrisTcicoConfig, ApiHitTimer apiHitTimer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(getAvatarUrl, "");
        Intrinsics.checkNotNullParameter(getTransferQr, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(checkBranchDeepLinkFeature, "");
        Intrinsics.checkNotNullParameter(getQrisTcicoConfig, "");
        Intrinsics.checkNotNullParameter(apiHitTimer, "");
        this.MyBillsEntityDataFactory = context;
        this.PlaceComponentResult = getAvatarUrl;
        this.scheduleImpl = getTransferQr;
        this.GetContactSyncConfig = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = checkBranchDeepLinkFeature;
        this.getAuthRequestContext = getQrisTcicoConfig;
        this.BuiltInFictitiousFunctionClassFactory = apiHitTimer;
    }

    @Override // id.dana.requestmoney.RequestMoneyQrContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        this.scheduleImpl.execute(GetTransferQr.Params.INSTANCE.forGetTransferQr(p0, p1), new Function1<QrUserResult, Unit>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getTransferQr$1
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
                RequestMoneyQrContract.View view;
                GetTransferQr getTransferQr;
                Intrinsics.checkNotNullParameter(qrUserResult, "");
                apiHitTimer = RequestMoneyQrPresenter.this.BuiltInFictitiousFunctionClassFactory;
                final RequestMoneyQrPresenter requestMoneyQrPresenter = RequestMoneyQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getTransferQr$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        RequestMoneyQrContract.View view2;
                        view2 = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                        view2.BuiltInFictitiousFunctionClassFactory(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                view = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                view.getAuthRequestContext(qrUserResult.getQrCode());
                List<String> qrCodeList = qrUserResult.getQrCodeList();
                if (qrCodeList == null || qrCodeList.isEmpty()) {
                    getTransferQr = RequestMoneyQrPresenter.this.scheduleImpl;
                    getTransferQr.dispose();
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getTransferQr$2
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
                RequestMoneyQrContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                apiHitTimer = RequestMoneyQrPresenter.this.BuiltInFictitiousFunctionClassFactory;
                final RequestMoneyQrPresenter requestMoneyQrPresenter = RequestMoneyQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getTransferQr$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        RequestMoneyQrContract.View view2;
                        view2 = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                        view2.BuiltInFictitiousFunctionClassFactory(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                RequestMoneyErrorHelper requestMoneyErrorHelper = RequestMoneyErrorHelper.INSTANCE;
                UiTextModel uiTextModel = RequestMoneyErrorHelper.KClassImpl$Data$declaredNonStaticMembers$2(th).PlaceComponentResult;
                context = RequestMoneyQrPresenter.this.MyBillsEntityDataFactory;
                String asString = uiTextModel.asString(context);
                view = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                view.KClassImpl$Data$declaredNonStaticMembers$2(asString);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.REQUEST_MONEY_QR_PREFIX);
                sb.append(RequestMoneyQrPresenter.this.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, sb.toString(), th);
                RequestMoneyQrPresenter.PlaceComponentResult(RequestMoneyQrPresenter.this, asString, th);
            }
        });
    }

    @Override // id.dana.requestmoney.RequestMoneyQrContract.Presenter
    public final void MyBillsEntityDataFactory() {
        GetHomeInfo getHomeInfo = this.moveToNextValue;
        if (getHomeInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getHomeInfo = null;
        }
        getHomeInfo.execute(new DefaultObserver<HomeInfoResponse>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getHomeInfo$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                HomeInfoMapper homeInfoMapper;
                HomeInfoResponse homeInfoResponse = (HomeInfoResponse) obj;
                Intrinsics.checkNotNullParameter(homeInfoResponse, "");
                homeInfoMapper = RequestMoneyQrPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (homeInfoMapper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    homeInfoMapper = null;
                }
                r0.PlaceComponentResult.execute(new DefaultObserver<String>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getProfileURL$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj2) {
                        RequestMoneyQrContract.View view;
                        String str = (String) obj2;
                        Intrinsics.checkNotNullParameter(str, "");
                        view = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                        view.PlaceComponentResult(r2, str);
                    }
                });
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.REQUEST_MONEY_HOMEINFO_PREFIX);
                sb.append(getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, sb.toString(), p0);
            }
        });
    }

    @Override // id.dana.requestmoney.RequestMoneyQrContract.Presenter
    public final void getAuthRequestContext() {
        GetRequestMoneyInfoFeature getRequestMoneyInfoFeature = this.getErrorConfigVersion;
        if (getRequestMoneyInfoFeature == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getRequestMoneyInfoFeature = null;
        }
        getRequestMoneyInfoFeature.execute(new DefaultObserver<RequestMoneyInfo>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$getRequestMoneyInfo$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                RequestMoneyQrContract.View view;
                RequestMoneyInfoModelMapper requestMoneyInfoModelMapper;
                RequestMoneyInfo requestMoneyInfo = (RequestMoneyInfo) obj;
                Intrinsics.checkNotNullParameter(requestMoneyInfo, "");
                view = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                requestMoneyInfoModelMapper = RequestMoneyQrPresenter.this.lookAheadTest;
                if (requestMoneyInfoModelMapper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    requestMoneyInfoModelMapper = null;
                }
                view.BuiltInFictitiousFunctionClassFactory(requestMoneyInfoModelMapper.apply(requestMoneyInfo));
            }
        });
    }

    @Override // id.dana.requestmoney.RequestMoneyQrContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$checkDeeplinkFeature$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                RequestMoneyQrContract.View view;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                view = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                view.getAuthRequestContext(booleanValue);
            }
        });
    }

    @Override // id.dana.requestmoney.RequestMoneyQrContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        BaseUseCase.execute$default(this.getAuthRequestContext, NoParams.INSTANCE, new Function1<QrisTciCoConfig, Unit>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$checkQrisFeature$1
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
                ApiHitTimer apiHitTimer;
                RequestMoneyQrContract.View view;
                Intrinsics.checkNotNullParameter(qrisTciCoConfig, "");
                apiHitTimer = RequestMoneyQrPresenter.this.BuiltInFictitiousFunctionClassFactory;
                final RequestMoneyQrPresenter requestMoneyQrPresenter = RequestMoneyQrPresenter.this;
                Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: id.dana.requestmoney.RequestMoneyQrPresenter$checkQrisFeature$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long j) {
                        RequestMoneyQrContract.View view2;
                        view2 = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                        view2.MyBillsEntityDataFactory(Long.valueOf(j));
                    }
                };
                Intrinsics.checkNotNullParameter(function1, "");
                apiHitTimer.getAuthRequestContext = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                function1.invoke(Long.valueOf(apiHitTimer.BuiltInFictitiousFunctionClassFactory()));
                apiHitTimer.PlaceComponentResult = 0L;
                apiHitTimer.getAuthRequestContext = 0L;
                view = RequestMoneyQrPresenter.this.GetContactSyncConfig;
                view.BuiltInFictitiousFunctionClassFactory(QrisTciCoConfigModelKt.BuiltInFictitiousFunctionClassFactory(qrisTciCoConfig));
            }
        }, null, 4, null);
    }

    @Override // id.dana.requestmoney.RequestMoneyQrContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl.dispose();
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.scheduleImpl.dispose();
        this.PlaceComponentResult.dispose();
        GetHomeInfo getHomeInfo = this.moveToNextValue;
        GetRequestMoneyInfoFeature getRequestMoneyInfoFeature = null;
        if (getHomeInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            getHomeInfo = null;
        }
        getHomeInfo.dispose();
        GetRequestMoneyInfoFeature getRequestMoneyInfoFeature2 = this.getErrorConfigVersion;
        if (getRequestMoneyInfoFeature2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            getRequestMoneyInfoFeature = getRequestMoneyInfoFeature2;
        }
        getRequestMoneyInfoFeature.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(RequestMoneyQrPresenter requestMoneyQrPresenter, String str, Throwable th) {
        Throwable cause = th.getCause();
        NetworkException networkException = cause instanceof NetworkException ? (NetworkException) cause : null;
        if (networkException != null) {
            requestMoneyQrPresenter.GetContactSyncConfig.getAuthRequestContext(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_TRANSFER, str, networkException.getMessage(), networkException.getErrorCode(), networkException.getTraceId());
        } else {
            requestMoneyQrPresenter.GetContactSyncConfig.getAuthRequestContext(TrackerDataKey.NetworkErrorOperationTypeProperty.REQUEST_MONEY_QR_TRANSFER, str, th.getMessage(), "", "");
        }
    }
}
