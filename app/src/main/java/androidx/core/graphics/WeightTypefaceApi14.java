package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;

/* loaded from: classes6.dex */
final class WeightTypefaceApi14 {
    private static final LongSparseArray<SparseArray<Typeface>> KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Field PlaceComponentResult;
    private static final Object getAuthRequestContext;

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField("native_instance");
            field.setAccessible(true);
        } catch (Exception e) {
            InstrumentInjector.log_e("WeightTypeface", e.getClass().getName(), e);
            field = null;
        }
        PlaceComponentResult = field;
        KClassImpl$Data$declaredNonStaticMembers$2 = new LongSparseArray<>(3);
        getAuthRequestContext = new Object();
    }

    private WeightTypefaceApi14() {
    }
}
