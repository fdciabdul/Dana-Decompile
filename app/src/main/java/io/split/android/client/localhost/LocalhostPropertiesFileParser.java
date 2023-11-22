package io.split.android.client.localhost;

import io.split.android.client.dtos.Split;
import io.split.android.client.utils.logger.Logger;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes6.dex */
public class LocalhostPropertiesFileParser implements LocalhostFileParser {
    @Override // io.split.android.client.localhost.LocalhostFileParser
    public Map<String, Split> parse(String str) {
        HashMap hashMap = null;
        if (str == null) {
            return null;
        }
        try {
            Properties properties = new Properties();
            properties.load(new StringReader(str));
            HashMap hashMap2 = new HashMap();
            try {
                for (Object obj : properties.keySet()) {
                    String str2 = (String) obj;
                    String property = properties.getProperty((String) obj);
                    if (str2 != null && property != null) {
                        Split createDefaultSplit = SplitHelper.createDefaultSplit(str2);
                        createDefaultSplit.conditions = new ArrayList();
                        createDefaultSplit.conditions.add(SplitHelper.createRolloutCondition(property));
                        hashMap2.put(createDefaultSplit.name, createDefaultSplit);
                    }
                }
                return hashMap2;
            } catch (Exception unused) {
                hashMap = hashMap2;
                Logger.e("Error loading localhost property file");
                return hashMap;
            }
        } catch (Exception unused2) {
        }
    }
}
