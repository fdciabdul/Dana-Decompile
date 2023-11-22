package kotlin.reflect;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0018\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Ljava/lang/reflect/Type;", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "()Ljava/lang/reflect/Type;", "getRawType", "", "getTypeName", "()Ljava/lang/String;", "", "hashCode", "()I", "toString", "ownerType", "Ljava/lang/reflect/Type;", "Ljava/lang/Class;", "rawType", "Ljava/lang/Class;", "typeArguments", "[Ljava/lang/reflect/Type;", "", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Class<?> cls, Type type, List<? extends Type> list) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.rawType = cls;
        this.ownerType = type;
        Object[] array = list.toArray(new Type[0]);
        if (array != null) {
            this.typeArguments = (Type[]) array;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.rawType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public final String getTypeName() {
        String typeToString;
        String typeToString2;
        StringBuilder sb = new StringBuilder();
        Type type = this.ownerType;
        if (type != null) {
            typeToString2 = TypesJVMKt.typeToString(type);
            sb.append(typeToString2);
            sb.append("$");
            sb.append(this.rawType.getSimpleName());
        } else {
            typeToString = TypesJVMKt.typeToString(this.rawType);
            sb.append(typeToString);
        }
        Type[] typeArr = this.typeArguments;
        if ((!(typeArr.length == 0)) != false) {
            ArraysKt.joinTo(typeArr, sb, (r14 & 2) != 0 ? ", " : null, (r14 & 4) != 0 ? "" : SimpleComparison.LESS_THAN_OPERATION, (r14 & 8) != 0 ? "" : SimpleComparison.GREATER_THAN_OPERATION, (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.INSTANCE);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final boolean equals(Object other) {
        if (other instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) other;
            if (Intrinsics.areEqual(this.rawType, parameterizedType.getRawType()) && Intrinsics.areEqual(this.ownerType, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.rawType.hashCode();
        Type type = this.ownerType;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public final String toString() {
        return getTypeName();
    }
}
