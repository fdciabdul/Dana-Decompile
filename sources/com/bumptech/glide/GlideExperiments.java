package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class GlideExperiments {
    private final Map<Class<?>, Experiment> KClassImpl$Data$declaredNonStaticMembers$2;

    /* loaded from: classes3.dex */
    interface Experiment {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlideExperiments(Builder builder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Collections.unmodifiableMap(new HashMap(builder.BuiltInFictitiousFunctionClassFactory));
    }

    public final boolean MyBillsEntityDataFactory(Class<? extends Experiment> cls) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(cls);
    }

    /* loaded from: classes3.dex */
    static final class Builder {
        private final Map<Class<?>, Experiment> BuiltInFictitiousFunctionClassFactory = new HashMap();
    }
}
