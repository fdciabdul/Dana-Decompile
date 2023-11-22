package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public interface PackagePartProvider {
    List<String> findPackageParts(String str);

    /* loaded from: classes.dex */
    public static final class Empty implements PackagePartProvider {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        public final List<String> findPackageParts(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            return CollectionsKt.emptyList();
        }
    }
}
