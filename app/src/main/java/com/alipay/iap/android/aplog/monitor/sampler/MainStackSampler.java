package com.alipay.iap.android.aplog.monitor.sampler;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.monitor.watchdog.ANRError;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MainStackSampler extends AbstractSampler {
    private static final LinkedHashMap<Long, String> c = new LinkedHashMap<>();
    private static String d;
    private int e;

    public MainStackSampler(long j) {
        this(10, j);
    }

    public MainStackSampler(int i, long j) {
        super(j);
        this.e = i;
    }

    public String a(long j, long j2) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Long, String> linkedHashMap = c;
        synchronized (linkedHashMap) {
            for (Long l : linkedHashMap.keySet()) {
                if (j < l.longValue() && l.longValue() <= j2) {
                    sb.append(this.f6933a.format(l));
                    sb.append(" :");
                    sb.append("\n");
                    sb.append(c.get(l));
                    sb.append("\n");
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public String b(long j, long j2) {
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

    public String c(long j, long j2) {
        int i;
        String str;
        LinkedHashMap<Long, String> linkedHashMap = c;
        synchronized (linkedHashMap) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            i = 0;
            int i2 = 0;
            for (Long l : linkedHashMap.keySet()) {
                if (j < l.longValue() && l.longValue() <= j2) {
                    i2++;
                    String str2 = c.get(l);
                    linkedHashMap2.put(str2, Integer.valueOf(linkedHashMap2.containsKey(str2) ? 1 + ((Integer) linkedHashMap2.get(str2)).intValue() : 1));
                }
            }
            str = null;
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                double d2 = intValue;
                double d3 = i2;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = d2 / d3;
                if (intValue >= i && d4 > 0.6d) {
                    str = (String) entry.getKey();
                    i = intValue;
                }
            }
        }
        return i <= 0 ? b(j, j2) : str;
    }

    public void d(long j, long j2) {
        synchronized (this) {
            d = c(j, j2);
        }
    }

    public String d() {
        String str;
        synchronized (this) {
            str = d;
            d = null;
        }
        return str;
    }

    @Override // com.alipay.iap.android.aplog.monitor.sampler.AbstractSampler
    protected void c() {
        LoggerFactory.getTraceLogger().info("ANRMonitor", "MainStackSampler.doSample");
        String stackTraceString = Log.getStackTraceString(ANRError.NewMainOnly());
        if (TextUtils.isEmpty(stackTraceString)) {
            return;
        }
        LinkedHashMap<Long, String> linkedHashMap = c;
        synchronized (linkedHashMap) {
            int size = linkedHashMap.size();
            int i = this.e;
            if (size >= i && i > 0) {
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
            }
            linkedHashMap.put(Long.valueOf(System.currentTimeMillis()), stackTraceString);
        }
    }
}
