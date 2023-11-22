package id.dana.feeds.data.config.utils;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/feeds/data/config/utils/DefaultFriendshipGenerator;", "", "Lcom/alibaba/fastjson/JSONObject;", "MyBillsEntityDataFactory", "()Lcom/alibaba/fastjson/JSONObject;", "", "", "PlaceComponentResult", "()Ljava/util/List;", "", "Lkotlin/Pair;", "getAuthRequestContext", "()[Lkotlin/Pair;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultFriendshipGenerator {
    public static final DefaultFriendshipGenerator INSTANCE = new DefaultFriendshipGenerator();

    private DefaultFriendshipGenerator() {
    }

    public static JSONObject MyBillsEntityDataFactory() {
        JSONObject jSONObject = new JSONObject();
        MapsKt.putAll(jSONObject, getAuthRequestContext());
        return jSONObject;
    }

    public static Pair<String, String>[] getAuthRequestContext() {
        return new Pair[]{new Pair<>("2615", "hot beverage"), new Pair<>("2705", "check mark button"), new Pair<>("1F973", "partying face"), new Pair<>("1F929", "star-struck"), new Pair<>("1F60D", "smiling face with heart-eyes"), new Pair<>("1F62E", "face with open mouth"), new Pair<>("1F924", "drooling face"), new Pair<>("1F60E", "smiling face with sunglasses"), new Pair<>("1F914", "thinking face"), new Pair<>("1F97A", "pleading face"), new Pair<>("1F62D", "loudly crying face"), new Pair<>("1F44D", "thumbs up"), new Pair<>("1F44C", "OK hand"), new Pair<>("1F44F", "clapping hands"), new Pair<>("1F91F", "love-you gesture"), new Pair<>("1F919", "call me hand"), new Pair<>("1F64F", "folded hands"), new Pair<>("1F4AA", "flexed biceps"), new Pair<>("1F355", "pizza"), new Pair<>("1F357", "poultry leg"), new Pair<>("1F37D", "fork and knife with plate"), new Pair<>("1F389", "party popper"), new Pair<>("1F38A", "confetti ball"), new Pair<>("1F381", "wrapped gift"), new Pair<>("1F9E7", "red envelope"), new Pair<>("1F4B0", "money bag"), new Pair<>("1F4B8", "money with wings"), new Pair<>("1F4AF", "hundred points"), new Pair<>("1F495", "two hearts"), new Pair<>("1F494", "broken heart")};
    }

    public static List<String> PlaceComponentResult() {
        return CollectionsKt.listOf((Object[]) new String[]{"1F929", "1F60D", "1F62E", "1F924", "1F973", "1F60E", "1F914", "1F97A", "1F62D", "1F44D", "1F44C", "1F44F", "1F91F", "1F919", "1F64F", "1F4AA", "2615", "1F355", "1F357", "1F37D", "1F389", "1F38A", "1F381", "1F9E7", "1F4B0", "1F4B8", "1F4AF", "1F495", "1F494", "2705"});
    }
}
