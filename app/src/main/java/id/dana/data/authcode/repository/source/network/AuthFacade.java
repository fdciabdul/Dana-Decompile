package id.dana.data.authcode.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.authcode.AuthCodeEntity;
import id.dana.data.authcode.AuthRequest;
import id.dana.data.authcode.QueryAuthInfoRequest;
import id.dana.data.authcode.QueryAuthInfoResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/authcode/repository/source/network/AuthFacade;", "", "Lid/dana/data/authcode/AuthRequest;", "request", "Lid/dana/data/authcode/AuthCodeEntity;", "oauthAuthCodeApply", "(Lid/dana/data/authcode/AuthRequest;)Lid/dana/data/authcode/AuthCodeEntity;", "Lid/dana/data/authcode/QueryAuthInfoRequest;", "Lid/dana/data/authcode/QueryAuthInfoResult;", "queryAuthInfo", "(Lid/dana/data/authcode/QueryAuthInfoRequest;)Lid/dana/data/authcode/QueryAuthInfoResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuthFacade {
    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.GET_AUTH_CODE)
    @SignCheck
    AuthCodeEntity oauthAuthCodeApply(AuthRequest request);

    @OperationType(TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_AUTH_INFO)
    @SignCheck
    QueryAuthInfoResult queryAuthInfo(QueryAuthInfoRequest request);
}
