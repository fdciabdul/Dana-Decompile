package com.iap.ac.android.container;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.iap.ac.android.common.container.IContainer;
import com.iap.ac.android.common.container.auth.IContainerAuth;
import com.iap.ac.android.common.container.callback.Callback;
import com.iap.ac.android.common.container.event.ContainerEvent;
import com.iap.ac.android.common.container.event.ContainerEventFilter;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;
import com.iap.ac.android.common.container.interceptor.BridgeJSAPIPreInterceptor;
import com.iap.ac.android.common.container.interceptor.NotFoundJSAPIInterceptor;
import com.iap.ac.android.common.container.js.plugin.BaseJSPlugin;
import com.iap.ac.android.common.container.model.AppInfoListData;
import com.iap.ac.android.common.container.model.CloseAppParams;
import com.iap.ac.android.common.container.model.ContainerParams;
import com.iap.ac.android.common.container.plugin.BaseContainerPlugin;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.container.activity.ACContainerActivity;
import com.iap.ac.android.container.constant.ContainerKeys;
import com.iap.ac.android.container.constant.LogEventKeys;
import com.iap.ac.android.container.constant.LogEventName;
import com.iap.ac.android.container.js.ACJSBridge;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class ACContainer implements IContainer {
    private static final String TAG = "ACContainer";
    private String bizCode;
    public static final ACContainer INSTANCE = new ACContainer("");
    public static final Map<String, ACContainer> containerMap = new HashMap();
    public static boolean DEBUG = false;
    private Map<String, IContainerListener> containerListenerMap = new HashMap();
    private List<IContainerListener> globalContainerListenerMap = new ArrayList();
    private Map<String, CopyOnWriteArrayList<BaseContainerPlugin>> pluginMap = new ConcurrentHashMap();
    private Map<String, Object> interceptorMap = new ConcurrentHashMap();
    private Map<String, Object> providerMap = new ConcurrentHashMap();

    @Override // com.iap.ac.android.common.container.IContainer
    public void closeApp(CloseAppParams closeAppParams) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void fetchAppInfoListByIds(List<String> list, Callback<AppInfoListData> callback) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public IContainerAuth getContainerAuth() {
        return null;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public HashMap<String, String> getGriverConfig() {
        return null;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean isMiniProgram(String str) {
        return false;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void logEvent(String str, Map<String, String> map) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public String objectForKey(String str, String str2) {
        return null;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerAppEventHandler() {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIPreInterceptor(BridgeJSAPIPreInterceptor bridgeJSAPIPreInterceptor) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerNotFoundJSAPIInterceptor(NotFoundJSAPIInterceptor notFoundJSAPIInterceptor) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void removeAllObjects(String str) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void removeObjectForKey(String str, String str2) {
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void setObject(String str, String str2, String str3, long j) {
    }

    private ACContainer(String str) {
        this.bizCode = str;
    }

    public static ACContainer getInstance(String str) {
        synchronized (INSTANCE) {
            if (TextUtils.isEmpty(str)) {
                return getInstance();
            }
            Map<String, ACContainer> map = containerMap;
            ACContainer aCContainer = map.get(str);
            if (aCContainer == null) {
                aCContainer = new ACContainer(str);
                map.put(str, aCContainer);
            }
            return aCContainer;
        }
    }

    public static ACContainer getInstance() {
        return INSTANCE;
    }

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
        if (TextUtils.isEmpty(containerParams.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put(LogEventKeys.SDK_VERSION, "0.1");
            hashMap.put("parameters", "url");
            ACMonitor.getInstance(this.bizCode).logEvent(new LogEvent(LogEventName.INVALID_CONTAINER_START_PARAMS, hashMap));
            return;
        }
        Intent intent = new Intent(context, ACContainerActivity.class);
        intent.putExtra("url", containerParams.url);
        intent.putExtra(ContainerKeys.PARAM_START_METHOD, containerParams.startMethod.value);
        intent.putExtra(ContainerKeys.PARAM_POST_PARAMS, containerParams.postParams);
        intent.putExtra("bizCode", this.bizCode);
        if (containerParams.containerBundle != null) {
            intent.putExtras(containerParams.containerBundle);
        }
        if (context instanceof Application) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        String generatePageId = generatePageId(containerParams.url);
        intent.putExtra(ContainerKeys.PARAM_PAGE_ID, generatePageId);
        if (iContainerListener != null) {
            this.containerListenerMap.put(generatePageId, iContainerListener);
        }
        intent.putExtra(ContainerKeys.PARAM_START_TIME, System.currentTimeMillis());
        context.startActivity(intent);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerContainerListener(IContainerListener iContainerListener) {
        if (iContainerListener != null) {
            this.globalContainerListenerMap.add(iContainerListener);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterContainerListener(IContainerListener iContainerListener) {
        if (iContainerListener != null) {
            this.globalContainerListenerMap.remove(iContainerListener);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean registerPlugin(BaseContainerPlugin baseContainerPlugin) {
        CopyOnWriteArrayList<BaseContainerPlugin> copyOnWriteArrayList;
        synchronized (this) {
            if (baseContainerPlugin == null) {
                ACLog.w(TAG, "Invalid plugin parameter! Plugin is null.");
                return false;
            }
            try {
                Iterator<String> actionIterator = baseContainerPlugin.onPrepare(new ContainerEventFilter()).actionIterator();
                if (!actionIterator.hasNext()) {
                    ACLog.w(TAG, "Empty plugin filter!");
                    return false;
                }
                while (actionIterator.hasNext()) {
                    String next = actionIterator.next();
                    if (TextUtils.isEmpty(next)) {
                        ACLog.w(TAG, "Event can't be empty!");
                    } else {
                        if (!this.pluginMap.containsKey(next)) {
                            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                            this.pluginMap.put(next, copyOnWriteArrayList);
                        } else {
                            copyOnWriteArrayList = this.pluginMap.get(next);
                            if (copyOnWriteArrayList == null) {
                                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                            } else if (copyOnWriteArrayList.contains(baseContainerPlugin)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Plugin already registered. Plugin: ");
                                sb.append(baseContainerPlugin.getClass().getName());
                                ACLog.w(TAG, sb.toString());
                                return false;
                            }
                        }
                        copyOnWriteArrayList.add(baseContainerPlugin);
                    }
                }
                return true;
            } catch (Exception e) {
                ACLog.e(TAG, "Prepare plugin fail! ", e);
                return false;
            }
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterPlugin(BaseContainerPlugin baseContainerPlugin) {
        CopyOnWriteArrayList<BaseContainerPlugin> copyOnWriteArrayList;
        synchronized (this) {
            if (baseContainerPlugin == null) {
                ACLog.w(TAG, "unregisterPlugin: Invalid plugin parameter! Plugin is null.");
                return;
            }
            try {
                Iterator<String> actionIterator = baseContainerPlugin.onPrepare(new ContainerEventFilter()).actionIterator();
                if (!actionIterator.hasNext()) {
                    ACLog.w(TAG, "unregisterPlugin: Empty plugin filter!");
                    return;
                }
                while (actionIterator.hasNext()) {
                    String next = actionIterator.next();
                    if (TextUtils.isEmpty(next)) {
                        ACLog.w(TAG, "unregisterPlugin: Event can't be empty!");
                    } else if (this.pluginMap.containsKey(next) && (copyOnWriteArrayList = this.pluginMap.get(next)) != null && !copyOnWriteArrayList.isEmpty() && copyOnWriteArrayList.contains(baseContainerPlugin)) {
                        copyOnWriteArrayList.remove(baseContainerPlugin);
                        this.pluginMap.put(next, copyOnWriteArrayList);
                    }
                }
            } catch (Exception e) {
                ACLog.e(TAG, "unregisterPlugin: Prepare plugin fail! ", e);
            }
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void setProvider(String str, Object obj) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                ACLog.w(TAG, "setProvider error: providerName is empty!");
            } else if (obj == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("setProvider error: provider is null for: ");
                sb.append(str);
                ACLog.w(TAG, sb.toString());
            } else {
                Map<String, Object> map = this.providerMap;
                if (map != null) {
                    map.put(str, obj);
                }
            }
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        synchronized (this) {
            ACJSBridge.getInstance(this.bizCode).registerJSAPIPlugin(baseJSPlugin);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        synchronized (this) {
            ACJSBridge.getInstance(this.bizCode).unregisterJSAPIPlugin(baseJSPlugin);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void registerJSAPIInterceptor(String str, BridgeInterceptor bridgeInterceptor) {
        if (TextUtils.isEmpty(str)) {
            ACLog.w(TAG, "registerJSAPIInterceptor error: jsapiName is empty!");
        } else if (bridgeInterceptor == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("registerJSAPIInterceptor error: bridgeInterceptor is null for: ");
            sb.append(str);
            ACLog.w(TAG, sb.toString());
        } else {
            Map<String, Object> map = this.interceptorMap;
            if (map != null) {
                map.put(str, bridgeInterceptor);
            }
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public void unregisterJSAPIInterceptor(String str) {
        if (TextUtils.isEmpty(str)) {
            ACLog.w(TAG, "unregisterJSAPIInterceptor error: jsapiName is empty!");
            return;
        }
        Map<String, Object> map = this.interceptorMap;
        if (map == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterJSAPIInterceptor error: interceptorMap is null for: ");
            sb.append(str);
            ACLog.w(TAG, sb.toString());
            return;
        }
        map.remove(str);
    }

    public Object getJSAPIInterceptor(String str) {
        synchronized (this) {
            Map<String, Object> map = this.interceptorMap;
            if (map != null && !map.isEmpty()) {
                return this.interceptorMap.get(str);
            }
            return null;
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public boolean isJSAPIRegistered(String str) {
        Map<String, Object> map = this.interceptorMap;
        return (map == null || map.get(str) == null) ? false : true;
    }

    private String generatePageId(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.hashCode());
        sb.append("_");
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    public boolean handleContainerEvent(ContainerEvent containerEvent) {
        List<BaseContainerPlugin> pluginList = getPluginList(containerEvent);
        if (pluginList == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("handleContainerEvent: didn't find any plugin to handle event: ");
            sb.append(containerEvent);
            ACLog.d(TAG, sb.toString());
            return false;
        }
        for (BaseContainerPlugin baseContainerPlugin : pluginList) {
            if (baseContainerPlugin != null && baseContainerPlugin.handleEvent(containerEvent)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ContainerEvent handled by plugin: ");
                sb2.append(baseContainerPlugin.getClass().getName());
                sb2.append(", action=");
                sb2.append(containerEvent.action);
                ACLog.d(TAG, sb2.toString());
                return true;
            }
        }
        return false;
    }

    private List<BaseContainerPlugin> getPluginList(ContainerEvent containerEvent) {
        synchronized (this) {
            if (containerEvent != null) {
                if (!TextUtils.isEmpty(containerEvent.action)) {
                    Map<String, CopyOnWriteArrayList<BaseContainerPlugin>> map = this.pluginMap;
                    if (map != null && !map.isEmpty()) {
                        CopyOnWriteArrayList<BaseContainerPlugin> copyOnWriteArrayList = this.pluginMap.get(containerEvent.action);
                        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("getPluginList error: Plugin list is empty for action: ");
                            sb.append(containerEvent.action);
                            ACLog.d(TAG, sb.toString());
                            return null;
                        }
                        return copyOnWriteArrayList;
                    }
                    ACLog.d(TAG, "getPluginList error: Plugin map is empty!");
                    return null;
                }
            }
            ACLog.w(TAG, "getPluginList error: containerEvent is null or action is null.");
            return null;
        }
    }

    public boolean interceptContainerEvent(ContainerEvent containerEvent) {
        List<BaseContainerPlugin> pluginList = getPluginList(containerEvent);
        if (pluginList == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("interceptContainerEvent: didn't find any plugin to intercept event: ");
            sb.append(containerEvent);
            ACLog.d(TAG, sb.toString());
            return false;
        }
        for (int size = pluginList.size() - 1; size >= 0; size--) {
            BaseContainerPlugin baseContainerPlugin = pluginList.get(size);
            if (baseContainerPlugin != null && baseContainerPlugin.interceptorEvent(containerEvent)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ContainerEvent intercepted by plugin: ");
                sb2.append(baseContainerPlugin.getClass().getName());
                sb2.append(", action=");
                sb2.append(containerEvent.action);
                ACLog.d(TAG, sb2.toString());
                return true;
            }
        }
        return false;
    }

    public Object getProvider(String str) {
        synchronized (this) {
            Map<String, Object> map = this.providerMap;
            if (map != null && !map.isEmpty()) {
                return this.providerMap.get(str);
            }
            return null;
        }
    }

    public void onDestroy(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IContainerListener remove = this.containerListenerMap.remove(str);
        if (remove != null) {
            remove.onContainerDestroyed(bundle);
        }
        for (IContainerListener iContainerListener : this.globalContainerListenerMap) {
            if (iContainerListener != null) {
                iContainerListener.onContainerDestroyed(bundle);
            }
        }
    }

    public void onCreate(String str, Bundle bundle) {
        if (bundle != null && bundle.containsKey(ContainerKeys.PARAM_START_TIME)) {
            long j = bundle.getLong(ContainerKeys.PARAM_START_TIME);
            if (j > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put(LogEventKeys.SDK_VERSION, "0.1");
                StringBuilder sb = new StringBuilder();
                sb.append(currentTimeMillis - j);
                hashMap.put("duration", sb.toString());
                ACMonitor.getInstance(this.bizCode).logEvent(new LogEvent(LogEventName.CONTAINER_START, hashMap));
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IContainerListener iContainerListener = this.containerListenerMap.get(str);
        if (iContainerListener != null) {
            iContainerListener.onContainerCreated(bundle);
        }
        for (IContainerListener iContainerListener2 : this.globalContainerListenerMap) {
            if (iContainerListener2 != null) {
                iContainerListener2.onContainerCreated(bundle);
            }
        }
    }
}
