package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* loaded from: classes.dex */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents signatureBuildingComponents, ClassDescriptor classDescriptor, String str) {
        Intrinsics.checkNotNullParameter(signatureBuildingComponents, "");
        Intrinsics.checkNotNullParameter(classDescriptor, "");
        Intrinsics.checkNotNullParameter(str, "");
        return signatureBuildingComponents.signature(MethodSignatureMappingKt.getInternalName(classDescriptor), str);
    }
}
