package j$.util.stream;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class Tripwire {
    static final boolean KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: j$.util.stream.Tripwire$$ExternalSyntheticLambda0
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
