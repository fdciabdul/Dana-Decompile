package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00008Á\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/KClass;", "", "getQualifiedOrSimpleName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "qualifiedOrSimpleName"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class KClassesImplKt {
    @JvmName(name = "getQualifiedOrSimpleName")
    public static final String getQualifiedOrSimpleName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "");
        return kClass.getQualifiedName();
    }
}
