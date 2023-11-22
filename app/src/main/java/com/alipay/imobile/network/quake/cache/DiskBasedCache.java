package com.alipay.imobile.network.quake.cache;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.cache.Cache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes3.dex */
public class DiskBasedCache implements Cache {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 54410;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 46929;
    private static char MyBillsEntityDataFactory = 39806;
    private static int PlaceComponentResult = 0;
    private static char getAuthRequestContext = 41981;
    private static int scheduleImpl = 1;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f7038a;
    private long b;
    private final File c;
    private int d;
    private boolean e;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f7039a;
        public String b;
        public String c;
        public long d;
        public long e;
        public long f;
        public Map<String, String> g;

        private b() {
        }

        public static b a(InputStream inputStream) throws IOException {
            b bVar = new b();
            if (DiskBasedCache.readInt(inputStream) == 538247942) {
                bVar.b = DiskBasedCache.readString(inputStream);
                String readString = DiskBasedCache.readString(inputStream);
                bVar.c = readString;
                if ("".equals(readString)) {
                    bVar.c = null;
                }
                bVar.d = DiskBasedCache.readLong(inputStream);
                bVar.e = DiskBasedCache.readLong(inputStream);
                bVar.f = DiskBasedCache.readLong(inputStream);
                bVar.g = DiskBasedCache.readStringStringMap(inputStream);
                return bVar;
            }
            throw new IOException();
        }

        public b(String str, Cache.Entry entry) {
            this.b = str;
            this.f7039a = entry.data.length;
            this.c = entry.dataVersion;
            this.d = entry.lastModified;
            this.e = entry.finalExpireTime;
            this.f = entry.softExpireTime;
            this.g = entry.extData;
        }

        public Cache.Entry a(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.dataVersion = this.c;
            entry.lastModified = this.d;
            entry.finalExpireTime = this.e;
            entry.softExpireTime = this.f;
            entry.extData = this.g;
            return entry;
        }

        public boolean a(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, 538247942);
                DiskBasedCache.writeString(outputStream, this.b);
                String str = this.c;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.writeString(outputStream, str);
                DiskBasedCache.writeLong(outputStream, this.d);
                DiskBasedCache.writeLong(outputStream, this.e);
                DiskBasedCache.writeLong(outputStream, this.f);
                DiskBasedCache.writeStringStringMap(this.g, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                LoggerWrapper.e(Quake.TAG, e.getMessage(), e);
                return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    static class c extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f7040a;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f7040a++;
            }
            return read;
        }

        private c(InputStream inputStream) {
            super(inputStream);
            this.f7040a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f7040a += read;
            }
            return read;
        }
    }

    public DiskBasedCache(File file, int i) {
        this.f7038a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.e = false;
        this.c = file;
        this.d = i;
    }

    private String a(String str) {
        try {
            int length = str.length() / 2;
            int hashCode = str.substring(0, length).hashCode();
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(hashCode));
            sb.append(String.valueOf(str.substring(length).hashCode()));
            String obj = sb.toString();
            try {
                int i = PlaceComponentResult + 113;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                return obj;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static String readString(InputStream inputStream) throws IOException {
        byte[] a2 = a(inputStream, (int) readLong(inputStream));
        Object[] objArr = new Object[1];
        f(4 - TextUtils.lastIndexOf("", '0'), new char[]{41771, 51858, 25042, 14333, 17165, 50741}, objArr);
        String str = new String(a2, ((String) objArr[0]).intern());
        int i = scheduleImpl + 25;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            return str;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        return str;
    }

    public static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        Map<String, String> hashMap;
        try {
            int readInt = readInt(inputStream);
            if (readInt == 0) {
                int i = scheduleImpl + 65;
                PlaceComponentResult = i % 128;
                if (!(i % 2 == 0)) {
                    hashMap = Collections.emptyMap();
                    int i2 = 45 / 0;
                } else {
                    hashMap = Collections.emptyMap();
                }
            } else {
                hashMap = new HashMap<>(readInt);
            }
            int i3 = 0;
            while (true) {
                if (i3 >= readInt) {
                    return hashMap;
                }
                int i4 = scheduleImpl + 23;
                try {
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                    hashMap.put(readString(inputStream).intern(), readString(inputStream).intern());
                    i3++;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void writeInt(OutputStream outputStream, int i) throws IOException {
        try {
            int i2 = PlaceComponentResult + 15;
            scheduleImpl = i2 % 128;
            int i3 = i2 % 2;
            outputStream.write(i & 255);
            outputStream.write((i >> 8) & 255);
            outputStream.write((i >> 16) & 255);
            outputStream.write((i >> 24) & 255);
            int i4 = PlaceComponentResult + 97;
            scheduleImpl = i4 % 128;
            if (!(i4 % 2 != 0)) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void writeLong(OutputStream outputStream, long j) throws IOException {
        try {
            int i = scheduleImpl + 63;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                outputStream.write((byte) j);
                outputStream.write((byte) (j >>> 8));
                outputStream.write((byte) (j >>> 16));
                outputStream.write((byte) (j >>> 24));
                outputStream.write((byte) (j >>> 32));
                outputStream.write((byte) (j >>> 40));
                outputStream.write((byte) (j >>> 48));
                outputStream.write((byte) (j >>> 56));
                int i3 = scheduleImpl + 121;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.alipay.imobile.network.quake.cache.Cache
    public void clear() {
        synchronized (this) {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            this.f7038a.clear();
            this.b = 0L;
            LoggerWrapper.d(Quake.TAG, "Cache cleared.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00ba: MOVE (r1 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:49:0x00ba */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.alipay.imobile.network.quake.cache.DiskBasedCache$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // com.alipay.imobile.network.quake.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.imobile.network.quake.cache.Cache.Entry get(java.lang.String r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.cache.DiskBasedCache.get(java.lang.String):com.alipay.imobile.network.quake.cache.Cache$Entry");
    }

    public File getFileForKey(String str) {
        File file = new File(this.c, a(str));
        try {
            int i = scheduleImpl + 35;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? Typography.amp : '9') != '&') {
                return file;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return file;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alipay.imobile.network.quake.cache.Cache
    public void initialize() {
        BufferedInputStream bufferedInputStream;
        synchronized (this) {
            if (!this.c.exists()) {
                if (!this.c.mkdirs()) {
                    LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Unable to create cache dir %s", this.c.getAbsolutePath()));
                }
                return;
            }
            File[] listFiles = this.c.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            b a2 = b.a(bufferedInputStream);
                            a2.f7039a = file.length();
                            a(a2.b, a2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                                LoggerWrapper.e(Quake.TAG, "", e);
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedInputStream2 = bufferedInputStream;
                            String str = Quake.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("disk cache can not read file=");
                            sb.append(file);
                            LoggerWrapper.i(str, sb.toString(), e);
                            file.delete();
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    LoggerWrapper.e(Quake.TAG, "", e3);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            }
            this.e = true;
        }
    }

    @Override // com.alipay.imobile.network.quake.cache.Cache
    public boolean isInitialized() {
        int i = PlaceComponentResult + 113;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        boolean z = this.e;
        try {
            int i3 = PlaceComponentResult + 109;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.alipay.imobile.network.quake.cache.Cache
    public void put(String str, Cache.Entry entry) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.d(Quake.TAG, "can not save the cache entry with a null key");
                return;
            }
            a(entry.data.length);
            File fileForKey = getFileForKey(str);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
                    try {
                        b bVar = new b(str, entry);
                        if (bVar.a(bufferedOutputStream)) {
                            bufferedOutputStream.write(entry.data);
                            a(str, bVar);
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                                LoggerWrapper.e(Quake.TAG, "Failed to close the output stream pointer of disk cache.");
                            }
                            return;
                        }
                        LoggerWrapper.d(Quake.TAG, LoggerWrapper.buildMessage("Failed to write header for %s", fileForKey.getAbsolutePath()));
                        throw new IOException();
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream2 = bufferedOutputStream;
                        LoggerWrapper.e(Quake.TAG, LoggerWrapper.buildMessage("Failed to put key=%s, entry=%s for %s ", str, entry, fileForKey.getAbsolutePath()), e);
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused2) {
                                LoggerWrapper.e(Quake.TAG, "Failed to close the output stream pointer of disk cache.");
                            }
                        }
                        if (!fileForKey.delete()) {
                            String str2 = Quake.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Could not clean up file ");
                            sb.append(fileForKey.getAbsolutePath());
                            LoggerWrapper.d(str2, sb.toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused3) {
                                LoggerWrapper.e(Quake.TAG, "Failed to close the output stream pointer of disk cache.");
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }
    }

    @Override // com.alipay.imobile.network.quake.cache.Cache
    public void remove(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                LoggerWrapper.d(Quake.TAG, "can not remove the cache entry with a null key");
                return;
            }
            boolean delete = getFileForKey(str).delete();
            b(str);
            if (!delete) {
                LoggerWrapper.d(Quake.TAG, LoggerWrapper.buildMessage("Could not delete cache entry for key=%s, filename=%s", str, a(str)));
            }
        }
    }

    @Override // com.alipay.imobile.network.quake.cache.Cache
    public void setMaxSizeInBytes(int i) {
        if (i > 0) {
            try {
                this.d = i;
                int i2 = scheduleImpl + 87;
                PlaceComponentResult = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        int i4 = PlaceComponentResult + 37;
        scheduleImpl = i4 % 128;
        int i5 = i4 % 2;
    }

    public static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        Iterator<Map.Entry<String, String>> it;
        if (!(map != null)) {
            writeInt(outputStream, 0);
            int i = PlaceComponentResult + 121;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return;
        }
        try {
            int i3 = PlaceComponentResult + 39;
            scheduleImpl = i3 % 128;
            if (!(i3 % 2 == 0)) {
                writeInt(outputStream, map.size());
                it = map.entrySet().iterator();
            } else {
                writeInt(outputStream, map.size());
                it = map.entrySet().iterator();
                int i4 = 86 / 0;
            }
            while (true) {
                try {
                    if (!(it.hasNext())) {
                        return;
                    }
                    int i5 = PlaceComponentResult + 99;
                    scheduleImpl = i5 % 128;
                    int i6 = i5 % 2;
                    Map.Entry<String, String> next = it.next();
                    writeString(outputStream, next.getKey());
                    writeString(outputStream, next.getValue());
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void writeString(OutputStream outputStream, String str) throws IOException {
        int i = PlaceComponentResult + 99;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = new Object[1];
            f(KeyEvent.getDeadChar(0, 0) + 5, new char[]{41771, 51858, 25042, 14333, 17165, 50741}, objArr);
            byte[] bytes = str.getBytes(((String) objArr[0]).intern());
            writeLong(outputStream, bytes.length);
            outputStream.write(bytes, 0, bytes.length);
            return;
        }
        Object[] objArr2 = new Object[1];
        f(KeyEvent.getDeadChar(1, 1) + 5, new char[]{41771, 51858, 25042, 14333, 17165, 50741}, objArr2);
        byte[] bytes2 = str.getBytes(((String) objArr2[0]).intern());
        writeLong(outputStream, bytes2.length);
        outputStream.write(bytes2, 0, bytes2.length);
    }

    private void a(int i) {
        if (LoggerWrapper.isDebuggable()) {
            String str = Quake.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Pruning currentSize=");
            sb.append(this.b);
            sb.append(", need=");
            sb.append(i);
            sb.append(", maxSize=");
            sb.append(this.d);
            LoggerWrapper.v(str, sb.toString());
        }
        long j = i;
        if (this.b + j < this.d) {
            return;
        }
        LoggerWrapper.v(Quake.TAG, "Pruning old cache entries");
        long j2 = this.b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, b>> it = this.f7038a.entrySet().iterator();
        int i2 = 0;
        try {
            do {
                if ((it.hasNext() ? 'R' : (char) 5) != 5) {
                    int i3 = PlaceComponentResult + 9;
                    scheduleImpl = i3 % 128;
                    int i4 = i3 % 2;
                    b value = it.next().getValue();
                    if (getFileForKey(value.b).delete()) {
                        this.b -= value.f7039a;
                    } else {
                        String str2 = Quake.TAG;
                        String str3 = value.b;
                        LoggerWrapper.d(str2, LoggerWrapper.buildMessage("Could not delete cache entry for key=%s, filename=%s", str3, a(str3)));
                    }
                    it.remove();
                    i2++;
                }
                LoggerWrapper.v(Quake.TAG, LoggerWrapper.buildMessage("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)));
                return;
            } while (((float) (this.b + j)) >= ((float) this.d) * 0.9f);
            LoggerWrapper.v(Quake.TAG, LoggerWrapper.buildMessage("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)));
            return;
        } catch (Exception e) {
            throw e;
        }
        int i5 = PlaceComponentResult + 15;
        scheduleImpl = i5 % 128;
        int i6 = i5 % 2;
        int i7 = PlaceComponentResult + 21;
        scheduleImpl = i7 % 128;
        int i8 = i7 % 2;
    }

    private void b(String str) {
        int i = PlaceComponentResult + 125;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        b bVar = this.f7038a.get(str);
        if ((bVar != null ? (char) 24 : 'Y') != 'Y') {
            try {
                try {
                    this.b -= bVar.f7039a;
                    this.f7038a.remove(str);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = scheduleImpl + 41;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 27 : 'Z') != 'Z') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static int readInt(InputStream inputStream) throws IOException {
        int i = scheduleImpl + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        int a2 = (a(inputStream) << 24) | a(inputStream) | 0 | (a(inputStream) << 8) | (a(inputStream) << 16);
        int i3 = scheduleImpl + 85;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return a2;
    }

    public static long readLong(InputStream inputStream) throws IOException {
        try {
            int i = scheduleImpl + 125;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            long a2 = (a(inputStream) & 255) | 0 | ((a(inputStream) & 255) << 8) | ((a(inputStream) & 255) << 16) | ((a(inputStream) & 255) << 24) | ((a(inputStream) & 255) << 32) | ((a(inputStream) & 255) << 40) | ((a(inputStream) & 255) << 48) | ((a(inputStream) & 255) << 56);
            try {
                int i3 = PlaceComponentResult + 93;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return a2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if ((!r9.f7038a.containsKey(r10)) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r9.b += r11.f7039a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r9.b += r11.f7039a - r9.f7038a.get(r10).f7039a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r9.f7038a.containsKey(r10) == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r10, com.alipay.imobile.network.quake.cache.DiskBasedCache.b r11) {
        /*
            r9 = this;
            int r0 = com.alipay.imobile.network.quake.cache.DiskBasedCache.PlaceComponentResult     // Catch: java.lang.Exception -> L62
            int r0 = r0 + 105
            int r1 = r0 % 128
            com.alipay.imobile.network.quake.cache.DiskBasedCache.scheduleImpl = r1     // Catch: java.lang.Exception -> L62
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L1c
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.cache.DiskBasedCache$b> r0 = r9.f7038a
            boolean r0 = r0.containsKey(r10)
            r3 = 14
            int r3 = r3 / r2
            if (r0 != 0) goto L33
            goto L29
        L1a:
            r10 = move-exception
            throw r10
        L1c:
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.cache.DiskBasedCache$b> r0 = r9.f7038a
            boolean r0 = r0.containsKey(r10)
            if (r0 != 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            if (r0 == 0) goto L33
        L29:
            long r3 = r9.b     // Catch: java.lang.Exception -> L31
            long r5 = r11.f7039a     // Catch: java.lang.Exception -> L31
            long r3 = r3 + r5
            r9.b = r3     // Catch: java.lang.Exception -> L31
            goto L45
        L31:
            r10 = move-exception
            throw r10
        L33:
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.cache.DiskBasedCache$b> r0 = r9.f7038a
            java.lang.Object r0 = r0.get(r10)
            com.alipay.imobile.network.quake.cache.DiskBasedCache$b r0 = (com.alipay.imobile.network.quake.cache.DiskBasedCache.b) r0
            long r3 = r9.b
            long r5 = r11.f7039a
            long r7 = r0.f7039a
            long r5 = r5 - r7
            long r3 = r3 + r5
            r9.b = r3
        L45:
            java.util.Map<java.lang.String, com.alipay.imobile.network.quake.cache.DiskBasedCache$b> r0 = r9.f7038a
            r0.put(r10, r11)
            int r10 = com.alipay.imobile.network.quake.cache.DiskBasedCache.PlaceComponentResult
            int r10 = r10 + 77
            int r11 = r10 % 128
            com.alipay.imobile.network.quake.cache.DiskBasedCache.scheduleImpl = r11
            int r10 = r10 % 2
            if (r10 != 0) goto L57
            goto L58
        L57:
            r1 = 0
        L58:
            if (r1 == 0) goto L61
            r10 = 0
            r10.hashCode()     // Catch: java.lang.Throwable -> L5f
            return
        L5f:
            r10 = move-exception
            throw r10
        L61:
            return
        L62:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.cache.DiskBasedCache.a(java.lang.String, com.alipay.imobile.network.quake.cache.DiskBasedCache$b):void");
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        int read;
        int i2 = PlaceComponentResult + 81;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        byte[] bArr = new byte[i];
        int i4 = 0;
        while (true) {
            if ((i4 < i) && (read = inputStream.read(bArr, i4, i - i4)) != -1) {
                int i5 = PlaceComponentResult + 89;
                scheduleImpl = i5 % 128;
                i4 = i5 % 2 == 0 ? i4 % read : i4 + read;
            }
        }
        if ((i4 == i ? (char) 16 : '\t') == 16) {
            int i6 = PlaceComponentResult + 31;
            scheduleImpl = i6 % 128;
            if (i6 % 2 == 0) {
                int i7 = 99 / 0;
                return bArr;
            }
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("Expected ");
            sb.append(i);
            sb.append(" bytes, read ");
            sb.append(i4);
            sb.append(" bytes");
            throw new IOException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if ((r4 != -1 ? '#' : 'M') != 'M') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        if ((r4 == -1) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        r0 = com.alipay.imobile.network.quake.cache.DiskBasedCache.PlaceComponentResult + 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        com.alipay.imobile.network.quake.cache.DiskBasedCache.scheduleImpl = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        if ((r0 % 2) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        if (r0 == true) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
    
        r0 = 10 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0049, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        throw new java.io.EOFException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.io.InputStream r4) throws java.io.IOException {
        /*
            int r0 = com.alipay.imobile.network.quake.cache.DiskBasedCache.PlaceComponentResult     // Catch: java.lang.Exception -> L50
            int r0 = r0 + 47
            int r1 = r0 % 128
            com.alipay.imobile.network.quake.cache.DiskBasedCache.scheduleImpl = r1     // Catch: java.lang.Exception -> L50
            int r0 = r0 % 2
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L25
            int r4 = r4.read()
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L23
            r0 = 77
            if (r4 == r1) goto L1e
            r1 = 35
            goto L20
        L1e:
            r1 = 77
        L20:
            if (r1 == r0) goto L4a
            goto L30
        L23:
            r4 = move-exception
            throw r4
        L25:
            int r4 = r4.read()     // Catch: java.lang.Exception -> L50
            if (r4 == r1) goto L2d
            r0 = 0
            goto L2e
        L2d:
            r0 = 1
        L2e:
            if (r0 != 0) goto L4a
        L30:
            int r0 = com.alipay.imobile.network.quake.cache.DiskBasedCache.PlaceComponentResult     // Catch: java.lang.Exception -> L48
            int r0 = r0 + 9
            int r1 = r0 % 128
            com.alipay.imobile.network.quake.cache.DiskBasedCache.scheduleImpl = r1     // Catch: java.lang.Exception -> L48
            int r0 = r0 % 2
            if (r0 != 0) goto L3e
            r0 = 1
            goto L3f
        L3e:
            r0 = 0
        L3f:
            if (r0 == r3) goto L42
            goto L45
        L42:
            r0 = 10
            int r0 = r0 / r2
        L45:
            return r4
        L46:
            r4 = move-exception
            throw r4
        L48:
            r4 = move-exception
            throw r4
        L4a:
            java.io.EOFException r4 = new java.io.EOFException
            r4.<init>()
            throw r4
        L50:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.cache.DiskBasedCache.a(java.io.InputStream):int");
    }

    private static void f(int i, char[] cArr, Object[] objArr) {
        C c2 = new C();
        char[] cArr2 = new char[cArr.length];
        c2.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c2.BuiltInFictitiousFunctionClassFactory < cArr.length ? 'E' : '+') != '+') {
                cArr3[0] = cArr[c2.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c2.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                int i3 = $10 + 113;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                int i5 = 0;
                while (true) {
                    if ((i5 < 16 ? '-' : 'b') != '-') {
                        break;
                    }
                    int i6 = $11 + 37;
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                    i2 -= 40503;
                    i5++;
                }
                cArr2[c2.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c2.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c2.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                String str = new String(cArr2, 0, i);
                int i8 = $11 + 99;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
