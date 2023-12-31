package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes.dex */
public interface JavaClass extends JavaClassifier, JavaModifierListOwner, JavaTypeParameterListOwner {
    Collection<JavaConstructor> getConstructors();

    Collection<JavaField> getFields();

    FqName getFqName();

    Collection<Name> getInnerClassNames();

    LightClassOriginKind getLightClassOriginKind();

    Collection<JavaMethod> getMethods();

    JavaClass getOuterClass();

    Collection<JavaClassifierType> getPermittedTypes();

    Collection<JavaRecordComponent> getRecordComponents();

    Collection<JavaClassifierType> getSupertypes();

    boolean hasDefaultConstructor();

    boolean isAnnotationType();

    boolean isEnum();

    boolean isInterface();

    boolean isRecord();

    boolean isSealed();
}
