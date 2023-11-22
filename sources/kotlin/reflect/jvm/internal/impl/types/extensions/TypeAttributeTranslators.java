package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* loaded from: classes.dex */
public final class TypeAttributeTranslators {
    private final List<TypeAttributeTranslator> translators;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeAttributeTranslators(List<? extends TypeAttributeTranslator> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.translators = list;
    }

    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }
}
