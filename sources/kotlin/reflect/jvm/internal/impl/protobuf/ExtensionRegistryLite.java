package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.common.base.Ascii;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes.dex */
public class ExtensionRegistryLite {
    private static final ExtensionRegistryLite EMPTY = new ExtensionRegistryLite(true);
    private static volatile boolean eagerlyParseMessageSets;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.extensionsByNumber.get(new ObjectIntPair(containingtype, i));
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    private ExtensionRegistryLite(boolean z) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    /* loaded from: classes.dex */
    static final class ObjectIntPair {
        public static final byte[] PlaceComponentResult = {125, -100, 71, Ascii.FS, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int getAuthRequestContext = 138;
        private final int number;
        private final Object object;

        private static void a(byte b, byte b2, int i, Object[] objArr) {
            byte[] bArr = PlaceComponentResult;
            int i2 = 16 - (b * 3);
            int i3 = b2 + 4;
            int i4 = i + 105;
            byte[] bArr2 = new byte[i2];
            int i5 = -1;
            int i6 = i2 - 1;
            if (bArr == null) {
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i5 = -1;
                i4 = i4 + i6 + 2;
                i6 = i6;
                i3 = i3;
            }
            while (true) {
                int i7 = i5 + 1;
                bArr2[i7] = (byte) i4;
                if (i7 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                int i8 = i3 + 1;
                byte b3 = bArr[i8];
                objArr = objArr;
                bArr = bArr;
                bArr2 = bArr2;
                i5 = i7;
                i4 = i4 + b3 + 2;
                i6 = i6;
                i3 = i8;
            }
        }

        ObjectIntPair(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            try {
                Object[] objArr = {this.object};
                byte b = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr2 = new Object[1];
                a(b, (byte) (b | 14), (byte) (-PlaceComponentResult[5]), objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b2 = (byte) (PlaceComponentResult[5] + 1);
                byte b3 = PlaceComponentResult[5];
                Object[] objArr3 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr3);
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
