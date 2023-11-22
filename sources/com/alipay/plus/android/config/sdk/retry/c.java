package com.alipay.plus.android.config.sdk.retry;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher;
import com.alipay.iap.android.common.utils.NetworkUtils;
import com.alipay.plus.android.config.sdk.ConfigCenter;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.ConfigGetter;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.ICancelableTask;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.fetcher.ConfigFetchCallback;
import com.alipay.plus.android.config.sdk.fetcher.ConfigNotifyCallback;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import com.alipay.plus.android.config.sdk.rpc.AmcsRpcUtils;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class c implements ICancelableTask {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7372a = e.a("FetchScheduler");
    private static boolean e = true;
    private a b;
    private List<String> c;
    private ConfigNotifyCallback d;
    private long i;
    private final Handler j;
    private final Handler k;
    private final ConfigCenterContext m;
    private final List<DistributionNode> n;

    /* renamed from: o  reason: collision with root package name */
    private List<DistributionNode> f7373o;
    private final ConfigFetchCallback p;
    private List<b> q;
    private LifecycleWatcher r;
    private NetworkUtils.NetworkStateListener s;
    private String t;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final List<DistributionNode> u = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alipay.plus.android.config.sdk.retry.c$7  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7381a;

        static {
            int[] iArr = new int[a.values().length];
            f7381a = iArr;
            try {
                iArr[a.BY_KEYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7381a[a.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum a {
        ALL,
        BY_KEYS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private long f7382a;
        private com.alipay.plus.android.config.sdk.fetcher.a.a b;

        private b(com.alipay.plus.android.config.sdk.fetcher.a.a aVar, long j) {
            this.b = aVar;
            this.f7382a = j;
        }

        public String a() {
            return this.b.a();
        }

        public String toString() {
            return String.format("%s - delay %s ms", this.b, Long.valueOf(this.f7382a));
        }
    }

    private c(ConfigCenterContext configCenterContext, List<DistributionNode> list, ConfigFetchCallback configFetchCallback) {
        this.m = configCenterContext;
        this.n = list;
        this.p = configFetchCallback;
        HandlerThread handlerThread = new HandlerThread("ConfigFetchScheduler-Thread");
        handlerThread.start();
        this.j = new Handler(handlerThread.getLooper());
        this.k = new Handler(Looper.getMainLooper());
    }

    private static long a(boolean z) {
        long j;
        long j2;
        double random = Math.random();
        if (z) {
            j = (long) (random * 3000.0d);
            j2 = RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
        } else {
            j = (long) (random * 45000.0d);
            j2 = 45000;
        }
        return j + j2;
    }

    public static c a(ConfigCenterContext configCenterContext, long j, List<DistributionNode> list, List<DistributionNode> list2, String str, ConfigFetchCallback configFetchCallback) {
        c cVar = new c(configCenterContext, list, configFetchCallback);
        cVar.a(list2, str, j);
        a(cVar.q);
        return cVar;
    }

    public static c a(ConfigCenterContext configCenterContext, List<DistributionNode> list, List<String> list2, ConfigFetchCallback configFetchCallback, ConfigNotifyCallback configNotifyCallback) {
        c cVar = new c(configCenterContext, list, configFetchCallback);
        cVar.a(list2, configNotifyCallback);
        a(cVar.q);
        return cVar;
    }

    private Map<String, Object> a(AmcsConfigRpcResult amcsConfigRpcResult) {
        Object config;
        if (amcsConfigRpcResult == null || amcsConfigRpcResult.updateKeys == null || amcsConfigRpcResult.updateKeys.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : amcsConfigRpcResult.updateKeys.keySet()) {
            int indexOf = str.indexOf(46);
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                String substring2 = str.substring(indexOf + 1);
                JSONObject sectionConfig = ConfigCenter.getInstance().getSectionConfig(substring);
                if (sectionConfig != null) {
                    config = sectionConfig.get(substring2);
                }
            } else {
                config = ConfigCenter.getInstance().getConfig(str);
            }
            hashMap.put(str, config);
        }
        return hashMap;
    }

    private void a(long j) {
        LoggerWrapper.i(f7372a, String.format("Will retry refresh after %s ms, mCurrentTaskIndex = %s.", Long.valueOf(j), Integer.valueOf(this.h)));
        this.j.postDelayed(new Runnable() { // from class: com.alipay.plus.android.config.sdk.retry.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.e();
            }
        }, j);
    }

    private void a(DistributionNode distributionNode, long j) {
        if (distributionNode != null && ConfigUtils.isDeviceHitRate(distributionNode.rate, this.m) && DistributionNode.a.isRpcNode(distributionNode.type)) {
            a(distributionNode, j, false);
        }
    }

    private void a(DistributionNode distributionNode, long j, boolean z) {
        while (true) {
            int i = AnonymousClass7.f7381a[this.b.ordinal()];
            if (i == 1) {
                this.q.add(new b(new com.alipay.plus.android.config.sdk.fetcher.a.c(this.m, distributionNode, this.c), j));
            } else if (i == 2) {
                this.q.addAll(b(distributionNode, j));
            }
            if (!z) {
                return;
            }
            z = false;
        }
    }

    private void a(DistributionNode distributionNode, String str) {
        this.m.getConfigMonitor().behavior("config_rate_limited", KVBuilder.newBuilder().put("code", str).put("serviceType", distributionNode.type.name()).build());
        this.u.add(distributionNode);
        Iterator<b> it = this.q.iterator();
        while (it.hasNext()) {
            if (!a(it.next().b.d())) {
                return;
            }
        }
        LoggerWrapper.e(f7372a, "** All fetch tasks need skip! will notify failed.");
        f();
    }

    private static void a(List<b> list) {
        LoggerWrapper.d(f7372a, "ConfigFetchScheduler tasks: ");
        for (int i = 0; i < list.size(); i++) {
            LoggerWrapper.d(f7372a, String.format("    %s %s", Integer.valueOf(i), list.get(i)));
        }
    }

    private void a(List<String> list, ConfigNotifyCallback configNotifyCallback) {
        this.b = a.BY_KEYS;
        this.c = list;
        this.d = configNotifyCallback;
        this.g = 1;
        d();
    }

    private void a(List<DistributionNode> list, String str, long j) {
        this.b = a.ALL;
        this.g = j();
        this.f7373o = list;
        this.t = str;
        this.i = j;
        d();
    }

    private boolean a(DistributionNode distributionNode) {
        Iterator<DistributionNode> it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next().isSameNode(distributionNode)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(b bVar) {
        String str = f7372a;
        LoggerWrapper.i(str, String.format("[%s] Will do task now! mCurrentTaskIndex = %s", bVar.a(), Integer.valueOf(this.h)));
        com.alipay.plus.android.config.sdk.fetcher.a.a aVar = bVar.b;
        DistributionNode d = aVar.d();
        if (a(d)) {
            StringBuilder sb = new StringBuilder();
            sb.append("** will skip this node: ");
            sb.append(d.configName);
            LoggerWrapper.e(str, sb.toString());
            return false;
        }
        try {
            String a2 = e.a(d, this.m);
            AmcsConfigRpcResult b2 = aVar.b(TextUtils.equals(this.t, a2) ? String.valueOf(this.i) : "0");
            if (isCanceled()) {
                LoggerWrapper.w(str, "Scheduler already canceled. will skip notify success.");
                return false;
            }
            if (this.b == a.BY_KEYS) {
                this.p.onFetchByKeysSuccess(b2);
                ConfigNotifyCallback configNotifyCallback = this.d;
                if (configNotifyCallback != null) {
                    configNotifyCallback.onFetchSuccess(a(b2));
                }
            } else {
                this.p.onFetchSuccess(b2, a2);
            }
            return true;
        } catch (FetchException e2) {
            String str2 = f7372a;
            LoggerWrapper.e(str2, String.format("[%s] Fetch failed! mCurrentTaskIndex = %s, node = %s, error: %s", bVar.a(), d.configName, Integer.valueOf(this.h), e2));
            String str3 = e2.errorCode;
            if (aVar.a(str3)) {
                LoggerWrapper.d(str2, String.format("** isRequestLimited! task = %s, errorCode = %s, node = %s.", aVar.a(), str3, d.configName));
                a(d, str3);
            }
            return false;
        }
    }

    private List<b> b(DistributionNode distributionNode, long j) {
        ArrayList arrayList = new ArrayList();
        ConfigGetter sectionConfigGetter = ConfigCenter.getInstance().getSectionConfigGetter("amcs");
        String stringConfig = sectionConfigGetter != null ? sectionConfigGetter.getStringConfig("encryptStatus") : null;
        if ("MIXED".equalsIgnoreCase(stringConfig) || "ENCRYPT".equalsIgnoreCase(stringConfig)) {
            arrayList.add(new b(new com.alipay.plus.android.config.sdk.fetcher.a.d(this.m, distributionNode, true), j));
        }
        if (!"ENCRYPT".equalsIgnoreCase(stringConfig)) {
            arrayList.add(new b(new com.alipay.plus.android.config.sdk.fetcher.a.d(this.m, distributionNode, false), j));
        }
        return arrayList;
    }

    private void d() {
        List<DistributionNode> list;
        long a2 = a(true);
        this.q = new ArrayList();
        List<DistributionNode> list2 = this.n;
        if (list2 != null) {
            for (DistributionNode distributionNode : list2) {
                if (this.q.isEmpty()) {
                    a(distributionNode, a2);
                    if (!this.q.isEmpty() && this.g <= 0) {
                        LoggerWrapper.d(f7372a, "mRefreshMaxCount <= 0, will disable retry.");
                        return;
                    } else if (this.b == a.ALL) {
                    }
                }
                a(distributionNode, a(false));
            }
        }
        if (this.q.isEmpty()) {
            String str = this.m.getRpcProfile().gatewayUrl;
            a(this.m.isUseGraySscaleAsDefault() ? new DistributionNode(DistributionNode.a.GRAYSCALE, str, AmcsRpcUtils.DEFAULT_NODE_GRAYSCALE_SERVICE, 100) : new DistributionNode(DistributionNode.a.MDS, str, AmcsRpcUtils.DEFAULT_NODE_MDS_SERVICE, 100), a2, this.g > 0);
        }
        if (this.g <= 0 || this.b != a.ALL || (list = this.f7373o) == null) {
            return;
        }
        Iterator<DistributionNode> it = list.iterator();
        while (it.hasNext()) {
            this.q.add(new b(new com.alipay.plus.android.config.sdk.fetcher.a.b(this.m, it.next()), a(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (isCanceled()) {
            LoggerWrapper.w(f7372a, "Scheduler already canceled. will skip doFetchTaskInternal.");
        } else if (this.h >= this.q.size()) {
            LoggerWrapper.w(f7372a, "All tasks finished. will skip.");
        } else {
            i();
            if (!g()) {
                String str = f7372a;
                StringBuilder sb = new StringBuilder();
                sb.append("AppInBackground or NoNetwork now! will not fetch. mCurrentTaskIndex = ");
                sb.append(this.h);
                LoggerWrapper.e(str, sb.toString());
                h();
                return;
            }
            if (this.h > 0) {
                this.m.getConfigMonitor().behavior("config_update_retry", KVBuilder.newBuilder().put("retryCount", Integer.valueOf(this.f)).build());
            }
            b bVar = this.q.get(this.h);
            if (a(bVar)) {
                cancel();
                return;
            }
            int i = this.h + 1;
            this.h = i;
            if (i < this.q.size()) {
                a(bVar.f7382a);
                return;
            }
            String str2 = f7372a;
            LoggerWrapper.i(str2, "All tasks finished.");
            int i2 = this.f + 1;
            this.f = i2;
            if (i2 >= this.g) {
                LoggerWrapper.e(str2, "** All retry turn finished, will not retry.");
                f();
                return;
            }
            long a2 = a(false);
            LoggerWrapper.i(str2, String.format("** Will schedule next retry. mRefreshCount = %s, delay = %s", Integer.valueOf(this.f), Long.valueOf(a2)));
            this.j.postDelayed(new Runnable() { // from class: com.alipay.plus.android.config.sdk.retry.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.h = 0;
                    c.this.b();
                }
            }, a2);
        }
    }

    private void f() {
        String str = f7372a;
        LoggerWrapper.i(str, "** Notify all fetch tasks failed.");
        ConfigNotifyCallback configNotifyCallback = this.d;
        if (configNotifyCallback != null) {
            configNotifyCallback.onFetchFailed("Unknown", "All fetch tasks failed.");
        }
        if (isCanceled() || this.b != a.ALL) {
            LoggerWrapper.w(str, "Scheduler already canceled. will skip notify failure.");
            return;
        }
        this.p.onFetchFailed("Unknown", "All fetch tasks failed.");
        cancel();
    }

    private boolean g() {
        if (e) {
            e = false;
            return true;
        }
        Context context = this.m.getContext();
        boolean a2 = e.a(context);
        boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(context);
        LoggerWrapper.i(f7372a, String.format("scheduleFetchTask. appInForeground = %s, hasNetwork = %s", Boolean.valueOf(a2), Boolean.valueOf(isNetworkAvailable)));
        return a2 && isNetworkAvailable;
    }

    private void h() {
        final Context context = this.m.getContext();
        if (!NetworkUtils.isNetworkAvailable(context)) {
            LoggerWrapper.d(f7372a, "Add network observer");
            NetworkUtils.NetworkStateListener networkStateListener = new NetworkUtils.NetworkStateListener() { // from class: com.alipay.plus.android.config.sdk.retry.c.4
                @Override // com.alipay.iap.android.common.utils.NetworkUtils.NetworkStateListener
                public void onNetworkChanged(int i, int i2) {
                    if (i2 != 0) {
                        LoggerWrapper.i(c.f7372a, "onNetworkChanged to available, will try scheduleFetchTask");
                        c.this.b();
                    }
                }
            };
            this.s = networkStateListener;
            NetworkUtils.addNetworkStateListener(context, networkStateListener);
        }
        if (e.a(context)) {
            return;
        }
        LoggerWrapper.d(f7372a, "Add app-foreground observer");
        this.k.post(new Runnable() { // from class: com.alipay.plus.android.config.sdk.retry.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.r = LifecycleWatcher.newValidWatcher();
                c.this.r.addCallback(new LifecycleWatcher.Callback() { // from class: com.alipay.plus.android.config.sdk.retry.c.5.1
                    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher.Callback
                    public void onAppToBackground() {
                    }

                    @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher.Callback
                    public void onAppToForeground() {
                        LoggerWrapper.i(c.f7372a, "onAppToForeground, will try scheduleFetchTask");
                        c.this.b();
                    }
                });
                c.this.r.startWatcher(context);
            }
        });
    }

    private void i() {
        final Context context = this.m.getContext();
        if (this.s != null) {
            LoggerWrapper.d(f7372a, "Remove network observer");
            NetworkUtils.removeNetworkStateListener(context, this.s);
            this.s = null;
        }
        if (this.r != null) {
            LoggerWrapper.d(f7372a, "Remove app-foreground observer");
            this.k.post(new Runnable() { // from class: com.alipay.plus.android.config.sdk.retry.c.6
                @Override // java.lang.Runnable
                public void run() {
                    c.this.r.stopWatcher(context);
                }
            });
            this.s = null;
        }
    }

    private static int j() {
        ConfigGetter sectionConfigGetter = ConfigCenter.getInstance().getSectionConfigGetter("amcs");
        int intConfig = sectionConfigGetter != null ? sectionConfigGetter.getIntConfig("refreshMaxCount", 10) : 10;
        String str = f7372a;
        StringBuilder sb = new StringBuilder();
        sb.append("refreshMaxCount = ");
        sb.append(intConfig);
        LoggerWrapper.i(str, sb.toString());
        return intConfig;
    }

    public int a() {
        int i = this.f;
        if (i <= 0 && this.h == 0) {
            return 0;
        }
        return i;
    }

    public void b() {
        if (isCanceled()) {
            LoggerWrapper.w(f7372a, "Scheduler already canceled. will skip scheduleFetchTask.");
        } else {
            this.j.post(new Runnable() { // from class: com.alipay.plus.android.config.sdk.retry.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.e();
                }
            });
        }
    }

    @Override // com.alipay.plus.android.config.sdk.common.ICancelableTask
    public void cancel() {
        if (this.l.get()) {
            return;
        }
        String str = f7372a;
        StringBuilder sb = new StringBuilder();
        sb.append("Will stop scheduler. mCurrentTaskIndex = ");
        sb.append(this.h);
        LoggerWrapper.d(str, sb.toString());
        this.l.set(true);
        this.j.removeCallbacksAndMessages(null);
        i();
        Looper looper = this.j.getLooper();
        if (looper != null) {
            looper.quit();
        }
    }

    @Override // com.alipay.plus.android.config.sdk.common.ICancelableTask
    public boolean isCanceled() {
        return this.l.get();
    }
}
