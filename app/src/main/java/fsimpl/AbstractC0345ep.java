package fsimpl;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.GCMParameterSpec;

/* renamed from: fsimpl.ep  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0345ep {

    /* renamed from: a  reason: collision with root package name */
    protected final Key f7975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0345ep(Key key) {
        this.f7975a = key;
    }

    private static int a(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(2048);
        int i = 0;
        while (true) {
            int read = readableByteChannel.read(allocateDirect);
            if (read == -1) {
                break;
            }
            i += read;
            allocateDirect.flip();
            writableByteChannel.write(allocateDirect);
            allocateDirect.compact();
        }
        allocateDirect.flip();
        while (allocateDirect.hasRemaining()) {
            writableByteChannel.write(allocateDirect);
        }
        return i;
    }

    private int a(Cipher cipher) {
        return ((GCMParameterSpec) cipher.getParameters().getParameterSpec(GCMParameterSpec.class)).getTLen();
    }

    private InputStream a(InputStream inputStream) {
        try {
            int read = inputStream.read();
            if (read != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported encryption version ");
                sb.append(read);
                throw new GeneralSecurityException(sb.toString());
            }
            int read2 = inputStream.read() * 8;
            if (read2 <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid tag length: ");
                sb2.append(read2);
                throw new GeneralSecurityException(sb2.toString());
            }
            int read3 = inputStream.read();
            if (read3 <= 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Invalid iv length: ");
                sb3.append(read3);
                throw new GeneralSecurityException(sb3.toString());
            }
            byte[] bArr = new byte[read3];
            int read4 = inputStream.read(bArr);
            if (read4 == read3) {
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, a(), new GCMParameterSpec(read2, bArr));
                return new CipherInputStream(inputStream, cipher);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unable to read full iv length of ");
            sb4.append(read3);
            sb4.append(", only read ");
            sb4.append(read4);
            throw new GeneralSecurityException(sb4.toString());
        } catch (GeneralSecurityException e) {
            throw e;
        } catch (Throwable th) {
            throw new GeneralSecurityException("Exception initializing decryption stream", th);
        }
    }

    private OutputStream a(OutputStream outputStream) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, a(), C0344eo.f7974a);
            byte[] iv = cipher.getIV();
            int length = iv.length;
            if (length <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid iv length: ");
                sb.append(length);
                throw new GeneralSecurityException(sb.toString());
            }
            int a2 = a(cipher);
            outputStream.write(0);
            outputStream.write(a2 / 8);
            outputStream.write(length);
            outputStream.write(iv);
            outputStream.flush();
            return new CipherOutputStream(outputStream, cipher);
        } catch (GeneralSecurityException e) {
            throw e;
        } catch (Throwable th) {
            throw new GeneralSecurityException("Exception initializing encryption stream", th);
        }
    }

    public int a(InputStream inputStream, OutputStream outputStream) {
        OutputStream a2 = a(outputStream);
        try {
            int a3 = a(Channels.newChannel(inputStream), Channels.newChannel(a2));
            if (a2 != null) {
                a2.close();
            }
            return a3;
        } catch (Throwable th) {
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    protected Key a() {
        return this.f7975a;
    }

    public int b(InputStream inputStream, OutputStream outputStream) {
        InputStream a2 = a(inputStream);
        try {
            int a3 = a(Channels.newChannel(a2), Channels.newChannel(outputStream));
            if (a2 != null) {
                a2.close();
            }
            return a3;
        } catch (Throwable th) {
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
