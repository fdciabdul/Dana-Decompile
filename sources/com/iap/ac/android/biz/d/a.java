package com.iap.ac.android.biz.d;

import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.container.IContainer;
import com.iap.ac.android.common.container.WebContainer;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;
import com.iap.ac.android.common.container.utils.ContainerUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.ACContainer;
import com.iap.ac.android.container.adapter.appcontainer.AppContainerImpl;
import com.iap.ac.android.container.adapter.griver.GriverContainerImpl;
import com.iap.ac.android.mpm.interceptor.event.PageEventPlugin;
import com.iap.ac.android.mpm.interceptor.jsapi.GetAuthCodeInterceptor;
import com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin;
import com.iap.ac.android.mpm.interceptor.provider.ACJsApiPermissionProvider;
import com.iap.ac.android.mpm.interceptor.provider.UAProvider;

/* loaded from: classes3.dex */
public enum a {
    INSTANCE;

    public boolean isInitialized;

    public static a get() {
        return INSTANCE;
    }

    public final void initContainer() {
        if (this.isInitialized) {
            return;
        }
        ACLog.i(Constants.TAG, "initContainer begin");
        if (Utils.checkClassExist("com.iap.ac.android.container.adapter.griver.GriverContainerImpl")) {
            ACLog.i(Constants.TAG, "initContainer using Griver");
            WebContainer.INSTANCE.setContainer(new GriverContainerImpl(), "ac_biz");
        } else if (ContainerUtils.isACContainerExist() && isToggleACContainer()) {
            ACLog.i(Constants.TAG, "initContainer using ACContainer");
            WebContainer.INSTANCE.setContainer(ACContainer.INSTANCE, "ac_biz");
            if (Utils.checkClassExist("com.iap.ac.android.mpm.interceptor.provider.ACJsApiPermissionProvider")) {
                WebContainer.getInstance("ac_biz").setProvider(JsApiPermissionProvider.class.getName(), new ACJsApiPermissionProvider());
            }
        } else if (ContainerUtils.isAppContainerExist()) {
            ACLog.i(Constants.TAG, "initContainer using AppContainer");
            WebContainer.INSTANCE.setContainer(new AppContainerImpl(), "ac_biz");
        } else {
            ACLog.e(Constants.TAG, "initContainer: No container implementation found!");
        }
        IContainer webContainer = WebContainer.getInstance("ac_biz");
        if (webContainer != null) {
            if (Utils.checkClassExist("com.iap.ac.android.mpm.interceptor.jsapi.TradePayPlugin")) {
                webContainer.registerJSAPIPlugin(new TradePayPlugin());
            }
            if (Utils.checkClassExist("com.iap.ac.android.mpm.interceptor.event.PageEventPlugin")) {
                webContainer.registerPlugin(new PageEventPlugin());
            }
            if (Utils.checkClassExist(Constants.PACKAGE_NAME_DECODE_CHECKER)) {
                webContainer.setProvider(ContainerUaProvider.class.getName(), new UAProvider());
            }
            if (Utils.checkClassExist("com.iap.ac.android.mpm.interceptor.jsapi.GetAuthCodeInterceptor")) {
                webContainer.registerACH5JSAPIInterceptor(com.iap.ac.android.acs.plugin.utils.Constants.JS_API_GET_AUTH_CODE, new GetAuthCodeInterceptor());
            }
        }
        this.isInitialized = true;
    }

    public final boolean isToggleACContainer() {
        return ConfigCenter.INSTANCE.getACContainerToggle();
    }
}
