package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* loaded from: classes.dex */
public interface JavaConstructor extends JavaMember, JavaTypeParameterListOwner {
    List<JavaValueParameter> getValueParameters();
}
