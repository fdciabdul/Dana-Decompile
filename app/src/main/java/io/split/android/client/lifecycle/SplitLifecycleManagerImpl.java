package io.split.android.client.lifecycle;

import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.ProcessLifecycleOwner;
import io.split.android.client.service.synchronizer.ThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SplitLifecycleManagerImpl implements DefaultLifecycleObserver, SplitLifecycleManager {
    private final List<WeakReference<SplitLifecycleAware>> mComponents = new ArrayList();

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.getAuthRequestContext();
    }

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.PlaceComponentResult();
    }

    @Override // androidx.view.FullLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.scheduleImpl();
    }

    public SplitLifecycleManagerImpl() {
        ThreadUtils.runInMainThread(new Runnable() { // from class: io.split.android.client.lifecycle.SplitLifecycleManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().BuiltInFictitiousFunctionClassFactory(SplitLifecycleManagerImpl.this);
            }
        });
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleManager
    public void register(SplitLifecycleAware splitLifecycleAware) {
        this.mComponents.add(new WeakReference<>(splitLifecycleAware));
    }

    @Override // androidx.view.FullLifecycleObserver
    public void onPause(LifecycleOwner lifecycleOwner) {
        changeRunningStatus(false);
    }

    @Override // androidx.view.FullLifecycleObserver
    public void onResume(LifecycleOwner lifecycleOwner) {
        changeRunningStatus(true);
    }

    private void changeRunningStatus(boolean z) {
        SplitLifecycleAware splitLifecycleAware;
        for (WeakReference<SplitLifecycleAware> weakReference : this.mComponents) {
            if (weakReference != null && (splitLifecycleAware = weakReference.get()) != null) {
                if (z) {
                    splitLifecycleAware.resume();
                } else {
                    splitLifecycleAware.pause();
                }
            }
        }
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleManager
    public void destroy() {
        ThreadUtils.runInMainThread(new Runnable() { // from class: io.split.android.client.lifecycle.SplitLifecycleManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.PlaceComponentResult().getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(SplitLifecycleManagerImpl.this);
            }
        });
    }
}
