package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes.dex */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    protected abstract void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void overrideConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "");
        conflict(callableMemberDescriptor, callableMemberDescriptor2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
    public void inheritanceConflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "");
        conflict(callableMemberDescriptor, callableMemberDescriptor2);
    }
}
