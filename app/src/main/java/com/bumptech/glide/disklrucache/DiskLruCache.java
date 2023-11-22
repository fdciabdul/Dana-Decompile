package com.bumptech.glide.disklrucache;

import android.os.Build;
import android.os.StrictMode;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class DiskLruCache implements Closeable {
    private final File MyBillsEntityDataFactory;
    private final File getAuthRequestContext;
    private final File getErrorConfigVersion;
    private int initRecordTimeStamp;
    private Writer lookAheadTest;
    private final File moveToNextValue;
    private long scheduleImpl;
    private long DatabaseTableConfigUtil = 0;
    private final LinkedHashMap<String, Entry> NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashMap<>(0, 0.75f, true);
    private long GetContactSyncConfig = 0;
    final ThreadPoolExecutor PlaceComponentResult = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory(0));
    private final Callable<Void> BuiltInFictitiousFunctionClassFactory = new Callable<Void>() { // from class: com.bumptech.glide.disklrucache.DiskLruCache.1
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.lookAheadTest == null) {
                    return null;
                }
                DiskLruCache.this.PlaceComponentResult();
                if (DiskLruCache.this.getAuthRequestContext()) {
                    DiskLruCache.this.KClassImpl$Data$declaredNonStaticMembers$2();
                    DiskLruCache.NetworkUserEntityData$$ExternalSyntheticLambda0(DiskLruCache.this);
                }
                return null;
            }
        }
    };
    private final int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;

    public static /* synthetic */ void MyBillsEntityDataFactory(DiskLruCache diskLruCache, Editor editor, boolean z) throws IOException {
        synchronized (diskLruCache) {
            Entry entry = editor.PlaceComponentResult;
            if (entry.BuiltInFictitiousFunctionClassFactory == editor) {
                if (z && !entry.moveToNextValue) {
                    for (int i = 0; i < diskLruCache.NetworkUserEntityData$$ExternalSyntheticLambda2; i++) {
                        if (editor.getAuthRequestContext[i]) {
                            if (!entry.MyBillsEntityDataFactory[i].exists()) {
                                MyBillsEntityDataFactory(DiskLruCache.this, editor, false);
                                return;
                            }
                        } else {
                            MyBillsEntityDataFactory(DiskLruCache.this, editor, false);
                            StringBuilder sb = new StringBuilder();
                            sb.append("Newly created entry didn't create value for index ");
                            sb.append(i);
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                }
                for (int i2 = 0; i2 < diskLruCache.NetworkUserEntityData$$ExternalSyntheticLambda2; i2++) {
                    File file = entry.MyBillsEntityDataFactory[i2];
                    if (z) {
                        if (file.exists()) {
                            File file2 = entry.KClassImpl$Data$declaredNonStaticMembers$2[i2];
                            file.renameTo(file2);
                            long j = entry.lookAheadTest[i2];
                            long length = file2.length();
                            entry.lookAheadTest[i2] = length;
                            diskLruCache.DatabaseTableConfigUtil = (diskLruCache.DatabaseTableConfigUtil - j) + length;
                        }
                    } else if (file.exists() && !file.delete()) {
                        throw new IOException();
                    }
                }
                diskLruCache.initRecordTimeStamp++;
                entry.BuiltInFictitiousFunctionClassFactory = null;
                if (!(entry.moveToNextValue | z)) {
                    diskLruCache.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(entry.getAuthRequestContext);
                    diskLruCache.lookAheadTest.append((CharSequence) FamilyAccountInvitationStatusType.REMOVE);
                    diskLruCache.lookAheadTest.append(InputCardNumberView.DIVIDER);
                    diskLruCache.lookAheadTest.append((CharSequence) entry.getAuthRequestContext);
                    diskLruCache.lookAheadTest.append('\n');
                } else {
                    Entry.MyBillsEntityDataFactory(entry);
                    diskLruCache.lookAheadTest.append((CharSequence) "CLEAN");
                    diskLruCache.lookAheadTest.append(InputCardNumberView.DIVIDER);
                    diskLruCache.lookAheadTest.append((CharSequence) entry.getAuthRequestContext);
                    diskLruCache.lookAheadTest.append((CharSequence) entry.getAuthRequestContext());
                    diskLruCache.lookAheadTest.append('\n');
                    if (z) {
                        long j2 = diskLruCache.GetContactSyncConfig;
                        diskLruCache.GetContactSyncConfig = 1 + j2;
                        entry.getErrorConfigVersion = j2;
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$2(diskLruCache.lookAheadTest);
                if (diskLruCache.DatabaseTableConfigUtil > diskLruCache.scheduleImpl || diskLruCache.getAuthRequestContext()) {
                    diskLruCache.PlaceComponentResult.submit(diskLruCache.BuiltInFictitiousFunctionClassFactory);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    static /* synthetic */ int NetworkUserEntityData$$ExternalSyntheticLambda0(DiskLruCache diskLruCache) {
        diskLruCache.initRecordTimeStamp = 0;
        return 0;
    }

    private DiskLruCache(File file, long j) {
        this.getAuthRequestContext = file;
        this.MyBillsEntityDataFactory = new File(file, "journal");
        this.moveToNextValue = new File(file, "journal.tmp");
        this.getErrorConfigVersion = new File(file, "journal.bkp");
        this.scheduleImpl = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0137, code lost:
    
        throw new java.io.IOException(r6.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bumptech.glide.disklrucache.DiskLruCache KClassImpl$Data$declaredNonStaticMembers$2(java.io.File r13, long r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.KClassImpl$Data$declaredNonStaticMembers$2(java.io.File, long):com.bumptech.glide.disklrucache.DiskLruCache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        synchronized (this) {
            Writer writer = this.lookAheadTest;
            if (writer != null) {
                getAuthRequestContext(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.moveToNextValue), Util.MyBillsEntityDataFactory));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.KClassImpl$Data$declaredNonStaticMembers$2));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.NetworkUserEntityData$$ExternalSyntheticLambda0.values()) {
                    if (entry.BuiltInFictitiousFunctionClassFactory != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(entry.getAuthRequestContext);
                        sb.append('\n');
                        bufferedWriter.write(sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(entry.getAuthRequestContext);
                        sb2.append(entry.getAuthRequestContext());
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    }
                }
                getAuthRequestContext(bufferedWriter);
                if (this.MyBillsEntityDataFactory.exists()) {
                    File file = this.MyBillsEntityDataFactory;
                    File file2 = this.getErrorConfigVersion;
                    if (file2.exists() && !file2.delete()) {
                        throw new IOException();
                    }
                    if (!file.renameTo(file2)) {
                        throw new IOException();
                    }
                }
                if (this.moveToNextValue.renameTo(this.MyBillsEntityDataFactory)) {
                    this.getErrorConfigVersion.delete();
                    this.lookAheadTest = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.MyBillsEntityDataFactory, true), Util.MyBillsEntityDataFactory));
                } else {
                    throw new IOException();
                }
            } catch (Throwable th) {
                getAuthRequestContext(bufferedWriter);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAuthRequestContext() {
        int i = this.initRecordTimeStamp;
        return i >= 2000 && i >= this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.lookAheadTest == null) {
                return;
            }
            Iterator it = new ArrayList(this.NetworkUserEntityData$$ExternalSyntheticLambda0.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.BuiltInFictitiousFunctionClassFactory != null) {
                    Editor editor = entry.BuiltInFictitiousFunctionClassFactory;
                    MyBillsEntityDataFactory(DiskLruCache.this, editor, false);
                }
            }
            PlaceComponentResult();
            getAuthRequestContext(this.lookAheadTest);
            this.lookAheadTest = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult() throws IOException {
        while (this.DatabaseTableConfigUtil > this.scheduleImpl) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0.entrySet().iterator().next().getKey());
        }
    }

    private static void getAuthRequestContext(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* loaded from: classes3.dex */
    public final class Value {
        private final long[] BuiltInFictitiousFunctionClassFactory;
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final long MyBillsEntityDataFactory;
        public final File[] PlaceComponentResult;

        /* synthetic */ Value(DiskLruCache diskLruCache, String str, long j, File[] fileArr, long[] jArr, byte b) {
            this(str, j, fileArr, jArr);
        }

        private Value(String str, long j, File[] fileArr, long[] jArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = j;
            this.PlaceComponentResult = fileArr;
            this.BuiltInFictitiousFunctionClassFactory = jArr;
        }
    }

    /* loaded from: classes3.dex */
    public final class Editor {
        public boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final Entry PlaceComponentResult;
        private final boolean[] getAuthRequestContext;

        /* synthetic */ Editor(DiskLruCache diskLruCache, Entry entry, byte b) {
            this(entry);
        }

        private Editor(Entry entry) {
            this.PlaceComponentResult = entry;
            this.getAuthRequestContext = entry.moveToNextValue ? null : new boolean[DiskLruCache.this.NetworkUserEntityData$$ExternalSyntheticLambda2];
        }

        public final File PlaceComponentResult() throws IOException {
            File file;
            synchronized (DiskLruCache.this) {
                if (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory != this) {
                    throw new IllegalStateException();
                }
                if (!this.PlaceComponentResult.moveToNextValue) {
                    this.getAuthRequestContext[0] = true;
                }
                file = this.PlaceComponentResult.MyBillsEntityDataFactory[0];
                DiskLruCache.this.getAuthRequestContext.mkdirs();
            }
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class Entry {
        private Editor BuiltInFictitiousFunctionClassFactory;
        File[] KClassImpl$Data$declaredNonStaticMembers$2;
        File[] MyBillsEntityDataFactory;
        private final String getAuthRequestContext;
        private long getErrorConfigVersion;
        private final long[] lookAheadTest;
        private boolean moveToNextValue;

        /* synthetic */ Entry(DiskLruCache diskLruCache, String str, byte b) {
            this(str);
        }

        static /* synthetic */ boolean MyBillsEntityDataFactory(Entry entry) {
            entry.moveToNextValue = true;
            return true;
        }

        private Entry(String str) {
            this.getAuthRequestContext = str;
            this.lookAheadTest = new long[DiskLruCache.this.NetworkUserEntityData$$ExternalSyntheticLambda2];
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new File[DiskLruCache.this.NetworkUserEntityData$$ExternalSyntheticLambda2];
            this.MyBillsEntityDataFactory = new File[DiskLruCache.this.NetworkUserEntityData$$ExternalSyntheticLambda2];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.NetworkUserEntityData$$ExternalSyntheticLambda2; i++) {
                sb.append(i);
                this.KClassImpl$Data$declaredNonStaticMembers$2[i] = new File(DiskLruCache.this.getAuthRequestContext, sb.toString());
                sb.append(".tmp");
                this.MyBillsEntityDataFactory[i] = new File(DiskLruCache.this.getAuthRequestContext, sb.toString());
                sb.setLength(length);
            }
        }

        public final String getAuthRequestContext() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.lookAheadTest) {
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(j);
            }
            return sb.toString();
        }

        private static IOException getAuthRequestContext(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        static /* synthetic */ void MyBillsEntityDataFactory(Entry entry, String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                throw getAuthRequestContext(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    entry.lookAheadTest[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw getAuthRequestContext(strArr);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        /* synthetic */ DiskLruCacheThreadFactory(byte b) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread;
            synchronized (this) {
                thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                thread.setPriority(1);
            }
            return thread;
        }
    }

    public final Editor getAuthRequestContext(String str) throws IOException {
        synchronized (this) {
            if (this.lookAheadTest != null) {
                Entry entry = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
                byte b = 0;
                if (entry == null) {
                    entry = new Entry(this, str, b);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(str, entry);
                } else if (entry.BuiltInFictitiousFunctionClassFactory != null) {
                    return null;
                }
                Editor editor = new Editor(this, entry, b);
                entry.BuiltInFictitiousFunctionClassFactory = editor;
                this.lookAheadTest.append((CharSequence) "DIRTY");
                this.lookAheadTest.append(InputCardNumberView.DIVIDER);
                this.lookAheadTest.append((CharSequence) str);
                this.lookAheadTest.append('\n');
                KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
                return editor;
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    public final Value MyBillsEntityDataFactory(String str) throws IOException {
        synchronized (this) {
            if (this.lookAheadTest != null) {
                Entry entry = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
                if (entry == null) {
                    return null;
                }
                if (entry.moveToNextValue) {
                    for (File file : entry.KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (!file.exists()) {
                            return null;
                        }
                    }
                    this.initRecordTimeStamp++;
                    this.lookAheadTest.append((CharSequence) "READ");
                    this.lookAheadTest.append(InputCardNumberView.DIVIDER);
                    this.lookAheadTest.append((CharSequence) str);
                    this.lookAheadTest.append('\n');
                    if (getAuthRequestContext()) {
                        this.PlaceComponentResult.submit(this.BuiltInFictitiousFunctionClassFactory);
                    }
                    return new Value(this, str, entry.getErrorConfigVersion, entry.KClassImpl$Data$declaredNonStaticMembers$2, entry.lookAheadTest, (byte) 0);
                }
                return null;
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) throws IOException {
        synchronized (this) {
            if (this.lookAheadTest != null) {
                Entry entry = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
                if (entry != null && entry.BuiltInFictitiousFunctionClassFactory == null) {
                    for (int i = 0; i < this.NetworkUserEntityData$$ExternalSyntheticLambda2; i++) {
                        File file = entry.KClassImpl$Data$declaredNonStaticMembers$2[i];
                        if (file.exists() && !file.delete()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("failed to delete ");
                            sb.append(file);
                            throw new IOException(sb.toString());
                        }
                        this.DatabaseTableConfigUtil -= entry.lookAheadTest[i];
                        entry.lookAheadTest[i] = 0;
                    }
                    this.initRecordTimeStamp++;
                    this.lookAheadTest.append((CharSequence) FamilyAccountInvitationStatusType.REMOVE);
                    this.lookAheadTest.append(InputCardNumberView.DIVIDER);
                    this.lookAheadTest.append((CharSequence) str);
                    this.lookAheadTest.append('\n');
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(str);
                    if (getAuthRequestContext()) {
                        this.PlaceComponentResult.submit(this.BuiltInFictitiousFunctionClassFactory);
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("cache is closed");
        }
    }
}
