package id.dana.danah5.globalnetwork;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import id.dana.danah5.globalnetwork.model.request.InquiryForexRateEntity;
import id.dana.data.base.BaseEvent;
import id.dana.data.foundation.utils.JsonUtil;

/* loaded from: classes8.dex */
public class InquiryForexRateParser {
    private InquiryForexRateParser() {
    }

    public static InquiryForexRateEntity getParsedEntity(JSONObject jSONObject) {
        BaseEvent baseEvent;
        String authRequestContext = JsonUtil.getAuthRequestContext((Object) jSONObject);
        InquiryForexRateEntity inquiryForexRateEntity = (TextUtils.isEmpty(authRequestContext) || (baseEvent = (BaseEvent) JSON.parseObject(authRequestContext, new TypeReference<BaseEvent<InquiryForexRateEntity>>() { // from class: id.dana.danah5.globalnetwork.InquiryForexRateParser.1
        }, new Feature[0])) == null || baseEvent.getInfo() == null) ? null : (InquiryForexRateEntity) baseEvent.getInfo();
        return inquiryForexRateEntity == null ? new InquiryForexRateEntity() : inquiryForexRateEntity;
    }
}
