package id.dana.riskChallenges.data.passkey;

import android.os.SystemClock;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.riskChallenges.data.passkey.source.PasskeyEntityData;
import id.dana.riskChallenges.data.passkey.source.PasskeyEntityDataFactory;
import id.dana.riskChallenges.data.passkey.source.local.PasskeyPreferenceEntityData;
import id.dana.riskChallenges.data.passkey.source.network.AuthenticationStartResponse;
import id.dana.riskChallenges.data.passkey.source.network.QueryUserCredentialsResponse;
import id.dana.riskChallenges.data.passkey.source.network.RegistrationFinishResponse;
import id.dana.riskChallenges.data.passkey.source.network.RegistrationStartResponse;
import id.dana.riskChallenges.data.passkey.source.network.RemoveCredentialResponse;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCredential;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.util.RaspUtils;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import o.getCallingPid;

@RiskChallengesScope
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\rJ#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00072\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0005\u0010\u0010J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000e0\u000b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0015J/\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000e0\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\b\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0013\u0010\u0005\u001a\u00020\u0018X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0013\u0010\u001c\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001e"}, d2 = {"Lid/dana/riskChallenges/data/passkey/PasskeyEntityRepository;", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "Lcom/alibaba/fastjson/JSONObject;", "p0", "Lio/reactivex/Completable;", "PlaceComponentResult", "(Lcom/alibaba/fastjson/JSONObject;)Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "(Z)Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "(Lcom/alibaba/fastjson/JSONObject;)Lio/reactivex/Observable;", "p1", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityDataFactory;", "Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityDataFactory;", "Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityData;", "Lkotlin/Lazy;", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;", "Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;", "<init>", "(Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityDataFactory;Lid/dana/riskChallenges/data/passkey/source/local/PasskeyPreferenceEntityData$Factory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PasskeyEntityRepository implements PasskeyRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PasskeyPreferenceEntityData.Factory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    private final PasskeyEntityDataFactory MyBillsEntityDataFactory;
    private final Lazy PlaceComponentResult;

    @Inject
    public PasskeyEntityRepository(PasskeyEntityDataFactory passkeyEntityDataFactory, PasskeyPreferenceEntityData.Factory factory) {
        Intrinsics.checkNotNullParameter(passkeyEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(factory, "");
        this.MyBillsEntityDataFactory = passkeyEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = factory;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<PasskeyEntityData>() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$networkEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // kotlin.jvm.functions.Function0
            public final PasskeyEntityData invoke() {
                PasskeyEntityDataFactory passkeyEntityDataFactory2;
                passkeyEntityDataFactory2 = PasskeyEntityRepository.this.MyBillsEntityDataFactory;
                if (Intrinsics.areEqual("network", "network")) {
                    return passkeyEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2;
                }
                ?? r2 = 0;
                throw new NotImplementedError(r2, 1, r2);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<PasskeyPreferenceEntityData>() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$preferenceEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // kotlin.jvm.functions.Function0
            public final PasskeyPreferenceEntityData invoke() {
                PasskeyPreferenceEntityData.Factory factory2;
                factory2 = PasskeyEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (Intrinsics.areEqual("local", "local")) {
                    return factory2.getAuthRequestContext;
                }
                ?? r2 = 0;
                throw new NotImplementedError(r2, 1, r2);
            }
        });
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    public final Observable<List<PasskeyCredential>> PlaceComponentResult(boolean p0) {
        String simpleName = Reflection.getOrCreateKotlinClass(PasskeyEntityRepository.class).getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("needBackendUpdate: ");
        sb.append(p0);
        DanaLog.MyBillsEntityDataFactory(simpleName, sb.toString());
        Observable<List<PasskeyCredential>> just = Observable.just(((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult());
        Intrinsics.checkNotNullExpressionValue(just, "");
        if (p0) {
            Observable<List<PasskeyCredential>> onErrorReturn = ((PasskeyEntityData) this.PlaceComponentResult.getValue()).queryUserCredentials(((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).MyBillsEntityDataFactory()).map(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyEntityRepository.BuiltInFictitiousFunctionClassFactory((QueryUserCredentialsResponse) obj);
                }
            }).filter(new Predicate() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean authRequestContext;
                    authRequestContext = PasskeyEntityRepository.getAuthRequestContext((List) obj);
                    return authRequestContext;
                }
            }).map(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda10
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyEntityRepository.MyBillsEntityDataFactory((List) obj);
                }
            }).doOnNext(new Consumer() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PasskeyEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(PasskeyEntityRepository.this, (List) obj);
                }
            }).onErrorReturn(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda12
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyEntityRepository.BuiltInFictitiousFunctionClassFactory(PasskeyEntityRepository.this, (Throwable) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
            return onErrorReturn;
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return !list.isEmpty();
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    public final Observable<Pair<String, List<VerificationMethodModel>>> getAuthRequestContext(final boolean p0) {
        DanaLog.MyBillsEntityDataFactory(Reflection.getOrCreateKotlinClass(PasskeyEntityRepository.class).getSimpleName(), "removeCredential invoked");
        Observable<Pair<String, List<VerificationMethodModel>>> doOnNext = ((PasskeyEntityData) this.PlaceComponentResult.getValue()).removeCredential(p0 ? null : ((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0()).doOnNext(new Consumer() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PasskeyEntityRepository.PlaceComponentResult(PasskeyEntityRepository.this, (RemoveCredentialResponse) obj);
            }
        }).map(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEntityRepository.PlaceComponentResult((RemoveCredentialResponse) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Pair pair = (Pair) obj;
                PasskeyEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(p0, this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((PasskeyCredential) JSON.toJavaObject((JSONObject) it.next(), PasskeyCredential.class));
        }
        return arrayList;
    }

    public static /* synthetic */ void PlaceComponentResult(PasskeyEntityRepository passkeyEntityRepository, RemoveCredentialResponse removeCredentialResponse) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        ((PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult(removeCredentialResponse.getSecurityId());
        List<VerificationMethodModel> verificationMethods = removeCredentialResponse.getVerificationMethods();
        if (verificationMethods == null || verificationMethods.isEmpty()) {
            ((PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(QueryUserCredentialsResponse queryUserCredentialsResponse) {
        Intrinsics.checkNotNullParameter(queryUserCredentialsResponse, "");
        return queryUserCredentialsResponse.getCredentials();
    }

    public static /* synthetic */ Boolean PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.TRUE;
    }

    public static /* synthetic */ Pair PlaceComponentResult(RemoveCredentialResponse removeCredentialResponse) {
        Intrinsics.checkNotNullParameter(removeCredentialResponse, "");
        return new Pair(removeCredentialResponse.getSecurityId(), removeCredentialResponse.getVerificationMethods());
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(PasskeyEntityRepository passkeyEntityRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        return ((PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PasskeyEntityRepository passkeyEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        PasskeyPreferenceEntityData passkeyPreferenceEntityData = (PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(list, "");
        passkeyPreferenceEntityData.MyBillsEntityDataFactory(list);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PasskeyEntityRepository passkeyEntityRepository, RegistrationStartResponse registrationStartResponse) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        ((PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).PlaceComponentResult(registrationStartResponse.getSecurityId());
    }

    public static /* synthetic */ JSONObject KClassImpl$Data$declaredNonStaticMembers$2(AuthenticationStartResponse authenticationStartResponse) {
        Intrinsics.checkNotNullParameter(authenticationStartResponse, "");
        return authenticationStartResponse.getPublicKeyCredentialRequestOptions();
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(PasskeyEntityRepository passkeyEntityRepository, RegistrationFinishResponse registrationFinishResponse) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        Intrinsics.checkNotNullParameter(registrationFinishResponse, "");
        return passkeyEntityRepository.PlaceComponentResult(true);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, PasskeyEntityRepository passkeyEntityRepository) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        if (z) {
            return;
        }
        ((PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PasskeyEntityRepository passkeyEntityRepository) {
        Intrinsics.checkNotNullParameter(passkeyEntityRepository, "");
        ((PasskeyPreferenceEntityData) passkeyEntityRepository.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ Pair KClassImpl$Data$declaredNonStaticMembers$2(RegistrationStartResponse registrationStartResponse) {
        Intrinsics.checkNotNullParameter(registrationStartResponse, "");
        JSONObject publicKeyCredentialCreationOptions = registrationStartResponse.getPublicKeyCredentialCreationOptions();
        if (publicKeyCredentialCreationOptions == null) {
            publicKeyCredentialCreationOptions = new JSONObject();
        }
        List<VerificationMethodModel> verificationMethods = registrationStartResponse.getVerificationMethods();
        if (verificationMethods == null) {
            verificationMethods = CollectionsKt.emptyList();
        }
        return new Pair(publicKeyCredentialCreationOptions, verificationMethods);
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    @Deprecated(message = "not used, we will use from alipayplus.mobilewallet.product.security.verify")
    public final Completable PlaceComponentResult(JSONObject p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String userId = ((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).getAuthRequestContext().getUserId();
        PasskeyEntityData passkeyEntityData = (PasskeyEntityData) this.PlaceComponentResult.getValue();
        Intrinsics.checkNotNullExpressionValue(userId, "");
        Completable ignoreElements = passkeyEntityData.authenticationFinish(p0, userId).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    public final Observable<JSONObject> getAuthRequestContext() {
        Observable map = ((PasskeyEntityData) this.PlaceComponentResult.getValue()).authenticationStart().map(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((AuthenticationStartResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    public final Observable<Pair<Boolean, Boolean>> PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Pair<Boolean, Boolean>> just = Observable.just(new Pair(Boolean.valueOf(((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0)), Boolean.valueOf(((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).BuiltInFictitiousFunctionClassFactory(p0))));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    public final Observable<Boolean> MyBillsEntityDataFactory(JSONObject p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> map = ((PasskeyEntityData) this.PlaceComponentResult.getValue()).registrationFinish(p0, ((PasskeyPreferenceEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda0()).flatMap(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEntityRepository.getAuthRequestContext(PasskeyEntityRepository.this, (RegistrationFinishResponse) obj);
            }
        }).doOnNext(new Consumer() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                List list = (List) obj;
                PasskeyEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(PasskeyEntityRepository.this);
            }
        }).map(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEntityRepository.PlaceComponentResult((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.riskChallenges.domain.passkey.PasskeyRepository
    public final Observable<Pair<JSONObject, List<VerificationMethodModel>>> MyBillsEntityDataFactory(String p0, String p1) {
        Observable map = ((PasskeyEntityData) this.PlaceComponentResult.getValue()).registrationStart(p0, p1).doOnNext(new Consumer() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda13
            private static int $10 = 0;
            private static int $11 = 1;
            private static char[] BuiltInFictitiousFunctionClassFactory = {42071, 37286, 37281, 37280, 37289, 37359, 42068, 37365, 42070};
            private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            private static int MyBillsEntityDataFactory = 1;
            private static char getAuthRequestContext = 42070;

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
                MyBillsEntityDataFactory = i % 128;
                if (!(i % 2 == 0)) {
                    PasskeyEntityRepository.MyBillsEntityDataFactory(PasskeyEntityRepository.this, (RegistrationStartResponse) obj);
                } else {
                    try {
                        try {
                            PasskeyEntityRepository.MyBillsEntityDataFactory(PasskeyEntityRepository.this, (RegistrationStartResponse) obj);
                            int i2 = 60 / 0;
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
            }

            public static void $$a(long j, long j2) {
                long j3 = j ^ (j2 << 32);
                Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                a(new char[]{2, 0, 5, 4, '\b', 4}, (byte) (56 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 7 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr);
                sb.append((String) objArr[0]);
                sb.append(j3);
                String obj = sb.toString();
                Intrinsics.checkNotNullParameter(obj, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj);
                RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
                Intrinsics.checkNotNullParameter(dexguardException, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(dexguardException);
                RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.EMULATOR);
                UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.EMULATOR);
                int i = MyBillsEntityDataFactory + 101;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            }

            private static void a(char[] cArr, byte b, int i, Object[] objArr) {
                int i2;
                getCallingPid getcallingpid = new getCallingPid();
                try {
                    char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
                    if (cArr2 != null) {
                        int length = cArr2.length;
                        char[] cArr3 = new char[length];
                        for (int i3 = 0; i3 < length; i3++) {
                            cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                        }
                        cArr2 = cArr3;
                    }
                    char c = (char) ((-1549216646985767851L) ^ getAuthRequestContext);
                    char[] cArr4 = new char[i];
                    if ((i % 2 != 0 ? ':' : (char) 14) != ':') {
                        i2 = i;
                    } else {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                        int i4 = $10 + 107;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                    }
                    if (i2 > 1) {
                        int i6 = $11 + 63;
                        try {
                            $10 = i6 % 128;
                            int i7 = i6 % 2;
                            getcallingpid.getAuthRequestContext = 0;
                            while (getcallingpid.getAuthRequestContext < i2) {
                                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                                } else {
                                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                                    } else if ((getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 ? '*' : '\'') != '\'') {
                                        int i10 = $11 + 27;
                                        $10 = i10 % 128;
                                        int i11 = i10 % 2;
                                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                        int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                        int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                                    } else {
                                        int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                        int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                                    }
                                }
                                getcallingpid.getAuthRequestContext += 2;
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    for (int i16 = 0; i16 < i; i16++) {
                        cArr4[i16] = (char) (cArr4[i16] ^ 13722);
                    }
                    objArr[0] = new String(cArr4);
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }).map(new Function() { // from class: id.dana.riskChallenges.data.passkey.PasskeyEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((RegistrationStartResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
