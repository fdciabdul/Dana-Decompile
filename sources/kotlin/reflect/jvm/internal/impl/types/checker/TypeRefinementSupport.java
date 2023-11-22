package kotlin.reflect.jvm.internal.impl.types.checker;

/* loaded from: classes.dex */
public abstract class TypeRefinementSupport {
    private final boolean isEnabled;

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    /* loaded from: classes.dex */
    public static final class Enabled extends TypeRefinementSupport {
        private final KotlinTypeRefiner typeRefiner;

        public final KotlinTypeRefiner getTypeRefiner() {
            return this.typeRefiner;
        }
    }
}
