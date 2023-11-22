package id.dana.domain.deeplink.repository;

import id.dana.domain.deeplink.model.DeepLink;
import id.dana.domain.splitbill.model.SplitBill;
import id.dana.domain.splitbill.model.SplitBillDeeplink;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface GenerateLinkRepository {
    Observable<DeepLink> generateProfileQrDeepLink(String str, String str2, String str3, boolean z);

    Observable<DeepLink> generateReferralDeepLink(String str);

    Observable<SplitBillDeeplink> generateSplitBillQrDeepLink(SplitBill splitBill, String str, String str2);

    Observable<DeepLink> generateTransferQrDeepLink(String str, String str2, String str3);
}
