package id.dana.data.deeplink.repository.source;

import id.dana.data.deeplink.repository.source.branch.result.DeepLinkEntity;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface GenerateLinkEntityData {
    Observable<DeepLinkEntity> generateProfileQrDeepLink(String str, String str2, String str3, String str4, String str5, boolean z);

    Observable<DeepLinkEntity> generateReferralDeepLink(String str);

    Observable<DeepLinkEntity> generateSplitBillDetailDeepLink(String str);

    Observable<DeepLinkEntity> generateSplitBillQrDeepLink(String str, String str2, String str3, String str4, String str5, String str6);

    Observable<DeepLinkEntity> generateTransferQrDeepLink(String str, String str2, String str3, String str4, String str5);

    Observable<Boolean> saveProfileQrDeepLink(String str, boolean z);
}
