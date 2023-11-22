package com.alibaba.ariver.resource.api.prerun;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class AppxPrerunChecker {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6218a = new HashSet();
    private static final Set<String> b = new HashSet();
    private static final Set<String> c = new HashSet();

    static {
        a();
    }

    public static boolean isPrerunWorkerApp(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return false;
        }
        if ("YES".equalsIgnoreCase(BundleUtils.getString(bundle, "appxRouteFramework"))) {
            if (!b.isEmpty()) {
                JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ta_appxng_prerun_blacklist");
                return (CollectionUtils.isEmpty(configJSONArray) || !configJSONArray.contains(str)) && !"NO".equalsIgnoreCase(BundleUtils.getString(bundle, RVParams.PRE_RUN_WORKER));
            }
            return false;
        }
        return f6218a.contains(str);
    }

    public static boolean isPrerunAction(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !b.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str) {
        try {
            f6218a.clear();
            b.clear();
            JSONObject parseObject = JSONUtils.parseObject(str);
            if (parseObject != null) {
                JSONArray jSONArray = parseObject.getJSONArray("white_list");
                if (!CollectionUtils.isEmpty(jSONArray)) {
                    for (int i = 0; i < jSONArray.size(); i++) {
                        f6218a.add(jSONArray.getString(i));
                    }
                }
                JSONArray jSONArray2 = parseObject.getJSONArray("block_apis");
                if (CollectionUtils.isEmpty(jSONArray2)) {
                    return;
                }
                for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                    b.add(jSONArray2.getString(i2));
                }
            }
        } catch (Exception e) {
            RVLogger.w("AriverRes:AppxPrerunChecker", "initPrerunConfig failed:\t", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        try {
            c.clear();
            JSONArray parseArray = JSONUtils.parseArray(str);
            if (CollectionUtils.isEmpty(parseArray)) {
                return;
            }
            for (int i = 0; i < parseArray.size(); i++) {
                c.add(parseArray.getString(i));
            }
        } catch (Exception e) {
            RVLogger.w("AriverRes:AppxPrerunChecker", "initMessageQueueConfig failed:\t", e);
        }
    }

    private static void a() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return;
        }
        try {
            a(rVConfigService.getConfig("ta_launch_prerunWorker", null, new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker.1
                @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
                public final void onChange(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ta_launch_prerunWorker,onConfigChange:  ");
                    sb.append(str);
                    RVLogger.d("AriverRes:AppxPrerunChecker", sb.toString());
                    AppxPrerunChecker.a(str);
                }
            }));
        } catch (Exception e) {
            RVLogger.e("AriverRes:AppxPrerunChecker", e);
        }
        try {
            b(rVConfigService.getConfig("ta_v8Worker_messageQueue_whiteList", null, new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker.2
                @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
                public final void onChange(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ta_v8Worker_messageQueue_whiteList,onConfigChange:  ");
                    sb.append(str);
                    RVLogger.d("AriverRes:AppxPrerunChecker", sb.toString());
                    AppxPrerunChecker.b(str);
                }
            }));
        } catch (Exception e2) {
            RVLogger.e("AriverRes:AppxPrerunChecker", e2);
        }
    }

    private static String b() {
        return RVKernelUtils.isDebug() ? PreferenceManager.getDefaultSharedPreferences(ProcessUtils.getContext()).getString("prerun_dev_mode_settings", "0") : "0";
    }

    public static boolean isRenderMessageQueue(String str) {
        String b2 = b();
        if (!b2.equals("0")) {
            return b2.equals("1");
        }
        Set<String> set = c;
        return set.contains(str) || set.contains("all");
    }

    public static void tryInjectStartParams(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isPrerunWorkerApp(str, bundle)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" support prerun");
            RVLogger.d("AriverRes:AppxPrerunChecker", sb.toString());
            bundle.putString(RVParams.PRE_RUN_WORKER, "YES");
            if (isRenderMessageQueue(str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" support messagequeue");
                RVLogger.d("AriverRes:AppxPrerunChecker", sb2.toString());
                bundle.putString(RVParams.ENABLE_RENDER_MESSAGEQUEUE, "YES");
            }
        } else if (BundleUtils.contains(bundle, RVParams.PRE_RUN_WORKER)) {
            bundle.remove(RVParams.PRE_RUN_WORKER);
        }
    }
}
