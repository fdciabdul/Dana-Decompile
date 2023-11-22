package com.iap.ac.android.rpc.ssl.task;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.rpc.ssl.api.OnAddRemoteCertificatesListener;
import com.iap.ac.android.rpc.ssl.db.CertificateDao;
import com.iap.ac.android.rpc.ssl.db.CertificateEntity;
import com.iap.ac.android.rpc.ssl.tls.TlsSupportSocketFactory;
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
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes8.dex */
public class RemoteCertificateDownloadTask extends AsyncTask<String, Void, Void> {
    private static final String DEBUG_TAG = "SSLPinning";
    private final CertificateDao certificateDao;
    private OnAddRemoteCertificatesListener listener;

    public RemoteCertificateDownloadTask(OnAddRemoteCertificatesListener onAddRemoteCertificatesListener, CertificateDao certificateDao) {
        this.listener = onAddRemoteCertificatesListener;
        this.certificateDao = certificateDao;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(String... strArr) {
        try {
            List<String> filter = filter(Arrays.asList(strArr), this.certificateDao.loadAllCertificates());
            if (filter.size() == 0) {
                OnAddRemoteCertificatesListener onAddRemoteCertificatesListener = this.listener;
                if (onAddRemoteCertificatesListener != null) {
                    onAddRemoteCertificatesListener.onSuccess();
                }
                ACLog.d(DEBUG_TAG, "Certificates already persisted, no need to download again");
                return null;
            }
            ArrayList arrayList = new ArrayList(filter.size());
            SSLSocketFactory createDefaultPatchSSLSocketFactory = TlsSupportSocketFactory.isNeedPatchTlsSupport() ? TlsSupportSocketFactory.createDefaultPatchSSLSocketFactory() : null;
            for (int i = 0; i < filter.size(); i++) {
                try {
                    String str = filter.get(i);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
                    if ((httpURLConnection instanceof HttpsURLConnection) && createDefaultPatchSSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(createDefaultPatchSSLSocketFactory);
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                        inputStream.close();
                        arrayList.add(new CertificateEntity(filter.get(i), generateCertificate));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Certificate download failed, URL is ");
                        sb.append(str);
                        ACLog.d(DEBUG_TAG, sb.toString());
                        throw new IOException("Certificate not found");
                    }
                } catch (IOException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("IO Exception occurs, ");
                    sb2.append(e.getMessage());
                    ACLog.e(DEBUG_TAG, sb2.toString());
                    OnAddRemoteCertificatesListener onAddRemoteCertificatesListener2 = this.listener;
                    if (onAddRemoteCertificatesListener2 != null) {
                        onAddRemoteCertificatesListener2.onFailure(RemoteCertificateDownloadPinnerException.newInstance(DownloadErrorExtension.createNetworkIAPError(), e));
                    }
                    return null;
                } catch (CertificateException e2) {
                    ACLog.e(DEBUG_TAG, "Certificate file parsing failed, is this file encoded in PEM or DER format?");
                    OnAddRemoteCertificatesListener onAddRemoteCertificatesListener3 = this.listener;
                    if (onAddRemoteCertificatesListener3 != null) {
                        onAddRemoteCertificatesListener3.onFailure(RemoteCertificateDownloadPinnerException.newInstance(DownloadErrorExtension.createCertificateParsingError(), e2));
                    }
                    return null;
                }
            }
            ACLog.d(DEBUG_TAG, "Certificate downloads successful");
            try {
                this.certificateDao.insertCertificates(arrayList);
                ACLog.d(DEBUG_TAG, "Certificates saved to database successfully");
                OnAddRemoteCertificatesListener onAddRemoteCertificatesListener4 = this.listener;
                if (onAddRemoteCertificatesListener4 != null) {
                    onAddRemoteCertificatesListener4.onSuccess();
                }
                return null;
            } catch (SQLiteException | IllegalStateException e3) {
                this.listener.onFailure(RemoteCertificateDownloadPinnerException.newInstance(DownloadErrorExtension.createSQLError(), e3));
                return null;
            }
        } catch (SQLiteException | IllegalStateException e4) {
            this.listener.onFailure(RemoteCertificateDownloadPinnerException.newInstance(DownloadErrorExtension.createSQLError(), e4));
            return null;
        }
    }

    private List<String> filter(List<String> list, List<CertificateEntity> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            arrayList2.add(list2.get(i).certificateUrl);
        }
        if (arrayList2.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = list.get(i2);
                if (!arrayList2.contains(str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return list;
    }
}
