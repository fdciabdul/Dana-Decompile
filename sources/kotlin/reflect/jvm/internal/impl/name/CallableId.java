package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class CallableId {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Name LOCAL_NAME;
    @Deprecated
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL;
    private final Name callableName;
    private final FqName className;
    private final FqName packageName;
    private final FqName pathToLocal;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CallableId) {
            CallableId callableId = (CallableId) obj;
            return Intrinsics.areEqual(this.packageName, callableId.packageName) && Intrinsics.areEqual(this.className, callableId.className) && Intrinsics.areEqual(this.callableName, callableId.callableName) && Intrinsics.areEqual(this.pathToLocal, callableId.pathToLocal);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.packageName.hashCode();
        FqName fqName = this.className;
        int hashCode2 = fqName == null ? 0 : fqName.hashCode();
        int hashCode3 = this.callableName.hashCode();
        FqName fqName2 = this.pathToLocal;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (fqName2 != null ? fqName2.hashCode() : 0);
    }

    public CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(name, "");
        this.packageName = fqName;
        this.className = fqName2;
        this.callableName = name;
        this.pathToLocal = fqName3;
    }

    public /* synthetic */ CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, fqName2, name, (i & 8) != 0 ? null : fqName3);
    }

    /* loaded from: classes.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Name name = SpecialNames.LOCAL;
        LOCAL_NAME = name;
        FqName fqName = FqName.topLevel(name);
        Intrinsics.checkNotNullExpressionValue(fqName, "");
        PACKAGE_FQ_NAME_FOR_LOCAL = fqName;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallableId(FqName fqName, Name name) {
        this(fqName, null, name, null, 8, null);
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(name, "");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String asString = this.packageName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        sb.append(StringsKt.replace$default(asString, '.', '/', false, 4, (Object) null));
        sb.append("/");
        FqName fqName = this.className;
        if (fqName != null) {
            sb.append(fqName);
            sb.append(".");
        }
        sb.append(this.callableName);
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
