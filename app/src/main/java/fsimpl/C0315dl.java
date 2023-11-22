package fsimpl;

import android.util.JsonReader;
import android.util.LruCache;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fsimpl.dl  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0315dl {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7938a;
    private static final int b;
    private static final byte[] c;
    private static final int d;
    private final RustInterface e;
    private C0320dr h;
    private Thread i;
    private int j;
    private AtomicReference f = new AtomicReference();
    private AtomicBoolean g = new AtomicBoolean();
    private LruCache k = new LruCache(200);

    static {
        byte[] bytes = "{\"sha1\":[".getBytes();
        f7938a = bytes;
        b = bytes.length;
        byte[] bytes2 = "]}".getBytes();
        c = bytes2;
        d = bytes2.length;
    }

    public C0315dl(RustInterface rustInterface, C0230ah c0230ah, C0320dr c0320dr) {
        this.e = rustInterface;
        URL a2 = a(c0230ah);
        this.f.set(a2);
        this.g.set(c0230ah != null);
        StringBuilder sb = new StringBuilder();
        sb.append("Ready check: url=");
        sb.append(a2);
        sb.append(", supported=");
        sb.append(c());
        Log.d(sb.toString());
        this.h = c0320dr;
    }

    private int a(ArrayList arrayList, OutputStream outputStream) {
        outputStream.write(f7938a);
        int i = b + 0;
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                z = false;
            } else {
                outputStream.write(44);
                i++;
            }
            outputStream.write(34);
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);
            outputStream.write(34);
            i += bytes.length + 2;
        }
        outputStream.write(c);
        return i + d;
    }

    private URL a(C0230ah c0230ah) {
        if (c0230ah == null) {
            return null;
        }
        return c0230ah.m();
    }

    private boolean a(InputStream inputStream, HashMap hashMap, int[] iArr) {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
        jsonReader.beginObject();
        if (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (!nextName.equals("sha1")) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected JSON key: ");
                sb.append(nextName);
                Log.d(sb.toString());
                return false;
            }
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                String nextString = jsonReader.nextString();
                String str = (String) hashMap.remove(nextString);
                if (str == null) {
                    iArr[3] = iArr[3] + 1;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Couldn't locate session for hash: ");
                    sb2.append(nextString);
                    Log.d(sb2.toString());
                } else {
                    iArr[4] = iArr[4] + 1;
                    this.h.a(str, nextString, dI.CONFIRM_READY);
                }
            }
            jsonReader.endArray();
            jsonReader.endObject();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00ac, code lost:
    
        if (a(r8, r3, r5) == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0315dl.d():void");
    }

    public void a() {
        eN eNVar = new eN(new RunnableC0316dm(this), "fs-ready-check");
        this.i = eNVar;
        eNVar.start();
    }

    public void b() {
        this.i.interrupt();
        this.i = null;
    }

    public Cdo c() {
        return this.g.get() ? this.f.get() != null ? Cdo.YES : Cdo.NO : Cdo.UNKNOWN;
    }
}
