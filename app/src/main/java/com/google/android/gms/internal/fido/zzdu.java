package com.google.android.gms.internal.fido;

import com.google.common.primitives.SignedBytes;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.time.DurationKt;

/* loaded from: classes3.dex */
public final class zzdu implements Closeable {
    private final InputStream zza;
    private zzdt zzb;
    private final byte[] zzc = new byte[8];
    private final zzdv zzd = zzdv.zza();

    public zzdu(InputStream inputStream) {
        this.zza = inputStream;
    }

    private final long zzh() throws IOException {
        if (this.zzb.zza() < 24) {
            long zza = this.zzb.zza();
            this.zzb = null;
            return zza;
        } else if (this.zzb.zza() == 24) {
            int read = this.zza.read();
            if (read != -1) {
                this.zzb = null;
                return read & 255;
            }
            throw new EOFException();
        } else if (this.zzb.zza() == 25) {
            zzk(this.zzc, 2);
            byte[] bArr = this.zzc;
            return ((bArr[0] & 255) << 8) | (255 & bArr[1]);
        } else if (this.zzb.zza() == 26) {
            zzk(this.zzc, 4);
            return (r1[3] & 255) | ((255 & r1[2]) << 8) | ((r1[1] & 255) << 16) | ((this.zzc[0] & 255) << 24);
        } else if (this.zzb.zza() == 27) {
            zzk(this.zzc, 8);
            byte[] bArr2 = this.zzc;
            long j = bArr2[0];
            return (bArr2[7] & 255) | ((bArr2[2] & 255) << 40) | ((bArr2[1] & 255) << 48) | ((j & 255) << 56) | ((bArr2[3] & 255) << 32) | ((bArr2[4] & 255) << 24) | ((bArr2[5] & 255) << 16) | ((bArr2[6] & 255) << 8);
        } else {
            throw new IOException(String.format("invalid additional information %s for major type %s", Byte.valueOf(this.zzb.zza()), Integer.valueOf(this.zzb.zzc())));
        }
    }

    private final void zzi() throws IOException {
        zzd();
        if (this.zzb.zza() == 31) {
            throw new IllegalStateException(String.format("expected definite length but found %s", Byte.valueOf(this.zzb.zza())));
        }
    }

    private final void zzj(byte b) throws IOException {
        zzd();
        if (this.zzb.zzb() != b) {
            throw new IllegalStateException(String.format("expected major type %s but found %s", Integer.valueOf((b >> 5) & 7), Integer.valueOf(this.zzb.zzc())));
        }
    }

    private final void zzk(byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 != i) {
            int read = this.zza.read(bArr, i2, i - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
        this.zzb = null;
    }

    private final byte[] zzl() throws IOException {
        zzi();
        long zzh = zzh();
        if (zzh < 0 || zzh > 2147483647L) {
            throw new UnsupportedOperationException(String.format("the maximum supported byte/text string length is %s bytes", Integer.MAX_VALUE));
        }
        if (this.zza.available() >= zzh) {
            int i = (int) zzh;
            byte[] bArr = new byte[i];
            zzk(bArr, i);
            return bArr;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.close();
        this.zzd.zzb();
    }

    public final long zza() throws IOException {
        zzj(Byte.MIN_VALUE);
        zzi();
        long zzh = zzh();
        if (zzh >= 0) {
            if (zzh > 0) {
                this.zzd.zzg(zzh);
            }
            return zzh;
        }
        throw new UnsupportedOperationException(String.format("the maximum supported array length is %s", Long.valueOf((long) LongCompanionObject.MAX_VALUE)));
    }

    public final long zzb() throws IOException {
        boolean z;
        zzd();
        if (this.zzb.zzb() == 0) {
            z = true;
        } else if (this.zzb.zzb() != 32) {
            throw new IllegalStateException(String.format("expected major type 0 or 1 but found %s", Integer.valueOf(this.zzb.zzc())));
        } else {
            z = false;
        }
        long zzh = zzh();
        if (zzh >= 0) {
            return z ? zzh : (-1) ^ zzh;
        }
        throw new UnsupportedOperationException(String.format("the maximum supported unsigned/negative integer is %s", Long.valueOf((long) LongCompanionObject.MAX_VALUE)));
    }

    public final long zzc() throws IOException {
        zzj((byte) -96);
        zzi();
        long zzh = zzh();
        if (zzh < 0 || zzh > DurationKt.MAX_MILLIS) {
            throw new UnsupportedOperationException("the maximum supported map length is 4611686018427387903L");
        }
        if (zzh > 0) {
            this.zzd.zzg(zzh + zzh);
        }
        return zzh;
    }

    public final zzdt zzd() throws IOException {
        if (this.zzb == null) {
            int read = this.zza.read();
            if (read == -1) {
                this.zzd.zzb();
                return null;
            }
            zzdt zzdtVar = new zzdt(read);
            this.zzb = zzdtVar;
            byte zzb = zzdtVar.zzb();
            if (zzb != Byte.MIN_VALUE && zzb != -96 && zzb != -64) {
                if (zzb != -32) {
                    if (zzb != 0 && zzb != 32) {
                        if (zzb == 64) {
                            this.zzd.zze(-1L);
                        } else if (zzb != 96) {
                            throw new IllegalStateException(String.format("invalid major type: %s", Integer.valueOf(this.zzb.zzc())));
                        } else {
                            this.zzd.zze(-2L);
                        }
                        this.zzd.zzf();
                    }
                } else if (this.zzb.zza() == 31) {
                    this.zzd.zzc();
                }
            }
            this.zzd.zzd();
            this.zzd.zzf();
        }
        return this.zzb;
    }

    public final String zze() throws IOException {
        zzj((byte) 96);
        return new String(zzl(), StandardCharsets.UTF_8);
    }

    public final boolean zzf() throws IOException {
        zzj((byte) -32);
        if (this.zzb.zza() > 24) {
            throw new IllegalStateException("expected simple value");
        }
        int zzh = (int) zzh();
        if (zzh == 20) {
            return false;
        }
        if (zzh == 21) {
            return true;
        }
        throw new IllegalStateException(String.format("expected FALSE or TRUE", new Object[0]));
    }

    public final byte[] zzg() throws IOException {
        zzj(SignedBytes.MAX_POWER_OF_TWO);
        return zzl();
    }
}
