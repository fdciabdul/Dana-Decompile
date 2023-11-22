package kotlin.reflect.jvm.internal.impl.types;

/* loaded from: classes.dex */
public interface CustomTypeParameter {
    boolean isTypeParameter();

    KotlinType substitutionResult(KotlinType kotlinType);
}
