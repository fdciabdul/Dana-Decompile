package com.j256.ormlite.android;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.processing.Completion;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/* loaded from: classes8.dex */
public class OrmliteTransactionalProcessor implements Processor {
    private static final Set<Class<? extends Annotation>> annotationSet;
    private ProcessingEnvironment processingEnv;

    static {
        HashSet hashSet = new HashSet();
        annotationSet = hashSet;
        hashSet.add(DatabaseTable.class);
        hashSet.add(DatabaseField.class);
    }

    public Set<String> getSupportedOptions() {
        return Collections.emptySet();
    }

    public Set<String> getSupportedAnnotationTypes() {
        HashSet hashSet = new HashSet();
        Iterator<Class<? extends Annotation>> it = annotationSet.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        return hashSet;
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_6;
    }

    public void init(ProcessingEnvironment processingEnvironment) {
        this.processingEnv = processingEnvironment;
    }

    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotationMirror, ExecutableElement executableElement, String str) {
        return Collections.emptyList();
    }

    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Class<? extends Annotation> cls : annotationSet) {
            for (Element element : roundEnvironment.getElementsAnnotatedWith(cls)) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("-- Element ");
                sb.append(element);
                sb.append(" has annotation ");
                sb.append(cls);
                printStream.println(sb.toString());
                Messager messager = this.processingEnv.getMessager();
                Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(element);
                sb2.append(" error");
                messager.printMessage(kind, sb2.toString());
            }
        }
        return true;
    }
}
