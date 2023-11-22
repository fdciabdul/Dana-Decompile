package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File BuiltInFictitiousFunctionClassFactory;
    private final DataFetcherGenerator.FetcherReadyCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private volatile ModelLoader.LoadData<?> MyBillsEntityDataFactory;
    private List<ModelLoader<File, ?>> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final List<Key> PlaceComponentResult;
    private final DecodeHelper<?> getAuthRequestContext;
    private Key getErrorConfigVersion;
    private int moveToNextValue;
    private int scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.KClassImpl$Data$declaredNonStaticMembers$2(), decodeHelper, fetcherReadyCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.scheduleImpl = -1;
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = decodeHelper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final boolean getAuthRequestContext() {
        while (true) {
            boolean z = false;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null || !MyBillsEntityDataFactory()) {
                int i = this.scheduleImpl + 1;
                this.scheduleImpl = i;
                if (i >= this.PlaceComponentResult.size()) {
                    return false;
                }
                Key key = this.PlaceComponentResult.get(this.scheduleImpl);
                File authRequestContext = this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(new DataCacheKey(key, this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1));
                this.BuiltInFictitiousFunctionClassFactory = authRequestContext;
                if (authRequestContext != null) {
                    this.getErrorConfigVersion = key;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
                    this.moveToNextValue = 0;
                }
            } else {
                this.MyBillsEntityDataFactory = null;
                while (!z && MyBillsEntityDataFactory()) {
                    List<ModelLoader<File, ?>> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    int i2 = this.moveToNextValue;
                    this.moveToNextValue = i2 + 1;
                    this.MyBillsEntityDataFactory = list.get(i2).KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext.GetContactSyncConfig, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext.lookAheadTest);
                    if (this.MyBillsEntityDataFactory != null && this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext())) {
                        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.scheduleImpl, this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean MyBillsEntityDataFactory() {
        return this.moveToNextValue < this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final void BuiltInFictitiousFunctionClassFactory() {
        ModelLoader.LoadData<?> loadData = this.MyBillsEntityDataFactory;
        if (loadData != null) {
            loadData.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void getAuthRequestContext(Object obj) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, obj, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, DataSource.DATA_DISK_CACHE, this.getErrorConfigVersion);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getErrorConfigVersion, exc, this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, DataSource.DATA_DISK_CACHE);
    }
}
