package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform targetPlatform) {
        Intrinsics.checkNotNullParameter(targetPlatform, "");
        return CollectionsKt.joinToString$default(targetPlatform.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}
