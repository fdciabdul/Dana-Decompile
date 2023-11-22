package com.alibaba.griver.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.framework.utils.Format;
import com.alibaba.griver.lottie.model.LottieCompositionCache;
import com.alibaba.griver.lottie.network.NetworkFetcher;
import com.alibaba.griver.lottie.okio.Okio;
import com.alibaba.griver.lottie.parser.LottieCompositionMoshiParser;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class LottieCompositionFactory {
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int MyBillsEntityDataFactory;
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int i) {
        LottieCompositionCache.getInstance().resize(i);
    }

    public static LottieTask<LottieComposition> fromUrl(final Context context, final String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("url_");
        sb.append(str);
        return cache(sb.toString(), new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return NetworkFetcher.fetchSync(context, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return NetworkFetcher.fetchSync(context, str);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("asset_");
            sb.append(str);
            String obj = sb.toString();
            int i = MyBillsEntityDataFactory + 69;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            int i3 = BuiltInFictitiousFunctionClassFactory + 107;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            try {
                if (((Boolean) String.class.getMethod("endsWith", String.class).invoke(str, ".zip")).booleanValue()) {
                    try {
                        Object[] objArr = {context.getAssets(), str};
                        Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                        if (obj2 == null) {
                            obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - View.MeasureSpec.makeMeasureSpec(0, 0)), ViewConfiguration.getScrollBarFadeDuration() >> 16, 48 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                            NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                        }
                        return fromZipStreamSync(new ZipInputStream((InputStream) ((Method) obj2).invoke(null, objArr)), obj);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                try {
                    Object[] objArr2 = {context.getAssets(), str};
                    Object obj3 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj3 == null) {
                        obj3 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 49)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj3);
                    }
                    return fromJsonInputStreamSync((InputStream) ((Method) obj3).invoke(null, objArr2), obj);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
        return new LottieResult<>((Throwable) e);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return cache(rawResCacheKey(i), new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromRawResSync(applicationContext, i);
            }
        });
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i), rawResCacheKey(i));
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static String rawResCacheKey(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes_");
        sb.append(i);
        return sb.toString();
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, final String str2) {
        return cache(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(JsonReader.this, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSyncInternal(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
                LottieCompositionCache.getInstance().put(str, parse);
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (Exception e) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LottieComposition解释错误,path=");
                    sb.append(jsonReader.getPath());
                    GriverLogger.e("LottieCompositionFactory", sb.toString());
                } catch (Throwable unused) {
                }
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public final LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("../")) {
                    zipInputStream.closeEntry();
                } else if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (name.contains(".json")) {
                    lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(".png") && !name.contains(Format.SUFFIX_WEBP)) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition, (String) entry.getKey());
                if (findImageAssetForFileName != null) {
                    findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("There is no image for ");
                    sb.append(entry2.getValue().getFileName());
                    return new LottieResult<>((Throwable) new IllegalStateException(sb.toString()));
                }
            }
            LottieCompositionCache.getInstance().put(str, lottieComposition);
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    private static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public final LottieResult<LottieComposition> call() {
                    return new LottieResult<>(LottieComposition.this);
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        lottieTask.addListener(new LottieListener<LottieComposition>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.9
            @Override // com.alibaba.griver.lottie.LottieListener
            public final void onResult(LottieComposition lottieComposition2) {
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, lottieComposition2);
                }
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        lottieTask.addFailureListener(new LottieListener<Throwable>() { // from class: com.alibaba.griver.lottie.LottieCompositionFactory.10
            @Override // com.alibaba.griver.lottie.LottieListener
            public final void onResult(Throwable th) {
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        taskCache.put(str, lottieTask);
        return lottieTask;
    }
}
