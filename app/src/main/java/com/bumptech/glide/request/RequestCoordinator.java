package com.bumptech.glide.request;

/* loaded from: classes3.dex */
public interface RequestCoordinator {
    boolean BuiltInFictitiousFunctionClassFactory();

    boolean BuiltInFictitiousFunctionClassFactory(Request request);

    boolean KClassImpl$Data$declaredNonStaticMembers$2(Request request);

    boolean MyBillsEntityDataFactory(Request request);

    void PlaceComponentResult(Request request);

    RequestCoordinator getAuthRequestContext();

    void lookAheadTest(Request request);

    /* loaded from: classes3.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        RequestState(boolean z) {
            this.isComplete = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean isComplete() {
            return this.isComplete;
        }
    }
}
