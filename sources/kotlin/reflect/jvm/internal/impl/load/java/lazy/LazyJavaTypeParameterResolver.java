package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* loaded from: classes.dex */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    private final LazyJavaResolverContext c;
    private final DeclarationDescriptor containingDeclaration;
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    private final Map<JavaTypeParameter, Integer> typeParameters;
    private final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "");
        this.c = lazyJavaResolverContext;
        this.containingDeclaration = declarationDescriptor;
        this.typeParametersIndexOffset = i;
        this.typeParameters = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
        this.resolve = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver$resolve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final LazyJavaTypeParameterDescriptor invoke(JavaTypeParameter javaTypeParameter) {
                Map map;
                LazyJavaResolverContext lazyJavaResolverContext2;
                DeclarationDescriptor declarationDescriptor2;
                int i2;
                DeclarationDescriptor declarationDescriptor3;
                Intrinsics.checkNotNullParameter(javaTypeParameter, "");
                map = LazyJavaTypeParameterResolver.this.typeParameters;
                Integer num = (Integer) map.get(javaTypeParameter);
                if (num != null) {
                    LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = LazyJavaTypeParameterResolver.this;
                    int intValue = num.intValue();
                    lazyJavaResolverContext2 = lazyJavaTypeParameterResolver.c;
                    LazyJavaResolverContext child = ContextKt.child(lazyJavaResolverContext2, lazyJavaTypeParameterResolver);
                    declarationDescriptor2 = lazyJavaTypeParameterResolver.containingDeclaration;
                    LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(child, declarationDescriptor2.getAnnotations());
                    i2 = lazyJavaTypeParameterResolver.typeParametersIndexOffset;
                    declarationDescriptor3 = lazyJavaTypeParameterResolver.containingDeclaration;
                    return new LazyJavaTypeParameterDescriptor(copyWithNewDefaultTypeQualifiers, javaTypeParameter, i2 + intValue, declarationDescriptor3);
                }
                return null;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    public final TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "");
        LazyJavaTypeParameterDescriptor invoke = this.resolve.invoke(javaTypeParameter);
        return invoke != null ? invoke : this.c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
    }
}
