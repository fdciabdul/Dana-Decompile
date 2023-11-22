package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;

/* loaded from: classes6.dex */
public class AccessibilityWindowInfoCompat {
    private final Object PlaceComponentResult;

    private static String KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    static AccessibilityWindowInfoCompat KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.PlaceComponentResult = obj;
    }

    public int KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getAuthRequestContext((AccessibilityWindowInfo) this.PlaceComponentResult);
        }
        return -1;
    }

    public int MyBillsEntityDataFactory() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.PlaceComponentResult).getLayer();
        }
        return -1;
    }

    public AccessibilityWindowInfoCompat BuiltInFictitiousFunctionClassFactory() {
        if (Build.VERSION.SDK_INT >= 21) {
            return KClassImpl$Data$declaredNonStaticMembers$2(Api21Impl.PlaceComponentResult((AccessibilityWindowInfo) this.PlaceComponentResult));
        }
        return null;
    }

    public int getAuthRequestContext() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.BuiltInFictitiousFunctionClassFactory((AccessibilityWindowInfo) this.PlaceComponentResult);
        }
        return -1;
    }

    public void MyBillsEntityDataFactory(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory((AccessibilityWindowInfo) this.PlaceComponentResult, rect);
        }
    }

    public boolean getErrorConfigVersion() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.lookAheadTest((AccessibilityWindowInfo) this.PlaceComponentResult);
        }
        return true;
    }

    public boolean lookAheadTest() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.moveToNextValue((AccessibilityWindowInfo) this.PlaceComponentResult);
        }
        return true;
    }

    public int PlaceComponentResult() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.MyBillsEntityDataFactory((AccessibilityWindowInfo) this.PlaceComponentResult);
        }
        return 0;
    }

    public int hashCode() {
        Object obj = this.PlaceComponentResult;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AccessibilityWindowInfoCompat)) {
            AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
            Object obj2 = this.PlaceComponentResult;
            if (obj2 == null) {
                return accessibilityWindowInfoCompat.PlaceComponentResult == null;
            }
            return obj2.equals(accessibilityWindowInfoCompat.PlaceComponentResult);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        MyBillsEntityDataFactory(rect);
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=");
        sb.append(getAuthRequestContext());
        sb.append(", type=");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2()));
        sb.append(", layer=");
        sb.append(MyBillsEntityDataFactory());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(lookAheadTest());
        sb.append(", active=");
        sb.append(getErrorConfigVersion());
        sb.append(", hasParent=");
        sb.append(BuiltInFictitiousFunctionClassFactory() != null);
        sb.append(", hasChildren=");
        sb.append(PlaceComponentResult() > 0);
        sb.append(']');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        static int MyBillsEntityDataFactory(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        static int BuiltInFictitiousFunctionClassFactory(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        static AccessibilityWindowInfo PlaceComponentResult(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        static int getAuthRequestContext(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        static boolean lookAheadTest(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        static boolean moveToNextValue(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }
    }

    /* loaded from: classes6.dex */
    static class Api24Impl {
        private Api24Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api33Impl {
        private Api33Impl() {
        }
    }
}
