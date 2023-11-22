package id.dana.danapoly.data.config.repository.source;

import id.dana.danapoly.data.config.model.response.GetConfigurationResponse;
import id.dana.danapoly.data.config.model.response.PlayBoardResponse;
import id.dana.danapoly.data.config.model.response.PlayerInfoResponse;
import id.dana.danapoly.ui.model.BackgroundColorType;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "", "getBackgroundColor", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "getConfig", "Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "getPlayBoard", "Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;", "eventId", "", "getPlayerInfo", "Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;", "hasShownTutorial", "", "userId", "saveBackgroundColor", "backgroundColorType", "saveShownTutorial", "", "feature-danapoly_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyConfigData {
    Flow<PlayerInfoResponse> BuiltInFictitiousFunctionClassFactory(String str);

    Flow<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(BackgroundColorType backgroundColorType);

    void KClassImpl$Data$declaredNonStaticMembers$2(String str);

    Flow<Boolean> MyBillsEntityDataFactory(String str);

    Flow<GetConfigurationResponse> PlaceComponentResult();

    Flow<BackgroundColorType> getAuthRequestContext();

    Flow<PlayBoardResponse> getAuthRequestContext(String str);

    /* renamed from: id.dana.danapoly.data.config.repository.source.DanapolyConfigData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Flow BuiltInFictitiousFunctionClassFactory(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Flow BuiltInFictitiousFunctionClassFactory() {
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Flow PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Flow KClassImpl$Data$declaredNonStaticMembers$2(BackgroundColorType backgroundColorType) {
            Intrinsics.checkNotNullParameter(backgroundColorType, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Flow PlaceComponentResult() {
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void MyBillsEntityDataFactory(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }

        public static Flow getAuthRequestContext(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            return FlowKt.flowOf(Boolean.FALSE);
        }
    }
}
