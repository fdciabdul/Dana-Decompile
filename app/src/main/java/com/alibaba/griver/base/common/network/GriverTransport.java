package com.alibaba.griver.base.common.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.network.DownloadRequest;
import com.alibaba.griver.api.common.network.GriverTransportExtension;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.iap.ac.android.acs.plugin.utils.ErrorCode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GriverTransport {
    public static HttpResponse request(HttpRequest httpRequest) {
        HttpResponse httpResponse = null;
        if (httpRequest == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, "httpRequest is empty");
            GriverMonitor.event(GriverMonitorConstants.ERROR_HTTP_FAILED, "GriverAppContainer", hashMap);
            GriverLogger.w("GriverTransport", "request is null, return null", null);
            return null;
        } else if (TextUtils.isEmpty(httpRequest.getUrl())) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, "httpRequest url is empty");
            GriverMonitor.event(GriverMonitorConstants.ERROR_HTTP_FAILED, "GriverAppContainer", hashMap2);
            GriverLogger.w("GriverTransport", "request url is empty, return null", null);
            return null;
        } else {
            try {
                httpResponse = a().request(httpRequest);
                if (httpResponse == null) {
                    HashMap hashMap3 = new HashMap(8);
                    hashMap3.put("url", httpRequest.getUrl());
                    hashMap3.put(GriverMonitorConstants.KEY_EXCEPTION_MESSAGE, "response is null");
                    GriverMonitor.event(GriverMonitorConstants.ERROR_HTTP_FAILED, "GriverAppContainer", hashMap3);
                }
            } catch (Exception e) {
                Map<String, String> commonExceptionMap = GriverMonitor.getCommonExceptionMap(e);
                commonExceptionMap.put("url", httpRequest.getUrl());
                GriverMonitor.event(GriverMonitorConstants.ERROR_HTTP_FAILED, "GriverAppContainer", commonExceptionMap);
            }
            return httpResponse;
        }
    }

    private static GriverTransportExtension a() {
        return (GriverTransportExtension) RVProxy.get(GriverTransportExtension.class);
    }

    public static void download(final DownloadRequest downloadRequest, final DownloadCallback downloadCallback) {
        if (downloadRequest == null) {
            a(null, downloadCallback, 100, GriverMonitorConstants.MESSAGE_DOWNLOAD_REQUEST_EMPTY_ERROR, null);
            return;
        }
        try {
            final String str = downloadRequest.downloadUrl;
            final String str2 = downloadRequest.downloadFilePath;
            if (TextUtils.isEmpty(str)) {
                a(downloadRequest, downloadCallback, 101, GriverMonitorConstants.MESSAGE_DOWNLOAD_REQUEST_URL_EMPTY_ERROR, null);
                GriverLogger.e("GriverTransport", "invalid download request, return");
            } else if (TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("download request file path is empty. Path: ");
                sb.append(str2);
                GriverLogger.e("GriverTransport", sb.toString());
                a(downloadRequest, downloadCallback, 102, GriverMonitorConstants.MESSAGE_DOWNLOAD_PATH_EMPTY_ERROR, null);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("download path: ");
                sb2.append(str2);
                GriverLogger.d("GriverTransport", sb2.toString());
                if (FileUtils.exists(new File(str2))) {
                    GriverLogger.d("GriverTransport", "download file exists, callback finish");
                    a(downloadRequest, downloadCallback, true, 0L, 0L, 0);
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append("_temp");
                final String obj = sb3.toString();
                if (FileUtils.exists(obj)) {
                    FileUtils.delete(obj);
                }
                GriverExecutors.getExecutor(downloadRequest.urgent ? ExecutorType.URGENT : ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.griver.base.common.network.GriverTransport.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i;
                        String str3;
                        Exception e;
                        byte[] bArr;
                        FileOutputStream fileOutputStream;
                        FileOutputStream fileOutputStream2;
                        AnonymousClass1 anonymousClass1;
                        AnonymousClass1 anonymousClass12 = this;
                        int i2 = DownloadRequest.this.retryTime + 1;
                        int i3 = 99;
                        String str4 = "";
                        Exception exc = null;
                        while (i2 > 0) {
                            int i4 = i2 - 1;
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            HttpRequest httpRequest = new HttpRequest();
                            httpRequest.setUrl(str);
                            httpRequest.setMethod("GET");
                            HttpResponse request = GriverTransport.request(httpRequest);
                            if (request == null || request.getStatusCode() != 200 || request.getInputStream() == null) {
                                str4 = GriverMonitorConstants.MESSAGE_DOWNLOAD_RESPONSE_ERROR;
                                i = 200;
                                exc = null;
                            } else {
                                long contentLength = request.getContentLength();
                                if (FileUtils.create(obj)) {
                                    InputStream inputStream = request.getInputStream();
                                    byte[] buf = IOUtils.getBuf(1024);
                                    try {
                                        fileOutputStream2 = new FileOutputStream(obj);
                                        long j = 0;
                                        long j2 = 0;
                                        float f = 0.0f;
                                        while (true) {
                                            try {
                                                try {
                                                    int read = inputStream.read(buf);
                                                    if (read != -1) {
                                                        long j3 = j2 + read;
                                                        try {
                                                            fileOutputStream2.write(buf, 0, read);
                                                            if (contentLength > j && j3 > j) {
                                                                float f2 = (((float) j3) * 100.0f) / ((float) contentLength);
                                                                if (f2 != f && f2 <= 100.0f && f2 >= 0.0f) {
                                                                    anonymousClass1 = this;
                                                                    try {
                                                                        downloadCallback.onProgress(str2, (int) f2);
                                                                        f = f2;
                                                                        j2 = j3;
                                                                        anonymousClass12 = anonymousClass1;
                                                                        j = 0;
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                        bArr = buf;
                                                                        try {
                                                                            StringBuilder sb4 = new StringBuilder();
                                                                            sb4.append("input error");
                                                                            sb4.append(e);
                                                                            GriverLogger.e("GriverTransport", sb4.toString());
                                                                            i = 301;
                                                                            IOUtils.returnBuf(bArr);
                                                                            IOUtils.closeQuietly(fileOutputStream2);
                                                                            IOUtils.closeQuietly(inputStream);
                                                                            str3 = "write file failed";
                                                                            exc = e;
                                                                            str4 = str3;
                                                                            anonymousClass12 = this;
                                                                            i2 = i4;
                                                                            i3 = i;
                                                                        } catch (Throwable th) {
                                                                            th = th;
                                                                            fileOutputStream = fileOutputStream2;
                                                                            IOUtils.returnBuf(bArr);
                                                                            IOUtils.closeQuietly(fileOutputStream);
                                                                            IOUtils.closeQuietly(inputStream);
                                                                            throw th;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            anonymousClass1 = this;
                                                            j2 = j3;
                                                            anonymousClass12 = anonymousClass1;
                                                            j = 0;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            fileOutputStream = fileOutputStream2;
                                                            bArr = buf;
                                                            IOUtils.returnBuf(bArr);
                                                            IOUtils.closeQuietly(fileOutputStream);
                                                            IOUtils.closeQuietly(inputStream);
                                                            throw th;
                                                        }
                                                    } else {
                                                        AnonymousClass1 anonymousClass13 = anonymousClass12;
                                                        new File(obj).renameTo(new File(str2));
                                                        fileOutputStream = fileOutputStream2;
                                                        bArr = buf;
                                                        try {
                                                            GriverTransport.a(DownloadRequest.this, downloadCallback, false, j2, SystemClock.elapsedRealtime() - elapsedRealtime, i4);
                                                            StringBuilder sb5 = new StringBuilder();
                                                            sb5.append("download success, download time");
                                                            sb5.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                                                            sb5.append(", size=");
                                                            sb5.append(j2 / ConvertUtils.KB);
                                                            sb5.append("KB");
                                                            GriverLogger.d("GriverTransport", sb5.toString());
                                                            IOUtils.returnBuf(bArr);
                                                            IOUtils.closeQuietly(fileOutputStream);
                                                            IOUtils.closeQuietly(inputStream);
                                                            return;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            fileOutputStream2 = fileOutputStream;
                                                            StringBuilder sb42 = new StringBuilder();
                                                            sb42.append("input error");
                                                            sb42.append(e);
                                                            GriverLogger.e("GriverTransport", sb42.toString());
                                                            i = 301;
                                                            IOUtils.returnBuf(bArr);
                                                            IOUtils.closeQuietly(fileOutputStream2);
                                                            IOUtils.closeQuietly(inputStream);
                                                            str3 = "write file failed";
                                                            exc = e;
                                                            str4 = str3;
                                                            anonymousClass12 = this;
                                                            i2 = i4;
                                                            i3 = i;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            IOUtils.returnBuf(bArr);
                                                            IOUtils.closeQuietly(fileOutputStream);
                                                            IOUtils.closeQuietly(inputStream);
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    fileOutputStream = fileOutputStream2;
                                                    bArr = buf;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        bArr = buf;
                                        fileOutputStream2 = null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bArr = buf;
                                        fileOutputStream = null;
                                    }
                                } else {
                                    i = 300;
                                    str3 = GriverMonitorConstants.MESSAGE_DOWNLOAD_CREATE_FILE_ERROR;
                                    e = null;
                                }
                                exc = e;
                                str4 = str3;
                            }
                            anonymousClass12 = this;
                            i2 = i4;
                            i3 = i;
                        }
                        FileUtils.delete(obj);
                        GriverTransport.a(DownloadRequest.this, downloadCallback, i3, str4, exc);
                    }
                });
            }
        } catch (Exception e) {
            a(downloadRequest, downloadCallback, 99, ErrorCode.ERROR_UNKNOWN_ERROR_MESSAGE, e);
        }
    }

    public static void downloadFile(final String str, final String str2, final DownloadCallback downloadCallback) {
        GriverExecutors.getScheduledExecutor().execute(new Runnable() { // from class: com.alibaba.griver.base.common.network.GriverTransport.2
            @Override // java.lang.Runnable
            public final void run() {
                if (GriverTransport.downloadFile(str, str2)) {
                    downloadCallback.onFinish(str2);
                } else {
                    downloadCallback.onFailed(str2, 200, GriverMonitorConstants.MESSAGE_DOWNLOAD_RESPONSE_ERROR);
                }
            }
        });
    }

    public static boolean downloadFile(String str, String str2) {
        int i;
        FileOutputStream fileOutputStream;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("download url: ");
                sb.append(str);
                GriverLogger.d("GriverTransport", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("download path: ");
                sb2.append(str2);
                GriverLogger.d("GriverTransport", sb2.toString());
                if (FileUtils.exists(new File(str2))) {
                    GriverLogger.d("GriverTransport", "download file exists, callback finish");
                    return true;
                }
                int i2 = 3;
                while (i2 > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    HttpRequest httpRequest = new HttpRequest();
                    httpRequest.setUrl(str);
                    httpRequest.setMethod("GET");
                    HttpResponse request = request(httpRequest);
                    if (request != null && request.getStatusCode() == 200 && request.getInputStream() != null) {
                        long contentLength = request.getContentLength();
                        if (FileUtils.create(str2)) {
                            InputStream inputStream = request.getInputStream();
                            byte[] buf = IOUtils.getBuf(1024);
                            FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                    fileOutputStream = new FileOutputStream(str2);
                                    long j = 0;
                                    while (true) {
                                        try {
                                            try {
                                                int read = inputStream.read(buf);
                                                if (read != -1) {
                                                    i = i2;
                                                    j += read;
                                                    try {
                                                        fileOutputStream.write(buf, 0, read);
                                                        if (contentLength > 0) {
                                                            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                                        }
                                                        i2 = i;
                                                    } catch (Exception e) {
                                                        e = e;
                                                        fileOutputStream2 = fileOutputStream;
                                                        StringBuilder sb3 = new StringBuilder();
                                                        sb3.append("input error");
                                                        sb3.append(e);
                                                        GriverLogger.e("GriverTransport", sb3.toString());
                                                        IOUtils.returnBuf(buf);
                                                        IOUtils.closeQuietly(fileOutputStream2);
                                                        IOUtils.closeQuietly(inputStream);
                                                        i2 = i - 1;
                                                    }
                                                } else {
                                                    i = i2;
                                                    try {
                                                        StringBuilder sb4 = new StringBuilder();
                                                        sb4.append("download success, download time");
                                                        sb4.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                                                        sb4.append(", size=");
                                                        sb4.append(j / ConvertUtils.KB);
                                                        sb4.append("KB");
                                                        GriverLogger.d("GriverTransport", sb4.toString());
                                                        IOUtils.returnBuf(buf);
                                                        IOUtils.closeQuietly(fileOutputStream);
                                                        IOUtils.closeQuietly(inputStream);
                                                        return true;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        fileOutputStream2 = fileOutputStream;
                                                        StringBuilder sb32 = new StringBuilder();
                                                        sb32.append("input error");
                                                        sb32.append(e);
                                                        GriverLogger.e("GriverTransport", sb32.toString());
                                                        IOUtils.returnBuf(buf);
                                                        IOUtils.closeQuietly(fileOutputStream2);
                                                        IOUtils.closeQuietly(inputStream);
                                                        i2 = i - 1;
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                IOUtils.returnBuf(buf);
                                                IOUtils.closeQuietly(fileOutputStream);
                                                IOUtils.closeQuietly(inputStream);
                                                throw th;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            i = i2;
                                        }
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    i = i2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        }
                    }
                    i = i2;
                    i2 = i - 1;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(DownloadRequest downloadRequest, DownloadCallback downloadCallback, int i, String str, Throwable th) {
        if (downloadCallback != null) {
            downloadCallback.onFailed(null, i, str);
        }
        if (downloadRequest == null) {
            GriverLogger.e("GriverTransport", "download request is null, return direct");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("download failed for appId: ");
        sb.append(downloadRequest.appId);
        sb.append(", version: ");
        sb.append(downloadRequest.version);
        sb.append(", downloadUrl: ");
        sb.append(downloadRequest.downloadUrl);
        sb.append(", path: ");
        sb.append(downloadRequest.downloadFilePath);
        sb.append(", errorCode: ");
        sb.append(i);
        sb.append(", errorMessage: ");
        sb.append(str);
        GriverLogger.e("GriverTransport", sb.toString());
        if (TextUtils.isEmpty(downloadRequest.appId)) {
            return;
        }
        GriverMonitor.error(GriverMonitorConstants.ERROR_DOWNLOAD_FAIL, "GriverAppContainer", new MonitorMap.Builder().appId(downloadRequest.appId).version(downloadRequest.version).deployVersion(downloadRequest.deployVersion).message(str).exception(th).downloadPath(downloadRequest.downloadFilePath).url(downloadRequest.downloadUrl).requestUrl(downloadRequest.downloadUrl).code(String.valueOf(i)).overTime(String.valueOf(downloadRequest.retryTime)).needAsynAppType(true).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(DownloadRequest downloadRequest, DownloadCallback downloadCallback, boolean z, long j, long j2, int i) {
        if (downloadCallback != null) {
            if (z) {
                downloadCallback.onFinish(null);
                return;
            }
            downloadCallback.onFinish(downloadRequest.downloadFilePath);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("download success: ");
        sb.append(downloadRequest.downloadUrl);
        sb.append(" , savePath: ");
        sb.append(downloadRequest.downloadFilePath);
        GriverLogger.d("GriverTransport", sb.toString());
        GriverMonitor.event(GriverMonitorConstants.EVENT_DOWNLOAD_SUCCESS, "GriverAppContainer", new MonitorMap.Builder().appId(downloadRequest.appId).version(downloadRequest.version).deployVersion(downloadRequest.deployVersion).url(downloadRequest.downloadUrl).downloadPath(downloadRequest.downloadFilePath).cost(String.valueOf(j2)).size(String.valueOf(j)).append(GriverMonitorConstants.KEY_RETRY_TIME, String.valueOf(i)).needAsynAppType(true).build());
    }
}
