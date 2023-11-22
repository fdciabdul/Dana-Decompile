package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

/* loaded from: classes3.dex */
public class LibraryVersionComponent {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {75, -23, 102, -23, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 230;

    /* loaded from: classes3.dex */
    public interface VersionExtractor<T> {
        String extract(T t);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 23 - r7
            int r8 = r8 * 2
            int r8 = r8 + 97
            int r6 = r6 + 4
            byte[] r0 = com.google.firebase.platforminfo.LibraryVersionComponent.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-8)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.platforminfo.LibraryVersionComponent.a(short, short, short, java.lang.Object[]):void");
    }

    private LibraryVersionComponent() {
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(LibraryVersion.create(str, str2), LibraryVersion.class);
    }

    public static Component<?> fromContext(final String str, final VersionExtractor<Context> versionExtractor) {
        Component.Builder intoSetBuilder = Component.intoSetBuilder(LibraryVersion.class);
        byte b = (byte) (BuiltInFictitiousFunctionClassFactory[8] + 1);
        byte b2 = (byte) (b + 1);
        Object[] objArr = new Object[1];
        a(b, b2, b2, objArr);
        return intoSetBuilder.add(Dependency.required(Class.forName((String) objArr[0]))).factory(new ComponentFactory() { // from class: com.google.firebase.platforminfo.LibraryVersionComponent$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return LibraryVersionComponent.lambda$fromContext$0(str, versionExtractor, componentContainer);
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ LibraryVersion lambda$fromContext$0(String str, VersionExtractor versionExtractor, ComponentContainer componentContainer) {
        byte b = (byte) (BuiltInFictitiousFunctionClassFactory[8] + 1);
        byte b2 = (byte) (b + 1);
        Object[] objArr = new Object[1];
        a(b, b2, b2, objArr);
        return LibraryVersion.create(str, versionExtractor.extract(componentContainer.get(Class.forName((String) objArr[0]))));
    }
}
