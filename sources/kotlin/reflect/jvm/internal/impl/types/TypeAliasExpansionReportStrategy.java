package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* loaded from: classes.dex */
public interface TypeAliasExpansionReportStrategy {
    void boundsViolationInSubstitution(TypeSubstitutor typeSubstitutor, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType);

    void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(AnnotationDescriptor annotationDescriptor);

    /* loaded from: classes.dex */
    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public final void boundsViolationInSubstitution(TypeSubstitutor typeSubstitutor, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor) {
            Intrinsics.checkNotNullParameter(typeSubstitutor, "");
            Intrinsics.checkNotNullParameter(kotlinType, "");
            Intrinsics.checkNotNullParameter(kotlinType2, "");
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public final void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "");
            Intrinsics.checkNotNullParameter(kotlinType, "");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public final void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public final void repeatedAnnotation(AnnotationDescriptor annotationDescriptor) {
            Intrinsics.checkNotNullParameter(annotationDescriptor, "");
        }

        private DO_NOTHING() {
        }
    }
}
