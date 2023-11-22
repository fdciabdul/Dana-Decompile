package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.longlinkservice.ConnectionEvent;
import java.util.Observable;

/* loaded from: classes3.dex */
public final class d extends Observable {
    public final void a(ConnectionEvent connectionEvent) {
        try {
            setChanged();
            super.notifyObservers(connectionEvent);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("[notifyObservers] Exception: ");
            sb.append(th.toString());
            com.alipay.mobile.rome.syncsdk.util.c.a("ConnectionStateObservable", sb.toString(), th);
        }
    }
}
