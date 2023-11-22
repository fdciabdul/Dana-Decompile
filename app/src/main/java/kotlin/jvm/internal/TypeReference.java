package kotlin.jvm.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u0012\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b/\u00100B/\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b/\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0010H\u0002¢\u0006\u0004\b\u0005\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u001a8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u00020\u000b8\u0001X\u0080\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b\"\u0010#\u001a\u0004\b!\u0010\rR\u0014\u0010$\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u00018\u0001X\u0080\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010#\u001a\u0004\b(\u0010)R\u001c\u0010.\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030+8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "", "convertPrimitiveToWrapper", "", "asString", "(Z)Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/String;", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "arguments", "Ljava/util/List;", "getArguments", "Lkotlin/reflect/KClassifier;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "flags", "I", "getFlags$kotlin_stdlib", "getFlags$kotlin_stdlib$annotations", "()V", "isMarkedNullable", "()Z", "platformTypeUpperBound", "Lkotlin/reflect/KType;", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypeReference implements KType {
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, KType kType, int i) {
        Intrinsics.checkNotNullParameter(kClassifier, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.classifier = kClassifier;
        this.arguments = list;
        this.platformTypeUpperBound = kType;
        this.flags = i;
    }

    @Override // kotlin.reflect.KType
    @JvmName(name = "getClassifier")
    public final KClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    @JvmName(name = "getArguments")
    public final List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @JvmName(name = "getPlatformTypeUpperBound$kotlin_stdlib")
    /* renamed from: getPlatformTypeUpperBound$kotlin_stdlib  reason: from getter */
    public final KType getPlatformTypeUpperBound() {
        return this.platformTypeUpperBound;
    }

    @JvmName(name = "getFlags$kotlin_stdlib")
    /* renamed from: getFlags$kotlin_stdlib  reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        this(kClassifier, list, null, z ? 1 : 0);
        Intrinsics.checkNotNullParameter(kClassifier, "");
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @JvmName(name = "getAnnotations")
    public final List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    @JvmName(name = "isMarkedNullable")
    public final boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public final boolean equals(Object other) {
        if (other instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) other;
            if (Intrinsics.areEqual(getClassifier(), typeReference.getClassifier()) && Intrinsics.areEqual(getArguments(), typeReference.getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.valueOf(this.flags).hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(asString(false));
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }

    private final String asString(boolean convertPrimitiveToWrapper) {
        String name;
        KClassifier classifier = getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        Class<?> javaClass = kClass != null ? JvmClassMappingKt.getJavaClass(kClass) : null;
        if (javaClass == null) {
            name = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (javaClass.isArray()) {
            name = getArrayClassName(javaClass);
        } else {
            name = (convertPrimitiveToWrapper && javaClass.isPrimitive()) ? JvmClassMappingKt.getJavaObjectType((KClass) getClassifier()).getName() : javaClass.getName();
        }
        String joinToString$default = getArguments().isEmpty() ? "" : CollectionsKt.joinToString$default(getArguments(), ", ", SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, 0, null, new Function1<KTypeProjection, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(KTypeProjection kTypeProjection) {
                String asString;
                Intrinsics.checkNotNullParameter(kTypeProjection, "");
                asString = TypeReference.this.asString(kTypeProjection);
                return asString;
            }
        }, 24, null);
        String str = isMarkedNullable() ? "?" : "";
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(joinToString$default);
        sb.append(str);
        String obj = sb.toString();
        KType kType = this.platformTypeUpperBound;
        if (kType instanceof TypeReference) {
            String asString = ((TypeReference) kType).asString(true);
            if (Intrinsics.areEqual(asString, obj)) {
                return obj;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append('?');
            if (Intrinsics.areEqual(asString, sb2.toString())) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj);
                sb3.append('!');
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append('(');
            sb4.append(obj);
            sb4.append("..");
            sb4.append(asString);
            sb4.append(')');
            return sb4.toString();
        }
        return obj;
    }

    @JvmName(name = "getArrayClassName")
    private final String getArrayClassName(Class<?> cls) {
        return Intrinsics.areEqual(cls, boolean[].class) ? "kotlin.BooleanArray" : Intrinsics.areEqual(cls, char[].class) ? "kotlin.CharArray" : Intrinsics.areEqual(cls, byte[].class) ? "kotlin.ByteArray" : Intrinsics.areEqual(cls, short[].class) ? "kotlin.ShortArray" : Intrinsics.areEqual(cls, int[].class) ? "kotlin.IntArray" : Intrinsics.areEqual(cls, float[].class) ? "kotlin.FloatArray" : Intrinsics.areEqual(cls, long[].class) ? "kotlin.LongArray" : Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String asString(KTypeProjection kTypeProjection) {
        String valueOf;
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        KType type = kTypeProjection.getType();
        TypeReference typeReference = type instanceof TypeReference ? (TypeReference) type : null;
        if (typeReference == null || (valueOf = typeReference.asString(true)) == null) {
            valueOf = String.valueOf(kTypeProjection.getType());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[kTypeProjection.getVariance().ordinal()];
        if (i != 1) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("in ");
                sb.append(valueOf);
                return sb.toString();
            } else if (i == 3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("out ");
                sb2.append(valueOf);
                return sb2.toString();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return valueOf;
    }
}
