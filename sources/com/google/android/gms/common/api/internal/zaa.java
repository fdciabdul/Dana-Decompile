package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
final class zaa extends LifecycleCallback {
    private List<Runnable> zaa;

    private zaa(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.zaa = new ArrayList();
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zaa zaa(Activity activity) {
        zaa zaaVar;
        synchronized (activity) {
            LifecycleFragment fragment = getFragment(activity);
            zaaVar = (zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
            if (zaaVar == null) {
                zaaVar = new zaa(fragment);
            }
        }
        return zaaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zac(Runnable runnable) {
        synchronized (this) {
            this.zaa.add(runnable);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        List<Runnable> list;
        synchronized (this) {
            list = this.zaa;
            this.zaa = new ArrayList();
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }
}
