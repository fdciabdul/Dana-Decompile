package org.commonmark.internal.util;

/* loaded from: classes6.dex */
public class Substring implements CharSequence {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;

    public static CharSequence KClassImpl$Data$declaredNonStaticMembers$2(String str, int i, int i2) {
        return new Substring(str, i, i2);
    }

    private Substring(String str, int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException("beginIndex must be at least 0");
        }
        if (i2 < 0) {
            throw new StringIndexOutOfBoundsException("endIndex must be at least 0");
        }
        if (i2 < i) {
            throw new StringIndexOutOfBoundsException("endIndex must not be less than beginIndex");
        }
        if (i2 > str.length()) {
            throw new StringIndexOutOfBoundsException("endIndex must not be greater than length");
        }
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 - this.MyBillsEntityDataFactory;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        int i2;
        if (i < 0 || (i2 = this.MyBillsEntityDataFactory + i) >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
            StringBuilder sb = new StringBuilder();
            sb.append("String index out of range: ");
            sb.append(i);
            throw new StringIndexOutOfBoundsException(sb.toString());
        }
        return this.BuiltInFictitiousFunctionClassFactory.charAt(i2);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i < 0 || (i5 = (i3 = this.MyBillsEntityDataFactory) + i) > (i4 = this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("String index out of range: ");
            sb.append(i);
            throw new StringIndexOutOfBoundsException(sb.toString());
        } else if (i2 < 0 || (i6 = i3 + i2) > i4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("String index out of range: ");
            sb2.append(i2);
            throw new StringIndexOutOfBoundsException(sb2.toString());
        } else {
            return new Substring(this.BuiltInFictitiousFunctionClassFactory, i5, i6);
        }
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.BuiltInFictitiousFunctionClassFactory.substring(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof CharSequence) && toString().equals(obj.toString()));
    }
}
