package com.alipay.imobile.network.sslpinning.b;

import android.os.AsyncTask;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.sslpinning.api.OnAddRemoteCertificatesListener;
import com.alipay.imobile.network.sslpinning.api.RemoteCertificateDownloadException;
import com.alipay.imobile.network.sslpinning.db.c;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class b extends AsyncTask<String, Void, Void> {
    private static String c = "SSLPinning";

    /* renamed from: a  reason: collision with root package name */
    private OnAddRemoteCertificatesListener f7087a;
    private final com.alipay.imobile.network.sslpinning.db.a b;

    public b(OnAddRemoteCertificatesListener onAddRemoteCertificatesListener, com.alipay.imobile.network.sslpinning.db.a aVar) {
        this.f7087a = onAddRemoteCertificatesListener;
        this.b = aVar;
    }

    private List<String> b(String... strArr) {
        List<String> asList = Arrays.asList(strArr);
        ArrayList arrayList = new ArrayList();
        List<c> a2 = this.b.a();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < a2.size(); i++) {
            arrayList2.add(a2.get(i).f7091a);
        }
        if (arrayList2.size() > 0) {
            for (int i2 = 0; i2 < asList.size(); i2++) {
                String str = asList.get(i2);
                if (!arrayList2.contains(str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return asList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public Void doInBackground(String... strArr) {
        List<String> b = b(strArr);
        if (b.size() == 0) {
            OnAddRemoteCertificatesListener onAddRemoteCertificatesListener = this.f7087a;
            if (onAddRemoteCertificatesListener != null) {
                onAddRemoteCertificatesListener.onSuccess();
            }
            LoggerWrapper.d(c, "Certificates already persisted, no need to download again");
            return null;
        }
        ArrayList arrayList = new ArrayList(b.size());
        for (int i = 0; i < b.size(); i++) {
            try {
                String str = b.get(i);
                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                    inputStream.close();
                    arrayList.add(new c(b.get(i), generateCertificate));
                } else {
                    String str2 = c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Certificate download failed, URL is ");
                    sb.append(str);
                    LoggerWrapper.d(str2, sb.toString());
                    throw new IOException("Certificate not found");
                }
            } catch (IOException e) {
                String str3 = c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("IO Exception occurs, ");
                sb2.append(e.getMessage());
                LoggerWrapper.e(str3, sb2.toString());
                OnAddRemoteCertificatesListener onAddRemoteCertificatesListener2 = this.f7087a;
                if (onAddRemoteCertificatesListener2 != null) {
                    onAddRemoteCertificatesListener2.onFailure(RemoteCertificateDownloadException.newInstance(a.b(), e));
                }
                return null;
            } catch (CertificateException e2) {
                LoggerWrapper.e(c, "Certificate file parsing failed, is this file encoded in PEM or DER format?");
                OnAddRemoteCertificatesListener onAddRemoteCertificatesListener3 = this.f7087a;
                if (onAddRemoteCertificatesListener3 != null) {
                    onAddRemoteCertificatesListener3.onFailure(RemoteCertificateDownloadException.newInstance(a.a(), e2));
                }
                return null;
            }
        }
        LoggerWrapper.d(c, "Certificate downloads successful");
        this.b.a(arrayList);
        LoggerWrapper.d(c, "Certificates saved to database successfully");
        OnAddRemoteCertificatesListener onAddRemoteCertificatesListener4 = this.f7087a;
        if (onAddRemoteCertificatesListener4 != null) {
            onAddRemoteCertificatesListener4.onSuccess();
        }
        return null;
    }
}
