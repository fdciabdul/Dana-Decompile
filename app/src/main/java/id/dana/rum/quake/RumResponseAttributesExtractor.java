package id.dana.rum.quake;

import android.webkit.CookieManager;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.rpc.RpcRequest;
import id.dana.rum.hash.HashUtils;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00062\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/rum/quake/RumResponseAttributesExtractor;", "Lio/opentelemetry/instrumentation/api/instrumenter/AttributesExtractor;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RumResponseAttributesExtractor implements AttributesExtractor<Request, NetworkResponse> {
    public static final AttributeKey<String> MyBillsEntityDataFactory;
    public static final AttributeKey<String> PlaceComponentResult;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final /* synthetic */ void onEnd(AttributesBuilder attributesBuilder, Context context, Request request, NetworkResponse networkResponse, Throwable th) {
        Object m3179constructorimpl;
        JSONObject jSONObject;
        List arrayList;
        NetworkResponse networkResponse2 = networkResponse;
        Intrinsics.checkNotNullParameter(attributesBuilder, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request, "");
        if (networkResponse2 != null) {
            String str = networkResponse2.extData.get("otelTraceId");
            if (str != null) {
                attributesBuilder.put((AttributeKey<AttributeKey<String>>) PlaceComponentResult, (AttributeKey<String>) str);
            }
            String str2 = networkResponse2.extData.get("Mgw-TraceId");
            if (str2 != null) {
                attributesBuilder.put((AttributeKey<AttributeKey<String>>) MyBillsEntityDataFactory, (AttributeKey<String>) str2);
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                RumResponseAttributesExtractor rumResponseAttributesExtractor = this;
                Map<String, String> map = networkResponse2.extData;
                Intrinsics.checkNotNullExpressionValue(map, "");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (Intrinsics.areEqual(entry.getKey(), "Set-Cookie")) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap;
                if (linkedHashMap2.isEmpty()) {
                    arrayList = CollectionsKt.emptyList();
                } else {
                    arrayList = new ArrayList();
                    for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                        CharSequence charSequence = (CharSequence) entry2.getValue();
                        if (!(charSequence == null || charSequence.length() == 0)) {
                            List split$default = StringsKt.split$default((CharSequence) ((String) entry2.getValue()).toString(), new String[]{";"}, false, 0, 6, (Object) null);
                            if ((!split$default.isEmpty()) != false) {
                                Iterator it = split$default.iterator();
                                while (it.hasNext()) {
                                    List split$default2 = StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{"="}, false, 0, 6, (Object) null);
                                    if (split$default2.size() == 2 && StringsKt.equals(StringsKt.trim((CharSequence) ((String) split$default2.get(0))).toString(), "ALIPAYJSESSIONID", true)) {
                                        arrayList.add(split$default2.get(1));
                                    }
                                }
                            }
                        }
                    }
                }
                List<String> list = arrayList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str3 : list) {
                    HashUtils hashUtils = HashUtils.INSTANCE;
                    arrayList2.add(StringsKt.take(HashUtils.PlaceComponentResult(str3), 20));
                }
                m3179constructorimpl = Result.m3179constructorimpl(arrayList2);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m3186isSuccessimpl(m3179constructorimpl)) {
                List list2 = (List) m3179constructorimpl;
                if ((!list2.isEmpty()) != false) {
                    attributesBuilder.put("dana.sessionIdAfter", CollectionsKt.joinToString$default(list2, ", ", null, null, 0, null, null, 62, null));
                }
            }
            byte[] bArr = networkResponse2.data;
            Intrinsics.checkNotNullExpressionValue(bArr, "");
            JSONObject jSONObject2 = new JSONObject(new String(bArr, Charsets.UTF_8));
            try {
                jSONObject = jSONObject2.getJSONObject("result");
            } catch (JSONException unused) {
                jSONObject = null;
            }
            int i = jSONObject2.getInt("resultStatus");
            if (i == 1000 && (jSONObject == null || jSONObject.getBoolean("success"))) {
                return;
            }
            attributesBuilder.put("error", true);
            if (jSONObject != null) {
                attributesBuilder.put("exception.type", jSONObject.getString("errorCode"));
                if (jSONObject.has("errorMessage")) {
                    attributesBuilder.put("exception.message", jSONObject.getString("errorMessage"));
                    return;
                }
                return;
            }
            attributesBuilder.put("exception.type", String.valueOf(i));
            attributesBuilder.put("exception.message", jSONObject2.getString("memo"));
        }
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final /* synthetic */ void onStart(AttributesBuilder attributesBuilder, Context context, Request request) {
        Object m3179constructorimpl;
        List list;
        Request request2 = request;
        Intrinsics.checkNotNullParameter(attributesBuilder, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request2, "");
        attributesBuilder.put("component", SemanticAttributes.FaasTriggerValues.HTTP);
        attributesBuilder.put("dana.operationType", request2.getActionType());
        RpcRequest rpcRequest = request2 instanceof RpcRequest ? (RpcRequest) request2 : null;
        try {
            Result.Companion companion = Result.INSTANCE;
            RumResponseAttributesExtractor rumResponseAttributesExtractor = this;
            String url = rpcRequest != null ? rpcRequest.getUrl() : null;
            if (url == null) {
                list = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                String cookie = CookieManager.getInstance().getCookie(url);
                String str = cookie;
                if (!(str == null || str.length() == 0)) {
                    List split$default = StringsKt.split$default((CharSequence) cookie.toString(), new String[]{";"}, false, 0, 6, (Object) null);
                    if ((!split$default.isEmpty()) != false) {
                        Iterator it = split$default.iterator();
                        while (it.hasNext()) {
                            List split$default2 = StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{"="}, false, 0, 6, (Object) null);
                            if (split$default2.size() == 2 && StringsKt.equals(StringsKt.trim((CharSequence) ((String) split$default2.get(0))).toString(), "ALIPAYJSESSIONID", true)) {
                                arrayList.add(split$default2.get(1));
                            }
                        }
                    }
                }
                list = arrayList;
            }
            List<String> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str2 : list2) {
                HashUtils hashUtils = HashUtils.INSTANCE;
                arrayList2.add(StringsKt.take(HashUtils.PlaceComponentResult(str2), 20));
            }
            m3179constructorimpl = Result.m3179constructorimpl(arrayList2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3186isSuccessimpl(m3179constructorimpl)) {
            List list3 = (List) m3179constructorimpl;
            if (true ^ list3.isEmpty()) {
                attributesBuilder.put("dana.sessionIdBefore", CollectionsKt.joinToString$default(list3, ", ", null, null, 0, null, null, 62, null));
            }
        }
    }

    static {
        AttributeKey<String> stringKey = AttributeKey.CC.stringKey("link.traceId");
        Intrinsics.checkNotNullExpressionValue(stringKey, "");
        PlaceComponentResult = stringKey;
        AttributeKey<String> stringKey2 = AttributeKey.CC.stringKey("dana.traceId");
        Intrinsics.checkNotNullExpressionValue(stringKey2, "");
        MyBillsEntityDataFactory = stringKey2;
    }
}
