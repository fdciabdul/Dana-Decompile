package fsimpl;

import com.alipay.mobile.zebra.ZebraLoader;
import com.fullstory.instrumentation.init.Initialization;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import com.google.common.net.HttpHeaders;
import id.dana.data.here.HereOauthManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.GeneralSecurityException;

/* renamed from: fsimpl.dk  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0314dk implements InterfaceC0319dq {

    /* renamed from: a  reason: collision with root package name */
    private final RustInterface f7937a;

    public C0314dk(RustInterface rustInterface) {
        this.f7937a = rustInterface;
    }

    private HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", ZebraLoader.MIME_TYPE_STREAM);
        httpURLConnection.setRequestProperty("charset", HereOauthManager.ENC);
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Initialization.f7427a);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    private void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        do {
        } while (inputStream.read(new byte[1024]) != -1);
    }

    private void a(HttpURLConnection httpURLConnection, long j, long j2) {
        int responseCode = httpURLConnection.getResponseCode();
        eU.a(this.f7937a, httpURLConnection, j, j2, responseCode);
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                a(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        try {
            a(errorStream);
            if (errorStream != null) {
                errorStream.close();
            }
            int responseCode2 = httpURLConnection.getResponseCode();
            StringBuilder sb = new StringBuilder();
            sb.append("Didn't get a 200 response: ");
            sb.append(httpURLConnection.getResponseCode());
            sb.append(" ");
            sb.append(httpURLConnection.getResponseMessage());
            throw new C0318dp(responseCode2, sb.toString());
        } catch (Throwable th2) {
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Throwable unused2) {
                }
            }
            throw th2;
        }
    }

    @Override // fsimpl.InterfaceC0319dq
    public void a(File file, String str, URL url, String str2, boolean z) {
        FileInputStream fileInputStream;
        long b;
        long nanoTime = System.nanoTime();
        HttpURLConnection a2 = a(url);
        if (str2 != null) {
            a2.setRequestProperty("Content-Type", str2);
        }
        if (z) {
            AbstractC0345ep a3 = C0344eo.a();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    OutputStream outputStream = a2.getOutputStream();
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Uploading encrypted bytes from ");
                        sb.append(file.getName());
                        sb.append(" to ");
                        sb.append(url);
                        Log.d(sb.toString());
                        b = a3.b(fileInputStream, outputStream);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Uploaded ");
                        sb2.append(b);
                        sb2.append(" bytes from ");
                        sb2.append(file.getName());
                        sb2.append(" to ");
                        sb2.append(url);
                        Log.d(sb2.toString());
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        fileInputStream.close();
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (GeneralSecurityException e) {
                Log.d("Unable to read encrypted file, aborting without rethrowing", e);
                return;
            } catch (Throwable th2) {
                Log.d("Unable to read encrypted file", th2);
                throw new IOException("Unable to read encrypted file", th2);
            }
        } else {
            fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                try {
                    OutputStream outputStream2 = a2.getOutputStream();
                    try {
                        long length = file.length();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Uploading ");
                        sb3.append(length);
                        sb3.append(" bytes from ");
                        sb3.append(file.getName());
                        sb3.append(" to ");
                        sb3.append(url);
                        Log.d(sb3.toString());
                        channel.transferTo(0L, length, Channels.newChannel(outputStream2));
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        fileInputStream.close();
                        b = length;
                    } catch (Throwable th3) {
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th4;
                }
            } finally {
            }
        }
        a(a2, b, nanoTime);
    }
}
