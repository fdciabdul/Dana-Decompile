package com.alipay.zoloz.toyger.convert;

import com.alibaba.fastjson.JSON;
import com.alipay.zoloz.toyger.blob.model.Meta;
import com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty.EntryStringString;
import com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty.MapStringString;
import com.zoloz.zhub.endpoint.gwfacade.zhubalipay.empty.UnifiedContentPb.MetaPbPB;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes7.dex */
public class MetaConverter implements IOriginalConverter<MetaPbPB> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alipay.zoloz.toyger.convert.IOriginalConverter
    public MetaPbPB converter(Object obj) {
        if (obj instanceof Meta) {
            Meta meta = (Meta) obj;
            MetaPbPB metaPbPB = new MetaPbPB();
            metaPbPB.type = meta.type;
            metaPbPB.scoreStr = JSON.toJSONString(meta.score);
            metaPbPB.collectInfoStr = JSON.toJSONString(meta.collectInfo);
            metaPbPB.serialize = Integer.valueOf(meta.serialize);
            metaPbPB.bistoken = meta.bisToken;
            metaPbPB.invtpType = meta.invtpType;
            metaPbPB.extInfo = JSON.toJSONString(meta.extInfo);
            return metaPbPB;
        }
        return null;
    }

    private MapStringString convertMap(Map<String, String> map) {
        MapStringString mapStringString = new MapStringString();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            EntryStringString entryStringString = new EntryStringString();
            entryStringString.fillTagValue(1, entry.getKey());
            entryStringString.fillTagValue(2, entry.getValue());
            arrayList.add(entryStringString);
        }
        mapStringString.fillTagValue(1, arrayList);
        return mapStringString;
    }
}
