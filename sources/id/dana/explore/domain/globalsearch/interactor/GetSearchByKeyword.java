package id.dana.explore.domain.globalsearch.interactor;

import android.location.Location;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/explore/domain/globalsearch/model/SearchResultResponse;", "Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword$Params;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetSearchByKeyword extends BaseUseCase<List<? extends SearchResultResponse>, Params> {
    private final GlobalSearchRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends SearchResultResponse>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(params2.MyBillsEntityDataFactory, params2.KClassImpl$Data$declaredNonStaticMembers$2, params2.PlaceComponentResult, params2.BuiltInFictitiousFunctionClassFactory, params2.getAuthRequestContext, params2.lookAheadTest);
    }

    @Inject
    public GetSearchByKeyword(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = globalSearchRepository;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BC\b\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0000¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0003X\u0000¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\nX\u0000¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\fX\u0000¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0011\u0010\u0004\u001a\u00020\fX\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\b"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword$Params;", "", "", "", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroid/location/Location;", "Landroid/location/Location;", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;IILjava/util/List;Landroid/location/Location;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final Location getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final List<String> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;
        final String lookAheadTest;

        public /* synthetic */ Params(String str, int i, int i2, List list, Location location, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, list, location, str2);
        }

        private Params(String str, int i, int i2, List<String> list, Location location, String str2) {
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = i2;
            this.BuiltInFictitiousFunctionClassFactory = list;
            this.getAuthRequestContext = location;
            this.lookAheadTest = str2;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword$Params$Companion;", "", "", "p0", "", "p1", "p2", "", "p3", "Landroid/location/Location;", "p4", "p5", "Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword$Params;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;IILjava/util/List;Landroid/location/Location;Ljava/lang/String;)Lid/dana/explore/domain/globalsearch/interactor/GetSearchByKeyword$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public static Params BuiltInFictitiousFunctionClassFactory(String p0, int p1, int p2, List<String> p3, Location p4, String p5) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p3, "");
                return new Params(p0, p1, p2, p3, p4, p5, null);
            }
        }
    }
}
