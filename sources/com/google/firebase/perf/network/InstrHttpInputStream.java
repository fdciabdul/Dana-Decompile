package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class InstrHttpInputStream extends InputStream {
    private final InputStream inputStream;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeToResponseInitiated;
    private final Timer timer;
    private long bytesRead = -1;
    private long timeToResponseLastRead = -1;

    public InstrHttpInputStream(InputStream inputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.timer = timer;
        this.inputStream = inputStream;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timeToResponseInitiated = networkRequestMetricBuilder.getTimeToResponseInitiatedMicros();
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        try {
            return this.inputStream.available();
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        long durationMicros = this.timer.getDurationMicros();
        if (this.timeToResponseLastRead == -1) {
            this.timeToResponseLastRead = durationMicros;
        }
        try {
            this.inputStream.close();
            long j = this.bytesRead;
            if (j != -1) {
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            long j2 = this.timeToResponseInitiated;
            if (j2 != -1) {
                this.networkMetricBuilder.setTimeToResponseInitiatedMicros(j2);
            }
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timeToResponseLastRead);
            this.networkMetricBuilder.build();
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.inputStream.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            int read = this.inputStream.read();
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j = this.bytesRead + 1;
                this.bytesRead = j;
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.inputStream.read(bArr, i, i2);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j = this.bytesRead + read;
                this.bytesRead = j;
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.inputStream.read(bArr);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j = this.bytesRead + read;
                this.bytesRead = j;
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        try {
            this.inputStream.reset();
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        try {
            long skip = this.inputStream.skip(j);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (skip == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            } else {
                long j2 = this.bytesRead + skip;
                this.bytesRead = j2;
                this.networkMetricBuilder.setResponsePayloadBytes(j2);
            }
            return skip;
        } catch (IOException e) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e;
        }
    }
}
