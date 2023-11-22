package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ResourcesCompat {
    private static final ThreadLocal<TypedValue> MyBillsEntityDataFactory = new ThreadLocal<>();
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> BuiltInFictitiousFunctionClassFactory = new WeakHashMap<>(0);
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();

    public static Drawable BuiltInFictitiousFunctionClassFactory(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.PlaceComponentResult(resources, i, theme);
        }
        return InstrumentInjector.Resources_getDrawable(resources, i);
    }

    public static Drawable PlaceComponentResult(Resources resources, int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getAuthRequestContext(resources, i, i2, theme);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            return Api15Impl.MyBillsEntityDataFactory(resources, i, i2);
        }
        return InstrumentInjector.Resources_getDrawable(resources, i);
    }

    public static int PlaceComponentResult(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.getAuthRequestContext(resources, i, theme);
        }
        return resources.getColor(i);
    }

    public static ColorStateList KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(colorStateListCacheKey, i);
        if (BuiltInFictitiousFunctionClassFactory2 != null) {
            return BuiltInFictitiousFunctionClassFactory2;
        }
        ColorStateList MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(resources, i, theme);
        if (MyBillsEntityDataFactory2 != null) {
            getAuthRequestContext(colorStateListCacheKey, i, MyBillsEntityDataFactory2, theme);
            return MyBillsEntityDataFactory2;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.BuiltInFictitiousFunctionClassFactory(resources, i, theme);
        } else {
            return resources.getColorStateList(i);
        }
    }

    private static ColorStateList MyBillsEntityDataFactory(Resources resources, int i, Resources.Theme theme) {
        if (PlaceComponentResult(resources, i)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.MyBillsEntityDataFactory(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            InstrumentInjector.log_w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList BuiltInFictitiousFunctionClassFactory(ColorStateListCacheKey colorStateListCacheKey, int i) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            SparseArray<ColorStateListCacheEntry> sparseArray = BuiltInFictitiousFunctionClassFactory.get(colorStateListCacheKey);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.MyBillsEntityDataFactory.equals(colorStateListCacheKey.KClassImpl$Data$declaredNonStaticMembers$2.getConfiguration()) && ((colorStateListCacheKey.PlaceComponentResult == null && colorStateListCacheEntry.BuiltInFictitiousFunctionClassFactory == 0) || (colorStateListCacheKey.PlaceComponentResult != null && colorStateListCacheEntry.BuiltInFictitiousFunctionClassFactory == colorStateListCacheKey.PlaceComponentResult.hashCode()))) {
                    return colorStateListCacheEntry.PlaceComponentResult;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void getAuthRequestContext(ColorStateListCacheKey colorStateListCacheKey, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2) {
            WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = BuiltInFictitiousFunctionClassFactory;
            SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(colorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.KClassImpl$Data$declaredNonStaticMembers$2.getConfiguration(), theme));
        }
    }

    private static boolean PlaceComponentResult(Resources resources, int i) {
        TypedValue BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
        resources.getValue(i, BuiltInFictitiousFunctionClassFactory2, true);
        return BuiltInFictitiousFunctionClassFactory2.type >= 28 && BuiltInFictitiousFunctionClassFactory2.type <= 31;
    }

    private static TypedValue BuiltInFictitiousFunctionClassFactory() {
        ThreadLocal<TypedValue> threadLocal = MyBillsEntityDataFactory;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* loaded from: classes.dex */
    public static final class ColorStateListCacheKey {
        final Resources KClassImpl$Data$declaredNonStaticMembers$2;
        final Resources.Theme PlaceComponentResult;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = resources;
            this.PlaceComponentResult = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(colorStateListCacheKey.KClassImpl$Data$declaredNonStaticMembers$2) && ObjectsCompat.MyBillsEntityDataFactory(this.PlaceComponentResult, colorStateListCacheKey.PlaceComponentResult);
        }

        public final int hashCode() {
            return ObjectsCompat.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        }
    }

    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {
        final int BuiltInFictitiousFunctionClassFactory;
        final Configuration MyBillsEntityDataFactory;
        final ColorStateList PlaceComponentResult;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.PlaceComponentResult = colorStateList;
            this.MyBillsEntityDataFactory = configuration;
            this.BuiltInFictitiousFunctionClassFactory = theme == null ? 0 : theme.hashCode();
        }
    }

    public static Typeface PlaceComponentResult(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return PlaceComponentResult(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface MyBillsEntityDataFactory(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return PlaceComponentResult(context, i, new TypedValue(), 0, null, null, false, true);
    }

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        /* renamed from: onFontRetrievalFailed */
        public abstract void m7xb24343b7(int i);

        /* renamed from: onFontRetrieved */
        public abstract void m8x46c88379(Typeface typeface);

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.m8x46c88379(typeface);
                }
            });
        }

        public final void callbackFailAsync(final int i, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.m7xb24343b7(i);
                }
            });
        }

        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, int i, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            PlaceComponentResult(context, i, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    public static Typeface MyBillsEntityDataFactory(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return PlaceComponentResult(context, i, typedValue, i2, fontCallback, null, true, false);
    }

    private static Typeface PlaceComponentResult(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface PlaceComponentResult = PlaceComponentResult(context, resources, typedValue, i, i2, fontCallback, handler, z, z2);
        if (PlaceComponentResult == null && fontCallback == null && !z2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Font resource ID #0x");
            sb.append(Integer.toHexString(i));
            sb.append(" could not be retrieved.");
            throw new Resources.NotFoundException(sb.toString());
        }
        return PlaceComponentResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface PlaceComponentResult(android.content.Context r17, android.content.res.Resources r18, android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.ResourcesCompat.FontCallback r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto Lbd
            java.lang.CharSequence r2 = r1.string
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L27
            if (r11 == 0) goto L26
            r11.callbackFailAsync(r15, r12)
        L26:
            return r16
        L27:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L37
            if (r11 == 0) goto L36
            r11.callbackSuccessAsync(r2, r12)
        L36:
            return r2
        L37:
            if (r25 == 0) goto L3a
            return r16
        L3a:
            java.lang.String r2 = r14.toLowerCase()     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            if (r2 == 0) goto L71
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.KClassImpl$Data$declaredNonStaticMembers$2(r2, r0)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            if (r2 != 0) goto L5b
            java.lang.String r0 = "Failed to find font-family tag"
            com.fullstory.instrumentation.InstrumentInjector.log_e(r13, r0)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            if (r11 == 0) goto L5a
            r11.callbackFailAsync(r15, r12)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
        L5a:
            return r16
        L5b:
            int r6 = r1.assetCookie     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.BuiltInFictitiousFunctionClassFactory(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            return r0
        L71:
            int r5 = r1.assetCookie     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.PlaceComponentResult(r1, r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            if (r11 == 0) goto L8b
            if (r0 == 0) goto L88
            r11.callbackSuccessAsync(r0, r12)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
            goto L8b
        L88:
            r11.callbackFailAsync(r15, r12)     // Catch: java.io.IOException -> L8c org.xmlpull.v1.XmlPullParserException -> La2
        L8b:
            return r0
        L8c:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            com.fullstory.instrumentation.InstrumentInjector.log_e(r13, r1, r0)
            goto Lb7
        La2:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            com.fullstory.instrumentation.InstrumentInjector.log_e(r13, r1, r0)
        Lb7:
            if (r11 == 0) goto Lbc
            r11.callbackFailAsync(r15, r12)
        Lbc:
            return r16
        Lbd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Resource \""
            r2.append(r3)
            java.lang.String r0 = r0.getResourceName(r4)
            r2.append(r0)
            java.lang.String r0 = "\" ("
            r2.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r2.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r2.append(r0)
            r2.append(r1)
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.PlaceComponentResult(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static ColorStateList BuiltInFictitiousFunctionClassFactory(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }

        static int getAuthRequestContext(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable PlaceComponentResult(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        static Drawable getAuthRequestContext(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api15Impl {
        private Api15Impl() {
        }

        static Drawable MyBillsEntityDataFactory(Resources resources, int i, int i2) {
            return InstrumentInjector.Resources_getDrawableForDensity(resources, i, i2);
        }
    }

    private ResourcesCompat() {
    }

    /* loaded from: classes.dex */
    public static final class ThemeCompat {
        private ThemeCompat() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT < 29) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Api23Impl.getAuthRequestContext(theme);
                    return;
                }
                return;
            }
            theme.rebase();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api29Impl {
            private Api29Impl() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class Api23Impl {
            private static Method KClassImpl$Data$declaredNonStaticMembers$2;
            private static boolean MyBillsEntityDataFactory;
            private static final Object PlaceComponentResult = new Object();

            private Api23Impl() {
            }

            static void getAuthRequestContext(Resources.Theme theme) {
                synchronized (PlaceComponentResult) {
                    if (!MyBillsEntityDataFactory) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            KClassImpl$Data$declaredNonStaticMembers$2 = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                            InstrumentInjector.log_i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                        }
                        MyBillsEntityDataFactory = true;
                    }
                    Method method = KClassImpl$Data$declaredNonStaticMembers$2;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            InstrumentInjector.log_i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                            KClassImpl$Data$declaredNonStaticMembers$2 = null;
                        }
                    }
                }
            }
        }
    }
}
