package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class FileBackedOutputStream extends OutputStream {
    @CheckForNull
    private File file;
    private final int fileThreshold;
    @CheckForNull
    private MemoryOutput memory;
    private OutputStream out;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        byte[] getBuffer() {
            return this.buf;
        }

        int getCount() {
            return this.count;
        }
    }

    @CheckForNull
    final File getFile() {
        File file;
        synchronized (this) {
            file = this.file;
        }
        return file;
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public FileBackedOutputStream(int i, boolean z) {
        Preconditions.checkArgument(i >= 0, "fileThreshold must be non-negative, but was %s", i);
        this.fileThreshold = i;
        this.resetOnFinalize = z;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        if (z) {
            this.source = new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.1
                @Override // com.google.common.io.ByteSource
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }

                protected void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th) {
                        th.printStackTrace(System.err);
                    }
                }
            };
        } else {
            this.source = new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.2
                @Override // com.google.common.io.ByteSource
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        }
    }

    public final ByteSource asByteSource() {
        return this.source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream openInputStream() throws IOException {
        synchronized (this) {
            if (this.file != null) {
                return new FileInputStream(this.file);
            }
            Objects.requireNonNull(this.memory);
            return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
        }
    }

    public final void reset() throws IOException {
        synchronized (this) {
            try {
                close();
                MemoryOutput memoryOutput = this.memory;
                if (memoryOutput == null) {
                    this.memory = new MemoryOutput();
                } else {
                    memoryOutput.reset();
                }
                this.out = this.memory;
                File file = this.file;
                if (file != null) {
                    this.file = null;
                    if (!file.delete()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Could not delete: ");
                        sb.append(file);
                        throw new IOException(sb.toString());
                    }
                }
            } catch (Throwable th) {
                if (this.memory == null) {
                    this.memory = new MemoryOutput();
                } else {
                    this.memory.reset();
                }
                this.out = this.memory;
                File file2 = this.file;
                if (file2 != null) {
                    this.file = null;
                    if (!file2.delete()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Could not delete: ");
                        sb2.append(file2);
                        throw new IOException(sb2.toString());
                    }
                }
                throw th;
            }
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        synchronized (this) {
            update(1);
            this.out.write(i);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        synchronized (this) {
            write(bArr, 0, bArr.length);
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        synchronized (this) {
            update(i2);
            this.out.write(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            this.out.close();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        synchronized (this) {
            this.out.flush();
        }
    }

    private void update(int i) throws IOException {
        MemoryOutput memoryOutput = this.memory;
        if (memoryOutput == null || memoryOutput.getCount() + i <= this.fileThreshold) {
            return;
        }
        File createTempFile = TempFileCreator.INSTANCE.createTempFile("FileBackedOutputStream");
        if (this.resetOnFinalize) {
            createTempFile.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
            fileOutputStream.flush();
            this.out = fileOutputStream;
            this.file = createTempFile;
            this.memory = null;
        } catch (IOException e) {
            createTempFile.delete();
            throw e;
        }
    }
}
