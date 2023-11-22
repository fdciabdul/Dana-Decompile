package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations annotations, Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations, "");
        Intrinsics.checkNotNullParameter(annotations2, "");
        return annotations.isEmpty() ? annotations2 : !annotations2.isEmpty() ? new CompositeAnnotations(annotations, annotations2) : annotations;
    }
}
