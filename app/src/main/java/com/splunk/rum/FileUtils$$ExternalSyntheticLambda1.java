package com.splunk.rum;

import j$.util.function.Predicate;
import java.io.File;

/* loaded from: classes3.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda1 implements Predicate {
    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate negate() {
        return Predicate.CC.PlaceComponentResult(this);
    }

    @Override // j$.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
    }

    @Override // j$.util.function.Predicate
    public final boolean test(Object obj) {
        return ((File) obj).isDirectory();
    }
}
