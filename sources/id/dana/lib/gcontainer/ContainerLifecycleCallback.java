package id.dana.lib.gcontainer;

import androidx.view.Lifecycle;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;

/* loaded from: classes2.dex */
public interface ContainerLifecycleCallback {
    void onContainerActivityLifecycleEvent(Lifecycle.Event event, GriverBaseActivity griverBaseActivity);
}
