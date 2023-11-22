package fsimpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: fsimpl.ev  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0351ev {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f7978a = Executors.newFixedThreadPool(3, new ThreadFactoryC0352ew());

    public static void a(Runnable runnable) {
        f7978a.execute(runnable);
    }
}
