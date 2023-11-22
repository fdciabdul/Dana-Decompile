package com.alipay.imobile.network.quake.util;

import android.os.SystemClock;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f7082a = new ArrayList();
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f7083a;
        public final long b;
        public final long c;

        public a(String str, long j, long j2) {
            this.f7083a = str;
            this.b = j;
            this.c = j2;
        }
    }

    public void a(String str, long j) {
        synchronized (this) {
            if (!this.b) {
                this.f7082a.add(new a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }
    }

    protected void finalize() throws Throwable {
        if (this.b) {
            return;
        }
        a("Request on the loose");
        LoggerWrapper.i(Quake.TAG, "Marker log finalized without finish() - uncaught exit point for request");
    }

    public void a(String str) {
        synchronized (this) {
            this.b = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f7082a.get(0).c;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(LoggerWrapper.buildMessage("(%-4d ms) %s", Long.valueOf(a2), str));
            stringBuffer.append("\n");
            for (a aVar : this.f7082a) {
                long j2 = aVar.c;
                stringBuffer.append(LoggerWrapper.buildMessage("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(aVar.b), aVar.f7083a));
                stringBuffer.append("\n");
                j = j2;
            }
            if (stringBuffer.length() > 0) {
                LoggerWrapper.i(Quake.TAG, stringBuffer.toString());
            }
        }
    }

    private long a() {
        if (this.f7082a.isEmpty()) {
            return 0L;
        }
        return this.f7082a.get(r2.size() - 1).c - this.f7082a.get(0).c;
    }
}
