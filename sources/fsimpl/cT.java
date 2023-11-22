package fsimpl;

import com.fullstory.instrumentation.init.Initialization;
import com.fullstory.util.Log;
import com.google.common.net.HttpHeaders;
import id.dana.data.here.HereOauthManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

/* loaded from: classes.dex */
public class cT {
    public static cU a(byte[] bArr, String str, String str2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("Content-Type", str2);
            httpURLConnection.setRequestProperty("charset", HereOauthManager.ENC);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Initialization.f7427a);
            httpURLConnection.setUseCaches(false);
            if (bArr.length > 0) {
                httpURLConnection.setRequestMethod("POST");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    Channels.newChannel(outputStream).write(ByteBuffer.wrap(bArr));
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } else {
                httpURLConnection.setRequestMethod("GET");
            }
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                cX cXVar = new cX(responseCode, a(inputStream));
                if (inputStream != null) {
                    inputStream.close();
                }
                return cXVar;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        } catch (Throwable th3) {
            Log.v("HTTP exception", th3);
            return new cW(th3);
        }
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
