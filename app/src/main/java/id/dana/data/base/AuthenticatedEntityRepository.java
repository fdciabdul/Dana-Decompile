package id.dana.data.base;

import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.mobile.common.rpc.RpcException;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.errorconfig.ErrorConfigFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.holdlogin.v2.HoldLoginFeatureFlag;
import id.dana.data.login.VerifyChallengeManager;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.login.source.LoginEntityDataFactory;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.network.exception.NetworkException;
import id.dana.network.response.login.LoginRpcResult;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
/* loaded from: classes2.dex */
public abstract class AuthenticatedEntityRepository implements HoldLoginV1Repository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    protected DeepLinkPayloadManager deepLinkPayloadManager;
    private final ErrorConfigFactory errorConfigFactory;
    protected final SecurityGuardFacade guardFacade;
    protected final HoldLoginFeatureFlag holdLoginFeatureFlag;
    private final LoginEntityDataFactory loginEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ LoginRpcResult lambda$holdLoginAndRetry$1(LoginRpcResult loginRpcResult, String str) throws Exception {
        return loginRpcResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$holdLoginAndRetry$4(Observable observable, LoginRpcResult loginRpcResult) throws Exception {
        return observable;
    }

    public AuthenticatedEntityRepository(AccountEntityDataFactory accountEntityDataFactory, LoginEntityDataFactory loginEntityDataFactory, SecurityGuardFacade securityGuardFacade, ErrorConfigFactory errorConfigFactory, HoldLoginFeatureFlag holdLoginFeatureFlag) {
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.loginEntityDataFactory = loginEntityDataFactory;
        this.guardFacade = securityGuardFacade;
        this.errorConfigFactory = errorConfigFactory;
        this.holdLoginFeatureFlag = holdLoginFeatureFlag;
    }

    @Inject
    public void buildDeepLinkPayloadDependencies(DeepLinkPayloadManager deepLinkPayloadManager) {
        this.deepLinkPayloadManager = deepLinkPayloadManager;
    }

    public <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        return this.holdLoginFeatureFlag.BuiltInFictitiousFunctionClassFactory() ? observable : observable.onErrorResumeNext(holdLoginAndRetry(observable));
    }

    public AccountEntityData createAccountData() {
        return this.accountEntityDataFactory.createData2("local");
    }

    public ErrorConfigEntityData createNetworkErrorConfigData() {
        return this.errorConfigFactory.createData2("network");
    }

    public ErrorConfigEntityData createLocalErrorConfigData() {
        return this.errorConfigFactory.createData2("local");
    }

    public LoginEntityData createNetworkLogin() {
        return this.loginEntityDataFactory.createData2("network");
    }

    public <T> Function<Throwable, ? extends Observable<? extends T>> holdLoginAndRetry(final Observable<T> observable) {
        return new Function() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AuthenticatedEntityRepository.this.m810x198c7a44(observable, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$holdLoginAndRetry$6$id-dana-data-base-AuthenticatedEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m810x198c7a44(final Observable observable, Throwable th) throws Exception {
        if (th instanceof RpcException) {
            final RpcException rpcException = (RpcException) th;
            if (rpcException.getCode() == 2000) {
                DeepLinkPayloadManager deepLinkPayloadManager = this.deepLinkPayloadManager;
                if (deepLinkPayloadManager != null) {
                    deepLinkPayloadManager.transferBackupPayload();
                }
                return Observable.zip(createAccountData().getUserId(), createAccountData().getClientKey(), new BiFunction() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda6
                    @Override // io.reactivex.functions.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        return AuthenticatedEntityRepository.lambda$holdLoginAndRetry$0((String) obj, (String) obj2);
                    }
                }).concatMap(new Function() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda7
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return AuthenticatedEntityRepository.this.m809x1a02e043(rpcException, observable, (Pair) obj);
                    }
                });
            }
        }
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            networkException.setErrorMessage(getErrorOfflineConfig(networkException.getErrorCode(), networkException.getMessage()));
        }
        return Observable.error(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Pair lambda$holdLoginAndRetry$0(String str, String str2) throws Exception {
        return new Pair(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$holdLoginAndRetry$5$id-dana-data-base-AuthenticatedEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m809x1a02e043(RpcException rpcException, final Observable observable, Pair pair) throws Exception {
        return createNetworkLogin().holdLogin((String) pair.getFirst(), (String) pair.getSecond(), rpcException.getOperationType()).flatMap(new Function() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AuthenticatedEntityRepository.this.m808x1b661240((LoginRpcResult) obj);
            }
        }).doOnError(new Consumer() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthenticatedEntityRepository.lambda$holdLoginAndRetry$3((Throwable) obj);
            }
        }).doOnNext(notifyPayApi()).concatMap(new Function() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AuthenticatedEntityRepository.lambda$holdLoginAndRetry$4(Observable.this, (LoginRpcResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$holdLoginAndRetry$2$id-dana-data-base-AuthenticatedEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m808x1b661240(final LoginRpcResult loginRpcResult) throws Exception {
        return createAccountData().saveClientKey(loginRpcResult.clientKey).map(new Function() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AuthenticatedEntityRepository.lambda$holdLoginAndRetry$1(LoginRpcResult.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$holdLoginAndRetry$3(Throwable th) throws Exception {
        try {
            Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter("holdLogin failed", "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log("holdLogin failed");
            Throwable cause = th.getCause();
            if (cause instanceof HoldLoginException) {
                HoldLoginException holdLoginException = (HoldLoginException) cause;
                StringBuilder sb = new StringBuilder();
                sb.append("rootCause: [");
                sb.append(holdLoginException.getErrorCode());
                sb.append("] ");
                sb.append(holdLoginException.getMessage());
                String obj = sb.toString();
                Intrinsics.checkNotNullParameter(obj, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("rootCause: ");
                sb2.append(th);
                sb2.append(" -> ");
                sb2.append(th.getMessage());
                String obj2 = sb2.toString();
                Intrinsics.checkNotNullParameter(obj2, "");
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj2);
                if (cause != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("cause: ");
                    sb3.append(cause);
                    sb3.append(" -> ");
                    sb3.append(cause.getMessage());
                    String obj3 = sb3.toString();
                    Intrinsics.checkNotNullParameter(obj3, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj3);
                }
            }
            Intrinsics.checkNotNullParameter(th, "");
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(th);
        } catch (Exception unused) {
        }
    }

    private String getErrorOfflineConfig(String str, String str2) {
        String errorMessageByKey = createLocalErrorConfigData().getErrorMessageByKey(str, createNetworkErrorConfigData().getErrorConfigAmcs());
        return !TextUtils.isEmpty(errorMessageByKey) ? errorMessageByKey : str2;
    }

    private Consumer<LoginRpcResult> notifyPayApi() {
        return new Consumer() { // from class: id.dana.data.base.AuthenticatedEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthenticatedEntityRepository.lambda$notifyPayApi$7((LoginRpcResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$notifyPayApi$7(LoginRpcResult loginRpcResult) throws Exception {
        if (!loginRpcResult.success || VerifyChallengeManager.isNeedChallenge(loginRpcResult.verificationMethods)) {
            return;
        }
        IAPLoginUserInfo iAPLoginUserInfo = new IAPLoginUserInfo();
        iAPLoginUserInfo.userID = loginRpcResult.userId;
        iAPLoginUserInfo.sessionID = loginRpcResult.sessionId;
        UserInfoManager.instance().loginNotify(iAPLoginUserInfo);
    }
}
