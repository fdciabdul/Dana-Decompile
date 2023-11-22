package id.dana.data.usercredential.repository.source.local;

import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import id.dana.data.usercredential.repository.CredentialEntityData;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/usercredential/repository/source/local/LocalCredentialEntityData;", "Lid/dana/data/usercredential/repository/CredentialEntityData;", "Lid/dana/domain/usercredential/model/PinRegularChangesConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/domain/usercredential/model/PinRegularChangesConfig;", "Lio/reactivex/Observable;", "Lid/dana/data/usercredential/model/QueryCredentialInfoResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "p0", "", "(Lid/dana/domain/usercredential/model/PinRegularChangesConfig;)V", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/usercredential/model/QueryCredentialInfoResult;)V", "Lid/dana/data/usercredential/repository/source/local/CredentialPreference;", "MyBillsEntityDataFactory", "Lid/dana/data/usercredential/repository/source/local/CredentialPreference;", "<init>", "(Lid/dana/data/usercredential/repository/source/local/CredentialPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalCredentialEntityData implements CredentialEntityData {
    private final CredentialPreference MyBillsEntityDataFactory;

    @Inject
    public LocalCredentialEntityData(CredentialPreference credentialPreference) {
        Intrinsics.checkNotNullParameter(credentialPreference, "");
        this.MyBillsEntityDataFactory = credentialPreference;
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final Observable<QueryCredentialInfoResult> getAuthRequestContext() {
        Observable<QueryCredentialInfoResult> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.usercredential.repository.source.local.LocalCredentialEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalCredentialEntityData.BuiltInFictitiousFunctionClassFactory(LocalCredentialEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final void BuiltInFictitiousFunctionClassFactory(QueryCredentialInfoResult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CredentialPreference credentialPreference = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        credentialPreference.KClassImpl$Data$declaredNonStaticMembers$2.saveData("PASSWORD_LAST_MODIFIED", credentialPreference.BuiltInFictitiousFunctionClassFactory.toJson(p0));
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final void getAuthRequestContext(PinRegularChangesConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CredentialPreference credentialPreference = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        credentialPreference.KClassImpl$Data$declaredNonStaticMembers$2.saveData("FEATURE_PIN_REGULAR_CHANGES_CONFIG", credentialPreference.BuiltInFictitiousFunctionClassFactory.toJson(p0));
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final PinRegularChangesConfig KClassImpl$Data$declaredNonStaticMembers$2() {
        CredentialPreference credentialPreference = this.MyBillsEntityDataFactory;
        String string = credentialPreference.KClassImpl$Data$declaredNonStaticMembers$2.getString("FEATURE_PIN_REGULAR_CHANGES_CONFIG");
        if (string != null) {
            return (PinRegularChangesConfig) credentialPreference.BuiltInFictitiousFunctionClassFactory.fromJson(string, PinRegularChangesConfig.class);
        }
        return null;
    }

    public static /* synthetic */ QueryCredentialInfoResult BuiltInFictitiousFunctionClassFactory(LocalCredentialEntityData localCredentialEntityData) {
        Intrinsics.checkNotNullParameter(localCredentialEntityData, "");
        CredentialPreference credentialPreference = localCredentialEntityData.MyBillsEntityDataFactory;
        String string = credentialPreference.KClassImpl$Data$declaredNonStaticMembers$2.getString("PASSWORD_LAST_MODIFIED");
        QueryCredentialInfoResult queryCredentialInfoResult = string != null ? (QueryCredentialInfoResult) credentialPreference.BuiltInFictitiousFunctionClassFactory.fromJson(string, QueryCredentialInfoResult.class) : null;
        return queryCredentialInfoResult == null ? new QueryCredentialInfoResult(0L, false, 3, null) : queryCredentialInfoResult;
    }
}
