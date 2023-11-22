package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class RemoteConfigRegistrar implements ComponentRegistrar {
    public static final byte[] MyBillsEntityDataFactory = {45, -61, Ascii.ETB, 105, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 114;

    private static void a(byte b, Object[] objArr) {
        int i = b + 4;
        byte[] bArr = MyBillsEntityDataFactory;
        byte[] bArr2 = new byte[23];
        int i2 = -1;
        int i3 = bArr == null ? (3 + (-97)) - 8 : 97;
        while (true) {
            i2++;
            i++;
            bArr2[i2] = (byte) i3;
            if (i2 == 22) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i])) - 8;
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component.Builder builder = Component.builder(RemoteConfigComponent.class);
        Object[] objArr = new Object[1];
        a((byte) -1, objArr);
        return Arrays.asList(builder.add(Dependency.required(Class.forName((String) objArr[0]))).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(AbtComponent.class)).add(Dependency.optionalProvider(AnalyticsConnector.class)).factory(new ComponentFactory() { // from class: com.google.firebase.remoteconfig.RemoteConfigRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return RemoteConfigRegistrar.lambda$getComponents$0(componentContainer);
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-rc", BuildConfig.VERSION_NAME));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RemoteConfigComponent lambda$getComponents$0(ComponentContainer componentContainer) {
        Object[] objArr = new Object[1];
        a((byte) -1, objArr);
        return new RemoteConfigComponent((Context) componentContainer.get(Class.forName((String) objArr[0])), (FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), ((AbtComponent) componentContainer.get(AbtComponent.class)).get(FirebaseABTesting.OriginService.REMOTE_CONFIG), componentContainer.getProvider(AnalyticsConnector.class));
    }
}
