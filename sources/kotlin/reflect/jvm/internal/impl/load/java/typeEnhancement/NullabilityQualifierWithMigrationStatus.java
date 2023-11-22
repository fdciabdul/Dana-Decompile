package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    private final NullabilityQualifier qualifier;

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.qualifier;
        }
        if ((i & 2) != 0) {
            z = nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "");
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NullabilityQualifierWithMigrationStatus) {
            NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
            return this.qualifier == nullabilityQualifierWithMigrationStatus.qualifier && this.isForWarningOnly == nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.qualifier.hashCode();
        boolean z = this.isForWarningOnly;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NullabilityQualifierWithMigrationStatus(qualifier=");
        sb.append(this.qualifier);
        sb.append(", isForWarningOnly=");
        sb.append(this.isForWarningOnly);
        sb.append(')');
        return sb.toString();
    }

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "");
        this.qualifier = nullabilityQualifier;
        this.isForWarningOnly = z;
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }

    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }
}
