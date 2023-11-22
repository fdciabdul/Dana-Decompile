package com.appsflyer.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public abstract class bt extends Observable {
    private long AFInAppEventType;
    public final String valueOf;
    final Runnable values;
    public final Map<String, Object> AFKeystoreWrapper = new HashMap();
    public e AFInAppEventParameterName = e.NOT_STARTED;

    /* loaded from: classes.dex */
    public enum e {
        NOT_STARTED,
        STARTED,
        FINISHED
    }

    public abstract void AFInAppEventParameterName(Context context);

    public bt(String str, Runnable runnable) {
        this.values = runnable;
        this.valueOf = str;
    }

    public final void AFInAppEventParameterName() {
        this.AFInAppEventType = System.currentTimeMillis();
        this.AFInAppEventParameterName = e.STARTED;
        addObserver(new Observer() { // from class: com.appsflyer.internal.bt.1
            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                bt.this.values.run();
            }
        });
    }

    public final void AFKeystoreWrapper() {
        this.AFKeystoreWrapper.put("source", this.valueOf);
        this.AFKeystoreWrapper.putAll(new bu());
        this.AFKeystoreWrapper.put("latency", Long.valueOf(System.currentTimeMillis() - this.AFInAppEventType));
        this.AFInAppEventParameterName = e.FINISHED;
        setChanged();
        notifyObservers();
    }
}
