package com.iap.ac.config.lite.f;

import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.c.b;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import com.iap.ac.config.lite.fetcher.ConfigFetchCallback;
import com.iap.ac.config.lite.fetcher.FetchException;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class c<T extends com.iap.ac.config.lite.c.b> extends com.iap.ac.config.lite.e.a<T> {
    private static final String p = e.b("FetchScheduler");
    protected final ConfigFetchCallback n;

    /* renamed from: o  reason: collision with root package name */
    protected Map<String, Object> f7642o;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Map<String, Object> map, ConfigCenterContext configCenterContext, ConfigFetchCallback configFetchCallback) {
        super(configCenterContext);
        this.f7642o = map;
        this.n = configFetchCallback;
    }

    protected abstract void a(AmcsConfigRpcResult amcsConfigRpcResult);

    @Override // com.iap.ac.config.lite.e.a
    public void f() {
        if (this.g > 0) {
            this.d.getConfigMonitor().behavior("config_update_retry", KVBuilder.newBuilder().put("retryCount", Integer.valueOf(this.f)).build());
        }
    }

    protected abstract String k();

    @Override // com.iap.ac.config.lite.e.a
    public long a(boolean z) {
        long random;
        long j;
        if (z) {
            random = (long) (Math.random() * 3000.0d);
            j = RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
        } else {
            random = (long) (Math.random() * 45000.0d);
            j = 45000;
        }
        return random + j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iap.ac.config.lite.e.a
    public boolean a(com.iap.ac.config.lite.c.b bVar) {
        String str = p;
        ACLog.i(str, String.format("[%s] Will do task now! mCurrentTaskIndex = %s", bVar.a(), Integer.valueOf(this.g)));
        try {
            AmcsConfigRpcResult a2 = bVar.a(k(), e.a(this.d, this.f7642o));
            if (isCanceled()) {
                ACLog.w(str, "Scheduler already canceled. will skip notify success.");
                return false;
            }
            a(a2);
            return true;
        } catch (FetchException e) {
            String str2 = p;
            ACLog.e(str2, String.format("[%s] Fetch failed! mCurrentTaskIndex = %s, error: %s", bVar.a(), Integer.valueOf(this.g), e));
            String str3 = e.errorCode;
            if (bVar.a(str3)) {
                ACLog.d(str2, String.format("** isRequestLimited! task = %s, errorCode = %s.", bVar.a(), str3));
                this.d.getConfigMonitor().behavior("config_rate_limited", KVBuilder.newBuilder().put("code", str3).build());
                g();
            }
            return false;
        } catch (Throwable th) {
            ACLog.e(p, String.format("[%s] Fetch error! mCurrentTaskIndex = %s, error: %s", bVar.a(), Integer.valueOf(this.g), th.getMessage()));
            return false;
        }
    }
}
