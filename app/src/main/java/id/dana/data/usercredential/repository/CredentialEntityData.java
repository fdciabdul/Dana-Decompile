package id.dana.data.usercredential.repository;

import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lid/dana/data/usercredential/repository/CredentialEntityData;", "", "getFeaturePinRegularChangesConfig", "Lid/dana/domain/usercredential/model/PinRegularChangesConfig;", "getPasswordLastModified", "Lio/reactivex/Observable;", "Lid/dana/data/usercredential/model/QueryCredentialInfoResult;", "saveFeaturePinRegularChangesConfig", "", "pinRegularChangesConfig", "savePasswordLastModified", "queryCredentialInfoResult", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CredentialEntityData {
    void BuiltInFictitiousFunctionClassFactory(QueryCredentialInfoResult queryCredentialInfoResult);

    PinRegularChangesConfig KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<QueryCredentialInfoResult> getAuthRequestContext();

    void getAuthRequestContext(PinRegularChangesConfig pinRegularChangesConfig);

    /* renamed from: id.dana.data.usercredential.repository.CredentialEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void MyBillsEntityDataFactory(QueryCredentialInfoResult queryCredentialInfoResult) {
            Intrinsics.checkNotNullParameter(queryCredentialInfoResult, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void PlaceComponentResult(PinRegularChangesConfig pinRegularChangesConfig) {
            Intrinsics.checkNotNullParameter(pinRegularChangesConfig, "");
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static PinRegularChangesConfig PlaceComponentResult() {
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }
    }
}
