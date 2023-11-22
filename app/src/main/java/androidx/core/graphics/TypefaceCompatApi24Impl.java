package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final Class<?> KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Method MyBillsEntityDataFactory;
    private static final Constructor<?> PlaceComponentResult;
    private static final Method getAuthRequestContext;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            InstrumentInjector.log_e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        PlaceComponentResult = constructor;
        KClassImpl$Data$declaredNonStaticMembers$2 = cls;
        MyBillsEntityDataFactory = method2;
        getAuthRequestContext = method;
    }

    public static boolean getAuthRequestContext() {
        Method method = MyBillsEntityDataFactory;
        if (method == null) {
            InstrumentInjector.log_w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object PlaceComponentResult() {
        try {
            return PlaceComponentResult.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean getAuthRequestContext(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) MyBillsEntityDataFactory.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface BuiltInFictitiousFunctionClassFactory(Object obj) {
        try {
            Object newInstance = Array.newInstance(KClassImpl$Data$declaredNonStaticMembers$2, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) getAuthRequestContext.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface PlaceComponentResult(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Object PlaceComponentResult2 = PlaceComponentResult();
        if (PlaceComponentResult2 == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            Uri PlaceComponentResult3 = fontInfo.PlaceComponentResult();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(PlaceComponentResult3);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.PlaceComponentResult(context, cancellationSignal, PlaceComponentResult3);
                simpleArrayMap.put(PlaceComponentResult3, byteBuffer);
            }
            if (byteBuffer == null || !getAuthRequestContext(PlaceComponentResult2, byteBuffer, fontInfo.BuiltInFictitiousFunctionClassFactory(), fontInfo.getAuthRequestContext(), fontInfo.MyBillsEntityDataFactory())) {
                return null;
            }
        }
        Typeface BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        return InstrumentInjector.typefaceCreateDerived(BuiltInFictitiousFunctionClassFactory, i);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface KClassImpl$Data$declaredNonStaticMembers$2(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object PlaceComponentResult2 = PlaceComponentResult();
        if (PlaceComponentResult2 == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2()) {
            ByteBuffer KClassImpl$Data$declaredNonStaticMembers$22 = TypefaceCompatUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, resources, fontFileResourceEntry.getAuthRequestContext());
            if (KClassImpl$Data$declaredNonStaticMembers$22 == null || !getAuthRequestContext(PlaceComponentResult2, KClassImpl$Data$declaredNonStaticMembers$22, fontFileResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2(), fontFileResourceEntry.MyBillsEntityDataFactory(), fontFileResourceEntry.moveToNextValue())) {
                return null;
            }
        }
        return BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
    }
}
