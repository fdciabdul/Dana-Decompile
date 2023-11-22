package butterknife.internal;

import android.util.TypedValue;
import android.view.View;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public final class Utils {
    private static final TypedValue KClassImpl$Data$declaredNonStaticMembers$2 = new TypedValue();

    @SafeVarargs
    private static <T> T[] MyBillsEntityDataFactory(T... tArr) {
        int length = tArr.length;
        int i = 0;
        for (T t : tArr) {
            if (t != null) {
                tArr[i] = t;
                i++;
            }
        }
        return i != length ? (T[]) Arrays.copyOf(tArr, i) : tArr;
    }

    @SafeVarargs
    public static <T> List<T> KClassImpl$Data$declaredNonStaticMembers$2(T... tArr) {
        return new ImmutableList(MyBillsEntityDataFactory(tArr));
    }

    public static <T> T PlaceComponentResult(View view, int i, String str, Class<T> cls) {
        return (T) BuiltInFictitiousFunctionClassFactory(view.findViewById(i), i, str, cls);
    }

    public static View BuiltInFictitiousFunctionClassFactory(View view, int i, String str) {
        View findViewById = view.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        String resourceEntryName = view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
        StringBuilder sb = new StringBuilder();
        sb.append("Required view '");
        sb.append(resourceEntryName);
        sb.append("' with ID ");
        sb.append(i);
        sb.append(" for ");
        sb.append(str);
        sb.append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
        throw new IllegalStateException(sb.toString());
    }

    public static <T> T KClassImpl$Data$declaredNonStaticMembers$2(View view, int i, String str, Class<T> cls) {
        return (T) BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory(view, i, str), i, str, cls);
    }

    public static <T> T BuiltInFictitiousFunctionClassFactory(View view, int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e) {
            String resourceEntryName = view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i);
            StringBuilder sb = new StringBuilder();
            sb.append("View '");
            sb.append(resourceEntryName);
            sb.append("' with ID ");
            sb.append(i);
            sb.append(" for ");
            sb.append(str);
            sb.append(" was of the wrong type. See cause for more info.");
            throw new IllegalStateException(sb.toString(), e);
        }
    }

    private Utils() {
        throw new AssertionError("No instances.");
    }
}
