package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory getErrorConfigVersion = new EngineResourceFactory();
    DecodeJob<R> BuiltInFictitiousFunctionClassFactory;
    private final EngineResourceFactory DatabaseTableConfigUtil;
    private final GlideExecutor FragmentBottomSheetPaymentSettingBinding;
    private volatile boolean GetContactSyncConfig;
    DataSource KClassImpl$Data$declaredNonStaticMembers$2;
    EngineResource<?> MyBillsEntityDataFactory;
    private final EngineJobListener NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final GlideExecutor NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final StateVerifier NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final EngineResource.ResourceListener NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Pools.Pool<EngineJob<?>> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8;
    final GlideExecutor PlaceComponentResult;
    private Key PrepareContext;
    final ResourceCallbacksAndExecutors getAuthRequestContext;
    private boolean getSupportButtonTintMode;
    private boolean initRecordTimeStamp;
    private final AtomicInteger isLayoutRequested;
    private final GlideExecutor lookAheadTest;
    GlideException moveToNextValue;
    private Resource<?> newProxyInstance;
    boolean scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, resourceListener, pool, getErrorConfigVersion);
    }

    private EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.getAuthRequestContext = new ResourceCallbacksAndExecutors();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = StateVerifier.KClassImpl$Data$declaredNonStaticMembers$2();
        this.isLayoutRequested = new AtomicInteger();
        this.PlaceComponentResult = glideExecutor;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = glideExecutor2;
        this.FragmentBottomSheetPaymentSettingBinding = glideExecutor3;
        this.lookAheadTest = glideExecutor4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = engineJobListener;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = resourceListener;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = pool;
        this.DatabaseTableConfigUtil = engineResourceFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EngineJob<R> getAuthRequestContext(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
        synchronized (this) {
            this.PrepareContext = key;
            this.initRecordTimeStamp = z;
            this.getSupportButtonTintMode = z2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = z4;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(ResourceCallback resourceCallback, Executor executor) {
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult();
            this.getAuthRequestContext.MyBillsEntityDataFactory.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                BuiltInFictitiousFunctionClassFactory(1);
                executor.execute(new CallResourceReady(resourceCallback));
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                BuiltInFictitiousFunctionClassFactory(1);
                executor.execute(new CallLoadFailed(resourceCallback));
            } else {
                Preconditions.BuiltInFictitiousFunctionClassFactory(!this.GetContactSyncConfig, "Cannot add callbacks to a cancelled EngineJob");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r2.isLayoutRequested.get() != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        moveToNextValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(com.bumptech.glide.request.ResourceCallback r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.bumptech.glide.util.pool.StateVerifier r0 = r2.NetworkUserEntityData$$ExternalSyntheticLambda4     // Catch: java.lang.Throwable -> L4d
            r0.PlaceComponentResult()     // Catch: java.lang.Throwable -> L4d
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r2.getAuthRequestContext     // Catch: java.lang.Throwable -> L4d
            java.util.List<com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor> r0 = r0.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L4d
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r3 = com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors.PlaceComponentResult(r3)     // Catch: java.lang.Throwable -> L4d
            r0.remove(r3)     // Catch: java.lang.Throwable -> L4d
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r3 = r2.getAuthRequestContext     // Catch: java.lang.Throwable -> L4d
            boolean r3 = r3.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4b
            boolean r3 = r2.PlaceComponentResult()     // Catch: java.lang.Throwable -> L4d
            r0 = 1
            if (r3 != 0) goto L34
            r2.GetContactSyncConfig = r0     // Catch: java.lang.Throwable -> L4d
            com.bumptech.glide.load.engine.DecodeJob<R> r3 = r2.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L4d
            r3.moveToNextValue = r0     // Catch: java.lang.Throwable -> L4d
            com.bumptech.glide.load.engine.DataFetcherGenerator r3 = r3.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L2d
            r3.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Throwable -> L4d
        L2d:
            com.bumptech.glide.load.engine.EngineJobListener r3 = r2.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Throwable -> L4d
            com.bumptech.glide.load.Key r1 = r2.PrepareContext     // Catch: java.lang.Throwable -> L4d
            r3.getAuthRequestContext(r2, r1)     // Catch: java.lang.Throwable -> L4d
        L34:
            boolean r3 = r2.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L3e
            boolean r3 = r2.NetworkUserEntityData$$ExternalSyntheticLambda1     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L3d
            goto L3e
        L3d:
            r0 = 0
        L3e:
            if (r0 == 0) goto L4b
            java.util.concurrent.atomic.AtomicInteger r3 = r2.isLayoutRequested     // Catch: java.lang.Throwable -> L4d
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L4b
            r2.moveToNextValue()     // Catch: java.lang.Throwable -> L4d
        L4b:
            monitor-exit(r2)
            return
        L4d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.getAuthRequestContext(com.bumptech.glide.request.ResourceCallback):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final GlideExecutor MyBillsEntityDataFactory() {
        if (this.getSupportButtonTintMode) {
            return this.FragmentBottomSheetPaymentSettingBinding;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6 ? this.lookAheadTest : this.NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    private boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1 || this.NetworkUserEntityData$$ExternalSyntheticLambda2 || this.GetContactSyncConfig;
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        EngineResource<?> engineResource;
        synchronized (this) {
            Preconditions.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(), "Not yet complete!");
            if (this.isLayoutRequested.getAndAdd(i) == 0 && (engineResource = this.MyBillsEntityDataFactory) != null) {
                engineResource.PlaceComponentResult();
            }
        }
    }

    final void BuiltInFictitiousFunctionClassFactory() {
        EngineResource<?> engineResource;
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult();
            Preconditions.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult(), "Not yet complete!");
            int decrementAndGet = this.isLayoutRequested.decrementAndGet();
            Preconditions.BuiltInFictitiousFunctionClassFactory(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource = this.MyBillsEntityDataFactory;
                moveToNextValue();
            } else {
                engineResource = null;
            }
        }
        if (engineResource != null) {
            engineResource.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    private void moveToNextValue() {
        synchronized (this) {
            if (this.PrepareContext == null) {
                throw new IllegalArgumentException();
            }
            this.getAuthRequestContext.MyBillsEntityDataFactory.clear();
            this.PrepareContext = null;
            this.MyBillsEntityDataFactory = null;
            this.newProxyInstance = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            this.GetContactSyncConfig = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
            this.scheduleImpl = false;
            DecodeJob<R> decodeJob = this.BuiltInFictitiousFunctionClassFactory;
            if (decodeJob.isLayoutRequested.MyBillsEntityDataFactory()) {
                decodeJob.PlaceComponentResult();
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.moveToNextValue = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public final void BuiltInFictitiousFunctionClassFactory(Resource<R> resource, DataSource dataSource, boolean z) {
        synchronized (this) {
            this.newProxyInstance = resource;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dataSource;
            this.scheduleImpl = z;
        }
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult();
            if (this.GetContactSyncConfig) {
                this.newProxyInstance.lookAheadTest();
                moveToNextValue();
            } else if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    throw new IllegalStateException("Already have resource");
                }
                this.MyBillsEntityDataFactory = EngineResourceFactory.BuiltInFictitiousFunctionClassFactory(this.newProxyInstance, this.initRecordTimeStamp, this.PrepareContext, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
                ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = new ResourceCallbacksAndExecutors(new ArrayList(this.getAuthRequestContext.MyBillsEntityDataFactory));
                BuiltInFictitiousFunctionClassFactory(resourceCallbacksAndExecutors.MyBillsEntityDataFactory.size() + 1);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(this, this.PrepareContext, this.MyBillsEntityDataFactory);
                Iterator<ResourceCallbackAndExecutor> it = resourceCallbacksAndExecutors.iterator();
                while (it.hasNext()) {
                    ResourceCallbackAndExecutor next = it.next();
                    next.getAuthRequestContext.execute(new CallResourceReady(next.PlaceComponentResult));
                }
                BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GlideException glideException) {
        synchronized (this) {
            this.moveToNextValue = glideException;
        }
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4.PlaceComponentResult();
            if (this.GetContactSyncConfig) {
                moveToNextValue();
            } else if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    throw new IllegalStateException("Already failed once");
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
                Key key = this.PrepareContext;
                ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = new ResourceCallbacksAndExecutors(new ArrayList(this.getAuthRequestContext.MyBillsEntityDataFactory));
                BuiltInFictitiousFunctionClassFactory(resourceCallbacksAndExecutors.MyBillsEntityDataFactory.size() + 1);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(this, key, null);
                Iterator<ResourceCallbackAndExecutor> it = resourceCallbacksAndExecutors.iterator();
                while (it.hasNext()) {
                    ResourceCallbackAndExecutor next = it.next();
                    next.getAuthRequestContext.execute(new CallLoadFailed(next.PlaceComponentResult));
                }
                BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public final void MyBillsEntityDataFactory(DecodeJob<?> decodeJob) {
        MyBillsEntityDataFactory().execute(decodeJob);
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier d_() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    /* loaded from: classes3.dex */
    class CallLoadFailed implements Runnable {
        private final ResourceCallback BuiltInFictitiousFunctionClassFactory;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.BuiltInFictitiousFunctionClassFactory = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory)) {
                        EngineJob engineJob = EngineJob.this;
                        try {
                            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(engineJob.moveToNextValue);
                        } catch (Throwable th) {
                            throw new CallbackException(th);
                        }
                    }
                    EngineJob.this.BuiltInFictitiousFunctionClassFactory();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class CallResourceReady implements Runnable {
        private final ResourceCallback PlaceComponentResult;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.PlaceComponentResult = resourceCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.PlaceComponentResult.getAuthRequestContext()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.getAuthRequestContext.MyBillsEntityDataFactory(this.PlaceComponentResult)) {
                        EngineJob.this.MyBillsEntityDataFactory.PlaceComponentResult();
                        EngineJob engineJob = EngineJob.this;
                        ResourceCallback resourceCallback = this.PlaceComponentResult;
                        try {
                            EngineResource<?> engineResource = engineJob.MyBillsEntityDataFactory;
                            DataSource dataSource = engineJob.KClassImpl$Data$declaredNonStaticMembers$2;
                            boolean z = engineJob.scheduleImpl;
                            resourceCallback.KClassImpl$Data$declaredNonStaticMembers$2(engineResource, dataSource);
                            EngineJob.this.getAuthRequestContext(this.PlaceComponentResult);
                        } catch (Throwable th) {
                            throw new CallbackException(th);
                        }
                    }
                    EngineJob.this.BuiltInFictitiousFunctionClassFactory();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        final List<ResourceCallbackAndExecutor> MyBillsEntityDataFactory;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.MyBillsEntityDataFactory = list;
        }

        final boolean MyBillsEntityDataFactory(ResourceCallback resourceCallback) {
            return this.MyBillsEntityDataFactory.contains(new ResourceCallbackAndExecutor(resourceCallback, Executors.MyBillsEntityDataFactory()));
        }

        final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory.isEmpty();
        }

        static ResourceCallbackAndExecutor PlaceComponentResult(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.MyBillsEntityDataFactory());
        }

        @Override // java.lang.Iterable
        public final Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.MyBillsEntityDataFactory.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ResourceCallbackAndExecutor {
        final ResourceCallback PlaceComponentResult;
        final Executor getAuthRequestContext;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor) {
            this.PlaceComponentResult = resourceCallback;
            this.getAuthRequestContext = executor;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.PlaceComponentResult.equals(((ResourceCallbackAndExecutor) obj).PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return this.PlaceComponentResult.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public static <R> EngineResource<R> BuiltInFictitiousFunctionClassFactory(Resource<R> resource, boolean z, Key key, EngineResource.ResourceListener resourceListener) {
            return new EngineResource<>(resource, z, true, key, resourceListener);
        }
    }
}
