package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001f\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lkotlin/reflect/KType;", "type", "createMutableCollectionKType", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KType;", "createNothingType", "lowerBound", "upperBound", "createPlatformKType", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)Lkotlin/reflect/KType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "readOnlyToMutable", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class TypeOfImplKt {
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    public static final KType createPlatformKType(KType kType, KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "");
        Intrinsics.checkNotNullParameter(kType2, "");
        KotlinType type = ((KTypeImpl) kType).getType();
        Intrinsics.checkNotNull(type);
        KotlinType type2 = ((KTypeImpl) kType2).getType();
        Intrinsics.checkNotNull(type2);
        ?? r0 = 0;
        return new KTypeImpl(KotlinTypeFactory.flexibleType((SimpleType) type, (SimpleType) type2), r0, 2, r0);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    public static final KType createMutableCollectionKType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "");
        KotlinType type = ((KTypeImpl) kType).getType();
        if (!(type instanceof SimpleType)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Non-simple type cannot be a mutable collection type: ");
            sb.append(kType);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        ClassifierDescriptor mo4441getDeclarationDescriptor = type.getConstructor().mo4441getDeclarationDescriptor();
        ?? r4 = 0;
        ClassDescriptor classDescriptor = mo4441getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo4441getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Non-class type cannot be a mutable collection type: ");
            sb2.append(kType);
            throw new IllegalArgumentException(sb2.toString());
        }
        TypeConstructor typeConstructor = readOnlyToMutable(classDescriptor).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "");
        return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) type, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), r4, 2, r4);
    }

    private static final ClassDescriptor readOnlyToMutable(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptor2 = classDescriptor;
        FqName readOnlyToMutable = JavaToKotlinClassMap.INSTANCE.readOnlyToMutable(DescriptorUtilsKt.getFqNameUnsafe(classDescriptor2));
        if (readOnlyToMutable == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not a readonly collection: ");
            sb.append(classDescriptor);
            throw new IllegalArgumentException(sb.toString());
        }
        ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor2).getBuiltInClassByFqName(readOnlyToMutable);
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "");
        return builtInClassByFqName;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    public static final KType createNothingType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "");
        KotlinType type = ((KTypeImpl) kType).getType();
        if (!(type instanceof SimpleType)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Non-simple type cannot be a Nothing type: ");
            sb.append(kType);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        TypeConstructor typeConstructor = TypeUtilsKt.getBuiltIns(type).getNothing().getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "");
        ?? r2 = 0;
        return new KTypeImpl(KotlinTypeFactory.simpleType$default((SimpleType) type, (TypeAttributes) null, typeConstructor, (List) null, false, 26, (Object) null), r2, 2, r2);
    }
}
