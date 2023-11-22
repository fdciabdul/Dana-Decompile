package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class InvalidModuleExceptionKt {
    private static final ModuleCapability<InvalidModuleNotifier> INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability<>("InvalidModuleNotifier");

    public static final void moduleInvalidated(ModuleDescriptor moduleDescriptor) {
        Unit unit;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "");
        InvalidModuleNotifier invalidModuleNotifier = (InvalidModuleNotifier) moduleDescriptor.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY);
        if (invalidModuleNotifier != null) {
            invalidModuleNotifier.notifyModuleInvalidated(moduleDescriptor);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Accessing invalid module descriptor ");
        sb.append(moduleDescriptor);
        throw new InvalidModuleException(sb.toString());
    }
}
