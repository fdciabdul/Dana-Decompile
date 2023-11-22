package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class LoadPath<Data, ResourceType, Transcode> {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Class<Data> PlaceComponentResult;
    private final Pools.Pool<List<Throwable>> getAuthRequestContext;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.PlaceComponentResult = cls;
        this.getAuthRequestContext = pool;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (List) Preconditions.getAuthRequestContext(list);
        StringBuilder sb = new StringBuilder();
        sb.append("Failed LoadPath{");
        sb.append(cls.getSimpleName());
        sb.append("->");
        sb.append(cls2.getSimpleName());
        sb.append("->");
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.BuiltInFictitiousFunctionClassFactory = sb.toString();
    }

    public final Resource<Transcode> getAuthRequestContext(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List<Throwable> list = (List) Preconditions.PlaceComponentResult(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
        try {
            return BuiltInFictitiousFunctionClassFactory(dataRewinder, options, i, i2, decodeCallback, list);
        } finally {
            this.getAuthRequestContext.MyBillsEntityDataFactory(list);
        }
    }

    private Resource<Transcode> BuiltInFictitiousFunctionClassFactory(DataRewinder<Data> dataRewinder, Options options, int i, int i2, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        Resource<Transcode> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            DecodePath<Data, ResourceType, Transcode> decodePath = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i3);
            try {
                resource = decodePath.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(decodeCallback.BuiltInFictitiousFunctionClassFactory(decodePath.BuiltInFictitiousFunctionClassFactory(dataRewinder, i, i2, options)), options);
            } catch (GlideException e) {
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.BuiltInFictitiousFunctionClassFactory, new ArrayList(list));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        sb.append(Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
