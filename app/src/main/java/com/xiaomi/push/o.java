package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class o {
    private static volatile o KClassImpl$Data$declaredNonStaticMembers$2;
    private SharedPreferences PlaceComponentResult;
    public ScheduledThreadPoolExecutor BuiltInFictitiousFunctionClassFactory = new ScheduledThreadPoolExecutor(1);
    private Map<String, ScheduledFuture> MyBillsEntityDataFactory = new HashMap();
    private Object getAuthRequestContext = new Object();

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        public abstract String PlaceComponentResult();
    }

    /* loaded from: classes8.dex */
    static class b implements Runnable {
        a BuiltInFictitiousFunctionClassFactory;

        public b(a aVar) {
            this.BuiltInFictitiousFunctionClassFactory = aVar;
        }

        void PlaceComponentResult() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.BuiltInFictitiousFunctionClassFactory.run();
            PlaceComponentResult();
        }
    }

    private o(Context context) {
        this.PlaceComponentResult = context.getSharedPreferences("mipush_extra", 0);
    }

    public static o PlaceComponentResult(Context context) {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (o.class) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = new o(context);
                }
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private ScheduledFuture getAuthRequestContext(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.getAuthRequestContext) {
            scheduledFuture = this.MyBillsEntityDataFactory.get(aVar.PlaceComponentResult());
        }
        return scheduledFuture;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(a aVar, int i) {
        if (getAuthRequestContext(aVar) == null) {
            ScheduledFuture<?> schedule = this.BuiltInFictitiousFunctionClassFactory.schedule(new q(this, aVar), i, TimeUnit.SECONDS);
            synchronized (this.getAuthRequestContext) {
                this.MyBillsEntityDataFactory.put(aVar.PlaceComponentResult(), schedule);
            }
            return true;
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(a aVar, int i) {
        return MyBillsEntityDataFactory(aVar, i, 0);
    }

    public final boolean MyBillsEntityDataFactory(a aVar, int i, int i2) {
        return BuiltInFictitiousFunctionClassFactory(aVar, i, i2);
    }

    public final boolean MyBillsEntityDataFactory(String str) {
        synchronized (this.getAuthRequestContext) {
            ScheduledFuture scheduledFuture = this.MyBillsEntityDataFactory.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.MyBillsEntityDataFactory.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory(a aVar, int i, int i2) {
        if (aVar == null || getAuthRequestContext(aVar) != null) {
            return false;
        }
        String PlaceComponentResult = aVar.PlaceComponentResult();
        StringBuilder sb = new StringBuilder();
        sb.append("last_job_time");
        sb.append(PlaceComponentResult);
        String obj = sb.toString();
        p pVar = new p(this, aVar, obj);
        long abs = Math.abs(System.currentTimeMillis() - this.PlaceComponentResult.getLong(obj, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.BuiltInFictitiousFunctionClassFactory.scheduleAtFixedRate(pVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.getAuthRequestContext) {
                this.MyBillsEntityDataFactory.put(aVar.PlaceComponentResult(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return true;
        }
    }
}
