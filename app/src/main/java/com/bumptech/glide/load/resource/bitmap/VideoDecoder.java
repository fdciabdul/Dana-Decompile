package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private final BitmapPool BuiltInFictitiousFunctionClassFactory;
    private final MediaMetadataRetrieverFactory PlaceComponentResult;
    private final MediaMetadataRetrieverInitializer<T> moveToNextValue;
    public static final Option<Long> getAuthRequestContext = Option.getAuthRequestContext("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1
        private final ByteBuffer BuiltInFictitiousFunctionClassFactory = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, Long l, MessageDigest messageDigest) {
            Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.BuiltInFictitiousFunctionClassFactory) {
                this.BuiltInFictitiousFunctionClassFactory.position(0);
                messageDigest.update(this.BuiltInFictitiousFunctionClassFactory.putLong(l2.longValue()).array());
            }
        }
    });
    public static final Option<Integer> MyBillsEntityDataFactory = Option.getAuthRequestContext("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2
        private final ByteBuffer BuiltInFictitiousFunctionClassFactory = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, Integer num, MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 != null) {
                messageDigest.update(bArr);
                synchronized (this.BuiltInFictitiousFunctionClassFactory) {
                    this.BuiltInFictitiousFunctionClassFactory.position(0);
                    messageDigest.update(this.BuiltInFictitiousFunctionClassFactory.putInt(num2.intValue()).array());
                }
            }
        }
    });
    private static final MediaMetadataRetrieverFactory KClassImpl$Data$declaredNonStaticMembers$2 = new MediaMetadataRetrieverFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface MediaMetadataRetrieverInitializer<T> {
        void PlaceComponentResult(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(T t, Options options) {
        return true;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> getAuthRequestContext(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer((byte) 0));
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> MyBillsEntityDataFactory(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> KClassImpl$Data$declaredNonStaticMembers$2(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    private VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.BuiltInFictitiousFunctionClassFactory = bitmapPool;
        this.moveToNextValue = mediaMetadataRetrieverInitializer;
        this.PlaceComponentResult = mediaMetadataRetrieverFactory;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(T t, int i, int i2, Options options) throws IOException {
        Option<Long> option = getAuthRequestContext;
        long longValue = ((Long) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option) : option.PlaceComponentResult)).longValue();
        if (longValue < 0 && longValue != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            sb.append(longValue);
            throw new IllegalArgumentException(sb.toString());
        }
        Option<Integer> option2 = MyBillsEntityDataFactory;
        Integer num = (Integer) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option2) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option2) : option2.PlaceComponentResult);
        if (num == null) {
            num = 2;
        }
        Option<DownsampleStrategy> option3 = DownsampleStrategy.scheduleImpl;
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option3) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option3) : option3.PlaceComponentResult);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.getAuthRequestContext;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever MyBillsEntityDataFactory2 = MediaMetadataRetrieverFactory.MyBillsEntityDataFactory();
        try {
            this.moveToNextValue.PlaceComponentResult(MyBillsEntityDataFactory2, t);
            int intValue = num.intValue();
            Bitmap KClassImpl$Data$declaredNonStaticMembers$22 = (Build.VERSION.SDK_INT < 27 || i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || downsampleStrategy2 == DownsampleStrategy.getErrorConfigVersion) ? null : KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2, longValue, intValue, i, i2, downsampleStrategy2);
            if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                KClassImpl$Data$declaredNonStaticMembers$22 = MyBillsEntityDataFactory2.getFrameAtTime(longValue, intValue);
            }
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                MyBillsEntityDataFactory2.release();
                return BitmapResource.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22, this.BuiltInFictitiousFunctionClassFactory);
            }
            throw new VideoDecoderException();
        } catch (Throwable th) {
            MyBillsEntityDataFactory2.release();
            throw th;
        }
    }

    private static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float MyBillsEntityDataFactory2 = downsampleStrategy.MyBillsEntityDataFactory(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * MyBillsEntityDataFactory2), Math.round(MyBillsEntityDataFactory2 * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                InstrumentInjector.log_d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public static MediaMetadataRetriever MyBillsEntityDataFactory() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        /* synthetic */ AssetFileDescriptorInitializer(byte b) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public final /* synthetic */ void PlaceComponentResult(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public final /* synthetic */ void PlaceComponentResult(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        public final /* synthetic */ void PlaceComponentResult(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            final ByteBuffer byteBuffer2 = byteBuffer;
            mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j, byte[] bArr, int i, int i2) {
                    if (j >= byteBuffer2.limit()) {
                        return -1;
                    }
                    byteBuffer2.position((int) j);
                    int min = Math.min(i2, byteBuffer2.remaining());
                    byteBuffer2.get(bArr, i, min);
                    return min;
                }

                @Override // android.media.MediaDataSource
                public long getSize() {
                    return byteBuffer2.limit();
                }
            });
        }

        ByteBufferInitializer() {
        }
    }

    /* loaded from: classes3.dex */
    static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }
}
