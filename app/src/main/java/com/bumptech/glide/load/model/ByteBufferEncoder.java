package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    @Override // com.bumptech.glide.load.Encoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer, File file, Options options) {
        return PlaceComponentResult(byteBuffer, file);
    }

    private static boolean PlaceComponentResult(ByteBuffer byteBuffer, File file) {
        try {
            ByteBufferUtil.MyBillsEntityDataFactory(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                InstrumentInjector.log_d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
