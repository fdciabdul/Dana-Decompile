package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* loaded from: classes.dex */
public interface ResolutionAnchorProvider {
    ModuleDescriptor getResolutionAnchor(ModuleDescriptor moduleDescriptor);
}
