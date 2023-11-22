package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes.dex */
public final class ClassicTypeCheckerStateKt {
    public static /* synthetic */ TypeCheckerState createClassicTypeCheckerState$default(boolean z, boolean z2, ClassicTypeSystemContext classicTypeSystemContext, KotlinTypePreparator kotlinTypePreparator, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            classicTypeSystemContext = SimpleClassicTypeSystemContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            kotlinTypePreparator = KotlinTypePreparator.Default.INSTANCE;
        }
        if ((i & 16) != 0) {
            kotlinTypeRefiner = KotlinTypeRefiner.Default.INSTANCE;
        }
        return createClassicTypeCheckerState(z, z2, classicTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static final TypeCheckerState createClassicTypeCheckerState(boolean z, boolean z2, ClassicTypeSystemContext classicTypeSystemContext, KotlinTypePreparator kotlinTypePreparator, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(classicTypeSystemContext, "");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "");
        return new TypeCheckerState(z, z2, true, classicTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }
}
