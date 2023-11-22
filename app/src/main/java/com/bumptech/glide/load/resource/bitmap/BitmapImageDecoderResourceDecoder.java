package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private final BitmapPool BuiltInFictitiousFunctionClassFactory = new BitmapPoolAdapter();

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public final Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Decoded [");
            sb.append(decodeBitmap.getWidth());
            sb.append("x");
            sb.append(decodeBitmap.getHeight());
            sb.append("] for [");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("]");
            InstrumentInjector.log_v("BitmapImageDecoder", sb.toString());
        }
        return new BitmapResource(decodeBitmap, this.BuiltInFictitiousFunctionClassFactory);
    }
}
