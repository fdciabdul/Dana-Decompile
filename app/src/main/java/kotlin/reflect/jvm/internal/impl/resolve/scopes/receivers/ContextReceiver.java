package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes.dex */
public final class ContextReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor declarationDescriptor;

    public final CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextReceiver(CallableDescriptor callableDescriptor, KotlinType kotlinType, ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(callableDescriptor, "");
        Intrinsics.checkNotNullParameter(kotlinType, "");
        this.declarationDescriptor = callableDescriptor;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cxt { ");
        sb.append(getDeclarationDescriptor());
        sb.append(" }");
        return sb.toString();
    }
}
