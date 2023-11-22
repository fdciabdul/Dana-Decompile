package com.alibaba.exthub.event;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.exthub.common.ExtHubLogger;
import com.alibaba.exthub.event.listener.ExtHubEventListener;
import com.alibaba.exthub.event.listener.ExtHubEventWithBizTypeListener;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtHubEventManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ExtHubEventManager f6268a;
    private Map<String, Map<String, List<ExtHubEventListener>>> b = new ConcurrentHashMap();
    private Map<String, Map<String, List<ExtHubEventWithBizTypeListener>>> c = new ConcurrentHashMap();

    public static ExtHubEventManager getInstance() {
        if (f6268a == null) {
            synchronized (ExtHubEventManager.class) {
                if (f6268a == null) {
                    f6268a = new ExtHubEventManager();
                }
            }
        }
        return f6268a;
    }

    public void onEvent(String str, ExtHubEventListener extHubEventListener) {
        if (TextUtils.isEmpty(str)) {
            ExtHubLogger.d("ExtHubEventManager", "onEventWithEventName eventName is null or empty");
        } else if (extHubEventListener == null) {
            ExtHubLogger.d("ExtHubEventManager", "onEventWithEventName listener is null");
        } else {
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            Activity activity = null;
            if (rVEnvironmentService != null && rVEnvironmentService.getTopActivity() != null) {
                activity = rVEnvironmentService.getTopActivity().get();
            }
            if (activity == null) {
                ExtHubLogger.d("ExtHubEventManager", "onEventWithEventName activity is null");
            } else {
                a(a(activity), str, extHubEventListener);
            }
        }
    }

    public void onEvent(String str, String str2, ExtHubEventWithBizTypeListener extHubEventWithBizTypeListener) {
        if (TextUtils.isEmpty(str)) {
            ExtHubLogger.d("ExtHubEventManager", "onCustomEventWithBizType bizType is null or empty");
        } else if (TextUtils.isEmpty(str2)) {
            ExtHubLogger.d("ExtHubEventManager", "onCustomEventWithBizType eventName is null or empty");
        } else if (extHubEventWithBizTypeListener == null) {
            ExtHubLogger.d("ExtHubEventManager", "onCustomEventWithBizType listener is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            a(str, str2, extHubEventWithBizTypeListener);
        }
    }

    private void a(String str, String str2, ExtHubEventListener extHubEventListener) {
        if (this.b.containsKey(str)) {
            Map<String, List<ExtHubEventListener>> map = this.b.get(str);
            if (map != null) {
                List<ExtHubEventListener> list = map.containsKey(str2) ? map.get(str2) : null;
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(extHubEventListener);
                map.put(str2, list);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(extHubEventListener);
        hashMap.put(str2, arrayList);
        this.b.put(str, hashMap);
    }

    private void a(String str, String str2, ExtHubEventWithBizTypeListener extHubEventWithBizTypeListener) {
        if (this.c.containsKey(str)) {
            Map<String, List<ExtHubEventWithBizTypeListener>> map = this.c.get(str);
            if (map != null) {
                List<ExtHubEventWithBizTypeListener> list = map.containsKey(str2) ? map.get(str2) : null;
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(extHubEventWithBizTypeListener);
                map.put(str2, list);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(extHubEventWithBizTypeListener);
        hashMap.put(str2, arrayList);
        this.c.put(str, hashMap);
    }

    public Map<String, Map<String, List<ExtHubEventListener>>> getActivityEventMap() {
        return this.b;
    }

    public Map<String, Map<String, List<ExtHubEventWithBizTypeListener>>> getBizTypeEventMap() {
        return this.c;
    }

    public void offEvent(Activity activity) {
        String a2 = a(activity);
        if (TextUtils.isEmpty(a2)) {
            ExtHubLogger.d("ExtHubEventManager", "removeEventWithActivity activity is null");
        } else {
            this.b.remove(a2);
        }
    }

    public void offGlobalEventWithBizType(String str) {
        if (TextUtils.isEmpty(str)) {
            ExtHubLogger.d("ExtHubEventManager", "offCustomEventWithBizType bizType is null");
        } else {
            this.c.remove(str);
        }
    }

    public void offGlobalEventWithBizType(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            ExtHubLogger.d("ExtHubEventManager", "offCustomEventWithBizType bizType is null or empty");
        } else if (TextUtils.isEmpty(str2)) {
            ExtHubLogger.d("ExtHubEventManager", "offCustomEventWithBizType eventName is null or empty");
        } else {
            Map<String, List<ExtHubEventWithBizTypeListener>> map = this.c.get(str);
            if (map != null) {
                map.remove(str2);
            }
        }
    }

    private String a(Activity activity) {
        if (activity == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(activity.getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(activity.hashCode());
        return sb.toString();
    }
}
