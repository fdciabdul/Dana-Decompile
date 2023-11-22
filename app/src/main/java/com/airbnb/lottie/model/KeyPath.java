package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class KeyPath {
    public static final KeyPath MyBillsEntityDataFactory = new KeyPath("COMPOSITION");
    public KeyPathElement BuiltInFictitiousFunctionClassFactory;
    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    public KeyPath(String... strArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Arrays.asList(strArr);
    }

    public KeyPath(KeyPath keyPath) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList(keyPath.KClassImpl$Data$declaredNonStaticMembers$2);
        this.BuiltInFictitiousFunctionClassFactory = keyPath.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean getAuthRequestContext(String str, int i) {
        if (getAuthRequestContext(str)) {
            return true;
        }
        if (i >= this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
            return false;
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).equals(str) || this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).equals("**") || this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).equals("*");
    }

    public final int BuiltInFictitiousFunctionClassFactory(String str, int i) {
        if (getAuthRequestContext(str)) {
            return 0;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).equals("**")) {
            return (i != this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1 && this.KClassImpl$Data$declaredNonStaticMembers$2.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean PlaceComponentResult(String str, int i) {
        if (i >= this.KClassImpl$Data$declaredNonStaticMembers$2.size()) {
            return false;
        }
        boolean z = i == this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1;
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.KClassImpl$Data$declaredNonStaticMembers$2.size() + (-2) && BuiltInFictitiousFunctionClassFactory())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.KClassImpl$Data$declaredNonStaticMembers$2.get(i + 1).equals(str)) {
            return i == this.KClassImpl$Data$declaredNonStaticMembers$2.size() + (-2) || (i == this.KClassImpl$Data$declaredNonStaticMembers$2.size() + (-3) && BuiltInFictitiousFunctionClassFactory());
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1) {
                return false;
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.get(i2).equals(str);
        }
    }

    public final boolean MyBillsEntityDataFactory(String str, int i) {
        return "__container".equals(str) || i < this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1 || this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).equals("**");
    }

    private static boolean getAuthRequestContext(String str) {
        return "__container".equals(str);
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get(r0.size() - 1).equals("**");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyPath keyPath = (KeyPath) obj;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.equals(keyPath.KClassImpl$Data$declaredNonStaticMembers$2)) {
            KeyPathElement keyPathElement = this.BuiltInFictitiousFunctionClassFactory;
            KeyPathElement keyPathElement2 = keyPath.BuiltInFictitiousFunctionClassFactory;
            return keyPathElement != null ? keyPathElement.equals(keyPathElement2) : keyPathElement2 == null;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        KeyPathElement keyPathElement = this.BuiltInFictitiousFunctionClassFactory;
        return (hashCode * 31) + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(",resolved=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory != null);
        sb.append('}');
        return sb.toString();
    }
}
