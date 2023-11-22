package id.dana.data.login.source.network;

import android.content.Context;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.login.source.HoldLoginEntityData;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.data.login.source.network.model.LoginType;
import id.dana.data.login.source.network.request.LoginRpcRequest;
import id.dana.domain.DefaultObserver;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import io.reactivex.Observable;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
@Deprecated
/* loaded from: classes2.dex */
public class NetworkHoldLoginEntityData extends SecureBaseNetwork<LoginRpcFacade> implements HoldLoginEntityData {
    private static final String TAG = "HoldLogin_InterruptedException";
    private LoginRpcResult cacheLoginRpcResult;
    private final Context context;
    private Throwable error;
    private HoldLoginConfig holdLoginConfig;
    private final Object object;
    private AtomicInteger requestCount;

    @Inject
    public NetworkHoldLoginEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, HoldLoginConfig holdLoginConfig) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.object = new Object();
        this.requestCount = new AtomicInteger(0);
        this.context = context;
        this.holdLoginConfig = holdLoginConfig;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<LoginRpcFacade> getFacadeClass() {
        return LoginRpcFacade.class;
    }

    @Override // id.dana.data.login.source.HoldLoginEntityData
    public Observable<LoginRpcResult> holdLogin(String str, String str2, final String str3) {
        this.requestCount.incrementAndGet();
        synchronized (this) {
            if (this.error instanceof HoldLoginException) {
                clearCacheWhenFinished();
                return Observable.error(new Throwable(this.error));
            }
            if (this.cacheLoginRpcResult == null) {
                FeatureHoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$2 = this.holdLoginConfig.KClassImpl$Data$declaredNonStaticMembers$2();
                final LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
                loginRpcRequest.credentials = str2;
                loginRpcRequest.envInfo = generateMobileEnvInfo();
                loginRpcRequest.loginId = str;
                loginRpcRequest.loginIdType = LoginIdType.MOBILE_NO;
                loginRpcRequest.loginType = LoginType.HOLD_LOGIN;
                wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkHoldLoginEntityData$$ExternalSyntheticLambda0
                    @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                    public final Object processFacade(Object obj) {
                        LoginRpcResult login;
                        login = ((LoginRpcFacade) obj).login(LoginRpcRequest.this);
                        return login;
                    }
                }, new HoldLoginExceptionParser(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getAuthRequestContext), LoginRpcResult.class).subscribe(new DefaultObserver<LoginRpcResult>() { // from class: id.dana.data.login.source.network.NetworkHoldLoginEntityData.1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public /* synthetic */ void onNext(Object obj) {
                        LoginRpcResult loginRpcResult = (LoginRpcResult) obj;
                        super.onNext(loginRpcResult);
                        NetworkHoldLoginEntityData.this.cacheLoginRpcResult = loginRpcResult;
                        NetworkHoldLoginEntityData.this.createTrackHoldLogin(str3);
                        synchronized (NetworkHoldLoginEntityData.this.object) {
                            NetworkHoldLoginEntityData.this.object.notifyAll();
                        }
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        NetworkHoldLoginEntityData.this.trackHoldLoginError(th, str3);
                        NetworkHoldLoginEntityData.this.cacheLoginRpcResult = null;
                        NetworkHoldLoginEntityData.this.error = th;
                        synchronized (NetworkHoldLoginEntityData.this.object) {
                            NetworkHoldLoginEntityData.this.object.notifyAll();
                        }
                    }
                });
                try {
                    synchronized (this.object) {
                        this.object.wait(10000L);
                    }
                } catch (InterruptedException e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, String.valueOf(e));
                }
            }
            LoginRpcResult loginRpcResult = this.cacheLoginRpcResult;
            Throwable th = this.error;
            clearCacheWhenFinished();
            if (loginRpcResult != null) {
                return Observable.just(loginRpcResult);
            }
            if (th == null) {
                th = new SocketTimeoutException();
            }
            return Observable.error(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTrackHoldLogin(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$user_id", UserInfoManager.instance().getUserId());
            jSONObject.put("Login Type", TrackerDataKey.LoginType.HOLD_LOGIN);
            jSONObject.put("Is Success", true);
            jSONObject.put("Operation Type", str);
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
        }
        MixPanelDataTracker.PlaceComponentResult(this.context, "Login", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackHoldLoginError(Throwable th, String str) {
        if (th instanceof HoldLoginException) {
            HoldLoginException holdLoginException = (HoldLoginException) th;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$user_id", UserInfoManager.instance().getUserId());
                jSONObject.put("Login Type", TrackerDataKey.LoginType.HOLD_LOGIN);
                jSONObject.put("errorCode", holdLoginException.getErrorCode());
                jSONObject.put("errorMessage", holdLoginException.getMessage());
                jSONObject.put("Is Success", false);
                jSONObject.put("Operation Type", str);
            } catch (JSONException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
            }
            MixPanelDataTracker.PlaceComponentResult(this.context, "Login", jSONObject);
        }
    }

    private void clearCacheWhenFinished() {
        if (this.requestCount.decrementAndGet() == 0) {
            this.cacheLoginRpcResult = null;
            this.error = null;
        }
    }
}
