package com.bumptech.glide.load.model;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final DataDecoder<Data> BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes3.dex */
    public interface DataDecoder<Data> {
        Class<Data> KClassImpl$Data$declaredNonStaticMembers$2();

        Data MyBillsEntityDataFactory(String str) throws IllegalArgumentException;

        void PlaceComponentResult(Data data) throws IOException;
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.BuiltInFictitiousFunctionClassFactory = dataDecoder;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<Data> KClassImpl$Data$declaredNonStaticMembers$2(Model model, int i, int i2, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.BuiltInFictitiousFunctionClassFactory));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final boolean BuiltInFictitiousFunctionClassFactory(Model model) {
        return model.toString().startsWith("data:image");
    }

    /* loaded from: classes3.dex */
    static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        private final DataDecoder<Data> KClassImpl$Data$declaredNonStaticMembers$2;
        private final String MyBillsEntityDataFactory;
        private Data PlaceComponentResult;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dataDecoder;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                this.PlaceComponentResult = MyBillsEntityDataFactory;
                dataCallback.getAuthRequestContext(MyBillsEntityDataFactory);
            } catch (IllegalArgumentException e) {
                dataCallback.BuiltInFictitiousFunctionClassFactory(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.PlaceComponentResult);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<Data> getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes3.dex */
    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {
        private final DataDecoder<InputStream> getAuthRequestContext = new DataDecoder<InputStream>() { // from class: com.bumptech.glide.load.model.DataUrlLoader.StreamFactory.1
            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public final /* synthetic */ void PlaceComponentResult(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public final Class<InputStream> KClassImpl$Data$declaredNonStaticMembers$2() {
                return InputStream.class;
            }

            @Override // com.bumptech.glide.load.model.DataUrlLoader.DataDecoder
            public final /* synthetic */ InputStream MyBillsEntityDataFactory(String str) throws IllegalArgumentException {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (!str.substring(0, indexOf).endsWith(";base64")) {
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
                return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
            }
        };

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Model, InputStream> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.getAuthRequestContext);
        }
    }
}
