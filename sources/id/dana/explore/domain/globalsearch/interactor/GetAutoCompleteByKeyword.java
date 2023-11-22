package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.model.AutoCompleteResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/explore/domain/globalsearch/model/AutoCompleteResult;", "Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword$Params;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "PlaceComponentResult", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetAutoCompleteByKeyword extends BaseUseCase<AutoCompleteResult, Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GlobalSearchRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<AutoCompleteResult> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(params2.BuiltInFictitiousFunctionClassFactory, params2.MyBillsEntityDataFactory, params2.PlaceComponentResult);
    }

    @Inject
    public GetAutoCompleteByKeyword(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalSearchRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0002X\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0006X\u0000¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword$Params;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "I", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final int MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        public /* synthetic */ Params(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2);
        }

        private Params(String str, int i, int i2) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = i2;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword$Params$Companion;", "", "", "p0", "", "p1", "p2", "Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword$Params;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/explore/domain/globalsearch/interactor/GetAutoCompleteByKeyword$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public static Params KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return new Params(str, 1, 5, null);
            }
        }
    }
}
