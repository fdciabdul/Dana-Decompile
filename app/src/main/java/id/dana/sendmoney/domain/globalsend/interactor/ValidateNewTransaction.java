package id.dana.sendmoney.domain.globalsend.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import id.dana.sendmoney.domain.globalsend.model.validate.BeneficiaryInfo;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateRequest;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/interactor/ValidateNewTransaction;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/sendmoney/domain/globalsend/interactor/ValidateNewTransaction$Param;", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateResult;", "Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;", "p0", "<init>", "(Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ValidateNewTransaction extends BaseFlowUseCase<Param, TransferValidateResult> {
    private final GlobalSendRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<TransferValidateResult> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        GlobalSendRepository globalSendRepository = this.BuiltInFictitiousFunctionClassFactory;
        TransferValidateRequest.Companion companion = TransferValidateRequest.INSTANCE;
        return globalSendRepository.getAuthRequestContext(TransferValidateRequest.Companion.BuiltInFictitiousFunctionClassFactory(param2.MyBillsEntityDataFactory, param2.BuiltInFictitiousFunctionClassFactory, param2.PlaceComponentResult));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ValidateNewTransaction(id.dana.sendmoney.domain.globalsend.GlobalSendRepository r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.globalsend.interactor.ValidateNewTransaction.<init>(id.dana.sendmoney.domain.globalsend.GlobalSendRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/interactor/ValidateNewTransaction$Param;", "", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {
        final BeneficiaryInfo BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public Param(String str, BeneficiaryInfo beneficiaryInfo, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(beneficiaryInfo, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = beneficiaryInfo;
            this.PlaceComponentResult = str2;
        }
    }
}
