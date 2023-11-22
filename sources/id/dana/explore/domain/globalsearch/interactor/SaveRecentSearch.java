package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch$Params;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SaveRecentSearch extends BaseUseCase<Unit, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GlobalSearchRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Unit> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(params2.BuiltInFictitiousFunctionClassFactory, params2.MyBillsEntityDataFactory);
    }

    @Inject
    public SaveRecentSearch(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.PlaceComponentResult = globalSearchRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0000¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0000¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch$Params;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "J", "p0", "p1", "<init>", "(Ljava/lang/String;J)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;
        final long MyBillsEntityDataFactory;

        public /* synthetic */ Params(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j);
        }

        private Params(String str, long j) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = j;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch$Params$Companion;", "", "", "p0", "", "p1", "Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch$Params;", "getAuthRequestContext", "(Ljava/lang/String;J)Lid/dana/explore/domain/globalsearch/interactor/SaveRecentSearch$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public static Params getAuthRequestContext(String p0, long p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                return new Params(p0, p1, null);
            }
        }
    }
}
