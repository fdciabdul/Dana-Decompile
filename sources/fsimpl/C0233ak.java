package fsimpl;

import java.lang.Thread;

/* renamed from: fsimpl.ak  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0233ak implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7854a;
    private final K b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0233ak(K k) {
        this.b = k;
        a(Thread.getDefaultUncaughtExceptionHandler());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Thread.UncaughtExceptionHandler a() {
        return this.f7854a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f7854a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            this.b.a(thread, th);
        } finally {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7854a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }
}
