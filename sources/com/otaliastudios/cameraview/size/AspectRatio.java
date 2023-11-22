package com.otaliastudios.cameraview.size;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class AspectRatio implements Comparable<AspectRatio> {
    static final HashMap<String, AspectRatio> BuiltInFictitiousFunctionClassFactory = new HashMap<>(16);
    public final int MyBillsEntityDataFactory;
    public final int getAuthRequestContext;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(AspectRatio aspectRatio) {
        AspectRatio aspectRatio2 = aspectRatio;
        if (equals(aspectRatio2)) {
            return 0;
        }
        return (((float) this.getAuthRequestContext) / ((float) this.MyBillsEntityDataFactory)) - (((float) aspectRatio2.getAuthRequestContext) / ((float) aspectRatio2.MyBillsEntityDataFactory)) > 0.0f ? 1 : -1;
    }

    public static AspectRatio MyBillsEntityDataFactory(String str) {
        String[] split = str.split(":");
        if (split.length != 2) {
            throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
        }
        return BuiltInFictitiousFunctionClassFactory(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue());
    }

    private AspectRatio(int i, int i2) {
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = i2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatio) {
            AspectRatio aspectRatio = (AspectRatio) obj;
            return this.getAuthRequestContext == aspectRatio.getAuthRequestContext && this.MyBillsEntityDataFactory == aspectRatio.MyBillsEntityDataFactory;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAuthRequestContext);
        sb.append(":");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }

    public int hashCode() {
        int i = this.MyBillsEntityDataFactory;
        int i2 = this.getAuthRequestContext;
        return i ^ ((i2 << 16) | (i2 >>> 16));
    }

    public static AspectRatio BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 != 0) {
            int i5 = i4;
            i4 = i3 % i4;
            i3 = i5;
        }
        int i6 = i / i3;
        int i7 = i2 / i3;
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        sb.append(":");
        sb.append(i7);
        String obj = sb.toString();
        HashMap<String, AspectRatio> hashMap = BuiltInFictitiousFunctionClassFactory;
        AspectRatio aspectRatio = hashMap.get(obj);
        if (aspectRatio == null) {
            AspectRatio aspectRatio2 = new AspectRatio(i6, i7);
            hashMap.put(obj, aspectRatio2);
            return aspectRatio2;
        }
        return aspectRatio;
    }

    public static AspectRatio MyBillsEntityDataFactory(Size size) {
        return BuiltInFictitiousFunctionClassFactory(size.BuiltInFictitiousFunctionClassFactory, size.getAuthRequestContext);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Size size) {
        return Math.abs((((float) this.getAuthRequestContext) / ((float) this.MyBillsEntityDataFactory)) - (((float) size.BuiltInFictitiousFunctionClassFactory) / ((float) size.getAuthRequestContext))) <= 5.0E-4f;
    }
}
