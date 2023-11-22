package com.alipay.iap.android.aplog.monitor.sampler;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.monitor.util.ANRUtil;
import java.util.LinkedHashMap;

/* loaded from: classes6.dex */
public class AllThreadsSampler extends AbstractSampler {
    private static final LinkedHashMap<Long, String> c = new LinkedHashMap<>();
    private int d;

    public AllThreadsSampler(long j) {
        this(3, j);
    }

    public AllThreadsSampler(int i, long j) {
        super(j);
        this.d = i;
    }

    public String a(long j, long j2) {
        String str;
        LinkedHashMap<Long, String> linkedHashMap = c;
        synchronized (linkedHashMap) {
            str = null;
            for (Long l : linkedHashMap.keySet()) {
                if (j < l.longValue() && l.longValue() <= j2) {
                    str = c.get(l);
                }
            }
        }
        return str;
    }

    @Override // com.alipay.iap.android.aplog.monitor.sampler.AbstractSampler
    protected void c() {
        LoggerFactory.getTraceLogger().info("ANRMonitor", "AllThreadsSampler.doSample");
        String a2 = ANRUtil.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        LinkedHashMap<Long, String> linkedHashMap = c;
        synchronized (linkedHashMap) {
            int size = linkedHashMap.size();
            int i = this.d;
            if (size >= i && i > 0) {
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
            }
            linkedHashMap.put(Long.valueOf(System.currentTimeMillis()), a2);
        }
    }
}
