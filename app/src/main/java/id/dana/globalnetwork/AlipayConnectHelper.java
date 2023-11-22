package id.dana.globalnetwork;

import android.app.Application;
import android.content.Intent;
import com.alibaba.griver.api.common.GriverExtension;
import com.alipay.imobile.network.quake.exception.ServerException;
import com.iap.ac.android.biz.IAPConnect;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.model.InitConfig;
import com.iap.ac.android.biz.common.model.InitErrorCode;
import com.iap.ac.android.biz.common.proxy.HttpTransporter;
import com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import dagger.Lazy;
import id.dana.RxIAPConnectBus;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Injector;
import id.dana.data.ProductFlavor;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.domain.danah5.interactor.OpenH5;
import id.dana.domain.featureconfig.interactor.GetMarmotConfig;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;
import id.dana.iapconnectutil.IapConnectState;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.miniprogram.provider.OauthServiceProvider;
import id.dana.miniprogram.provider.TopUpServiceProvider;
import id.dana.oauth.OauthLoginManager;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.internal.util.NotificationLite;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ{\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\"\u0010\u0012\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00060\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001b\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u001a"}, d2 = {"Lid/dana/globalnetwork/AlipayConnectHelper;", "", "Landroid/app/Application;", "p0", "", "p1", "Ldagger/Lazy;", "Lid/dana/globalnetworkproxy/GlobalNetworkProxyContract$Presenter;", "p2", "Lid/dana/domain/danah5/interactor/OpenH5;", "p3", "Lid/dana/domain/geocode/interactor/GetLatestSubdivision;", "p4", "Lid/dana/domain/featureconfig/interactor/GetMarmotConfig;", "p5", "", "Ljava/lang/Class;", "Lcom/alibaba/griver/api/common/GriverExtension;", "p6", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Application;ZLdagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ljava/util/Map;)V", "PlaceComponentResult", "()Z", "MyBillsEntityDataFactory", "", "()Ljava/lang/String;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AlipayConnectHelper {
    public static final AlipayConnectHelper INSTANCE = new AlipayConnectHelper();

    private AlipayConnectHelper() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(final Application p0, boolean p1, Lazy<GlobalNetworkProxyContract.Presenter> p2, final Lazy<OpenH5> p3, final Lazy<GetLatestSubdivision> p4, final Lazy<GetMarmotConfig> p5, final Map<Class<? extends GriverExtension>, ? extends Lazy<? extends GriverExtension>> p6) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        Intrinsics.checkNotNullParameter(p6, "");
        synchronized (INSTANCE) {
            Object obj = RxIAPConnectBus.getAuthRequestContext().getErrorConfigVersion.get();
            RemoteGnPaymentEntityData remoteGnPaymentEntityData = null;
            if (!Intrinsics.areEqual((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj), IapConnectState.Loading.INSTANCE)) {
                RxIAPConnectBus.getAuthRequestContext().onNext(IapConnectState.Loading.INSTANCE);
                InitConfig initConfig = new InitConfig();
                initConfig.envType = PlaceComponentResult() ? "PROD" : "DEV";
                initConfig.userAgent = BuiltInFictitiousFunctionClassFactory();
                OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
                OauthLoginManager.getAuthRequestContext(p1);
                if (p1) {
                    final GlobalNetworkProxyContract.Presenter presenter = p2.get();
                    initConfig.networkProxy = new HttpTransporter() { // from class: id.dana.globalnetwork.AlipayConnectHelper$$ExternalSyntheticLambda0
                        @Override // com.iap.ac.android.biz.common.proxy.HttpTransporter
                        public final HttpResponse sendHttpRequest(HttpRequest httpRequest) {
                            HttpResponse authRequestContext;
                            authRequestContext = AlipayConnectHelper.getAuthRequestContext(GlobalNetworkProxyContract.Presenter.this, p0, httpRequest);
                            return authRequestContext;
                        }
                    };
                }
                OauthServiceProvider authRequestContext = OauthServiceProvider.INSTANCE.getAuthRequestContext();
                if (authRequestContext != null) {
                    RemoteGnPaymentEntityData remoteGnPaymentEntityData2 = authRequestContext.remoteGnPaymentEntityData;
                    if (remoteGnPaymentEntityData2 != null) {
                        remoteGnPaymentEntityData = remoteGnPaymentEntityData2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = remoteGnPaymentEntityData.gnAuthResultPublishSubject;
                }
                TopUpServiceProvider.Companion companion = TopUpServiceProvider.INSTANCE;
                TopUpServiceProvider.Companion.KClassImpl$Data$declaredNonStaticMembers$2(p0.getBaseContext());
                IAPConnect.init(p0, initConfig, new InitCallback() { // from class: id.dana.globalnetwork.AlipayConnectHelper$initSynchronized$2
                    @Override // com.iap.ac.android.biz.common.callback.InitCallback
                    public final void onSuccess() {
                        DanaH5.initialize(p0, p3, p5);
                        GContainer.initialize(p0);
                        DanaH5Injector.inject(p4, p6);
                        RxIAPConnectBus.getAuthRequestContext().onNext(IapConnectState.Finished.INSTANCE);
                    }

                    @Override // com.iap.ac.android.biz.common.callback.InitCallback
                    public final void onFailure(InitErrorCode p02, String p12) {
                        Intrinsics.checkNotNullParameter(p02, "");
                        Intrinsics.checkNotNullParameter(p12, "");
                        RxIAPConnectBus.getAuthRequestContext().onNext(IapConnectState.Error.INSTANCE);
                        StringBuilder sb = new StringBuilder();
                        sb.append("onInitializeFailed errorMessage == ");
                        sb.append(p12);
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, sb.toString());
                    }
                });
                if (!Intrinsics.areEqual(initConfig.envType, "PROD")) {
                    IAPSslPinner.INSTANCE.disableSslPinning();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final HttpResponse getAuthRequestContext(GlobalNetworkProxyContract.Presenter presenter, Application application, HttpRequest httpRequest) {
        boolean z;
        boolean z2;
        HttpResponse httpResponse = null;
        boolean z3 = false;
        try {
            Map<String, String> map = httpRequest.headers;
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            String str = httpRequest.data;
            if (str == null) {
                str = "";
            }
            httpResponse = presenter.PlaceComponentResult(map, str);
        } catch (ServerException e) {
            String str2 = httpRequest.data;
            boolean z4 = (str2 != null ? StringsKt.contains$default((CharSequence) str2, (CharSequence) LogConstants.Mpm.EndNodeType.PREPARE, false, 2, (Object) null) : false) && e.getCode() == 2000;
            String str3 = httpRequest.data;
            if (str3 != null && StringsKt.contains$default((CharSequence) str3, (CharSequence) "mpm.code.scan", false, 2, (Object) null)) {
                z3 = true;
            }
            if (z3 && e.getCode() == 2000) {
                DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().MyBillsEntityDataFactory = Boolean.TRUE;
            }
            z3 = z4;
        }
        if (z3) {
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            z = OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (!z) {
                OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                OauthLoginManager.PlaceComponentResult(true);
                Intent intent = new Intent(application.getBaseContext(), LocalConfigSplashActivity.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                application.getBaseContext().startActivity(intent);
            }
            while (true) {
                OauthLoginManager oauthLoginManager3 = OauthLoginManager.INSTANCE;
                z2 = OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (!z2) {
                    break;
                }
                Thread.sleep(1000L);
            }
        }
        if (z3) {
            Map<String, String> map2 = httpRequest.headers;
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            String str4 = httpRequest.data;
            return presenter.PlaceComponentResult(map2, str4 != null ? str4 : "");
        }
        return httpResponse;
    }

    @JvmName(name = "PlaceComponentResult")
    private static boolean PlaceComponentResult() {
        return Intrinsics.areEqual("production", "production") || Intrinsics.areEqual(ProductFlavor.PREPROD, "production");
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static String BuiltInFictitiousFunctionClassFactory() {
        String userAgent = UserAgentFactory.getUserAgent();
        if (PlaceComponentResult()) {
            return userAgent;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(userAgent);
        sb.append(" incontainerdebug/1.0.0");
        return sb.toString();
    }
}
