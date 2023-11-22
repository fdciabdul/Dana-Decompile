package id.dana.data.ott.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.ott.OttVerifyEntity;
import id.dana.data.ott.OttVerifyRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/ott/repository/source/network/OttManageRpcFacade;", "", "Lid/dana/data/ott/OttVerifyRequest;", "ottVerifyRequest", "Lid/dana/data/ott/OttVerifyEntity;", "ottVerify", "(Lid/dana/data/ott/OttVerifyRequest;)Lid/dana/data/ott/OttVerifyEntity;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface OttManageRpcFacade {
    @OperationType("alipayplus.mobilewallet.wallet.user.ott.verify")
    @SignCheck
    OttVerifyEntity ottVerify(OttVerifyRequest ottVerifyRequest);
}
