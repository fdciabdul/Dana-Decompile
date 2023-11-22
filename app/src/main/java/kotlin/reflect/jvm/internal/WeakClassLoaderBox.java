package kotlin.reflect.jvm.internal;

import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
final class WeakClassLoaderBox {
    private final int identityHashCode;
    private final WeakReference<ClassLoader> ref;
    private ClassLoader temporaryStrongRef;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {108, -22, 67, 3, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 225;

    private static void a(short s, int i, short s2, Object[] objArr) {
        int i2 = 106 - s2;
        int i3 = 16 - (s * 2);
        int i4 = i + 4;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i2 = i6 + i2 + 2;
            i6 = i6;
            i4 = i4;
        }
        while (true) {
            int i7 = i4 + 1;
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i2 = i2 + bArr[i7] + 2;
            i6 = i6;
            i4 = i7;
        }
    }

    public WeakClassLoaderBox(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "");
        this.ref = new WeakReference<>(classLoader);
        try {
            Object[] objArr = {classLoader};
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr2 = new Object[1];
            a(b, (byte) (b | 14), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr3 = new Object[1];
            a(b2, b3, (byte) (-b3), objArr3);
            this.identityHashCode = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
            this.temporaryStrongRef = classLoader;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final void setTemporaryStrongRef(ClassLoader classLoader) {
        this.temporaryStrongRef = classLoader;
    }

    public final boolean equals(Object other) {
        return (other instanceof WeakClassLoaderBox) && this.ref.get() == ((WeakClassLoaderBox) other).ref.get();
    }

    /* renamed from: hashCode  reason: from getter */
    public final int getIdentityHashCode() {
        return this.identityHashCode;
    }

    public final String toString() {
        String obj;
        ClassLoader classLoader = this.ref.get();
        return (classLoader == null || (obj = classLoader.toString()) == null) ? "<null>" : obj;
    }
}
