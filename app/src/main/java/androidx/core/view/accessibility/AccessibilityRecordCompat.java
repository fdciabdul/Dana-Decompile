package androidx.core.view.accessibility;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord MyBillsEntityDataFactory;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.MyBillsEntityDataFactory = (AccessibilityRecord) obj;
    }

    public static void MyBillsEntityDataFactory(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.PlaceComponentResult(accessibilityRecord, view, i);
        }
    }

    @Deprecated
    public void getAuthRequestContext(int i) {
        this.MyBillsEntityDataFactory.setFromIndex(i);
    }

    @Deprecated
    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.MyBillsEntityDataFactory.setToIndex(i);
    }

    public static void MyBillsEntityDataFactory(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            Api15Impl.BuiltInFictitiousFunctionClassFactory(accessibilityRecord, i);
        }
    }

    public static void PlaceComponentResult(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            Api15Impl.getAuthRequestContext(accessibilityRecord, i);
        }
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.MyBillsEntityDataFactory;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityRecordCompat) {
            AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
            AccessibilityRecord accessibilityRecord = this.MyBillsEntityDataFactory;
            if (accessibilityRecord == null) {
                return accessibilityRecordCompat.MyBillsEntityDataFactory == null;
            }
            return accessibilityRecord.equals(accessibilityRecordCompat.MyBillsEntityDataFactory);
        }
        return false;
    }

    /* loaded from: classes3.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static void PlaceComponentResult(AccessibilityRecord accessibilityRecord, View view, int i) {
            accessibilityRecord.setSource(view, i);
        }
    }

    /* loaded from: classes3.dex */
    static class Api15Impl {
        private Api15Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }

        static void getAuthRequestContext(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }
}
