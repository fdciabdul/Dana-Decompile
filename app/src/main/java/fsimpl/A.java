package fsimpl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class A implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final RustInterface f7798a;
    private final AbstractC0258bi b;
    private final AtomicInteger c = new AtomicInteger();
    private final AtomicBoolean d = new AtomicBoolean();
    private final AtomicReference e = new AtomicReference(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(bG bGVar, RustInterface rustInterface, aA aAVar) {
        this.f7798a = rustInterface;
        this.b = AbstractC0258bi.a(bGVar, rustInterface, aAVar);
    }

    private String a(Activity activity) {
        return activity != null ? activity.getClass().getName() : "unknown";
    }

    private String b() {
        WeakReference weakReference = (WeakReference) this.e.get();
        return a(weakReference == null ? null : (Activity) weakReference.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Activity activity;
        WeakReference weakReference = (WeakReference) this.e.get();
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null) {
            return;
        }
        activity.finishAffinity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String[] strArr) {
        String b = b();
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onCrash: ");
        sb.append(b);
        Log.d(sb.toString());
        this.f7798a.a(b, strArr);
    }

    public AbstractC0258bi getFragmentSupport() {
        return this.b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivityCreated: ");
        sb.append(a(activity));
        Log.d(sb.toString());
        bC.a(activity.getResources());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivityDestroyed: ");
        sb.append(a(activity));
        Log.d(sb.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivityPaused: ");
        sb.append(a(activity));
        Log.d(sb.toString());
        WeakReference weakReference = (WeakReference) this.e.get();
        Activity activity2 = weakReference == null ? null : (Activity) weakReference.get();
        if (activity2 == activity || activity2 == null) {
            this.e.compareAndSet(weakReference, null);
        }
        this.f7798a.a(a(activity), (short) 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivityResumed: ");
        sb.append(a(activity));
        Log.d(sb.toString());
        this.e.set(new WeakReference(activity));
        if (this.d.compareAndSet(true, false)) {
            this.f7798a.c();
        }
        this.f7798a.a(a(activity), (short) 0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivitySaveInstanceState: ");
        sb.append(a(activity));
        Log.d(sb.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int incrementAndGet = this.c.incrementAndGet();
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivityStarted: ");
        sb.append(a(activity));
        Log.d(sb.toString());
        if (incrementAndGet == 1) {
            this.d.set(true);
        }
        this.b.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("[activity] onActivityStopped: ");
        sb.append(a(activity));
        Log.d(sb.toString());
        this.f7798a.a(a(activity), (short) 2);
        fb.a(new B(this), 500L);
        this.b.b(activity);
    }
}
