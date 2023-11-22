package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* loaded from: classes.dex */
public interface JavaAnnotation extends JavaElement {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static boolean isFreshlySupportedTypeUseAnnotation(JavaAnnotation javaAnnotation) {
            return false;
        }

        public static boolean isIdeExternalAnnotation(JavaAnnotation javaAnnotation) {
            return false;
        }
    }

    Collection<JavaAnnotationArgument> getArguments();

    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    JavaClass resolve();
}
