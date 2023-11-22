package id.dana.feeds.data.config.utils;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/data/config/utils/FeedsConfigGenerator;", "", "", "Lcom/alibaba/fastjson/JSONObject;", "getAuthRequestContext", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsConfigGenerator {
    public static final FeedsConfigGenerator INSTANCE = new FeedsConfigGenerator();

    private FeedsConfigGenerator() {
    }

    public static List<JSONObject> getAuthRequestContext() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reason_id", (Object) "code_1");
        jSONObject.put("id", (Object) "Komentar spam");
        jSONObject.put("en", (Object) "Spam comment");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("reason_id", (Object) "code_2");
        jSONObject2.put("id", (Object) "Komentar tidak pantas");
        jSONObject2.put("en", (Object) "Inappropriate comment");
        return CollectionsKt.listOf((Object[]) new JSONObject[]{jSONObject, jSONObject2});
    }
}
