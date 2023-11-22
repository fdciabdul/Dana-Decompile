package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    private final Object BuiltInFictitiousFunctionClassFactory;

    public AccessibilityNodeInfoCompat BuiltInFictitiousFunctionClassFactory(int i) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> KClassImpl$Data$declaredNonStaticMembers$2(String str, int i) {
        return null;
    }

    public boolean MyBillsEntityDataFactory(int i, int i2, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeInfoCompat PlaceComponentResult(int i) {
        return null;
    }

    public void PlaceComponentResult(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
    }

    /* loaded from: classes3.dex */
    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat MyBillsEntityDataFactory;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.MyBillsEntityDataFactory = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfoCompat BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i);
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory.getSupportButtonTintMode();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<AccessibilityNodeInfoCompat> KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(str, i);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = KClassImpl$Data$declaredNonStaticMembers$2.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.get(i2).getSupportButtonTintMode());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(i, i2, bundle);
        }
    }

    /* loaded from: classes3.dex */
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            AccessibilityNodeInfoCompat PlaceComponentResult = this.MyBillsEntityDataFactory.PlaceComponentResult(i);
            if (PlaceComponentResult == null) {
                return null;
            }
            return PlaceComponentResult.getSupportButtonTintMode();
        }
    }

    /* loaded from: classes3.dex */
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.MyBillsEntityDataFactory.PlaceComponentResult(i, AccessibilityNodeInfoCompat.MyBillsEntityDataFactory(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.BuiltInFictitiousFunctionClassFactory = new AccessibilityNodeProviderApi26(this);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.BuiltInFictitiousFunctionClassFactory = new AccessibilityNodeProviderApi19(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.BuiltInFictitiousFunctionClassFactory = new AccessibilityNodeProviderApi16(this);
        } else {
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.BuiltInFictitiousFunctionClassFactory = obj;
    }

    public Object KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
