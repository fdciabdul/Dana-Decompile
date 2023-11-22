package com.bumptech.glide.load.data;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    static final HttpUrlConnectionFactory PlaceComponentResult = new DefaultHttpUrlConnectionFactory();
    private InputStream BuiltInFictitiousFunctionClassFactory;
    private volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final HttpUrlConnectionFactory MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GlideUrl getAuthRequestContext;
    private HttpURLConnection moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection MyBillsEntityDataFactory(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, PlaceComponentResult);
    }

    private HttpUrlFetcher(GlideUrl glideUrl, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.getAuthRequestContext = glideUrl;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.MyBillsEntityDataFactory = httpUrlConnectionFactory;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long PlaceComponentResult2 = LogTime.PlaceComponentResult();
        try {
            try {
                GlideUrl glideUrl = this.getAuthRequestContext;
                if (glideUrl.getAuthRequestContext == null) {
                    if (TextUtils.isEmpty(glideUrl.PlaceComponentResult)) {
                        String str = glideUrl.scheduleImpl;
                        if (TextUtils.isEmpty(str)) {
                            str = ((URL) Preconditions.PlaceComponentResult(glideUrl.moveToNextValue)).toString();
                        }
                        glideUrl.PlaceComponentResult = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
                    }
                    glideUrl.getAuthRequestContext = new URL(glideUrl.PlaceComponentResult);
                }
                dataCallback.getAuthRequestContext(getAuthRequestContext(glideUrl.getAuthRequestContext, 0, null, this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    InstrumentInjector.log_d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                dataCallback.BuiltInFictitiousFunctionClassFactory(e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.MyBillsEntityDataFactory(PlaceComponentResult2));
                InstrumentInjector.log_v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(LogTime.MyBillsEntityDataFactory(PlaceComponentResult2));
                InstrumentInjector.log_v("HttpUrlFetcher", sb2.toString());
            }
            throw th;
        }
    }

    private InputStream getAuthRequestContext(URL url, int i, URL url2, Map<String, String> map) throws HttpException {
        while (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                        break;
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(url, map);
            this.moveToNextValue = BuiltInFictitiousFunctionClassFactory;
            try {
                BuiltInFictitiousFunctionClassFactory.connect();
                this.BuiltInFictitiousFunctionClassFactory = this.moveToNextValue.getInputStream();
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return null;
                }
                int PlaceComponentResult2 = PlaceComponentResult(this.moveToNextValue);
                if (KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2)) {
                    return getAuthRequestContext(this.moveToNextValue);
                }
                if (!PlaceComponentResult(PlaceComponentResult2)) {
                    if (PlaceComponentResult2 == -1) {
                        throw new HttpException(PlaceComponentResult2);
                    }
                    try {
                        throw new HttpException(this.moveToNextValue.getResponseMessage(), PlaceComponentResult2);
                    } catch (IOException e) {
                        throw new HttpException("Failed to get a response message", PlaceComponentResult2, e);
                    }
                }
                String headerField = this.moveToNextValue.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new HttpException("Received empty or null redirect url", PlaceComponentResult2);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    KClassImpl$Data$declaredNonStaticMembers$2();
                    i++;
                    url2 = url;
                    url = url3;
                } catch (MalformedURLException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Bad redirect url: ");
                    sb.append(headerField);
                    throw new HttpException(sb.toString(), PlaceComponentResult2, e2);
                }
            } catch (IOException e3) {
                throw new HttpException("Failed to connect or obtain data", PlaceComponentResult(this.moveToNextValue), e3);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    private static int PlaceComponentResult(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                InstrumentInjector.log_d("HttpUrlFetcher", "Failed to get a response code", e);
                return -1;
            }
            return -1;
        }
    }

    private HttpURLConnection BuiltInFictitiousFunctionClassFactory(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                MyBillsEntityDataFactory.addRequestProperty(entry.getKey(), entry.getValue());
            }
            MyBillsEntityDataFactory.setConnectTimeout(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            MyBillsEntityDataFactory.setReadTimeout(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            MyBillsEntityDataFactory.setUseCaches(false);
            MyBillsEntityDataFactory.setDoInput(true);
            MyBillsEntityDataFactory.setInstanceFollowRedirects(false);
            return MyBillsEntityDataFactory;
        } catch (IOException e) {
            throw new HttpException("URL.openConnection threw", 0, e);
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return i / 100 == 2;
    }

    private static boolean PlaceComponentResult(int i) {
        return i / 100 == 3;
    }

    private InputStream getAuthRequestContext(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.BuiltInFictitiousFunctionClassFactory = ContentLengthInputStream.getAuthRequestContext(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Got non empty content encoding: ");
                    sb.append(httpURLConnection.getContentEncoding());
                    InstrumentInjector.log_d("HttpUrlFetcher", sb.toString());
                }
                this.BuiltInFictitiousFunctionClassFactory = httpURLConnection.getInputStream();
            }
            return this.BuiltInFictitiousFunctionClassFactory;
        } catch (IOException e) {
            throw new HttpException("Failed to obtain InputStream", PlaceComponentResult(httpURLConnection), e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        InputStream inputStream = this.BuiltInFictitiousFunctionClassFactory;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.moveToNextValue;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.moveToNextValue = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<InputStream> getAuthRequestContext() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource MyBillsEntityDataFactory() {
        return DataSource.REMOTE;
    }

    /* loaded from: classes3.dex */
    static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public final HttpURLConnection MyBillsEntityDataFactory(URL url) throws IOException {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url.openConnection())));
        }
    }
}
