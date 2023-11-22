package com.iap.ac.android.common.container.event;

import com.iap.ac.android.common.a.a;
import com.iap.ac.android.common.container.IContainerPresenter;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ContainerEvent {
    public String action;
    public IContainerPresenter containerPresenter;
    public Map<String, Object> extras;
    public JSONObject params;

    public ContainerEvent(String str, IContainerPresenter iContainerPresenter) {
        this.action = str;
        this.containerPresenter = iContainerPresenter;
    }

    public String toString() {
        StringBuilder a2 = a.a("ContainerEvent{action='");
        a2.append(this.action);
        a2.append('\'');
        a2.append(", params=");
        a2.append(this.params);
        a2.append(", extras=");
        a2.append(this.extras);
        a2.append(", containerPresenter=");
        a2.append(this.containerPresenter);
        a2.append('}');
        return a2.toString();
    }
}
