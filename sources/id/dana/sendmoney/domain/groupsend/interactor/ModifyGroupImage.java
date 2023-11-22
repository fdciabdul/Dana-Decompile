package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyRequest;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupImage;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupImage$Param;", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyResult;", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModifyGroupImage extends BaseFlowUseCase<Param, BizGroupModifyResult> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GroupSendRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<BizGroupModifyResult> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        GroupSendRepository groupSendRepository = this.MyBillsEntityDataFactory;
        BizGroupModifyRequest.Companion companion = BizGroupModifyRequest.INSTANCE;
        return groupSendRepository.MyBillsEntityDataFactory(BizGroupModifyRequest.Companion.getAuthRequestContext(param2.KClassImpl$Data$declaredNonStaticMembers$2, param2.MyBillsEntityDataFactory));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ModifyGroupImage(id.dana.sendmoney.domain.groupsend.GroupSendRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.MyBillsEntityDataFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupImage.<init>(id.dana.sendmoney.domain.groupsend.GroupSendRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupImage$Param;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Param(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = str2;
        }
    }
}
