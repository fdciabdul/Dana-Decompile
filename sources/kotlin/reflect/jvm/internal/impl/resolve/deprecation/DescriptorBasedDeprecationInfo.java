package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* loaded from: classes.dex */
public abstract class DescriptorBasedDeprecationInfo extends DeprecationInfo {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationInfo
    public boolean getPropagatesToOverrides() {
        return true;
    }
}
