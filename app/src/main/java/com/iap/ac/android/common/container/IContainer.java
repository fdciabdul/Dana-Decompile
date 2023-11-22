package com.iap.ac.android.common.container;

import android.content.Context;
import com.iap.ac.android.common.container.auth.IContainerAuth;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.container.interceptor.BridgeJSAPIPreInterceptor;
import com.iap.ac.android.common.container.interceptor.NotFoundJSAPIInterceptor;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.container.model.AppInfoListData;
import com.iap.ac.android.common.container.model.CloseAppParams;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IContainer {
    void closeApp(CloseAppParams closeAppParams);

    void fetchAppInfoListByIds(List<String> list, Callback<AppInfoListData> callback);

    IContainerAuth getContainerAuth();

    HashMap<String, String> getGriverConfig();

    boolean isJSAPIRegistered(String str);

    boolean isMiniProgram(String str);

    void logEvent(String str, Map<String, String> map);

    String objectForKey(String str, String str2);

    void registerACH5JSAPIInterceptor(String str, BridgeInterceptor bridgeInterceptor);

    void registerAppEventHandler();

    void registerContainerListener(IContainerListener iContainerListener);

    void registerJSAPIInterceptor(String str, BridgeInterceptor bridgeInterceptor);

    void registerJSAPIPlugin(BaseJSPlugin baseJSPlugin);

    void registerJSAPIPreInterceptor(BridgeJSAPIPreInterceptor bridgeJSAPIPreInterceptor);

    void registerNotFoundJSAPIInterceptor(NotFoundJSAPIInterceptor notFoundJSAPIInterceptor);

    boolean registerPlugin(BaseContainerPlugin baseContainerPlugin);

    void removeAllObjects(String str);

    void removeObjectForKey(String str, String str2);

    void setObject(String str, String str2, String str3, long j);

    void setProvider(String str, Object obj);

    void startContainer(Context context, ContainerParams containerParams);

    void startContainer(Context context, ContainerParams containerParams, IContainerListener iContainerListener);

    void startContainer(Context context, String str);

    void startContainer(Context context, String str, IContainerListener iContainerListener);

    void unregisterACH5JSAPIInterceptor(String str);

    void unregisterContainerListener(IContainerListener iContainerListener);

    void unregisterJSAPIInterceptor(String str);

    void unregisterJSAPIPlugin(BaseJSPlugin baseJSPlugin);

    void unregisterPlugin(BaseContainerPlugin baseContainerPlugin);
}
