package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/reflect/Type;", "getGenericComponentType", "()Ljava/lang/reflect/Type;", "", "getTypeName", "()Ljava/lang/String;", "", "hashCode", "()I", "toString", "elementType", "Ljava/lang/reflect/Type;", "<init>", "(Ljava/lang/reflect/Type;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {
    private final Type elementType;

    public GenericArrayTypeImpl(Type type) {
        Intrinsics.checkNotNullParameter(type, "");
        this.elementType = type;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        String typeToString;
        StringBuilder sb = new StringBuilder();
        typeToString = TypesJVMKt.typeToString(this.elementType);
        sb.append(typeToString);
        sb.append("[]");
        return sb.toString();
    }

    public final boolean equals(Object other) {
        return (other instanceof GenericArrayType) && Intrinsics.areEqual(getGenericComponentType(), ((GenericArrayType) other).getGenericComponentType());
    }

    public final int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public final String toString() {
        return getTypeName();
    }
}
