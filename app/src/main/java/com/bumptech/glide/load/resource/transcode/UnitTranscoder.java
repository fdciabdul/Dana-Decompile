package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes3.dex */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    private static final UnitTranscoder<?> PlaceComponentResult = new UnitTranscoder<>();

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<Z> BuiltInFictitiousFunctionClassFactory(Resource<Z> resource, Options options) {
        return resource;
    }

    public static <Z> ResourceTranscoder<Z, Z> BuiltInFictitiousFunctionClassFactory() {
        return PlaceComponentResult;
    }
}
