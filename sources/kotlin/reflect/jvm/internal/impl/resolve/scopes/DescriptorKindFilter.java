package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL;
    private static final int ALL_KINDS_MASK;
    public static final DescriptorKindFilter CALLABLES;
    private static final int CALLABLES_MASK;
    public static final DescriptorKindFilter CLASSIFIERS;
    private static final int CLASSIFIERS_MASK;
    public static final Companion Companion;
    private static final List<Companion.MaskToName> DEBUG_MASK_BIT_NAMES;
    private static final List<Companion.MaskToName> DEBUG_PREDEFINED_FILTERS_MASK_NAMES;
    public static final DescriptorKindFilter FUNCTIONS;
    private static final int FUNCTIONS_MASK;
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS;
    private static final int NON_SINGLETON_CLASSIFIERS_MASK;
    public static final DescriptorKindFilter PACKAGES;
    private static final int PACKAGES_MASK;
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS;
    private static final int SINGLETON_CLASSIFIERS_MASK;
    public static final DescriptorKindFilter TYPE_ALIASES;
    private static final int TYPE_ALIASES_MASK;
    public static final DescriptorKindFilter VALUES;
    private static final int VALUES_MASK;
    public static final DescriptorKindFilter VARIABLES;
    private static final int VARIABLES_MASK;
    private static int nextMaskValue;
    private final List<DescriptorKindExclude> excludes;
    private final int kindMask;

    /* JADX WARN: Multi-variable type inference failed */
    public DescriptorKindFilter(int i, List<? extends DescriptorKindExclude> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.excludes = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i &= ((DescriptorKindExclude) it.next()).getFullyExcludedDescriptorKinds() ^ (-1);
        }
        this.kindMask = i;
    }

    public /* synthetic */ DescriptorKindFilter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.excludes;
    }

    public final int getKindMask() {
        return this.kindMask;
    }

    public final boolean acceptsKinds(int i) {
        return (i & this.kindMask) != 0;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int i) {
        int i2 = i & this.kindMask;
        if (i2 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i2, this.excludes);
    }

    public final String toString() {
        Object obj;
        Iterator<T> it = DEBUG_PREDEFINED_FILTERS_MASK_NAMES.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Companion.MaskToName) obj).getMask() == this.kindMask) {
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        String name = maskToName != null ? maskToName.getName() : null;
        if (name == null) {
            List<Companion.MaskToName> list = DEBUG_MASK_BIT_NAMES;
            ArrayList arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : list) {
                String name2 = acceptsKinds(maskToName2.getMask()) ? maskToName2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = CollectionsKt.joinToString$default(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DescriptorKindFilter(");
        sb.append(name);
        sb.append(", ");
        sb.append(this.excludes);
        sb.append(')');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj);
            DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) obj;
            return Intrinsics.areEqual(this.excludes, descriptorKindFilter.excludes) && this.kindMask == descriptorKindFilter.kindMask;
        }
        return false;
    }

    public final int hashCode() {
        return (this.excludes.hashCode() * 31) + this.kindMask;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int nextMask() {
            int i = DescriptorKindFilter.nextMaskValue;
            Companion companion = DescriptorKindFilter.Companion;
            DescriptorKindFilter.nextMaskValue <<= 1;
            return i;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.NON_SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.SINGLETON_CLASSIFIERS_MASK;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.TYPE_ALIASES_MASK;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.PACKAGES_MASK;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.FUNCTIONS_MASK;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.VARIABLES_MASK;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.ALL_KINDS_MASK;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.CLASSIFIERS_MASK;
        }

        /* loaded from: classes.dex */
        static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int i, String str) {
                Intrinsics.checkNotNullParameter(str, "");
                this.mask = i;
                this.name = str;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        Companion.MaskToName maskToName;
        Companion.MaskToName maskToName2;
        ?? r2 = 0;
        Companion companion = new Companion(r2);
        Companion = companion;
        nextMaskValue = 1;
        int nextMask = companion.nextMask();
        NON_SINGLETON_CLASSIFIERS_MASK = nextMask;
        int nextMask2 = companion.nextMask();
        SINGLETON_CLASSIFIERS_MASK = nextMask2;
        int nextMask3 = companion.nextMask();
        TYPE_ALIASES_MASK = nextMask3;
        int nextMask4 = companion.nextMask();
        PACKAGES_MASK = nextMask4;
        int nextMask5 = companion.nextMask();
        FUNCTIONS_MASK = nextMask5;
        int nextMask6 = companion.nextMask();
        VARIABLES_MASK = nextMask6;
        int nextMask7 = companion.nextMask() - 1;
        ALL_KINDS_MASK = nextMask7;
        int i = nextMask | nextMask2 | nextMask3;
        CLASSIFIERS_MASK = i;
        int i2 = nextMask2 | nextMask5 | nextMask6;
        VALUES_MASK = i2;
        int i3 = nextMask5 | nextMask6;
        CALLABLES_MASK = i3;
        int i4 = 2;
        ALL = new DescriptorKindFilter(nextMask7, r2, i4, r2);
        CALLABLES = new DescriptorKindFilter(i3, r2, i4, r2);
        NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(nextMask, r2, i4, r2);
        SINGLETON_CLASSIFIERS = new DescriptorKindFilter(nextMask2, r2, i4, r2);
        TYPE_ALIASES = new DescriptorKindFilter(nextMask3, r2, i4, r2);
        CLASSIFIERS = new DescriptorKindFilter(i, r2, i4, r2);
        PACKAGES = new DescriptorKindFilter(nextMask4, r2, i4, r2);
        FUNCTIONS = new DescriptorKindFilter(nextMask5, r2, i4, r2);
        VARIABLES = new DescriptorKindFilter(nextMask6, r2, i4, r2);
        VALUES = new DescriptorKindFilter(i2, r2, i4, r2);
        Field[] fields = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            DescriptorKindFilter descriptorKindFilter = obj instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj : null;
            if (descriptorKindFilter != null) {
                int i5 = descriptorKindFilter.kindMask;
                String name = field2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "");
                maskToName2 = new Companion.MaskToName(i5, name);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        DEBUG_PREDEFINED_FILTERS_MASK_NAMES = arrayList2;
        Field[] fields2 = DescriptorKindFilter.class.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (Intrinsics.areEqual(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Intrinsics.checkNotNull(obj3);
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "");
                maskToName = new Companion.MaskToName(intValue, name2);
            } else {
                maskToName = null;
            }
            if (maskToName != null) {
                arrayList5.add(maskToName);
            }
        }
        DEBUG_MASK_BIT_NAMES = arrayList5;
    }
}
