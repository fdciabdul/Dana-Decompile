package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001c\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058G¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0002\u0010\u0006"}, d2 = {"Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/KClass;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "jvmErasure", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class KTypesJvm {
    public static /* synthetic */ void getJvmErasure$annotations(KType kType) {
    }

    @JvmName(name = "getJvmErasure")
    public static final KClass<?> getJvmErasure(KType kType) {
        KClass<?> jvmErasure;
        Intrinsics.checkNotNullParameter(kType, "");
        KClassifier classifier = kType.getClassifier();
        if (classifier == null || (jvmErasure = getJvmErasure(classifier)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot calculate JVM erasure for type: ");
            sb.append(kType);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return jvmErasure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmName(name = "getJvmErasure")
    public static final KClass<?> getJvmErasure(KClassifier kClassifier) {
        ClassDescriptor classDescriptor;
        KClass<?> jvmErasure;
        Intrinsics.checkNotNullParameter(kClassifier, "");
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        if (kClassifier instanceof KTypeParameter) {
            List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                KType kType = (KType) next;
                Intrinsics.checkNotNull(kType);
                ClassifierDescriptor mo4441getDeclarationDescriptor = ((KTypeImpl) kType).getType().getConstructor().mo4441getDeclarationDescriptor();
                classDescriptor = mo4441getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo4441getDeclarationDescriptor : null;
                if ((classDescriptor == null || classDescriptor.getKind() == ClassKind.INTERFACE || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true) {
                    classDescriptor = next;
                    break;
                }
            }
            KType kType2 = (KType) classDescriptor;
            if (kType2 == null) {
                kType2 = (KType) CollectionsKt.firstOrNull((List) upperBounds);
            }
            return (kType2 == null || (jvmErasure = getJvmErasure(kType2)) == null) ? Reflection.getOrCreateKotlinClass(Object.class) : jvmErasure;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot calculate JVM erasure for type: ");
        sb.append(kClassifier);
        throw new KotlinReflectionInternalError(sb.toString());
    }
}
