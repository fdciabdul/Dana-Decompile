package com.google.firebase.abt.component;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.firebase.abt.BuildConfig;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class AbtRegistrar implements ComponentRegistrar {
    public static final byte[] getAuthRequestContext = {63, Ascii.SUB, 111, -17, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 12;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r10) {
        /*
            byte[] r0 = com.google.firebase.abt.component.AbtRegistrar.getAuthRequestContext
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 3
            r4 = 0
            if (r0 != 0) goto Lf
            r5 = 3
            r6 = 23
            r8 = 0
            goto L28
        Lf:
            r5 = 97
            r6 = 0
        L12:
            int r3 = r3 + 1
            byte r7 = (byte) r5
            int r8 = r6 + 1
            r2[r6] = r7
            if (r8 != r1) goto L23
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2, r4)
            r10[r4] = r0
            return
        L23:
            r6 = r0[r3]
            r9 = r5
            r5 = r3
            r3 = r9
        L28:
            int r6 = -r6
            int r3 = r3 + r6
            int r3 = r3 + (-8)
            r6 = r8
            r9 = r5
            r5 = r3
            r3 = r9
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.abt.component.AbtRegistrar.a(java.lang.Object[]):void");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component.Builder builder = Component.builder(AbtComponent.class);
        Object[] objArr = new Object[1];
        a(objArr);
        return Arrays.asList(builder.add(Dependency.required(Class.forName((String) objArr[0]))).add(Dependency.optionalProvider(AnalyticsConnector.class)).factory(new ComponentFactory() { // from class: com.google.firebase.abt.component.AbtRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return AbtRegistrar.lambda$getComponents$0(componentContainer);
            }
        }).build(), LibraryVersionComponent.create("fire-abt", BuildConfig.VERSION_NAME));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AbtComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        Object[] objArr = new Object[1];
        a(objArr);
        return new AbtComponent((Context) componentContainer.get(Class.forName((String) objArr[0])), componentContainer.getProvider(AnalyticsConnector.class));
    }
}
