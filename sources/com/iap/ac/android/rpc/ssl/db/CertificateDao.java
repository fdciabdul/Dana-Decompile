package com.iap.ac.android.rpc.ssl.db;

import java.util.List;

/* loaded from: classes3.dex */
public interface CertificateDao {
    void insertCertificates(List<CertificateEntity> list);

    List<CertificateEntity> loadAllCertificates();
}
