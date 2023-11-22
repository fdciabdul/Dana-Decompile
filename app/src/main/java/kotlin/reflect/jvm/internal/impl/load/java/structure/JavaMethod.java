package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* loaded from: classes.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(JavaMethod javaMethod) {
            return javaMethod.getAnnotationParameterDefaultValue() != null;
        }
    }
}
