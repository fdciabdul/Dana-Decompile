package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public final class ImageHeaderParserUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface OrientationReader {
        int BuiltInFictitiousFunctionClassFactory(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface TypeReader {
        ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$2(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static ImageHeaderParser.ImageType getAuthRequestContext(List<ImageHeaderParser> list, final InputStream inputStream, ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return MyBillsEntityDataFactory(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public final ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$2(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.PlaceComponentResult(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType MyBillsEntityDataFactory(List<ImageHeaderParser> list, final ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return MyBillsEntityDataFactory(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public final ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$2(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.PlaceComponentResult(byteBuffer);
            }
        });
    }

    public static ImageHeaderParser.ImageType BuiltInFictitiousFunctionClassFactory(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final ArrayPool arrayPool) throws IOException {
        return MyBillsEntityDataFactory(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public final ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$2(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.getAuthRequestContext.rewind().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                    recyclableBufferedInputStream = null;
                }
                try {
                    ImageHeaderParser.ImageType PlaceComponentResult = imageHeaderParser.PlaceComponentResult(recyclableBufferedInputStream);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    ParcelFileDescriptorRewinder.this.getAuthRequestContext.rewind();
                    return PlaceComponentResult;
                } catch (Throwable th2) {
                    th = th2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    ParcelFileDescriptorRewinder.this.getAuthRequestContext.rewind();
                    throw th;
                }
            }
        });
    }

    private static ImageHeaderParser.ImageType MyBillsEntityDataFactory(List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType KClassImpl$Data$declaredNonStaticMembers$2 = typeReader.KClassImpl$Data$declaredNonStaticMembers$2(list.get(i));
            if (KClassImpl$Data$declaredNonStaticMembers$2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(List<ImageHeaderParser> list, final InputStream inputStream, final ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(5242880);
        return MyBillsEntityDataFactory(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public final int BuiltInFictitiousFunctionClassFactory(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.MyBillsEntityDataFactory(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int MyBillsEntityDataFactory(List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int BuiltInFictitiousFunctionClassFactory = orientationReader.BuiltInFictitiousFunctionClassFactory(list.get(i));
            if (BuiltInFictitiousFunctionClassFactory != -1) {
                return BuiltInFictitiousFunctionClassFactory;
            }
        }
        return -1;
    }
}
