package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* loaded from: classes3.dex */
final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    private static final Pools.Pool<LockedResource<?>> BuiltInFictitiousFunctionClassFactory = FactoryPools.BuiltInFictitiousFunctionClassFactory(20, new FactoryPools.Factory<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.LockedResource.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public final /* synthetic */ LockedResource<?> getAuthRequestContext() {
            return new LockedResource<>();
        }
    });
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private final StateVerifier PlaceComponentResult = StateVerifier.KClassImpl$Data$declaredNonStaticMembers$2();
    private Resource<Z> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Z> LockedResource<Z> getAuthRequestContext(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
        ((LockedResource) lockedResource).KClassImpl$Data$declaredNonStaticMembers$2 = false;
        ((LockedResource) lockedResource).MyBillsEntityDataFactory = true;
        ((LockedResource) lockedResource).getAuthRequestContext = resource;
        return lockedResource;
    }

    LockedResource() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            this.PlaceComponentResult.PlaceComponentResult();
            if (!this.MyBillsEntityDataFactory) {
                throw new IllegalStateException("Already unlocked");
            }
            this.MyBillsEntityDataFactory = false;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                lookAheadTest();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<Z> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Z getAuthRequestContext() {
        return this.getAuthRequestContext.getAuthRequestContext();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
        synchronized (this) {
            this.PlaceComponentResult.PlaceComponentResult();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            if (!this.MyBillsEntityDataFactory) {
                this.getAuthRequestContext.lookAheadTest();
                this.getAuthRequestContext = null;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this);
            }
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier d_() {
        return this.PlaceComponentResult;
    }
}
