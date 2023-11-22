package com.airbnb.lottie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.alibaba.griver.image.framework.utils.Format;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes3.dex */
public class LottieCompositionFactory {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int PlaceComponentResult = 1;
    private static final Map<String, LottieTask<LottieComposition>> BuiltInFictitiousFunctionClassFactory = new HashMap();
    private static final byte[] MyBillsEntityDataFactory = {80, 75, 3, 4};

    private LottieCompositionFactory() {
    }

    public static LottieTask<LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("url_");
        sb.append(str);
        String obj = sb.toString();
        return MyBillsEntityDataFactory(obj, new LottieCompositionFactory$$ExternalSyntheticLambda2(context, str, obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ com.airbnb.lottie.LottieResult MyBillsEntityDataFactory(android.content.Context r3, java.lang.String r4, java.lang.String r5) throws java.lang.Exception {
        /*
            com.airbnb.lottie.network.NetworkFetcher r3 = com.airbnb.lottie.L.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            if (r5 == 0) goto L31
            com.airbnb.lottie.network.NetworkCache r0 = r3.MyBillsEntityDataFactory
            android.util.Pair r0 = r0.PlaceComponentResult(r4)
            if (r0 == 0) goto L31
            java.lang.Object r1 = r0.first
            com.airbnb.lottie.network.FileExtension r1 = (com.airbnb.lottie.network.FileExtension) r1
            java.lang.Object r0 = r0.second
            java.io.InputStream r0 = (java.io.InputStream) r0
            com.airbnb.lottie.network.FileExtension r2 = com.airbnb.lottie.network.FileExtension.ZIP
            if (r1 != r2) goto L24
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream
            r1.<init>(r0)
            com.airbnb.lottie.LottieResult r0 = KClassImpl$Data$declaredNonStaticMembers$2(r1, r4)
            goto L28
        L24:
            com.airbnb.lottie.LottieResult r0 = PlaceComponentResult(r0, r4)
        L28:
            V r1 = r0.PlaceComponentResult
            if (r1 == 0) goto L31
            V r0 = r0.PlaceComponentResult
            com.airbnb.lottie.LottieComposition r0 = (com.airbnb.lottie.LottieComposition) r0
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L3a
            com.airbnb.lottie.LottieResult r3 = new com.airbnb.lottie.LottieResult
            r3.<init>(r0)
            goto L57
        L3a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Animation for "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " not found in cache. Fetching from network."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.airbnb.lottie.utils.Logger.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            com.airbnb.lottie.LottieResult r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r4, r5)
        L57:
            if (r5 == 0) goto L6c
            V r4 = r3.PlaceComponentResult
            if (r4 == 0) goto L6c
            com.airbnb.lottie.model.LottieCompositionCache r4 = com.airbnb.lottie.model.LottieCompositionCache.BuiltInFictitiousFunctionClassFactory()
            V r0 = r3.PlaceComponentResult
            com.airbnb.lottie.LottieComposition r0 = (com.airbnb.lottie.LottieComposition) r0
            if (r5 == 0) goto L6c
            androidx.collection.LruCache<java.lang.String, com.airbnb.lottie.LottieComposition> r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            r4.put(r5, r0)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.MyBillsEntityDataFactory(android.content.Context, java.lang.String, java.lang.String):com.airbnb.lottie.LottieResult");
    }

    public static LottieTask<LottieComposition> BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("asset_");
        sb.append(str);
        String obj = sb.toString();
        return MyBillsEntityDataFactory(obj, new LottieCompositionFactory$$ExternalSyntheticLambda10(context.getApplicationContext(), str, obj));
    }

    public static LottieTask<LottieComposition> PlaceComponentResult(Context context, String str) {
        return MyBillsEntityDataFactory((String) null, new LottieCompositionFactory$$ExternalSyntheticLambda10(context.getApplicationContext(), str, null));
    }

    public static LottieResult<LottieComposition> getAuthRequestContext(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("asset_");
        sb.append(str);
        return BuiltInFictitiousFunctionClassFactory(context, str, sb.toString());
    }

    public static LottieResult<LottieComposition> BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2) {
        int i = PlaceComponentResult + 51;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            try {
                int length = objArr.length;
            } catch (IOException e) {
                return new LottieResult<>((Throwable) e);
            }
        }
        try {
            if ((!((Boolean) String.class.getMethod("endsWith", String.class).invoke(str, ".zip")).booleanValue() ? '0' : (char) 7) != 7) {
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
                try {
                    if (!((Boolean) String.class.getMethod("endsWith", String.class).invoke(str, ".lottie")).booleanValue()) {
                        try {
                            Object[] objArr2 = {context.getAssets(), str};
                            Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                            if (obj == null) {
                                obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (View.MeasureSpec.getMode(0) + 58133), KeyEvent.getMaxKeyCode() >> 16, 49 - TextUtils.getOffsetBefore("", 0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                            }
                            LottieResult<LottieComposition> PlaceComponentResult2 = PlaceComponentResult((InputStream) ((Method) obj).invoke(null, objArr2), str2);
                            int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 35;
                            PlaceComponentResult = i4 % 128;
                            if (!(i4 % 2 != 0)) {
                                int i5 = 69 / 0;
                                return PlaceComponentResult2;
                            }
                            return PlaceComponentResult2;
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause != null) {
                                throw cause;
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
            try {
                Object[] objArr3 = {context.getAssets(), str};
                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj2 == null) {
                    obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), ViewConfiguration.getDoubleTapTimeout() >> 16, 49 - (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                }
                return KClassImpl$Data$declaredNonStaticMembers$2(new ZipInputStream((InputStream) ((Method) obj2).invoke(null, objArr3)), str2);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
                throw th3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 != null) {
                throw cause4;
            }
            throw th4;
        }
    }

    public static LottieTask<LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(context, i);
        return MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2, new LottieCompositionFactory$$ExternalSyntheticLambda1(new WeakReference(context), context.getApplicationContext(), i, BuiltInFictitiousFunctionClassFactory2));
    }

    public static LottieTask<LottieComposition> getAuthRequestContext(Context context, int i) {
        return MyBillsEntityDataFactory((String) null, new LottieCompositionFactory$$ExternalSyntheticLambda1(new WeakReference(context), context.getApplicationContext(), i, null));
    }

    public static /* synthetic */ LottieResult PlaceComponentResult(WeakReference weakReference, Context context, int i, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return PlaceComponentResult(context, i, str);
    }

    public static LottieResult<LottieComposition> MyBillsEntityDataFactory(Context context, int i) {
        return PlaceComponentResult(context, i, BuiltInFictitiousFunctionClassFactory(context, i));
    }

    public static LottieResult<LottieComposition> PlaceComponentResult(Context context, int i, String str) {
        try {
            BufferedSource KClassImpl$Data$declaredNonStaticMembers$22 = Okio.KClassImpl$Data$declaredNonStaticMembers$2(Okio.getAuthRequestContext(context.getResources().openRawResource(i)));
            if (MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$22).booleanValue()) {
                return KClassImpl$Data$declaredNonStaticMembers$2(new ZipInputStream(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda0()), str);
            }
            return PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda0(), str);
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(BuiltInFictitiousFunctionClassFactory(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static LottieTask<LottieComposition> getAuthRequestContext(final InputStream inputStream, final String str) {
        return MyBillsEntityDataFactory(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieResult PlaceComponentResult2;
                PlaceComponentResult2 = LottieCompositionFactory.PlaceComponentResult(inputStream, str);
                return PlaceComponentResult2;
            }
        });
    }

    public static LottieResult<LottieComposition> PlaceComponentResult(InputStream inputStream, String str) {
        try {
            return BuiltInFictitiousFunctionClassFactory(JsonReader.KClassImpl$Data$declaredNonStaticMembers$2(Okio.KClassImpl$Data$declaredNonStaticMembers$2(Okio.getAuthRequestContext(inputStream))), str, true);
        } finally {
            Utils.getAuthRequestContext(inputStream);
        }
    }

    public static LottieResult<LottieComposition> BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader, String str, boolean z) {
        try {
            try {
                LottieComposition KClassImpl$Data$declaredNonStaticMembers$22 = LottieCompositionMoshiParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader);
                if (str != null) {
                    LottieCompositionCache BuiltInFictitiousFunctionClassFactory2 = LottieCompositionCache.BuiltInFictitiousFunctionClassFactory();
                    if (str != null) {
                        BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.put(str, KClassImpl$Data$declaredNonStaticMembers$22);
                    }
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(KClassImpl$Data$declaredNonStaticMembers$22);
                if (z) {
                    Utils.getAuthRequestContext(jsonReader);
                }
                return lottieResult;
            } catch (Exception e) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e);
                if (z) {
                    Utils.getAuthRequestContext(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z) {
                Utils.getAuthRequestContext(jsonReader);
            }
            throw th;
        }
    }

    public static LottieResult<LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2(ZipInputStream zipInputStream, String str) {
        try {
            return BuiltInFictitiousFunctionClassFactory(zipInputStream, str);
        } finally {
            Utils.getAuthRequestContext(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> BuiltInFictitiousFunctionClassFactory(ZipInputStream zipInputStream, String str) {
        LottieImageAsset lottieImageAsset;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (!nextEntry.getName().contains(".json")) {
                    if (!name.contains(".png") && !name.contains(Format.SUFFIX_WEBP) && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    lottieComposition = BuiltInFictitiousFunctionClassFactory(JsonReader.KClassImpl$Data$declaredNonStaticMembers$2(Okio.KClassImpl$Data$declaredNonStaticMembers$2(Okio.getAuthRequestContext(zipInputStream))), (String) null, false).PlaceComponentResult;
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<LottieImageAsset> it = lottieComposition.moveToNextValue.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        lottieImageAsset = null;
                        break;
                    }
                    lottieImageAsset = it.next();
                    if (lottieImageAsset.PlaceComponentResult.equals(str2)) {
                        break;
                    }
                }
                if (lottieImageAsset != null) {
                    lottieImageAsset.MyBillsEntityDataFactory = Utils.KClassImpl$Data$declaredNonStaticMembers$2((Bitmap) entry.getValue(), lottieImageAsset.KClassImpl$Data$declaredNonStaticMembers$2, lottieImageAsset.BuiltInFictitiousFunctionClassFactory);
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.moveToNextValue.entrySet()) {
                if (entry2.getValue().MyBillsEntityDataFactory == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("There is no image for ");
                    sb.append(entry2.getValue().PlaceComponentResult);
                    return new LottieResult<>((Throwable) new IllegalStateException(sb.toString()));
                }
            }
            if (str != null) {
                LottieCompositionCache BuiltInFictitiousFunctionClassFactory2 = LottieCompositionCache.BuiltInFictitiousFunctionClassFactory();
                if (str != null) {
                    BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.put(str, lottieComposition);
                }
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static Boolean MyBillsEntityDataFactory(BufferedSource bufferedSource) {
        try {
            BufferedSource scheduleImpl = bufferedSource.scheduleImpl();
            for (byte b : MyBillsEntityDataFactory) {
                if (scheduleImpl.initRecordTimeStamp() != b) {
                    return Boolean.FALSE;
                }
            }
            scheduleImpl.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            Logger.MyBillsEntityDataFactory("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static LottieTask<LottieComposition> MyBillsEntityDataFactory(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = null;
        if (str != null) {
            LottieCompositionCache BuiltInFictitiousFunctionClassFactory2 = LottieCompositionCache.BuiltInFictitiousFunctionClassFactory();
            if (str != null) {
                lottieComposition = BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            }
        }
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return LottieCompositionFactory.MyBillsEntityDataFactory(LottieComposition.this);
                }
            });
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = BuiltInFictitiousFunctionClassFactory;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.BuiltInFictitiousFunctionClassFactory(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda5
                @Override // com.airbnb.lottie.LottieListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                    LottieComposition lottieComposition2 = (LottieComposition) obj;
                    LottieCompositionFactory.MyBillsEntityDataFactory(str, atomicBoolean);
                }
            });
            lottieTask.getAuthRequestContext(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda6
                @Override // com.airbnb.lottie.LottieListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                    Throwable th = (Throwable) obj;
                    LottieCompositionFactory.getAuthRequestContext(str, atomicBoolean);
                }
            });
            if (!atomicBoolean.get()) {
                BuiltInFictitiousFunctionClassFactory.put(str, lottieTask);
            }
        }
        return lottieTask;
    }

    public static /* synthetic */ LottieResult MyBillsEntityDataFactory(LottieComposition lottieComposition) throws Exception {
        return new LottieResult(lottieComposition);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(String str, AtomicBoolean atomicBoolean) {
        BuiltInFictitiousFunctionClassFactory.remove(str);
        atomicBoolean.set(true);
    }

    public static /* synthetic */ void getAuthRequestContext(String str, AtomicBoolean atomicBoolean) {
        BuiltInFictitiousFunctionClassFactory.remove(str);
        atomicBoolean.set(true);
    }
}
