package fsimpl;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.fullstory.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fsimpl.dr  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0320dr {
    private final C0376z d;
    private final int e;
    private final int f;
    private int g;
    private final InterfaceC0319dq h;
    private SortedSet i;
    private ThreadPoolExecutor j;
    private dJ l;
    private C0325dw m;
    private C0327dy n;
    private final AtomicLong c = new AtomicLong(0);
    private final Object k = new Object();

    /* renamed from: a  reason: collision with root package name */
    dL f7943a = dL.NATURAL;

    /* renamed from: o  reason: collision with root package name */
    private AtomicInteger f7944o = new AtomicInteger();
    int b = 10000;

    public C0320dr(C0376z c0376z, int i, int i2, int i3, InterfaceC0319dq interfaceC0319dq) {
        this.d = c0376z;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = interfaceC0319dq;
    }

    private dH a(String str) {
        synchronized (this.k) {
            for (dH dHVar : this.i) {
                if (dHVar.f7916a.equals(str)) {
                    return dHVar;
                }
            }
            return null;
        }
    }

    private C0324dv a(File file, File file2) {
        try {
            FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
            try {
                FileLock tryLock = channel.tryLock(0L, LongCompanionObject.MAX_VALUE, false);
                if (tryLock == null || !tryLock.isValid()) {
                    eI.a(channel);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b(file).toString());
                C0324dv c0324dv = new C0324dv();
                c0324dv.d = channel;
                c0324dv.e = tryLock;
                c0324dv.i = dF.valueOf(jSONObject.getString("priority"));
                c0324dv.g = jSONObject.getLong("dateMs");
                c0324dv.b = file2;
                c0324dv.f = jSONObject.getString("originalFile");
                c0324dv.c = file;
                c0324dv.j = new URL(jSONObject.getString("url"));
                c0324dv.k = jSONObject.optString("contentType", null);
                c0324dv.h = jSONObject.optLong(GriverMonitorConstants.KEY_SIZE, 0L);
                c0324dv.l = jSONObject.optBoolean("encrypted", false);
                c0324dv.m = jSONObject.optBoolean("ready", true);
                c0324dv.n = jSONObject.optString("hash", null);
                return c0324dv;
            } catch (IOException | OverlappingFileLockException unused) {
                eI.a(channel);
                return null;
            }
        } catch (IOException | OverlappingFileLockException unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dK dKVar) {
        for (int i = 0; i < 6; i++) {
            try {
                dKVar.a();
                return;
            } catch (IOException e) {
                if (i == 5) {
                    throw e;
                }
                if ((e instanceof C0318dp) && ((C0318dp) e).a()) {
                    throw e;
                }
                Log.e("Retrying after I/O failure", e);
                try {
                    double d = this.b;
                    double pow = Math.pow(2.0d, i);
                    Double.isNaN(d);
                    Thread.sleep((long) (d * pow));
                } catch (InterruptedException unused) {
                    throw e;
                }
            } catch (Exception e2) {
                Log.e("Unexpected error while uploading", e2);
                throw e2;
            }
        }
    }

    private void a(File file) {
        try {
            this.d.a(file);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpectedly unable to trash file ");
            sb.append(file.getAbsolutePath());
            Log.e(sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IOException iOException) {
        dJ dJVar = this.l;
        if (dJVar != null) {
            dJVar.notify(str, iOException, ((long) this.n.a()) == 0 && ((long) this.j.getActiveCount()) == 1);
        }
    }

    private boolean a(dH dHVar) {
        File[] listFiles = dHVar.b.listFiles();
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected error reading session directory ");
            sb.append(dHVar.b.getAbsolutePath());
            Log.e(sb.toString());
            return false;
        }
        boolean z = false;
        for (File file : listFiles) {
            if (file.getName().endsWith(".metadata")) {
                File file2 = new File(file.getParentFile(), file.getName().substring(0, file.getName().length() - 9));
                if (file2.exists()) {
                    try {
                        C0324dv a2 = a(file, file2);
                        if (a2 != null) {
                            try {
                                a2.f7948a = dHVar;
                                a(a2);
                            } catch (IOException | JSONException unused) {
                                z = true;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Error reading metadata file: ");
                                sb2.append(file.getAbsolutePath());
                                Log.e(sb2.toString());
                            }
                        }
                        z = true;
                    } catch (IOException | JSONException unused2) {
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Missing file associated with metadata: ");
                    sb3.append(file2.getAbsolutePath());
                    Log.e(sb3.toString());
                    a(file);
                }
            }
        }
        return z;
    }

    private boolean a(C0324dv c0324dv) {
        synchronized (this.k) {
            dH dHVar = c0324dv.f7948a;
            if (c0324dv.m) {
                dHVar.d.add(c0324dv);
            } else {
                C0324dv c0324dv2 = (C0324dv) dHVar.e.put(c0324dv.n, c0324dv);
                if (c0324dv2 != null) {
                    dHVar.e.put(c0324dv.n, c0324dv2);
                    Log.d(String.format("Got a duplicate non-ready upload with hash=%s/session=%s, ignoring", c0324dv.n, dHVar.f7916a));
                    c0324dv.a();
                    return false;
                }
            }
            if (!c0324dv.m) {
                this.m.offer(c0324dv);
            } else if (this.j == null) {
                this.n.offer(new dA(this, c0324dv));
            } else {
                this.j.execute(new dA(this, c0324dv));
            }
            return true;
        }
    }

    private dH b(String str) {
        synchronized (this.k) {
            dH a2 = a(str);
            if (a2 != null) {
                return a2;
            }
            long d = d();
            File file = new File(this.d.c(), str);
            eI.a(file, this.d.b());
            File file2 = new File(file, ".session");
            file2.createNewFile();
            file2.setLastModified(d);
            dH dHVar = new dH(file, d);
            this.i.add(dHVar);
            return dHVar;
        }
    }

    private StringBuilder b(File file) {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("utf8"));
            char[] cArr = new char[10240];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return sb;
                }
                sb.append(cArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private SortedSet b() {
        TreeSet treeSet = new TreeSet();
        File[] listFiles = this.d.c().listFiles();
        if (listFiles == null) {
            Log.e("Unexpected error listing files for upload");
            return treeSet;
        }
        long d = d();
        long convert = TimeUnit.MILLISECONDS.convert(this.f, TimeUnit.DAYS);
        long convert2 = TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS);
        for (File file : listFiles) {
            if (file.isDirectory()) {
                File file2 = new File(file, ".session");
                long lastModified = file2.exists() ? file2.lastModified() : file.lastModified();
                if (lastModified <= d - convert || lastModified >= convert2 + d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Not uploading session from ");
                    sb.append(new Date(lastModified));
                    sb.append(" (now=");
                    sb.append(new Date(d));
                    sb.append(")");
                    Log.e(sb.toString());
                    a(file);
                } else {
                    treeSet.add(new dH(file, lastModified));
                }
            } else {
                a(file);
            }
            if (treeSet.size() > this.e) {
                dH dHVar = (dH) treeSet.first();
                treeSet.remove(dHVar);
                file = dHVar.b;
                a(file);
            }
        }
        return treeSet;
    }

    private void b(C0324dv c0324dv) {
        FileOutputStream fileOutputStream = new FileOutputStream(c0324dv.c);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("utf8"));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("priority", c0324dv.i);
                jSONObject.put("file", c0324dv.b.getAbsolutePath());
                jSONObject.put("originalFile", c0324dv.f);
                jSONObject.put("url", c0324dv.j.toString());
                jSONObject.put("session", c0324dv.f7948a.f7916a);
                jSONObject.put("dateMs", c0324dv.g);
                jSONObject.put("contentType", c0324dv.k);
                jSONObject.put(GriverMonitorConstants.KEY_SIZE, c0324dv.h);
                jSONObject.put("encrypted", c0324dv.l);
                jSONObject.put("hash", c0324dv.n);
                jSONObject.put("ready", c0324dv.m);
                outputStreamWriter.write(jSONObject.toString(2));
                outputStreamWriter.flush();
                fileOutputStream.close();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    private void c() {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            dH dHVar = (dH) it.next();
            if (!a(dHVar)) {
                it.remove();
                a(dHVar.b);
            }
        }
    }

    private long d() {
        int i = C0322dt.f7946a[this.f7943a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return 0L;
            }
            return this.f7944o.incrementAndGet() + 1500000000000L;
        }
        return System.currentTimeMillis();
    }

    public void a() {
        synchronized (this.k) {
            this.n = new C0327dy(10);
            this.m = new C0325dw(10);
            this.i = b();
            c();
            Runnable runnable = (Runnable) this.n.poll();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.g, this.g, 1L, TimeUnit.MINUTES, this.n, new ThreadFactoryC0321ds(this));
            this.j = threadPoolExecutor;
            if (runnable != null) {
                threadPoolExecutor.execute(runnable);
            }
        }
    }

    public void a(dC dCVar) {
        Iterator<E> it = this.m.iterator();
        while (it.hasNext()) {
            C0324dv c0324dv = (C0324dv) it.next();
            int i = C0322dt.b[dCVar.a(c0324dv.f7948a.f7916a, c0324dv.n).ordinal()];
            if (i == 1) {
                return;
            }
            if (i == 3) {
                c0324dv.a();
                this.m.remove(c0324dv);
            }
        }
    }

    public void a(dJ dJVar) {
        this.l = dJVar;
    }

    public void a(String str, File file, URL url, String str2, dF dFVar, EnumC0323du enumC0323du, dG dGVar, String str3) {
        synchronized (this.k) {
            if (str != null) {
                if (str.length() != 0 && str.matches("[a-zA-Z0-9-_]*")) {
                    if (dGVar == dG.UNREADY && str3 == null) {
                        throw new IllegalArgumentException("hash");
                    }
                    dH b = b(str);
                    File file2 = new File(b.b, UUID.randomUUID().toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(file2.getAbsolutePath());
                    sb.append(".metadata");
                    File file3 = new File(sb.toString());
                    try {
                        FileChannel channel = new RandomAccessFile(file3, "rw").getChannel();
                        try {
                            FileLock lock = channel.lock(0L, LongCompanionObject.MAX_VALUE, false);
                            if (lock == null || !lock.isValid()) {
                                eI.a(channel);
                                Log.e("Failed to lock new metadata file");
                                return;
                            }
                            C0324dv c0324dv = new C0324dv();
                            c0324dv.d = channel;
                            c0324dv.e = lock;
                            c0324dv.b = file2;
                            c0324dv.c = file3;
                            c0324dv.f = file.getName();
                            c0324dv.j = url;
                            c0324dv.i = dFVar;
                            c0324dv.g = d();
                            c0324dv.h = file.length();
                            c0324dv.f7948a = b;
                            c0324dv.k = str2;
                            boolean z = true;
                            c0324dv.l = enumC0323du == EnumC0323du.ENCRYPTED;
                            c0324dv.n = str3;
                            if (dGVar != dG.READY) {
                                z = false;
                            }
                            c0324dv.m = z;
                            if (file.renameTo(file2)) {
                                b(c0324dv);
                                a(c0324dv);
                                return;
                            }
                            c0324dv.b();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Unexpected error moving file ");
                            sb2.append(file.getAbsolutePath());
                            sb2.append(" -> ");
                            sb2.append(file2);
                            Log.e(sb2.toString());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Unexpected error moving file ");
                            sb3.append(file.getAbsolutePath());
                            sb3.append(" -> ");
                            sb3.append(file2);
                            throw new IOException(sb3.toString());
                        } catch (IOException | OverlappingFileLockException e) {
                            eI.a(channel);
                            Log.e("Failed to lock new metadata file", e);
                            return;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Log.e("Failed to create new file channel", e);
                        return;
                    } catch (OverlappingFileLockException e3) {
                        e = e3;
                        Log.e("Failed to create new file channel", e);
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("session");
        }
    }

    public boolean a(String str, String str2, dI dIVar) {
        synchronized (this.k) {
            if (str2 != null) {
                dH a2 = a(str);
                if (a2 == null) {
                    Log.w(String.format("Attempted to update a session that disappeared (session=%s/hash=%s)", str, str2));
                    return false;
                }
                C0324dv c0324dv = (C0324dv) a2.e.remove(str2);
                if (c0324dv == null) {
                    Log.w(String.format("Attempted to update a file that disappeared (session=%s/hash=%s)", str, str2));
                    return false;
                }
                this.m.remove(c0324dv);
                int i = C0322dt.c[dIVar.ordinal()];
                if (i == 1) {
                    c0324dv.m = true;
                    b(c0324dv);
                    a(c0324dv);
                } else if (i != 2) {
                    throw new IllegalArgumentException("action");
                } else {
                    c0324dv.a();
                }
                return true;
            }
            throw new IllegalArgumentException("hash");
        }
    }
}
