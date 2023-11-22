package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {
    private final Converter<Data> MyBillsEntityDataFactory;

    /* loaded from: classes3.dex */
    public interface Converter<Data> {
        Class<Data> KClassImpl$Data$declaredNonStaticMembers$2();

        Data PlaceComponentResult(byte[] bArr);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i, int i2, Options options) {
        byte[] bArr2 = bArr;
        return new ModelLoader.LoadData(new ObjectKey(bArr2), new Fetcher(bArr2, this.MyBillsEntityDataFactory));
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.MyBillsEntityDataFactory = converter;
    }

    /* loaded from: classes3.dex */
    static class Fetcher<Data> implements DataFetcher<Data> {
        private final Converter<Data> BuiltInFictitiousFunctionClassFactory;
        private final byte[] getAuthRequestContext;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        Fetcher(byte[] bArr, Converter<Data> converter) {
            this.getAuthRequestContext = bArr;
            this.BuiltInFictitiousFunctionClassFactory = converter;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.getAuthRequestContext((Data) this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.getAuthRequestContext));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<Data> getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes3.dex */
    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<byte[], ByteBuffer> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() { // from class: com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory.1
                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public final Class<ByteBuffer> KClassImpl$Data$declaredNonStaticMembers$2() {
                    return ByteBuffer.class;
                }

                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public final /* synthetic */ ByteBuffer PlaceComponentResult(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<byte[], InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() { // from class: com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory.1
                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public final Class<InputStream> KClassImpl$Data$declaredNonStaticMembers$2() {
                    return InputStream.class;
                }

                @Override // com.bumptech.glide.load.model.ByteArrayLoader.Converter
                public final /* synthetic */ InputStream PlaceComponentResult(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }
    }
}
