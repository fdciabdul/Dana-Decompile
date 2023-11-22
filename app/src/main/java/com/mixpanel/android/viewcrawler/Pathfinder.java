package com.mixpanel.android.viewcrawler;

import android.view.View;
import android.view.ViewGroup;
import com.mixpanel.android.util.MPLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class Pathfinder {
    private final IntStack getAuthRequestContext = new IntStack();

    /* loaded from: classes.dex */
    public interface Accumulator {
        void BuiltInFictitiousFunctionClassFactory(View view);
    }

    /* loaded from: classes.dex */
    public static class PathElement {
        public final int BuiltInFictitiousFunctionClassFactory;
        public final String KClassImpl$Data$declaredNonStaticMembers$2;
        public final String MyBillsEntityDataFactory;
        public final String PlaceComponentResult;
        public final int getAuthRequestContext;
        public final int getErrorConfigVersion;

        public PathElement(int i, String str, int i2, int i3, String str2, String str3) {
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.getErrorConfigVersion = i3;
            this.MyBillsEntityDataFactory = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.getAuthRequestContext == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                String str = this.PlaceComponentResult;
                if (str != null) {
                    jSONObject.put("view_class", str);
                }
                int i = this.BuiltInFictitiousFunctionClassFactory;
                if (i >= 0) {
                    jSONObject.put("index", i);
                }
                int i2 = this.getErrorConfigVersion;
                if (i2 >= 0) {
                    jSONObject.put("id", i2);
                }
                String str2 = this.MyBillsEntityDataFactory;
                if (str2 != null) {
                    jSONObject.put("contentDescription", str2);
                }
                String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (str3 != null) {
                    jSONObject.put("tag", str3);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                throw new RuntimeException("Can't serialize PathElement to String", e);
            }
        }
    }

    public final void PlaceComponentResult(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            return;
        }
        if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
            return;
        }
        PathElement pathElement = list.get(0);
        List<PathElement> subList = list.subList(1, list.size());
        IntStack intStack = this.getAuthRequestContext;
        int i = intStack.PlaceComponentResult;
        intStack.PlaceComponentResult = i + 1;
        intStack.BuiltInFictitiousFunctionClassFactory[i] = 0;
        View MyBillsEntityDataFactory = MyBillsEntityDataFactory(pathElement, view, i);
        IntStack intStack2 = this.getAuthRequestContext;
        int i2 = intStack2.PlaceComponentResult - 1;
        intStack2.PlaceComponentResult = i2;
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(intStack2.PlaceComponentResult);
        }
        if (MyBillsEntityDataFactory != null) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, subList, accumulator);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            accumulator.BuiltInFictitiousFunctionClassFactory(view);
        } else if (view instanceof ViewGroup) {
            if (this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory()) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PathFinder", "Path is too deep, will not match");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            PathElement pathElement = list.get(0);
            List<PathElement> subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            IntStack intStack = this.getAuthRequestContext;
            int i = intStack.PlaceComponentResult;
            intStack.PlaceComponentResult = i + 1;
            intStack.BuiltInFictitiousFunctionClassFactory[i] = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View MyBillsEntityDataFactory = MyBillsEntityDataFactory(pathElement, viewGroup.getChildAt(i2), i);
                if (MyBillsEntityDataFactory != null) {
                    BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, subList, accumulator);
                }
                if (pathElement.BuiltInFictitiousFunctionClassFactory >= 0 && this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory[i] > pathElement.BuiltInFictitiousFunctionClassFactory) {
                    break;
                }
            }
            IntStack intStack2 = this.getAuthRequestContext;
            int i3 = intStack2.PlaceComponentResult - 1;
            intStack2.PlaceComponentResult = i3;
            if (i3 < 0) {
                throw new ArrayIndexOutOfBoundsException(intStack2.PlaceComponentResult);
            }
        }
    }

    private View MyBillsEntityDataFactory(PathElement pathElement, View view, int i) {
        int i2 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory[i];
        if (BuiltInFictitiousFunctionClassFactory(pathElement, view)) {
            int[] iArr = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            iArr[i] = iArr[i] + 1;
            if (pathElement.BuiltInFictitiousFunctionClassFactory == -1 || pathElement.BuiltInFictitiousFunctionClassFactory == i2) {
                return view;
            }
        }
        if (pathElement.getAuthRequestContext == 1 && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View MyBillsEntityDataFactory = MyBillsEntityDataFactory(pathElement, viewGroup.getChildAt(i3), i);
                if (MyBillsEntityDataFactory != null) {
                    return MyBillsEntityDataFactory;
                }
            }
            return null;
        }
        return null;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(PathElement pathElement, View view) {
        if (pathElement.PlaceComponentResult == null || getAuthRequestContext(view, pathElement.PlaceComponentResult)) {
            if (-1 == pathElement.getErrorConfigVersion || view.getId() == pathElement.getErrorConfigVersion) {
                if (pathElement.MyBillsEntityDataFactory == null || pathElement.MyBillsEntityDataFactory.equals(view.getContentDescription())) {
                    String str = pathElement.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (pathElement.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        return view.getTag() != null && str.equals(view.getTag().toString());
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean getAuthRequestContext(Object obj, String str) {
        Class<?> cls = obj.getClass();
        while (true) {
            String canonicalName = cls.getCanonicalName();
            if (canonicalName != null && canonicalName.equals(str)) {
                return true;
            }
            if (cls == Object.class) {
                return false;
            }
            cls = cls.getSuperclass();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class IntStack {
        final int[] BuiltInFictitiousFunctionClassFactory = new int[256];
        int PlaceComponentResult = 0;

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.length == this.PlaceComponentResult;
        }
    }
}
