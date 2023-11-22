package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    @Override // com.bumptech.glide.load.Encoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, File file, Options options) {
        return getAuthRequestContext((Resource) obj, file);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy KClassImpl$Data$declaredNonStaticMembers$2(Options options) {
        return EncodeStrategy.SOURCE;
    }

    private static boolean getAuthRequestContext(Resource<GifDrawable> resource, File file) {
        try {
            ByteBufferUtil.MyBillsEntityDataFactory(resource.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                InstrumentInjector.log_w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
