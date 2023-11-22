package fsimpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.dm  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class RunnableC0316dm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0315dl f7939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0316dm(C0315dl c0315dl) {
        this.f7939a = c0315dl;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7939a.d();
        } catch (InterruptedException unused) {
        }
    }
}
