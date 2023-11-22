package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public abstract class bt {
    private static final AtomicInteger PrepareContext = new AtomicInteger(0);
    public static boolean getAuthRequestContext;
    protected ce BuiltInFictitiousFunctionClassFactory;
    protected bu PlaceComponentResult;
    protected XMPushService moveToNextValue;
    protected int MyBillsEntityDataFactory = 0;
    protected long KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    protected volatile long DatabaseTableConfigUtil = 0;
    protected volatile long NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    public LinkedList<Pair<Integer, Long>> NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedList<>();
    public final Collection<bv> lookAheadTest = new CopyOnWriteArrayList();
    protected final Map<bx, a> scheduleImpl = new ConcurrentHashMap();
    protected final Map<bx, a> initRecordTimeStamp = new ConcurrentHashMap();
    protected String getErrorConfigVersion = "";
    protected String GetContactSyncConfig = "";
    private int isLayoutRequested = 2;
    protected final int NetworkUserEntityData$$ExternalSyntheticLambda1 = PrepareContext.getAndIncrement();
    long newProxyInstance = 0;
    protected long NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;

    /* loaded from: classes8.dex */
    public static class a {
        cf BuiltInFictitiousFunctionClassFactory;
        bx getAuthRequestContext;

        public a(bx bxVar, cf cfVar) {
            this.getAuthRequestContext = bxVar;
            this.BuiltInFictitiousFunctionClassFactory = cfVar;
        }
    }

    static {
        getAuthRequestContext = false;
        try {
            getAuthRequestContext = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        by.BuiltInFictitiousFunctionClassFactory();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(long j) {
        boolean z;
        synchronized (this) {
            z = this.newProxyInstance >= j;
        }
        return z;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(bx bxVar, cf cfVar) {
        if (bxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.initRecordTimeStamp.put(bxVar, new a(bxVar, cfVar));
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(cj cjVar);

    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return false;
    }

    public final bu MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    public abstract void MyBillsEntityDataFactory(az.b bVar);

    public final void MyBillsEntityDataFactory(String str) {
        synchronized (this) {
            if (this.isLayoutRequested == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("setChallenge hash = ");
                sb.append(ac.BuiltInFictitiousFunctionClassFactory(str).substring(0, 8));
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                this.getErrorConfigVersion = str;
                KClassImpl$Data$declaredNonStaticMembers$2(1, 0, null);
            } else {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("ignore setChallenge because connection was disconnected");
            }
        }
    }

    public abstract void MyBillsEntityDataFactory(boolean z);

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.isLayoutRequested == 0;
    }

    public abstract void PlaceComponentResult(bi biVar);

    public final void PlaceComponentResult(bx bxVar, cf cfVar) {
        if (bxVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.scheduleImpl.put(bxVar, new a(bxVar, cfVar));
    }

    public abstract void PlaceComponentResult(String str, String str2);

    public final int getAuthRequestContext() {
        return this.isLayoutRequested;
    }

    public abstract void getAuthRequestContext(int i, Exception exc);

    public abstract void getAuthRequestContext(bi[] biVarArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<bx, a> getErrorConfigVersion() {
        return this.scheduleImpl;
    }

    public final boolean moveToNextValue() {
        return this.isLayoutRequested == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bt(XMPushService xMPushService, bu buVar) {
        String str;
        Class<?> cls = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = buVar;
        this.moveToNextValue = xMPushService;
        if (buVar.MyBillsEntityDataFactory() && this.BuiltInFictitiousFunctionClassFactory == null) {
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception unused2) {
                }
            }
            if (cls == null) {
                this.BuiltInFictitiousFunctionClassFactory = new br(this);
                return;
            }
            try {
                this.BuiltInFictitiousFunctionClassFactory = (ce) cls.getConstructor(bt.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e);
            }
        }
    }

    public String lookAheadTest() {
        bu buVar = this.PlaceComponentResult;
        if (buVar.MyBillsEntityDataFactory == null) {
            buVar.MyBillsEntityDataFactory = bu.PlaceComponentResult();
        }
        return buVar.MyBillsEntityDataFactory;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, Exception exc) {
        int i3 = this.isLayoutRequested;
        if (i != i3) {
            Object[] objArr = new Object[3];
            objArr[0] = i3 == 1 ? "connected" : i3 == 0 ? "connecting" : i3 == 2 ? "disconnected" : "unknown";
            objArr[1] = i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
            objArr[2] = com.xiaomi.push.service.bd.MyBillsEntityDataFactory(i2);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("update the connection status. %1$s -> %2$s : %3$s ", objArr));
        }
        if (y.MyBillsEntityDataFactory(this.moveToNextValue)) {
            synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                if (i == 1) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
                } else {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() > 6) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(0);
                    }
                }
            }
        }
        if (i == 1) {
            this.moveToNextValue.a(10);
            if (this.isLayoutRequested != 0) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("try set connected while not connecting.");
            }
            this.isLayoutRequested = i;
            Iterator<bv> it = this.lookAheadTest.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        } else if (i == 0) {
            if (this.isLayoutRequested != 2) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("try set connecting while not disconnected.");
            }
            this.isLayoutRequested = i;
            Iterator<bv> it2 = this.lookAheadTest.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
        } else if (i == 2) {
            this.moveToNextValue.a(10);
            int i4 = this.isLayoutRequested;
            if (i4 == 0) {
                Iterator<bv> it3 = this.lookAheadTest.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                Iterator<bv> it4 = this.lookAheadTest.iterator();
                while (it4.hasNext()) {
                    it4.next().a(this, i2, exc);
                }
            }
            this.isLayoutRequested = i;
        }
    }

    public final String scheduleImpl() {
        return this.PlaceComponentResult.scheduleImpl;
    }
}
