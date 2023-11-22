package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.globalsearch.model.SearchCondition;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000b\f\rB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/explore/domain/globalsearch/model/SearchResultResponse;", "Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant$Params;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "MyBillsEntityDataFactory", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V", "Companion", "OnlineMerchantType", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetOnlineMerchant extends BaseUseCase<SearchResultResponse, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GlobalSearchRepository getAuthRequestContext;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant$OnlineMerchantType;", "", "<init>", "(Ljava/lang/String;I)V", PayMethod.ALL, "TRENDING", "SEARCH"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum OnlineMerchantType {
        ALL,
        TRENDING,
        SEARCH
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[OnlineMerchantType.values().length];
            iArr[OnlineMerchantType.ALL.ordinal()] = 1;
            iArr[OnlineMerchantType.TRENDING.ordinal()] = 2;
            iArr[OnlineMerchantType.SEARCH.ordinal()] = 3;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<SearchResultResponse> buildUseCase(Params params) {
        Observable<SearchResultResponse> MyBillsEntityDataFactory;
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[params2.MyBillsEntityDataFactory.ordinal()];
        if (i == 1) {
            MyBillsEntityDataFactory = this.getAuthRequestContext.MyBillsEntityDataFactory(null, params2.getAuthRequestContext, params2.PlaceComponentResult);
            return MyBillsEntityDataFactory;
        }
        int i2 = 2;
        if (i == 2) {
            ?? r3 = 0;
            return this.getAuthRequestContext.MyBillsEntityDataFactory(CollectionsKt.listOf(new SearchCondition("TRENDING", r3, i2, r3)), params2.getAuthRequestContext, params2.PlaceComponentResult);
        } else if (i == 3) {
            return this.getAuthRequestContext.MyBillsEntityDataFactory(CollectionsKt.listOf(new SearchCondition("NAME", CollectionsKt.listOf(params2.KClassImpl$Data$declaredNonStaticMembers$2))), params2.getAuthRequestContext, params2.PlaceComponentResult);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Inject
    public GetOnlineMerchant(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.getAuthRequestContext = globalSearchRepository;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000b"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant$Params;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant$OnlineMerchantType;", "PlaceComponentResult", "Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant$OnlineMerchantType;", "", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;IILid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant$OnlineMerchantType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final int PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final OnlineMerchantType MyBillsEntityDataFactory;
        final int getAuthRequestContext;

        public Params(String str, int i, int i2, OnlineMerchantType onlineMerchantType) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(onlineMerchantType, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = i2;
            this.MyBillsEntityDataFactory = onlineMerchantType;
        }

        public /* synthetic */ Params(String str, int i, int i2, OnlineMerchantType onlineMerchantType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, i, i2, onlineMerchantType);
        }
    }
}
