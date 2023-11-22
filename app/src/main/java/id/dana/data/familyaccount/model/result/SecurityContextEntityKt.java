package id.dana.data.familyaccount.model.result;

import id.dana.domain.autoroute.model.SecurityContext;
import id.dana.network.response.autoroute.SecurityContextResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0000*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/familyaccount/model/result/SecurityContextEntity;", "Lid/dana/domain/autoroute/model/SecurityContext;", "toSecurityContext", "(Lid/dana/data/familyaccount/model/result/SecurityContextEntity;)Lid/dana/domain/autoroute/model/SecurityContext;", "Lid/dana/network/response/autoroute/SecurityContextResult;", "toSecurityContextEntity", "(Lid/dana/network/response/autoroute/SecurityContextResult;)Lid/dana/data/familyaccount/model/result/SecurityContextEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecurityContextEntityKt {
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final SecurityContextEntity toSecurityContextEntity(SecurityContextResult securityContextResult) {
        if (securityContextResult != null) {
            String pubKey = securityContextResult.getPubKey();
            if (pubKey == null) {
                pubKey = "";
            }
            return new SecurityContextEntity(pubKey);
        }
        ?? r1 = 0;
        return new SecurityContextEntity(r1, 1, r1);
    }

    public static final SecurityContext toSecurityContext(SecurityContextEntity securityContextEntity) {
        Intrinsics.checkNotNullParameter(securityContextEntity, "");
        return new SecurityContext(securityContextEntity.getPubKey());
    }
}
