package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.griver.base.common.utils.FileCache;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.g.i;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
public class c {
    static final String BuiltInFictitiousFunctionClassFactory = "c";
    private FutureTask<Boolean> DatabaseTableConfigUtil;
    GrsBaseInfo KClassImpl$Data$declaredNonStaticMembers$2;
    Context MyBillsEntityDataFactory;
    private com.huawei.hms.framework.network.grs.e.a NetworkUserEntityData$$ExternalSyntheticLambda0;
    com.huawei.hms.framework.network.grs.e.c PlaceComponentResult;
    h getAuthRequestContext;
    com.huawei.hms.framework.network.grs.a getErrorConfigVersion;
    private com.huawei.hms.framework.network.grs.e.c lookAheadTest;
    private static final ExecutorService scheduleImpl = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    private static AtomicInteger moveToNextValue = new AtomicInteger(0);

    private static boolean PlaceComponentResult(long j) {
        return System.currentTimeMillis() - j <= FileCache.EXPIRE_TIME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(Object obj) {
        if (this == obj) {
            return true;
        }
        if (c.class == obj.getClass()) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.compare(((c) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.DatabaseTableConfigUtil;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e) {
            e = e;
            str = BuiltInFictitiousFunctionClassFactory;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(BuiltInFictitiousFunctionClassFactory, "init compute task canceled.");
            return false;
        } catch (ExecutionException e2) {
            e = e2;
            str = BuiltInFictitiousFunctionClassFactory;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(BuiltInFictitiousFunctionClassFactory, "init compute task timed out");
            return false;
        } catch (Exception e3) {
            e = e3;
            str = BuiltInFictitiousFunctionClassFactory;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    /* loaded from: classes7.dex */
    class a implements Callable<Boolean> {
        final /* synthetic */ Context PlaceComponentResult;
        final /* synthetic */ GrsBaseInfo getAuthRequestContext;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.PlaceComponentResult = context;
            this.getAuthRequestContext = grsBaseInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            c.this.getAuthRequestContext = new h();
            c cVar = c.this;
            Context context = this.PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append(GrsApp.getInstance().getBrand("_"));
            sb.append("share_pre_grs_conf_");
            cVar.PlaceComponentResult = new com.huawei.hms.framework.network.grs.e.c(context, sb.toString());
            c cVar2 = c.this;
            Context context2 = this.PlaceComponentResult;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(GrsApp.getInstance().getBrand("_"));
            sb2.append("share_pre_grs_services_");
            cVar2.lookAheadTest = new com.huawei.hms.framework.network.grs.e.c(context2, sb2.toString());
            c cVar3 = c.this;
            cVar3.NetworkUserEntityData$$ExternalSyntheticLambda0 = new com.huawei.hms.framework.network.grs.e.a(cVar3.PlaceComponentResult, c.this.lookAheadTest, c.this.getAuthRequestContext);
            c cVar4 = c.this;
            cVar4.getErrorConfigVersion = new com.huawei.hms.framework.network.grs.a(cVar4.KClassImpl$Data$declaredNonStaticMembers$2, c.this.NetworkUserEntityData$$ExternalSyntheticLambda0, c.this.getAuthRequestContext, c.this.lookAheadTest);
            if (c.moveToNextValue.incrementAndGet() <= 2 || com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getPackageName(), c.this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.PlaceComponentResult, this.getAuthRequestContext).MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            }
            com.huawei.hms.framework.network.grs.g.k.c cVar5 = new com.huawei.hms.framework.network.grs.g.k.c(this.getAuthRequestContext, this.PlaceComponentResult);
            String PlaceComponentResult = cVar5.KClassImpl$Data$declaredNonStaticMembers$2.size() == 0 ? cVar5.PlaceComponentResult() : cVar5.KClassImpl$Data$declaredNonStaticMembers$2();
            String str = c.BuiltInFictitiousFunctionClassFactory;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("scan serviceSet is:");
            sb3.append(PlaceComponentResult);
            Logger.v(str, sb3.toString());
            String authRequestContext = c.this.lookAheadTest.getAuthRequestContext("services", "");
            String authRequestContext2 = i.getAuthRequestContext(authRequestContext, PlaceComponentResult);
            if (!TextUtils.isEmpty(authRequestContext2)) {
                com.huawei.hms.framework.network.grs.e.c cVar6 = c.this.lookAheadTest;
                PLSharedPreferences pLSharedPreferences = cVar6.KClassImpl$Data$declaredNonStaticMembers$2;
                if (pLSharedPreferences != null) {
                    synchronized (pLSharedPreferences) {
                        cVar6.KClassImpl$Data$declaredNonStaticMembers$2.putString("services", authRequestContext2);
                    }
                }
                String str2 = c.BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("postList is:");
                sb4.append(StringUtils.anonymizeMessage(authRequestContext2));
                Logger.i(str2, sb4.toString());
                String str3 = c.BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("currentServices:");
                sb5.append(StringUtils.anonymizeMessage(authRequestContext));
                Logger.i(str3, sb5.toString());
                if (!authRequestContext2.equals(authRequestContext)) {
                    String grsParasKey = c.this.KClassImpl$Data$declaredNonStaticMembers$2.getGrsParasKey(true, true, this.PlaceComponentResult);
                    h hVar = c.this.getAuthRequestContext;
                    synchronized (hVar.BuiltInFictitiousFunctionClassFactory) {
                        hVar.MyBillsEntityDataFactory.remove(grsParasKey);
                    }
                    c.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new com.huawei.hms.framework.network.grs.g.k.c(this.getAuthRequestContext, this.PlaceComponentResult), null, c.this.lookAheadTest);
                }
            }
            c cVar7 = c.this;
            c.PlaceComponentResult(cVar7, cVar7.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
            com.huawei.hms.framework.network.grs.e.a aVar = c.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            GrsBaseInfo grsBaseInfo = this.getAuthRequestContext;
            Context context3 = this.PlaceComponentResult;
            String grsParasKey2 = grsBaseInfo.getGrsParasKey(true, true, context3);
            String authRequestContext3 = aVar.PlaceComponentResult.getAuthRequestContext(grsParasKey2, "");
            com.huawei.hms.framework.network.grs.e.c cVar8 = aVar.PlaceComponentResult;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(grsParasKey2);
            sb6.append("time");
            String authRequestContext4 = cVar8.getAuthRequestContext(sb6.toString(), "0");
            long j = 0;
            if (!TextUtils.isEmpty(authRequestContext4) && authRequestContext4.matches("\\d+")) {
                try {
                    j = Long.parseLong(authRequestContext4);
                } catch (NumberFormatException e) {
                    Logger.w(com.huawei.hms.framework.network.grs.e.a.KClassImpl$Data$declaredNonStaticMembers$2, "convert urlParamKey from String to Long catch NumberFormatException.", e);
                }
            }
            aVar.BuiltInFictitiousFunctionClassFactory.put(grsParasKey2, com.huawei.hms.framework.network.grs.a.PlaceComponentResult(authRequestContext3));
            aVar.MyBillsEntityDataFactory.put(grsParasKey2, Long.valueOf(j));
            if (e.getAuthRequestContext(aVar.MyBillsEntityDataFactory.get(grsParasKey2))) {
                com.huawei.hms.framework.network.grs.g.k.c cVar9 = new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context3);
                h hVar2 = aVar.NetworkUserEntityData$$ExternalSyntheticLambda0;
                hVar2.getAuthRequestContext.execute(new h.b(cVar9, null, aVar.getAuthRequestContext, null));
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.DatabaseTableConfigUtil = null;
        this.MyBillsEntityDataFactory = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e) {
            Logger.w(BuiltInFictitiousFunctionClassFactory, "GrsClient catch CloneNotSupportedException", e);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = grsBaseInfo.copy();
        }
        GrsBaseInfo grsBaseInfo2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.MyBillsEntityDataFactory, grsBaseInfo2));
        this.DatabaseTableConfigUtil = futureTask;
        scheduleImpl.execute(futureTask);
        Logger.i(BuiltInFictitiousFunctionClassFactory, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.PlaceComponentResult(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GrsBaseInfo grsBaseInfo) {
        this.DatabaseTableConfigUtil = null;
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e) {
            Logger.w(BuiltInFictitiousFunctionClassFactory, "GrsClient catch CloneNotSupportedException", e);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = grsBaseInfo.copy();
        }
    }

    static /* synthetic */ void PlaceComponentResult(c cVar, Map map) {
        if (map == null || map.isEmpty()) {
            Logger.v(BuiltInFictitiousFunctionClassFactory, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith("time")) {
                String authRequestContext = cVar.PlaceComponentResult.getAuthRequestContext(str, "");
                long j = 0;
                if (!TextUtils.isEmpty(authRequestContext) && authRequestContext.matches("\\d+")) {
                    try {
                        j = Long.parseLong(authRequestContext);
                    } catch (NumberFormatException e) {
                        Logger.w(BuiltInFictitiousFunctionClassFactory, "convert expire time from String to Long catch NumberFormatException.", e);
                    }
                }
                if (PlaceComponentResult(j)) {
                    continue;
                } else {
                    Logger.i(BuiltInFictitiousFunctionClassFactory, "init interface auto clear some invalid sp's data.");
                    String substring = str.substring(0, str.length() - 4);
                    StringBuilder sb = new StringBuilder();
                    sb.append(substring);
                    sb.append("ETag");
                    String obj = sb.toString();
                    com.huawei.hms.framework.network.grs.e.c cVar2 = cVar.PlaceComponentResult;
                    PLSharedPreferences pLSharedPreferences = cVar2.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pLSharedPreferences != null) {
                        synchronized (pLSharedPreferences) {
                            cVar2.KClassImpl$Data$declaredNonStaticMembers$2.remove(substring);
                        }
                    }
                    com.huawei.hms.framework.network.grs.e.c cVar3 = cVar.PlaceComponentResult;
                    PLSharedPreferences pLSharedPreferences2 = cVar3.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pLSharedPreferences2 != null) {
                        synchronized (pLSharedPreferences2) {
                            cVar3.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
                        }
                    }
                    com.huawei.hms.framework.network.grs.e.c cVar4 = cVar.PlaceComponentResult;
                    PLSharedPreferences pLSharedPreferences3 = cVar4.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pLSharedPreferences3 != null) {
                        synchronized (pLSharedPreferences3) {
                            cVar4.KClassImpl$Data$declaredNonStaticMembers$2.remove(obj);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!getAuthRequestContext() || (grsBaseInfo = this.KClassImpl$Data$declaredNonStaticMembers$2) == null || (context = this.MyBillsEntityDataFactory) == null) {
            return false;
        }
        com.huawei.hms.framework.network.grs.e.a aVar = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        com.huawei.hms.framework.network.grs.e.c cVar = aVar.PlaceComponentResult;
        StringBuilder sb = new StringBuilder();
        sb.append(grsParasKey);
        sb.append("time");
        String obj = sb.toString();
        PLSharedPreferences pLSharedPreferences = cVar.KClassImpl$Data$declaredNonStaticMembers$2;
        if (pLSharedPreferences != null) {
            synchronized (pLSharedPreferences) {
                cVar.KClassImpl$Data$declaredNonStaticMembers$2.putString(obj, "0");
            }
        }
        Map<String, Long> map = aVar.MyBillsEntityDataFactory;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(grsParasKey);
        sb2.append("time");
        map.remove(sb2.toString());
        aVar.BuiltInFictitiousFunctionClassFactory.remove(grsParasKey);
        h hVar = aVar.NetworkUserEntityData$$ExternalSyntheticLambda0;
        synchronized (hVar.BuiltInFictitiousFunctionClassFactory) {
            hVar.MyBillsEntityDataFactory.remove(grsParasKey);
        }
        return true;
    }
}
