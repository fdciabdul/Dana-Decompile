package com.otaliastudios.cameraview.size;

/* loaded from: classes2.dex */
public class Size implements Comparable<Size> {
    public final int BuiltInFictitiousFunctionClassFactory;
    public final int getAuthRequestContext;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Size size) {
        Size size2 = size;
        return (this.BuiltInFictitiousFunctionClassFactory * this.getAuthRequestContext) - (size2.BuiltInFictitiousFunctionClassFactory * size2.getAuthRequestContext);
    }

    public Size(int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.getAuthRequestContext = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.BuiltInFictitiousFunctionClassFactory == size.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext == size.getAuthRequestContext;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("x");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    public int hashCode() {
        int i = this.getAuthRequestContext;
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        return i ^ ((i2 << 16) | (i2 >>> 16));
    }
}
