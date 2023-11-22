package id.dana.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/utils/RSAUtil;", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "getAuthRequestContext", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RSAUtil {
    public static final RSAUtil INSTANCE = new RSAUtil();

    private RSAUtil() {
    }

    @JvmStatic
    public static final String getAuthRequestContext() {
        String severity1 = JNIKey.severity1();
        return severity1 == null ? "" : severity1;
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(String p0) {
        String severity1 = JNIKey.severity1();
        if (severity1 == null) {
            severity1 = "";
        }
        return id.dana.domain.util.RSAUtil.decrypt(p0, severity1);
    }
}
