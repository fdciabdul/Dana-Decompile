package fsimpl;

import android.graphics.Bitmap;
import com.fullstory.util.Log;
import java.io.OutputStream;

/* loaded from: classes8.dex */
class aF implements aH {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f7823a;
    final /* synthetic */ Bitmap.CompressFormat b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ aE e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aF(aE aEVar, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, int i2) {
        this.e = aEVar;
        this.f7823a = bitmap;
        this.b = compressFormat;
        this.c = i;
        this.d = i2;
    }

    @Override // fsimpl.aH
    public void a(OutputStream outputStream) {
        String str;
        String obj;
        if (aE.a(this.f7823a)) {
            str = "bitmap recycled after canvas checks and made it through to encoding, discarding from uploads";
        } else if (this.f7823a.compress(this.b, 50, outputStream)) {
            return;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to compress bitmap for unknown reasons: ");
            if (aE.a(this.f7823a)) {
                obj = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("format=");
                sb2.append(this.f7823a.getConfig());
                obj = sb2.toString();
            }
            sb.append(obj);
            sb.append(" dim=");
            sb.append(this.c);
            sb.append("x");
            sb.append(this.d);
            str = sb.toString();
        }
        Log.w(str);
    }
}
