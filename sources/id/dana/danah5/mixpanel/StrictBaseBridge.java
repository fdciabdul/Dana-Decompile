package id.dana.danah5.mixpanel;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.H5ExtKt;
import id.dana.danah5.mixpanel.StrictBaseBridge;
import id.dana.danah5.mixpanel.model.JSApiRuleModel;
import id.dana.danah5.mixpanel.model.JSApiStatus;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0005@\u0005X\u0085.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/danah5/mixpanel/StrictBaseBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", RecordError.KEY_JSAPI_NAME, "Lcom/alibaba/ariver/app/api/Page;", "page", "Lid/dana/danah5/mixpanel/model/JSApiStatus;", "canUse", "(Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)Lid/dana/danah5/mixpanel/model/JSApiStatus;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "getSplitFacade", "()Lid/dana/data/toggle/SplitFacade;", "setSplitFacade", "(Lid/dana/data/toggle/SplitFacade;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class StrictBaseBridge extends BaseBridge {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @Inject
    protected SplitFacade splitFacade;

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getSplitFacade")
    public final SplitFacade getSplitFacade() {
        SplitFacade splitFacade = this.splitFacade;
        if (splitFacade != null) {
            return splitFacade;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSplitFacade")
    protected final void setSplitFacade(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSApiStatus canUse(String jsapiName, Page page) {
        Intrinsics.checkNotNullParameter(jsapiName, "");
        Intrinsics.checkNotNullParameter(page, "");
        return INSTANCE.canUse(getSplitFacade(), jsapiName, page);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danah5/mixpanel/StrictBaseBridge$Companion;", "", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "", RecordError.KEY_JSAPI_NAME, "Lcom/alibaba/ariver/app/api/Page;", "page", "Lid/dana/danah5/mixpanel/model/JSApiStatus;", "canUse", "(Lid/dana/data/toggle/SplitFacade;Ljava/lang/String;Lcom/alibaba/ariver/app/api/Page;)Lid/dana/danah5/mixpanel/model/JSApiStatus;", "Lorg/json/JSONObject;", "fetchConfigFromSplit", "(Lid/dana/data/toggle/SplitFacade;)Lorg/json/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final JSONObject fetchConfigFromSplit(SplitFacade splitFacade) {
            Object blockingFirst = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.danah5.mixpanel.StrictBaseBridge$Companion$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    JSONObject m705fetchConfigFromSplit$lambda0;
                    m705fetchConfigFromSplit$lambda0 = StrictBaseBridge.Companion.m705fetchConfigFromSplit$lambda0((BaseTrafficType) obj);
                    return m705fetchConfigFromSplit$lambda0;
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
            return (JSONObject) blockingFirst;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: fetchConfigFromSplit$lambda-0  reason: not valid java name */
        public static final JSONObject m705fetchConfigFromSplit$lambda0(BaseTrafficType baseTrafficType) {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object emptyMap = MapsKt.emptyMap();
            String authRequestContext = baseTrafficType.getAuthRequestContext("jsapi_rules", false);
            if (Map.class.isAssignableFrom(JSONArray.class)) {
                emptyMap = (Map) new JSONArray(authRequestContext != null ? authRequestContext : "");
            } else if (authRequestContext != null) {
                Object obj = null;
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) Map.class);
                } catch (Exception unused) {
                }
                if (obj != null) {
                    emptyMap = obj;
                }
            }
            return new JSONObject((Map) emptyMap);
        }

        public final JSApiStatus canUse(SplitFacade splitFacade, String jsapiName, Page page) {
            String optString;
            boolean z;
            Intrinsics.checkNotNullParameter(splitFacade, "");
            Intrinsics.checkNotNullParameter(jsapiName, "");
            Intrinsics.checkNotNullParameter(page, "");
            String appId = H5ExtKt.getAppId(page);
            Boolean bool = Boolean.TRUE;
            boolean z2 = true;
            boolean z3 = false;
            if (appId != null && !StringsKt.isBlank(appId)) {
                z2 = false;
            }
            if (!z2 && (optString = fetchConfigFromSplit(splitFacade).optString(jsapiName)) != null) {
                JSApiRuleModel jSApiRuleModel = (JSApiRuleModel) JSONExtKt.PlaceComponentResult().fromJson(optString, JSApiRuleModel.class);
                if (jSApiRuleModel != null && jSApiRuleModel.getEnabled()) {
                    String appId2 = H5ExtKt.getAppId(page);
                    if (appId2 != null) {
                        List<String> appIds = jSApiRuleModel.getWhitelist().getAppIds();
                        z = Intrinsics.areEqual(appIds != null ? Boolean.valueOf(appIds.contains(appId2)) : null, bool);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        String serviceKey = H5ExtKt.getServiceKey(page);
                        if (serviceKey != null) {
                            List<String> serviceKeys = jSApiRuleModel.getWhitelist().getServiceKeys();
                            z3 = Intrinsics.areEqual(serviceKeys != null ? Boolean.valueOf(serviceKeys.contains(serviceKey)) : null, bool);
                        }
                        if (!z3) {
                            return JSApiStatus.NOT_WHITELIST;
                        }
                    }
                    return JSApiStatus.ENABLED;
                }
                return JSApiStatus.DISABLED;
            }
            return JSApiStatus.ENABLED;
        }
    }
}
