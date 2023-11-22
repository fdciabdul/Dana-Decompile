package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private T BuiltInFictitiousFunctionClassFactory;
    private final ContentResolver MyBillsEntityDataFactory;
    private final Uri getAuthRequestContext;

    protected abstract T BuiltInFictitiousFunctionClassFactory(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    protected abstract void MyBillsEntityDataFactory(T t) throws IOException;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.MyBillsEntityDataFactory = contentResolver;
        this.getAuthRequestContext = uri;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
            dataCallback.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                InstrumentInjector.log_d("LocalUriFetcher", "Failed to open Uri", e);
            }
            dataCallback.BuiltInFictitiousFunctionClassFactory(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        T t = this.BuiltInFictitiousFunctionClassFactory;
        if (t != null) {
            try {
                MyBillsEntityDataFactory(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource MyBillsEntityDataFactory() {
        return DataSource.LOCAL;
    }
}
