package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* loaded from: classes.dex */
public final class TypeAttributesKt {
    public static final TypeAttributes toDefaultAttributes(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, annotations, null, null, 6, null);
    }

    public static final TypeAttributes replaceAnnotations(TypeAttributes typeAttributes, Annotations annotations) {
        TypeAttributes remove;
        Intrinsics.checkNotNullParameter(typeAttributes, "");
        Intrinsics.checkNotNullParameter(annotations, "");
        if (AnnotationsTypeAttributeKt.getAnnotations(typeAttributes) == annotations) {
            return typeAttributes;
        }
        AnnotationsTypeAttribute annotationsAttribute = AnnotationsTypeAttributeKt.getAnnotationsAttribute(typeAttributes);
        if (annotationsAttribute != null && (remove = typeAttributes.remove(annotationsAttribute)) != null) {
            typeAttributes = remove;
        }
        return (annotations.iterator().hasNext() || !annotations.isEmpty()) ? typeAttributes.plus(new AnnotationsTypeAttribute(annotations)) : typeAttributes;
    }
}
