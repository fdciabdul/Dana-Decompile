package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    @Override // java.lang.Comparable
    public int compareTo(DeprecationInfo deprecationInfo) {
        Intrinsics.checkNotNullParameter(deprecationInfo, "");
        int compareTo = getDeprecationLevel().compareTo(deprecationInfo.getDeprecationLevel());
        if (compareTo == 0 && !getPropagatesToOverrides() && deprecationInfo.getPropagatesToOverrides()) {
            return 1;
        }
        return compareTo;
    }
}
