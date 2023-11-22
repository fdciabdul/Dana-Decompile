package id.dana.data.network;

import java.security.cert.Certificate;
import java.util.List;

/* loaded from: classes2.dex */
public interface IOkHttpSSLPinningManager {
    void PlaceComponentResult(List<Certificate> list);

    void getAuthRequestContext(int i);

    void getAuthRequestContext(List<String> list);
}
