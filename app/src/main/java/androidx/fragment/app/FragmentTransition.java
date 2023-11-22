package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentTransition {
    static final FragmentTransitionImpl BuiltInFictitiousFunctionClassFactory;
    static final FragmentTransitionImpl getAuthRequestContext;

    static {
        getAuthRequestContext = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
    }

    private static FragmentTransitionImpl BuiltInFictitiousFunctionClassFactory() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAuthRequestContext(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            int i2 = i << 1;
            if (str.equals(arrayMap.moveToNextValue[i2 + 1])) {
                return (String) arrayMap.moveToNextValue[i2];
            }
        }
        return null;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey((String) arrayMap.moveToNextValue[(size << 1) + 1])) {
                arrayMap.MyBillsEntityDataFactory(size);
            }
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        SharedElementCallback enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                int i2 = i << 1;
                arrayList2.add((String) arrayMap.moveToNextValue[i2]);
                arrayList.add((View) arrayMap.moveToNextValue[i2 + 1]);
            }
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    public static boolean MyBillsEntityDataFactory() {
        return (getAuthRequestContext == null && BuiltInFictitiousFunctionClassFactory == null) ? false : true;
    }

    private FragmentTransition() {
    }
}
