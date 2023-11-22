package androidx.core.graphics;

import android.graphics.Rect;

/* loaded from: classes.dex */
public final class Insets {
    public static final Insets MyBillsEntityDataFactory = new Insets(0, 0, 0, 0);
    public final int BuiltInFictitiousFunctionClassFactory;
    public final int KClassImpl$Data$declaredNonStaticMembers$2;
    public final int PlaceComponentResult;
    public final int getAuthRequestContext;

    private Insets(int i, int i2, int i3, int i4) {
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
        this.getAuthRequestContext = i4;
    }

    public static Insets PlaceComponentResult(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return MyBillsEntityDataFactory;
        }
        return new Insets(i, i2, i3, i4);
    }

    public static Insets PlaceComponentResult(Rect rect) {
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return MyBillsEntityDataFactory;
        }
        return new Insets(i, i2, i3, i4);
    }

    public static Insets PlaceComponentResult(Insets insets, Insets insets2) {
        int max = Math.max(insets.PlaceComponentResult, insets2.PlaceComponentResult);
        int max2 = Math.max(insets.BuiltInFictitiousFunctionClassFactory, insets2.BuiltInFictitiousFunctionClassFactory);
        int max3 = Math.max(insets.KClassImpl$Data$declaredNonStaticMembers$2, insets2.KClassImpl$Data$declaredNonStaticMembers$2);
        int max4 = Math.max(insets.getAuthRequestContext, insets2.getAuthRequestContext);
        if (max == 0 && max2 == 0 && max3 == 0 && max4 == 0) {
            return MyBillsEntityDataFactory;
        }
        return new Insets(max, max2, max3, max4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.getAuthRequestContext == insets.getAuthRequestContext && this.PlaceComponentResult == insets.PlaceComponentResult && this.KClassImpl$Data$declaredNonStaticMembers$2 == insets.KClassImpl$Data$declaredNonStaticMembers$2 && this.BuiltInFictitiousFunctionClassFactory == insets.BuiltInFictitiousFunctionClassFactory;
    }

    public final int hashCode() {
        int i = this.PlaceComponentResult;
        return (((((i * 31) + this.BuiltInFictitiousFunctionClassFactory) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + this.getAuthRequestContext;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Insets{left=");
        sb.append(this.PlaceComponentResult);
        sb.append(", top=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", right=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", bottom=");
        sb.append(this.getAuthRequestContext);
        sb.append('}');
        return sb.toString();
    }

    public static Insets MyBillsEntityDataFactory(android.graphics.Insets insets) {
        int i = insets.left;
        int i2 = insets.top;
        int i3 = insets.right;
        int i4 = insets.bottom;
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return MyBillsEntityDataFactory;
        }
        return new Insets(i, i2, i3, i4);
    }

    /* loaded from: classes.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static android.graphics.Insets BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3, int i4) {
            return android.graphics.Insets.of(i, i2, i3, i4);
        }
    }
}
