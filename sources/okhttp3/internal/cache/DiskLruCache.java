package okhttp3.internal.cache;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: classes6.dex */
public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    int redundantOpCount;
    final int valueCount;
    private long size = 0;
    final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (DiskLruCache.this) {
                if ((!DiskLruCache.this.initialized) != false || DiskLruCache.this.closed) {
                    return;
                }
                try {
                    DiskLruCache.this.trimToSize();
                } catch (IOException unused) {
                    DiskLruCache.this.mostRecentTrimFailed = true;
                }
                try {
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                } catch (IOException unused2) {
                    DiskLruCache.this.mostRecentRebuildFailed = true;
                    DiskLruCache.this.journalWriter = Okio.BuiltInFictitiousFunctionClassFactory(Okio.MyBillsEntityDataFactory());
                }
            }
        }
    };

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public final void initialize() throws IOException {
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    StringBuilder sb = new StringBuilder();
                    sb.append("DiskLruCache ");
                    sb.append(this.directory);
                    sb.append(" is corrupt: ");
                    sb.append(e.getMessage());
                    sb.append(", removing");
                    platform.log(5, sb.toString(), e);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal();
            this.initialized = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void readJournal() throws IOException {
        BufferedSource KClassImpl$Data$declaredNonStaticMembers$2 = Okio.KClassImpl$Data$declaredNonStaticMembers$2(this.fileSystem.source(this.journalFile));
        try {
            String NetworkUserEntityData$$ExternalSyntheticLambda5 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
            String NetworkUserEntityData$$ExternalSyntheticLambda52 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
            String NetworkUserEntityData$$ExternalSyntheticLambda53 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
            String NetworkUserEntityData$$ExternalSyntheticLambda54 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
            String NetworkUserEntityData$$ExternalSyntheticLambda55 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5();
            if (!MAGIC.equals(NetworkUserEntityData$$ExternalSyntheticLambda5) || !"1".equals(NetworkUserEntityData$$ExternalSyntheticLambda52) || !Integer.toString(this.appVersion).equals(NetworkUserEntityData$$ExternalSyntheticLambda53) || !Integer.toString(this.valueCount).equals(NetworkUserEntityData$$ExternalSyntheticLambda54) || !"".equals(NetworkUserEntityData$$ExternalSyntheticLambda55)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda5);
                sb.append(", ");
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda52);
                sb.append(", ");
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda54);
                sb.append(", ");
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda55);
                sb.append("]");
                throw new IOException(sb.toString());
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = newJournalWriter();
                    }
                    Util.closeQuietly(KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(KClassImpl$Data$declaredNonStaticMembers$2);
            throw th;
        }
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.BuiltInFictitiousFunctionClassFactory(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) { // from class: okhttp3.internal.cache.DiskLruCache.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // okhttp3.internal.cache.FaultHidingSink
            protected void onException(IOException iOException) {
                DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(str);
            throw new IOException(sb.toString());
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith(READ)) {
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unexpected journal line: ");
            sb2.append(str);
            throw new IOException(sb2.toString());
        }
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i]);
                    this.fileSystem.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    final void rebuildJournal() throws IOException {
        synchronized (this) {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(this.fileSystem.sink(this.journalFileTmp));
            try {
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(MAGIC).PlaceComponentResult(10);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory("1").PlaceComponentResult(10);
                BuiltInFictitiousFunctionClassFactory.moveToNextValue(this.appVersion).PlaceComponentResult(10);
                BuiltInFictitiousFunctionClassFactory.moveToNextValue(this.valueCount).PlaceComponentResult(10);
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(DIRTY).PlaceComponentResult(32);
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(entry.key);
                        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(10);
                    } else {
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(CLEAN).PlaceComponentResult(32);
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(entry.key);
                        entry.writeLengths(BuiltInFictitiousFunctionClassFactory);
                        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(10);
                    }
                }
                BuiltInFictitiousFunctionClassFactory.close();
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } catch (Throwable th) {
                BuiltInFictitiousFunctionClassFactory.close();
                throw th;
            }
        }
    }

    public final Snapshot get(String str) throws IOException {
        synchronized (this) {
            initialize();
            checkNotClosed();
            validateKey(str);
            Entry entry = this.lruEntries.get(str);
            if (entry != null && entry.readable) {
                Snapshot snapshot = entry.snapshot();
                if (snapshot == null) {
                    return null;
                }
                this.redundantOpCount++;
                this.journalWriter.BuiltInFictitiousFunctionClassFactory(READ).PlaceComponentResult(32).BuiltInFictitiousFunctionClassFactory(str).PlaceComponentResult(10);
                if (journalRebuildRequired()) {
                    this.executor.execute(this.cleanupRunnable);
                }
                return snapshot;
            }
            return null;
        }
    }

    @Nullable
    public final Editor edit(String str) throws IOException {
        return edit(str, -1L);
    }

    final Editor edit(String str, long j) throws IOException {
        synchronized (this) {
            initialize();
            checkNotClosed();
            validateKey(str);
            Entry entry = this.lruEntries.get(str);
            if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
                if (entry == null || entry.currentEditor == null) {
                    if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                        this.journalWriter.BuiltInFictitiousFunctionClassFactory(DIRTY).PlaceComponentResult(32).BuiltInFictitiousFunctionClassFactory(str).PlaceComponentResult(10);
                        this.journalWriter.flush();
                        if (this.hasJournalErrors) {
                            return null;
                        }
                        if (entry == null) {
                            entry = new Entry(str);
                            this.lruEntries.put(str, entry);
                        }
                        Editor editor = new Editor(entry);
                        entry.currentEditor = editor;
                        return editor;
                    }
                    this.executor.execute(this.cleanupRunnable);
                    return null;
                }
                return null;
            }
            return null;
        }
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final long getMaxSize() {
        long j;
        synchronized (this) {
            j = this.maxSize;
        }
        return j;
    }

    public final void setMaxSize(long j) {
        synchronized (this) {
            this.maxSize = j;
            if (this.initialized) {
                this.executor.execute(this.cleanupRunnable);
            }
        }
    }

    public final long size() throws IOException {
        long j;
        synchronized (this) {
            initialize();
            j = this.size;
        }
        return j;
    }

    final void completeEdit(Editor editor, boolean z) throws IOException {
        synchronized (this) {
            Entry entry = editor.entry;
            if (entry.currentEditor != editor) {
                throw new IllegalStateException();
            }
            if (z && !entry.readable) {
                for (int i = 0; i < this.valueCount; i++) {
                    if (!editor.written[i]) {
                        editor.abort();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Newly created entry didn't create value for index ");
                        sb.append(i);
                        throw new IllegalStateException(sb.toString());
                    } else if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                        editor.abort();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < this.valueCount; i2++) {
                File file = entry.dirtyFiles[i2];
                if (z) {
                    if (this.fileSystem.exists(file)) {
                        File file2 = entry.cleanFiles[i2];
                        this.fileSystem.rename(file, file2);
                        long j = entry.lengths[i2];
                        long size = this.fileSystem.size(file2);
                        entry.lengths[i2] = size;
                        this.size = (this.size - j) + size;
                    }
                } else {
                    this.fileSystem.delete(file);
                }
            }
            this.redundantOpCount++;
            entry.currentEditor = null;
            if (entry.readable | z) {
                entry.readable = true;
                this.journalWriter.BuiltInFictitiousFunctionClassFactory(CLEAN).PlaceComponentResult(32);
                this.journalWriter.BuiltInFictitiousFunctionClassFactory(entry.key);
                entry.writeLengths(this.journalWriter);
                this.journalWriter.PlaceComponentResult(10);
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    entry.sequenceNumber = j2;
                }
            } else {
                this.lruEntries.remove(entry.key);
                this.journalWriter.BuiltInFictitiousFunctionClassFactory("REMOVE").PlaceComponentResult(32);
                this.journalWriter.BuiltInFictitiousFunctionClassFactory(entry.key);
                this.journalWriter.PlaceComponentResult(10);
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
        }
    }

    final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public final boolean remove(String str) throws IOException {
        synchronized (this) {
            initialize();
            checkNotClosed();
            validateKey(str);
            Entry entry = this.lruEntries.get(str);
            if (entry == null) {
                return false;
            }
            boolean removeEntry = removeEntry(entry);
            if (removeEntry && this.size <= this.maxSize) {
                this.mostRecentTrimFailed = false;
            }
            return removeEntry;
        }
    }

    final boolean removeEntry(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            this.size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.BuiltInFictitiousFunctionClassFactory("REMOVE").PlaceComponentResult(32).BuiltInFictitiousFunctionClassFactory(entry.key).PlaceComponentResult(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.closed;
        }
        return z;
    }

    private void checkNotClosed() {
        synchronized (this) {
            if (isClosed()) {
                throw new IllegalStateException("cache is closed");
            }
        }
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        synchronized (this) {
            if (this.initialized) {
                checkNotClosed();
                trimToSize();
                this.journalWriter.flush();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (this.initialized && !this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        }
    }

    final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final void evictAll() throws IOException {
        synchronized (this) {
            initialize();
            for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                removeEntry(entry);
            }
            this.mostRecentTrimFailed = false;
        }
    }

    private void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("keys must match regex [a-z0-9_-]{1,120}: \"");
        sb.append(str);
        sb.append("\"");
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: okhttp3.internal.cache.DiskLruCache$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass3 implements Iterator<Snapshot>, j$.util.Iterator {
        final Iterator<Entry> delegate;
        Snapshot nextSnapshot;
        Snapshot removeSnapshot;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super Snapshot> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        AnonymousClass3() {
            this.delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Snapshot snapshot;
            if (this.nextSnapshot != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.closed) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Entry next = this.delegate.next();
                    if (next.readable && (snapshot = next.snapshot()) != null) {
                        this.nextSnapshot = snapshot;
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            return snapshot;
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot snapshot = this.removeSnapshot;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                DiskLruCache.this.remove(snapshot.key);
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
        }
    }

    public final java.util.Iterator<Snapshot> snapshots() throws IOException {
        AnonymousClass3 anonymousClass3;
        synchronized (this) {
            initialize();
            anonymousClass3 = new AnonymousClass3();
        }
        return anonymousClass3;
    }

    /* loaded from: classes6.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public final String key() {
            return this.key;
        }

        @Nullable
        public final Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource(int i) {
            return this.sources[i];
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        final void detach() {
            if (this.entry.currentEditor == this) {
                for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                    try {
                        DiskLruCache.this.fileSystem.delete(this.entry.dirtyFiles[i]);
                    } catch (IOException unused) {
                    }
                }
                this.entry.currentEditor = null;
            }
        }

        public final Source newSource(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.readable && this.entry.currentEditor == this) {
                    try {
                        return DiskLruCache.this.fileSystem.source(this.entry.cleanFiles[i]);
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                return null;
            }
        }

        public final Sink newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor != this) {
                    return Okio.MyBillsEntityDataFactory();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                try {
                    return new FaultHidingSink(DiskLruCache.this.fileSystem.sink(this.entry.dirtyFiles[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // okhttp3.internal.cache.FaultHidingSink
                        protected void onException(IOException iOException) {
                            synchronized (DiskLruCache.this) {
                                Editor.this.detach();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return Okio.MyBillsEntityDataFactory();
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        public final void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public final void abortUnlessCommitted() {
            synchronized (DiskLruCache.this) {
                if (!this.done && this.entry.currentEditor == this) {
                    try {
                        DiskLruCache.this.completeEdit(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new File[DiskLruCache.this.valueCount];
            this.dirtyFiles = new File[DiskLruCache.this.valueCount];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                sb.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        final void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        final void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long j : this.lengths) {
                bufferedSink.PlaceComponentResult(32).moveToNextValue(j);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected journal line: ");
            sb.append(Arrays.toString(strArr));
            throw new IOException(sb.toString());
        }

        final Snapshot snapshot() {
            Source source;
            if (!Thread.holdsLock(DiskLruCache.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[DiskLruCache.this.valueCount];
            long[] jArr = (long[]) this.lengths.clone();
            for (int i = 0; i < DiskLruCache.this.valueCount; i++) {
                try {
                    sourceArr[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < DiskLruCache.this.valueCount && (source = sourceArr[i2]) != null; i2++) {
                        Util.closeQuietly(source);
                    }
                    try {
                        DiskLruCache.this.removeEntry(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new Snapshot(this.key, this.sequenceNumber, sourceArr, jArr);
        }
    }
}
