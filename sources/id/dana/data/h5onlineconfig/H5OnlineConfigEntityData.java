package id.dana.data.h5onlineconfig;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.Observable;
import java.util.Set;

/* loaded from: classes2.dex */
public interface H5OnlineConfigEntityData {
    Observable<JSONObject> getH5OnlineConfig(String str, Set<String> set);
}
