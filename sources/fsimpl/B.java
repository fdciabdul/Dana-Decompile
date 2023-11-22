package fsimpl;

import com.fullstory.rust.RustInterface;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f7799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(A a2) {
        this.f7799a = a2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        RustInterface rustInterface;
        atomicInteger = this.f7799a.c;
        if (atomicInteger.decrementAndGet() == 0) {
            rustInterface = this.f7799a.f7798a;
            rustInterface.a(0);
        }
    }
}
