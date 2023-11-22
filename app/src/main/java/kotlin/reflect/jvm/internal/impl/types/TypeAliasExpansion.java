package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* loaded from: classes.dex */
public final class TypeAliasExpansion {
    public static final Companion Companion = new Companion(null);
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeAliasExpansion, typeAliasDescriptor, list, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeProjection getReplacement(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "");
        ClassifierDescriptor mo4441getDeclarationDescriptor = typeConstructor.mo4441getDeclarationDescriptor();
        if (mo4441getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return this.mapping.get(mo4441getDeclarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "");
        if (!Intrinsics.areEqual(this.descriptor, typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.parent;
            if (!(typeAliasExpansion != null ? typeAliasExpansion.isRecursion(typeAliasDescriptor) : false)) {
                return false;
            }
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TypeAliasExpansion create(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "");
            Intrinsics.checkNotNullParameter(list, "");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "");
            List<TypeParameterDescriptor> list2 = parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((TypeParameterDescriptor) it.next()).getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, MapsKt.toMap(CollectionsKt.zip(arrayList, list)), null);
        }
    }
}
