package id.dana.data.util;

import com.huawei.hms.framework.common.ExceptionCode;
import id.dana.data.config.source.amcs.result.RequestMoneyInfoResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/util/RequestMoneyDefaultConfigGenerator;", "", "Lid/dana/data/config/source/amcs/result/RequestMoneyInfoResult;", "createRequestMoneyInfo", "()Lid/dana/data/config/source/amcs/result/RequestMoneyInfoResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestMoneyDefaultConfigGenerator {
    public static final RequestMoneyDefaultConfigGenerator INSTANCE = new RequestMoneyDefaultConfigGenerator();

    private RequestMoneyDefaultConfigGenerator() {
    }

    public final RequestMoneyInfoResult createRequestMoneyInfo() {
        RequestMoneyInfoResult requestMoneyInfoResult = new RequestMoneyInfoResult();
        requestMoneyInfoResult.setMinAmount(1);
        requestMoneyInfoResult.setMaxAmount(ExceptionCode.CRASH_EXCEPTION);
        return requestMoneyInfoResult;
    }
}
