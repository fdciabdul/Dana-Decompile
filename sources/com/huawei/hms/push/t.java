package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class t extends Handler {
    public WeakReference<a> getAuthRequestContext;

    /* loaded from: classes8.dex */
    public interface a {
        void BuiltInFictitiousFunctionClassFactory(Message message);
    }

    public t(a aVar) {
        this.getAuthRequestContext = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.getAuthRequestContext.get();
        if (aVar != null) {
            aVar.BuiltInFictitiousFunctionClassFactory(message);
        }
    }
}
