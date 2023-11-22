package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class VersionSpecificBehaviorKt {
    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "");
        return isKotlin1Dot4OrLater(binaryVersion);
    }

    public static final boolean isKotlin1Dot4OrLater(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "");
        return binaryVersion.getMajor() == 1 && binaryVersion.getMinor() >= 4;
    }
}
