package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private final GifHeaderParserPool BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final GifDecoderFactory MyBillsEntityDataFactory;
    private final List<ImageHeaderParser> getErrorConfigVersion;
    private final GifBitmapProvider lookAheadTest;
    private static final GifDecoderFactory getAuthRequestContext = new GifDecoderFactory();
    private static final GifHeaderParserPool PlaceComponentResult = new GifHeaderParserPool();

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, PlaceComponentResult, getAuthRequestContext);
    }

    private ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
        this.getErrorConfigVersion = list;
        this.MyBillsEntityDataFactory = gifDecoderFactory;
        this.lookAheadTest = new GifBitmapProvider(bitmapPool, arrayPool);
        this.BuiltInFictitiousFunctionClassFactory = gifHeaderParserPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer, Options options) throws IOException {
        Option<Boolean> option = GifOptions.getAuthRequestContext;
        return !((Boolean) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option) : option.PlaceComponentResult)).booleanValue() && ImageHeaderParserUtils.MyBillsEntityDataFactory(this.getErrorConfigVersion, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public GifDrawableResource BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer, int i, int i2, Options options) {
        GifHeaderParser MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(byteBuffer);
        try {
            GifDrawableResource authRequestContext = getAuthRequestContext(byteBuffer, i, i2, MyBillsEntityDataFactory, options);
            GifHeaderParserPool gifHeaderParserPool = this.BuiltInFictitiousFunctionClassFactory;
            synchronized (gifHeaderParserPool) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory = null;
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                gifHeaderParserPool.BuiltInFictitiousFunctionClassFactory.offer(MyBillsEntityDataFactory);
            }
            return authRequestContext;
        } catch (Throwable th) {
            GifHeaderParserPool gifHeaderParserPool2 = this.BuiltInFictitiousFunctionClassFactory;
            synchronized (gifHeaderParserPool2) {
                MyBillsEntityDataFactory.MyBillsEntityDataFactory = null;
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                gifHeaderParserPool2.BuiltInFictitiousFunctionClassFactory.offer(MyBillsEntityDataFactory);
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bumptech.glide.load.resource.gif.GifDrawableResource getAuthRequestContext(java.nio.ByteBuffer r21, int r22, int r23, com.bumptech.glide.gifdecoder.GifHeaderParser r24, com.bumptech.glide.load.Options r25) {
        /*
            Method dump skipped, instructions count: 949
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.getAuthRequestContext(java.nio.ByteBuffer, int, int, com.bumptech.glide.gifdecoder.GifHeaderParser, com.bumptech.glide.load.Options):com.bumptech.glide.load.resource.gif.GifDrawableResource");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        static GifDecoder MyBillsEntityDataFactory(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class GifHeaderParserPool {
        final Queue<GifHeaderParser> BuiltInFictitiousFunctionClassFactory = Util.BuiltInFictitiousFunctionClassFactory(0);

        GifHeaderParserPool() {
        }

        final GifHeaderParser MyBillsEntityDataFactory(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            synchronized (this) {
                poll = this.BuiltInFictitiousFunctionClassFactory.poll();
                if (poll == null) {
                    poll = new GifHeaderParser();
                }
                poll.MyBillsEntityDataFactory = null;
                Arrays.fill(poll.getAuthRequestContext, (byte) 0);
                poll.KClassImpl$Data$declaredNonStaticMembers$2 = new GifHeader();
                poll.BuiltInFictitiousFunctionClassFactory = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                poll.MyBillsEntityDataFactory = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                poll.MyBillsEntityDataFactory.order(ByteOrder.LITTLE_ENDIAN);
            }
            return poll;
        }
    }
}
