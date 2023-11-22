package fsimpl;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.ds  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ThreadFactoryC0321ds implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0320dr f7945a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryC0321ds(C0320dr c0320dr) {
        this.f7945a = c0320dr;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new eN(runnable, "fs-uploader");
    }
}
