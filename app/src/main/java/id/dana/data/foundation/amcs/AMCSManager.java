package id.dana.data.foundation.amcs;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.iap.android.common.utils.MiscUtils;
import com.alipay.mobile.common.logging.api.LoggerFactory;
import com.iap.ac.android.common.instance.IInstanceInfo;
import com.iap.ac.android.common.instance.InstanceInfo;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.rpc.RpcAppInfo;
import com.iap.ac.android.instance.IAPInstanceInfo;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import com.iap.ac.android.rpc.RpcProxyImpl;
import com.iap.ac.android.rpc.multigateway.RpcGatewayController;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.delegate.ConfigIdentifierProvider;
import com.iap.ac.config.lite.utils.ConfigUtils;
import com.ut.device.UTDevice;
import id.dana.data.BuildConfig;
import id.dana.utils.foundation.SignatureUtils;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

@Singleton
/* loaded from: classes.dex */
public class AMCSManager {
    private boolean PlaceComponentResult;
    public final List<Listener> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    private String getAuthRequestContext = "125c";

    /* loaded from: classes.dex */
    public interface Listener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Inject
    public AMCSManager(Context context) {
        MyBillsEntityDataFactory(context, "prod");
    }

    public final void MyBillsEntityDataFactory(Context context, String str) {
        if (this.PlaceComponentResult) {
            return;
        }
        getAuthRequestContext(context, str);
        LoggerFactory.init(context);
        SyncTriggerMonitor.getAuthRequestContext();
        UserInfoManager.instance().addUserChangeObserver(new IAPUserChangeObserver() { // from class: id.dana.data.foundation.amcs.AMCSManager.1
            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public void onUserChanged(IAPLoginUserInfo iAPLoginUserInfo) {
                ConfigCenter.getInstance().refreshConfig();
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public void onUserLogin(IAPLoginUserInfo iAPLoginUserInfo) {
                ConfigCenter.getInstance().refreshConfig();
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public void onUserLogout() {
                ConfigCenter.getInstance().refreshConfig();
            }
        });
        if (SignatureUtils.getAuthRequestContext(context)) {
            return;
        }
        this.getAuthRequestContext = "0a6a_prod";
    }

    private void getAuthRequestContext(final Context context, final String str) {
        RpcAppInfo rpcAppInfo = new RpcAppInfo();
        rpcAppInfo.appId = BuildConfig.AMCS_LITE_GATEWAY_APP_ID;
        rpcAppInfo.rpcGateWayUrl = BuildConfig.AMCS_LITE_GATEWAY_URL;
        rpcAppInfo.addHeader("workspaceId", "default");
        rpcAppInfo.authCode = this.getAuthRequestContext;
        InstanceInfo.setInstanceInfoImpl(new IInstanceInfo() { // from class: id.dana.data.foundation.amcs.AMCSManager.2
            @Override // com.iap.ac.android.common.instance.IInstanceInfo
            public String getInstanceId(Context context2) {
                return IAPInstanceInfo.instanceId(context2);
            }

            @Override // com.iap.ac.android.common.instance.IInstanceInfo
            public String getTid(Context context2) {
                return IAPInstanceInfo.tid(context2);
            }
        });
        RpcProxyImpl rpcProxyImpl = RpcProxyImpl.getInstance();
        rpcProxyImpl.initialize(context, rpcAppInfo);
        RPCProxyHost.setRpcProxy(rpcProxyImpl);
        RpcGatewayController.initGatewayController(context);
        final ConfigCenter configCenter = ConfigCenter.getInstance();
        final ConfigCenterContext configCenterContext = new ConfigCenterContext(context, rpcAppInfo, str, null, "default", BuildConfig.AMCS_LITE_APP_ID, null);
        configCenterContext.setIdentifierProvider(new ConfigIdentifierProvider() { // from class: id.dana.data.foundation.amcs.AMCSManager.3
            @Override // com.iap.ac.config.lite.delegate.ConfigIdentifierProvider
            public String getUtdId(Context context2) {
                return UTDevice.getUtdid(context2);
            }

            @Override // com.iap.ac.config.lite.delegate.ConfigIdentifierProvider
            public String getConfigUserId(Context context2) {
                String userId = UserInfoManager.instance().getUserId();
                return TextUtils.isEmpty(userId) ? "" : MiscUtils.md5(userId);
            }
        });
        configCenterContext.setDnsServer("223.5.5.5");
        configCenterContext.setVersion(ConfigCenterContext.SchemeVersion.V1);
        Single PlaceComponentResult = Single.PlaceComponentResult(new Callable() { // from class: id.dana.data.foundation.amcs.AMCSManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AMCSManager.BuiltInFictitiousFunctionClassFactory(ConfigCenter.this, configCenterContext);
            }
        });
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult, MyBillsEntityDataFactory));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.data.foundation.amcs.AMCSManager$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                AMCSManager.this.getAuthRequestContext(context, str, configCenter, configCenterContext);
            }
        }, new Consumer() { // from class: id.dana.data.foundation.amcs.AMCSManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AMCSManager aMCSManager = AMCSManager.this;
                Context context2 = context;
                String str2 = str;
                ConfigCenter configCenter2 = configCenter;
                ConfigCenterContext configCenterContext2 = configCenterContext;
                DanaLog.BuiltInFictitiousFunctionClassFactory("AMCSManager", "ConfigCenter Initialization fail", (Throwable) obj);
                aMCSManager.getAuthRequestContext(context2, str2, configCenter2, configCenterContext2);
            }
        });
        this.PlaceComponentResult = true;
        Iterator<Listener> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean BuiltInFictitiousFunctionClassFactory(ConfigCenter configCenter, ConfigCenterContext configCenterContext) throws Exception {
        configCenter.initialize(configCenterContext);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(Context context, String str, ConfigCenter configCenter, ConfigCenterContext configCenterContext) {
        configCenter.refreshConfig();
        ConfigUtils.setConfigProxy();
        ConfigUpdateSyncTrigger configUpdateSyncTrigger = new ConfigUpdateSyncTrigger();
        Intrinsics.checkNotNullParameter(configCenterContext, "");
        LoggerWrapper.d("ConfigUpdateSyncTrigger", "startTrigger");
        configUpdateSyncTrigger.PlaceComponentResult(configCenterContext);
        SyncUtils.BuiltInFictitiousFunctionClassFactory(context, str, this.getAuthRequestContext);
        ConfigUpdateSyncTrigger configUpdateSyncTrigger2 = new ConfigUpdateSyncTrigger();
        Intrinsics.checkNotNullParameter(configCenterContext, "");
        LoggerWrapper.d("ConfigUpdateSyncTrigger", "startTrigger");
        configUpdateSyncTrigger2.PlaceComponentResult(configCenterContext);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }
}
