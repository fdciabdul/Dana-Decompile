package id.dana.data.errorconfig.local;

import android.content.Context;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.errorconfig.ErrorConfigKey;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.model.ErrorConfigAmcsResult;
import id.dana.data.model.ErrorConfigResult;
import id.dana.data.storage.Serializer;
import id.dana.util.permission.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class LocalErrorConfigEntityData implements ErrorConfigEntityData {
    private static final String ENGLISH_LANGUAGE = "en";
    private static final String INDONESIAN_LANGUAGE = "in";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public LocalErrorConfigEntityData(Serializer serializer, Context context) {
        this.serializer = serializer;
        this.context = context;
    }

    private Map<String, List<ErrorConfigResult>> getErrorConfig(ErrorConfigAmcsResult errorConfigAmcsResult) {
        HashMap hashMap = new HashMap();
        if (Permission.KClassImpl$Data$declaredNonStaticMembers$2(this.context, "android.permission.READ_EXTERNAL_STORAGE")) {
            StringBuilder sb = new StringBuilder();
            sb.append(ErrorConfigKey.FILE_NAME_PREFIX);
            sb.append(errorConfigAmcsResult.getVersion());
            sb.append(".json");
            for (Map.Entry<String, String> entry : this.serializer.deserializeMap(JsonUtil.MyBillsEntityDataFactory(this.context, sb.toString())).entrySet()) {
                hashMap.put(entry.getKey(), createErrorCodeConfigFromMap(entry));
            }
        }
        return hashMap;
    }

    private List<ErrorConfigResult> createErrorCodeConfigFromMap(Map.Entry<String, String> entry) {
        Map<String, String> deserializeMap = this.serializer.deserializeMap(entry.getValue());
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry2 : deserializeMap.entrySet()) {
            arrayList.add(new ErrorConfigResult(entry2.getKey(), entry2.getValue()));
        }
        return arrayList;
    }

    private String searchErrorMessage(String str, String str2, ErrorConfigAmcsResult errorConfigAmcsResult) {
        List<ErrorConfigResult> list = getErrorConfig(errorConfigAmcsResult).get(str);
        if (list != null) {
            for (ErrorConfigResult errorConfigResult : list) {
                if (errorConfigResult.getId().equals(str2)) {
                    return errorConfigResult.getMessage();
                }
            }
            return null;
        }
        return null;
    }

    @Override // id.dana.data.errorconfig.ErrorConfigEntityData
    public String getErrorMessageByKey(String str, ErrorConfigAmcsResult errorConfigAmcsResult) {
        if (errorConfigAmcsResult == null || !errorConfigAmcsResult.isEnable()) {
            return null;
        }
        if (new Locale("in").getLanguage().equals(Locale.getDefault().getLanguage())) {
            return searchErrorMessage("in", str, errorConfigAmcsResult);
        }
        return searchErrorMessage(ENGLISH_LANGUAGE, str, errorConfigAmcsResult);
    }

    @Override // id.dana.data.errorconfig.ErrorConfigEntityData
    public ErrorConfigAmcsResult getErrorConfigAmcs() {
        throw new UnsupportedOperationException();
    }
}
