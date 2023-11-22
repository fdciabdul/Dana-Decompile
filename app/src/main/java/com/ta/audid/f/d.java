package com.ta.audid.f;

import android.content.Context;
import com.ta.audid.g.j;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f7679a;

    /* renamed from: a  reason: collision with other field name */
    private ScheduledFuture f49a;
    private Context mContext;

    private d(Context context) {
        this.mContext = context;
    }

    public static d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f7679a == null) {
                f7679a = new d(context);
            }
            dVar = f7679a;
        }
        return dVar;
    }

    public void start() {
        synchronized (this) {
            ScheduledFuture scheduledFuture = this.f49a;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            e();
        }
    }

    public void stop() {
        synchronized (this) {
            ScheduledFuture scheduledFuture = this.f49a;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }
    }

    private void e() {
        this.f49a = j.a().a(this.f49a, new g(this.mContext), 60000L, 180000L);
    }
}
