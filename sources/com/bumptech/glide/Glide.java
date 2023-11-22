package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.FrameWaiter;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {
    private static volatile boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static volatile Glide lookAheadTest;
    public final BitmapPool BuiltInFictitiousFunctionClassFactory;
    private final MemoryCache DatabaseTableConfigUtil;
    private final Engine GetContactSyncConfig;
    public final GlideContext MyBillsEntityDataFactory;
    public final Registry NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ArrayPool PlaceComponentResult;
    final ConnectivityMonitorFactory getAuthRequestContext;
    private final RequestOptionsFactory initRecordTimeStamp;
    public final RequestManagerRetriever scheduleImpl;
    public static final byte[] moveToNextValue = {16, -72, -107, 15, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int getErrorConfigVersion = 112;
    final List<RequestManager> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    private MemoryCategory NetworkUserEntityData$$ExternalSyntheticLambda1 = MemoryCategory.NORMAL;

    /* loaded from: classes3.dex */
    public interface RequestOptionsFactory {
        RequestOptions PlaceComponentResult();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    /* JADX WARN: Removed duplicated region for block: B:250:0x0058 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0092 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x00bf A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x00d1 A[Catch: all -> 0x0208, LOOP:2: B:266:0x00cb->B:268:0x00d1, LOOP_END, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00dc A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00e6 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x00f0 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x00fa A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x010a A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0115 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x012f A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x013e A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x014e A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0159 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0175 A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x017c A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x01c0 A[Catch: all -> 0x0208, TRY_LEAVE, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x01ee A[Catch: all -> 0x0208, TryCatch #1 {, blocks: (B:232:0x000f, B:234:0x0013, B:236:0x0017, B:238:0x0029, B:245:0x0040, B:247:0x004a, B:248:0x0052, B:250:0x0058, B:252:0x0068, B:254:0x0070, B:255:0x0086, B:256:0x008a, B:258:0x0092, B:259:0x0096, B:261:0x009c, B:263:0x00bf, B:265:0x00c5, B:266:0x00cb, B:268:0x00d1, B:269:0x00d8, B:271:0x00dc, B:272:0x00e2, B:274:0x00e6, B:275:0x00ec, B:277:0x00f0, B:278:0x00f6, B:280:0x00fa, B:281:0x0106, B:283:0x010a, B:284:0x0111, B:286:0x0115, B:288:0x011b, B:289:0x0124, B:290:0x012b, B:292:0x012f, B:293:0x013a, B:295:0x013e, B:296:0x014a, B:298:0x014e, B:299:0x0155, B:301:0x0159, B:302:0x0171, B:304:0x0175, B:306:0x0182, B:307:0x01ba, B:309:0x01c0, B:310:0x01c6, B:313:0x01cd, B:314:0x01eb, B:316:0x01ee, B:317:0x01f5, B:305:0x017c, B:242:0x0033, B:318:0x01fe, B:319:0x0205), top: B:329:0x000f, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bumptech.glide.Glide BuiltInFictitiousFunctionClassFactory(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Glide.BuiltInFictitiousFunctionClassFactory(android.content.Context):com.bumptech.glide.Glide");
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x002d A[Catch: InvocationTargetException -> 0x0057, NoSuchMethodException -> 0x005e, IllegalAccessException -> 0x0065, InstantiationException -> 0x006c, ClassNotFoundException -> 0x0073, TryCatch #2 {ClassNotFoundException -> 0x0073, IllegalAccessException -> 0x0065, InstantiationException -> 0x006c, NoSuchMethodException -> 0x005e, InvocationTargetException -> 0x0057, blocks: (B:69:0x0002, B:73:0x0025, B:75:0x002d, B:76:0x004b), top: B:96:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004b A[Catch: InvocationTargetException -> 0x0057, NoSuchMethodException -> 0x005e, IllegalAccessException -> 0x0065, InstantiationException -> 0x006c, ClassNotFoundException -> 0x0073, TRY_LEAVE, TryCatch #2 {ClassNotFoundException -> 0x0073, IllegalAccessException -> 0x0065, InstantiationException -> 0x006c, NoSuchMethodException -> 0x005e, InvocationTargetException -> 0x0057, blocks: (B:69:0x0002, B:73:0x0025, B:75:0x002d, B:76:0x004b), top: B:96:0x0002 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x004d -> B:78:0x0050). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bumptech.glide.GeneratedAppGlideModule getAuthRequestContext(android.content.Context r14) {
        /*
            java.lang.String r0 = "GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation."
            java.lang.String r1 = "com.bumptech.glide.GeneratedAppGlideModuleImpl"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            byte[] r4 = com.bumptech.glide.Glide.moveToNextValue     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r5 = 3
            r6 = 23
            byte[] r7 = new byte[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r8 = 97
            r9 = 0
            r5 = r4
            if (r4 != 0) goto L1f
            r10 = r7
            r7 = 3
            r11 = 0
            r12 = 23
            r4 = r3
            goto L50
        L1f:
            r8 = r7
            r7 = 3
            r10 = 97
            r11 = 0
            r4 = r3
        L25:
            int r7 = r7 + r2
            byte r12 = (byte) r10     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r8[r11] = r12     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            int r11 = r11 + 1
            if (r11 != r6) goto L4b
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r5.<init>(r8, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r3[r9] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            android.content.Context r14 = r14.getApplicationContext()     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r2[r9] = r14     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            java.lang.Object r14 = r1.newInstance(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            com.bumptech.glide.GeneratedAppGlideModule r14 = (com.bumptech.glide.GeneratedAppGlideModule) r14     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            goto L83
        L4b:
            r12 = r5[r7]     // Catch: java.lang.reflect.InvocationTargetException -> L57 java.lang.NoSuchMethodException -> L5e java.lang.IllegalAccessException -> L65 java.lang.InstantiationException -> L6c java.lang.ClassNotFoundException -> L73
            r13 = r10
            r10 = r8
            r8 = r13
        L50:
            int r8 = r8 + r12
            int r8 = r8 + (-8)
            r13 = r10
            r10 = r8
            r8 = r13
            goto L25
        L57:
            r14 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0, r14)
            throw r1
        L5e:
            r14 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0, r14)
            throw r1
        L65:
            r14 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0, r14)
            throw r1
        L6c:
            r14 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0, r14)
            throw r1
        L73:
            r14 = 5
            java.lang.String r0 = "Glide"
            boolean r14 = android.util.Log.isLoggable(r0, r14)
            if (r14 == 0) goto L82
            java.lang.String r14 = "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r0, r14)
        L82:
            r14 = 0
        L83:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.Glide.getAuthRequestContext(android.content.Context):com.bumptech.glide.GeneratedAppGlideModule");
    }

    private Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i, RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, GlideExperiments glideExperiments) {
        ResourceDecoder byteBufferBitmapDecoder;
        ResourceDecoder streamBitmapDecoder;
        this.GetContactSyncConfig = engine;
        this.BuiltInFictitiousFunctionClassFactory = bitmapPool;
        this.PlaceComponentResult = arrayPool;
        this.DatabaseTableConfigUtil = memoryCache;
        this.scheduleImpl = requestManagerRetriever;
        this.getAuthRequestContext = connectivityMonitorFactory;
        this.initRecordTimeStamp = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = registry;
        registry.MyBillsEntityDataFactory(new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            registry.MyBillsEntityDataFactory(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> KClassImpl$Data$declaredNonStaticMembers$2 = registry.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        if (!KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, KClassImpl$Data$declaredNonStaticMembers$2, bitmapPool, arrayPool);
            ResourceDecoder<ParcelFileDescriptor, Bitmap> MyBillsEntityDataFactory = VideoDecoder.MyBillsEntityDataFactory(bitmapPool);
            List<ImageHeaderParser> KClassImpl$Data$declaredNonStaticMembers$22 = registry.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            if (!KClassImpl$Data$declaredNonStaticMembers$22.isEmpty()) {
                Downsampler downsampler = new Downsampler(KClassImpl$Data$declaredNonStaticMembers$22, resources.getDisplayMetrics(), bitmapPool, arrayPool);
                if (glideExperiments.MyBillsEntityDataFactory(GlideBuilder.EnableImageDecoderForBitmaps.class) && Build.VERSION.SDK_INT >= 28) {
                    streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
                    byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
                } else {
                    byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
                    streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
                }
                ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
                ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
                ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
                ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
                ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
                BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
                BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
                GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
                ContentResolver contentResolver = context.getContentResolver();
                registry.getAuthRequestContext(ByteBuffer.class, new ByteBufferEncoder()).getAuthRequestContext(InputStream.class, new StreamEncoder(arrayPool)).BuiltInFictitiousFunctionClassFactory("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).BuiltInFictitiousFunctionClassFactory("Bitmap", InputStream.class, Bitmap.class, streamBitmapDecoder);
                if (ParcelFileDescriptorRewinder.BuiltInFictitiousFunctionClassFactory()) {
                    registry.BuiltInFictitiousFunctionClassFactory("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
                }
                Registry BuiltInFictitiousFunctionClassFactory = registry.BuiltInFictitiousFunctionClassFactory("Bitmap", ParcelFileDescriptor.class, Bitmap.class, MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.getAuthRequestContext(bitmapPool)).BuiltInFictitiousFunctionClassFactory(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).KClassImpl$Data$declaredNonStaticMembers$2(Bitmap.class, bitmapEncoder).BuiltInFictitiousFunctionClassFactory("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).BuiltInFictitiousFunctionClassFactory("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).BuiltInFictitiousFunctionClassFactory("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, MyBillsEntityDataFactory)).KClassImpl$Data$declaredNonStaticMembers$2(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).BuiltInFictitiousFunctionClassFactory("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(KClassImpl$Data$declaredNonStaticMembers$2, byteBufferGifDecoder, arrayPool)).BuiltInFictitiousFunctionClassFactory("Gif", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).KClassImpl$Data$declaredNonStaticMembers$2(GifDrawable.class, new GifDrawableEncoder()).BuiltInFictitiousFunctionClassFactory(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool));
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory("legacy_append", Uri.class, Drawable.class, resourceDrawableDecoder);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory("legacy_append", Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool));
                Registry BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new ByteBufferRewinder.Factory()).BuiltInFictitiousFunctionClassFactory(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).BuiltInFictitiousFunctionClassFactory(File.class, InputStream.class, new FileLoader.StreamFactory());
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory("legacy_append", File.class, File.class, new FileDecoder());
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).BuiltInFictitiousFunctionClassFactory(File.class, File.class, UnitModelLoader.Factory.KClassImpl$Data$declaredNonStaticMembers$2()).getAuthRequestContext(new InputStreamRewinder.Factory(arrayPool));
                if (ParcelFileDescriptorRewinder.BuiltInFictitiousFunctionClassFactory()) {
                    registry.getAuthRequestContext(new ParcelFileDescriptorRewinder.Factory());
                }
                registry.BuiltInFictitiousFunctionClassFactory(Integer.TYPE, InputStream.class, streamFactory).BuiltInFictitiousFunctionClassFactory(Integer.TYPE, ParcelFileDescriptor.class, fileDescriptorFactory).BuiltInFictitiousFunctionClassFactory(Integer.class, InputStream.class, streamFactory).BuiltInFictitiousFunctionClassFactory(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory).BuiltInFictitiousFunctionClassFactory(Integer.class, Uri.class, uriFactory).BuiltInFictitiousFunctionClassFactory(Integer.TYPE, AssetFileDescriptor.class, assetFileDescriptorFactory).BuiltInFictitiousFunctionClassFactory(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).BuiltInFictitiousFunctionClassFactory(Integer.TYPE, Uri.class, uriFactory).BuiltInFictitiousFunctionClassFactory(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).BuiltInFictitiousFunctionClassFactory(String.class, InputStream.class, new StringLoader.StreamFactory()).BuiltInFictitiousFunctionClassFactory(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).BuiltInFictitiousFunctionClassFactory(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).BuiltInFictitiousFunctionClassFactory(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
                if (Build.VERSION.SDK_INT >= 29) {
                    registry.BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
                    registry.BuiltInFictitiousFunctionClassFactory(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
                }
                Registry BuiltInFictitiousFunctionClassFactory3 = registry.BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).BuiltInFictitiousFunctionClassFactory(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).BuiltInFictitiousFunctionClassFactory(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).BuiltInFictitiousFunctionClassFactory(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).BuiltInFictitiousFunctionClassFactory(URL.class, InputStream.class, new UrlLoader.StreamFactory()).BuiltInFictitiousFunctionClassFactory(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).BuiltInFictitiousFunctionClassFactory(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).BuiltInFictitiousFunctionClassFactory(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).BuiltInFictitiousFunctionClassFactory(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).BuiltInFictitiousFunctionClassFactory(Uri.class, Uri.class, UnitModelLoader.Factory.KClassImpl$Data$declaredNonStaticMembers$2()).BuiltInFictitiousFunctionClassFactory(Drawable.class, Drawable.class, UnitModelLoader.Factory.KClassImpl$Data$declaredNonStaticMembers$2());
                BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory("legacy_append", Drawable.class, Drawable.class, new UnitDrawableDecoder());
                BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).BuiltInFictitiousFunctionClassFactory(Bitmap.class, byte[].class, bitmapBytesTranscoder).BuiltInFictitiousFunctionClassFactory(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).BuiltInFictitiousFunctionClassFactory(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
                if (Build.VERSION.SDK_INT >= 23) {
                    ResourceDecoder<ByteBuffer, Bitmap> KClassImpl$Data$declaredNonStaticMembers$23 = VideoDecoder.KClassImpl$Data$declaredNonStaticMembers$2(bitmapPool);
                    registry.BuiltInFictitiousFunctionClassFactory("legacy_append", ByteBuffer.class, Bitmap.class, KClassImpl$Data$declaredNonStaticMembers$23);
                    registry.BuiltInFictitiousFunctionClassFactory("legacy_append", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, KClassImpl$Data$declaredNonStaticMembers$23));
                }
                this.MyBillsEntityDataFactory = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, glideExperiments, i);
                return;
            }
            throw new Registry.NoImageHeaderParserException();
        }
        throw new Registry.NoImageHeaderParserException();
    }

    public static RequestManager MyBillsEntityDataFactory(Fragment fragment) {
        Context context = fragment.getContext();
        Preconditions.BuiltInFictitiousFunctionClassFactory(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return BuiltInFictitiousFunctionClassFactory(context).scheduleImpl.getAuthRequestContext(fragment);
    }

    public static RequestManager getAuthRequestContext(View view) {
        Context context = view.getContext();
        Preconditions.BuiltInFictitiousFunctionClassFactory(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        RequestManagerRetriever requestManagerRetriever = BuiltInFictitiousFunctionClassFactory(context).scheduleImpl;
        if (Util.PlaceComponentResult()) {
            return requestManagerRetriever.MyBillsEntityDataFactory(view.getContext().getApplicationContext());
        }
        Preconditions.PlaceComponentResult(view);
        Preconditions.BuiltInFictitiousFunctionClassFactory(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity authRequestContext = RequestManagerRetriever.getAuthRequestContext(view.getContext());
        if (authRequestContext == null) {
            return requestManagerRetriever.MyBillsEntityDataFactory(view.getContext().getApplicationContext());
        }
        android.app.Fragment fragment = null;
        Fragment fragment2 = null;
        if (authRequestContext instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) authRequestContext;
            requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            RequestManagerRetriever.BuiltInFictitiousFunctionClassFactory(fragmentActivity.getSupportFragmentManager().getFragments(), requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2);
            View findViewById = fragmentActivity.findViewById(16908290);
            while (!view.equals(findViewById) && (fragment2 = requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2.get(view)) == null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            return fragment2 != null ? requestManagerRetriever.getAuthRequestContext(fragment2) : requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2(fragmentActivity);
        }
        requestManagerRetriever.PlaceComponentResult.clear();
        requestManagerRetriever.BuiltInFictitiousFunctionClassFactory(authRequestContext.getFragmentManager(), requestManagerRetriever.PlaceComponentResult);
        View findViewById2 = authRequestContext.findViewById(16908290);
        while (!view.equals(findViewById2) && (fragment = requestManagerRetriever.PlaceComponentResult.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        requestManagerRetriever.PlaceComponentResult.clear();
        if (fragment == null) {
            return requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        }
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (Util.PlaceComponentResult() || Build.VERSION.SDK_INT < 17) {
            return requestManagerRetriever.MyBillsEntityDataFactory(fragment.getActivity().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            FrameWaiter frameWaiter = requestManagerRetriever.MyBillsEntityDataFactory;
            fragment.getActivity();
        }
        return requestManagerRetriever.KClassImpl$Data$declaredNonStaticMembers$2(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public final boolean PlaceComponentResult(Target<?> target) {
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Iterator<RequestManager> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                if (it.next().PlaceComponentResult(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static RequestManager KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        Preconditions.BuiltInFictitiousFunctionClassFactory(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return BuiltInFictitiousFunctionClassFactory(context).scheduleImpl.MyBillsEntityDataFactory(context);
    }

    public static RequestManager getAuthRequestContext(FragmentActivity fragmentActivity) {
        Preconditions.BuiltInFictitiousFunctionClassFactory(fragmentActivity, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return BuiltInFictitiousFunctionClassFactory(fragmentActivity).scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(fragmentActivity);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Util.BuiltInFictitiousFunctionClassFactory();
        this.DatabaseTableConfigUtil.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        this.PlaceComponentResult.getAuthRequestContext();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        Util.BuiltInFictitiousFunctionClassFactory();
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Iterator<RequestManager> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i);
            }
        }
        this.DatabaseTableConfigUtil.PlaceComponentResult(i);
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(i);
        this.PlaceComponentResult.MyBillsEntityDataFactory(i);
    }
}
