package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* loaded from: classes.dex */
public final class TypeIntersector {
    public static final TypeIntersector INSTANCE = new TypeIntersector();

    private TypeIntersector() {
    }

    public final SimpleType intersectTypes$descriptors(List<? extends SimpleType> list) {
        Intrinsics.checkNotNullParameter(list, "");
        list.size();
        ArrayList arrayList = new ArrayList();
        for (SimpleType simpleType : list) {
            if (simpleType.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> mo4442getSupertypes = simpleType.getConstructor().mo4442getSupertypes();
                Intrinsics.checkNotNullExpressionValue(mo4442getSupertypes, "");
                Collection<KotlinType> collection = mo4442getSupertypes;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
                for (KotlinType kotlinType : collection) {
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "");
                    SimpleType upperIfFlexible = FlexibleTypesKt.upperIfFlexible(kotlinType);
                    if (simpleType.isMarkedNullable()) {
                        upperIfFlexible = upperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(upperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(simpleType);
            }
        }
        ArrayList<SimpleType> arrayList3 = arrayList;
        ResultNullability resultNullability = ResultNullability.START;
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            resultNullability = resultNullability.combine((UnwrappedType) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (NewCapturedType newCapturedType : arrayList3) {
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (newCapturedType instanceof NewCapturedType) {
                    newCapturedType = SpecialTypesKt.withNotNullProjection((NewCapturedType) newCapturedType);
                }
                newCapturedType = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull$default(newCapturedType, false, 1, null);
            }
            linkedHashSet.add(newCapturedType);
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        List<? extends SimpleType> list2 = list;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((SimpleType) it2.next()).getAttributes());
        }
        Iterator it3 = arrayList4.iterator();
        if (!it3.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it3.next();
        while (it3.hasNext()) {
            next = ((TypeAttributes) next).intersect((TypeAttributes) it3.next());
        }
        return intersectTypesWithoutIntersectionType(linkedHashSet2).replaceAttributes((TypeAttributes) next);
    }

    private final SimpleType intersectTypesWithoutIntersectionType(final Set<? extends SimpleType> set) {
        if (set.size() == 1) {
            return (SimpleType) CollectionsKt.single(set);
        }
        new Function0<String>() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append("This collections cannot be empty! input types: ");
                sb.append(CollectionsKt.joinToString$default(set, null, null, null, 0, null, null, 63, null));
                return sb.toString();
            }
        };
        Set<? extends SimpleType> set2 = set;
        Collection<SimpleType> filterTypes = filterTypes(set2, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        filterTypes.isEmpty();
        SimpleType findIntersectionType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(filterTypes);
        if (findIntersectionType != null) {
            return findIntersectionType;
        }
        Collection<SimpleType> filterTypes2 = filterTypes(filterTypes, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(NewKotlinTypeChecker.Companion.getDefault()));
        filterTypes2.isEmpty();
        return filterTypes2.size() < 2 ? (SimpleType) CollectionsKt.single(filterTypes2) : new IntersectionTypeConstructor(set2).createType();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0054 A[EDGE_INSN: B:29:0x0054->B:20:0x0054 BREAK  A[LOOP:1: B:9:0x002d->B:33:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:1: B:9:0x002d->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.SimpleType> filterTypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.SimpleType> r8, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.types.SimpleType, ? super kotlin.reflect.jvm.internal.impl.types.SimpleType, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
        Le:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L5a
            java.lang.Object r2 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L29
            goto L53
        L29:
            java.util.Iterator r3 = r3.iterator()
        L2d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L53
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r4
            if (r4 == r2) goto L4f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            java.lang.Object r4 = r9.invoke(r4, r2)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L4f
            r4 = 1
            goto L50
        L4f:
            r4 = 0
        L50:
            if (r4 == 0) goto L2d
            goto L54
        L53:
            r5 = 0
        L54:
            if (r5 == 0) goto Le
            r8.remove()
            goto Le
        L5a:
            java.util.Collection r0 = (java.util.Collection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.filterTypes(java.util.Collection, kotlin.jvm.functions.Function2):java.util.Collection");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isStrictSupertype(KotlinType kotlinType, KotlinType kotlinType2) {
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        return newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeCheckerImpl.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    static final abstract class ResultNullability {
        public static final ResultNullability START = new START("START", 0);
        public static final ResultNullability ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final ResultNullability UNKNOWN = new UNKNOWN("UNKNOWN", 2);
        public static final ResultNullability NOT_NULL = new NOT_NULL("NOT_NULL", 3);
        private static final /* synthetic */ ResultNullability[] $VALUES = $values();

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        public /* synthetic */ ResultNullability(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        public abstract ResultNullability combine(UnwrappedType unwrappedType);

        /* loaded from: classes.dex */
        static final class START extends ResultNullability {
            START(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public final ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "");
                return getResultNullability(unwrappedType);
            }
        }

        private ResultNullability(String str, int i) {
        }

        /* loaded from: classes.dex */
        static final class ACCEPT_NULL extends ResultNullability {
            ACCEPT_NULL(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public final ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "");
                return getResultNullability(unwrappedType);
            }
        }

        /* loaded from: classes.dex */
        static final class UNKNOWN extends ResultNullability {
            UNKNOWN(String str, int i) {
                super(str, i, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public final ResultNullability combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "");
                ResultNullability resultNullability = getResultNullability(unwrappedType);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        /* loaded from: classes.dex */
        static final class NOT_NULL extends ResultNullability {
            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            public final NOT_NULL combine(UnwrappedType unwrappedType) {
                Intrinsics.checkNotNullParameter(unwrappedType, "");
                return this;
            }

            NOT_NULL(String str, int i) {
                super(str, i, null);
            }
        }

        protected final ResultNullability getResultNullability(UnwrappedType unwrappedType) {
            Intrinsics.checkNotNullParameter(unwrappedType, "");
            return unwrappedType.isMarkedNullable() ? ACCEPT_NULL : ((unwrappedType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) unwrappedType).getOriginal() instanceof StubTypeForBuilderInference)) ? NOT_NULL : ((unwrappedType instanceof StubTypeForBuilderInference) || !NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType)) ? UNKNOWN : NOT_NULL;
        }
    }
}
