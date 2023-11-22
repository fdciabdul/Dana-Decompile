package com.alibaba.griver.base.resource.offline;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.FileCache;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverOfflinePkgManager {
    private static volatile GriverOfflinePkgManager f;

    /* renamed from: a  reason: collision with root package name */
    private Context f6366a;
    private SharedPreferences b;
    private Map<String, ?> c;
    private long e = FileCache.EXPIRE_TIME;
    private JSONObject d = GriverInnerConfig.getConfigJSONObject("android_offline_package_automatic_clean");

    public boolean needCleanPkg() {
        return System.currentTimeMillis() - this.b.getLong("lastDay", System.currentTimeMillis()) > 86400000;
    }

    public void cleanPkg() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null && jSONObject.getBoolean("enable").booleanValue() && needCleanPkg()) {
            this.b.edit().putLong("lastDay", a()).commit();
            try {
                this.e = this.d.getLong("time").longValue() * 1000;
            } catch (Exception unused) {
                this.e = FileCache.EXPIRE_TIME;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.c.keySet()) {
                if ((this.c.get(str) instanceof Long) && currentTimeMillis - ((Long) this.c.get(str)).longValue() > this.e) {
                    b(str);
                    a(str);
                }
            }
        }
    }

    public long getCleanTime() {
        return this.e;
    }

    private void a(String str) {
        MonitorMap.Builder needAsynAppType = new MonitorMap.Builder().needAsynAppType(true);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] split = str.split(File.separator);
        String str2 = (split == null || split.length == 0) ? "" : split[split.length - 1];
        needAsynAppType.append(LogConstants.KEY_TIME_STAPM, simpleDateFormat.format(date));
        needAsynAppType.append("pluginId&version", str2);
        GriverMonitor.event("offline_package_clean", "GriverAppContainer", needAsynAppType.build());
    }

    private void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            FileUtils.delete(file);
        }
    }

    public void updatePkgTime(String str, long j) {
        this.b.edit().putLong(str, j).commit();
    }

    private GriverOfflinePkgManager(Context context) {
        this.f6366a = context;
        this.b = context.getSharedPreferences("griver_offline_pkg", 4);
        this.c = this.b.getAll();
        if (this.b.getLong("lastDay", 0L) == 0) {
            this.b.edit().putLong("lastDay", a()).commit();
        }
    }

    private long a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime().getTime();
    }

    public static GriverOfflinePkgManager getInstance() {
        return f;
    }

    public static GriverOfflinePkgManager getInstance(Context context) {
        if (f == null) {
            synchronized (GriverOfflinePkgManager.class) {
                if (f == null) {
                    f = new GriverOfflinePkgManager(context);
                }
            }
        }
        return f;
    }
}
