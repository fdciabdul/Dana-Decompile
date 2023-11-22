package id.dana.lib.toggle;

import id.dana.lib.toggle.result.RawResult;
import java.util.Map;

/* loaded from: classes5.dex */
public interface RawResultsCallback {
    void onComplete(Map<String, RawResult> map);

    void onError();
}
