package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private final String BuiltInFictitiousFunctionClassFactory;
    private T PlaceComponentResult;
    private final AssetManager getAuthRequestContext;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(T t) throws IOException;

    protected abstract T MyBillsEntityDataFactory(AssetManager assetManager, String str) throws IOException;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.getAuthRequestContext = assetManager;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T MyBillsEntityDataFactory = MyBillsEntityDataFactory(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
            this.PlaceComponentResult = MyBillsEntityDataFactory;
            dataCallback.getAuthRequestContext(MyBillsEntityDataFactory);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                InstrumentInjector.log_d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.BuiltInFictitiousFunctionClassFactory(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        T t = this.PlaceComponentResult;
        if (t == null) {
            return;
        }
        try {
            KClassImpl$Data$declaredNonStaticMembers$2(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource MyBillsEntityDataFactory() {
        return DataSource.LOCAL;
    }
}
