package id.dana.danah5.globalnetwork;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import id.dana.danah5.globalnetwork.model.request.GetForexBalanceEntity;
import id.dana.data.base.BaseEvent;
import id.dana.data.foundation.utils.JsonUtil;

/* loaded from: classes8.dex */
public class GetForexBalanceEntityParser {
    private GetForexBalanceEntityParser() {
    }

    public static GetForexBalanceEntity getParsedEntity(JSONObject jSONObject) {
        BaseEvent baseEvent;
        String authRequestContext = JsonUtil.getAuthRequestContext((Object) jSONObject);
        GetForexBalanceEntity getForexBalanceEntity = (TextUtils.isEmpty(authRequestContext) || (baseEvent = (BaseEvent) JSON.parseObject(authRequestContext, new TypeReference<BaseEvent<GetForexBalanceEntity>>() { // from class: id.dana.danah5.globalnetwork.GetForexBalanceEntityParser.1
        }, new Feature[0])) == null || baseEvent.getInfo() == null) ? null : (GetForexBalanceEntity) baseEvent.getInfo();
        return getForexBalanceEntity == null ? new GetForexBalanceEntity() : getForexBalanceEntity;
    }
}
