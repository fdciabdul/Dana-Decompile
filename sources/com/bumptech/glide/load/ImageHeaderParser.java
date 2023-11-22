package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface ImageHeaderParser {
    int MyBillsEntityDataFactory(InputStream inputStream, ArrayPool arrayPool) throws IOException;

    ImageType PlaceComponentResult(InputStream inputStream) throws IOException;

    ImageType PlaceComponentResult(ByteBuffer byteBuffer) throws IOException;

    /* loaded from: classes3.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public final boolean hasAlpha() {
            return this.hasAlpha;
        }
    }
}
