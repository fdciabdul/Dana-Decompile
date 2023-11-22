package fsimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: fsimpl.az  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0248az {

    /* renamed from: a  reason: collision with root package name */
    public String f7865a;
    public String b;
    public List c;
    public Map d;
    public String e;
    public String f;
    public byte g;
    private byte h;

    private void a(byte b, boolean z) {
        this.h = (byte) (z ? b | this.h : (b ^ (-1)) & this.h);
    }

    private boolean a(byte b) {
        return (b & this.h) != 0;
    }

    public void a() {
        if (this.d == null) {
            this.d = new HashMap();
        }
    }

    public void a(boolean z) {
        a((byte) 1, z);
    }

    public void b() {
        if (this.c == null) {
            this.c = new ArrayList();
        }
    }

    public void b(boolean z) {
        a((byte) 2, z);
    }

    public boolean c() {
        return a((byte) 1);
    }

    public boolean d() {
        return a((byte) 2);
    }

    public String toString() {
        return String.format(Locale.US, "ViewAttributeEmulation: [tagName=%s; hidden=%b; id=%s; attrPackage=%s; attrType=%d; attrHref=%s; isTextField=%b; classes=%s; attributes=%s]", this.f7865a, Boolean.valueOf(c()), this.b, this.e, Byte.valueOf(this.g), this.f, Boolean.valueOf(d()), this.c, this.d);
    }
}
