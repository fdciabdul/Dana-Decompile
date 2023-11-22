package id.dana.domain.h5onlineconfig;

import io.reactivex.Observable;
import java.util.Set;

/* loaded from: classes2.dex */
public interface H5OnlineConfigRepository {
    Observable<String> getH5OnlineConfig(String str, Set<String> set);
}
