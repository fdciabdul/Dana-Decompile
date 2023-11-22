package id.dana.danapoly.domain.play.interactor;

import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.play.DanapolyPlayRepository;
import id.dana.danapoly.domain.play.model.GetLeaderboard;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/danapoly/domain/play/interactor/FetchLeaderboard;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/danapoly/domain/play/interactor/FetchLeaderboard$Params;", "Lid/dana/danapoly/domain/play/model/GetLeaderboard;", "Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/domain/play/DanapolyPlayRepository;", "Lid/dana/danapoly/domain/play/DanapolyPlayRepository;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/danapoly/domain/config/DanapolyConfigRepository;Lid/dana/danapoly/domain/play/DanapolyPlayRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FetchLeaderboard extends BaseFlowUseCase<Params, GetLeaderboard> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final DanapolyConfigRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DanapolyPlayRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<GetLeaderboard> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return FlowKt.transformLatest(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(), new FetchLeaderboard$buildUseCase$$inlined$flatMapLatest$1(null, params2, this));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FetchLeaderboard(id.dana.danapoly.domain.config.DanapolyConfigRepository r3, id.dana.danapoly.domain.play.DanapolyPlayRepository r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            r2.MyBillsEntityDataFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.domain.play.interactor.FetchLeaderboard.<init>(id.dana.danapoly.domain.config.DanapolyConfigRepository, id.dana.danapoly.domain.play.DanapolyPlayRepository):void");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/domain/play/interactor/FetchLeaderboard$Params;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Params() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.domain.play.interactor.FetchLeaderboard.Params.<init>():void");
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
        }

        public /* synthetic */ Params(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }
    }
}
