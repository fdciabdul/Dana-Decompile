package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes.dex */
public abstract class KotlinTypePreparator extends AbstractTypePreparator {
    private final SimpleType transformToNewType(SimpleType simpleType) {
        KotlinType type;
        TypeConstructor constructor = simpleType.getConstructor();
        boolean z = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r5 = null;
        UnwrappedType unwrappedType = null;
        if (constructor instanceof CapturedTypeConstructorImpl) {
            CapturedTypeConstructorImpl capturedTypeConstructorImpl = (CapturedTypeConstructorImpl) constructor;
            TypeProjection projection = capturedTypeConstructorImpl.getProjection();
            if (!(projection.getProjectionKind() == Variance.IN_VARIANCE)) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                unwrappedType = type.unwrap();
            }
            UnwrappedType unwrappedType2 = unwrappedType;
            if (capturedTypeConstructorImpl.getNewTypeConstructor() == null) {
                TypeProjection projection2 = capturedTypeConstructorImpl.getProjection();
                Collection<KotlinType> mo4442getSupertypes = capturedTypeConstructorImpl.mo4442getSupertypes();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mo4442getSupertypes, 10));
                Iterator<T> it = mo4442getSupertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((KotlinType) it.next()).unwrap());
                }
                capturedTypeConstructorImpl.setNewTypeConstructor(new NewCapturedTypeConstructor(projection2, arrayList, null, 4, null));
            }
            CaptureStatus captureStatus = CaptureStatus.FOR_SUBTYPING;
            NewCapturedTypeConstructor newTypeConstructor = capturedTypeConstructorImpl.getNewTypeConstructor();
            Intrinsics.checkNotNull(newTypeConstructor);
            return new NewCapturedType(captureStatus, newTypeConstructor, unwrappedType2, simpleType.getAttributes(), simpleType.isMarkedNullable(), false, 32, null);
        } else if (constructor instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> mo4442getSupertypes2 = ((IntegerValueTypeConstructor) constructor).mo4442getSupertypes();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(mo4442getSupertypes2, 10));
            Iterator<T> it2 = mo4442getSupertypes2.iterator();
            while (it2.hasNext()) {
                KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified((KotlinType) it2.next(), simpleType.isMarkedNullable());
                Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "");
                arrayList2.add(makeNullableAsSpecified);
            }
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(simpleType.getAttributes(), new IntersectionTypeConstructor(arrayList2), CollectionsKt.emptyList(), false, simpleType.getMemberScope());
        } else if ((constructor instanceof IntersectionTypeConstructor) && simpleType.isMarkedNullable()) {
            IntersectionTypeConstructor intersectionTypeConstructor2 = (IntersectionTypeConstructor) constructor;
            Collection<KotlinType> mo4442getSupertypes3 = intersectionTypeConstructor2.mo4442getSupertypes();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(mo4442getSupertypes3, 10));
            Iterator<T> it3 = mo4442getSupertypes3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(TypeUtilsKt.makeNullable((KotlinType) it3.next()));
                z = true;
            }
            ArrayList arrayList4 = arrayList3;
            if (z) {
                KotlinType alternativeType = intersectionTypeConstructor2.getAlternativeType();
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList4).setAlternative(alternativeType != null ? TypeUtilsKt.makeNullable(alternativeType) : null);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor2 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor2.createType();
        } else {
            return simpleType;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator
    public UnwrappedType prepareType(KotlinTypeMarker kotlinTypeMarker) {
        SimpleType flexibleType;
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "");
        if (!(kotlinTypeMarker instanceof KotlinType)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
        if (unwrap instanceof SimpleType) {
            flexibleType = transformToNewType((SimpleType) unwrap);
        } else if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType2 = (FlexibleType) unwrap;
            SimpleType transformToNewType = transformToNewType(flexibleType2.getLowerBound());
            SimpleType transformToNewType2 = transformToNewType(flexibleType2.getUpperBound());
            flexibleType = (transformToNewType == flexibleType2.getLowerBound() && transformToNewType2 == flexibleType2.getUpperBound()) ? unwrap : KotlinTypeFactory.flexibleType(transformToNewType, transformToNewType2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(flexibleType, unwrap, new KotlinTypePreparator$prepareType$1(this));
    }

    /* loaded from: classes.dex */
    public static final class Default extends KotlinTypePreparator {
        public static final Default INSTANCE = new Default();

        private Default() {
        }
    }
}
