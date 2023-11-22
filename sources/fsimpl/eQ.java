package fsimpl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
class eQ implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ eO f7959a;
    private Throwable b;
    private final CountDownLatch c;
    private long d;
    private long e;
    private int f;
    private int g;
    private AtomicBoolean h;

    private eQ(eO eOVar) {
        this.f7959a = eOVar;
        this.c = new CountDownLatch(1);
        this.d = -1L;
        this.e = -1L;
        this.f = 0;
        this.g = 0;
        this.h = new AtomicBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            this.c.await();
        } catch (InterruptedException e) {
            this.h.set(false);
            if (this.b == null) {
                this.b = e;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        long nanoTime = System.nanoTime();
        if (this.d == -1) {
            this.d = nanoTime;
        }
        this.g++;
        while (this.h.get() && (runnable = (Runnable) eO.a(this.f7959a).poll()) != null) {
            try {
                this.f++;
                runnable.run();
                if (eO.b(this.f7959a) && System.nanoTime() - nanoTime > eO.c(this.f7959a) && this.h.get() && eO.a(this.f7959a).peek() != null) {
                    fb.a(this);
                    return;
                }
            } catch (Throwable th) {
                this.b = th;
            }
        }
        this.e = System.nanoTime();
        this.c.countDown();
    }
}
