package id.dana.danah5.extension;

import android.net.Uri;
import com.alibaba.griver.api.ui.share.GriverShareURLCreatorExtension;
import com.google.gson.JsonObject;
import id.dana.danah5.share.ShareToFeedBridge;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danah5/extension/DanaGriverShareURLCreatorExtension;", "Lcom/alibaba/griver/api/ui/share/GriverShareURLCreatorExtension;", "", "", "params", "urlForParams", "(Ljava/util/Map;)Ljava/lang/String;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaGriverShareURLCreatorExtension implements GriverShareURLCreatorExtension {
    public static final String FEEDS_PARAMS = "feedsParams";
    private static final String PATH = "_ariver_path";
    private static final String QUERY = "query";

    @Inject
    public DanaGriverShareURLCreatorExtension() {
    }

    @Override // com.alibaba.griver.api.ui.share.GriverShareURLCreatorExtension
    public final String urlForParams(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "");
        JsonObject jsonObject = new JsonObject();
        String remove = params.remove("_ariver_path");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String value = entry.getValue();
            if (!(value == null || value.length() == 0)) {
                jsonObject.addProperty(entry.getKey(), entry.getValue());
            }
        }
        if (remove != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("http://");
            sb.append(remove);
            String obj = sb.toString();
            if (obj != null) {
                Uri parse = Uri.parse(obj);
                String substringBefore$default = StringsKt.substringBefore$default(remove, '?', (String) null, 2, (Object) null);
                jsonObject.addProperty("_ariver_path", substringBefore$default);
                JsonObject jsonObject2 = new JsonObject();
                Uri.Builder buildUpon = Uri.parse(substringBefore$default).buildUpon();
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameterNames, "");
                    for (String str : queryParameterNames) {
                        if (str != null) {
                            int hashCode = str.hashCode();
                            if (hashCode != -389647866) {
                                if (hashCode != -389131437) {
                                    if (hashCode == -364473263 && str.equals(ShareToFeedBridge.CONTENT_FORMATTER)) {
                                        jsonObject2.addProperty(str, parse.getQueryParameter(str));
                                    }
                                } else if (str.equals("contentType")) {
                                    jsonObject2.addProperty(str, parse.getQueryParameter(str));
                                }
                            } else if (str.equals("contentCode")) {
                                jsonObject2.addProperty(str, parse.getQueryParameter(str));
                            }
                        }
                        buildUpon.appendQueryParameter(str, parse.getQueryParameter(str));
                    }
                }
                jsonObject.add(FEEDS_PARAMS, jsonObject2);
                jsonObject.addProperty("query", buildUpon.build().getQuery());
            }
        }
        String obj2 = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        return obj2;
    }
}
