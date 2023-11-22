package com.alibaba.griver.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.LottieCompositionFactory;
import com.alibaba.griver.lottie.LottieResult;
import com.alibaba.griver.lottie.utils.Logger;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipInputStream;

/* loaded from: classes6.dex */
public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    public static LottieResult<LottieComposition> fetchSync(Context context, String str) {
        return new NetworkFetcher(context, str).fetchSync();
    }

    private NetworkFetcher(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.url = str;
        this.networkCache = new NetworkCache(applicationContext, str);
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition fetchFromCache = fetchFromCache();
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Animation for ");
        sb.append(this.url);
        sb.append(" not found in cache. Fetching from network.");
        Logger.debug(sb.toString());
        return fetchFromNetwork();
    }

    private LottieComposition fetchFromCache() {
        LottieResult<LottieComposition> fromJsonInputStreamSync;
        Pair<FileExtension, InputStream> fetch = this.networkCache.fetch();
        if (fetch == null) {
            return null;
        }
        FileExtension fileExtension = fetch.getAuthRequestContext;
        InputStream inputStream = fetch.PlaceComponentResult;
        if (fileExtension == FileExtension.ZIP) {
            fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url);
        } else {
            fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        }
        if (fromJsonInputStreamSync.getValue() != null) {
            return fromJsonInputStreamSync.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private LottieResult fetchFromNetworkInternal() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching ");
        sb.append(this.url);
        Logger.debug(sb.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(this.url).openConnection())));
        httpURLConnection.setRequestMethod("GET");
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                LottieResult<LottieComposition> resultFromConnection = getResultFromConnection(httpURLConnection);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                sb2.append(resultFromConnection.getValue() != null);
                Logger.debug(sb2.toString());
                return resultFromConnection;
            }
            String errorFromConnection = getErrorFromConnection(httpURLConnection);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to fetch ");
            sb3.append(this.url);
            sb3.append(". Failed with ");
            sb3.append(httpURLConnection.getResponseCode());
            sb3.append("\n");
            sb3.append(errorFromConnection);
            return new LottieResult((Throwable) new IllegalArgumentException(sb3.toString()));
        } catch (Exception e) {
            return new LottieResult((Throwable) e);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> fromZipStreamSync;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        char c = 65535;
        int hashCode = contentType.hashCode();
        if (hashCode != -1248325150) {
            if (hashCode == -43840953 && contentType.equals("application/json")) {
                c = 1;
            }
        } else if (contentType.equals("application/zip")) {
            c = 0;
        }
        if (c == 0) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            fromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension))), this.url);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            fromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
        }
        if (fromZipStreamSync.getValue() != null) {
            this.networkCache.renameTempFile(fileExtension);
        }
        return fromZipStreamSync;
    }
}
