package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* loaded from: classes.dex */
public final class UtilsKt {
    public static final KotlinType findCorrespondingSupertype(KotlinType kotlinType, KotlinType kotlinType2, TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        boolean z;
        Intrinsics.checkNotNullParameter(kotlinType, "");
        Intrinsics.checkNotNullParameter(kotlinType2, "");
        Intrinsics.checkNotNullParameter(typeCheckingProcedureCallbacks, "");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new SubtypePathNode(kotlinType, null));
        TypeConstructor constructor = kotlinType2.getConstructor();
        while (!arrayDeque.isEmpty()) {
            SubtypePathNode subtypePathNode = (SubtypePathNode) arrayDeque.poll();
            KotlinType type = subtypePathNode.getType();
            TypeConstructor constructor2 = type.getConstructor();
            if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor2, constructor)) {
                boolean isMarkedNullable = type.isMarkedNullable();
                for (SubtypePathNode previous = subtypePathNode.getPrevious(); previous != null; previous = previous.getPrevious()) {
                    KotlinType type2 = previous.getType();
                    List<TypeProjection> arguments = type2.getArguments();
                    if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                        Iterator<T> it = arguments.iterator();
                        while (it.hasNext()) {
                            if (((TypeProjection) it.next()).getProjectionKind() != Variance.INVARIANT) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        KotlinType safeSubstitute = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(type2), false, 1, null).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "");
                        type = approximate(safeSubstitute);
                    } else {
                        type = TypeConstructorSubstitution.Companion.create(type2).buildSubstitutor().safeSubstitute(type, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(type, "");
                    }
                    isMarkedNullable = isMarkedNullable || type2.isMarkedNullable();
                }
                TypeConstructor constructor3 = type.getConstructor();
                if (typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor)) {
                    return TypeUtils.makeNullableAsSpecified(type, isMarkedNullable);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Type constructors should be equals!\nsubstitutedSuperType: ");
                sb.append(debugInfo(constructor3));
                sb.append(", \n\nsupertype: ");
                sb.append(debugInfo(constructor));
                sb.append(" \n");
                sb.append(typeCheckingProcedureCallbacks.assertEqualTypeConstructors(constructor3, constructor));
                throw new AssertionError(sb.toString());
            }
            for (KotlinType kotlinType3 : constructor2.mo4442getSupertypes()) {
                Intrinsics.checkNotNullExpressionValue(kotlinType3, "");
                arrayDeque.add(new SubtypePathNode(kotlinType3, subtypePathNode));
            }
        }
        return null;
    }

    private static final KotlinType approximate(KotlinType kotlinType) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getUpper();
    }

    private static final String debugInfo(TypeConstructor typeConstructor) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("type: ");
        sb2.append(typeConstructor);
        m4451debugInfo$lambda1$unaryPlus(sb2.toString(), sb);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("hashCode: ");
        sb3.append(typeConstructor.hashCode());
        m4451debugInfo$lambda1$unaryPlus(sb3.toString(), sb);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("javaClass: ");
        sb4.append(typeConstructor.getClass().getCanonicalName());
        m4451debugInfo$lambda1$unaryPlus(sb4.toString(), sb);
        for (ClassifierDescriptor mo4441getDeclarationDescriptor = typeConstructor.mo4441getDeclarationDescriptor(); mo4441getDeclarationDescriptor != null; mo4441getDeclarationDescriptor = mo4441getDeclarationDescriptor.getContainingDeclaration()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fqName: ");
            sb5.append(DescriptorRenderer.FQ_NAMES_IN_TYPES.render(mo4441getDeclarationDescriptor));
            m4451debugInfo$lambda1$unaryPlus(sb5.toString(), sb);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("javaClass: ");
            sb6.append(mo4441getDeclarationDescriptor.getClass().getCanonicalName());
            m4451debugInfo$lambda1$unaryPlus(sb6.toString(), sb);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    /* renamed from: debugInfo$lambda-1$unaryPlus  reason: not valid java name */
    private static final StringBuilder m4451debugInfo$lambda1$unaryPlus(String str, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(str, "");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }
}
