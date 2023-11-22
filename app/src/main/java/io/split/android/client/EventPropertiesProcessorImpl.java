package io.split.android.client;

import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.ValidationConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class EventPropertiesProcessorImpl implements EventPropertiesProcessor {
    private static final int MAXIMUM_EVENT_PROPERTY_BYTES = ValidationConfig.getInstance().getMaximumEventPropertyBytes();
    private static final int MAX_PROPS_COUNT = 300;
    private static final String VALIDATION_TAG = "track";

    @Override // io.split.android.client.EventPropertiesProcessor
    public ProcessedEventProperties process(Map<String, Object> map) {
        int i = 0;
        if (map == null) {
            return new ProcessedEventProperties(true, null, 0);
        }
        if (map.size() > 300) {
            Logger.w("trackEvent has more than 300 properties. Some of them will be trimmed when processed");
        }
        HashMap hashMap = new HashMap(map);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String obj = entry.getKey().toString();
            if (value != null && isInvalidValueType(value)) {
                hashMap.put(obj, null);
            }
            i += calculateEventSizeInBytes(obj, value);
            if (i > MAXIMUM_EVENT_PROPERTY_BYTES) {
                StringBuilder sb = new StringBuilder();
                sb.append("trackThe maximum size allowed for the  properties is 32kb. Current is ");
                sb.append(obj);
                sb.append(". Event not queued");
                Logger.w(sb.toString());
                return ProcessedEventProperties.InvalidProperties();
            }
        }
        return new ProcessedEventProperties(true, hashMap, i);
    }

    private boolean isInvalidValueType(Object obj) {
        return ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String)) ? false : true;
    }

    private int calculateEventSizeInBytes(String str, Object obj) {
        return ((obj == null || obj.getClass() != String.class) ? 0 : obj.toString().getBytes().length) + str.getBytes().length;
    }
}
