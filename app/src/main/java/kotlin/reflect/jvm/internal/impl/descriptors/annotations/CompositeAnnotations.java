package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public final class CompositeAnnotations implements Annotations {
    private final List<Annotations> delegates;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(List<? extends Annotations> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.delegates = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(Annotations... annotationsArr) {
        this(ArraysKt.toList(annotationsArr));
        Intrinsics.checkNotNullParameter(annotationsArr, "");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean isEmpty() {
        List<Annotations> list = this.delegates;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((Annotations) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public final boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Iterator it = CollectionsKt.asSequence(this.delegates).iterator();
        while (it.hasNext()) {
            if (((Annotations) it.next()).hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    /* renamed from: findAnnotation */
    public final AnnotationDescriptor mo4435findAnnotation(final FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.delegates), new Function1<Annotations, AnnotationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$findAnnotation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AnnotationDescriptor invoke(Annotations annotations) {
                Intrinsics.checkNotNullParameter(annotations, "");
                return annotations.mo4435findAnnotation(FqName.this);
            }
        }));
    }

    @Override // java.lang.Iterable
    public final Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.delegates), new Function1<Annotations, Sequence<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$iterator$1
            @Override // kotlin.jvm.functions.Function1
            public final Sequence<AnnotationDescriptor> invoke(Annotations annotations) {
                Intrinsics.checkNotNullParameter(annotations, "");
                return CollectionsKt.asSequence(annotations);
            }
        }).iterator();
    }
}
