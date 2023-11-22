package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c {
    public static final c b = new c();
    public static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List<Activity> f7463a = new ArrayList(1);

    public void a(Activity activity) {
        synchronized (c) {
            for (Activity activity2 : this.f7463a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f7463a.add(activity);
        }
    }

    public void b(Activity activity) {
        synchronized (c) {
            this.f7463a.remove(activity);
        }
    }
}
