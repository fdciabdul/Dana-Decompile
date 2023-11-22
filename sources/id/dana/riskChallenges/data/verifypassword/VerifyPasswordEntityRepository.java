package id.dana.riskChallenges.data.verifypassword;

import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.riskChallenges.data.verifypassword.mapper.VerifyPasswordMapperKt;
import id.dana.riskChallenges.data.verifypassword.source.VerifyPasswordEntityData;
import id.dana.riskChallenges.data.verifypassword.source.VerifyPasswordEntityDataFactory;
import id.dana.riskChallenges.data.verifypassword.source.network.result.VerifyPasswordResult;
import id.dana.riskChallenges.domain.verifypassword.VerifyPasswordRepository;
import id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u0006*\u00020\u000f0\u000fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\r\u001a\u00020\u0013X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/riskChallenges/data/verifypassword/VerifyPasswordEntityRepository;", "Lid/dana/riskChallenges/domain/verifypassword/VerifyPasswordRepository;", "", "p0", "p1", "p2", "", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "p4", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/security/source/SecurityEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityData;", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityDataFactory;", "PlaceComponentResult", "Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityDataFactory;", "<init>", "(Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityDataFactory;Lid/dana/data/security/source/SecurityEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPasswordEntityRepository implements VerifyPasswordRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SecurityEntityDataFactory BuiltInFictitiousFunctionClassFactory;
    private final VerifyPasswordEntityDataFactory PlaceComponentResult;

    @Inject
    public VerifyPasswordEntityRepository(VerifyPasswordEntityDataFactory verifyPasswordEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory) {
        Intrinsics.checkNotNullParameter(verifyPasswordEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityEntityDataFactory, "");
        this.PlaceComponentResult = verifyPasswordEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = securityEntityDataFactory;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<SecurityEntityData>() { // from class: id.dana.riskChallenges.data.verifypassword.VerifyPasswordEntityRepository$networkSecurity$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SecurityEntityData invoke() {
                SecurityEntityDataFactory securityEntityDataFactory2;
                securityEntityDataFactory2 = VerifyPasswordEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return securityEntityDataFactory2.createData2("network");
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<VerifyPasswordEntityData>() { // from class: id.dana.riskChallenges.data.verifypassword.VerifyPasswordEntityRepository$networkVerifyPassword$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyPasswordEntityData invoke() {
                VerifyPasswordEntityDataFactory verifyPasswordEntityDataFactory2;
                verifyPasswordEntityDataFactory2 = VerifyPasswordEntityRepository.this.PlaceComponentResult;
                if (Intrinsics.areEqual("network", "network")) {
                    return verifyPasswordEntityDataFactory2.BuiltInFictitiousFunctionClassFactory;
                }
                ?? r2 = 0;
                throw new NotImplementedError(r2, 1, r2);
            }
        });
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(VerifyPasswordEntityRepository verifyPasswordEntityRepository, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(verifyPasswordEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        return ((VerifyPasswordEntityData) verifyPasswordEntityRepository.getAuthRequestContext.getValue()).PlaceComponentResult(str, str2, str6, str3, str4, str5);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(VerifyPasswordEntityRepository verifyPasswordEntityRepository, String str, String str2, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(verifyPasswordEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        return ((VerifyPasswordEntityData) verifyPasswordEntityRepository.getAuthRequestContext.getValue()).getAuthRequestContext(str4, str, str2, str3, z);
    }

    public static /* synthetic */ VerifyPassword PlaceComponentResult(VerifyPasswordResult verifyPasswordResult) {
        Intrinsics.checkNotNullParameter(verifyPasswordResult, "");
        return VerifyPasswordMapperKt.getAuthRequestContext(verifyPasswordResult);
    }

    public static /* synthetic */ VerifyPassword MyBillsEntityDataFactory(VerifyPasswordResult verifyPasswordResult) {
        Intrinsics.checkNotNullParameter(verifyPasswordResult, "");
        return VerifyPasswordMapperKt.getAuthRequestContext(verifyPasswordResult);
    }

    @Override // id.dana.riskChallenges.domain.verifypassword.VerifyPasswordRepository
    public final Observable<VerifyPassword> BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final String p2, final boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<VerifyPassword> map = ((SecurityEntityData) this.MyBillsEntityDataFactory.getValue()).loginKey().flatMap(new Function() { // from class: id.dana.riskChallenges.data.verifypassword.VerifyPasswordEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VerifyPasswordEntityRepository.getAuthRequestContext(VerifyPasswordEntityRepository.this, p0, p1, p2, p3, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.riskChallenges.data.verifypassword.VerifyPasswordEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VerifyPasswordEntityRepository.MyBillsEntityDataFactory((VerifyPasswordResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.riskChallenges.domain.verifypassword.VerifyPasswordRepository
    public final Observable<VerifyPassword> getAuthRequestContext(final String p0, final String p1, final String p2, final String p3, final String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Observable<VerifyPassword> map = ((SecurityEntityData) this.MyBillsEntityDataFactory.getValue()).loginKey().flatMap(new Function() { // from class: id.dana.riskChallenges.data.verifypassword.VerifyPasswordEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VerifyPasswordEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(VerifyPasswordEntityRepository.this, p0, p1, p2, p3, p4, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.riskChallenges.data.verifypassword.VerifyPasswordEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VerifyPasswordEntityRepository.PlaceComponentResult((VerifyPasswordResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
