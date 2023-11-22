package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static final byte[] PlaceComponentResult = {125, -100, 71, Ascii.FS, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 114;

    private static void a(Object[] objArr) {
        byte[] bArr = PlaceComponentResult;
        byte[] bArr2 = new byte[23];
        int i = 97;
        int i2 = 3;
        int i3 = -1;
        if (bArr == null) {
            i = (3 + 97) - 8;
            i2 = 3;
            i3 = -1;
        }
        while (true) {
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr2[i4] = (byte) i;
            if (i4 == 22) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i = (i + bArr[i5]) - 8;
            i2 = i5;
            i3 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AnalyticsConnector lambda$getComponents$0(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        Object[] objArr = new Object[1];
        a(objArr);
        return AnalyticsConnectorImpl.getInstance(firebaseApp, (Context) componentContainer.get(Class.forName((String) objArr[0])), (Subscriber) componentContainer.get(Subscriber.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component.Builder add = Component.builder(AnalyticsConnector.class).add(Dependency.required(FirebaseApp.class));
        Object[] objArr = new Object[1];
        a(objArr);
        return Arrays.asList(add.add(Dependency.required(Class.forName((String) objArr[0]))).add(Dependency.required(Subscriber.class)).factory(new ComponentFactory() { // from class: com.google.firebase.analytics.connector.internal.zzb
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return AnalyticsConnectorRegistrar.lambda$getComponents$0(componentContainer);
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-analytics", "21.1.1"));
    }
}
