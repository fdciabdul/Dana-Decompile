package id.dana.domain.featureconfig.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013"}, d2 = {"Lid/dana/domain/featureconfig/model/StartupConfig;", "", "", "", "getCertificates", "()Ljava/util/List;", "", "getFeatureDexguardHookCheck", "()Z", "getFeatureDexguardRootCheck", "getFeatureDexguardTamperCheck", "getFeatureWarmstartTracking", "", "getPinningMode", "()I", "getSslCertificateWhitelistHost", "isEnableNonBlockingSplash", "isEnableSimpleGetUserId", "certificates", "Ljava/util/List;", "enableNonBlockingSplash", "Ljava/lang/Boolean;", "enableSimpleGetUserId", "featureDexguardHookCheck", "featureDexguardRootCheck", "featureDexguardTamperCheck", "featureWarmstartTracking", "pinningMode", "Ljava/lang/Integer;", "sslCertificateWhitelistHost", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StartupConfig {
    public List<String> certificates;
    public Boolean enableNonBlockingSplash;
    public Boolean enableSimpleGetUserId;
    public Boolean featureDexguardHookCheck;
    public Boolean featureDexguardRootCheck;
    public Boolean featureDexguardTamperCheck;
    public Boolean featureWarmstartTracking;
    public Integer pinningMode;
    public List<String> sslCertificateWhitelistHost;

    public /* synthetic */ StartupConfig() {
    }

    public StartupConfig(Boolean bool, Boolean bool2, Boolean bool3, Integer num, List<String> list, List<String> list2, Boolean bool4, Boolean bool5, Boolean bool6) {
        this.featureDexguardRootCheck = bool;
        this.featureDexguardHookCheck = bool2;
        this.featureDexguardTamperCheck = bool3;
        this.pinningMode = num;
        this.certificates = list;
        this.sslCertificateWhitelistHost = list2;
        this.featureWarmstartTracking = bool4;
        this.enableNonBlockingSplash = bool5;
        this.enableSimpleGetUserId = bool6;
    }

    public final boolean getFeatureDexguardRootCheck() {
        Boolean bool = this.featureDexguardRootCheck;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean getFeatureDexguardHookCheck() {
        Boolean bool = this.featureDexguardHookCheck;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean getFeatureDexguardTamperCheck() {
        Boolean bool = this.featureDexguardTamperCheck;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final int getPinningMode() {
        Integer num = this.pinningMode;
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public final List<String> getCertificates() {
        List<String> list = this.certificates;
        return list == null ? CollectionsKt.listOf((Object[]) new String[]{"https://a.m.dana.id/app/common/sec/dana-akamai-2021.cer", "https://a.m.dana.id/app/common/sec/star_m_dana_id_2021.cer", "https://a.m.dana.id/app/common/sec/star_m_dana_id_bin_2022.cer", "https://a.m.dana.id/app/common/sec/dana-akamai-bin-2022.cer", "https://a.m.dana.id/app/common/sec/dana-cloudflare-2022.cer"}) : list;
    }

    public final List<String> getSslCertificateWhitelistHost() {
        List<String> list = this.sslCertificateWhitelistHost;
        return list == null ? CollectionsKt.listOf((Object[]) new String[]{"mgs-gw.m.dana.id", "m.dana.id", "sec.m.dana.id"}) : list;
    }

    public final boolean getFeatureWarmstartTracking() {
        Boolean bool = this.featureWarmstartTracking;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isEnableNonBlockingSplash() {
        Boolean bool = this.enableNonBlockingSplash;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isEnableSimpleGetUserId() {
        Boolean bool = this.enableSimpleGetUserId;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
