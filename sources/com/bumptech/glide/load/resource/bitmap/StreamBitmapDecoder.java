package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes3.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool BuiltInFictitiousFunctionClassFactory;
    private final Downsampler MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, Options options) throws IOException {
        return PlaceComponentResult();
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.MyBillsEntityDataFactory = downsampler;
        this.BuiltInFictitiousFunctionClassFactory = arrayPool;
    }

    private boolean PlaceComponentResult() {
        return Downsampler.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(InputStream inputStream, int i, int i2, Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.BuiltInFictitiousFunctionClassFactory);
            z = true;
        }
        ExceptionPassthroughInputStream authRequestContext = ExceptionPassthroughInputStream.getAuthRequestContext(recyclableBufferedInputStream);
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream(authRequestContext);
        UntrustedCallbacks untrustedCallbacks = new UntrustedCallbacks(recyclableBufferedInputStream, authRequestContext);
        try {
            Downsampler downsampler = this.MyBillsEntityDataFactory;
            Resource<Bitmap> PlaceComponentResult = downsampler.PlaceComponentResult(new ImageReader.InputStreamImageReader(markEnforcingInputStream, downsampler.getErrorConfigVersion, downsampler.scheduleImpl), i, i2, options, untrustedCallbacks);
            authRequestContext.MyBillsEntityDataFactory = null;
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            Queue<ExceptionPassthroughInputStream> queue = ExceptionPassthroughInputStream.BuiltInFictitiousFunctionClassFactory;
            synchronized (queue) {
                queue.offer(authRequestContext);
            }
            if (z) {
                recyclableBufferedInputStream.BuiltInFictitiousFunctionClassFactory();
            }
            return PlaceComponentResult;
        } catch (Throwable th) {
            authRequestContext.MyBillsEntityDataFactory = null;
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            Queue<ExceptionPassthroughInputStream> queue2 = ExceptionPassthroughInputStream.BuiltInFictitiousFunctionClassFactory;
            synchronized (queue2) {
                queue2.offer(authRequestContext);
                if (z) {
                    recyclableBufferedInputStream.BuiltInFictitiousFunctionClassFactory();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        private final RecyclableBufferedInputStream PlaceComponentResult;
        private final ExceptionPassthroughInputStream getAuthRequestContext;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
            this.PlaceComponentResult = recyclableBufferedInputStream;
            this.getAuthRequestContext = exceptionPassthroughInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public final void getAuthRequestContext() {
            RecyclableBufferedInputStream recyclableBufferedInputStream = this.PlaceComponentResult;
            synchronized (recyclableBufferedInputStream) {
                recyclableBufferedInputStream.getAuthRequestContext = recyclableBufferedInputStream.KClassImpl$Data$declaredNonStaticMembers$2.length;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public final void PlaceComponentResult(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException iOException = this.getAuthRequestContext.MyBillsEntityDataFactory;
            if (iOException != null) {
                if (bitmap != null) {
                    bitmapPool.PlaceComponentResult(bitmap);
                    throw iOException;
                }
                throw iOException;
            }
        }
    }
}
