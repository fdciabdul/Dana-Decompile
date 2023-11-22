package io.split.android.client.service.impressions;

import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.dtos.TestImpressions;
import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.utils.Json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ImpressionsRequestBodySerializer implements HttpRequestBodySerializer<List<KeyImpression>> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(List<KeyImpression> list) {
        return Json.toJson(groupImpressions(list));
    }

    private List<TestImpressions> groupImpressions(List<KeyImpression> list) {
        HashMap hashMap = new HashMap();
        for (KeyImpression keyImpression : list) {
            List list2 = (List) hashMap.get(keyImpression.feature);
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.add(keyImpression);
            hashMap.put(keyImpression.feature, list2);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            TestImpressions testImpressions = new TestImpressions();
            testImpressions.testName = (String) entry.getKey();
            testImpressions.keyImpressions = (List) entry.getValue();
            arrayList.add(testImpressions);
        }
        return arrayList;
    }
}
