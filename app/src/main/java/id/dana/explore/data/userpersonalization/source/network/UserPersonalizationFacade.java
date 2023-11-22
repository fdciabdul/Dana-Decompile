package id.dana.explore.data.userpersonalization.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.explore.data.userpersonalization.source.network.request.CreateUserPersonalizationRequest;
import id.dana.explore.data.userpersonalization.source.network.request.UserPreferenceRequest;
import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionListEntity;
import id.dana.explore.data.userpersonalization.source.network.result.UserPreferenceResultEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/network/UserPersonalizationFacade;", "", "Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;", "request", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "createUserPreference", "(Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "getPreferenceOptionList", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "Lid/dana/explore/data/userpersonalization/source/network/request/UserPreferenceRequest;", "userPreferenceRequest", "Lid/dana/explore/data/userpersonalization/source/network/result/UserPreferenceResultEntity;", "getUserPreference", "(Lid/dana/explore/data/userpersonalization/source/network/request/UserPreferenceRequest;)Lid/dana/explore/data/userpersonalization/source/network/result/UserPreferenceResultEntity;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface UserPersonalizationFacade {
    @OperationType("id.dana.danasearch.user.preference.bulkinsert")
    @SignCheck
    BaseRpcResult createUserPreference(CreateUserPersonalizationRequest request);

    @OperationType("id.dana.danasearch.user.preference.options.query")
    @SignCheck
    PreferenceOptionListEntity getPreferenceOptionList(BaseRpcRequest request);

    @OperationType("id.dana.danasearch.user.preference.search")
    @SignCheck
    UserPreferenceResultEntity getUserPreference(UserPreferenceRequest userPreferenceRequest);
}
