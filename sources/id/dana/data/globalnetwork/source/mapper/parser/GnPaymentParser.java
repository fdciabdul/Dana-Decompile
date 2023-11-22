package id.dana.data.globalnetwork.source.mapper.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import id.dana.domain.model.f2fpay.F2FPayOrderInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class GnPaymentParser {
    private GnPaymentParser() {
    }

    public static List<F2FPayOrderInfo> parseToF2FPayResultResponses(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.charAt(0) != '[') {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(str);
                sb.append("]");
                str = sb.toString();
            }
            return (List) JSON.parseObject(str.replace("&quot;", "\"").replaceAll(",\\\"extendInfo\\\":\\\"\\{.*\\}\\\"", ""), new TypeReference<List<F2FPayOrderInfo>>() { // from class: id.dana.data.globalnetwork.source.mapper.parser.GnPaymentParser.1
            }, new Feature[0]);
        }
        return new ArrayList();
    }
}
