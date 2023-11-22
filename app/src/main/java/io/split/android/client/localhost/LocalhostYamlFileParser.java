package io.split.android.client.localhost;

import io.split.android.client.dtos.Split;
import io.split.android.client.utils.YamlParser;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LocalhostYamlFileParser implements LocalhostFileParser {
    private static final String CONFIG_FIELD = "config";
    private static final String KEYS_FIELD = "keys";
    private static final String TREATMENT_FIELD = "treatment";

    @Override // io.split.android.client.localhost.LocalhostFileParser
    public Map<String, Split> parse(String str) {
        String str2;
        HashMap hashMap = null;
        try {
            List list = (List) new YamlParser().parse(str);
            if (list == null) {
                Logger.e("Feature flag file could not be parsed because it is not in the correct format.");
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (Object obj : list) {
                    try {
                        addLoadedSplitToParsedSplits(hashMap2, (Map) obj);
                    } catch (Exception unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("An error has occurred while parsing a feature flag");
                        if (obj != null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(", source: '");
                            sb2.append(obj);
                            sb2.append("'");
                            str2 = sb2.toString();
                        } else {
                            str2 = "";
                        }
                        sb.append(str2);
                        Logger.e(sb.toString());
                    }
                }
                return hashMap2;
            } catch (Exception unused2) {
                hashMap = hashMap2;
                Logger.e("An error has occurred while parsing localhost feature flags content");
                return hashMap;
            }
        } catch (Exception unused3) {
        }
    }

    private void addLoadedSplitToParsedSplits(Map<String, Split> map, Map<String, Object> map2) {
        String str;
        Map<String, String> map3;
        Object[] array = map2.keySet().toArray();
        if (array.length <= 0 || (str = (String) array[0]) == null || (map3 = (Map) map2.get(str)) == null || map3.get(TREATMENT_FIELD) == null) {
            return;
        }
        Split orCreateSplit = getOrCreateSplit(map, str);
        String str2 = map3.get(TREATMENT_FIELD);
        addConditionsToSplit(orCreateSplit, str2, parseKeys(map3.get("keys")));
        addConfigToSplit(orCreateSplit, map3, str2);
        map.put(orCreateSplit.name, orCreateSplit);
    }

    private void addConfigToSplit(Split split, Map<String, String> map, String str) {
        String str2 = map.get("config");
        if (str2 != null) {
            if (split.configurations == null) {
                split.configurations = new HashMap();
            }
            split.configurations.put(str, str2);
        }
    }

    private void addConditionsToSplit(Split split, String str, List<String> list) {
        if (list.size() > 0) {
            split.conditions.add(0, SplitHelper.createWhiteListCondition(list, str));
        } else {
            split.conditions.add(SplitHelper.createRolloutCondition(str));
        }
    }

    private List<String> parseKeys(Object obj) {
        if (obj == null) {
            return new ArrayList();
        }
        try {
            if (obj instanceof List) {
                return (ArrayList) obj;
            }
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add((String) obj);
            } catch (ClassCastException unused) {
            }
            return arrayList;
        } catch (ClassCastException unused2) {
            return new ArrayList();
        }
    }

    private Split getOrCreateSplit(Map<String, Split> map, String str) {
        Split split = map.get(str);
        return split == null ? SplitHelper.createDefaultSplit(str) : split;
    }
}
