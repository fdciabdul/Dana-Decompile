package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
final class WeightTypefaceApi26 {
    private static final LongSparseArray<SparseArray<Typeface>> BuiltInFictitiousFunctionClassFactory;
    private static final Field KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Method MyBillsEntityDataFactory;
    private static final Object PlaceComponentResult;
    private static final Constructor<Typeface> getAuthRequestContext;

    static {
        Method method;
        Constructor<Typeface> constructor;
        Field field = null;
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            method = Typeface.class.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", Long.TYPE, Integer.TYPE, Boolean.TYPE);
            method.setAccessible(true);
            constructor = Typeface.class.getDeclaredConstructor(Long.TYPE);
            constructor.setAccessible(true);
            field = declaredField;
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            InstrumentInjector.log_e("WeightTypeface", e.getClass().getName(), e);
            method = null;
            constructor = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = field;
        MyBillsEntityDataFactory = method;
        getAuthRequestContext = constructor;
        BuiltInFictitiousFunctionClassFactory = new LongSparseArray<>(3);
        PlaceComponentResult = new Object();
    }

    private WeightTypefaceApi26() {
    }
}
