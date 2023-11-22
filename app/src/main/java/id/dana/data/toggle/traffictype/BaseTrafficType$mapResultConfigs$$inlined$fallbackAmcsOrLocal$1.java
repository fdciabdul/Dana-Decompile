package id.dana.data.toggle.traffictype;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.gson.Gson;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.util.ConfigUtil;
import id.dana.utils.extension.JSONExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "", "key", BridgeDSL.INVOKE, "(Ljava/lang/String;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes2.dex */
public final class BaseTrafficType$mapResultConfigs$$inlined$fallbackAmcsOrLocal$1<T> extends Lambda implements Function1<String, T> {
    final /* synthetic */ Map $$defaultMapValue$inlined;
    final /* synthetic */ Object $$defaultValue$inlined;
    final /* synthetic */ String $$key$inlined;
    final /* synthetic */ BaseTrafficType this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTrafficType$mapResultConfigs$$inlined$fallbackAmcsOrLocal$1(BaseTrafficType baseTrafficType, Map map, Object obj, String str) {
        super(1);
        this.this$0 = baseTrafficType;
        this.$$defaultMapValue$inlined = map;
        this.$$defaultValue$inlined = obj;
        this.$$key$inlined = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(String str) {
        String jSONObject;
        Intrinsics.checkNotNullParameter(str, "");
        JSONObject jSONConfig = ConfigCenter.getInstance().getJSONConfig(str);
        if (jSONConfig != null && (jSONObject = jSONConfig.toString()) != null) {
            T t = null;
            try {
                Gson PlaceComponentResult = JSONExtKt.PlaceComponentResult();
                String KClassImpl$Data$declaredNonStaticMembers$2 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, null);
                Intrinsics.reifiedOperationMarker(4, "T?");
                t = (T) PlaceComponentResult.fromJson(KClassImpl$Data$declaredNonStaticMembers$2, (Class) Object.class);
            } catch (Exception unused) {
            }
            if (t != null) {
                return t;
            }
        }
        ConfigUtil configUtil = ConfigUtil.INSTANCE;
        final BaseTrafficType baseTrafficType = this.this$0;
        Intrinsics.needClassReification();
        final Map map = this.$$defaultMapValue$inlined;
        final Object obj = this.$$defaultValue$inlined;
        return new Function1<String, T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$mapResultConfigs$lambda-8$$inlined$getDefaultValue$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                Map map2 = map;
                if (!((map2.isEmpty() ^ true) && map2.containsKey(str2))) {
                    map2 = null;
                }
                if (map2 != null) {
                    String json = JSONExtKt.PlaceComponentResult().toJson(map2.get(str2));
                    if (json == null) {
                        json = JSONExtKt.PlaceComponentResult().toJson(map2);
                    }
                    Gson PlaceComponentResult2 = JSONExtKt.PlaceComponentResult();
                    Intrinsics.reifiedOperationMarker(4, "T");
                    T t2 = (T) PlaceComponentResult2.fromJson(json, (Class) Object.class);
                    if (t2 != null) {
                        return t2;
                    }
                }
                BaseTrafficType baseTrafficType2 = baseTrafficType;
                return (T) obj;
            }
        }.invoke(this.$$key$inlined);
    }
}
