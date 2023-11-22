package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final boolean PlaceComponentResult = Log.isLoggable("Request", 2);
    private volatile Engine BuiltInFictitiousFunctionClassFactory;
    private final int DatabaseTableConfigUtil;
    private final StateVerifier FragmentBottomSheetPaymentSettingBinding;
    private Engine.LoadStatus GetContactSyncConfig;
    private final TransitionFactory<? super R> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Object NetworkUserEntityData$$ExternalSyntheticLambda2;
    private long NetworkUserEntityData$$ExternalSyntheticLambda3;
    private Resource<R> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private RuntimeException NetworkUserEntityData$$ExternalSyntheticLambda5;
    private Status NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final RequestCoordinator NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Priority NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final List<RequestListener<R>> PrepareContext;
    private final Class<R> SubSequence;
    private final Executor getAuthRequestContext;
    private int getCallingPid;
    private final GlideContext getErrorConfigVersion;
    private final Target<R> getSupportButtonTintMode;
    private final int initRecordTimeStamp;
    private final BaseRequestOptions<?> isLayoutRequested;
    private Drawable lookAheadTest;
    private int moveToNextValue;
    private final Object newProxyInstance;
    private final String readMicros;
    private Drawable scheduleImpl;
    private final RequestListener<R> whenAvailable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> getAuthRequestContext(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority, Target<R> target, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.readMicros = PlaceComponentResult ? String.valueOf(super.hashCode()) : null;
        this.FragmentBottomSheetPaymentSettingBinding = StateVerifier.KClassImpl$Data$declaredNonStaticMembers$2();
        this.newProxyInstance = obj;
        this.MyBillsEntityDataFactory = context;
        this.getErrorConfigVersion = glideContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obj2;
        this.SubSequence = cls;
        this.isLayoutRequested = baseRequestOptions;
        this.DatabaseTableConfigUtil = i;
        this.initRecordTimeStamp = i2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = priority;
        this.getSupportButtonTintMode = target;
        this.whenAvailable = requestListener;
        this.PrepareContext = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = requestCoordinator;
        this.BuiltInFictitiousFunctionClassFactory = engine;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transitionFactory;
        this.getAuthRequestContext = executor;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Status.PENDING;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda5 == null && glideContext.lookAheadTest.MyBillsEntityDataFactory(GlideBuilder.LogRequestOrigins.class)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void PlaceComponentResult() {
        synchronized (this.newProxyInstance) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.FragmentBottomSheetPaymentSettingBinding.PlaceComponentResult();
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = LogTime.PlaceComponentResult();
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                    if (Util.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil, this.initRecordTimeStamp)) {
                        this.getCallingPid = this.DatabaseTableConfigUtil;
                        this.moveToNextValue = this.initRecordTimeStamp;
                    }
                    BuiltInFictitiousFunctionClassFactory(new GlideException("Received null model"), DatabaseTableConfigUtil() == null ? 5 : 3);
                    return;
                } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.RUNNING) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                } else {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.COMPLETE) {
                        KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda4, DataSource.MEMORY_CACHE);
                        return;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Status.WAITING_FOR_SIZE;
                    if (Util.KClassImpl$Data$declaredNonStaticMembers$2(this.DatabaseTableConfigUtil, this.initRecordTimeStamp)) {
                        BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil, this.initRecordTimeStamp);
                    } else {
                        this.getSupportButtonTintMode.getSize(this);
                    }
                    if ((this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.RUNNING || this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.WAITING_FOR_SIZE) && NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                        this.getSupportButtonTintMode.onLoadStarted(initRecordTimeStamp());
                    }
                    if (PlaceComponentResult) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("finished run method in ");
                        sb.append(LogTime.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
                        PlaceComponentResult(sb.toString());
                    }
                    return;
                }
            }
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.newProxyInstance) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.FragmentBottomSheetPaymentSettingBinding.PlaceComponentResult();
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.CLEARED) {
                    return;
                }
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    this.FragmentBottomSheetPaymentSettingBinding.PlaceComponentResult();
                    this.getSupportButtonTintMode.removeCallback(this);
                    Engine.LoadStatus loadStatus = this.GetContactSyncConfig;
                    Resource<R> resource = null;
                    if (loadStatus != null) {
                        synchronized (Engine.this) {
                            loadStatus.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(loadStatus.MyBillsEntityDataFactory);
                        }
                        this.GetContactSyncConfig = null;
                    }
                    Resource<R> resource2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                    if (resource2 != null) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
                        resource = resource2;
                    }
                    if (getErrorConfigVersion()) {
                        this.getSupportButtonTintMode.onLoadCleared(initRecordTimeStamp());
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Status.CLEARED;
                    if (resource != null) {
                        Engine.MyBillsEntityDataFactory((Resource<?>) resource);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
            }
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void lookAheadTest() {
        synchronized (this.newProxyInstance) {
            if (moveToNextValue()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean moveToNextValue() {
        boolean z;
        synchronized (this.newProxyInstance) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 != Status.RUNNING) {
                z = this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.WAITING_FOR_SIZE;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean scheduleImpl() {
        boolean z;
        synchronized (this.newProxyInstance) {
            z = this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this.newProxyInstance) {
            z = this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        synchronized (this.newProxyInstance) {
            z = this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.COMPLETE;
        }
        return z;
    }

    private Drawable initRecordTimeStamp() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            Drawable drawable = this.isLayoutRequested.lookAheadTest;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = drawable;
            if (drawable == null && this.isLayoutRequested.scheduleImpl > 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested.scheduleImpl);
            }
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    private Drawable DatabaseTableConfigUtil() {
        if (this.lookAheadTest == null) {
            Drawable drawable = this.isLayoutRequested.BuiltInFictitiousFunctionClassFactory;
            this.lookAheadTest = drawable;
            if (drawable == null && this.isLayoutRequested.getErrorConfigVersion > 0) {
                this.lookAheadTest = KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested.getErrorConfigVersion);
            }
        }
        return this.lookAheadTest;
    }

    private Drawable KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        Resources.Theme theme;
        if (this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
            theme = this.MyBillsEntityDataFactory.getTheme();
        } else {
            theme = this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        return DrawableDecoderCompat.PlaceComponentResult(this.getErrorConfigVersion, i, theme);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        Object obj;
        int i3 = i;
        this.FragmentBottomSheetPaymentSettingBinding.PlaceComponentResult();
        Object obj2 = this.newProxyInstance;
        synchronized (obj2) {
            try {
                boolean z = PlaceComponentResult;
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Got onSizeReady in ");
                    sb.append(LogTime.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
                    PlaceComponentResult(sb.toString());
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == Status.WAITING_FOR_SIZE) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Status.RUNNING;
                    float f = this.isLayoutRequested.initRecordTimeStamp;
                    if (i3 != Integer.MIN_VALUE) {
                        i3 = Math.round(i3 * f);
                    }
                    this.getCallingPid = i3;
                    this.moveToNextValue = i2 != Integer.MIN_VALUE ? Math.round(f * i2) : i2;
                    if (z) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("finished setup for calling load in ");
                        sb2.append(LogTime.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
                        PlaceComponentResult(sb2.toString());
                    }
                    obj = obj2;
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        this.GetContactSyncConfig = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getCallingPid, this.moveToNextValue, this.isLayoutRequested.moveToNextValue, this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2, this.isLayoutRequested.DatabaseTableConfigUtil, this.isLayoutRequested.PrepareContext(), this.isLayoutRequested.isLayoutRequested(), this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda0, this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda8(), this.isLayoutRequested.NetworkUserEntityData$$ExternalSyntheticLambda2(), this.isLayoutRequested.DatabaseTableConfigUtil(), this.isLayoutRequested.getErrorConfigVersion(), this, this.getAuthRequestContext);
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 != Status.RUNNING) {
                            this.GetContactSyncConfig = null;
                        }
                        if (z) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("finished onSizeReady in ");
                            sb3.append(LogTime.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
                            PlaceComponentResult(sb3.toString());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    private boolean GetContactSyncConfig() {
        RequestCoordinator requestCoordinator = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return requestCoordinator == null || requestCoordinator.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    private boolean getErrorConfigVersion() {
        RequestCoordinator requestCoordinator = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return requestCoordinator == null || requestCoordinator.MyBillsEntityDataFactory(this);
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RequestCoordinator requestCoordinator = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return requestCoordinator == null || requestCoordinator.BuiltInFictitiousFunctionClassFactory(this);
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        RequestCoordinator requestCoordinator = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return requestCoordinator == null || !requestCoordinator.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        if (r7 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        com.bumptech.glide.load.engine.Engine.MyBillsEntityDataFactory(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
    
        if (r7 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ae, code lost:
    
        com.bumptech.glide.load.engine.Engine.MyBillsEntityDataFactory(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(com.bumptech.glide.load.engine.Resource<?> r7, com.bumptech.glide.load.DataSource r8) {
        /*
            r6 = this;
            com.bumptech.glide.util.pool.StateVerifier r0 = r6.FragmentBottomSheetPaymentSettingBinding
            r0.PlaceComponentResult()
            r0 = 0
            java.lang.Object r1 = r6.newProxyInstance     // Catch: java.lang.Throwable -> Lbc
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lbc
            r6.GetContactSyncConfig = r0     // Catch: java.lang.Throwable -> Lb4
            r2 = 5
            if (r7 != 0) goto L30
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb4
            r8.<init>()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r3 = "Expected to receive a Resource<R> with an object of "
            r8.append(r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.Class<R> r3 = r6.SubSequence     // Catch: java.lang.Throwable -> Lb4
            r8.append(r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r3 = " inside, but instead got null."
            r8.append(r3)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lb4
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lb4
            r6.BuiltInFictitiousFunctionClassFactory(r7, r2)     // Catch: java.lang.Throwable -> Lb4
            monitor-exit(r1)
            return
        L30:
            java.lang.Object r3 = r7.getAuthRequestContext()     // Catch: java.lang.Throwable -> Lb4
            if (r3 == 0) goto L5b
            java.lang.Class<R> r4 = r6.SubSequence     // Catch: java.lang.Throwable -> Lb4
            java.lang.Class r5 = r3.getClass()     // Catch: java.lang.Throwable -> Lb4
            boolean r4 = r4.isAssignableFrom(r5)     // Catch: java.lang.Throwable -> Lb4
            if (r4 != 0) goto L43
            goto L5b
        L43:
            boolean r2 = r6.GetContactSyncConfig()     // Catch: java.lang.Throwable -> Lb4
            if (r2 != 0) goto L56
            r6.NetworkUserEntityData$$ExternalSyntheticLambda4 = r0     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.request.SingleRequest$Status r8 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch: java.lang.Throwable -> Lb2
            r6.NetworkUserEntityData$$ExternalSyntheticLambda6 = r8     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r1)
            if (r7 == 0) goto L55
            com.bumptech.glide.load.engine.Engine.MyBillsEntityDataFactory(r7)
        L55:
            return
        L56:
            r6.MyBillsEntityDataFactory(r7, r3, r8)     // Catch: java.lang.Throwable -> Lb4
            monitor-exit(r1)
            return
        L5b:
            r6.NetworkUserEntityData$$ExternalSyntheticLambda4 = r0     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.load.engine.GlideException r8 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r0.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "Expected to receive an object of "
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class<R> r4 = r6.SubSequence     // Catch: java.lang.Throwable -> Lb2
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = " but instead got "
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            if (r3 == 0) goto L7a
            java.lang.Class r4 = r3.getClass()     // Catch: java.lang.Throwable -> Lb2
            goto L7c
        L7a:
            java.lang.String r4 = ""
        L7c:
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "{"
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "} inside Resource{"
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            r0.append(r7)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "}."
            r0.append(r4)     // Catch: java.lang.Throwable -> Lb2
            if (r3 == 0) goto L9c
            java.lang.String r3 = ""
            goto L9e
        L9c:
            java.lang.String r3 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9e:
            r0.append(r3)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lb2
            r8.<init>(r0)     // Catch: java.lang.Throwable -> Lb2
            r6.BuiltInFictitiousFunctionClassFactory(r8, r2)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r1)
            if (r7 == 0) goto Lb1
            com.bumptech.glide.load.engine.Engine.MyBillsEntityDataFactory(r7)
        Lb1:
            return
        Lb2:
            r8 = move-exception
            goto Lb7
        Lb4:
            r7 = move-exception
            r8 = r7
            r7 = r0
        Lb7:
            monitor-exit(r1)
            throw r8     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            r8 = move-exception
            r0 = r7
            goto Lbd
        Lbc:
            r8 = move-exception
        Lbd:
            if (r0 == 0) goto Lc2
            com.bumptech.glide.load.engine.Engine.MyBillsEntityDataFactory(r0)
        Lc2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.KClassImpl$Data$declaredNonStaticMembers$2(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource):void");
    }

    private void MyBillsEntityDataFactory(Resource<R> resource, R r, DataSource dataSource) {
        boolean z;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda1();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Status.COMPLETE;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = resource;
        if (this.getErrorConfigVersion.scheduleImpl <= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Finished loading ");
            sb.append(r.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(dataSource);
            sb.append(" for ");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sb.append(" with size [");
            sb.append(this.getCallingPid);
            sb.append("x");
            sb.append(this.moveToNextValue);
            sb.append("] in ");
            sb.append(LogTime.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            sb.append(" ms");
            InstrumentInjector.log_d("Glide", sb.toString());
        }
        boolean z2 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        try {
            List<RequestListener<R>> list = this.PrepareContext;
            if (list != null) {
                Iterator<RequestListener<R>> it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= it.next().onResourceReady(r, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getSupportButtonTintMode, dataSource, NetworkUserEntityData$$ExternalSyntheticLambda1);
                }
            } else {
                z = false;
            }
            RequestListener<R> requestListener = this.whenAvailable;
            if (requestListener == null || !requestListener.onResourceReady(r, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getSupportButtonTintMode, dataSource, NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.getSupportButtonTintMode.onResourceReady(r, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(dataSource, NetworkUserEntityData$$ExternalSyntheticLambda1));
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            RequestCoordinator requestCoordinator = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (requestCoordinator != null) {
                requestCoordinator.lookAheadTest(this);
            }
        } catch (Throwable th) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public final void BuiltInFictitiousFunctionClassFactory(GlideException glideException) {
        BuiltInFictitiousFunctionClassFactory(glideException, 5);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public final Object getAuthRequestContext() {
        this.FragmentBottomSheetPaymentSettingBinding.PlaceComponentResult();
        return this.newProxyInstance;
    }

    private void BuiltInFictitiousFunctionClassFactory(GlideException glideException, int i) {
        boolean z;
        this.FragmentBottomSheetPaymentSettingBinding.PlaceComponentResult();
        synchronized (this.newProxyInstance) {
            glideException.setOrigin(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            int i2 = this.getErrorConfigVersion.scheduleImpl;
            if (i2 <= i) {
                StringBuilder sb = new StringBuilder();
                sb.append("Load failed for ");
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                sb.append(" with size [");
                sb.append(this.getCallingPid);
                sb.append("x");
                sb.append(this.moveToNextValue);
                sb.append("]");
                InstrumentInjector.log_w("Glide", sb.toString(), glideException);
                if (i2 <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.GetContactSyncConfig = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = Status.FAILED;
            boolean z2 = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            try {
                List<RequestListener<R>> list = this.PrepareContext;
                if (list != null) {
                    Iterator<RequestListener<R>> it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        z |= it.next().onLoadFailed(glideException, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getSupportButtonTintMode, NetworkUserEntityData$$ExternalSyntheticLambda1());
                    }
                } else {
                    z = false;
                }
                RequestListener<R> requestListener = this.whenAvailable;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.getSupportButtonTintMode, NetworkUserEntityData$$ExternalSyntheticLambda1())) {
                    z2 = false;
                }
                if (!(z | z2) && NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    Drawable DatabaseTableConfigUtil = this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null ? DatabaseTableConfigUtil() : null;
                    if (DatabaseTableConfigUtil == null) {
                        if (this.scheduleImpl == null) {
                            Drawable drawable = this.isLayoutRequested.getAuthRequestContext;
                            this.scheduleImpl = drawable;
                            if (drawable == null && this.isLayoutRequested.MyBillsEntityDataFactory > 0) {
                                this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested.MyBillsEntityDataFactory);
                            }
                        }
                        DatabaseTableConfigUtil = this.scheduleImpl;
                    }
                    if (DatabaseTableConfigUtil == null) {
                        DatabaseTableConfigUtil = initRecordTimeStamp();
                    }
                    this.getSupportButtonTintMode.onLoadFailed(DatabaseTableConfigUtil);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                RequestCoordinator requestCoordinator = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (requestCoordinator != null) {
                    requestCoordinator.PlaceComponentResult(this);
                }
            } catch (Throwable th) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean getAuthRequestContext(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority2;
        int size2;
        if (request instanceof SingleRequest) {
            synchronized (this.newProxyInstance) {
                i = this.DatabaseTableConfigUtil;
                i2 = this.initRecordTimeStamp;
                obj = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                cls = this.SubSequence;
                baseRequestOptions = this.isLayoutRequested;
                priority = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                List<RequestListener<R>> list = this.PrepareContext;
                size = list != null ? list.size() : 0;
            }
            SingleRequest singleRequest = (SingleRequest) request;
            synchronized (singleRequest.newProxyInstance) {
                i3 = singleRequest.DatabaseTableConfigUtil;
                i4 = singleRequest.initRecordTimeStamp;
                obj2 = singleRequest.NetworkUserEntityData$$ExternalSyntheticLambda2;
                cls2 = singleRequest.SubSequence;
                baseRequestOptions2 = singleRequest.isLayoutRequested;
                priority2 = singleRequest.NetworkUserEntityData$$ExternalSyntheticLambda8;
                List<RequestListener<R>> list2 = singleRequest.PrepareContext;
                size2 = list2 != null ? list2.size() : 0;
            }
            return i == i3 && i2 == i4 && Util.MyBillsEntityDataFactory(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
        }
        return false;
    }

    private void PlaceComponentResult(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.readMicros);
        InstrumentInjector.log_v("Request", sb.toString());
    }
}
