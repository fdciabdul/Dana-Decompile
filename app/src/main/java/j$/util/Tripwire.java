package j$.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes.dex */
abstract class Tripwire {
    static final boolean MyBillsEntityDataFactory = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: j$.util.Tripwire$$ExternalSyntheticLambda0
        @Override // java.security.PrivilegedAction
        public final Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
        }
    })).booleanValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(Class cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls);
        sb.append(" tripwire tripped but logging not supported: ");
        sb.append(str);
        throw new UnsupportedOperationException(sb.toString());
    }
}
