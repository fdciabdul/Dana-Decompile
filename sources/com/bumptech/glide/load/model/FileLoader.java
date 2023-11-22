package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class FileLoader<Data> implements ModelLoader<File, Data> {
    private final FileOpener<Data> BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes3.dex */
    public interface FileOpener<Data> {
        Class<Data> getAuthRequestContext();

        Data getAuthRequestContext(File file) throws FileNotFoundException;

        void getAuthRequestContext(Data data) throws IOException;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(File file, int i, int i2, Options options) {
        File file2 = file;
        return new ModelLoader.LoadData(new ObjectKey(file2), new FileFetcher(file2, this.BuiltInFictitiousFunctionClassFactory));
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.BuiltInFictitiousFunctionClassFactory = fileOpener;
    }

    /* loaded from: classes3.dex */
    static final class FileFetcher<Data> implements DataFetcher<Data> {
        private final FileOpener<Data> BuiltInFictitiousFunctionClassFactory;
        private final File KClassImpl$Data$declaredNonStaticMembers$2;
        private Data PlaceComponentResult;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        FileFetcher(File file, FileOpener<Data> fileOpener) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = file;
            this.BuiltInFictitiousFunctionClassFactory = fileOpener;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.PlaceComponentResult = authRequestContext;
                dataCallback.getAuthRequestContext(authRequestContext);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    InstrumentInjector.log_d("FileLoader", "Failed to open file", e);
                }
                dataCallback.BuiltInFictitiousFunctionClassFactory(e);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            Data data = this.PlaceComponentResult;
            if (data != null) {
                try {
                    this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext((FileOpener<Data>) data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<Data> getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes3.dex */
    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {
        private final FileOpener<Data> BuiltInFictitiousFunctionClassFactory;

        public Factory(FileOpener<Data> fileOpener) {
            this.BuiltInFictitiousFunctionClassFactory = fileOpener;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<File, Data> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* loaded from: classes3.dex */
    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new FileOpener<InputStream>() { // from class: com.bumptech.glide.load.model.FileLoader.StreamFactory.1
                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public final /* synthetic */ void getAuthRequestContext(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public final Class<InputStream> getAuthRequestContext() {
                    return InputStream.class;
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public final /* synthetic */ InputStream getAuthRequestContext(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new FileOpener<ParcelFileDescriptor>() { // from class: com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.1
                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public final /* synthetic */ void getAuthRequestContext(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public final Class<ParcelFileDescriptor> getAuthRequestContext() {
                    return ParcelFileDescriptor.class;
                }

                @Override // com.bumptech.glide.load.model.FileLoader.FileOpener
                public final /* synthetic */ ParcelFileDescriptor getAuthRequestContext(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, SQLiteDatabase.CREATE_IF_NECESSARY);
                }
            });
        }
    }
}
