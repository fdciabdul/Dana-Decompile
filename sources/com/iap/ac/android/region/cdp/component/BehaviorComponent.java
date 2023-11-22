package com.iap.ac.android.region.cdp.component;

import com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback;
import com.iap.ac.android.region.cdp.model.CdpUploadFatigueEvent;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface BehaviorComponent {
    void addBehavior(String str, String str2, String str3, boolean z, AddFatigueActionCallback addFatigueActionCallback);

    void updateLastUploadCount(Collection<CdpUploadFatigueEvent> collection);
}
