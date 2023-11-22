package com.alipay.plus.android.ab.sdk.fetcher;

import android.os.SystemClock;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.ab.sdk.AbTestingContext;
import com.alipay.plus.android.ab.sdk.facade.request.AbTestingRequest;
import com.alipay.plus.android.ab.sdk.facade.result.AbTestingResponse;
import com.alipay.plus.android.ab.sdk.monitor.AbTestingMonitor;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import java.util.Map;

/* loaded from: classes7.dex */
public class AbTestingRpcFetcher implements AbTestingFetcher {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7343a = e.a("AbTestingRpcFetcher");
    private AbTestingContext b;

    public AbTestingRpcFetcher(AbTestingContext abTestingContext) {
        this.b = abTestingContext;
    }

    private AbTestingRequest a(String str) {
        AbTestingRequest abTestingRequest = new AbTestingRequest();
        abTestingRequest.deviceId = this.b.getDeviceId();
        abTestingRequest.entrance = str;
        abTestingRequest.userId = this.b.getUserId();
        abTestingRequest.condition = this.b.getCondition();
        abTestingRequest.cookie = this.b.getCookie();
        return abTestingRequest;
    }

    private void a(KVBuilder kVBuilder) {
        a(AbTestingMonitor.Events.AB_FETCH_START, kVBuilder.build());
    }

    private void a(String str, Map<String, String> map) {
        this.b.getAbTestingMonitor().behavior(str, map);
    }

    private void b(KVBuilder kVBuilder) {
        a(AbTestingMonitor.Events.AB_FETCH_SUCCESS, kVBuilder.build());
    }

    private void c(KVBuilder kVBuilder) {
        a(AbTestingMonitor.Events.AB_FETCH_FAILURE, kVBuilder.build());
    }

    @Override // com.alipay.plus.android.ab.sdk.fetcher.AbTestingFetcher
    public Map<String, String> getVariation(String str, String str2) throws FetchException {
        KVBuilder newBuilder = KVBuilder.newBuilder();
        newBuilder.put("source", str);
        newBuilder.put("entrance", str2);
        a(newBuilder);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            AbTestingResponse fetchVariation = this.b.getAbTestingRpcProvider().fetchVariation(a(str2));
            if (fetchVariation.success) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                KVBuilder newBuilder2 = KVBuilder.newBuilder();
                newBuilder2.put("source", str);
                newBuilder2.put("entrance", str2);
                newBuilder2.put("duration", Long.valueOf(elapsedRealtime2 - elapsedRealtime));
                b(newBuilder2);
                return fetchVariation.params;
            }
            throw new FetchException(fetchVariation.errorCode, fetchVariation.errorMessage);
        } catch (Throwable th) {
            LoggerWrapper.e(f7343a, "fetch variation failed", th);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            FetchException a2 = e.a(th, true);
            KVBuilder newBuilder3 = KVBuilder.newBuilder();
            newBuilder3.put("source", str);
            newBuilder3.put("entrance", str2);
            newBuilder3.put("duration", Long.valueOf(elapsedRealtime3 - elapsedRealtime));
            newBuilder3.put("errorCode", a2.errorCode);
            newBuilder3.put("errorMessage", a2.errorMessage);
            c(newBuilder3);
            throw a2;
        }
    }
}
