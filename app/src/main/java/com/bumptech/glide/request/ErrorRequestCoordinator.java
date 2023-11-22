package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes3.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private final RequestCoordinator KClassImpl$Data$declaredNonStaticMembers$2;
    public volatile Request PlaceComponentResult;
    public volatile Request getAuthRequestContext;
    private final Object moveToNextValue;
    private RequestCoordinator.RequestState BuiltInFictitiousFunctionClassFactory = RequestCoordinator.RequestState.CLEARED;
    private RequestCoordinator.RequestState MyBillsEntityDataFactory = RequestCoordinator.RequestState.CLEARED;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        this.moveToNextValue = obj;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = requestCoordinator;
    }

    @Override // com.bumptech.glide.request.Request
    public final void PlaceComponentResult() {
        synchronized (this.moveToNextValue) {
            if (this.BuiltInFictitiousFunctionClassFactory != RequestCoordinator.RequestState.RUNNING) {
                this.BuiltInFictitiousFunctionClassFactory = RequestCoordinator.RequestState.RUNNING;
                this.getAuthRequestContext.PlaceComponentResult();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.moveToNextValue) {
            this.BuiltInFictitiousFunctionClassFactory = RequestCoordinator.RequestState.CLEARED;
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
            if (this.MyBillsEntityDataFactory != RequestCoordinator.RequestState.CLEARED) {
                this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.CLEARED;
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void lookAheadTest() {
        synchronized (this.moveToNextValue) {
            if (this.BuiltInFictitiousFunctionClassFactory == RequestCoordinator.RequestState.RUNNING) {
                this.BuiltInFictitiousFunctionClassFactory = RequestCoordinator.RequestState.PAUSED;
                this.getAuthRequestContext.lookAheadTest();
            }
            if (this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.RUNNING) {
                this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.PAUSED;
                this.PlaceComponentResult.lookAheadTest();
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean moveToNextValue() {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (this.BuiltInFictitiousFunctionClassFactory != RequestCoordinator.RequestState.RUNNING) {
                z = this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.RUNNING;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean scheduleImpl() {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (this.BuiltInFictitiousFunctionClassFactory != RequestCoordinator.RequestState.SUCCESS) {
                z = this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.SUCCESS;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean MyBillsEntityDataFactory() {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (this.BuiltInFictitiousFunctionClassFactory == RequestCoordinator.RequestState.CLEARED) {
                z = this.MyBillsEntityDataFactory == RequestCoordinator.RequestState.CLEARED;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean getAuthRequestContext(Request request) {
        if (request instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
            return this.getAuthRequestContext.getAuthRequestContext(errorRequestCoordinator.getAuthRequestContext) && this.PlaceComponentResult.getAuthRequestContext(errorRequestCoordinator.PlaceComponentResult);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Request request) {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                z = scheduleImpl(request);
            }
        }
        return z;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        RequestCoordinator requestCoordinator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return requestCoordinator == null || requestCoordinator.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final boolean BuiltInFictitiousFunctionClassFactory(Request request) {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                z = scheduleImpl(request);
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final boolean MyBillsEntityDataFactory(Request request) {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (getErrorConfigVersion()) {
                z = scheduleImpl(request);
            }
        }
        return z;
    }

    private boolean getErrorConfigVersion() {
        RequestCoordinator requestCoordinator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return requestCoordinator == null || requestCoordinator.MyBillsEntityDataFactory(this);
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        RequestCoordinator requestCoordinator = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return requestCoordinator == null || requestCoordinator.BuiltInFictitiousFunctionClassFactory(this);
    }

    private boolean scheduleImpl(Request request) {
        return request.equals(this.getAuthRequestContext) || (this.BuiltInFictitiousFunctionClassFactory == RequestCoordinator.RequestState.FAILED && request.equals(this.PlaceComponentResult));
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        synchronized (this.moveToNextValue) {
            if (!this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
                z = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final void lookAheadTest(Request request) {
        synchronized (this.moveToNextValue) {
            if (request.equals(this.getAuthRequestContext)) {
                this.BuiltInFictitiousFunctionClassFactory = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.PlaceComponentResult)) {
                this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (requestCoordinator != null) {
                requestCoordinator.lookAheadTest(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final void PlaceComponentResult(Request request) {
        synchronized (this.moveToNextValue) {
            if (!request.equals(this.PlaceComponentResult)) {
                this.BuiltInFictitiousFunctionClassFactory = RequestCoordinator.RequestState.FAILED;
                if (this.MyBillsEntityDataFactory != RequestCoordinator.RequestState.RUNNING) {
                    this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.RUNNING;
                    this.PlaceComponentResult.PlaceComponentResult();
                }
                return;
            }
            this.MyBillsEntityDataFactory = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (requestCoordinator != null) {
                requestCoordinator.PlaceComponentResult(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public final RequestCoordinator getAuthRequestContext() {
        RequestCoordinator authRequestContext;
        synchronized (this.moveToNextValue) {
            RequestCoordinator requestCoordinator = this.KClassImpl$Data$declaredNonStaticMembers$2;
            authRequestContext = requestCoordinator != null ? requestCoordinator.getAuthRequestContext() : this;
        }
        return authRequestContext;
    }
}
