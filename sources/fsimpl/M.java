package fsimpl;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class M implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Application f7808a;
    final /* synthetic */ bH b;
    final /* synthetic */ K c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(K k, Application application, bH bHVar) {
        this.c = k;
        this.f7808a = application;
        this.b = bHVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        A a2;
        A a3;
        A a4;
        A a5;
        this.f7808a.unregisterActivityLifecycleCallbacks(this.b);
        Application application = this.f7808a;
        a2 = this.c.f;
        application.registerActivityLifecycleCallbacks(a2);
        for (Activity activity : this.b.getCreated()) {
            a5 = this.c.f;
            a5.onActivityCreated(activity, null);
        }
        for (Activity activity2 : this.b.getStarted()) {
            a4 = this.c.f;
            a4.onActivityStarted(activity2);
        }
        for (Activity activity3 : this.b.getResumed()) {
            a3 = this.c.f;
            a3.onActivityResumed(activity3);
        }
    }
}
