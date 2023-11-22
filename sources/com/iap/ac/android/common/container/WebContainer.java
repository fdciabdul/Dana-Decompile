package com.iap.ac.android.common.container;

import android.content.Context;
import android.text.TextUtils;
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
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public enum WebContainer implements IContainer {
    INSTANCE;

    public static final String EVENT_GET_DEFAULT_IMPL = "ac_common_get_container_defalut_impl";
    public static final String EVENT_GET_IMPL_ERROR = "ac_common_get_container_impl_error";
    public static final String TAG = "WebContainer";
    public static final Map<String, IContainer> containerMap = new HashMap();
    public static IContainer mContainer;

    public static IContainer getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return getInstance();
        }
        IContainer iContainer = containerMap.get(str);
        if (iContainer == null && (iContainer = mContainer) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bizCode", str);
            hashMap.put("msg", "Cannot find the implemetation for this bizCode. Using default instead.");
            LogEvent logEvent = new LogEvent(EVENT_GET_DEFAULT_IMPL, hashMap);
            logEvent.bizCode = str;
            ACMonitor.getInstance(str).logEvent(logEvent);
        }
        if (iContainer == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bizCode", str);
            hashMap2.put("errorMsg", "Cannot find the implemetation for this bizCode.");
            LogEvent logEvent2 = new LogEvent(EVENT_GET_IMPL_ERROR, hashMap2);
            logEvent2.bizCode = str;
            logEvent2.eventType = LogEventType.CRUCIAL_LOG;
            ACMonitor.getInstance(str).logEvent(logEvent2);
        }
        return iContainer;
    }

    private void noImplementationError() {
        ACLog.e(TAG, "No implementation of IContainer found. Please setContainer before use!");
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void closeApp(CloseAppParams closeAppParams) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.closeApp(closeAppParams);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void fetchAppInfoListByIds(List<String> list, Callback<AppInfoListData> callback) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.fetchAppInfoListByIds(list, callback);
        }
    }

    public final IContainer getContainer() {
        return mContainer;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final IContainerAuth getContainerAuth() {
        return null;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final HashMap<String, String> getGriverConfig() {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
            return new HashMap<>();
        }
        return iContainer.getGriverConfig();
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final boolean isJSAPIRegistered(String str) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
            return false;
        }
        return iContainer.isJSAPIRegistered(str);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final boolean isMiniProgram(String str) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
            return false;
        }
        return iContainer.isMiniProgram(str);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void logEvent(String str, Map<String, String> map) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.logEvent(str, map);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final String objectForKey(String str, String str2) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
            return null;
        }
        return iContainer.objectForKey(str, str2);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerACH5JSAPIInterceptor(String str, BridgeInterceptor bridgeInterceptor) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerACH5JSAPIInterceptor(str, bridgeInterceptor);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerAppEventHandler() {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerAppEventHandler();
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerContainerListener(IContainerListener iContainerListener) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerContainerListener(iContainerListener);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerJSAPIInterceptor(String str, BridgeInterceptor bridgeInterceptor) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerJSAPIInterceptor(str, bridgeInterceptor);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerJSAPIPlugin(baseJSPlugin);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerJSAPIPreInterceptor(BridgeJSAPIPreInterceptor bridgeJSAPIPreInterceptor) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerJSAPIPreInterceptor(bridgeJSAPIPreInterceptor);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void registerNotFoundJSAPIInterceptor(NotFoundJSAPIInterceptor notFoundJSAPIInterceptor) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.registerNotFoundJSAPIInterceptor(notFoundJSAPIInterceptor);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final boolean registerPlugin(BaseContainerPlugin baseContainerPlugin) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
            return false;
        }
        return iContainer.registerPlugin(baseContainerPlugin);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void removeAllObjects(String str) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.removeAllObjects(str);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void removeObjectForKey(String str, String str2) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.removeObjectForKey(str, str2);
        }
    }

    public final void setContainer(IContainer iContainer) {
        mContainer = iContainer;
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void setObject(String str, String str2, String str3, long j) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.setObject(str, str2, str3, j);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void setProvider(String str, Object obj) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.setProvider(str, obj);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void startContainer(Context context, String str) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.startContainer(context, str);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void unregisterACH5JSAPIInterceptor(String str) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.unregisterACH5JSAPIInterceptor(str);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void unregisterContainerListener(IContainerListener iContainerListener) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.unregisterContainerListener(iContainerListener);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void unregisterJSAPIInterceptor(String str) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.unregisterJSAPIInterceptor(str);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void unregisterJSAPIPlugin(BaseJSPlugin baseJSPlugin) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.unregisterJSAPIPlugin(baseJSPlugin);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void unregisterPlugin(BaseContainerPlugin baseContainerPlugin) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.unregisterPlugin(baseContainerPlugin);
        }
    }

    public final void setContainer(IContainer iContainer, String str) {
        containerMap.put(str, iContainer);
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void startContainer(Context context, String str, IContainerListener iContainerListener) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.startContainer(context, str, iContainerListener);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void startContainer(Context context, ContainerParams containerParams) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.startContainer(context, containerParams);
        }
    }

    @Override // com.iap.ac.android.common.container.IContainer
    public final void startContainer(Context context, ContainerParams containerParams, IContainerListener iContainerListener) {
        IContainer iContainer = mContainer;
        if (iContainer == null) {
            noImplementationError();
        } else {
            iContainer.startContainer(context, containerParams, iContainerListener);
        }
    }

    public static IContainer getInstance() {
        return mContainer;
    }
}
