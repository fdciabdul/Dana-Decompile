package kotlin.reflect.jvm.internal.impl.types;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* loaded from: classes.dex */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {86, TarHeader.LF_NORMAL, -68, 79, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 93;
    private int hashCode;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 4
            int r8 = r8 + 16
            int r6 = r6 * 15
            int r6 = 18 - r6
            int r7 = 106 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor.a(short, short, short, java.lang.Object[]):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo4441getDeclarationDescriptor();

    protected abstract boolean isSameClassifier(ClassifierDescriptor classifierDescriptor);

    public int hashCode() {
        int intValue;
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ClassifierDescriptor mo4441getDeclarationDescriptor = mo4441getDeclarationDescriptor();
        if (hasMeaningfulFqName(mo4441getDeclarationDescriptor)) {
            intValue = DescriptorUtils.getFqName(mo4441getDeclarationDescriptor).hashCode();
        } else {
            try {
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr2);
                intValue = ((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        this.hashCode = intValue;
        return intValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TypeConstructor) && obj.hashCode() == hashCode()) {
            TypeConstructor typeConstructor = (TypeConstructor) obj;
            if (typeConstructor.getParameters().size() != getParameters().size()) {
                return false;
            }
            ClassifierDescriptor mo4441getDeclarationDescriptor = mo4441getDeclarationDescriptor();
            ClassifierDescriptor mo4441getDeclarationDescriptor2 = typeConstructor.mo4441getDeclarationDescriptor();
            if (mo4441getDeclarationDescriptor2 != null && hasMeaningfulFqName(mo4441getDeclarationDescriptor) && hasMeaningfulFqName(mo4441getDeclarationDescriptor2)) {
                return isSameClassifier(mo4441getDeclarationDescriptor2);
            }
            return false;
        }
        return false;
    }

    public final boolean areFqNamesEqual(ClassifierDescriptor classifierDescriptor, ClassifierDescriptor classifierDescriptor2) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "");
        Intrinsics.checkNotNullParameter(classifierDescriptor2, "");
        if (Intrinsics.areEqual(classifierDescriptor.getName(), classifierDescriptor2.getName())) {
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            for (DeclarationDescriptor containingDeclaration2 = classifierDescriptor2.getContainingDeclaration(); containingDeclaration != null && containingDeclaration2 != null; containingDeclaration2 = containingDeclaration2.getContainingDeclaration()) {
                if (containingDeclaration instanceof ModuleDescriptor) {
                    return containingDeclaration2 instanceof ModuleDescriptor;
                }
                if (containingDeclaration2 instanceof ModuleDescriptor) {
                    return false;
                }
                if (containingDeclaration instanceof PackageFragmentDescriptor) {
                    return (containingDeclaration2 instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), ((PackageFragmentDescriptor) containingDeclaration2).getFqName());
                } else if ((containingDeclaration2 instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual(containingDeclaration.getName(), containingDeclaration2.getName())) {
                    return false;
                } else {
                    containingDeclaration = containingDeclaration.getContainingDeclaration();
                }
            }
            return true;
        }
        return false;
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor classifierDescriptor) {
        ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
        return (ErrorUtils.isError(classifierDescriptor2) || DescriptorUtils.isLocal(classifierDescriptor2)) ? false : true;
    }
}
