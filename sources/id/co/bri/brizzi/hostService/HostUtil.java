package id.co.bri.brizzi.hostService;

import id.co.bri.brizzi.BuildConfig;

/* loaded from: classes8.dex */
public class HostUtil {
    public static final String b = "/v3.0/brizzi/checkBalance";
    public static final String c = "/v3.0/brizzi/updateBalance";
    public static final String d = "/v3.0/brizzi/validateUpdateBalance";

    /* renamed from: a  reason: collision with root package name */
    public String f8019a = BuildConfig.BASE_URL;

    private static native String cdoPddWiflkcAliw();

    private static native String ebUkidIFdckdbpcd(String str);

    private static native long ihwamIaobulJbizp(APIData aPIData);

    private static native String kagilPkcdiifPggi();

    private static native long lfbQjkMnkrqAlyJk(APIData aPIData);

    private static native long ykdDbhdfoNiJEaEk(APIData aPIData);

    public String a() {
        return kagilPkcdiifPggi();
    }

    public String a(String str) {
        return ebUkidIFdckdbpcd(str);
    }

    public void a(APIData aPIData) {
        lfbQjkMnkrqAlyJk(aPIData);
    }

    public String b() {
        return cdoPddWiflkcAliw();
    }

    public void b(APIData aPIData) {
        ihwamIaobulJbizp(aPIData);
    }

    public void c(APIData aPIData) {
        ykdDbhdfoNiJEaEk(aPIData);
    }
}
