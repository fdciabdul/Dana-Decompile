package fsimpl;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class eM implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final CountDownLatch f7957a = new CountDownLatch(1);
    final Runnable b;
    Throwable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eM(Runnable runnable) {
        this.b = runnable;
    }

    public final void a() {
        try {
            this.f7957a.await();
        } catch (InterruptedException e) {
            if (this.c != null) {
                this.c = e;
            }
        }
        Throwable th = this.c;
        if (th != null) {
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(this.c);
            }
            throw ((RuntimeException) th);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.run();
        } finally {
            try {
            } finally {
            }
        }
    }
}
