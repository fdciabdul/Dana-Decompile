package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {
    private final ModelLoader<Uri, DataT> BuiltInFictitiousFunctionClassFactory;
    private final Context MyBillsEntityDataFactory;
    private final Class<DataT> PlaceComponentResult;
    private final ModelLoader<File, DataT> getAuthRequestContext;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return getAuthRequestContext(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        Uri uri2 = uri;
        return new ModelLoader.LoadData(new ObjectKey(uri2), new QMediaStoreUriFetcher(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, uri2, i, i2, options, this.PlaceComponentResult));
    }

    QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.MyBillsEntityDataFactory = context.getApplicationContext();
        this.getAuthRequestContext = modelLoader;
        this.BuiltInFictitiousFunctionClassFactory = modelLoader2;
        this.PlaceComponentResult = cls;
    }

    private static boolean getAuthRequestContext(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.getAuthRequestContext(uri);
    }

    /* loaded from: classes3.dex */
    static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
        private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {"_data"};
        private final Context BuiltInFictitiousFunctionClassFactory;
        private volatile DataFetcher<DataT> MyBillsEntityDataFactory;
        private volatile boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final Class<DataT> PlaceComponentResult;
        private final ModelLoader<File, DataT> getAuthRequestContext;
        private final Options getErrorConfigVersion;
        private final int initRecordTimeStamp;
        private final ModelLoader<Uri, DataT> lookAheadTest;
        private final int moveToNextValue;
        private final Uri scheduleImpl;

        QMediaStoreUriFetcher(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i, int i2, Options options, Class<DataT> cls) {
            this.BuiltInFictitiousFunctionClassFactory = context.getApplicationContext();
            this.getAuthRequestContext = modelLoader;
            this.lookAheadTest = modelLoader2;
            this.scheduleImpl = uri;
            this.initRecordTimeStamp = i;
            this.moveToNextValue = i2;
            this.getErrorConfigVersion = options;
            this.PlaceComponentResult = cls;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            DataFetcher<DataT> dataFetcher = this.MyBillsEntityDataFactory;
            if (dataFetcher != null) {
                dataFetcher.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            DataFetcher<DataT> dataFetcher = this.MyBillsEntityDataFactory;
            if (dataFetcher != null) {
                dataFetcher.BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<DataT> getAuthRequestContext() {
            return this.PlaceComponentResult;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }

        private File MyBillsEntityDataFactory(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = this.BuiltInFictitiousFunctionClassFactory.getContentResolver().query(uri, KClassImpl$Data$declaredNonStaticMembers$2, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to media store entry for: ");
                    sb.append(uri);
                    throw new FileNotFoundException(sb.toString());
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("File path was empty in media store for: ");
                    sb2.append(uri);
                    throw new FileNotFoundException(sb2.toString());
                }
                File file = new File(string);
                if (query != null) {
                    query.close();
                }
                return file;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        private boolean PlaceComponentResult() {
            return this.BuiltInFictitiousFunctionClassFactory.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super DataT> dataCallback) {
            ModelLoader.LoadData<DataT> KClassImpl$Data$declaredNonStaticMembers$22;
            try {
                if (Environment.isExternalStorageLegacy()) {
                    KClassImpl$Data$declaredNonStaticMembers$22 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(this.scheduleImpl), this.initRecordTimeStamp, this.moveToNextValue, this.getErrorConfigVersion);
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$22 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult() ? MediaStore.setRequireOriginal(this.scheduleImpl) : this.scheduleImpl, this.initRecordTimeStamp, this.moveToNextValue, this.getErrorConfigVersion);
                }
                DataFetcher<DataT> dataFetcher = KClassImpl$Data$declaredNonStaticMembers$22 != null ? KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory : null;
                if (dataFetcher == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to build fetcher for: ");
                    sb.append(this.scheduleImpl);
                    dataCallback.BuiltInFictitiousFunctionClassFactory(new IllegalArgumentException(sb.toString()));
                    return;
                }
                this.MyBillsEntityDataFactory = dataFetcher;
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    dataFetcher.BuiltInFictitiousFunctionClassFactory(priority, dataCallback);
                    return;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                DataFetcher<DataT> dataFetcher2 = this.MyBillsEntityDataFactory;
                if (dataFetcher2 != null) {
                    dataFetcher2.BuiltInFictitiousFunctionClassFactory();
                }
            } catch (FileNotFoundException e) {
                dataCallback.BuiltInFictitiousFunctionClassFactory(e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    /* loaded from: classes3.dex */
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* loaded from: classes3.dex */
    static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {
        private final Context KClassImpl$Data$declaredNonStaticMembers$2;
        private final Class<DataT> MyBillsEntityDataFactory;

        Factory(Context context, Class<DataT> cls) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            this.MyBillsEntityDataFactory = cls;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, DataT> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.KClassImpl$Data$declaredNonStaticMembers$2, multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(File.class, this.MyBillsEntityDataFactory), multiModelLoaderFactory.BuiltInFictitiousFunctionClassFactory(Uri.class, this.MyBillsEntityDataFactory), this.MyBillsEntityDataFactory);
        }
    }
}
