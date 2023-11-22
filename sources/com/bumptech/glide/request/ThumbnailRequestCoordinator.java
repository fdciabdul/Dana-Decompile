package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes3.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private final RequestCoordinator BuiltInFictitiousFunctionClassFactory;
    public volatile Request KClassImpl$Data$declaredNonStaticMembers$2;
    private RequestCoordinator.RequestState MyBillsEntityDataFactory = RequestCoordinator.RequestState.CLEARED;
    private RequestCoordinator.RequestState NetworkUserEntityData$$ExternalSyntheticLambda0 = RequestCoordinator.RequestState.CLEARED;
    public volatile Request PlaceComponentResult;
    private boolean getAuthRequestContext;
    private final Object getErrorConfigVersion;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        this.getErrorConfigVersion = obj;
        this.BuiltInFictitiousFunctionClassFactory = requestCoordinator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2.MyBillsEntityDataFactory != com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS) goto L10;
     */
    @Override // com.bumptech.glide.request.RequestCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.getErrorConfigVersion
            monitor-enter(r0)
            boolean r1 = r2.initRecordTimeStamp()     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L19
            com.bumptech.glide.request.Request r1 = r2.PlaceComponentResult     // Catch: java.lang.Throwable -> L1c
            boolean r3 = r3.equals(r1)     // Catch: java.lang.Throwable -> L1c
            if (r3 != 0) goto L17
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L1c
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.SUCCESS     // Catch: java.lang.Throwable -> L1c
            if (r3 == r1) goto L19
        L17:
            r3 = 1
            goto L1a
        L19:
            r3 = 0
        L1a:
            monitor-exit(r0)
            return r3
        L1c:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ThumbnailRequestCoordinator.KClassImpl$Data$declaredNonStaticMembers$2(com.bumptech.glide.request.Request):boolean");
    }

    private boolean initRecordTimeStamp() {
        RequestCoordinator requestCoordinator = this.BuiltInFictitiousFunctionClassFactory;
        return requestCoordinator == null || requestCoordinator.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final boolean BuiltInFictitiousFunctionClassFactory(Request request) {
        boolean z;
        synchronized (this.getErrorConfigVersion) {
            if (getErrorConfigVersion() && request.equals(this.PlaceComponentResult)) {
                z = BuiltInFictitiousFunctionClassFactory() ? false : true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final boolean MyBillsEntityDataFactory(Request request) {
        boolean z;
        synchronized (this.getErrorConfigVersion) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0() && request.equals(this.PlaceComponentResult)) {
                z = this.MyBillsEntityDataFactory != RequestCoordinator.RequestState.PAUSED;
            }
        }
        return z;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RequestCoordinator requestCoordinator = this.BuiltInFictitiousFunctionClassFactory;
        return requestCoordinator == null || requestCoordinator.MyBillsEntityDataFactory(this);
    }

    private boolean getErrorConfigVersion() {
        RequestCoordinator requestCoordinator = this.BuiltInFictitiousFunctionClassFactory;
        return requestCoordinator == null || requestCoordinator.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        synchronized (this.getErrorConfigVersion) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
                z = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final void lookAheadTest(Request request) {
        synchronized (this.getErrorConfigVersion) {
            if (request.equals(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.BuiltInFictitiousFunctionClassFactory;
            if (requestCoordinator != null) {
                requestCoordinator.lookAheadTest(this);
            }
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.isComplete()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final void PlaceComponentResult(Request request) {
        synchronized (this.getErrorConfigVersion) {
            if (!request.equals(this.PlaceComponentResult)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.BuiltInFictitiousFunctionClassFactory;
            if (requestCoordinator != null) {
                requestCoordinator.PlaceComponentResult(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final RequestCoordinator getAuthRequestContext() {
        RequestCoordinator authRequestContext;
        synchronized (this.getErrorConfigVersion) {
            RequestCoordinator requestCoordinator = this.BuiltInFictitiousFunctionClassFactory;
            authRequestContext = requestCoordinator != null ? requestCoordinator.getAuthRequestContext() : this;
        }
        return authRequestContext;
    }

    @Override // com.bumptech.glide.request.Request
    public final void PlaceComponentResult() {
        synchronized (this.getErrorConfigVersion) {
            this.getAuthRequestContext = true;
            try {
                if (this.MyBillsEntityDataFactory != RequestCoordinator.RequestState.SUCCESS && this.NetworkUserEntityData$$ExternalSyntheticLambda0 != RequestCoordinator.RequestState.RUNNING) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = RequestCoordinator.RequestState.RUNNING;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
                }
                if (this.getAuthRequestContext && this.MyBillsEntityDataFactory != RequestCoordinator.RequestState.RUNNING) {
                    this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.RUNNING;
                    this.PlaceComponentResult.PlaceComponentResult();
                }
            } finally {
                this.getAuthRequestContext = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.getErrorConfigVersion) {
            this.getAuthRequestContext = false;
            this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.CLEARED;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = RequestCoordinator.RequestState.CLEARED;
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void lookAheadTest() {
        synchronized (this.getErrorConfigVersion) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.isComplete()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = RequestCoordinator.RequestState.PAUSED;
                this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest();
            }
            if (!this.MyBillsEntityDataFactory.isComplete()) {
                this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.PAUSED;
                this.PlaceComponentResult.lookAheadTest();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean moveToNextValue() {
        boolean z;
        synchronized (this.getErrorConfigVersion) {
            z = this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean scheduleImpl() {
        boolean z;
        synchronized (this.getErrorConfigVersion) {
            z = this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this.getErrorConfigVersion) {
            z = this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean getAuthRequestContext(Request request) {
        if (request instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
            if (this.PlaceComponentResult == null) {
                if (thumbnailRequestCoordinator.PlaceComponentResult != null) {
                    return false;
                }
            } else if (!this.PlaceComponentResult.getAuthRequestContext(thumbnailRequestCoordinator.PlaceComponentResult)) {
                return false;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                if (thumbnailRequestCoordinator.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    return false;
                }
            } else if (!this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(thumbnailRequestCoordinator.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
