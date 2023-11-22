package id.dana.data.config.model;

import id.dana.domain.featureconfig.model.StartupConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001e\u0010\n"}, d2 = {"Lid/dana/data/config/model/StartupConfigEntity;", "", "Lid/dana/domain/featureconfig/model/StartupConfig;", "toStartupConfig", "()Lid/dana/domain/featureconfig/model/StartupConfig;", "", "", "certificates", "Ljava/util/List;", "getCertificates", "()Ljava/util/List;", "", "enableNonBlockingSplash", "Ljava/lang/Boolean;", "enableSimpleGetUserId", "featureDexguardHookCheck", "getFeatureDexguardHookCheck", "()Ljava/lang/Boolean;", "featureDexguardRootCheck", "getFeatureDexguardRootCheck", "featureDexguardTamperCheck", "getFeatureDexguardTamperCheck", "featureWarmstartTracking", "getFeatureWarmstartTracking", "", "pinningMode", "Ljava/lang/Integer;", "getPinningMode", "()Ljava/lang/Integer;", "sslCertificateWhitelistHost", "getSslCertificateWhitelistHost", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StartupConfigEntity {
    public List<String> certificates;
    public Boolean enableNonBlockingSplash;
    public Boolean enableSimpleGetUserId;
    public Boolean featureDexguardHookCheck;
    public Boolean featureDexguardRootCheck;
    public Boolean featureDexguardTamperCheck;
    public Boolean featureWarmstartTracking;
    public Integer pinningMode;
    public List<String> sslCertificateWhitelistHost;

    public /* synthetic */ StartupConfigEntity() {
    }

    public StartupConfigEntity(Boolean bool, Boolean bool2, Boolean bool3, Integer num, List<String> list, List<String> list2, Boolean bool4, Boolean bool5, Boolean bool6) {
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

    @JvmName(name = "getFeatureDexguardRootCheck")
    public final Boolean getFeatureDexguardRootCheck() {
        return this.featureDexguardRootCheck;
    }

    @JvmName(name = "getFeatureDexguardHookCheck")
    public final Boolean getFeatureDexguardHookCheck() {
        return this.featureDexguardHookCheck;
    }

    @JvmName(name = "getFeatureDexguardTamperCheck")
    public final Boolean getFeatureDexguardTamperCheck() {
        return this.featureDexguardTamperCheck;
    }

    @JvmName(name = "getPinningMode")
    public final Integer getPinningMode() {
        return this.pinningMode;
    }

    @JvmName(name = "getCertificates")
    public final List<String> getCertificates() {
        return this.certificates;
    }

    @JvmName(name = "getSslCertificateWhitelistHost")
    public final List<String> getSslCertificateWhitelistHost() {
        return this.sslCertificateWhitelistHost;
    }

    @JvmName(name = "getFeatureWarmstartTracking")
    public final Boolean getFeatureWarmstartTracking() {
        return this.featureWarmstartTracking;
    }

    public final StartupConfig toStartupConfig() {
        Boolean bool = this.featureDexguardRootCheck;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = this.featureDexguardHookCheck;
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = this.featureDexguardTamperCheck;
        boolean booleanValue3 = bool3 != null ? bool3.booleanValue() : false;
        Integer num = this.pinningMode;
        int intValue = num != null ? num.intValue() : 1;
        List<String> list = this.certificates;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List<String> list2 = list;
        List<String> list3 = this.sslCertificateWhitelistHost;
        if (list3 == null) {
            list3 = CollectionsKt.emptyList();
        }
        List<String> list4 = list3;
        Boolean bool4 = this.featureWarmstartTracking;
        boolean booleanValue4 = bool4 != null ? bool4.booleanValue() : false;
        Boolean bool5 = this.enableNonBlockingSplash;
        boolean booleanValue5 = bool5 != null ? bool5.booleanValue() : false;
        Boolean bool6 = this.enableSimpleGetUserId;
        return new StartupConfig(Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(booleanValue3), Integer.valueOf(intValue), list2, list4, Boolean.valueOf(booleanValue4), Boolean.valueOf(booleanValue5), Boolean.valueOf(bool6 != null ? bool6.booleanValue() : false));
    }
}
