package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.d;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class c {
    private static final String MyBillsEntityDataFactory = "c";
    private final GrsBaseInfo BuiltInFictitiousFunctionClassFactory;
    private final com.huawei.hms.framework.network.grs.g.k.c DatabaseTableConfigUtil;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private com.huawei.hms.framework.network.grs.g.k.d NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final com.huawei.hms.framework.network.grs.e.a PlaceComponentResult;
    String getAuthRequestContext;
    private d scheduleImpl;
    private final Map<String, Future<d>> getErrorConfigVersion = new ConcurrentHashMap(16);
    private final List<d> NetworkUserEntityData$$ExternalSyntheticLambda0 = new CopyOnWriteArrayList();
    private final JSONArray moveToNextValue = new JSONArray();
    private final List<String> lookAheadTest = new CopyOnWriteArrayList();
    private final List<String> initRecordTimeStamp = new CopyOnWriteArrayList();
    private long GetContactSyncConfig = 1;

    private d getAuthRequestContext(d dVar) {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.getErrorConfigVersion.entrySet()) {
            if (dVar != null && (dVar.MyBillsEntityDataFactory() || dVar.KClassImpl$Data$declaredNonStaticMembers$2())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e = e;
                str = MyBillsEntityDataFactory;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(MyBillsEntityDataFactory, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e2) {
                e = e2;
                str = MyBillsEntityDataFactory;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(MyBillsEntityDataFactory, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements Callable<d> {
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ String MyBillsEntityDataFactory;
        final /* synthetic */ ExecutorService getAuthRequestContext;

        a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
            this.getAuthRequestContext = executorService;
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = cVar;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ d call() {
            return c.getAuthRequestContext(c.this, this.getAuthRequestContext, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public c(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.getAuthRequestContext = "";
        this.DatabaseTableConfigUtil = cVar;
        this.BuiltInFictitiousFunctionClassFactory = cVar.PlaceComponentResult;
        Context context = cVar.MyBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = aVar;
        com.huawei.hms.framework.network.grs.g.k.d KClassImpl$Data$declaredNonStaticMembers$2 = com.huawei.hms.framework.network.grs.g.j.a.KClassImpl$Data$declaredNonStaticMembers$2(context);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Logger.w(MyBillsEntityDataFactory, "g*s***_se****er_conf*** maybe has a big error");
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$2;
            List<String> list = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            if (list == null || list.size() <= 0) {
                Logger.v(MyBillsEntityDataFactory, "maybe grs_base_url config with [],please check.");
            } else if (list.size() > 10) {
                throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
            } else {
                String str = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                String str2 = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
                if (list.size() > 0) {
                    for (String str3 : list) {
                        if (str3.startsWith("https://")) {
                            if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.getAppName()) || !TextUtils.isEmpty(MyBillsEntityDataFactory())) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str3);
                                Locale locale = Locale.ROOT;
                                Object[] objArr = new Object[1];
                                objArr[0] = TextUtils.isEmpty(MyBillsEntityDataFactory()) ? this.BuiltInFictitiousFunctionClassFactory.getAppName() : MyBillsEntityDataFactory();
                                sb.append(String.format(locale, str, objArr));
                                String grsReqParamJoint = this.BuiltInFictitiousFunctionClassFactory.getGrsReqParamJoint(false, false, "1.0", this.KClassImpl$Data$declaredNonStaticMembers$2);
                                if (!TextUtils.isEmpty(grsReqParamJoint)) {
                                    sb.append("?");
                                    sb.append(grsReqParamJoint);
                                }
                                this.lookAheadTest.add(sb.toString());
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(str2);
                            String grsReqParamJoint2 = this.BuiltInFictitiousFunctionClassFactory.getGrsReqParamJoint(false, false, MyBillsEntityDataFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (!TextUtils.isEmpty(grsReqParamJoint2)) {
                                sb2.append("?");
                                sb2.append(grsReqParamJoint2);
                            }
                            this.initRecordTimeStamp.add(sb2.toString());
                        } else {
                            Logger.w(MyBillsEntityDataFactory, "grs server just support https scheme url,please check.");
                        }
                    }
                }
                Logger.v(MyBillsEntityDataFactory, "request to GRS server url is{%s} and {%s}", this.lookAheadTest, this.initRecordTimeStamp);
            }
        }
        String grsParasKey = this.BuiltInFictitiousFunctionClassFactory.getGrsParasKey(true, true, this.KClassImpl$Data$declaredNonStaticMembers$2);
        com.huawei.hms.framework.network.grs.e.c cVar2 = this.PlaceComponentResult.PlaceComponentResult;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(grsParasKey);
        sb3.append("ETag");
        this.getAuthRequestContext = cVar2.getAuthRequestContext(sb3.toString(), "");
    }

    static /* synthetic */ d getAuthRequestContext(c cVar, ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d PlaceComponentResult = cVar.PlaceComponentResult(executorService, cVar.initRecordTimeStamp, str, cVar2);
        int i = PlaceComponentResult == null ? 0 : PlaceComponentResult.PlaceComponentResult;
        String str2 = MyBillsEntityDataFactory;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(i));
        if (i == 404 || i == 401) {
            if (TextUtils.isEmpty(cVar.MyBillsEntityDataFactory()) && TextUtils.isEmpty(cVar.BuiltInFictitiousFunctionClassFactory.getAppName())) {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            cVar.getErrorConfigVersion.clear();
            Logger.i(str2, "this env has not deploy new interface,so use old interface.");
            PlaceComponentResult = cVar.PlaceComponentResult(executorService, cVar.lookAheadTest, str, cVar2);
        }
        e.BuiltInFictitiousFunctionClassFactory(new ArrayList(cVar.NetworkUserEntityData$$ExternalSyntheticLambda0), SystemClock.elapsedRealtime() - elapsedRealtime, cVar.moveToNextValue, cVar.KClassImpl$Data$declaredNonStaticMembers$2);
        cVar.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        return PlaceComponentResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed A[LOOP:0: B:3:0x0006->B:41:0x00ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.g.d PlaceComponentResult(java.util.concurrent.ExecutorService r25, java.util.List<java.lang.String> r26, java.lang.String r27, com.huawei.hms.framework.network.grs.e.c r28) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.c.PlaceComponentResult(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    private String MyBillsEntityDataFactory() {
        com.huawei.hms.framework.network.grs.f.b BuiltInFictitiousFunctionClassFactory = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), this.BuiltInFictitiousFunctionClassFactory);
        com.huawei.hms.framework.network.grs.local.model.a MyBillsEntityDataFactory2 = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.MyBillsEntityDataFactory() : null;
        if (MyBillsEntityDataFactory2 != null) {
            String str = MyBillsEntityDataFactory2.MyBillsEntityDataFactory;
            Logger.v(MyBillsEntityDataFactory, "get appName from local assets is{%s}", str);
            return str;
        }
        return "";
    }

    public final d MyBillsEntityDataFactory(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        String str2;
        String str3;
        if (this.lookAheadTest.isEmpty() && this.initRecordTimeStamp.isEmpty()) {
            return null;
        }
        try {
            return (d) executorService.submit(new a(executorService, str, cVar)).get(this.NetworkUserEntityData$$ExternalSyntheticLambda2 != null ? r0.PlaceComponentResult : 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            str2 = MyBillsEntityDataFactory;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e);
            return null;
        } catch (CancellationException unused) {
            Logger.i(MyBillsEntityDataFactory, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            str2 = MyBillsEntityDataFactory;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(MyBillsEntityDataFactory, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e3) {
            e = e3;
            str2 = MyBillsEntityDataFactory;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e);
            return null;
        }
    }

    public final void PlaceComponentResult(d dVar) {
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(dVar);
            d dVar2 = this.scheduleImpl;
            if (dVar2 != null && (dVar2.MyBillsEntityDataFactory() || this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2())) {
                Logger.v(MyBillsEntityDataFactory, "grsResponseResult is ok");
            } else if (dVar.BuiltInFictitiousFunctionClassFactory()) {
                Logger.i(MyBillsEntityDataFactory, "GRS server open 503 limiting strategy.");
                com.huawei.hms.framework.network.grs.h.d.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getGrsParasKey(true, true, this.KClassImpl$Data$declaredNonStaticMembers$2), new d.a(dVar.getErrorConfigVersion, SystemClock.elapsedRealtime()));
            } else {
                if (dVar.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    Logger.i(MyBillsEntityDataFactory, "GRS server open 304 Not Modified.");
                }
                if (!dVar.MyBillsEntityDataFactory() && !dVar.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    Logger.v(MyBillsEntityDataFactory, "grsResponseResult has exception so need return");
                    return;
                }
                this.scheduleImpl = dVar;
                com.huawei.hms.framework.network.grs.e.a aVar = this.PlaceComponentResult;
                GrsBaseInfo grsBaseInfo = this.BuiltInFictitiousFunctionClassFactory;
                Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
                com.huawei.hms.framework.network.grs.g.k.c cVar = this.DatabaseTableConfigUtil;
                if (dVar.NetworkUserEntityData$$ExternalSyntheticLambda0 == 2) {
                    Logger.w(com.huawei.hms.framework.network.grs.e.a.KClassImpl$Data$declaredNonStaticMembers$2, "update cache from server failed");
                } else if (cVar.KClassImpl$Data$declaredNonStaticMembers$2.size() == 0) {
                    String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
                    if (dVar.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        aVar.BuiltInFictitiousFunctionClassFactory.put(grsParasKey, com.huawei.hms.framework.network.grs.a.PlaceComponentResult(aVar.PlaceComponentResult.getAuthRequestContext(grsParasKey, "")));
                    } else {
                        com.huawei.hms.framework.network.grs.e.c cVar2 = aVar.PlaceComponentResult;
                        String str = dVar.BuiltInFictitiousFunctionClassFactory;
                        PLSharedPreferences pLSharedPreferences = cVar2.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (pLSharedPreferences != null) {
                            synchronized (pLSharedPreferences) {
                                cVar2.KClassImpl$Data$declaredNonStaticMembers$2.putString(grsParasKey, str);
                            }
                        }
                        aVar.BuiltInFictitiousFunctionClassFactory.put(grsParasKey, com.huawei.hms.framework.network.grs.a.PlaceComponentResult(dVar.BuiltInFictitiousFunctionClassFactory));
                    }
                    if (!TextUtils.isEmpty(dVar.lookAheadTest)) {
                        com.huawei.hms.framework.network.grs.e.c cVar3 = aVar.PlaceComponentResult;
                        StringBuilder sb = new StringBuilder();
                        sb.append(grsParasKey);
                        sb.append("ETag");
                        String obj = sb.toString();
                        String str2 = dVar.lookAheadTest;
                        PLSharedPreferences pLSharedPreferences2 = cVar3.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (pLSharedPreferences2 != null) {
                            synchronized (pLSharedPreferences2) {
                                cVar3.KClassImpl$Data$declaredNonStaticMembers$2.putString(obj, str2);
                            }
                        }
                    }
                    com.huawei.hms.framework.network.grs.e.c cVar4 = aVar.PlaceComponentResult;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(grsParasKey);
                    sb2.append("time");
                    String obj2 = sb2.toString();
                    String str3 = dVar.moveToNextValue;
                    PLSharedPreferences pLSharedPreferences3 = cVar4.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pLSharedPreferences3 != null) {
                        synchronized (pLSharedPreferences3) {
                            cVar4.KClassImpl$Data$declaredNonStaticMembers$2.putString(obj2, str3);
                        }
                    }
                    aVar.MyBillsEntityDataFactory.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.moveToNextValue)));
                } else {
                    com.huawei.hms.framework.network.grs.e.c cVar5 = aVar.PlaceComponentResult;
                    String str4 = dVar.BuiltInFictitiousFunctionClassFactory;
                    PLSharedPreferences pLSharedPreferences4 = cVar5.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pLSharedPreferences4 != null) {
                        synchronized (pLSharedPreferences4) {
                            cVar5.KClassImpl$Data$declaredNonStaticMembers$2.putString("geoipCountryCode", str4);
                        }
                    }
                    com.huawei.hms.framework.network.grs.e.c cVar6 = aVar.PlaceComponentResult;
                    String str5 = dVar.moveToNextValue;
                    PLSharedPreferences pLSharedPreferences5 = cVar6.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pLSharedPreferences5 != null) {
                        synchronized (pLSharedPreferences5) {
                            cVar6.KClassImpl$Data$declaredNonStaticMembers$2.putString("geoipCountryCodetime", str5);
                        }
                    }
                }
                for (Map.Entry<String, Future<d>> entry : this.getErrorConfigVersion.entrySet()) {
                    if (!entry.getKey().equals(dVar.NetworkUserEntityData$$ExternalSyntheticLambda1) && !entry.getValue().isCancelled()) {
                        Logger.i(MyBillsEntityDataFactory, "future cancel");
                        entry.getValue().cancel(true);
                    }
                }
            }
        }
    }
}
