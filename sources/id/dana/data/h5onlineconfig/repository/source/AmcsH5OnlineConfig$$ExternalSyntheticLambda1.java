package id.dana.data.h5onlineconfig.repository.source;

import id.dana.data.foundation.utils.JsonUtil;
import io.reactivex.functions.Function;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final /* synthetic */ class AmcsH5OnlineConfig$$ExternalSyntheticLambda1 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return JsonUtil.MyBillsEntityDataFactory((JSONObject) obj);
    }
}
