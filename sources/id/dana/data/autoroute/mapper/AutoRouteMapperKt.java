package id.dana.data.autoroute.mapper;

import id.dana.data.autoroute.model.AuthenticationTypeOptionResult;
import id.dana.data.autoroute.model.AutoRouteInitResult;
import id.dana.data.autoroute.model.UserAutoRouteConfigStoreRequest;
import id.dana.domain.autoroute.model.AuthenticationTypeOption;
import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.autoroute.model.Risk;
import id.dana.domain.autoroute.model.SecurityContext;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import id.dana.network.response.autoroute.RiskResult;
import id.dana.network.response.autoroute.SecurityContextResult;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0017\u001a\u00020\u0000*\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u001b\u001a\u00020\u001a*\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "", "key", "value", "addExtParams", "(Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/data/autoroute/model/AuthenticationTypeOptionResult;", "Lid/dana/domain/autoroute/model/AuthenticationTypeOption;", "toAuthenticationTypeOption", "(Lid/dana/data/autoroute/model/AuthenticationTypeOptionResult;)Lid/dana/domain/autoroute/model/AuthenticationTypeOption;", "Lid/dana/data/autoroute/model/AutoRouteInitResult;", "Lid/dana/domain/autoroute/model/AutoRouteInit;", "toAutoRouteInit", "(Lid/dana/data/autoroute/model/AutoRouteInitResult;)Lid/dana/domain/autoroute/model/AutoRouteInit;", "Lid/dana/network/response/autoroute/RiskResult;", "Lid/dana/domain/autoroute/model/Risk;", "toRisk", "(Lid/dana/network/response/autoroute/RiskResult;)Lid/dana/domain/autoroute/model/Risk;", "Lid/dana/network/response/autoroute/SecurityContextResult;", "Lid/dana/domain/autoroute/model/SecurityContext;", "toSecurityContext", "(Lid/dana/network/response/autoroute/SecurityContextResult;)Lid/dana/domain/autoroute/model/SecurityContext;", "Lid/dana/domain/autoroute/model/UserAutoRouteConfigStore;", "toUserAutoRouteConfigRequest", "(Lid/dana/domain/autoroute/model/UserAutoRouteConfigStore;)Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "Lid/dana/domain/autoroute/model/UserAutoRouteConfigSwitch;", "toUserAutoRouteSwitch", "(Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;)Lid/dana/domain/autoroute/model/UserAutoRouteConfigSwitch;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AutoRouteMapperKt {
    public static final AutoRouteInit toAutoRouteInit(AutoRouteInitResult autoRouteInitResult) {
        List list;
        Intrinsics.checkNotNullParameter(autoRouteInitResult, "");
        Boolean autorouteFeatureEnable = autoRouteInitResult.getAutorouteFeatureEnable();
        Boolean autorouteConfigEnable = autoRouteInitResult.getAutorouteConfigEnable();
        String authenticationType = autoRouteInitResult.getAuthenticationType();
        List<AuthenticationTypeOptionResult> authenticationSettingOptions = autoRouteInitResult.getAuthenticationSettingOptions();
        if (authenticationSettingOptions != null) {
            List<AuthenticationTypeOptionResult> list2 = authenticationSettingOptions;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toAuthenticationTypeOption((AuthenticationTypeOptionResult) it.next()));
            }
            list = CollectionsKt.toMutableList((Collection) arrayList);
        } else {
            list = null;
        }
        return new AutoRouteInit(autorouteFeatureEnable, autorouteConfigEnable, authenticationType, list, autoRouteInitResult.getAutorouteAssetExist());
    }

    public static final AuthenticationTypeOption toAuthenticationTypeOption(AuthenticationTypeOptionResult authenticationTypeOptionResult) {
        Intrinsics.checkNotNullParameter(authenticationTypeOptionResult, "");
        return new AuthenticationTypeOption(authenticationTypeOptionResult.getAuthenticationType());
    }

    public static final Risk toRisk(RiskResult riskResult) {
        Intrinsics.checkNotNullParameter(riskResult, "");
        return new Risk(riskResult.getResult(), riskResult.getVerificationMethod(), riskResult.getSecurityId());
    }

    public static final SecurityContext toSecurityContext(SecurityContextResult securityContextResult) {
        Intrinsics.checkNotNullParameter(securityContextResult, "");
        return new SecurityContext(securityContextResult.getPubKey());
    }

    public static final UserAutoRouteConfigSwitch toUserAutoRouteSwitch(UserAutoRouteConfigSwitchResult userAutoRouteConfigSwitchResult) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigSwitchResult, "");
        RiskResult riskResult = userAutoRouteConfigSwitchResult.getRiskResult();
        Risk risk = riskResult != null ? toRisk(riskResult) : null;
        SecurityContextResult securityContext = userAutoRouteConfigSwitchResult.getSecurityContext();
        return new UserAutoRouteConfigSwitch(risk, securityContext != null ? toSecurityContext(securityContext) : null);
    }

    public static final UserAutoRouteConfigStoreRequest toUserAutoRouteConfigRequest(UserAutoRouteConfigStore userAutoRouteConfigStore) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigStore, "");
        return new UserAutoRouteConfigStoreRequest(userAutoRouteConfigStore.getAutoroute(), userAutoRouteConfigStore.getAuthenticationType(), userAutoRouteConfigStore.getSecurityId(), userAutoRouteConfigStore.getValidateData());
    }

    public static final String addExtParams(UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest, String str, String str2) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigStoreRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return userAutoRouteConfigStoreRequest.extParams.put(str, str2);
    }
}
