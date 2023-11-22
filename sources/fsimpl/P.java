package fsimpl;

import android.content.Context;
import com.fullstory.util.Log;

/* loaded from: classes.dex */
public class P {

    /* renamed from: a  reason: collision with root package name */
    private Context f7810a;

    public P(Context context) {
        this.f7810a = context;
    }

    public String a(String str) {
        String a2 = cY.a(this.f7810a, cY.b, str);
        Log.v(String.format("readKey: %s='%s'", str, a2));
        return a2;
    }

    public void a(String str, Boolean bool) {
        boolean a2 = cY.a(this.f7810a, cY.b, str, bool);
        if (!a2) {
            Log.e(String.format("writeKeyBool '%s' failed", str));
        }
        Log.v(String.format("writeKeyBool %s='%b'; success=%b", str, bool, Boolean.valueOf(a2)));
    }

    public void a(String str, Long l) {
        boolean a2 = cY.a(this.f7810a, cY.b, str, l);
        if (!a2) {
            Log.e(String.format("writeKeyLong '%s' failed", str));
        }
        Log.v(String.format("writeKeyLong %s='%d'; success=%b", str, l, Boolean.valueOf(a2)));
    }

    public void a(String str, String str2) {
        boolean a2 = cY.a(this.f7810a, cY.b, str, str2);
        if (!a2) {
            Log.e(String.format("writeKey '%s' failed", str));
        }
        Log.v(String.format("writeKey: %s='%s'; success=%b", str, str2, Boolean.valueOf(a2)));
    }

    public Boolean b(String str) {
        Boolean b = cY.b(this.f7810a, cY.b, str);
        Log.v(String.format("readKeyBool: %s='%b'", str, b));
        return b;
    }

    public Long c(String str) {
        Long c = cY.c(this.f7810a, cY.b, str);
        Log.v(String.format("readKeyLong: %s='%d'", str, c));
        return c;
    }
}
