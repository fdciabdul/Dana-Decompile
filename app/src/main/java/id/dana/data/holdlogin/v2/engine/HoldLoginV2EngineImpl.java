package id.dana.data.holdlogin.v2.engine;

import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.holdlogin.HoldLoginUtils;
import id.dana.data.holdlogin.v2.entity.HoldLoginEntityData;
import id.dana.data.holdlogin.v2.entity.HoldLoginEntityDataFactory;
import id.dana.data.holdlogin.v2.entity.HoldLoginResult;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.login.VerifyChallengeManager;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.response.login.RpcUserInfo;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\u0006\u0010\"\u001a\u00020\u0015\u0012\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\f\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0019\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010\u0016\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001e"}, d2 = {"Lid/dana/data/holdlogin/v2/engine/HoldLoginV2EngineImpl;", "Lid/dana/data/holdlogin/v2/engine/HoldLoginV2Engine;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;)V", "", "Lio/reactivex/Observable;", "Lid/dana/data/holdlogin/v2/entity/HoldLoginResult;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/deeplink/DeepLinkPayloadManager;", "Lid/dana/data/deeplink/DeepLinkPayloadManager;", "Lid/dana/data/config/DeviceInformationProvider;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/config/DeviceInformationProvider;", "MyBillsEntityDataFactory", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "getErrorConfigVersion", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityDataFactory;", "scheduleImpl", "Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityDataFactory;", "Lid/dana/data/login/LoginLogoutSubject;", "Lid/dana/data/login/LoginLogoutSubject;", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/foundation/facade/SecurityGuardFacade;Lid/dana/data/login/LoginLogoutSubject;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HoldLoginV2EngineImpl implements HoldLoginV2Engine {
    DeepLinkPayloadManager BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DeviceInformationProvider MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final SecurityGuardFacade getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final LoginLogoutSubject scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final AccountEntityDataFactory PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final HoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final HoldLoginEntityDataFactory getAuthRequestContext;

    @Inject
    public HoldLoginV2EngineImpl(AccountEntityDataFactory accountEntityDataFactory, SecurityGuardFacade securityGuardFacade, LoginLogoutSubject loginLogoutSubject, DeviceInformationProvider deviceInformationProvider, HoldLoginConfig holdLoginConfig, HoldLoginEntityDataFactory holdLoginEntityDataFactory) {
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityGuardFacade, "");
        Intrinsics.checkNotNullParameter(loginLogoutSubject, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        Intrinsics.checkNotNullParameter(holdLoginEntityDataFactory, "");
        this.PlaceComponentResult = accountEntityDataFactory;
        this.getErrorConfigVersion = securityGuardFacade;
        this.scheduleImpl = loginLogoutSubject;
        this.MyBillsEntityDataFactory = deviceInformationProvider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginConfig;
        this.getAuthRequestContext = holdLoginEntityDataFactory;
    }

    @Override // id.dana.data.holdlogin.v2.engine.HoldLoginV2Engine
    public final Observable<HoldLoginResult> BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DeepLinkPayloadManager deepLinkPayloadManager = this.BuiltInFictitiousFunctionClassFactory;
        if (deepLinkPayloadManager != null) {
            deepLinkPayloadManager.transferBackupPayload();
        }
        AccountEntityData createData2 = this.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<String> userId = createData2.getUserId();
        AccountEntityData createData22 = this.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData22, "");
        Observable<HoldLoginResult> flatMap = Observable.zip(userId, createData22.getClientKey(), new BiFunction() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return HoldLoginV2EngineImpl.getAuthRequestContext((String) obj, (String) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HoldLoginV2EngineImpl.getAuthRequestContext(HoldLoginV2EngineImpl.this, p0, (Pair) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginUtils holdLoginUtils = HoldLoginUtils.INSTANCE;
        HoldLoginUtils.getAuthRequestContext(p0);
        HoldLoginUtils.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    public static /* synthetic */ HoldLoginResult MyBillsEntityDataFactory(LoginRpcResult loginRpcResult) {
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        return new HoldLoginResult.Success(loginRpcResult);
    }

    public static /* synthetic */ Pair getAuthRequestContext(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return TuplesKt.to(str, str2);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(HoldLoginV2EngineImpl holdLoginV2EngineImpl, LoginRpcResult loginRpcResult, Boolean bool) {
        Intrinsics.checkNotNullParameter(holdLoginV2EngineImpl, "");
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        Intrinsics.checkNotNullParameter(bool, "");
        AccountEntityData createData2 = holdLoginV2EngineImpl.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2.saveClientKey(loginRpcResult.clientKey);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(final HoldLoginV2EngineImpl holdLoginV2EngineImpl, final LoginRpcResult loginRpcResult) {
        Intrinsics.checkNotNullParameter(holdLoginV2EngineImpl, "");
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        AccountEntityData createData2 = holdLoginV2EngineImpl.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2.getAccount().concatMap(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HoldLoginV2EngineImpl.KClassImpl$Data$declaredNonStaticMembers$2(HoldLoginV2EngineImpl.this, loginRpcResult, (AccountEntity) obj);
            }
        }).map(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HoldLoginV2EngineImpl.MyBillsEntityDataFactory(LoginRpcResult.this, (AccountEntity) obj);
            }
        });
    }

    public static /* synthetic */ LoginRpcResult getAuthRequestContext(LoginRpcResult loginRpcResult, Throwable th) {
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        Intrinsics.checkNotNullParameter(th, "");
        return loginRpcResult;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(final HoldLoginV2EngineImpl holdLoginV2EngineImpl, String str, Pair pair) {
        String str2;
        Observable<LoginRpcResult> authRequestContext;
        Intrinsics.checkNotNullParameter(holdLoginV2EngineImpl, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(pair, "");
        String str3 = (String) pair.component1();
        String str4 = (String) pair.component2();
        boolean builtInFictitiousFunctionClassFactory = holdLoginV2EngineImpl.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().getBuiltInFictitiousFunctionClassFactory();
        if (builtInFictitiousFunctionClassFactory) {
            str2 = "old_hold_login";
        } else if (builtInFictitiousFunctionClassFactory) {
            throw new NoWhenBranchMatchedException();
        } else {
            str2 = "new_hold_login";
        }
        final HoldLoginEntityData createData2 = holdLoginV2EngineImpl.getAuthRequestContext.createData2(str2);
        if (holdLoginV2EngineImpl.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().getMyBillsEntityDataFactory()) {
            Intrinsics.checkNotNullExpressionValue(str3, "");
            Intrinsics.checkNotNullExpressionValue(str4, "");
            authRequestContext = createData2.BuiltInFictitiousFunctionClassFactory(str3, str4, str);
        } else {
            Intrinsics.checkNotNullExpressionValue(str3, "");
            Intrinsics.checkNotNullExpressionValue(str4, "");
            authRequestContext = createData2.getAuthRequestContext(str3, str4, str);
        }
        return authRequestContext.flatMap(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable just;
                final HoldLoginV2EngineImpl holdLoginV2EngineImpl2 = HoldLoginV2EngineImpl.this;
                final LoginRpcResult loginRpcResult = (LoginRpcResult) obj;
                Intrinsics.checkNotNullParameter(loginRpcResult, "");
                if (loginRpcResult.success && !VerifyChallengeManager.isNeedChallenge(loginRpcResult.verificationMethods)) {
                    CommonUtil.BuiltInFictitiousFunctionClassFactory(holdLoginV2EngineImpl2.getErrorConfigVersion, loginRpcResult.userId);
                    AccountEntityData createData22 = holdLoginV2EngineImpl2.PlaceComponentResult.createData2("local");
                    Intrinsics.checkNotNullExpressionValue(createData22, "");
                    just = createData22.init(loginRpcResult.userId).flatMap(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda1
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return HoldLoginV2EngineImpl.getAuthRequestContext(HoldLoginV2EngineImpl.this, loginRpcResult, (Boolean) obj2);
                        }
                    }).map(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda2
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return HoldLoginV2EngineImpl.getAuthRequestContext(LoginRpcResult.this, (String) obj2);
                        }
                    }).onErrorReturn(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda3
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return HoldLoginV2EngineImpl.getAuthRequestContext(LoginRpcResult.this, (Throwable) obj2);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(just, "");
                } else {
                    just = Observable.just(loginRpcResult);
                    Intrinsics.checkNotNullExpressionValue(just, "");
                }
                return just;
            }
        }).flatMap(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable just;
                final HoldLoginV2EngineImpl holdLoginV2EngineImpl2 = HoldLoginV2EngineImpl.this;
                final LoginRpcResult loginRpcResult = (LoginRpcResult) obj;
                Intrinsics.checkNotNullParameter(loginRpcResult, "");
                if (loginRpcResult.success && !VerifyChallengeManager.isNeedChallenge(loginRpcResult.verificationMethods)) {
                    just = Observable.defer(new Callable() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return HoldLoginV2EngineImpl.BuiltInFictitiousFunctionClassFactory(HoldLoginV2EngineImpl.this, loginRpcResult);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(just, "");
                } else {
                    just = Observable.just(loginRpcResult);
                    Intrinsics.checkNotNullExpressionValue(just, "");
                }
                return just;
            }
        }).doOnError(new Consumer() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HoldLoginV2EngineImpl.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HoldLoginV2EngineImpl holdLoginV2EngineImpl2 = HoldLoginV2EngineImpl.this;
                LoginRpcResult loginRpcResult = (LoginRpcResult) obj;
                Intrinsics.checkNotNullParameter(loginRpcResult, "");
                HoldLoginUtils holdLoginUtils = HoldLoginUtils.INSTANCE;
                HoldLoginUtils.getAuthRequestContext(loginRpcResult);
                String PlaceComponentResult = HoldLoginUtils.PlaceComponentResult(loginRpcResult);
                if (PlaceComponentResult != null) {
                    holdLoginV2EngineImpl2.scheduleImpl.setUserId(PlaceComponentResult);
                }
            }
        }).map(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HoldLoginV2EngineImpl.MyBillsEntityDataFactory((LoginRpcResult) obj);
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HoldLoginV2EngineImpl.PlaceComponentResult((Throwable) obj);
            }
        }).doOnDispose(new Action() { // from class: id.dana.data.holdlogin.v2.engine.HoldLoginV2EngineImpl$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Action
            public final void run() {
                HoldLoginV2EngineImpl.BuiltInFictitiousFunctionClassFactory(HoldLoginEntityData.this);
            }
        });
    }

    public static /* synthetic */ HoldLoginResult PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new HoldLoginResult.Error(th);
    }

    public static /* synthetic */ LoginRpcResult getAuthRequestContext(LoginRpcResult loginRpcResult, String str) {
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        Intrinsics.checkNotNullParameter(str, "");
        return loginRpcResult;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(HoldLoginV2EngineImpl holdLoginV2EngineImpl, LoginRpcResult loginRpcResult, AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(holdLoginV2EngineImpl, "");
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        AccountEntityData createData2 = holdLoginV2EngineImpl.PlaceComponentResult.createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        String str = loginRpcResult.userId;
        String str2 = loginRpcResult.sessionId;
        RpcUserInfo rpcUserInfo = loginRpcResult.userInfo;
        String str3 = rpcUserInfo != null ? rpcUserInfo.nickname : null;
        RpcUserInfo rpcUserInfo2 = loginRpcResult.userInfo;
        return createData2.saveAccount(phoneNumber, str, str2, str3, rpcUserInfo2 != null ? rpcUserInfo2.avatarUrl : null, holdLoginV2EngineImpl.MyBillsEntityDataFactory.getDeviceUUID());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HoldLoginEntityData holdLoginEntityData) {
        Intrinsics.checkNotNullParameter(holdLoginEntityData, "");
        holdLoginEntityData.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ LoginRpcResult MyBillsEntityDataFactory(LoginRpcResult loginRpcResult, AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(loginRpcResult, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return loginRpcResult;
    }
}
