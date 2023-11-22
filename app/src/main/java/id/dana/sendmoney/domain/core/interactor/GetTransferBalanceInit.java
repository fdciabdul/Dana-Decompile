package id.dana.sendmoney.domain.core.interactor;

import com.alibaba.wireless.security.SecExceptionCode;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import id.dana.sendmoney.domain.core.model.init.TransferInitRequest;
import id.dana.sendmoney.domain.core.model.init.TransferInitResult;
import id.dana.sendmoney.domain.core.model.init.TransferParticipant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/core/interactor/GetTransferBalanceInit;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/sendmoney/domain/core/interactor/GetTransferBalanceInit$Param;", "Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "Lid/dana/sendmoney/domain/core/SendMoneyCoreRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/core/SendMoneyCoreRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/sendmoney/domain/core/SendMoneyCoreRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetTransferBalanceInit extends BaseFlowUseCase<Param, TransferInitResult> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SendMoneyCoreRepository BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Boolean, java.lang.String] */
    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<TransferInitResult> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        String str = null;
        String str2 = null;
        ?? r7 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(new TransferInitRequest(str, str2, r7, str3, str4, str5, new TransferParticipant(param2.MyBillsEntityDataFactory, param2.KClassImpl$Data$declaredNonStaticMembers$2, null, str, str2, r7, str3, str4, str5, SecExceptionCode.SEC_ERROR_DYN_STORE_DDPEX_KEY_VALUE_NOT_EXSIT, null), 63, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetTransferBalanceInit(id.dana.sendmoney.domain.core.SendMoneyCoreRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.BuiltInFictitiousFunctionClassFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.core.interactor.GetTransferBalanceInit.<init>(id.dana.sendmoney.domain.core.SendMoneyCoreRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/core/interactor/GetTransferBalanceInit$Param;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Param(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.MyBillsEntityDataFactory = str2;
        }
    }
}
