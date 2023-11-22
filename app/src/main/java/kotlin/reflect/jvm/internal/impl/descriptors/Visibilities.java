package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class Visibilities {
    private static final Public DEFAULT_VISIBILITY;
    public static final Visibilities INSTANCE = new Visibilities();
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;

    /* loaded from: classes.dex */
    public static final class Private extends Visibility {
        public static final Private INSTANCE = new Private();

        private Private() {
            super("private", false);
        }
    }

    private Visibilities() {
    }

    /* loaded from: classes.dex */
    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final String getInternalDisplayName() {
            return "private/*private to this*/";
        }

        private PrivateToThis() {
            super("private_to_this", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = new Protected();

        private Protected() {
            super("protected", true);
        }
    }

    /* loaded from: classes.dex */
    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = new Internal();

        private Internal() {
            super("internal", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class Public extends Visibility {
        public static final Public INSTANCE = new Public();

        private Public() {
            super("public", true);
        }
    }

    /* loaded from: classes.dex */
    public static final class Local extends Visibility {
        public static final Local INSTANCE = new Local();

        private Local() {
            super("local", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = new Inherited();

        private Inherited() {
            super("inherited", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super("unknown", false);
        }
    }

    static {
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put(PrivateToThis.INSTANCE, 0);
        createMapBuilder.put(Private.INSTANCE, 0);
        createMapBuilder.put(Internal.INSTANCE, 1);
        createMapBuilder.put(Protected.INSTANCE, 1);
        createMapBuilder.put(Public.INSTANCE, 2);
        ORDERED_VISIBILITIES = MapsKt.build(createMapBuilder);
        DEFAULT_VISIBILITY = Public.INSTANCE;
    }

    public final Integer compareLocal$compiler_common(Visibility visibility, Visibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility, "");
        Intrinsics.checkNotNullParameter(visibility2, "");
        if (visibility == visibility2) {
            return 0;
        }
        Map<Visibility, Integer> map = ORDERED_VISIBILITIES;
        Integer num = map.get(visibility);
        Integer num2 = map.get(visibility2);
        if (num == null || num2 == null || Intrinsics.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "");
        return visibility == Private.INSTANCE || visibility == PrivateToThis.INSTANCE;
    }
}
