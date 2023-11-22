package fsimpl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Base64;
import com.fullstory.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class aE {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Bitmap f7822a;
    private WeakHashMap b = new WeakHashMap();
    private fg c = new fg();
    private C0315dl d;
    private C0376z e;
    private C0275bz f;
    private C0230ah g;
    private C0320dr h;

    public aE(C0230ah c0230ah, C0320dr c0320dr, C0275bz c0275bz, C0315dl c0315dl, C0376z c0376z) {
        this.g = c0230ah;
        this.h = c0320dr;
        this.d = c0315dl;
        this.e = c0376z;
        this.f = c0275bz;
    }

    private String a(Bitmap.CompressFormat compressFormat) {
        return compressFormat == Bitmap.CompressFormat.WEBP ? "image/webp" : compressFormat == Bitmap.CompressFormat.JPEG ? "image/jpeg" : compressFormat == Bitmap.CompressFormat.PNG ? "image/png" : "image/unknown";
    }

    private String a(Bitmap.CompressFormat compressFormat, aH aHVar) {
        dG dGVar;
        URL l;
        try {
            File a2 = this.e.a(compressFormat.toString().toLowerCase());
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            FileOutputStream fileOutputStream = new FileOutputStream(a2);
            try {
                aHVar.a(new aG(this, fileOutputStream, messageDigest));
                fileOutputStream.close();
                byte[] digest = messageDigest.digest();
                if (a2.length() == 0) {
                    Log.w("Cowardly refusing to upload a zero-byte image");
                    return null;
                }
                String encodeToString = Base64.encodeToString(digest, 10);
                if (this.g == null) {
                    Log.e("sessionKnobs == null but tried to upload an image");
                } else {
                    if (this.d.c() == Cdo.YES) {
                        dGVar = dG.UNREADY;
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.g.l().toExternalForm());
                        sb.append("&ClientSha1Hash=");
                        sb.append(encodeToString);
                        l = new URL(sb.toString());
                    } else {
                        dGVar = dG.READY;
                        l = this.g.l();
                    }
                    C0320dr c0320dr = this.h;
                    String b = this.g.b();
                    c0320dr.a(b, a2, l, a(compressFormat), dF.LOW, EnumC0323du.NONE, dGVar, encodeToString);
                }
                return encodeToString;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            cS.a("Unexpected error", th2);
            return null;
        }
    }

    public static boolean a(Bitmap bitmap) {
        f7822a = bitmap;
        boolean isRecycled = bitmap.isRecycled();
        f7822a = null;
        return isRecycled;
    }

    private String c(Bitmap bitmap, int i, int i2) {
        String obj;
        C0230ah c0230ah = this.g;
        if (c0230ah == null) {
            Log.e("sessionKnobs == null but tried to upload an image");
            return null;
        }
        Bitmap.CompressFormat compressFormat = c0230ah.o() ? Bitmap.CompressFormat.WEBP : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        try {
            String a2 = a(compressFormat, new aF(this, bitmap, compressFormat, i, i2));
            if (a2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to compress bitmap for unknown reasons: ");
                if (a(bitmap)) {
                    obj = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("format=");
                    sb2.append(bitmap.getConfig());
                    obj = sb2.toString();
                }
                sb.append(obj);
                sb.append(" dim=");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                Log.w(sb.toString());
            }
            return a2;
        } catch (Throwable th) {
            cS.a("Unable to cache bitmap", th);
            return null;
        }
    }

    public String a(Bitmap bitmap, int i, int i2) {
        return c(bitmap, i, i2);
    }

    public String b(Bitmap bitmap, int i, int i2) {
        Bitmap a2;
        C0350eu.b("The trackBitmap method should NEVER be called on the UI thread", new Object[0]);
        String str = (String) this.b.get(bitmap);
        if (a(bitmap)) {
            this.b.remove(bitmap);
            Log.w("bitmap recycled after canvas checks and made it through to encoding, discarding from uploads");
            return null;
        }
        int generationId = bitmap.getGenerationId();
        int density = bitmap.getDensity();
        if (this.b.containsKey(bitmap) && generationId == this.c.b(bitmap)) {
            return str;
        }
        C0274by a3 = this.f.a();
        int a4 = a3.a();
        if (Math.max(i, i2) > a4 || bitmap.getConfig() == Bitmap.Config.ALPHA_8) {
            a2 = a3.a("resize", true);
            int density2 = a2.getDensity();
            a2.setDensity(density);
            StringBuilder sb = new StringBuilder();
            sb.append("Resized before upload ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append(" -> ");
            sb.append(a4);
            sb.append("x");
            sb.append(a4);
            sb.append(" and density ");
            sb.append(density2);
            sb.append(" -> ");
            sb.append(density);
            Log.d(sb.toString());
            Canvas canvas = new Canvas(a2);
            float f = a4;
            canvas.scale(f / i, f / i2);
            if (a(bitmap)) {
                Log.w("bitmap recycled after canvas checks and made it through to encoding, discarding from uploads");
            } else if (C0353ex.a(bitmap)) {
                Bitmap b = C0353ex.b(bitmap);
                canvas.drawBitmap(b, 0.0f, 0.0f, (Paint) null);
                C0353ex.a(b, bitmap);
            } else {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            }
            density = density2;
        } else {
            a2 = bitmap;
        }
        String c = c(a2, i, i2);
        this.b.put(bitmap, c);
        this.c.a(bitmap, generationId);
        if (a2 != bitmap) {
            a2.setDensity(density);
            a3.a(a2);
        }
        return c;
    }
}
