package kotlin.reflect.jvm.internal.impl.descriptors;

/* loaded from: classes.dex */
public interface PropertyAccessorDescriptor extends VariableAccessorDescriptor {
    PropertyDescriptor getCorrespondingProperty();

    boolean isDefault();
}
