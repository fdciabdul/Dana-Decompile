package id.dana.data.h5onlineconfig.repository;

import com.alibaba.fastjson.JSONObject;
import id.dana.data.h5onlineconfig.repository.source.AmcsH5OnlineConfig;
import id.dana.domain.h5onlineconfig.H5OnlineConfigRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class H5OnlineConfigEntityRepository implements H5OnlineConfigRepository {
    private final AmcsH5OnlineConfig amcsH5OnlineConfig;

    @Inject
    public H5OnlineConfigEntityRepository(AmcsH5OnlineConfig amcsH5OnlineConfig) {
        this.amcsH5OnlineConfig = amcsH5OnlineConfig;
    }

    @Override // id.dana.domain.h5onlineconfig.H5OnlineConfigRepository
    public Observable<String> getH5OnlineConfig(String str, Set<String> set) {
        return this.amcsH5OnlineConfig.getH5OnlineConfig(str, set).map(new Function() { // from class: id.dana.data.h5onlineconfig.repository.H5OnlineConfigEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((JSONObject) obj).toJSONString();
            }
        });
    }
}
