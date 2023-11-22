package com.bumptech.glide;

import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideExperiments;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class GlideBuilder {
    ArrayPool BuiltInFictitiousFunctionClassFactory;
    MemorySizeCalculator DatabaseTableConfigUtil;
    boolean GetContactSyncConfig;
    GlideExecutor KClassImpl$Data$declaredNonStaticMembers$2;
    ConnectivityMonitorFactory MyBillsEntityDataFactory;
    MemoryCache NetworkUserEntityData$$ExternalSyntheticLambda1;
    RequestManagerRetriever.RequestManagerFactory NetworkUserEntityData$$ExternalSyntheticLambda7;
    List<RequestListener<Object>> PlaceComponentResult;
    BitmapPool getAuthRequestContext;
    Engine getErrorConfigVersion;
    GlideExecutor moveToNextValue;
    GlideExecutor newProxyInstance;
    DiskCache.Factory scheduleImpl;
    final Map<Class<?>, TransitionOptions<?, ?>> lookAheadTest = new ArrayMap();
    final GlideExperiments.Builder NetworkUserEntityData$$ExternalSyntheticLambda2 = new GlideExperiments.Builder();
    int initRecordTimeStamp = 4;
    Glide.RequestOptionsFactory NetworkUserEntityData$$ExternalSyntheticLambda0 = new Glide.RequestOptionsFactory() { // from class: com.bumptech.glide.GlideBuilder.1
        {
            GlideBuilder.this = this;
        }

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        public final RequestOptions PlaceComponentResult() {
            return new RequestOptions();
        }
    };

    /* loaded from: classes3.dex */
    public static final class LogRequestOrigins implements GlideExperiments.Experiment {
    }

    /* loaded from: classes7.dex */
    static final class ManualOverrideHardwareBitmapMaxFdCount implements GlideExperiments.Experiment {
    }

    /* renamed from: com.bumptech.glide.GlideBuilder$2 */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Glide.RequestOptionsFactory {
        final /* synthetic */ RequestOptions MyBillsEntityDataFactory;

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        public final RequestOptions PlaceComponentResult() {
            RequestOptions requestOptions = this.MyBillsEntityDataFactory;
            return requestOptions == null ? new RequestOptions() : requestOptions;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WaitForFramesAfterTrimMemory implements GlideExperiments.Experiment {
        private WaitForFramesAfterTrimMemory() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnableImageDecoderForBitmaps implements GlideExperiments.Experiment {
        EnableImageDecoderForBitmaps() {
        }
    }
}
