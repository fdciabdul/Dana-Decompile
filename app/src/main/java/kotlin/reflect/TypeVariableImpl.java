package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\r*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0012\u0010\fJ\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0019H\u0016¢\u0006\u0004\b \u0010\u001bR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "", "getAnnotatedBounds", "()[Ljava/lang/annotation/Annotation;", "T", "Ljava/lang/Class;", "annotationClass", "getAnnotation", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "Ljava/lang/reflect/Type;", "getBounds", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "()Ljava/lang/reflect/GenericDeclaration;", "", "getName", "()Ljava/lang/String;", "getTypeName", "", "hashCode", "()I", "toString", "Lkotlin/reflect/KTypeParameter;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "<init>", "(Lkotlin/reflect/KTypeParameter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {
    private final KTypeParameter typeParameter;

    public final <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        Intrinsics.checkNotNullParameter(annotationClass, "");
        return null;
    }

    public TypeVariableImpl(KTypeParameter kTypeParameter) {
        Intrinsics.checkNotNullParameter(kTypeParameter, "");
        this.typeParameter = kTypeParameter;
    }

    @Override // java.lang.reflect.TypeVariable
    public final String getName() {
        return this.typeParameter.getName();
    }

    @Override // java.lang.reflect.TypeVariable
    public final GenericDeclaration getGenericDeclaration() {
        StringBuilder sb = new StringBuilder();
        sb.append("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        sb.append(this.typeParameter);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("An operation is not implemented: ");
        sb2.append(obj);
        throw new NotImplementedError(sb2.toString());
    }

    @Override // java.lang.reflect.TypeVariable
    public final Type[] getBounds() {
        Type computeJavaType;
        List<KType> upperBounds = this.typeParameter.getUpperBounds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            computeJavaType = TypesJVMKt.computeJavaType((KType) it.next(), true);
            arrayList.add(computeJavaType);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        if (array != null) {
            return (Type[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        return getName();
    }

    public final boolean equals(Object other) {
        if (other instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) other;
            if (Intrinsics.areEqual(getName(), typeVariable.getName()) && Intrinsics.areEqual(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public final String toString() {
        return getTypeName();
    }

    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }

    public final Annotation[] getAnnotatedBounds() {
        return new Annotation[0];
    }
}
