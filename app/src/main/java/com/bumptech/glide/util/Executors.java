package com.bumptech.glide.util;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class Executors {
    private static final Executor PlaceComponentResult = new Executor() { // from class: com.bumptech.glide.util.Executors.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Util.BuiltInFictitiousFunctionClassFactory(runnable);
        }
    };
    private static final Executor KClassImpl$Data$declaredNonStaticMembers$2 = new Executor() { // from class: com.bumptech.glide.util.Executors.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    private Executors() {
    }

    public static Executor MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
