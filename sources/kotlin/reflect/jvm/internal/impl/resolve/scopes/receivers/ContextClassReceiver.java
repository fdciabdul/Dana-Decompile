package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes.dex */
public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final ClassDescriptor classDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(ClassDescriptor classDescriptor, KotlinType kotlinType, ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(classDescriptor, "");
        Intrinsics.checkNotNullParameter(kotlinType, "");
        this.classDescriptor = classDescriptor;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(": Ctx { ");
        sb.append(this.classDescriptor);
        sb.append(" }");
        return sb.toString();
    }
}
