package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;

/* loaded from: classes.dex */
public final class ClassDeserializer {
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;
    public static final Companion Companion = new Companion(null);
    private static final Set<ClassId> BLACK_LIST = SetsKt.setOf(ClassId.topLevel(StandardNames.FqNames.cloneable.toSafe()));

    public ClassDeserializer(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "");
        this.components = deserializationComponents;
        this.classes = deserializationComponents.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<ClassKey, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$classes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ClassDescriptor invoke(ClassDeserializer.ClassKey classKey) {
                ClassDescriptor createClass;
                Intrinsics.checkNotNullParameter(classKey, "");
                createClass = ClassDeserializer.this.createClass(classKey);
                return createClass;
            }
        });
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i, Object obj) {
        if ((i & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "");
        return this.classes.invoke(new ClassKey(classId, classData));
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00b7 A[EDGE_INSN: B:103:0x00b7->B:94:0x00b7 BREAK  A[LOOP:1: B:83:0x0090->B:107:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[LOOP:1: B:83:0x0090->B:107:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey r13) {
        /*
            r12 = this;
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r13.getClassId()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r1 = r12.components
            java.lang.Iterable r1 = r1.getFictitiousClassDescriptorFactories()
            java.util.Iterator r1 = r1.iterator()
        Le:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L21
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r2 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = r2.createClass(r0)
            if (r2 == 0) goto Le
            return r2
        L21:
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> r1 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.BLACK_LIST
            boolean r1 = r1.contains(r0)
            r2 = 0
            if (r1 == 0) goto L2b
            return r2
        L2b:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData r13 = r13.getClassData()
            if (r13 != 0) goto L3e
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r13 = r12.components
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder r13 = r13.getClassDataFinder()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData r13 = r13.findClassData(r0)
            if (r13 != 0) goto L3e
            return r2
        L3e:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r1 = r13.component1()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r10 = r13.component2()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r11 = r13.component3()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r13 = r13.component4()
            kotlin.reflect.jvm.internal.impl.name.ClassId r3 = r0.getOuterClassId()
            java.lang.String r4 = ""
            if (r3 == 0) goto L79
            r5 = 2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = deserializeClass$default(r12, r3, r2, r5, r2)
            boolean r5 = r3 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            if (r5 == 0) goto L62
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r3
            goto L63
        L62:
            r3 = r2
        L63:
            if (r3 != 0) goto L66
            return r2
        L66:
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getShortClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            boolean r0 = r3.hasNestedClass$deserialization(r0)
            if (r0 != 0) goto L74
            return r2
        L74:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r3.getC()
            goto Le0
        L79:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r3 = r12.components
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider r3 = r3.getPackageFragmentProvider()
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = r0.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            java.util.List r3 = kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt.packageFragments(r3, r5)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L90:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto Lb6
            java.lang.Object r5 = r3.next()
            r6 = r5
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r6
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
            if (r7 == 0) goto Lb2
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment r6 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment) r6
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r0.getShortClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            boolean r6 = r6.hasTopLevelClass(r7)
            if (r6 != 0) goto Lb2
            r6 = 0
            goto Lb3
        Lb2:
            r6 = 1
        Lb3:
            if (r6 == 0) goto L90
            goto Lb7
        Lb6:
            r5 = r2
        Lb7:
            r0 = r5
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r0
            if (r0 != 0) goto Lbd
            return r2
        Lbd:
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r3 = r12.components
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r2 = r10.getTypeTable()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r6 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable
            r6.<init>(r2)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable$Companion r2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r5 = r10.getVersionRequirementTable()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r7 = r2.create(r5)
            r9 = 0
            r4 = r0
            r5 = r1
            r8 = r11
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r3.createContext(r4, r5, r6, r7, r8, r9)
        Le0:
            r4 = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            r3 = r0
            r5 = r10
            r6 = r1
            r7 = r11
            r8 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.createClass(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$ClassKey):kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor");
    }

    /* loaded from: classes.dex */
    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId classId, ClassData classData) {
            Intrinsics.checkNotNullParameter(classId, "");
            this.classId = classId;
            this.classData = classData;
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) obj).classId);
        }

        public final int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }
    }
}
