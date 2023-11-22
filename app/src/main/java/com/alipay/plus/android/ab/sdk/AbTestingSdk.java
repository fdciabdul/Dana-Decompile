package com.alipay.plus.android.ab.sdk;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.task.async.IAPAsyncTask;
import com.alipay.plus.android.ab.sdk.fetcher.AbTestingFetcher;
import com.alipay.plus.android.ab.sdk.fetcher.AbTestingRpcFetcher;
import com.alipay.plus.android.ab.sdk.monitor.AbTestingMonitor;
import com.alipay.plus.android.ab.sdk.storage.AbTestingStorage;
import com.alipay.plus.android.ab.sdk.trigger.AbTestingTrigger;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class AbTestingSdk {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7341a = e.a("AbTestingSdk");
    private static final AbTestingSdk b = new AbTestingSdk();
    private AbTestingContext c;
    private AbTestingStorage d;
    private boolean e = false;
    private Map<String, Set<String>> f;
    private AbTestingFetcher g;

    /* loaded from: classes7.dex */
    public interface Callback {
        void handleException(FetchException fetchException);

        void handleVariation(Map<String, String> map);
    }

    private AbTestingSdk() {
    }

    private void a(Map<String, Set<String>> map) {
        synchronized (this) {
            this.f = map;
        }
    }

    private boolean a(String str, String str2) {
        String str3;
        String str4 = f7341a;
        LoggerWrapper.d(str4, String.format("getVariation: source = %s, entrance = %s", str, str2));
        if (isInitialized()) {
            Map<String, Set<String>> map = this.f;
            if (map == null) {
                str3 = "** AbTestingSdk cache not initialized, will return!";
            } else {
                Set<String> set = map.get(str);
                if (set == null) {
                    str3 = String.format("** can not find source [%s], will return!", str);
                } else if (!set.contains(str2)) {
                    str3 = String.format("** can not find entrance [%s] in source [%s], will return!", str2, str);
                } else if (this.g != null) {
                    return true;
                } else {
                    str3 = "** Fetcher is null,will return!";
                }
            }
        } else {
            str3 = "** AbTestingSdk not initialized, will return!";
        }
        LoggerWrapper.e(str4, str3);
        return false;
    }

    public static AbTestingSdk getInstance() {
        return b;
    }

    public AbTestingFetcher getAbTestingFetcher() {
        return this.g;
    }

    public void getVariation(final String str, final String str2, final Callback callback) {
        if (callback == null) {
            LoggerWrapper.e(f7341a, "** Callback is null, will return!");
            return;
        }
        if (!a(str, str2)) {
            callback.handleVariation(null);
        }
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.alipay.plus.android.ab.sdk.AbTestingSdk.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    callback.handleVariation(AbTestingSdk.this.g.getVariation(str, str2));
                } catch (Throwable th) {
                    callback.handleException(e.a(th, true));
                }
            }
        });
    }

    public Map<String, String> getVariationSync(String str, String str2) throws FetchException {
        if (a(str, str2)) {
            try {
                return this.g.getVariation(str, str2);
            } catch (Throwable th) {
                throw e.a(th, true);
            }
        }
        return null;
    }

    public void initialize(AbTestingContext abTestingContext) {
        if (this.e) {
            LoggerWrapper.d(f7341a, "AbTestingSdk already initialized!");
            return;
        }
        this.c = abTestingContext;
        abTestingContext.getAbTestingMonitor().behavior(AbTestingMonitor.Events.AB_INITIALIZED, null);
        this.g = new AbTestingRpcFetcher(this.c);
        AbTestingTrigger abTestingTrigger = this.c.getAbTestingTrigger();
        if (abTestingTrigger != null) {
            abTestingTrigger.initialize(this.c.getContext());
        }
        LoggerWrapper.i(f7341a, "** ABTesting initialize...");
        this.e = true;
        AbTestingStorage abTestingStorage = new AbTestingStorage(this.c.getContext(), this.c.getEnvironment());
        this.d = abTestingStorage;
        a(abTestingStorage.loadAbVariation());
    }

    public boolean isInitialized() {
        return this.e;
    }

    public void setAbTestingFetcher(AbTestingFetcher abTestingFetcher) {
        this.g = abTestingFetcher;
    }

    public void startAbTestingTrigger() {
        if (!this.e) {
            LoggerWrapper.e(f7341a, "startAbTestingTrigger. You need invoke initialize(ctx) firstly!");
            return;
        }
        AbTestingTrigger abTestingTrigger = this.c.getAbTestingTrigger();
        if (abTestingTrigger != null) {
            abTestingTrigger.startTrigger(this.c);
        }
    }

    public void switchEnvironment(String str) {
        if (!this.e) {
            LoggerWrapper.e(f7341a, "switchEnvironment. You need invoke initialize(ctx) firstly!");
            return;
        }
        this.c.setEnvironment(str);
        AbTestingStorage abTestingStorage = new AbTestingStorage(this.c.getContext(), str);
        this.d = abTestingStorage;
        a(abTestingStorage.loadAbVariation());
    }

    public void updateAbVariation(String str, String str2) {
        synchronized (this) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            Set<String> set = this.f.get(str);
            if (set == null) {
                set = new HashSet<>();
                this.f.put(str, set);
            }
            set.add(str2);
            AbTestingStorage abTestingStorage = this.d;
            if (abTestingStorage != null) {
                abTestingStorage.updateAbvariation(str, str2);
            }
        }
    }
}
