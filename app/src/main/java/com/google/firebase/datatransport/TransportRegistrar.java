package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class TransportRegistrar implements ComponentRegistrar {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {97, -108, 86, -98, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 202;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r8) {
        /*
            byte[] r0 = com.google.firebase.datatransport.TransportRegistrar.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 3
            r3 = 97
            r4 = 0
            if (r0 != 0) goto L11
            r3 = 3
            r5 = 0
            r6 = 97
            goto L2a
        L11:
            r5 = 0
        L12:
            int r2 = r2 + 1
            byte r6 = (byte) r3
            r1[r5] = r6
            r6 = 22
            if (r5 != r6) goto L23
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1, r4)
            r8[r4] = r0
            return
        L23:
            int r5 = r5 + 1
            r6 = r0[r2]
            r7 = r3
            r3 = r2
            r2 = r7
        L2a:
            int r6 = -r6
            int r2 = r2 + r6
            int r2 = r2 + (-8)
            r7 = r3
            r3 = r2
            r2 = r7
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.datatransport.TransportRegistrar.a(java.lang.Object[]):void");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component.Builder builder = Component.builder(TransportFactory.class);
        Object[] objArr = new Object[1];
        a(objArr);
        return Arrays.asList(builder.add(Dependency.required(Class.forName((String) objArr[0]))).factory(new ComponentFactory() { // from class: com.google.firebase.datatransport.TransportRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return TransportRegistrar.lambda$getComponents$0(componentContainer);
            }
        }).build(), LibraryVersionComponent.create("fire-transport", BuildConfig.VERSION_NAME));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ TransportFactory lambda$getComponents$0(ComponentContainer componentContainer) {
        Object[] objArr = new Object[1];
        a(objArr);
        TransportRuntime.initialize((Context) componentContainer.get(Class.forName((String) objArr[0])));
        return TransportRuntime.getInstance().newFactory(CCTDestination.LEGACY_INSTANCE);
    }
}
