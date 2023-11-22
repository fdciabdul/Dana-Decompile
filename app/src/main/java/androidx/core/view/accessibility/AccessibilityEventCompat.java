package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class AccessibilityEventCompat {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ContentChangeType {
    }

    private AccessibilityEventCompat() {
    }

    @Deprecated
    public static AccessibilityRecordCompat MyBillsEntityDataFactory(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }

    public static void BuiltInFictitiousFunctionClassFactory(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.PlaceComponentResult(accessibilityEvent, i);
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.BuiltInFictitiousFunctionClassFactory(accessibilityEvent);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static void PlaceComponentResult(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        static int BuiltInFictitiousFunctionClassFactory(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }
    }

    /* loaded from: classes.dex */
    static class Api16Impl {
        private Api16Impl() {
        }
    }
}
