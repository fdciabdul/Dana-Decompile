package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData<ByteBuffer> KClassImpl$Data$declaredNonStaticMembers$2(File file, int i, int i2, Options options) {
        File file2 = file;
        return new ModelLoader.LoadData<>(new ObjectKey(file2), new ByteBufferFetcher(file2));
    }

    /* loaded from: classes3.dex */
    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<File, ByteBuffer> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    /* loaded from: classes3.dex */
    static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        private final File getAuthRequestContext;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        ByteBufferFetcher(File file) {
            this.getAuthRequestContext = file;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.getAuthRequestContext(ByteBufferUtil.PlaceComponentResult(this.getAuthRequestContext));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    InstrumentInjector.log_d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                dataCallback.BuiltInFictitiousFunctionClassFactory(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<ByteBuffer> getAuthRequestContext() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }
    }
}
