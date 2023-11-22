package androidx.core.view;

import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout MyBillsEntityDataFactory;

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.MyBillsEntityDataFactory = displayCutout;
    }

    public final int PlaceComponentResult() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.PlaceComponentResult(this.MyBillsEntityDataFactory);
        }
        return 0;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        }
        return 0;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.MyBillsEntityDataFactory.getSafeInsetLeft();
        }
        return 0;
    }

    public final int MyBillsEntityDataFactory() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, ((DisplayCutoutCompat) obj).MyBillsEntityDataFactory);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.MyBillsEntityDataFactory;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisplayCutoutCompat{");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayCutoutCompat MyBillsEntityDataFactory(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    /* loaded from: classes.dex */
    static class Api28Impl {
        private Api28Impl() {
        }

        static int PlaceComponentResult(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }

        static int BuiltInFictitiousFunctionClassFactory(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int MyBillsEntityDataFactory(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        private Api30Impl() {
        }
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }
    }
}
