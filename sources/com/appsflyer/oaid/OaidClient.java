package com.appsflyer.oaid;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.framework.common.EmuiUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class OaidClient {
    private final Context context;
    private final Logger logger;
    private final long timeout;
    private final TimeUnit unit;

    private static boolean isMsaAvailableAtRuntime() {
        return true;
    }

    public OaidClient(Context context, long j, TimeUnit timeUnit) {
        Logger logger = Logger.getLogger("AppsFlyerOaid6.2.4");
        this.logger = logger;
        this.context = context;
        this.timeout = j;
        this.unit = timeUnit;
        logger.setLevel(Level.OFF);
    }

    public OaidClient(Context context) {
        this(context, 1L, TimeUnit.SECONDS);
    }

    private static boolean isHuawei() {
        if (!Build.BRAND.equalsIgnoreCase("huawei")) {
            if (((Integer) Class.forName(EmuiUtil.BUILDEX_VERSION).getDeclaredField(EmuiUtil.EMUI_SDK_INT).get(null)).intValue() <= 0) {
                return false;
            }
        }
        return true;
    }

    public Info fetch() {
        Info fetchMsa;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (isHuawei()) {
                fetchMsa = fetchHuawei();
            } else {
                fetchMsa = isMsaAvailableAtRuntime() ? OaidMsaClient.fetchMsa(this.context, this.logger, this.timeout, this.unit) : null;
            }
            Logger logger = this.logger;
            StringBuilder sb = new StringBuilder();
            sb.append("Fetch ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append(" ms");
            logger.info(sb.toString());
            return fetchMsa;
        } catch (Throwable th) {
            this.logger.info(th.getMessage());
            return null;
        }
    }

    private Info fetchHuawei() {
        try {
            FutureTask futureTask = new FutureTask(new Callable<Info>() { // from class: com.appsflyer.oaid.OaidClient.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Info call() {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(OaidClient.this.context);
                    if (advertisingIdInfo == null) {
                        return null;
                    }
                    return new Info(advertisingIdInfo.getId(), Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled()));
                }
            });
            new Thread(futureTask).start();
            return (Info) futureTask.get(this.timeout, this.unit);
        } catch (Throwable th) {
            this.logger.info(th.getMessage());
            return null;
        }
    }

    public void setLogging(boolean z) {
        this.logger.setLevel(z ? null : Level.OFF);
    }

    /* loaded from: classes.dex */
    public static class Info {

        /* renamed from: id  reason: collision with root package name */
        private final String f7417id;
        private final Boolean lat;

        public Info(String str, Boolean bool) {
            this.f7417id = str;
            this.lat = bool;
        }

        public Info(String str) {
            this(str, null);
        }

        public String getId() {
            return this.f7417id;
        }

        public Boolean getLat() {
            return this.lat;
        }
    }
}
