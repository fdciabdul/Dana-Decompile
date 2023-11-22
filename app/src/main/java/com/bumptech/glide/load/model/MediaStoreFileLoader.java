package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes3.dex */
public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    private final Context BuiltInFictitiousFunctionClassFactory;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return MyBillsEntityDataFactory(uri);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* synthetic */ ModelLoader.LoadData<File> KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, int i, int i2, Options options) {
        Uri uri2 = uri;
        return new ModelLoader.LoadData<>(new ObjectKey(uri2), new FilePathFetcher(this.BuiltInFictitiousFunctionClassFactory, uri2));
    }

    public MediaStoreFileLoader(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    private static boolean MyBillsEntityDataFactory(Uri uri) {
        return MediaStoreUtil.getAuthRequestContext(uri);
    }

    /* loaded from: classes3.dex */
    static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] getAuthRequestContext = {"_data"};
        private final Uri BuiltInFictitiousFunctionClassFactory;
        private final Context PlaceComponentResult;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        FilePathFetcher(Context context, Uri uri) {
            this.PlaceComponentResult = context;
            this.BuiltInFictitiousFunctionClassFactory = uri;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.PlaceComponentResult.getContentResolver().query(this.BuiltInFictitiousFunctionClassFactory, getAuthRequestContext, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find file path for: ");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                dataCallback.BuiltInFictitiousFunctionClassFactory(new FileNotFoundException(sb.toString()));
                return;
            }
            dataCallback.getAuthRequestContext(new File(r0));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final Class<File> getAuthRequestContext() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public final DataSource MyBillsEntityDataFactory() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        private final Context KClassImpl$Data$declaredNonStaticMembers$2;

        public Factory(Context context) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<Uri, File> PlaceComponentResult(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
