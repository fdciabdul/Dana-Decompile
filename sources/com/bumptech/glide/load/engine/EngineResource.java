package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
class EngineResource<Z> implements Resource<Z> {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    final Resource<Z> PlaceComponentResult;
    private int getAuthRequestContext;
    private final Key getErrorConfigVersion;
    private final ResourceListener scheduleImpl;

    /* loaded from: classes3.dex */
    interface ResourceListener {
        void BuiltInFictitiousFunctionClassFactory(Key key, EngineResource<?> engineResource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource(Resource<Z> resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        this.PlaceComponentResult = (Resource) Preconditions.PlaceComponentResult(resource);
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.MyBillsEntityDataFactory = z2;
        this.getErrorConfigVersion = key;
        this.scheduleImpl = (ResourceListener) Preconditions.PlaceComponentResult(resourceListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<Z> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Z getAuthRequestContext() {
        return this.PlaceComponentResult.getAuthRequestContext();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return this.PlaceComponentResult.MyBillsEntityDataFactory();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
        synchronized (this) {
            if (this.getAuthRequestContext > 0) {
                throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            if (this.MyBillsEntityDataFactory) {
                this.PlaceComponentResult.lookAheadTest();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult() {
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                throw new IllegalStateException("Cannot acquire a recycled resource");
            }
            this.getAuthRequestContext++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        boolean z;
        synchronized (this) {
            int i = this.getAuthRequestContext;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            int i2 = i - 1;
            this.getAuthRequestContext = i2;
            z = i2 == 0;
        }
        if (z) {
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, this);
        }
    }

    public String toString() {
        String obj;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineResource{isMemoryCacheable=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", listener=");
            sb.append(this.scheduleImpl);
            sb.append(", key=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", acquired=");
            sb.append(this.getAuthRequestContext);
            sb.append(", isRecycled=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", resource=");
            sb.append(this.PlaceComponentResult);
            sb.append('}');
            obj = sb.toString();
        }
        return obj;
    }
}
