package io.split.android.client.service.sseclient;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.logger.Logger;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class SseJwtParser {
    static final Type ALL_TOKEN_TYPE = new TypeToken<Map<String, Object>>() { // from class: io.split.android.client.service.sseclient.SseJwtParser.1
    }.getType();
    static final Type CHANNEL_TYPE = new TypeToken<Map<String, List<String>>>() { // from class: io.split.android.client.service.sseclient.SseJwtParser.2
    }.getType();
    private static final String PUBLISHERS_CHANNEL_METADATA = "channel-metadata:publishers";
    private static final String PUBLISHERS_CHANNEL_PREFIX = "[?occupancy=metrics.publishers]";

    public SseJwtToken parse(String str) throws InvalidJwtTokenException {
        if (str == null) {
            Logger.e("Error: JWT is null.");
            throw new InvalidJwtTokenException();
        }
        String extractTokenData = extractTokenData(str);
        if (extractTokenData == null) {
            Logger.e("SSE authentication JWT payload is not valid.");
            throw new InvalidJwtTokenException();
        }
        String decode = Base64Util.decode(extractTokenData);
        if (decode == null) {
            Logger.e("Could not decode SSE authentication JWT payload.");
            throw new InvalidJwtTokenException();
        }
        try {
            SseAuthToken sseAuthToken = (SseAuthToken) Json.fromJson(decode, SseAuthToken.class);
            if (sseAuthToken == null || sseAuthToken.getChannelList() == null) {
                Logger.e("SSE JWT data is empty or not valid.");
                throw new InvalidJwtTokenException();
            }
            Map map = (Map) Json.fromJson(sseAuthToken.getChannelList(), CHANNEL_TYPE);
            if (map == null) {
                Logger.e("SSE JWT has not channels.");
                throw new InvalidJwtTokenException();
            }
            ArrayList arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                List list = (List) map.get(str2);
                if (list != null && list.contains(PUBLISHERS_CHANNEL_METADATA)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(PUBLISHERS_CHANNEL_PREFIX);
                    sb.append(str2);
                    arrayList.add(sb.toString());
                } else {
                    arrayList.add(str2);
                }
            }
            return new SseJwtToken(sseAuthToken.getIssuedAt(), sseAuthToken.getExpirationAt(), arrayList, str);
        } catch (JsonSyntaxException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error parsing SSE authentication JWT json ");
            sb2.append(e.getLocalizedMessage());
            Logger.e(sb2.toString());
            throw new InvalidJwtTokenException();
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknonwn error while parsing SSE authentication JWT: ");
            sb3.append(e2.getLocalizedMessage());
            Logger.e(sb3.toString());
            throw new InvalidJwtTokenException();
        }
    }

    private String extractTokenData(String str) {
        String[] split = str.split("\\.");
        if (split.length > 1) {
            return split[1];
        }
        return null;
    }

    private List<String> emptyChannelList() {
        return new ArrayList();
    }
}
