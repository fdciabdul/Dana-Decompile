package id.dana.mybills.domain.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.model.CheckUniqueValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/domain/interactor/CheckBillsUniqueValue;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/mybills/domain/interactor/CheckBillsUniqueValue$Params;", "Lid/dana/mybills/domain/model/CheckUniqueValue;", "Lid/dana/mybills/domain/MyBillsRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/domain/MyBillsRepository;", "p0", "<init>", "(Lid/dana/mybills/domain/MyBillsRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckBillsUniqueValue extends BaseFlowUseCase<Params, CheckUniqueValue> {
    private final MyBillsRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<CheckUniqueValue> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(params2.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CheckBillsUniqueValue(id.dana.mybills.domain.MyBillsRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.CheckBillsUniqueValue.<init>(id.dana.mybills.domain.MyBillsRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/interactor/CheckBillsUniqueValue$Params;", "", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "MyBillsEntityDataFactory", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final UniqueValueRequest BuiltInFictitiousFunctionClassFactory;

        public Params(UniqueValueRequest uniqueValueRequest) {
            Intrinsics.checkNotNullParameter(uniqueValueRequest, "");
            this.BuiltInFictitiousFunctionClassFactory = uniqueValueRequest;
        }
    }
}
