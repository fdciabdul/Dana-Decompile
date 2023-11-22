package id.dana.contract.deeplink.path;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/contract/deeplink/path/IpgRegistrationPayLoadMapper;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IpgRegistrationPayLoadMapper {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/contract/deeplink/path/IpgRegistrationPayLoadMapper$Companion;", "", "", "", "p0", "Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "PlaceComponentResult", "(Ljava/util/Map;)Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static IpgRegistrationPayload PlaceComponentResult(Map<String, String> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String str = p0.get("path");
            String str2 = str == null ? "" : str;
            String str3 = p0.get("action");
            String str4 = str3 == null ? "" : str3;
            String str5 = p0.get("bizType");
            String str6 = str5 == null ? "" : str5;
            String str7 = p0.get("logo");
            String str8 = str7 == null ? "" : str7;
            String str9 = p0.get("idTitle");
            String str10 = str9 == null ? "" : str9;
            String str11 = p0.get("enTitle");
            String str12 = str11 == null ? "" : str11;
            String str13 = p0.get("tnc");
            String str14 = str13 == null ? "" : str13;
            String str15 = p0.get("userConsentConfigKey");
            String str16 = str15 == null ? "" : str15;
            String str17 = p0.get("userConsentSyncKey");
            return new IpgRegistrationPayload(str2, str4, str6, str8, str10, str12, str14, str16, str17 == null ? "" : str17);
        }
    }
}
