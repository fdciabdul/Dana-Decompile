package com.ta.utdid2.b.a;

import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class d {
    private static final Object b = new Object();
    private File d;

    /* renamed from: a  reason: collision with root package name */
    private final Object f7692a = new Object();
    private HashMap<File, a> e = new HashMap<>();

    public d(String str) {
        if (str != null && str.length() > 0) {
            this.d = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("File ");
        sb.append(str);
        sb.append(" contains a path separator");
        throw new IllegalArgumentException(sb.toString());
    }

    private File a() {
        File file;
        synchronized (this.f7692a) {
            file = this.d;
        }
        return file;
    }

    private File b(String str) {
        File a2 = a();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".xml");
        return a(a2, sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ta.utdid2.b.a.b a(java.lang.String r6, int r7) {
        /*
            r5 = this;
            java.io.File r6 = r5.b(r6)
            java.lang.Object r0 = com.ta.utdid2.b.a.d.b
            monitor-enter(r0)
            java.util.HashMap<java.io.File, com.ta.utdid2.b.a.d$a> r1 = r5.e     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> Lae
            com.ta.utdid2.b.a.d$a r1 = (com.ta.utdid2.b.a.d.a) r1     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto L19
            boolean r2 = r1.i()     // Catch: java.lang.Throwable -> Lae
            if (r2 != 0) goto L19
            monitor-exit(r0)
            return r1
        L19:
            monitor-exit(r0)
            java.io.File r0 = a(r6)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L2a
            r6.delete()
            r0.renameTo(r6)
        L2a:
            boolean r0 = r6.exists()
            r2 = 0
            if (r0 == 0) goto L8c
            boolean r0 = r6.canRead()
            if (r0 == 0) goto L8c
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53 org.xmlpull.v1.XmlPullParserException -> L57
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53 org.xmlpull.v1.XmlPullParserException -> L57
            java.util.HashMap r2 = com.ta.utdid2.b.a.e.a(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.xmlpull.v1.XmlPullParserException -> L4d
            r0.close()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.xmlpull.v1.XmlPullParserException -> L4d
        L43:
            r0.close()     // Catch: java.lang.Throwable -> L47
            goto L8c
        L47:
            goto L8c
        L49:
            r6 = move-exception
            goto L79
        L4b:
            goto L54
        L4d:
            r4 = r2
            r2 = r0
            r0 = r4
            goto L58
        L51:
            r6 = move-exception
            goto L78
        L53:
            r0 = r2
        L54:
            if (r0 == 0) goto L8c
            goto L43
        L57:
            r0 = r2
        L58:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L7f
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L7f
            int r2 = r3.available()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r3.read(r2)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6f
            r3.close()     // Catch: java.lang.Throwable -> L6a
            goto L86
        L6a:
            goto L86
        L6c:
            r6 = move-exception
            r2 = r3
            goto L72
        L6f:
            r2 = r3
            goto L80
        L71:
            r6 = move-exception
        L72:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.lang.Throwable -> L77
        L77:
            throw r6     // Catch: java.lang.Throwable -> L51
        L78:
            r0 = r2
        L79:
            if (r0 == 0) goto L7e
            r0.close()     // Catch: java.lang.Throwable -> L7e
        L7e:
            throw r6
        L7f:
        L80:
            if (r2 == 0) goto L85
            r2.close()     // Catch: java.lang.Throwable -> L85
        L85:
            r3 = r2
        L86:
            if (r3 == 0) goto L8b
            r3.close()     // Catch: java.lang.Throwable -> L8b
        L8b:
            r2 = r0
        L8c:
            java.lang.Object r0 = com.ta.utdid2.b.a.d.b
            monitor-enter(r0)
            if (r1 == 0) goto L95
            r1.a(r2)     // Catch: java.lang.Throwable -> Lab
            goto La9
        L95:
            java.util.HashMap<java.io.File, com.ta.utdid2.b.a.d$a> r1 = r5.e     // Catch: java.lang.Throwable -> Lab
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> Lab
            com.ta.utdid2.b.a.d$a r1 = (com.ta.utdid2.b.a.d.a) r1     // Catch: java.lang.Throwable -> Lab
            if (r1 != 0) goto La9
            com.ta.utdid2.b.a.d$a r1 = new com.ta.utdid2.b.a.d$a     // Catch: java.lang.Throwable -> Lab
            r1.<init>(r6, r7, r2)     // Catch: java.lang.Throwable -> Lab
            java.util.HashMap<java.io.File, com.ta.utdid2.b.a.d$a> r7 = r5.e     // Catch: java.lang.Throwable -> Lab
            r7.put(r6, r1)     // Catch: java.lang.Throwable -> Lab
        La9:
            monitor-exit(r0)
            return r1
        Lab:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        Lae:
            r6 = move-exception
            monitor-exit(r0)
            goto Lb2
        Lb1:
            throw r6
        Lb2:
            goto Lb1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.d.a(java.lang.String, int):com.ta.utdid2.b.a.b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File a(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getPath());
        sb.append(".bak");
        return new File(sb.toString());
    }

    /* loaded from: classes.dex */
    static final class a implements b {
        private static final Object c = new Object();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<b.InterfaceC0150b, Object> f7693a;
        private Map b;

        /* renamed from: c  reason: collision with other field name */
        private final int f68c;
        private final File e;
        private final File f;
        private boolean p = false;

        a(File file, int i, Map map) {
            this.e = file;
            this.f = d.a(file);
            this.f68c = i;
            this.b = map == null ? new HashMap() : map;
            this.f7693a = new WeakHashMap<>();
        }

        @Override // com.ta.utdid2.b.a.b
        public final boolean g() {
            return this.e != null && new File(this.e.getAbsolutePath()).exists();
        }

        public final void c(boolean z) {
            synchronized (this) {
                this.p = z;
            }
        }

        public final boolean i() {
            boolean z;
            synchronized (this) {
                z = this.p;
            }
            return z;
        }

        public final void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.b = map;
                }
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public final Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.b);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.b.a.b
        public final String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.b.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        @Override // com.ta.utdid2.b.a.b
        public final long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.b.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class C0151a implements b.a {
            private final Map<String, Object> c = new HashMap();
            private boolean q = false;

            public C0151a() {
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a a(String str, String str2) {
                synchronized (this) {
                    this.c.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a a(String str, int i) {
                synchronized (this) {
                    this.c.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a a(String str, long j) {
                synchronized (this) {
                    this.c.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a a(String str, float f) {
                synchronized (this) {
                    this.c.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a a(String str, boolean z) {
                synchronized (this) {
                    this.c.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a a(String str) {
                synchronized (this) {
                    this.c.put(str, this);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final b.a b() {
                synchronized (this) {
                    this.q = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public final boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC0150b> hashSet;
                boolean j;
                synchronized (d.b) {
                    z = a.this.f7693a.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f7693a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.q) {
                            a.this.b.clear();
                            this.q = false;
                        }
                        for (Map.Entry<String, Object> entry : this.c.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.b.remove(key);
                            } else {
                                a.this.b.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.c.clear();
                    }
                    j = a.this.j();
                    if (j) {
                        a.this.c(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.InterfaceC0150b interfaceC0150b : hashSet) {
                            if (interfaceC0150b != null) {
                                interfaceC0150b.a(a.this, str);
                            }
                        }
                    }
                }
                return j;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public final b.a a() {
            return new C0151a();
        }

        private FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j() {
            if (this.e.exists()) {
                if (!this.f.exists()) {
                    if (!this.e.renameTo(this.f)) {
                        return false;
                    }
                } else {
                    this.e.delete();
                }
            }
            try {
                FileOutputStream a2 = a(this.e);
                if (a2 == null) {
                    return false;
                }
                e.a(this.b, a2);
                a2.close();
                this.f.delete();
                return true;
            } catch (Exception unused) {
                if (this.e.exists()) {
                    this.e.delete();
                }
                return false;
            }
        }
    }
}
