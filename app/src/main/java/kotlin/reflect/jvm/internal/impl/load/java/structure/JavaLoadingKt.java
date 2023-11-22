package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public final class JavaLoadingKt {
    public static final boolean isObjectMethodInInterface(JavaMember javaMember) {
        Intrinsics.checkNotNullParameter(javaMember, "");
        return javaMember.getContainingClass().isInterface() && (javaMember instanceof JavaMethod) && isObjectMethod((JavaMethod) javaMember);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
    
        if (r0.equals("toString") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return r3.getValueParameters().isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r0.equals("hashCode") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean isObjectMethod(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod r3) {
        /*
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r3.getName()
            java.lang.String r0 = r0.asString()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L31
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L24
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 != r2) goto L42
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L39
            goto L42
        L24:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
            boolean r3 = isMethodWithOneObjectParameter(r3)
            goto L43
        L31:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
        L39:
            java.util.List r3 = r3.getValueParameters()
            boolean r3 = r3.isEmpty()
            goto L43
        L42:
            r3 = 0
        L43:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt.isObjectMethod(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod):boolean");
    }

    private static final boolean isMethodWithOneObjectParameter(JavaMethod javaMethod) {
        FqName fqName;
        JavaValueParameter javaValueParameter = (JavaValueParameter) CollectionsKt.singleOrNull((List) javaMethod.getValueParameters());
        JavaType type = javaValueParameter != null ? javaValueParameter.getType() : null;
        JavaClassifierType javaClassifierType = type instanceof JavaClassifierType ? (JavaClassifierType) type : null;
        if (javaClassifierType == null) {
            return false;
        }
        JavaClassifier classifier = javaClassifierType.getClassifier();
        return (classifier instanceof JavaClass) && (fqName = ((JavaClass) classifier).getFqName()) != null && Intrinsics.areEqual(fqName.asString(), "java.lang.Object");
    }
}
