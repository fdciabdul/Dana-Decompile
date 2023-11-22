package kotlin.reflect.jvm.internal.impl.types.model;

/* loaded from: classes.dex */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");

    private final String presentation;

    TypeVariance(String str) {
        this.presentation = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.presentation;
    }
}
