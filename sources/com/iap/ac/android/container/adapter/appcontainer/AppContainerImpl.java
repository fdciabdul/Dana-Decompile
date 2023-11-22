package com.iap.ac.android.container.adapter.appcontainer;

import android.content.Context;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.provider.H5JSApiPermissionProvider;
import com.alipay.mobile.nebula.provider.H5ReceivedSslErrorHandler;
import com.alipay.mobile.nebula.provider.H5UaProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.alipay.mobile.nebula.webview.APWebView;
import com.iap.ac.android.common.container.IContainer;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;
import com.iap.ac.android.common.container.provider.ReceivedSslErrorHandler;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.appcontainer.provider.AppJSApiPermissionProvider;
import com.iap.ac.android.container.adapter.appcontainer.provider.AppSslErrorHandler;
import com.iap.ac.android.container.adapter.appcontainer.provider.AppUaProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppContainerImpl implements IContainer {
    private static final String TAG = "AppContainerImpl";
    private Map<BaseJSPlugin, AppContainerJSPlugin> base2JSPlugin = new HashMap();
    private Map<BaseContainerPlugin, AppContainerPlugin> base2Plugin = new HashMap();

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, String str) {
        startContainer(context, str, (IContainerListener) null);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, String str, IContainerListener iContainerListener) {
        startContainer(context, new ContainerParams(str), iContainerListener);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, ContainerParams containerParams) {
        startContainer(context, containerParams, (IContainerListener) null);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void startContainer(Context context, ContainerParams containerParams, IContainerListener iContainerListener) {
        if (!ContainerUtils.isAppContainerInit()) {
            ACLog.e(TAG, "startContainer error! AppContainer not initialized.");
        } else if (containerParams == null) {
            ACLog.e(TAG, "startContainer error! containerParams is null!");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("url", containerParams.url);
            bundle.putString("openUrlMethod", containerParams.startMethod.value);
            bundle.putString("openUrlPostParams", containerParams.postParams);
            if (containerParams.containerBundle != null) {
                bundle.putAll(containerParams.containerBundle);
            }
            AppContainerKit.getInstance().startContainerActivity(context, bundle, new AppContainerWebListener(iContainerListener));
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void setProvider(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        if (h5Service == null) {
            ACLog.e(TAG, "setProvider error! AppContainer not initialized.");
        } else if (str.equals(ContainerUaProvider.class.getName())) {
            AppContainerKit.getInstance().setProvider(H5UaProvider.class.getName(), new AppUaProvider((H5UaProvider) h5Service.getProviderManager().getProvider(H5UaProvider.class.getName()), (ContainerUaProvider) obj) { // from class: com.iap.ac.android.container.adapter.appcontainer.AppContainerImpl.1
            });
        } else if (str.equals(JsApiPermissionProvider.class.getName())) {
            AppContainerKit.getInstance().setProvider(H5JSApiPermissionProvider.class.getName(), new AppJSApiPermissionProvider((H5JSApiPermissionProvider) h5Service.getProviderManager().getProvider(H5JSApiPermissionProvider.class.getName()), (JsApiPermissionProvider) obj) { // from class: com.iap.ac.android.container.adapter.appcontainer.AppContainerImpl.2
            });
        } else if (str.equals(ReceivedSslErrorHandler.class.getName())) {
            final ReceivedSslErrorHandler receivedSslErrorHandler = (ReceivedSslErrorHandler) obj;
            AppContainerKit.getInstance().setProvider(H5ReceivedSslErrorHandler.class.getName(), new H5ReceivedSslErrorHandler() { // from class: com.iap.ac.android.container.adapter.appcontainer.AppContainerImpl.3
                public void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
                    receivedSslErrorHandler.onReceivedSslError(new AppContainerWebView(aPWebView), new AppSslErrorHandler(aPSslErrorHandler), sslError);
                }
            });
        } else {
            AppContainerKit.getInstance().setProvider(str, obj);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        synchronized (this) {
            if (baseJSPlugin == null) {
                return;
            }
            if (!ContainerUtils.isAppContainerInit()) {
                ACLog.e(TAG, "registerJSAPIPlugin error! AppContainer not initialized.");
                return;
            }
            AppContainerJSPlugin appContainerJSPlugin = new AppContainerJSPlugin(baseJSPlugin);
            this.base2JSPlugin.put(baseJSPlugin, appContainerJSPlugin);
            AppContainerKit.getInstance().registerPlugin(appContainerJSPlugin);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        synchronized (this) {
            if (baseJSPlugin == null) {
                return;
            }
            if (!ContainerUtils.isAppContainerInit()) {
                ACLog.e(TAG, "unregisterJSAPIPlugin error! AppContainer not initialized.");
                return;
            }
            Map<BaseJSPlugin, AppContainerJSPlugin> map = this.base2JSPlugin;
            if (map != null && !map.isEmpty() && this.base2JSPlugin.get(baseJSPlugin) != null) {
                AppContainerKit.getInstance().unRegisterPlugin(this.base2JSPlugin.get(baseJSPlugin));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterJSAPIPlugin fail: Cannot find plugin. ");
            sb.append(baseJSPlugin);
            ACLog.w(TAG, sb.toString());
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean registerPlugin(BaseContainerPlugin baseContainerPlugin) {
        synchronized (this) {
            if (baseContainerPlugin == null) {
                return false;
            }
            if (!ContainerUtils.isAppContainerInit()) {
                ACLog.e(TAG, "registerPlugin error! AppContainer not initialized.");
                return false;
            }
            AppContainerPlugin appContainerPlugin = new AppContainerPlugin(baseContainerPlugin);
            this.base2Plugin.put(baseContainerPlugin, appContainerPlugin);
            AppContainerKit.getInstance().registerPlugin(appContainerPlugin);
            return true;
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterPlugin(BaseContainerPlugin baseContainerPlugin) {
        synchronized (this) {
            if (baseContainerPlugin == null) {
                return;
            }
            if (!ContainerUtils.isAppContainerInit()) {
                ACLog.e(TAG, "unregisterPlugin error! AppContainer not initialized.");
                return;
            }
            Map<BaseContainerPlugin, AppContainerPlugin> map = this.base2Plugin;
            if (map != null && !map.isEmpty() && this.base2Plugin.get(baseContainerPlugin) != null) {
                AppContainerKit.getInstance().unRegisterPlugin(this.base2Plugin.get(baseContainerPlugin));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterPlugin fail: Cannot find plugin. ");
            sb.append(baseContainerPlugin);
            ACLog.w(TAG, sb.toString());
        }
    }
}
