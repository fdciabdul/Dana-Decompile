package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* loaded from: classes.dex */
public abstract class TypeSubstitution {
    public static final Companion Companion = new Companion(null);
    public static final TypeSubstitution EMPTY = new TypeSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitution$Companion$EMPTY$1
        public final Void get(KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
        public final boolean isEmpty() {
            return true;
        }

        public final String toString() {
            return "Empty TypeSubstitution";
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
        /* renamed from: get  reason: collision with other method in class */
        public final /* bridge */ /* synthetic */ TypeProjection mo4450get(KotlinType kotlinType) {
            return (TypeProjection) get(kotlinType);
        }
    };

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public Annotations filterAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "");
        return annotations;
    }

    /* renamed from: get */
    public abstract TypeProjection mo4450get(KotlinType kotlinType);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        Intrinsics.checkNotNullParameter(variance, "");
        return kotlinType;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TypeSubstitutor buildSubstitutor() {
        TypeSubstitutor create = TypeSubstitutor.create(this);
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new TypeSubstitution() { // from class: kotlin.reflect.jvm.internal.impl.types.TypeSubstitution$replaceWithNonApproximating$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public final boolean approximateCapturedTypes() {
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public final boolean approximateContravariantCapturedTypes() {
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            /* renamed from: get */
            public final TypeProjection mo4450get(KotlinType kotlinType) {
                Intrinsics.checkNotNullParameter(kotlinType, "");
                return TypeSubstitution.this.mo4450get(kotlinType);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public final Annotations filterAnnotations(Annotations annotations) {
                Intrinsics.checkNotNullParameter(annotations, "");
                return TypeSubstitution.this.filterAnnotations(annotations);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public final KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
                Intrinsics.checkNotNullParameter(kotlinType, "");
                Intrinsics.checkNotNullParameter(variance, "");
                return TypeSubstitution.this.prepareTopLevelType(kotlinType, variance);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
            public final boolean isEmpty() {
                return TypeSubstitution.this.isEmpty();
            }
        };
    }
}
