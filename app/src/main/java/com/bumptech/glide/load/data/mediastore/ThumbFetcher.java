package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes3.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    private final ThumbnailStreamOpener BuiltInFictitiousFunctionClassFactory;
    private final Uri KClassImpl$Data$declaredNonStaticMembers$2;
    private InputStream MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    public static ThumbFetcher PlaceComponentResult(Context context, Uri uri) {
        return KClassImpl$Data$declaredNonStaticMembers$2(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher BuiltInFictitiousFunctionClassFactory(Context context, Uri uri) {
        return KClassImpl$Data$declaredNonStaticMembers$2(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private static ThumbFetcher KClassImpl$Data$declaredNonStaticMembers$2(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        ArrayPool arrayPool = Glide.BuiltInFictitiousFunctionClassFactory(context).PlaceComponentResult;
        List<ImageHeaderParser> KClassImpl$Data$declaredNonStaticMembers$2 = Glide.BuiltInFictitiousFunctionClassFactory(context).NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        if (!KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            return new ThumbFetcher(uri, new ThumbnailStreamOpener(KClassImpl$Data$declaredNonStaticMembers$2, thumbnailQuery, arrayPool, context.getContentResolver()));
        }
        throw new Registry.NoImageHeaderParserException();
    }

    private ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uri;
        this.BuiltInFictitiousFunctionClassFactory = thumbnailStreamOpener;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        InputStream inputStream = this.MyBillsEntityDataFactory;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<InputStream> getAuthRequestContext() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource MyBillsEntityDataFactory() {
        return DataSource.LOCAL;
    }

    /* loaded from: classes3.dex */
    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PlaceComponentResult = {"_data"};
        private final ContentResolver MyBillsEntityDataFactory;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.MyBillsEntityDataFactory = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public final Cursor BuiltInFictitiousFunctionClassFactory(Uri uri) {
            return this.MyBillsEntityDataFactory.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PlaceComponentResult, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes3.dex */
    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] KClassImpl$Data$declaredNonStaticMembers$2 = {"_data"};
        private final ContentResolver MyBillsEntityDataFactory;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.MyBillsEntityDataFactory = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public final Cursor BuiltInFictitiousFunctionClassFactory(Uri uri) {
            return this.MyBillsEntityDataFactory.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, KClassImpl$Data$declaredNonStaticMembers$2, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        try {
            InputStream KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
            int authRequestContext = KClassImpl$Data$declaredNonStaticMembers$2 != null ? this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2) : -1;
            if (authRequestContext != -1) {
                KClassImpl$Data$declaredNonStaticMembers$2 = new ExifOrientationStream(KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext);
            }
            this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2;
            dataCallback.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                InstrumentInjector.log_d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            dataCallback.BuiltInFictitiousFunctionClassFactory(e);
        }
    }
}
