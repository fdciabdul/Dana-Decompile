package fsimpl;

import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fsimpl.aq  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0239aq {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference f7859a = new AtomicReference();
    private static final WeakHashMap b = new WeakHashMap();

    public static H a() {
        return (H) f7859a.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021 A[Catch: all -> 0x0059, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:11:0x0013, B:17:0x0021, B:18:0x0026, B:20:0x002f, B:22:0x003d, B:23:0x0043, B:21:0x003a), top: B:29:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002f A[Catch: all -> 0x0059, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:11:0x0013, B:17:0x0021, B:18:0x0026, B:20:0x002f, B:22:0x003d, B:23:0x0043, B:21:0x003a), top: B:29:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: all -> 0x0059, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:11:0x0013, B:17:0x0021, B:18:0x0026, B:20:0x002f, B:22:0x003d, B:23:0x0043, B:21:0x003a), top: B:29:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.view.Window r4) {
        /*
            java.util.WeakHashMap r0 = fsimpl.C0239aq.b
            monitor-enter(r0)
            android.view.Window$Callback r1 = r4.getCallback()     // Catch: java.lang.Throwable -> L59
            boolean r2 = r1 instanceof fsimpl.WindowCallbackC0375y     // Catch: java.lang.Throwable -> L59
            if (r2 != 0) goto L12
            boolean r2 = r1 instanceof fsimpl.ActivityC0374x     // Catch: java.lang.Throwable -> L59
            if (r2 == 0) goto L10
            goto L12
        L10:
            r2 = 0
            goto L13
        L12:
            r2 = 1
        L13:
            java.util.WeakHashMap r3 = fsimpl.C0239aq.b     // Catch: java.lang.Throwable -> L59
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L1f
            if (r2 == 0) goto L1f
            monitor-exit(r0)
            return
        L1f:
            if (r2 != 0) goto L26
            java.lang.String r2 = "Window.Callback for windows has changed - re-adding FullStory callbacks on window"
            com.fullstory.util.Log.w(r2)     // Catch: java.lang.Throwable -> L59
        L26:
            fsimpl.y r2 = new fsimpl.y     // Catch: java.lang.Throwable -> L59
            r2.<init>(r4, r1)     // Catch: java.lang.Throwable -> L59
            boolean r3 = r1 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L3a
            fsimpl.x r3 = new fsimpl.x     // Catch: java.lang.Throwable -> L59
            android.app.Activity r1 = (android.app.Activity) r1     // Catch: java.lang.Throwable -> L59
            r3.<init>(r2, r1)     // Catch: java.lang.Throwable -> L59
            r4.setCallback(r3)     // Catch: java.lang.Throwable -> L59
            goto L3d
        L3a:
            r4.setCallback(r2)     // Catch: java.lang.Throwable -> L59
        L3d:
            java.util.WeakHashMap r1 = fsimpl.C0239aq.b     // Catch: java.lang.Throwable -> L59
            r2 = 0
            r1.put(r4, r2)     // Catch: java.lang.Throwable -> L59
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Found a new window: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            com.fullstory.util.Log.w(r4)
            return
        L59:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0239aq.a(android.view.Window):void");
    }

    public static void a(H h) {
        f7859a.set(h);
    }
}
