package com.alipay.iap.android.f2fpay.common;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.a.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class F2FPayCallbacks<T> {
    protected final CopyOnWriteArrayList<T> mCallbacks = new CopyOnWriteArrayList<>();

    /* loaded from: classes3.dex */
    public interface Invoker<T> {
        void invoke(T t);
    }

    public IF2FPayCallbackHolder addCallback(final T t) {
        synchronized (this.mCallbacks) {
            Iterator<T> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                if (it.next() == t) {
                    return null;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("addCallback with callback=");
            sb.append(t);
            LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
            this.mCallbacks.add(t);
            return new IF2FPayCallbackHolder() { // from class: com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alipay.iap.android.f2fpay.common.IF2FPayCallbackHolder
                public void removeSelf() {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("removeSelf with callback=");
                    sb2.append(t);
                    LoggerWrapper.d(F2FPayConstants.TAG, sb2.toString());
                    F2FPayCallbacks.this.removeCallback(t);
                }
            };
        }
    }

    public void callback(Invoker<T> invoker) {
        synchronized (this.mCallbacks) {
            StringBuilder sb = new StringBuilder();
            sb.append("callback start with invoker=");
            sb.append(invoker);
            LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
            Iterator<T> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                invoker.invoke(it.next());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("callback end with invoker=");
            sb2.append(invoker);
            LoggerWrapper.d(F2FPayConstants.TAG, sb2.toString());
        }
    }

    public void clear() {
        synchronized (this.mCallbacks) {
            LoggerWrapper.d(F2FPayConstants.TAG, "[F2FPayCallbacks] clear");
            this.mCallbacks.clear();
        }
    }

    public void postMainCallback(final Invoker<T> invoker) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("postMainCallback with invoker=");
            sb.append(invoker);
            LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
            a.a().a(new Runnable() { // from class: com.alipay.iap.android.f2fpay.common.F2FPayCallbacks.2
                @Override // java.lang.Runnable
                public void run() {
                    F2FPayCallbacks.this.callback(invoker);
                }
            });
        }
    }

    public void removeCallback(T t) {
        synchronized (this.mCallbacks) {
            StringBuilder sb = new StringBuilder();
            sb.append("removeCallback start with callback=");
            sb.append(t);
            LoggerWrapper.d(F2FPayConstants.TAG, sb.toString());
            this.mCallbacks.remove(t);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("removeCallback end with callback=");
            sb2.append(t);
            LoggerWrapper.d(F2FPayConstants.TAG, sb2.toString());
        }
    }
}
