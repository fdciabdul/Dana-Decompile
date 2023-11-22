package com.uc.crashsdk;

import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfHttpClient;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/* loaded from: classes8.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static int f7733a = 5000;

    private static byte[] a(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        byte[] bArr2 = null;
        r1 = null;
        r1 = null;
        BufferedInputStream bufferedInputStream3 = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        bArr2 = new byte[length];
                        int i = 0;
                        while (i < length) {
                            int read = bufferedInputStream.read(bArr2, i, length - i);
                            if (-1 == read) {
                                break;
                            }
                            i += read;
                        }
                        com.uc.crashsdk.a.b.a(bufferedInputStream);
                        com.uc.crashsdk.a.b.a(fileInputStream);
                        return bArr2;
                    } catch (Exception e2) {
                        e = e2;
                        byte[] bArr3 = bArr2;
                        bufferedInputStream3 = bufferedInputStream;
                        bArr = bArr3;
                        com.uc.crashsdk.a.a.a(e, true);
                        com.uc.crashsdk.a.b.a(bufferedInputStream3);
                        com.uc.crashsdk.a.b.a(fileInputStream);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        com.uc.crashsdk.a.b.a(bufferedInputStream2);
                        com.uc.crashsdk.a.b.a(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream3;
                    fileInputStream = fileInputStream;
                }
            } catch (Exception e3) {
                e = e3;
                bArr = null;
            }
        } catch (Exception e4) {
            e = e4;
            bArr = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            com.uc.crashsdk.a.b.a(bufferedInputStream2);
            com.uc.crashsdk.a.b.a(fileInputStream);
            throw th;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            StringBuilder sb = new StringBuilder("upload try again: ");
            sb.append(str);
            com.uc.crashsdk.a.c.b(sb.toString());
        }
        return false;
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a2 = a(file);
            if (a2 != null && a2.length != 0) {
                return a(a2, str, str2);
            }
            return false;
        } catch (Exception e) {
            com.uc.crashsdk.a.a.a(e, false);
            return false;
        }
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        HttpHost httpHost;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setIntParameter("http.connection.timeout", 10000);
                    defaultHttpClient.getParams().setIntParameter("http.socket.timeout", 60000);
                    String a2 = com.uc.crashsdk.a.e.a();
                    if (a2 != null) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(a2, com.uc.crashsdk.a.e.b()));
                    }
                    if (str2 == null || str2.length() <= 0) {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder("uploadCrashLog get url [");
                    sb.append(str2);
                    sb.append("] ...");
                    com.uc.crashsdk.a.c.b(sb.toString());
                    HttpPost httpPost = new HttpPost(str2);
                    if (str2.startsWith("http://")) {
                        str2 = str2.substring(7);
                    } else if (str2.startsWith("https://")) {
                        str2 = str2.substring(8);
                    }
                    StringBuilder sb2 = new StringBuilder("uploadCrashLog after substr url [");
                    sb2.append(str2);
                    sb2.append("] ...");
                    com.uc.crashsdk.a.c.b(sb2.toString());
                    if (str2.contains(":")) {
                        String substring = str2.substring(0, str2.indexOf(":"));
                        int indexOf = str2.indexOf("/");
                        if (indexOf < 0) {
                            indexOf = str2.length();
                        }
                        httpHost = new HttpHost(substring, Integer.valueOf(str2.substring(str2.indexOf(":") + 1, indexOf)).intValue());
                    } else if (str2.contains("/")) {
                        httpHost = new HttpHost(str2.substring(0, str2.indexOf("/")));
                    } else {
                        httpHost = new HttpHost(str2);
                    }
                    httpPost.setHeader("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                    StringBuilder sb3 = new StringBuilder("form-data; name=\"file\"; filename=");
                    sb3.append(str);
                    httpPost.setHeader(HttpHeaders.CONTENT_DISPOSITION, sb3.toString());
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                    stringBuffer.append("Content-Disposition: form-data; name=\"file\";");
                    stringBuffer.append(" filename=\"");
                    stringBuffer.append(str);
                    stringBuffer.append("\"\r\n");
                    stringBuffer.append("Content-Type: application/octet-stream\r\n");
                    stringBuffer.append("\r\n");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(stringBuffer.toString().getBytes());
                    byteArrayOutputStream.write(bArr);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n");
                    byteArrayOutputStream.write(stringBuffer2.toString().getBytes());
                    byteArrayOutputStream.close();
                    httpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream.toByteArray()));
                    try {
                        int statusCode = FirebasePerfHttpClient.execute(defaultHttpClient, httpHost, httpPost).getStatusLine().getStatusCode();
                        StringBuilder sb4 = new StringBuilder("StatusLine: ");
                        sb4.append(statusCode);
                        com.uc.crashsdk.a.c.a("crashsdk", sb4.toString());
                        return statusCode == 200;
                    } catch (Throwable th) {
                        try {
                            com.uc.crashsdk.a.a.a(th, true);
                            return false;
                        } finally {
                            defaultHttpClient.getConnectionManager().shutdown();
                        }
                    }
                }
            } catch (Exception e) {
                com.uc.crashsdk.a.a.a(e, true);
            }
        }
        return false;
    }
}
