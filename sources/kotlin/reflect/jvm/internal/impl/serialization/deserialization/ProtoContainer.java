package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public abstract class ProtoContainer {
    private final NameResolver nameResolver;
    private final SourceElement source;
    private final TypeTable typeTable;

    public /* synthetic */ ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(nameResolver, typeTable, sourceElement);
    }

    public abstract FqName debugFqName();

    private ProtoContainer(NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.source = sourceElement;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final SourceElement getSource() {
        return this.source;
    }

    /* loaded from: classes.dex */
    public static final class Class extends ProtoContainer {
        private final ClassId classId;
        private final ProtoBuf.Class classProto;
        private final boolean isInner;
        private final ProtoBuf.Class.Kind kind;
        private final Class outerClass;

        public final ProtoBuf.Class getClassProto() {
            return this.classProto;
        }

        public final Class getOuterClass() {
            return this.outerClass;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(ProtoBuf.Class r3, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, Class r7) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics.checkNotNullParameter(r3, "");
            Intrinsics.checkNotNullParameter(nameResolver, "");
            Intrinsics.checkNotNullParameter(typeTable, "");
            this.classProto = r3;
            this.outerClass = r7;
            this.classId = NameResolverUtilKt.getClassId(nameResolver, r3.getFqName());
            ProtoBuf.Class.Kind kind = Flags.CLASS_KIND.get(r3.getFlags());
            this.kind = kind == null ? ProtoBuf.Class.Kind.CLASS : kind;
            Boolean bool = Flags.IS_INNER.get(r3.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "");
            this.isInner = bool.booleanValue();
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final ProtoBuf.Class.Kind getKind() {
            return this.kind;
        }

        public final boolean isInner() {
            return this.isInner;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public final FqName debugFqName() {
            FqName asSingleFqName = this.classId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName, "");
            return asSingleFqName;
        }
    }

    /* loaded from: classes.dex */
    public static final class Package extends ProtoContainer {
        private final FqName fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Package(FqName fqName, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            super(nameResolver, typeTable, sourceElement, null);
            Intrinsics.checkNotNullParameter(fqName, "");
            Intrinsics.checkNotNullParameter(nameResolver, "");
            Intrinsics.checkNotNullParameter(typeTable, "");
            this.fqName = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public final FqName debugFqName() {
            return this.fqName;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": ");
        sb.append(debugFqName());
        return sb.toString();
    }
}
