package kotlin.reflect.jvm.internal.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations INSTANCE = new SpecialJvmAnnotations();
    private static final ClassId JAVA_LANG_ANNOTATION_REPEATABLE;
    private static final Set<ClassId> SPECIAL_ANNOTATIONS;

    private SpecialJvmAnnotations() {
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    static {
        List listOf = CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it.next()));
        }
        SPECIAL_ANNOTATIONS = linkedHashSet;
        ClassId classId = ClassId.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION);
        Intrinsics.checkNotNullExpressionValue(classId, "");
        JAVA_LANG_ANNOTATION_REPEATABLE = classId;
    }

    public final ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        kotlinJvmBinaryClass.loadClassAnnotations(new KotlinJvmBinaryClass.AnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1
            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public final void visitEnd() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
            public final KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
                Intrinsics.checkNotNullParameter(classId, "");
                Intrinsics.checkNotNullParameter(sourceElement, "");
                if (Intrinsics.areEqual(classId, JvmAbi.INSTANCE.getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION())) {
                    Ref.BooleanRef.this.element = true;
                    return null;
                }
                return null;
            }
        }, null);
        return booleanRef.element;
    }
}
