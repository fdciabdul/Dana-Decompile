package id.dana.data.network.interceptor;

import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.google.common.primitives.SignedBytes;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.login.VerifyChallengeManager;
import id.dana.data.login.source.LoginEntityDataFactory;
import id.dana.data.network.RpcProxy;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;

@Singleton
/* loaded from: classes2.dex */
public class HttpSessionInterceptor {
    final LoginEntityDataFactory BuiltInFictitiousFunctionClassFactory;
    final SecurityGuardFacade KClassImpl$Data$declaredNonStaticMembers$2;
    final AccountEntityDataFactory MyBillsEntityDataFactory;
    final LoginLogoutSubject getAuthRequestContext;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    public static final byte[] PlaceComponentResult = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 6;
    private static final Object getErrorConfigVersion = new Object();
    private boolean scheduleImpl = false;
    private AtomicInteger initRecordTimeStamp = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface ILoginResult {
        void MyBillsEntityDataFactory(boolean z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.data.network.interceptor.HttpSessionInterceptor.PlaceComponentResult
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r9 = r9 * 12
            int r9 = 16 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            r6 = r8
            r8 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r9 = r9 + r7
            int r7 = r9 + 2
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.network.interceptor.HttpSessionInterceptor.a(byte, int, int, java.lang.Object[]):void");
    }

    @Inject
    public HttpSessionInterceptor(LoginEntityDataFactory loginEntityDataFactory, SecurityGuardFacade securityGuardFacade, LoginLogoutSubject loginLogoutSubject, AccountEntityDataFactory accountEntityDataFactory) {
        this.BuiltInFictitiousFunctionClassFactory = loginEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = securityGuardFacade;
        this.getAuthRequestContext = loginLogoutSubject;
        this.MyBillsEntityDataFactory = accountEntityDataFactory;
    }

    public final HttpResponse getAuthRequestContext(RpcProxy rpcProxy, HttpRequest httpRequest, HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append("interceptResponse--> ");
        sb.append(httpRequest);
        sb.append("  \t | ");
        sb.append(httpResponse);
        sb.append("\t statusCode: ");
        sb.append(httpResponse.getStatusCode());
        DanaLog.MyBillsEntityDataFactory("HttpSessionInterceptor", sb.toString());
        if (httpResponse.getStatusCode() == 401) {
            this.initRecordTimeStamp.incrementAndGet();
            synchronized (getErrorConfigVersion) {
                this.scheduleImpl = false;
                while (!this.lookAheadTest && !this.scheduleImpl) {
                    getAuthRequestContext("requestCount: ");
                    if (!this.moveToNextValue) {
                        this.moveToNextValue = true;
                        final String replace = httpRequest.getUrl().replace("https://m.dana.id", "");
                        final ILoginResult iLoginResult = new ILoginResult() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda5
                            @Override // id.dana.data.network.interceptor.HttpSessionInterceptor.ILoginResult
                            public final void MyBillsEntityDataFactory(boolean z) {
                                HttpSessionInterceptor.MyBillsEntityDataFactory(HttpSessionInterceptor.this, z);
                            }
                        };
                        Observable.zip(this.MyBillsEntityDataFactory.createData2("local").getUserId(), this.MyBillsEntityDataFactory.createData2("local").getClientKey(), new BiFunction() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda2
                            @Override // io.reactivex.functions.BiFunction
                            public final Object apply(Object obj, Object obj2) {
                                return HttpSessionInterceptor.MyBillsEntityDataFactory((String) obj, (String) obj2);
                            }
                        }).concatMap(new Function() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda3
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj) {
                                HttpSessionInterceptor httpSessionInterceptor = HttpSessionInterceptor.this;
                                Pair pair = (Pair) obj;
                                return httpSessionInterceptor.BuiltInFictitiousFunctionClassFactory.createData2("network").holdLogin((String) pair.getFirst(), (String) pair.getSecond(), replace);
                            }
                        }).flatMap(new Function() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda6
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj) {
                                final HttpSessionInterceptor httpSessionInterceptor = HttpSessionInterceptor.this;
                                final LoginRpcResult loginRpcResult = (LoginRpcResult) obj;
                                if (loginRpcResult.success && !VerifyChallengeManager.isNeedChallenge(loginRpcResult.verificationMethods)) {
                                    CommonUtil.BuiltInFictitiousFunctionClassFactory(httpSessionInterceptor.KClassImpl$Data$declaredNonStaticMembers$2, loginRpcResult.userId);
                                    httpSessionInterceptor.getAuthRequestContext.setUserId(loginRpcResult.userId);
                                    return httpSessionInterceptor.MyBillsEntityDataFactory.createData2("local").init(loginRpcResult.userId).flatMap(new Function() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda0
                                        @Override // io.reactivex.functions.Function
                                        public final Object apply(Object obj2) {
                                            Boolean bool = (Boolean) obj2;
                                            return HttpSessionInterceptor.this.MyBillsEntityDataFactory.createData2("local").saveClientKey(loginRpcResult.clientKey);
                                        }
                                    }).concatMap(new Function() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda1
                                        @Override // io.reactivex.functions.Function
                                        public final Object apply(Object obj2) {
                                            ObservableSource just;
                                            String str = (String) obj2;
                                            just = Observable.just(LoginRpcResult.this);
                                            return just;
                                        }
                                    });
                                }
                                return Observable.just(loginRpcResult);
                            }
                        }).doOnNext(new Consumer() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor$$ExternalSyntheticLambda4
                            @Override // io.reactivex.functions.Consumer
                            public final void accept(Object obj) {
                                HttpSessionInterceptor httpSessionInterceptor = HttpSessionInterceptor.this;
                                LoginRpcResult loginRpcResult = (LoginRpcResult) obj;
                                if (!loginRpcResult.success || VerifyChallengeManager.isNeedChallenge(loginRpcResult.verificationMethods)) {
                                    return;
                                }
                                httpSessionInterceptor.getAuthRequestContext.setUserId(loginRpcResult.userId);
                                IAPLoginUserInfo iAPLoginUserInfo = new IAPLoginUserInfo();
                                iAPLoginUserInfo.userID = loginRpcResult.userId;
                                iAPLoginUserInfo.sessionID = loginRpcResult.sessionId;
                                UserInfoManager.instance().loginNotify(iAPLoginUserInfo);
                            }
                        }).subscribe(new Observer<LoginRpcResult>() { // from class: id.dana.data.network.interceptor.HttpSessionInterceptor.1
                            @Override // io.reactivex.Observer
                            public void onComplete() {
                            }

                            @Override // io.reactivex.Observer
                            public void onSubscribe(Disposable disposable) {
                            }

                            @Override // io.reactivex.Observer
                            public /* synthetic */ void onNext(LoginRpcResult loginRpcResult) {
                                LoginRpcResult loginRpcResult2 = loginRpcResult;
                                ILoginResult iLoginResult2 = iLoginResult;
                                if (iLoginResult2 != null) {
                                    iLoginResult2.MyBillsEntityDataFactory(loginRpcResult2.success);
                                }
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                                ILoginResult iLoginResult2 = iLoginResult;
                                if (iLoginResult2 != null) {
                                    iLoginResult2.MyBillsEntityDataFactory(false);
                                }
                            }
                        });
                    }
                    try {
                        getErrorConfigVersion.wait(100L);
                    } catch (InterruptedException e) {
                        DanaLog.BuiltInFictitiousFunctionClassFactory("HttpSessionInterceptor", "InterruptedException", e);
                        try {
                            byte b = PlaceComponentResult[15];
                            byte b2 = (byte) (b - 1);
                            Object[] objArr = new Object[1];
                            a(b, b2, b2, objArr);
                            Class<?> cls = Class.forName((String) objArr[0]);
                            byte b3 = (byte) (PlaceComponentResult[15] - 1);
                            byte b4 = PlaceComponentResult[15];
                            Object[] objArr2 = new Object[1];
                            a(b3, b4, b4, objArr2);
                            ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    }
                }
                try {
                    try {
                        httpResponse = KClassImpl$Data$declaredNonStaticMembers$2(rpcProxy, httpRequest, httpResponse);
                    } finally {
                        if (this.initRecordTimeStamp.decrementAndGet() == 0) {
                            this.lookAheadTest = false;
                            this.moveToNextValue = false;
                        }
                    }
                } catch (Exception e2) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("HttpSessionInterceptor", "HoldLogin", e2);
                    throw e2;
                }
            }
        }
        return httpResponse;
    }

    private HttpResponse KClassImpl$Data$declaredNonStaticMembers$2(RpcProxy rpcProxy, HttpRequest httpRequest, HttpResponse httpResponse) {
        synchronized (getErrorConfigVersion) {
            if (this.lookAheadTest) {
                getAuthRequestContext("retry!!!! requestCount: ");
                httpResponse = rpcProxy.KClassImpl$Data$declaredNonStaticMembers$2(httpRequest);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("holdLogin fail after session expired in aphome\t requestCount: ");
                sb.append(this.initRecordTimeStamp.get());
                sb.append("\tjumpOut: ");
                sb.append(this.scheduleImpl);
                sb.append("\tloginSuc: ");
                sb.append(this.lookAheadTest);
                sb.append("\tloginBegin: ");
                sb.append(this.moveToNextValue);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.H5APHOME_REQUEST, DanaLogConstants.ExceptionType.APHOME_HOLDLOGIN_FAIL_EXCEPTION, sb.toString());
            }
        }
        return httpResponse;
    }

    private void getAuthRequestContext(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.initRecordTimeStamp.get());
        sb.append("\tjumpOut: ");
        sb.append(this.scheduleImpl);
        sb.append("\tloginSuc: ");
        sb.append(this.lookAheadTest);
        sb.append("\tloginBegin: ");
        sb.append(this.moveToNextValue);
        DanaLog.MyBillsEntityDataFactory("HttpSessionInterceptor", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Pair MyBillsEntityDataFactory(String str, String str2) throws Exception {
        return new Pair(str, str2);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(HttpSessionInterceptor httpSessionInterceptor, boolean z) {
        synchronized (getErrorConfigVersion) {
            StringBuilder sb = new StringBuilder();
            sb.append("loginResult: ");
            sb.append(z);
            DanaLog.MyBillsEntityDataFactory("HttpSessionInterceptor", sb.toString());
            if (z) {
                httpSessionInterceptor.lookAheadTest = true;
                httpSessionInterceptor.moveToNextValue = false;
            } else {
                httpSessionInterceptor.lookAheadTest = false;
                httpSessionInterceptor.moveToNextValue = false;
                httpSessionInterceptor.scheduleImpl = true;
            }
        }
    }
}
