package id.dana.sendmoney.domain.globalsend.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.request.TransferSubmitRequest;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.response.TransferSubmitResult;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/interactor/TransferSubmit;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/sendmoney/domain/globalsend/interactor/TransferSubmit$Param;", "Lid/dana/sendmoney/domain/globalsend/model/transfersubmit/response/TransferSubmitResult;", "Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;", "PlaceComponentResult", "Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/sendmoney/domain/globalsend/GlobalSendRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferSubmit extends BaseFlowUseCase<Param, TransferSubmitResult> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GlobalSendRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<TransferSubmitResult> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        String str = param2.MyBillsEntityDataFactory;
        String str2 = param2.BuiltInFictitiousFunctionClassFactory;
        String str3 = param2.getAuthRequestContext;
        String obj = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new TransferSubmitRequest(str, str2, str3, obj, param2.PlaceComponentResult, param2.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransferSubmit(id.dana.sendmoney.domain.globalsend.GlobalSendRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.getAuthRequestContext = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.globalsend.interactor.TransferSubmit.<init>(id.dana.sendmoney.domain.globalsend.GlobalSendRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/interactor/TransferSubmit$Param;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "p0", "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;
        final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        public Param(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
            this.getAuthRequestContext = str3;
            this.PlaceComponentResult = str4;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        }
    }
}
