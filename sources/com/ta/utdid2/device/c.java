package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ta.audid.g.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f7697a;
    private static final Object e = new Object();
    private static final String t;

    /* renamed from: a  reason: collision with other field name */
    private com.ta.utdid2.b.a.c f69a;

    /* renamed from: a  reason: collision with other field name */
    private d f70a;
    private com.ta.utdid2.b.a.c b;
    private Context mContext;
    private String r;
    private String s;

    /* renamed from: e  reason: collision with other field name */
    private String f72e = null;

    /* renamed from: b  reason: collision with other field name */
    private Pattern f71b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(".UTSystemConfig");
        sb.append(File.separator);
        sb.append("Global");
        t = sb.toString();
    }

    private c(Context context) {
        this.mContext = null;
        this.f70a = null;
        this.r = "xx_utdid_key";
        this.s = "xx_utdid_domain";
        this.f69a = null;
        this.b = null;
        this.mContext = context;
        this.b = new com.ta.utdid2.b.a.c(context, t, "Alvin2", false, true);
        this.f69a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f70a = new d();
        this.r = String.format("K_%d", Integer.valueOf(com.ta.utdid2.a.a.e.hashCode(this.r)));
        this.s = String.format("D_%d", Integer.valueOf(com.ta.utdid2.a.a.e.hashCode(this.s)));
    }

    private void l() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            if (com.ta.utdid2.a.a.e.isEmpty(cVar.getString("UTDID2"))) {
                String string = this.b.getString("UTDID");
                if (!com.ta.utdid2.a.a.e.isEmpty(string)) {
                    l(string);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!com.ta.utdid2.a.a.e.isEmpty(this.b.getString("DID"))) {
                this.b.remove("DID");
                z = true;
            }
            if (!com.ta.utdid2.a.a.e.isEmpty(this.b.getString("EI"))) {
                this.b.remove("EI");
                z = true;
            }
            if (com.ta.utdid2.a.a.e.isEmpty(this.b.getString("SI"))) {
                z2 = z;
            } else {
                this.b.remove("SI");
            }
            if (z2) {
                this.b.commit();
            }
        }
    }

    public static c a(Context context) {
        if (context != null && f7697a == null) {
            synchronized (e) {
                if (f7697a == null) {
                    c cVar = new c(context);
                    f7697a = cVar;
                    cVar.l();
                }
            }
        }
        return f7697a;
    }

    private void l(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.b) == null) {
                return;
            }
            cVar.putString("UTDID2", str);
            this.b.commit();
        }
    }

    private void m(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (str == null || (cVar = this.f69a) == null || str.equals(cVar.getString(this.r))) {
            return;
        }
        this.f69a.putString(this.r, str);
        this.f69a.commit();
    }

    private void n(String str) {
        if (k() && b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (b(str2)) {
                    return;
                }
                try {
                    Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void o(String str) {
        String str2;
        try {
            str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str2 = null;
        }
        if (str.equals(str2)) {
            return;
        }
        try {
            Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        } catch (Exception unused2) {
        }
    }

    private void p(String str) {
        if (!k() || str == null) {
            return;
        }
        o(str);
    }

    private String ac() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            String string = cVar.getString("UTDID2");
            if (com.ta.utdid2.a.a.e.isEmpty(string) || this.f70a.m(string) == null) {
                return null;
            }
            return string;
        }
        return null;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f71b.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public String getValue() {
        synchronized (this) {
            String str = this.f72e;
            if (str != null) {
                return str;
            }
            return ad();
        }
    }

    public String ad() {
        synchronized (this) {
            String ae = ae();
            this.f72e = ae;
            if (!TextUtils.isEmpty(ae)) {
                return this.f72e;
            }
            try {
                byte[] b = b();
                if (b != null) {
                    String encodeToString = com.ta.utdid2.a.a.b.encodeToString(b, 2);
                    this.f72e = encodeToString;
                    l(encodeToString);
                    String c = this.f70a.c(b);
                    if (c != null) {
                        p(c);
                        m(c);
                    }
                    return this.f72e;
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public String ae() {
        String str;
        String str2;
        synchronized (this) {
            try {
                str = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
            } catch (Exception unused) {
                str = "";
            }
            if (b(str)) {
                return str;
            }
            e eVar = new e();
            boolean z = false;
            try {
                str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
            } catch (Exception unused2) {
                str2 = null;
            }
            if (com.ta.utdid2.a.a.e.isEmpty(str2)) {
                z = true;
            } else {
                String o2 = eVar.o(str2);
                if (b(o2)) {
                    n(o2);
                    return o2;
                }
                String n = eVar.n(str2);
                if (b(n)) {
                    String m = this.f70a.m(n);
                    if (!com.ta.utdid2.a.a.e.isEmpty(m)) {
                        p(m);
                        try {
                            str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                        } catch (Exception unused3) {
                        }
                    }
                }
                String n2 = this.f70a.n(str2);
                if (b(n2)) {
                    this.f72e = n2;
                    l(n2);
                    m(str2);
                    n(this.f72e);
                    return this.f72e;
                }
            }
            String ac = ac();
            if (b(ac)) {
                String m2 = this.f70a.m(ac);
                if (z) {
                    p(m2);
                }
                n(ac);
                m(m2);
                this.f72e = ac;
                return ac;
            }
            String string = this.f69a.getString(this.r);
            if (!com.ta.utdid2.a.a.e.isEmpty(string)) {
                String n3 = eVar.n(string);
                if (!b(n3)) {
                    n3 = this.f70a.n(string);
                }
                if (b(n3)) {
                    String m3 = this.f70a.m(n3);
                    if (!com.ta.utdid2.a.a.e.isEmpty(n3)) {
                        this.f72e = n3;
                        if (z) {
                            p(m3);
                        }
                        l(this.f72e);
                        return this.f72e;
                    }
                }
            }
            return null;
        }
    }

    private byte[] b() throws Exception {
        String obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.a.a.c.getBytes(currentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.a.a.c.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            obj = com.ta.utdid2.a.a.d.getImei(this.mContext);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(new Random().nextInt());
            obj = sb.toString();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(com.ta.utdid2.a.a.e.hashCode(obj)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.a.a.c.getBytes(com.ta.utdid2.a.a.e.hashCode(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, -95, -126, -82, -64, 113, 116, -16, -103, TarHeader.LF_LINK, -30, 9, -39, 33, -80, -68, -78, -117, TarHeader.LF_DIR, Ascii.RS, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(h.b(bArr2), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.b.encodeToString(mac.doFinal(bArr), 2);
    }

    private boolean k() {
        return this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }
}
