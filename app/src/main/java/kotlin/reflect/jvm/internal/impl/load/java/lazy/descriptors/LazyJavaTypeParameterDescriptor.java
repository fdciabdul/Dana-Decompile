package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes.dex */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaResolverContext c;
    private final JavaTypeParameter javaTypeParameter;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* renamed from: reportSupertypeLoopError */
    public final void mo4444reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaTypeParameter javaTypeParameter, int i, DeclarationDescriptor declarationDescriptor) {
        super(lazyJavaResolverContext.getStorageManager(), declarationDescriptor, new LazyJavaAnnotations(lazyJavaResolverContext, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, lazyJavaResolverContext.getComponents().getSupertypeLoopChecker());
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "");
        Intrinsics.checkNotNullParameter(javaTypeParameter, "");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "");
        this.c = lazyJavaResolverContext;
        this.javaTypeParameter = javaTypeParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public final List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            SimpleType anyType = this.c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkNotNullExpressionValue(anyType, "");
            SimpleType nullableAnyType = this.c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        Collection<JavaClassifierType> collection = upperBounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.getTypeResolver().transformJavaType((JavaClassifierType) it.next(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public final List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "");
        return this.c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.c);
    }
}
