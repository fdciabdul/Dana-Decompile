package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* loaded from: classes.dex */
public interface ThisClassReceiver extends ReceiverValue {
    ClassDescriptor getClassDescriptor();
}
