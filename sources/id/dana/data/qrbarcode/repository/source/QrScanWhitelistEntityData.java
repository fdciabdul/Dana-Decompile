package id.dana.data.qrbarcode.repository.source;

import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface QrScanWhitelistEntityData {
    Observable<List<String>> getWhitelistedQrH5Container();
}
