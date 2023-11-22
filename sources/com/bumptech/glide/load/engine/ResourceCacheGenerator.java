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
public class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private volatile ModelLoader.LoadData<?> BuiltInFictitiousFunctionClassFactory;
    private ResourceCacheKey KClassImpl$Data$declaredNonStaticMembers$2;
    private File MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private final DataFetcherGenerator.FetcherReadyCallback PlaceComponentResult;
    private final DecodeHelper<?> getAuthRequestContext;
    private int getErrorConfigVersion;
    private Key lookAheadTest;
    private int moveToNextValue;
    private List<ModelLoader<File, ?>> scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.getAuthRequestContext = decodeHelper;
        this.PlaceComponentResult = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final boolean getAuthRequestContext() {
        List<Key> KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        boolean z = false;
        if (KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            return false;
        }
        DecodeHelper<?> decodeHelper = this.getAuthRequestContext;
        List<Class<?>> BuiltInFictitiousFunctionClassFactory = decodeHelper.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(decodeHelper.NetworkUserEntityData$$ExternalSyntheticLambda0.getClass(), decodeHelper.getErrorConfigVersion, decodeHelper.initRecordTimeStamp);
        if (BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            if (File.class.equals(this.getAuthRequestContext.initRecordTimeStamp)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any load path from ");
            sb.append(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0.getClass());
            sb.append(" to ");
            sb.append(this.getAuthRequestContext.initRecordTimeStamp);
            throw new IllegalStateException(sb.toString());
        }
        while (true) {
            if (this.scheduleImpl == null || !KClassImpl$Data$declaredNonStaticMembers$2()) {
                int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                if (i >= BuiltInFictitiousFunctionClassFactory.size()) {
                    int i2 = this.moveToNextValue + 1;
                    this.moveToNextValue = i2;
                    if (i2 >= KClassImpl$Data$declaredNonStaticMembers$2.size()) {
                        return false;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
                }
                Key key = KClassImpl$Data$declaredNonStaticMembers$2.get(this.moveToNextValue);
                Class<?> cls = BuiltInFictitiousFunctionClassFactory.get(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new ResourceCacheKey(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, key, this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1, this.getAuthRequestContext.GetContactSyncConfig, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext.getAuthRequestContext(cls), cls, this.getAuthRequestContext.lookAheadTest);
                File authRequestContext = this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.MyBillsEntityDataFactory = authRequestContext;
                if (authRequestContext != null) {
                    this.lookAheadTest = key;
                    this.scheduleImpl = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
                    this.getErrorConfigVersion = 0;
                }
            } else {
                this.BuiltInFictitiousFunctionClassFactory = null;
                while (!z && KClassImpl$Data$declaredNonStaticMembers$2()) {
                    List<ModelLoader<File, ?>> list = this.scheduleImpl;
                    int i3 = this.getErrorConfigVersion;
                    this.getErrorConfigVersion = i3 + 1;
                    this.BuiltInFictitiousFunctionClassFactory = list.get(i3).KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, this.getAuthRequestContext.GetContactSyncConfig, this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext.lookAheadTest);
                    if (this.BuiltInFictitiousFunctionClassFactory != null && this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext())) {
                        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.scheduleImpl, this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion < this.scheduleImpl.size();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public final void BuiltInFictitiousFunctionClassFactory() {
        ModelLoader.LoadData<?> loadData = this.BuiltInFictitiousFunctionClassFactory;
        if (loadData != null) {
            loadData.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void getAuthRequestContext(Object obj) {
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, obj, this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, DataSource.RESOURCE_DISK_CACHE, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
    public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
        this.PlaceComponentResult.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, exc, this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, DataSource.RESOURCE_DISK_CACHE);
    }
}
