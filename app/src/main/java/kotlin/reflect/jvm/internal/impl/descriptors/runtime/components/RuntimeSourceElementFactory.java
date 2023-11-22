package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;

/* loaded from: classes.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory INSTANCE = new RuntimeSourceElementFactory();

    /* loaded from: classes.dex */
    public static final class RuntimeSourceElement implements JavaSourceElement {
        private final ReflectJavaElement javaElement;

        public RuntimeSourceElement(ReflectJavaElement reflectJavaElement) {
            Intrinsics.checkNotNullParameter(reflectJavaElement, "");
            this.javaElement = reflectJavaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        public final ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(": ");
            sb.append(getJavaElement());
            return sb.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        public final SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            Intrinsics.checkNotNullExpressionValue(sourceFile, "");
            return sourceFile;
        }
    }

    private RuntimeSourceElementFactory() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    public final JavaSourceElement source(JavaElement javaElement) {
        Intrinsics.checkNotNullParameter(javaElement, "");
        return new RuntimeSourceElement((ReflectJavaElement) javaElement);
    }
}
