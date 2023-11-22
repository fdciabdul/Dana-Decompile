package com.journeyapps.barcodescanner;

/* loaded from: classes3.dex */
public class Size implements Comparable<Size> {
    public final int KClassImpl$Data$declaredNonStaticMembers$2;
    public final int MyBillsEntityDataFactory;

    public Size(int i, int i2) {
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }

    public final Size MyBillsEntityDataFactory(Size size) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = size.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = size.MyBillsEntityDataFactory;
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i5 = i * i2;
        int i6 = i3 * i4;
        if (i5 >= i6) {
            return new Size(i3, i6 / i);
        }
        return new Size(i5 / i4, i2);
    }

    public final Size BuiltInFictitiousFunctionClassFactory(Size size) {
        int i = this.MyBillsEntityDataFactory;
        int i2 = size.KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = size.MyBillsEntityDataFactory;
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i5 = i * i2;
        int i6 = i3 * i4;
        if (i5 <= i6) {
            return new Size(i3, i6 / i);
        }
        return new Size(i5 / i4, i2);
    }

    public final boolean getAuthRequestContext(Size size) {
        return this.MyBillsEntityDataFactory <= size.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 <= size.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.lang.Comparable
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final int compareTo(Size size) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2 * this.MyBillsEntityDataFactory;
        int i2 = size.KClassImpl$Data$declaredNonStaticMembers$2 * size.MyBillsEntityDataFactory;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("x");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Size size = (Size) obj;
        return this.MyBillsEntityDataFactory == size.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == size.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public int hashCode() {
        return (this.MyBillsEntityDataFactory * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
