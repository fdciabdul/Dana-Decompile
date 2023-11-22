package id.dana.data.usercredential.repository.source.local;

import com.google.gson.Gson;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.usercredential.di.Credential;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\b\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/usercredential/repository/source/local/CredentialPreference;", "", "Lcom/google/gson/Gson;", "MyBillsEntityDataFactory", "Lcom/google/gson/Gson;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/storage/PreferenceFacade;", "PlaceComponentResult", "Lid/dana/data/storage/PreferenceFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CredentialPreference {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Gson BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public CredentialPreference(@Credential PreferenceFacade preferenceFacade, Gson gson) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = preferenceFacade;
        this.BuiltInFictitiousFunctionClassFactory = gson;
    }
}
