package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* loaded from: classes.dex */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "");
        return runIsPossibleSubtype(typeCheckerState, simpleTypeMarker, simpleTypeMarker2);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker))) {
                typeCheckerState.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker2)) {
                typeCheckerState.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return true;
        }
        SimpleTypeMarker simpleTypeMarker3 = simpleTypeMarker;
        if (typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker3) || typeSystemContext.isNotNullTypeParameter(simpleTypeMarker3)) {
            return true;
        }
        if ((simpleTypeMarker instanceof CapturedTypeMarker) && typeSystemContext.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) {
            return true;
        }
        AbstractNullabilityChecker abstractNullabilityChecker = INSTANCE;
        if (abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, simpleTypeMarker, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2) || abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, simpleTypeMarker2, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) || typeSystemContext.isClassType(simpleTypeMarker)) {
            return false;
        }
        return abstractNullabilityChecker.hasPathByNotMarkedNullableNodes(typeCheckerState, simpleTypeMarker, typeSystemContext.typeConstructor(simpleTypeMarker2));
    }

    public final boolean hasNotNullSupertype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
        Intrinsics.checkNotNullParameter(supertypesPolicy, "");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!((typeSystemContext.isClassType(simpleTypeMarker) && !typeSystemContext.isMarkedNullable(simpleTypeMarker)) || typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker))) {
            typeCheckerState.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
            Intrinsics.checkNotNull(supertypesDeque);
            Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
            Intrinsics.checkNotNull(supertypesSet);
            supertypesDeque.push(simpleTypeMarker);
            while ((!supertypesDeque.isEmpty()) != false) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Too many supertypes for type: ");
                    sb.append(simpleTypeMarker);
                    sb.append(". Supertypes = ");
                    sb.append(CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sb.toString().toString());
                }
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, "");
                if (supertypesSet.add(pop)) {
                    TypeCheckerState.SupertypesPolicy.None none = typeSystemContext.isMarkedNullable(pop) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : supertypesPolicy;
                    if ((!Intrinsics.areEqual(none, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == false) {
                        none = null;
                    }
                    if (none != null) {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop)).iterator();
                        while (it.hasNext()) {
                            SimpleTypeMarker mo4449transformType = none.mo4449transformType(typeCheckerState, it.next());
                            if ((typeSystemContext.isClassType(mo4449transformType) && !typeSystemContext.isMarkedNullable(mo4449transformType)) || typeSystemContext.isDefinitelyNotNullType(mo4449transformType)) {
                                typeCheckerState.clear();
                            } else {
                                supertypesDeque.add(mo4449transformType);
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            typeCheckerState.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(typeCheckerState, simpleTypeMarker, typeConstructorMarker)) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while ((!supertypesDeque.isEmpty()) != false) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sb = new StringBuilder();
                sb.append("Too many supertypes for type: ");
                sb.append(simpleTypeMarker);
                sb.append(". Supertypes = ");
                sb.append(CollectionsKt.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sb.toString().toString());
            }
            SimpleTypeMarker pop = supertypesDeque.pop();
            Intrinsics.checkNotNullExpressionValue(pop, "");
            if (supertypesSet.add(pop)) {
                TypeCheckerState.SupertypesPolicy supertypesPolicy = typeSystemContext.isMarkedNullable(pop) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                if ((!Intrinsics.areEqual(supertypesPolicy, TypeCheckerState.SupertypesPolicy.None.INSTANCE)) == false) {
                    supertypesPolicy = null;
                }
                if (supertypesPolicy != null) {
                    TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                    Iterator<KotlinTypeMarker> it = typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop)).iterator();
                    while (it.hasNext()) {
                        SimpleTypeMarker mo4449transformType = supertypesPolicy.mo4449transformType(typeCheckerState, it.next());
                        if (INSTANCE.isApplicableAsEndNode(typeCheckerState, mo4449transformType, typeConstructorMarker)) {
                            typeCheckerState.clear();
                            return true;
                        }
                        supertypesDeque.add(mo4449transformType);
                    }
                } else {
                    continue;
                }
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (typeCheckerState.isStubTypeEqualsToAnything() && typeSystemContext.isStubType(simpleTypeMarker)) {
            return true;
        }
        return typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
    }
}
