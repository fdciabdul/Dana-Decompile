package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes3.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private final List<ImageHeaderParser> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ArrayPool MyBillsEntityDataFactory;
    private final ResourceDecoder<ByteBuffer, GifDrawable> getAuthRequestContext;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<GifDrawable> BuiltInFictitiousFunctionClassFactory(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(inputStream);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        return this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(ByteBuffer.wrap(BuiltInFictitiousFunctionClassFactory), i, i2, options);
    }

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.getAuthRequestContext = resourceDecoder;
        this.MyBillsEntityDataFactory = arrayPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, Options options) throws IOException {
        Option<Boolean> option = GifOptions.getAuthRequestContext;
        return !((Boolean) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option) : option.PlaceComponentResult)).booleanValue() && ImageHeaderParserUtils.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, inputStream, this.MyBillsEntityDataFactory) == ImageHeaderParser.ImageType.GIF;
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                InstrumentInjector.log_w("StreamGifDecoder", "Error reading data from stream", e);
                return null;
            }
            return null;
        }
    }
}
