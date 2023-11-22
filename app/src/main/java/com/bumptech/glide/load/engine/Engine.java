package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.ActiveResources;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    private static final boolean PlaceComponentResult = Log.isLoggable("Engine", 2);
    private final MemoryCache BuiltInFictitiousFunctionClassFactory;
    private final DecodeJobFactory KClassImpl$Data$declaredNonStaticMembers$2;
    private final LazyDiskCacheProvider MyBillsEntityDataFactory;
    private final Jobs NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ActiveResources getAuthRequestContext;
    private final EngineJobFactory getErrorConfigVersion;
    private final ResourceRecycler lookAheadTest;
    private final EngineKeyFactory moveToNextValue;

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, z, (byte) 0);
    }

    private Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z, byte b) {
        this.BuiltInFictitiousFunctionClassFactory = memoryCache;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(factory);
        this.MyBillsEntityDataFactory = lazyDiskCacheProvider;
        ActiveResources activeResources = new ActiveResources(z);
        this.getAuthRequestContext = activeResources;
        synchronized (this) {
            synchronized (activeResources) {
                activeResources.BuiltInFictitiousFunctionClassFactory = this;
            }
        }
        this.moveToNextValue = new EngineKeyFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Jobs();
        this.getErrorConfigVersion = new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new DecodeJobFactory(lazyDiskCacheProvider);
        this.lookAheadTest = new ResourceRecycler();
        memoryCache.BuiltInFictitiousFunctionClassFactory(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:10:0x0026, B:12:0x002c, B:14:0x0030, B:24:0x004b, B:25:0x007b, B:15:0x0036, B:17:0x003c, B:19:0x0040), top: B:32:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <R> com.bumptech.glide.load.engine.Engine.LoadStatus BuiltInFictitiousFunctionClassFactory(com.bumptech.glide.GlideContext r25, java.lang.Object r26, com.bumptech.glide.load.Key r27, int r28, int r29, java.lang.Class<?> r30, java.lang.Class<R> r31, com.bumptech.glide.Priority r32, com.bumptech.glide.load.engine.DiskCacheStrategy r33, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r34, boolean r35, boolean r36, com.bumptech.glide.load.Options r37, boolean r38, boolean r39, boolean r40, boolean r41, com.bumptech.glide.request.ResourceCallback r42, java.util.concurrent.Executor r43) {
        /*
            r24 = this;
            r15 = r24
            boolean r0 = com.bumptech.glide.load.engine.Engine.PlaceComponentResult
            if (r0 == 0) goto Lb
            long r0 = com.bumptech.glide.util.LogTime.PlaceComponentResult()
            goto Ld
        Lb:
            r0 = 0
        Ld:
            r13 = r0
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r34
            r5 = r30
            r6 = r31
            r7 = r37
            com.bumptech.glide.load.engine.EngineKey r0 = com.bumptech.glide.load.engine.EngineKeyFactory.getAuthRequestContext(r0, r1, r2, r3, r4, r5, r6, r7)
            monitor-enter(r24)
            r1 = 0
            if (r38 == 0) goto L48
            com.bumptech.glide.load.engine.EngineResource r2 = r15.PlaceComponentResult(r0)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L36
            boolean r3 = com.bumptech.glide.load.engine.Engine.PlaceComponentResult     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L49
            java.lang.String r3 = "Loaded resource from active resources"
            getAuthRequestContext(r3, r13, r0)     // Catch: java.lang.Throwable -> L46
            goto L49
        L36:
            com.bumptech.glide.load.engine.EngineResource r2 = r15.MyBillsEntityDataFactory(r0)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L48
            boolean r3 = com.bumptech.glide.load.engine.Engine.PlaceComponentResult     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L49
            java.lang.String r3 = "Loaded resource from cache"
            getAuthRequestContext(r3, r13, r0)     // Catch: java.lang.Throwable -> L46
            goto L49
        L46:
            r0 = move-exception
            goto L7d
        L48:
            r2 = r1
        L49:
            if (r2 != 0) goto L7f
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r12 = r35
            r22 = r13
            r13 = r36
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r20 = r43
            r21 = r0
            com.bumptech.glide.load.engine.Engine$LoadStatus r0 = r1.PlaceComponentResult(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r24)     // Catch: java.lang.Throwable -> L46
            return r0
        L7d:
            monitor-exit(r24)
            throw r0
        L7f:
            monitor-exit(r24)
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.MEMORY_CACHE
            r3 = r42
            r3.KClassImpl$Data$declaredNonStaticMembers$2(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.Engine.BuiltInFictitiousFunctionClassFactory(com.bumptech.glide.GlideContext, java.lang.Object, com.bumptech.glide.load.Key, int, int, java.lang.Class, java.lang.Class, com.bumptech.glide.Priority, com.bumptech.glide.load.engine.DiskCacheStrategy, java.util.Map, boolean, boolean, com.bumptech.glide.load.Options, boolean, boolean, boolean, boolean, com.bumptech.glide.request.ResourceCallback, java.util.concurrent.Executor):com.bumptech.glide.load.engine.Engine$LoadStatus");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <R> LoadStatus PlaceComponentResult(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j) {
        Jobs jobs = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        EngineJob<?> engineJob = (z6 ? jobs.PlaceComponentResult : jobs.BuiltInFictitiousFunctionClassFactory).get(engineKey);
        if (engineJob != null) {
            engineJob.BuiltInFictitiousFunctionClassFactory(resourceCallback, executor);
            if (PlaceComponentResult) {
                getAuthRequestContext("Added to existing load", j, engineKey);
            }
            return new LoadStatus(resourceCallback, engineJob);
        }
        EngineJob<?> authRequestContext = ((EngineJob) Preconditions.PlaceComponentResult(this.getErrorConfigVersion.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory())).getAuthRequestContext(engineKey, z3, z4, z5, z6);
        DecodeJobFactory decodeJobFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DecodeJob<R> decodeJob = (DecodeJob) Preconditions.PlaceComponentResult(decodeJobFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
        int i3 = decodeJobFactory.MyBillsEntityDataFactory;
        decodeJobFactory.MyBillsEntityDataFactory = i3 + 1;
        DecodeHelper<R> decodeHelper = decodeJob.MyBillsEntityDataFactory;
        DecodeJob.DiskCacheProvider diskCacheProvider = decodeJob.lookAheadTest;
        decodeHelper.KClassImpl$Data$declaredNonStaticMembers$2 = glideContext;
        decodeHelper.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj;
        decodeHelper.NetworkUserEntityData$$ExternalSyntheticLambda1 = key;
        decodeHelper.GetContactSyncConfig = i;
        decodeHelper.BuiltInFictitiousFunctionClassFactory = i2;
        decodeHelper.MyBillsEntityDataFactory = diskCacheStrategy;
        decodeHelper.getErrorConfigVersion = cls;
        decodeHelper.PlaceComponentResult = diskCacheProvider;
        decodeHelper.initRecordTimeStamp = cls2;
        decodeHelper.scheduleImpl = priority;
        decodeHelper.lookAheadTest = options;
        decodeHelper.NetworkUserEntityData$$ExternalSyntheticLambda2 = map;
        decodeHelper.moveToNextValue = z;
        decodeHelper.getAuthRequestContext = z2;
        decodeJob.getErrorConfigVersion = glideContext;
        decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda8 = key;
        decodeJob.PrepareContext = priority;
        decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda1 = engineKey;
        decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
        decodeJob.scheduleImpl = i2;
        decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda0 = diskCacheStrategy;
        decodeJob.DatabaseTableConfigUtil = z6;
        decodeJob.initRecordTimeStamp = options;
        decodeJob.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        decodeJob.GetContactSyncConfig = i3;
        decodeJob.newProxyInstance = DecodeJob.RunReason.INITIALIZE;
        decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda2 = obj;
        Jobs jobs2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2() ? jobs2.PlaceComponentResult : jobs2.BuiltInFictitiousFunctionClassFactory).put(engineKey, authRequestContext);
        authRequestContext.BuiltInFictitiousFunctionClassFactory(resourceCallback, executor);
        synchronized (authRequestContext) {
            authRequestContext.BuiltInFictitiousFunctionClassFactory = decodeJob;
            (decodeJob.MyBillsEntityDataFactory() ? authRequestContext.PlaceComponentResult : authRequestContext.MyBillsEntityDataFactory()).execute(decodeJob);
        }
        if (PlaceComponentResult) {
            getAuthRequestContext("Started new load", j, engineKey);
        }
        return new LoadStatus(resourceCallback, authRequestContext);
    }

    private static void getAuthRequestContext(String str, long j, Key key) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.MyBillsEntityDataFactory(j));
        sb.append("ms, key: ");
        sb.append(key);
        InstrumentInjector.log_v("Engine", sb.toString());
    }

    private EngineResource<?> PlaceComponentResult(Key key) {
        EngineResource<?> MyBillsEntityDataFactory = this.getAuthRequestContext.MyBillsEntityDataFactory(key);
        if (MyBillsEntityDataFactory != null) {
            MyBillsEntityDataFactory.PlaceComponentResult();
        }
        return MyBillsEntityDataFactory;
    }

    public static void MyBillsEntityDataFactory(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).NetworkUserEntityData$$ExternalSyntheticLambda0();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public final void BuiltInFictitiousFunctionClassFactory(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        synchronized (this) {
            if (engineResource != null) {
                if (engineResource.BuiltInFictitiousFunctionClassFactory()) {
                    this.getAuthRequestContext.MyBillsEntityDataFactory(key, engineResource);
                }
            }
            Jobs jobs = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Map<Key, EngineJob<?>> map = engineJob.KClassImpl$Data$declaredNonStaticMembers$2() ? jobs.PlaceComponentResult : jobs.BuiltInFictitiousFunctionClassFactory;
            if (engineJob.equals(map.get(key))) {
                map.remove(key);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public final void getAuthRequestContext(EngineJob<?> engineJob, Key key) {
        synchronized (this) {
            Jobs jobs = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Map<Key, EngineJob<?>> map = engineJob.KClassImpl$Data$declaredNonStaticMembers$2() ? jobs.PlaceComponentResult : jobs.BuiltInFictitiousFunctionClassFactory;
            if (engineJob.equals(map.get(key))) {
                map.remove(key);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public final void PlaceComponentResult(Resource<?> resource) {
        this.lookAheadTest.PlaceComponentResult(resource, true);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public final void BuiltInFictitiousFunctionClassFactory(Key key, EngineResource<?> engineResource) {
        ActiveResources activeResources = this.getAuthRequestContext;
        synchronized (activeResources) {
            ActiveResources.ResourceWeakReference remove = activeResources.KClassImpl$Data$declaredNonStaticMembers$2.remove(key);
            if (remove != null) {
                remove.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                remove.clear();
            }
        }
        if (engineResource.BuiltInFictitiousFunctionClassFactory()) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(key, engineResource);
        } else {
            this.lookAheadTest.PlaceComponentResult(engineResource, false);
        }
    }

    /* loaded from: classes3.dex */
    public class LoadStatus {
        public final EngineJob<?> KClassImpl$Data$declaredNonStaticMembers$2;
        public final ResourceCallback MyBillsEntityDataFactory;

        LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.MyBillsEntityDataFactory = resourceCallback;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = engineJob;
        }
    }

    /* loaded from: classes3.dex */
    static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
        private final DiskCache.Factory KClassImpl$Data$declaredNonStaticMembers$2;
        private volatile DiskCache PlaceComponentResult;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = factory;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public final DiskCache KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.PlaceComponentResult == null) {
                synchronized (this) {
                    if (this.PlaceComponentResult == null) {
                        this.PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                    }
                    if (this.PlaceComponentResult == null) {
                        this.PlaceComponentResult = new DiskCacheAdapter();
                    }
                }
            }
            return this.PlaceComponentResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class DecodeJobFactory {
        final Pools.Pool<DecodeJob<?>> KClassImpl$Data$declaredNonStaticMembers$2 = FactoryPools.BuiltInFictitiousFunctionClassFactory(150, new FactoryPools.Factory<DecodeJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.DecodeJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public final /* synthetic */ DecodeJob<?> getAuthRequestContext() {
                return new DecodeJob<>(DecodeJobFactory.this.PlaceComponentResult, DecodeJobFactory.this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        });
        int MyBillsEntityDataFactory;
        final DecodeJob.DiskCacheProvider PlaceComponentResult;

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.PlaceComponentResult = diskCacheProvider;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class EngineJobFactory {
        final EngineResource.ResourceListener BuiltInFictitiousFunctionClassFactory;
        final GlideExecutor KClassImpl$Data$declaredNonStaticMembers$2;
        final GlideExecutor MyBillsEntityDataFactory;
        final Pools.Pool<EngineJob<?>> PlaceComponentResult = FactoryPools.BuiltInFictitiousFunctionClassFactory(150, new FactoryPools.Factory<EngineJob<?>>() { // from class: com.bumptech.glide.load.engine.Engine.EngineJobFactory.1
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public final /* synthetic */ EngineJob<?> getAuthRequestContext() {
                return new EngineJob<>(EngineJobFactory.this.MyBillsEntityDataFactory, EngineJobFactory.this.lookAheadTest, EngineJobFactory.this.scheduleImpl, EngineJobFactory.this.KClassImpl$Data$declaredNonStaticMembers$2, EngineJobFactory.this.getAuthRequestContext, EngineJobFactory.this.BuiltInFictitiousFunctionClassFactory, EngineJobFactory.this.PlaceComponentResult);
            }
        });
        final EngineJobListener getAuthRequestContext;
        final GlideExecutor lookAheadTest;
        final GlideExecutor scheduleImpl;

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.MyBillsEntityDataFactory = glideExecutor;
            this.lookAheadTest = glideExecutor2;
            this.scheduleImpl = glideExecutor3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = glideExecutor4;
            this.getAuthRequestContext = engineJobListener;
            this.BuiltInFictitiousFunctionClassFactory = resourceListener;
        }
    }

    private EngineResource<?> MyBillsEntityDataFactory(Key key) {
        EngineResource<?> engineResource;
        Resource<?> BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(key);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            engineResource = null;
        } else if (BuiltInFictitiousFunctionClassFactory instanceof EngineResource) {
            engineResource = (EngineResource) BuiltInFictitiousFunctionClassFactory;
        } else {
            engineResource = new EngineResource<>(BuiltInFictitiousFunctionClassFactory, true, true, key, this);
        }
        if (engineResource != null) {
            engineResource.PlaceComponentResult();
            this.getAuthRequestContext.MyBillsEntityDataFactory(key, engineResource);
        }
        return engineResource;
    }
}
