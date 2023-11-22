package fsimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* renamed from: fsimpl.dc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0306dc {

    /* renamed from: a  reason: collision with root package name */
    public C0306dc f7931a;
    public byte b;
    public String c;
    public String d;
    public Map e = new HashMap();
    public Map f = new HashMap();
    public Map g = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0306dc(C0306dc c0306dc, byte b) {
        this.f7931a = c0306dc;
        this.b = b;
    }

    private static String a(byte b) {
        return (b < 0 || b >= bW.f7880a.length) ? "" : bW.a(b);
    }

    private String a(String str) {
        if (str.equals("-")) {
            return "\\-";
        }
        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) == '-') {
            sb.append('-');
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (('0' > charAt || charAt > '9') && (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '-' && charAt != '_'))) {
                int indexOf = "[]:./\\()@#%^&*'\" ".indexOf(charAt);
                sb.append('\\');
                if (indexOf == -1) {
                    sb.append(Integer.toHexString(charAt));
                }
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private String b() {
        int length = bX.f7881a.length;
        byte b = this.b;
        return (b < 0 || b >= length) ? "" : bX.a(b);
    }

    private String b(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("\"");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == '\\') {
                sb.append('\\');
            } else if (charAt < 31) {
                sb.append('\\');
                sb.append(Integer.toHexString(charAt));
            }
            sb.append(charAt);
        }
        sb.append(Typography.quote);
        return sb.toString();
    }

    public String a() {
        String b = b();
        if (this.c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            sb.append(this.c.equals("*") ? this.c : a(this.c));
            b = sb.toString();
        }
        if (this.d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            sb2.append('#');
            sb2.append(a(this.d));
            b = sb2.toString();
        }
        ArrayList arrayList = new ArrayList(this.e.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b);
            sb3.append('.');
            sb3.append(a(str));
            b = sb3.toString();
        }
        for (String str2 : this.g.keySet()) {
            Byte b2 = (Byte) this.f.get(str2);
            if (b2 == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(b);
                sb4.append('[');
                sb4.append(a(str2));
                sb4.append(']');
                b = sb4.toString();
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(b);
                sb5.append('[');
                sb5.append(a(str2));
                sb5.append(a(b2.byteValue()));
                sb5.append(b((String) this.g.get(str2)));
                sb5.append(']');
                b = sb5.toString();
            }
        }
        return b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[SelectorRules parent=");
        sb.append(this.f7931a);
        sb.append("; combinator=");
        sb.append((int) this.b);
        sb.append("; tag=");
        sb.append(this.c);
        sb.append("; id=");
        sb.append(this.d);
        sb.append("; classes=");
        sb.append(this.e);
        sb.append("; attrs=");
        sb.append(this.g);
        sb.append("; attrMatch=");
        sb.append(this.f);
        sb.append("]");
        return sb.toString();
    }
}
