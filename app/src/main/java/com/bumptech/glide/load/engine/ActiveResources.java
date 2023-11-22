package com.bumptech.glide.load.engine;

import android.os.Process;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class ActiveResources {
    public static final byte[] lookAheadTest = {113, 46, 115, -60, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int scheduleImpl = WSContextConstant.HANDSHAKE_SEND_SIZE;
    EngineResource.ResourceListener BuiltInFictitiousFunctionClassFactory;
    final Map<Key, ResourceWeakReference> KClassImpl$Data$declaredNonStaticMembers$2;
    final ReferenceQueue<EngineResource<?>> MyBillsEntityDataFactory;
    private final Executor NetworkUserEntityData$$ExternalSyntheticLambda0;
    volatile DequeuedResourceCallback PlaceComponentResult;
    volatile boolean getAuthRequestContext;
    private final boolean getErrorConfigVersion;

    /* loaded from: classes3.dex */
    interface DequeuedResourceCallback {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = 106 - r6
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 + 4
            byte[] r0 = com.bumptech.glide.load.engine.ActiveResources.lookAheadTest
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            int r8 = r8 + 1
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r7 = r7 + r6
            int r6 = r7 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.a(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bumptech.glide.load.engine.ActiveResources.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    private ActiveResources(boolean z, Executor executor) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
        this.MyBillsEntityDataFactory = new ReferenceQueue<>();
        this.getErrorConfigVersion = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = executor;
        executor.execute(new Runnable() { // from class: com.bumptech.glide.load.engine.ActiveResources.2
            @Override // java.lang.Runnable
            public void run() {
                ActiveResources activeResources = ActiveResources.this;
                while (!activeResources.getAuthRequestContext) {
                    try {
                        try {
                            activeResources.PlaceComponentResult((ResourceWeakReference) activeResources.MyBillsEntityDataFactory.remove());
                            DequeuedResourceCallback dequeuedResourceCallback = activeResources.PlaceComponentResult;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (InterruptedException unused) {
                        byte b = (byte) (ActiveResources.lookAheadTest[15] - 1);
                        Object[] objArr = new Object[1];
                        ActiveResources.a(b, b, ActiveResources.lookAheadTest[22], objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b2 = ActiveResources.lookAheadTest[15];
                        byte b3 = b2;
                        Object[] objArr2 = new Object[1];
                        ActiveResources.a(b2, b3, (byte) (-b3), objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(Key key, EngineResource<?> engineResource) {
        synchronized (this) {
            ResourceWeakReference put = this.KClassImpl$Data$declaredNonStaticMembers$2.put(key, new ResourceWeakReference(key, engineResource, this.MyBillsEntityDataFactory, this.getErrorConfigVersion));
            if (put != null) {
                put.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                put.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EngineResource<?> MyBillsEntityDataFactory(Key key) {
        synchronized (this) {
            ResourceWeakReference resourceWeakReference = this.KClassImpl$Data$declaredNonStaticMembers$2.get(key);
            if (resourceWeakReference == null) {
                return null;
            }
            EngineResource<?> engineResource = resourceWeakReference.get();
            if (engineResource == null) {
                PlaceComponentResult(resourceWeakReference);
            }
            return engineResource;
        }
    }

    final void PlaceComponentResult(ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.remove(resourceWeakReference.PlaceComponentResult);
            if (resourceWeakReference.BuiltInFictitiousFunctionClassFactory) {
                if (resourceWeakReference.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(resourceWeakReference.PlaceComponentResult, new EngineResource<>(resourceWeakReference.KClassImpl$Data$declaredNonStaticMembers$2, true, false, resourceWeakReference.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean BuiltInFictitiousFunctionClassFactory;
        Resource<?> KClassImpl$Data$declaredNonStaticMembers$2;
        final Key PlaceComponentResult;

        ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.PlaceComponentResult = (Key) Preconditions.PlaceComponentResult(key);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (engineResource.BuiltInFictitiousFunctionClassFactory() && z) ? (Resource) Preconditions.PlaceComponentResult(engineResource.PlaceComponentResult) : null;
            this.BuiltInFictitiousFunctionClassFactory = engineResource.BuiltInFictitiousFunctionClassFactory();
        }
    }
}
