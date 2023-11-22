package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.common.base.Ascii;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes.dex */
public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {Ascii.US, -80, -88, -103, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 145;
    private final Name name;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 15
            int r6 = r6 + 4
            int r7 = 106 - r7
            int r8 = r8 * 2
            int r8 = r8 + 16
            byte[] r0 = kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L31:
            int r8 = -r8
            int r7 = r7 + r8
            int r6 = r6 + 1
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl.a(short, short, short, java.lang.Object[]):void");
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeclarationDescriptorImpl(Annotations annotations, Name name) {
        super(annotations);
        if (annotations == null) {
            $$$reportNull$$$0(0);
        }
        if (name == null) {
            $$$reportNull$$$0(1);
        }
        this.name = name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name name = this.name;
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        return name;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(DescriptorRenderer.DEBUG_TEXT.render(declarationDescriptor));
            sb.append("[");
            sb.append(declarationDescriptor.getClass().getSimpleName());
            sb.append(AUScreenAdaptTool.PREFIX_ID);
            try {
                Object[] objArr = {declarationDescriptor};
                byte b = BuiltInFictitiousFunctionClassFactory[5];
                byte b2 = (byte) (b - 1);
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                byte b4 = BuiltInFictitiousFunctionClassFactory[5];
                Object[] objArr3 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append("]");
                String obj = sb.toString();
                if (obj == null) {
                    $$$reportNull$$$0(5);
                }
                return obj;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(declarationDescriptor.getClass().getSimpleName());
            sb2.append(" ");
            sb2.append(declarationDescriptor.getName());
            String obj2 = sb2.toString();
            if (obj2 == null) {
                $$$reportNull$$$0(6);
            }
            return obj2;
        }
    }
}
