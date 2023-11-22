package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    public static final Companion Companion = Companion.$$INSTANCE;

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();

    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NewKotlinTypeCheckerImpl Default;

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator] */
        static {
            ?? r2 = 0;
            Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, r2, 2, r2);
        }

        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }
}
