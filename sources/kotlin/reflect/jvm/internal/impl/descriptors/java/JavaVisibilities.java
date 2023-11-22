package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

/* loaded from: classes.dex */
public final class JavaVisibilities {
    public static final JavaVisibilities INSTANCE = new JavaVisibilities();

    /* loaded from: classes.dex */
    public static final class PackageVisibility extends Visibility {
        public static final PackageVisibility INSTANCE = new PackageVisibility();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final String getInternalDisplayName() {
            return "public/*package*/";
        }

        private PackageVisibility() {
            super("package", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final Integer compareTo(Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "");
            if (this == visibility) {
                return 0;
            }
            return Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    private JavaVisibilities() {
    }

    /* loaded from: classes.dex */
    public static final class ProtectedStaticVisibility extends Visibility {
        public static final ProtectedStaticVisibility INSTANCE = new ProtectedStaticVisibility();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProtectedAndPackage extends Visibility {
        public static final ProtectedAndPackage INSTANCE = new ProtectedAndPackage();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final Integer compareTo(Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "");
            if (Intrinsics.areEqual(this, visibility)) {
                return 0;
            }
            if (visibility == Visibilities.Internal.INSTANCE) {
                return null;
            }
            return Integer.valueOf(Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public final Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }
}
