package com.akamai.botman;

import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class t {
    public final b BuiltInFictitiousFunctionClassFactory;
    ArrayList<g> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
    AtomicBoolean MyBillsEntityDataFactory = new AtomicBoolean(false);
    Future<Pair<String, Long>> PlaceComponentResult;
    public int getAuthRequestContext;
    public long getErrorConfigVersion;

    public t() {
        b bVar = new b(this, (byte) 0);
        this.BuiltInFictitiousFunctionClassFactory = bVar;
        bVar.getAuthRequestContext = SystemClock.uptimeMillis();
        this.getAuthRequestContext = 0;
        this.getErrorConfigVersion = 0L;
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        MyBillsEntityDataFactory();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Long> PlaceComponentResult() throws java.lang.Exception {
        /*
            r6 = this;
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r0 = r6.PlaceComponentResult
            r1 = 0
            java.lang.String r2 = "TextChangeManager"
            java.lang.String r3 = "Failed to get Text data: "
            if (r0 == 0) goto L3d
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            android.util.Pair r0 = (android.util.Pair) r0     // Catch: java.util.concurrent.ExecutionException -> L10 java.lang.InterruptedException -> L27
            goto L3e
        L10:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r0, r4)
            goto L3d
        L27:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Throwable[] r4 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r0, r4)
        L3d:
            r0 = 0
        L3e:
            if (r0 != 0) goto L7f
            android.util.Pair r0 = r6.getAuthRequestContext()
            if (r0 != 0) goto L7f
            java.util.concurrent.Future<android.util.Pair<java.lang.String, java.lang.Long>> r4 = r6.PlaceComponentResult
            if (r4 == 0) goto L7f
            java.lang.Object r4 = r4.get()     // Catch: java.util.concurrent.ExecutionException -> L52 java.lang.InterruptedException -> L69
            android.util.Pair r4 = (android.util.Pair) r4     // Catch: java.util.concurrent.ExecutionException -> L52 java.lang.InterruptedException -> L69
            r0 = r4
            goto L7f
        L52:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
            goto L7f
        L69:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r3)
            java.lang.String r3 = r4.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.Throwable[] r1 = new java.lang.Throwable[r1]
            com.akamai.botman.ah.MyBillsEntityDataFactory(r2, r3, r1)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.t.PlaceComponentResult():android.util.Pair");
    }

    final Pair<String, Long> getAuthRequestContext() throws Exception {
        String str = "";
        long j = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.size() == 0) {
            return new Pair<>("", 0L);
        }
        if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
            Iterator<g> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                g next = it.next();
                StringBuilder sb = new StringBuilder();
                sb.append(next.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(",");
                sb.append(Long.valueOf(next.getAuthRequestContext));
                sb.append(",");
                sb.append(next.BuiltInFictitiousFunctionClassFactory);
                String obj = sb.toString();
                if (next.PlaceComponentResult) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(obj);
                    sb2.append(",1");
                    obj = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj);
                sb3.append(";");
                String obj2 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(obj2);
                str = sb4.toString();
                j += next.getAuthRequestContext + q.PlaceComponentResult(next.KClassImpl$Data$declaredNonStaticMembers$2) + next.BuiltInFictitiousFunctionClassFactory;
                long uptimeMillis = SystemClock.uptimeMillis();
                long j2 = d.PlaceComponentResult;
                long j3 = next.getAuthRequestContext;
                this.KClassImpl$Data$declaredNonStaticMembers$2.size();
                Objects.toString(Long.valueOf((uptimeMillis - j2) - j3));
            }
            this.MyBillsEntityDataFactory.set(false);
            return new Pair<>(str, Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class b implements Observer {
        private int BuiltInFictitiousFunctionClassFactory;
        long getAuthRequestContext;

        private b() {
            this.BuiltInFictitiousFunctionClassFactory = -1;
        }

        /* synthetic */ b(t tVar, byte b) {
            this();
        }

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            try {
                t.this.getErrorConfigVersion++;
                if (obj == null || t.this.KClassImpl$Data$declaredNonStaticMembers$2.size() >= 50 || t.this.MyBillsEntityDataFactory.get()) {
                    return;
                }
                g gVar = (g) obj;
                g gVar2 = new g(gVar.getAuthRequestContext - this.getAuthRequestContext, gVar.KClassImpl$Data$declaredNonStaticMembers$2, gVar.BuiltInFictitiousFunctionClassFactory, gVar.PlaceComponentResult);
                if (this.BuiltInFictitiousFunctionClassFactory != gVar.BuiltInFictitiousFunctionClassFactory) {
                    t.this.getAuthRequestContext = 0;
                    this.BuiltInFictitiousFunctionClassFactory = gVar.BuiltInFictitiousFunctionClassFactory;
                }
                if (t.this.getAuthRequestContext < 9) {
                    t.this.getAuthRequestContext++;
                    t.this.KClassImpl$Data$declaredNonStaticMembers$2.add(gVar2);
                }
                this.getAuthRequestContext = gVar.getAuthRequestContext;
                if (t.this.KClassImpl$Data$declaredNonStaticMembers$2.size() >= 50) {
                    t tVar = t.this;
                    if (tVar.PlaceComponentResult == null || tVar.PlaceComponentResult.isCancelled() || tVar.PlaceComponentResult.isDone()) {
                        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
                        tVar.PlaceComponentResult = newFixedThreadPool.submit(new a());
                        newFixedThreadPool.shutdown();
                    }
                }
            } catch (Exception e) {
                ah.MyBillsEntityDataFactory("TextChangeManager", "Exception in processing text change event", e);
                f.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        Future<Pair<String, Long>> future = this.PlaceComponentResult;
        if (future != null) {
            if (!future.isCancelled() && !this.PlaceComponentResult.isDone()) {
                this.PlaceComponentResult.cancel(true);
            }
            this.PlaceComponentResult = null;
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Callable<Pair<String, Long>> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Pair<String, Long> call() throws Exception {
            return t.this.getAuthRequestContext();
        }
    }
}
