package com.google.protobuf;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.common.base.Ascii;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets;
    private static volatile ExtensionRegistryLite emptyRegistry;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    /* loaded from: classes.dex */
    static class ExtensionClassHolder {
        static final Class<?> INSTANCE = resolveExtensionClass();

        private ExtensionClassHolder() {
        }

        static Class<?> resolveExtensionClass() {
            try {
                return Class.forName(ExtensionRegistryLite.EXTENSION_CLASS_NAME);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean z) {
        eagerlyParseMessageSets = z;
    }

    public static ExtensionRegistryLite newInstance() {
        return doFullRuntimeInheritanceCheck ? ExtensionRegistryFactory.create() : new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite;
        ExtensionRegistryLite extensionRegistryLite2 = emptyRegistry;
        if (extensionRegistryLite2 == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = emptyRegistry;
                if (extensionRegistryLite == null) {
                    extensionRegistryLite = doFullRuntimeInheritanceCheck ? ExtensionRegistryFactory.createEmpty() : EMPTY_REGISTRY_LITE;
                    emptyRegistry = extensionRegistryLite;
                }
            }
            return extensionRegistryLite;
        }
        return extensionRegistryLite2;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.extensionsByNumber.get(new ObjectIntPair(containingtype, i));
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        if (doFullRuntimeInheritanceCheck && ExtensionRegistryFactory.isFullRegistry(this)) {
            try {
                getClass().getMethod(ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD, ExtensionClassHolder.INSTANCE).invoke(this, extensionLite);
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", extensionLite), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY_REGISTRY_LITE) {
            this.extensionsByNumber = Collections.emptyMap();
        } else {
            this.extensionsByNumber = Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
        }
    }

    ExtensionRegistryLite(boolean z) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ObjectIntPair {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {83, 16, 71, 115, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int PlaceComponentResult = 0;
        private final int number;
        private final Object object;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, byte r8, short r9, java.lang.Object[] r10) {
            /*
                int r9 = 106 - r9
                int r7 = r7 * 4
                int r7 = 16 - r7
                byte[] r0 = com.google.protobuf.ExtensionRegistryLite.ObjectIntPair.BuiltInFictitiousFunctionClassFactory
                int r8 = r8 * 15
                int r8 = r8 + 4
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L15
                r3 = r9
                r4 = 0
                r9 = r8
                goto L2a
            L15:
                r3 = 0
            L16:
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r7) goto L25
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L25:
                r3 = r0[r8]
                r6 = r9
                r9 = r8
                r8 = r6
            L2a:
                int r3 = -r3
                int r8 = r8 + r3
                int r8 = r8 + 2
                int r9 = r9 + 1
                r3 = r4
                r6 = r9
                r9 = r8
                r8 = r6
                goto L16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ExtensionRegistryLite.ObjectIntPair.a(int, byte, short, java.lang.Object[]):void");
        }

        ObjectIntPair(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            try {
                Object[] objArr = {this.object};
                Object[] objArr2 = new Object[1];
                a((byte) PlaceComponentResult, BuiltInFictitiousFunctionClassFactory[5], (byte) PlaceComponentResult, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b = (byte) PlaceComponentResult;
                Object[] objArr3 = new Object[1];
                a(b, b, BuiltInFictitiousFunctionClassFactory[5], objArr3);
                return (((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue() * 65535) + this.number;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ObjectIntPair) {
                ObjectIntPair objectIntPair = (ObjectIntPair) obj;
                return this.object == objectIntPair.object && this.number == objectIntPair.number;
            }
            return false;
        }
    }
}
