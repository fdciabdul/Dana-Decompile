package id.dana.sendmoney.data.repository.groupsend.source.split;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.fastjson.JSONObject;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/source/split/GroupSendDefaultConfigGenerator;", "", "", "Lcom/alibaba/fastjson/JSONObject;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendDefaultConfigGenerator {
    public static final GroupSendDefaultConfigGenerator INSTANCE = new GroupSendDefaultConfigGenerator();

    private GroupSendDefaultConfigGenerator() {
    }

    public static List<JSONObject> KClassImpl$Data$declaredNonStaticMembers$2() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", (Object) "Kirim ke Bank");
        jSONObject.put(RVParams.LONG_SUB_TITLE, (Object) "Buat grup untuk Kirim Uang ke beberapa bank.");
        jSONObject.put("action", (Object) GroupSendRecipientType.BANK);
        jSONObject.put("backgroundImg", (Object) "");
        jSONObject.put("icon", (Object) "https://a.m.dana.id/resource/icons/send-money-group/x2b.png");
        jSONObject.put("promoTitle", (Object) "");
        jSONObject.put("promoDesc", (Object) "");
        Boolean bool = Boolean.FALSE;
        jSONObject.put("promoActive", (Object) bool);
        Boolean bool2 = Boolean.TRUE;
        jSONObject.put("isEnable", (Object) bool2);
        Unit unit = Unit.INSTANCE;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("title", (Object) "Kirim ke Teman");
        jSONObject2.put(RVParams.LONG_SUB_TITLE, (Object) "Buat grup untuk Kirim Uang ke teman-temanmu.");
        jSONObject2.put("action", (Object) GroupSendRecipientType.CONTACT);
        jSONObject2.put("backgroundImg", (Object) "");
        jSONObject2.put("icon", (Object) "https://a.m.dana.id/resource/icons/send-money-group/x2p.png");
        jSONObject2.put("promoTitle", (Object) "");
        jSONObject2.put("promoDesc", (Object) "");
        jSONObject2.put("promoActive", (Object) bool);
        jSONObject2.put("isEnable", (Object) bool2);
        Unit unit2 = Unit.INSTANCE;
        return CollectionsKt.listOf((Object[]) new JSONObject[]{jSONObject, jSONObject2});
    }
}
