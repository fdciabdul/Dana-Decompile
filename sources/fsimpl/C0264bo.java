package fsimpl;

import com.fullstory.instrumentation.frameworks.compose.FSComposeCombinedModifier;
import com.fullstory.instrumentation.frameworks.compose.FSComposeModifier;

/* renamed from: fsimpl.bo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0264bo {
    public static void a(FSComposeModifier fSComposeModifier, InterfaceC0265bp interfaceC0265bp) {
        while (interfaceC0265bp != null && fSComposeModifier != null) {
            if (!(fSComposeModifier instanceof FSComposeCombinedModifier)) {
                interfaceC0265bp.accept(fSComposeModifier);
                return;
            }
            FSComposeCombinedModifier fSComposeCombinedModifier = (FSComposeCombinedModifier) fSComposeModifier;
            a(fSComposeCombinedModifier._fsGetOuter(), interfaceC0265bp);
            fSComposeModifier = fSComposeCombinedModifier._fsGetInner();
        }
    }
}
