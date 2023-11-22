package com.alibaba.ariver.kernel.common.runnable;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class OneShotRunnable implements Runnable {
    static boolean sUseWeakRef;

    /* renamed from: a  reason: collision with root package name */
    private String f6155a;
    private WeakReference<Runnable> b;
    private Runnable c;
    private AtomicBoolean d;

    public OneShotRunnable(Runnable runnable) {
        this("EMPTY", runnable);
    }

    public OneShotRunnable(String str, Runnable runnable) {
        this.d = new AtomicBoolean(false);
        this.f6155a = str;
        if (sUseWeakRef) {
            this.b = new WeakReference<>(runnable);
        } else {
            this.c = runnable;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.d.getAndSet(true)) {
            if (sUseWeakRef) {
                WeakReference<Runnable> weakReference = this.b;
                if (weakReference != null) {
                    Runnable runnable = weakReference.get();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("OneShotRunnable [");
                        sb.append(this.f6155a);
                        sb.append("] already recycled!");
                        RVLogger.d("AriverKernel:OneShotRunnable", sb.toString());
                    }
                    this.b = null;
                    return;
                }
                return;
            }
            Runnable runnable2 = this.c;
            if (runnable2 != null) {
                runnable2.run();
                this.c = null;
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("OneShotRunnable [");
        sb2.append(this.f6155a);
        sb2.append("] already executed!");
        RVLogger.d("AriverKernel:OneShotRunnable", sb2.toString());
    }
}
