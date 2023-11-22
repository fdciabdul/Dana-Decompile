package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private final Pools.Pool<List<Throwable>> BuiltInFictitiousFunctionClassFactory;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Class<DataType> MyBillsEntityDataFactory;
    final ResourceTranscoder<ResourceType, Transcode> PlaceComponentResult;
    private final String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface DecodeCallback<ResourceType> {
        Resource<ResourceType> BuiltInFictitiousFunctionClassFactory(Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.MyBillsEntityDataFactory = cls;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.PlaceComponentResult = resourceTranscoder;
        this.BuiltInFictitiousFunctionClassFactory = pool;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed DecodePath{");
        sb.append(cls.getSimpleName());
        sb.append("->");
        sb.append(cls2.getSimpleName());
        sb.append("->");
        sb.append(cls3.getSimpleName());
        sb.append("}");
        this.getAuthRequestContext = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Resource<ResourceType> BuiltInFictitiousFunctionClassFactory(DataRewinder<DataType> dataRewinder, int i, int i2, Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory());
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2(dataRewinder, i, i2, options, list);
        } finally {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(list);
        }
    }

    private Resource<ResourceType> KClassImpl$Data$declaredNonStaticMembers$2(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, List<Throwable> list) throws GlideException {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        Resource<ResourceType> resource = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i3);
            try {
                if (resourceDecoder.KClassImpl$Data$declaredNonStaticMembers$2(dataRewinder.PlaceComponentResult(), options)) {
                    resource = resourceDecoder.BuiltInFictitiousFunctionClassFactory(dataRewinder.PlaceComponentResult(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode data for ");
                    sb.append(resourceDecoder);
                    InstrumentInjector.log_v("DecodePath", sb.toString(), e);
                }
                list.add(e);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.getAuthRequestContext, new ArrayList(list));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecodePath{ dataClass=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", decoders=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", transcoder=");
        sb.append(this.PlaceComponentResult);
        sb.append('}');
        return sb.toString();
    }
}
