package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a$\u0010\n\u001a\u00028\u0000\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0082\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u000f\u0010\f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"", "major", "minor", "patch", "", "apiVersionIsAtLeast", "(III)Z", "", "T", "instance", "castToBaseType", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "()I", "Lkotlin/internal/PlatformImplementations;", "IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        PlatformImplementations platformImplementations;
        Object newInstance;
        Object newInstance2;
        int javaVersion = getJavaVersion();
        if (javaVersion >= 65544 || javaVersion < 65536) {
            try {
                try {
                    newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance, "");
                    try {
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                        if (Intrinsics.areEqual(classLoader, classLoader2)) {
                            throw e;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Instance class was loaded from a different classloader: ");
                        sb.append(classLoader);
                        sb.append(", base type classloader: ");
                        sb.append(classLoader2);
                        throw new ClassNotFoundException(sb.toString(), e);
                    }
                } catch (ClassNotFoundException unused) {
                }
            } catch (ClassNotFoundException unused2) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance3, "");
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) newInstance3;
                } catch (ClassCastException e2) {
                    ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                    if (Intrinsics.areEqual(classLoader3, classLoader4)) {
                        throw e2;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Instance class was loaded from a different classloader: ");
                    sb2.append(classLoader3);
                    sb2.append(", base type classloader: ");
                    sb2.append(classLoader4);
                    throw new ClassNotFoundException(sb2.toString(), e2);
                }
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (PlatformImplementations) newInstance;
            IMPLEMENTATIONS = platformImplementations;
        }
        if (javaVersion >= 65543 || javaVersion < 65536) {
            try {
                try {
                    newInstance2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance2, "");
                    try {
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                        if (Intrinsics.areEqual(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Instance class was loaded from a different classloader: ");
                        sb3.append(classLoader5);
                        sb3.append(", base type classloader: ");
                        sb3.append(classLoader6);
                        throw new ClassNotFoundException(sb3.toString(), e3);
                    }
                } catch (ClassNotFoundException unused3) {
                }
            } catch (ClassNotFoundException unused4) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance4, "");
                try {
                    if (newInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) newInstance4;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                    if (Intrinsics.areEqual(classLoader7, classLoader8)) {
                        throw e4;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Instance class was loaded from a different classloader: ");
                    sb4.append(classLoader7);
                    sb4.append(", base type classloader: ");
                    sb4.append(classLoader8);
                    throw new ClassNotFoundException(sb4.toString(), e4);
                }
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (PlatformImplementations) newInstance2;
            IMPLEMENTATIONS = platformImplementations;
        }
        platformImplementations = new PlatformImplementations();
        IMPLEMENTATIONS = platformImplementations;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T castToBaseType(Object obj) {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            Object obj2 = obj;
            return obj;
        } catch (ClassCastException e) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instance class was loaded from a different classloader: ");
                sb.append(classLoader);
                sb.append(", base type classloader: ");
                sb.append(classLoader2);
                throw new ClassNotFoundException(sb.toString(), e);
            }
            throw e;
        }
    }

    private static final int getJavaVersion() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        String str = property;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i = indexOf$default + 1;
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '.', i, false, 4, (Object) null);
        if (indexOf$default2 < 0) {
            indexOf$default2 = property.length();
        }
        String substring = property.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String substring2 = property.substring(i, indexOf$default2);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }

    public static final boolean apiVersionIsAtLeast(int i, int i2, int i3) {
        return KotlinVersion.CURRENT.isAtLeast(i, i2, i3);
    }
}
