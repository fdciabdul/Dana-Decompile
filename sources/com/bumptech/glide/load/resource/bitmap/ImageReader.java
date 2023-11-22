package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes3.dex */
interface ImageReader {
    ImageHeaderParser.ImageType BuiltInFictitiousFunctionClassFactory() throws IOException;

    int KClassImpl$Data$declaredNonStaticMembers$2() throws IOException;

    Bitmap KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.Options options) throws IOException;

    void getAuthRequestContext();

    /* loaded from: classes3.dex */
    public static final class InputStreamImageReader implements ImageReader {
        private final InputStreamRewinder BuiltInFictitiousFunctionClassFactory;
        private final List<ImageHeaderParser> KClassImpl$Data$declaredNonStaticMembers$2;
        private final ArrayPool PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.PlaceComponentResult = (ArrayPool) Preconditions.PlaceComponentResult(arrayPool);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (List) Preconditions.PlaceComponentResult(list);
            this.BuiltInFictitiousFunctionClassFactory = new InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.Options options) throws IOException {
            InputStreamRewinder inputStreamRewinder = this.BuiltInFictitiousFunctionClassFactory;
            inputStreamRewinder.MyBillsEntityDataFactory.reset();
            return BitmapFactory.decodeStream(inputStreamRewinder.MyBillsEntityDataFactory, null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final ImageHeaderParser.ImageType BuiltInFictitiousFunctionClassFactory() throws IOException {
            List<ImageHeaderParser> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            InputStreamRewinder inputStreamRewinder = this.BuiltInFictitiousFunctionClassFactory;
            inputStreamRewinder.MyBillsEntityDataFactory.reset();
            return ImageHeaderParserUtils.getAuthRequestContext(list, inputStreamRewinder.MyBillsEntityDataFactory, this.PlaceComponentResult);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final int KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            List<ImageHeaderParser> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            InputStreamRewinder inputStreamRewinder = this.BuiltInFictitiousFunctionClassFactory;
            inputStreamRewinder.MyBillsEntityDataFactory.reset();
            return ImageHeaderParserUtils.KClassImpl$Data$declaredNonStaticMembers$2(list, inputStreamRewinder.MyBillsEntityDataFactory, this.PlaceComponentResult);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final void getAuthRequestContext() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            synchronized (recyclableBufferedInputStream) {
                recyclableBufferedInputStream.getAuthRequestContext = recyclableBufferedInputStream.KClassImpl$Data$declaredNonStaticMembers$2.length;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        private final ParcelFileDescriptorRewinder KClassImpl$Data$declaredNonStaticMembers$2;
        private final ArrayPool PlaceComponentResult;
        private final List<ImageHeaderParser> getAuthRequestContext;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final void getAuthRequestContext() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            this.PlaceComponentResult = (ArrayPool) Preconditions.PlaceComponentResult(arrayPool);
            this.getAuthRequestContext = (List) Preconditions.PlaceComponentResult(list);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.rewind().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final ImageHeaderParser.ImageType BuiltInFictitiousFunctionClassFactory() throws IOException {
            return ImageHeaderParserUtils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public final int KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            int MyBillsEntityDataFactory;
            MyBillsEntityDataFactory = ImageHeaderParserUtils.MyBillsEntityDataFactory(this.getAuthRequestContext, new ImageHeaderParserUtils.OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
                @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
                public final int BuiltInFictitiousFunctionClassFactory(ImageHeaderParser imageHeaderParser) throws IOException {
                    RecyclableBufferedInputStream recyclableBufferedInputStream;
                    try {
                        recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(r1.getAuthRequestContext.rewind().getFileDescriptor()), r2);
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = null;
                    }
                    try {
                        int MyBillsEntityDataFactory2 = imageHeaderParser.MyBillsEntityDataFactory(recyclableBufferedInputStream, r2);
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                        r1.getAuthRequestContext.rewind();
                        return MyBillsEntityDataFactory2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        r1.getAuthRequestContext.rewind();
                        throw th;
                    }
                }
            });
            return MyBillsEntityDataFactory;
        }
    }
}
