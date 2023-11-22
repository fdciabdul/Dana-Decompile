package id.dana.kyb.helper;

import id.dana.data.constant.DanaUrl;
import id.dana.kyb.domain.model.KybUrlsConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\b\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000f"}, d2 = {"Lid/dana/kyb/helper/KybUrlsDataManager;", "", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "PlaceComponentResult", "()Ljava/lang/String;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/kyb/domain/model/KybUrlsConfig;", "", "(Lid/dana/kyb/domain/model/KybUrlsConfig;)V", "Lid/dana/kyb/domain/model/KybUrlsConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybUrlsDataManager {
    public static final KybUrlsDataManager INSTANCE = new KybUrlsDataManager();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static KybUrlsConfig KClassImpl$Data$declaredNonStaticMembers$2 = new KybUrlsConfig(null, null, null, null, null, null, null, null, null, null, 1023, null);

    private KybUrlsDataManager() {
    }

    @JvmStatic
    public static final void getAuthRequestContext(KybUrlsConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getKyb());
        sb.append(p0);
        return sb.toString();
    }

    @JvmStatic
    public static final String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getKyc());
        sb.append(p0);
        return sb.toString();
    }

    @JvmStatic
    public static final String getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getTransaction());
        sb.append(p0);
        return sb.toString();
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory() {
        if (KClassImpl$Data$declaredNonStaticMembers$2.getRegistration().length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getRegistration());
            return sb.toString();
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_REGISTRATION_REVAMP);
    }

    @JvmStatic
    public static final String PlaceComponentResult() {
        if (KClassImpl$Data$declaredNonStaticMembers$2.getRegistrationReject().length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getRegistrationReject());
            return sb.toString();
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_REREGISTER);
    }

    @JvmStatic
    public static final String getAuthRequestContext() {
        if (KClassImpl$Data$declaredNonStaticMembers$2.getRegistrationRevoke().length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getRegistrationRevoke());
            return sb.toString();
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_ADD_NEWBISNIS);
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory() {
        if (KClassImpl$Data$declaredNonStaticMembers$2.getWithdrawWithBalance().length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getWithdrawWithBalance());
            sb.append(DanaUrl.KYB_WITHDRAW_PARAM);
            return sb.toString();
        }
        return DanaUrl.KYB_WITHDRAW_BALANCE;
    }

    @JvmStatic
    public static final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (KClassImpl$Data$declaredNonStaticMembers$2.getWithdrawWithBank().length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getWithdrawWithBank());
            sb.append(DanaUrl.KYB_WITHDRAW_PARAM);
            return sb.toString();
        }
        return DanaUrl.KYB_WITHDRAW_BANK;
    }
}
