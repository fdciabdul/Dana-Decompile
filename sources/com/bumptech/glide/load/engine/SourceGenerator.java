package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    final DecodeHelper<?> BuiltInFictitiousFunctionClassFactory;
    final DataFetcherGenerator.FetcherReadyCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private volatile ModelLoader.LoadData<?> MyBillsEntityDataFactory;
    Object PlaceComponentResult;
    DataCacheKey getAuthRequestContext;
    private DataCacheGenerator lookAheadTest;
    private int moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.BuiltInFictitiousFunctionClassFactory = decodeHelper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final boolean getAuthRequestContext() {
        Object obj = this.PlaceComponentResult;
        if (obj != null) {
            this.PlaceComponentResult = null;
            long PlaceComponentResult = LogTime.PlaceComponentResult();
            try {
                Encoder KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(obj.getClass());
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    DataCacheWriter dataCacheWriter = new DataCacheWriter(KClassImpl$Data$declaredNonStaticMembers$2, obj, this.BuiltInFictitiousFunctionClassFactory.lookAheadTest);
                    this.getAuthRequestContext = new DataCacheKey(this.MyBillsEntityDataFactory.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this.getAuthRequestContext, dataCacheWriter);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Finished encoding source to cache, key: ");
                        sb.append(this.getAuthRequestContext);
                        sb.append(", data: ");
                        sb.append(obj);
                        sb.append(", encoder: ");
                        sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                        sb.append(", duration: ");
                        sb.append(LogTime.MyBillsEntityDataFactory(PlaceComponentResult));
                        InstrumentInjector.log_v("SourceGenerator", sb.toString());
                    }
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                    this.lookAheadTest = new DataCacheGenerator(Collections.singletonList(this.MyBillsEntityDataFactory.getAuthRequestContext), this.BuiltInFictitiousFunctionClassFactory, this);
                } else {
                    throw new Registry.NoSourceEncoderAvailableException(obj.getClass());
                }
            } catch (Throwable th) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                throw th;
            }
        }
        DataCacheGenerator dataCacheGenerator = this.lookAheadTest;
        if (dataCacheGenerator == null || !dataCacheGenerator.getAuthRequestContext()) {
            this.lookAheadTest = null;
            this.MyBillsEntityDataFactory = null;
            boolean z = false;
            while (!z && PlaceComponentResult()) {
                List<ModelLoader.LoadData<?>> PlaceComponentResult2 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                int i = this.moveToNextValue;
                this.moveToNextValue = i + 1;
                this.MyBillsEntityDataFactory = PlaceComponentResult2.get(i);
                if (this.MyBillsEntityDataFactory != null && (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()) || this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()))) {
                    final ModelLoader.LoadData<?> loadData = this.MyBillsEntityDataFactory;
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl, new DataFetcher.DataCallback<Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
                        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
                        public final void getAuthRequestContext(Object obj2) {
                            if (SourceGenerator.this.BuiltInFictitiousFunctionClassFactory(loadData)) {
                                SourceGenerator sourceGenerator = SourceGenerator.this;
                                ModelLoader.LoadData loadData2 = loadData;
                                DiskCacheStrategy diskCacheStrategy = sourceGenerator.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                                if (obj2 != null && diskCacheStrategy.BuiltInFictitiousFunctionClassFactory(loadData2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory())) {
                                    sourceGenerator.PlaceComponentResult = obj2;
                                    sourceGenerator.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                                    return;
                                }
                                sourceGenerator.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(loadData2.getAuthRequestContext, obj2, loadData2.BuiltInFictitiousFunctionClassFactory, loadData2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(), sourceGenerator.getAuthRequestContext);
                            }
                        }

                        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
                        public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
                            if (SourceGenerator.this.BuiltInFictitiousFunctionClassFactory(loadData)) {
                                SourceGenerator sourceGenerator = SourceGenerator.this;
                                ModelLoader.LoadData loadData2 = loadData;
                                sourceGenerator.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(sourceGenerator.getAuthRequestContext, exc, loadData2.BuiltInFictitiousFunctionClassFactory, loadData2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
                            }
                        }
                    });
                    z = true;
                }
            }
            return z;
        }
        return true;
    }

    final boolean BuiltInFictitiousFunctionClassFactory(ModelLoader.LoadData<?> loadData) {
        ModelLoader.LoadData<?> loadData2 = this.MyBillsEntityDataFactory;
        return loadData2 != null && loadData2 == loadData;
    }

    private boolean PlaceComponentResult() {
        return this.moveToNextValue < this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult().size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final void BuiltInFictitiousFunctionClassFactory() {
        ModelLoader.LoadData<?> loadData = this.MyBillsEntityDataFactory;
        if (loadData != null) {
            loadData.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void BuiltInFictitiousFunctionClassFactory(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(key, obj, dataFetcher, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void PlaceComponentResult(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(key, exc, dataFetcher, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }
}
