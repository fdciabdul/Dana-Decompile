package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public interface Headers {
    public static final Headers BuiltInFictitiousFunctionClassFactory;
    @Deprecated
    public static final Headers PlaceComponentResult = new Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public final Map<String, String> BuiltInFictitiousFunctionClassFactory() {
            return Collections.emptyMap();
        }
    };

    Map<String, String> BuiltInFictitiousFunctionClassFactory();

    static {
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        builder.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory = new LazyHeaders(builder.MyBillsEntityDataFactory);
    }
}
