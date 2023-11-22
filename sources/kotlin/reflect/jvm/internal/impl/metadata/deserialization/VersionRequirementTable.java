package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion(null);
    private static final VersionRequirementTable EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    private final List<ProtoBuf.VersionRequirement> infos;

    public /* synthetic */ VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.infos = list;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.EMPTY;
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable versionRequirementTable) {
            Intrinsics.checkNotNullParameter(versionRequirementTable, "");
            if (versionRequirementTable.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = versionRequirementTable.getRequirementList();
            Intrinsics.checkNotNullExpressionValue(requirementList, "");
            return new VersionRequirementTable(requirementList, null);
        }
    }
}
