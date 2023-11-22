package id.dana.data.deeplink.repository.source.local;

import id.dana.data.deeplink.repository.source.GenerateLinkEntityData;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkEntity;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PreferencesGenerateLinkEntityData implements GenerateLinkEntityData {
    private final DeepLinkPreferences deepLinkPreferences;

    @Inject
    public PreferencesGenerateLinkEntityData(DeepLinkPreferences deepLinkPreferences) {
        this.deepLinkPreferences = deepLinkPreferences;
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<Boolean> saveProfileQrDeepLink(String str, boolean z) {
        this.deepLinkPreferences.saveProfileDeepLinkUrl(str, z);
        return Observable.just(Boolean.TRUE);
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateReferralDeepLink(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateTransferQrDeepLink(String str, String str2, String str3, String str4, String str5) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateProfileQrDeepLink(String str, String str2, String str3, String str4, String str5, boolean z) {
        return Observable.just(new DeepLinkEntity(this.deepLinkPreferences.getProfileDeepLinkUrl(isWithReferral(str3, z))));
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateSplitBillQrDeepLink(String str, String str2, String str3, String str4, String str5, String str6) {
        throw new UnsupportedOperationException();
    }

    private boolean isWithReferral(String str, boolean z) {
        return z || !str.isEmpty();
    }

    @Override // id.dana.data.deeplink.repository.source.GenerateLinkEntityData
    public Observable<DeepLinkEntity> generateSplitBillDetailDeepLink(String str) {
        throw new UnsupportedOperationException();
    }
}
