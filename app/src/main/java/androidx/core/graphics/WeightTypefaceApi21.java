package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
final class WeightTypefaceApi21 {
    private static final Method BuiltInFictitiousFunctionClassFactory;
    private static final Method KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Field MyBillsEntityDataFactory;
    private static final Object PlaceComponentResult;
    private static final Constructor<Typeface> getAuthRequestContext;
    private static final LongSparseArray<SparseArray<Typeface>> scheduleImpl;

    static {
        Method method;
        Method method2;
        Constructor<Typeface> constructor;
        Field field = null;
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            method2 = Typeface.class.getDeclaredMethod("nativeCreateFromTypeface", Long.TYPE, Integer.TYPE);
            method2.setAccessible(true);
            method = Typeface.class.getDeclaredMethod("nativeCreateWeightAlias", Long.TYPE, Integer.TYPE);
            method.setAccessible(true);
            constructor = Typeface.class.getDeclaredConstructor(Long.TYPE);
            constructor.setAccessible(true);
            field = declaredField;
        } catch (NoSuchFieldException | NoSuchMethodException e) {
            InstrumentInjector.log_e("WeightTypeface", e.getClass().getName(), e);
            method = null;
            method2 = null;
            constructor = null;
        }
        MyBillsEntityDataFactory = field;
        BuiltInFictitiousFunctionClassFactory = method2;
        KClassImpl$Data$declaredNonStaticMembers$2 = method;
        getAuthRequestContext = constructor;
        scheduleImpl = new LongSparseArray<>(3);
        PlaceComponentResult = new Object();
    }

    private WeightTypefaceApi21() {
    }
}
