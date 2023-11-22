package id.dana.mybills.domain.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.domain.model.FormModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0007B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/domain/interactor/ValidateFormUseCase;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/mybills/domain/interactor/ValidateFormUseCase$Params;", "", "", "<init>", "()V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ValidateFormUseCase extends BaseFlowUseCase<Params, Map<String, ? extends String>> {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ValidateFormUseCase() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.ValidateFormUseCase.<init>():void");
    }

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<Map<String, ? extends String>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return FlowKt.flow(new ValidateFormUseCase$buildUseCase$1(params2, null));
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/interactor/ValidateFormUseCase$Params;", "", "Lid/dana/mybills/domain/model/FormModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/domain/model/FormModel;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/mybills/domain/model/FormModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final FormModel MyBillsEntityDataFactory;

        public Params(FormModel formModel) {
            Intrinsics.checkNotNullParameter(formModel, "");
            this.MyBillsEntityDataFactory = formModel;
        }
    }
}
