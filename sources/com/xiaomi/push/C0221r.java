package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* renamed from: com.xiaomi.push.r  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0221r {
    private a BuiltInFictitiousFunctionClassFactory;
    Handler KClassImpl$Data$declaredNonStaticMembers$2;
    private volatile b MyBillsEntityDataFactory;
    private volatile boolean PlaceComponentResult;
    private int getAuthRequestContext;
    private final boolean moveToNextValue;

    /* renamed from: com.xiaomi.push.r$b */
    /* loaded from: classes8.dex */
    public static abstract class b {
        public void MyBillsEntityDataFactory() {
        }

        public abstract void PlaceComponentResult();
    }

    public C0221r() {
        this(false);
    }

    public C0221r(boolean z) {
        this(z, 0);
    }

    public C0221r(boolean z, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.PlaceComponentResult = false;
        this.getAuthRequestContext = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new s(this, Looper.getMainLooper());
        this.moveToNextValue = z;
        this.getAuthRequestContext = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.r$a */
    /* loaded from: classes8.dex */
    public class a extends Thread {
        final LinkedBlockingQueue<b> BuiltInFictitiousFunctionClassFactory;

        public a() {
            super("PackageProcessor");
            this.BuiltInFictitiousFunctionClassFactory = new LinkedBlockingQueue<>();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = C0221r.this.getAuthRequestContext > 0 ? C0221r.this.getAuthRequestContext : LongCompanionObject.MAX_VALUE;
            while (!C0221r.this.PlaceComponentResult) {
                try {
                    b poll = this.BuiltInFictitiousFunctionClassFactory.poll(j, TimeUnit.SECONDS);
                    C0221r.this.MyBillsEntityDataFactory = poll;
                    if (poll != null) {
                        try {
                            C0221r.this.KClassImpl$Data$declaredNonStaticMembers$2.sendMessage(C0221r.this.KClassImpl$Data$declaredNonStaticMembers$2.obtainMessage(0, poll));
                        } catch (Exception e) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                        }
                        poll.PlaceComponentResult();
                        try {
                            C0221r.this.KClassImpl$Data$declaredNonStaticMembers$2.sendMessage(C0221r.this.KClassImpl$Data$declaredNonStaticMembers$2.obtainMessage(1, poll));
                        } catch (Exception e2) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
                        }
                    } else if (C0221r.this.getAuthRequestContext > 0) {
                        C0221r.BuiltInFictitiousFunctionClassFactory(C0221r.this);
                    }
                } catch (InterruptedException e3) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e3);
                }
            }
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(C0221r c0221r) {
        synchronized (c0221r) {
            c0221r.BuiltInFictitiousFunctionClassFactory = null;
            c0221r.PlaceComponentResult = true;
        }
    }

    public final void getAuthRequestContext(b bVar) {
        synchronized (this) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                a aVar = new a();
                this.BuiltInFictitiousFunctionClassFactory = aVar;
                aVar.setDaemon(this.moveToNextValue);
                this.PlaceComponentResult = false;
                this.BuiltInFictitiousFunctionClassFactory.start();
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.add(bVar);
            } catch (Exception unused) {
            }
        }
    }
}
