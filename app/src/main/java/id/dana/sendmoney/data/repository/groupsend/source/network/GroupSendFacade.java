package id.dana.sendmoney.data.repository.groupsend.source.network;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.sendmoney.data.api.groupsend.detail.model.request.BizGroupDetailEntityRequest;
import id.dana.sendmoney.data.api.groupsend.detail.model.response.BizGroupDetailEntityResult;
import id.dana.sendmoney.data.api.groupsend.init.model.request.BizGroupTransferInitRequest;
import id.dana.sendmoney.data.api.groupsend.init.model.response.BizGroupTransferInitResult;
import id.dana.sendmoney.data.api.groupsend.modify.model.request.BizGroupModifyEntityRequest;
import id.dana.sendmoney.data.api.groupsend.modify.model.response.BizGroupModifyEntityResult;
import id.dana.sendmoney.data.api.groupsend.query.model.request.BizGroupQueryEntityRequest;
import id.dana.sendmoney.data.api.groupsend.query.model.response.BizGroupQueryEntityResult;
import id.dana.sendmoney.data.api.groupsend.submit.model.request.BizGroupTransferSubmitRequest;
import id.dana.sendmoney.data.api.groupsend.submit.model.response.BizGroupTransferSubmitResult;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/source/network/GroupSendFacade;", "", "Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;", "request", "Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "getBizGroupDetail", "(Lid/dana/sendmoney/data/api/groupsend/detail/model/request/BizGroupDetailEntityRequest;)Lid/dana/sendmoney/data/api/groupsend/detail/model/response/BizGroupDetailEntityResult;", "Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "getBizGroupQuery", "(Lid/dana/sendmoney/data/api/groupsend/query/model/request/BizGroupQueryEntityRequest;)Lid/dana/sendmoney/data/api/groupsend/query/model/response/BizGroupQueryEntityResult;", "Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", IAPSyncCommand.COMMAND_INIT, "(Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;)Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;", "modifyGroup", "(Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;)Lid/dana/sendmoney/data/api/groupsend/modify/model/response/BizGroupModifyEntityResult;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;", "submit", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;)Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GroupSendFacade {
    @OperationType(GroupSendOperationType.GROUP_DETAIL)
    @SignCheck
    BizGroupDetailEntityResult getBizGroupDetail(BizGroupDetailEntityRequest request);

    @OperationType(GroupSendOperationType.GROUP_QUERY)
    @SignCheck
    BizGroupQueryEntityResult getBizGroupQuery(BizGroupQueryEntityRequest request);

    @OperationType(GroupSendOperationType.GROUP_INIT)
    @SignCheck
    BizGroupTransferInitResult init(BizGroupTransferInitRequest request);

    @OperationType(GroupSendOperationType.GROUP_MODIFY)
    @SignCheck
    BizGroupModifyEntityResult modifyGroup(BizGroupModifyEntityRequest request);

    @OperationType(GroupSendOperationType.GROUP_TRANSFER_SUBMIT)
    @SignCheck
    BizGroupTransferSubmitResult submit(BizGroupTransferSubmitRequest request);
}
