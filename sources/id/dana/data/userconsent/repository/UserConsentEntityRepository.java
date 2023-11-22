package id.dana.data.userconsent.repository;

import android.text.TextUtils;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.user.UserEntityRepository;
import id.dana.data.userconsent.repository.UserConsentEntityRepository;
import id.dana.data.userconsent.repository.source.local.UserConsentPreference;
import id.dana.data.userconsent.repository.source.model.ConsultAgreementResult;
import id.dana.data.userconsent.repository.source.model.FetchScopesResult;
import id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData;
import id.dana.domain.featureconfig.model.UgcConfig;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Singleton
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 62\u00020\u0001:\u00056789:B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020*\u0012\u0006\u0010\u0006\u001a\u00020,\u0012\u0006\u0010\u000e\u001a\u00020/\u0012\u0006\u0010\u0010\u001a\u00020'\u0012\u0006\u0010\u0014\u001a\u000201¢\u0006\u0004\b4\u00105J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0019J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0007H\u0002¢\u0006\u0004\b\u001f\u0010 Jc\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b$\u0010%J+\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010&R\u0014\u0010\u001f\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u001b\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010(\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103"}, d2 = {"Lid/dana/data/userconsent/repository/UserConsentEntityRepository;", "Lid/dana/domain/useragreement/UserConsentRepository;", "", "p0", "", "Lid/dana/domain/oauth/model/Agreement;", "p1", "Lio/reactivex/Observable;", "Ljava/util/ArrayList;", "buildAgreementContent", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "", "buildIncompleteUserDataContent", "(Ljava/util/Set;)Lio/reactivex/Observable;", "p2", "", "p3", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$UserInfo;", "checkUserInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "p4", "p5", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "consultAgreement", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "(Ljava/util/List;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Lid/dana/data/userconsent/repository/source/local/UserConsentPreference$LastCheck;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getScopes", "Lid/dana/data/userconsent/repository/UserConsentEntityRepository$UserConsentThreshold;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "p6", "p7", "", "recordAgreement", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/AccountEntityRepository;", "getAuthRequestContext", "Lid/dana/data/account/repository/AccountEntityRepository;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/userconsent/repository/source/network/NetworkUserConsentEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/userconsent/repository/source/network/NetworkUserConsentEntityData;", "Lid/dana/data/userconsent/repository/source/local/UserConsentPreference;", "Lid/dana/data/userconsent/repository/source/local/UserConsentPreference;", "Lid/dana/data/user/UserEntityRepository;", "PlaceComponentResult", "Lid/dana/data/user/UserEntityRepository;", "<init>", "(Lid/dana/data/toggle/SplitFacade;Lid/dana/data/userconsent/repository/source/network/NetworkUserConsentEntityData;Lid/dana/data/userconsent/repository/source/local/UserConsentPreference;Lid/dana/data/account/repository/AccountEntityRepository;Lid/dana/data/user/UserEntityRepository;)V", "Companion", "EnIn", "ScopeOrder", "UserConsentAgreementContent", "UserConsentThreshold"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserConsentEntityRepository implements UserConsentRepository {
    private final SplitFacade BuiltInFictitiousFunctionClassFactory;
    private final NetworkUserConsentEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final UserConsentPreference getAuthRequestContext;
    private final UserEntityRepository PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AccountEntityRepository MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/data/userconsent/repository/UserConsentEntityRepository$EnIn;", "", "", "", "PlaceComponentResult", "[Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class EnIn {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String[] MyBillsEntityDataFactory;
        public String[] PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/data/userconsent/repository/UserConsentEntityRepository$UserConsentAgreementContent;", "", "Lid/dana/data/userconsent/repository/UserConsentEntityRepository$EnIn;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/userconsent/repository/UserConsentEntityRepository$EnIn;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UserConsentAgreementContent {
        public EnIn BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public EnIn getAuthRequestContext;
    }

    @Inject
    public UserConsentEntityRepository(SplitFacade splitFacade, NetworkUserConsentEntityData networkUserConsentEntityData, UserConsentPreference userConsentPreference, AccountEntityRepository accountEntityRepository, UserEntityRepository userEntityRepository) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(networkUserConsentEntityData, "");
        Intrinsics.checkNotNullParameter(userConsentPreference, "");
        Intrinsics.checkNotNullParameter(accountEntityRepository, "");
        Intrinsics.checkNotNullParameter(userEntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = splitFacade;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkUserConsentEntityData;
        this.getAuthRequestContext = userConsentPreference;
        this.MyBillsEntityDataFactory = accountEntityRepository;
        this.PlaceComponentResult = userEntityRepository;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<String> getScopes(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NetworkUserConsentEntityData networkUserConsentEntityData = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = networkUserConsentEntityData.wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserConsentEntityData.KClassImpl$Data$declaredNonStaticMembers$2(p0, (UserConsentFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        Observable<String> map = wrapper.map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.MyBillsEntityDataFactory((FetchScopesResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<ConsultAgreementResponse> consultAgreement(final String p0, final List<String> p1, final String p2, final String p3, final String p4, final boolean p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<ConsultAgreementResponse> flatMap = MyBillsEntityDataFactory().zipWith(BuiltInFictitiousFunctionClassFactory(p0), new BiFunction() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return UserConsentEntityRepository.MyBillsEntityDataFactory(p4, this, p3, p1, p2, p5, p0, (UserConsentEntityRepository.UserConsentThreshold) obj, (UserConsentPreference.LastCheck) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda12
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.userconsent.repository.UserConsentEntityRepository.PlaceComponentResult(io.reactivex.Observable):io.reactivex.ObservableSource
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException
                */
            @Override // io.reactivex.functions.Function
            public final java.lang.Object apply(java.lang.Object r1) {
                /*
                    r0 = this;
                    io.reactivex.Observable r1 = (io.reactivex.Observable) r1
                    io.reactivex.ObservableSource r1 = id.dana.data.userconsent.repository.UserConsentEntityRepository.PlaceComponentResult(r1)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda12.apply(java.lang.Object):java.lang.Object");
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<ConsultAgreementResponse> consultAgreement(final List<String> p0, final Boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        NetworkUserConsentEntityData networkUserConsentEntityData = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = networkUserConsentEntityData.wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserConsentEntityData.BuiltInFictitiousFunctionClassFactory(p0, p1, (UserConsentFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        Observable<ConsultAgreementResponse> map = wrapper.map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.PlaceComponentResult((ConsultAgreementResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<Unit> recordAgreement(final String p0, final List<String> p1, final boolean p2, final String p3, final String p4, final String p5, final String p6, final String p7) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Observable map = BuiltInFictitiousFunctionClassFactory(p0).map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.MyBillsEntityDataFactory(p1, p4, this, p0, p2, p3, p5, p6, p7, (UserConsentPreference.LastCheck) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return baseRpcResult.success || Intrinsics.areEqual(baseRpcResult.errorCode, "AE15112158317300");
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<Boolean> recordAgreement(List<String> p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<String> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (final String str : list) {
            NetworkUserConsentEntityData networkUserConsentEntityData = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(str, "");
            Observable<S> wrapper = networkUserConsentEntityData.wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData$$ExternalSyntheticLambda3
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    return NetworkUserConsentEntityData.PlaceComponentResult(str, p1, (UserConsentFacade) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(wrapper, "");
            arrayList.add(wrapper.map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda18
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((BaseRpcResult) obj);
                }
            }));
        }
        Observable<Boolean> zip = Observable.zip(arrayList, new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.PlaceComponentResult((Object[]) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<GetEmptyUserInfo.UserInfo> checkUserInfo(final String p0, final String p1, final String p2, final boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<GetEmptyUserInfo.UserInfo> flatMap = MyBillsEntityDataFactory().zipWith(BuiltInFictitiousFunctionClassFactory(p0), new BiFunction() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return UserConsentEntityRepository.getAuthRequestContext(p1, this, p2, p3, p0, (UserConsentEntityRepository.UserConsentThreshold) obj, (UserConsentPreference.LastCheck) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda9
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.userconsent.repository.UserConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(io.reactivex.Observable):io.reactivex.ObservableSource
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException
                */
            @Override // io.reactivex.functions.Function
            public final java.lang.Object apply(java.lang.Object r1) {
                /*
                    r0 = this;
                    io.reactivex.Observable r1 = (io.reactivex.Observable) r1
                    io.reactivex.ObservableSource r1 = id.dana.data.userconsent.repository.UserConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(r1)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda9.apply(java.lang.Object):java.lang.Object");
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    private final Observable<UserConsentThreshold> MyBillsEntityDataFactory() {
        int i = 0;
        Observable<UserConsentThreshold> onErrorReturnItem = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserConsentEntityRepository.UserConsentThreshold errorConfigVersion;
                errorConfigVersion = UserConsentEntityRepository.getErrorConfigVersion((BaseTrafficType) obj);
                return errorConfigVersion;
            }
        }).onErrorReturnItem(new UserConsentThreshold(i, i, 3, null));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    private final Observable<UserConsentPreference.LastCheck> BuiltInFictitiousFunctionClassFactory(final String p0) {
        Observable<UserConsentPreference.LastCheck> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UserConsentEntityRepository.MyBillsEntityDataFactory(UserConsentEntityRepository.this, p0);
            }
        }).onErrorReturnItem(new UserConsentPreference.LastCheck(0L, false, 0L, 0, null, 31, null));
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<List<String>> buildIncompleteUserDataContent(final Set<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<List<String>> map = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = UserConsentEntityRepository.MyBillsEntityDataFactory((BaseTrafficType) obj);
                return MyBillsEntityDataFactory;
            }
        }).map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.getAuthRequestContext(p0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.useragreement.UserConsentRepository
    public final Observable<ArrayList<String>> buildAgreementContent(final String p0, final List<? extends Agreement> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<ArrayList<String>> map = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                UserConsentEntityRepository.UserConsentAgreementContent KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = UserConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((BaseTrafficType) obj);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }).map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.PlaceComponentResult(UserConsentEntityRepository.this, p1, p0, (UserConsentEntityRepository.UserConsentAgreementContent) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007"}, d2 = {"Lid/dana/data/userconsent/repository/UserConsentEntityRepository$ScopeOrder;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class ScopeOrder {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String PlaceComponentResult;

        public ScopeOrder(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/data/userconsent/repository/UserConsentEntityRepository$UserConsentThreshold;", "", "", "getAuthRequestContext", "I", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class UserConsentThreshold {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public int MyBillsEntityDataFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public UserConsentThreshold() {
            /*
                r3 = this;
                r0 = 0
                r1 = 3
                r2 = 0
                r3.<init>(r0, r0, r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository.UserConsentThreshold.<init>():void");
        }

        private UserConsentThreshold(int i, int i2) {
            this.MyBillsEntityDataFactory = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
        }

        public /* synthetic */ UserConsentThreshold(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? UgcConfig.DEFAULT_UGC_INTERVAL : i, (i3 & 2) != 0 ? UgcConfig.DEFAULT_UGC_INTERVAL : i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserConsentThreshold getErrorConfigVersion(BaseTrafficType baseTrafficType) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext("user_consent_threshold", false);
        Object obj2 = null;
        if (UserConsentThreshold.class.isAssignableFrom(JSONArray.class)) {
            obj2 = (UserConsentThreshold) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else {
            if (authRequestContext != null) {
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) UserConsentThreshold.class);
                } catch (Exception unused) {
                    obj = null;
                }
                if (obj != null) {
                    obj2 = obj;
                }
            }
            Intrinsics.checkNotNull(null);
        }
        return (UserConsentThreshold) obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map MyBillsEntityDataFactory(BaseTrafficType baseTrafficType) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext("user_data_scopes", false);
        Object obj2 = null;
        if (Map.class.isAssignableFrom(JSONArray.class)) {
            obj2 = (Map) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else {
            if (authRequestContext != null) {
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) Map.class);
                } catch (Exception unused) {
                    obj = null;
                }
                if (obj != null) {
                    obj2 = obj;
                }
            }
            Intrinsics.checkNotNull(null);
        }
        return (Map) obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserConsentAgreementContent KClassImpl$Data$declaredNonStaticMembers$2(BaseTrafficType baseTrafficType) {
        Object obj;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext("user_consent_agreement_content", false);
        Object obj2 = null;
        if (UserConsentAgreementContent.class.isAssignableFrom(JSONArray.class)) {
            obj2 = (UserConsentAgreementContent) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else {
            if (authRequestContext != null) {
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) UserConsentAgreementContent.class);
                } catch (Exception unused) {
                    obj = null;
                }
                if (obj != null) {
                    obj2 = obj;
                }
            }
            Intrinsics.checkNotNull(null);
        }
        return (UserConsentAgreementContent) obj2;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final UserConsentEntityRepository userConsentEntityRepository, final List list, final String str, final boolean z, final UserConsentPreference.LastCheck lastCheck, final String str2, final String str3, final String str4) {
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(lastCheck, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        NetworkUserConsentEntityData networkUserConsentEntityData = userConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Observable<S> wrapper = networkUserConsentEntityData.wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserConsentEntityData.BuiltInFictitiousFunctionClassFactory(list, str, z, str4, (UserConsentFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper.map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserConsentEntityRepository.MyBillsEntityDataFactory(UserConsentPreference.LastCheck.this, str2, userConsentEntityRepository, str3, (ConsultAgreementResult) obj);
            }
        });
    }

    public static /* synthetic */ ArrayList PlaceComponentResult(UserConsentEntityRepository userConsentEntityRepository, List list, String str, UserConsentAgreementContent userConsentAgreementContent) {
        String obj;
        int i;
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(userConsentAgreementContent, "");
        EnIn enIn = userConsentAgreementContent.BuiltInFictitiousFunctionClassFactory;
        String[] strArr = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "in") ? enIn.MyBillsEntityDataFactory : enIn.PlaceComponentResult;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(new ScopeOrder(1, str2));
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Agreement agreement = (Agreement) it.next();
                if (Intrinsics.areEqual(agreement.getType(), "user_data")) {
                    String name = agreement.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "");
                    arrayList2.add(name);
                } else if (!Intrinsics.areEqual(agreement.getTitle(), "MINI_PROGRAM")) {
                    String title = agreement.getTitle();
                    if (Intrinsics.areEqual(title, "MINI_PROGRAM_NO_RES")) {
                        i = 2;
                    } else {
                        i = Intrinsics.areEqual(title, "MINI_PROGRAM_RES") ? 3 : 5;
                    }
                    String description = agreement.getDescription();
                    Intrinsics.checkNotNullExpressionValue(description, "");
                    mutableList.add(new ScopeOrder(i, description));
                }
            }
        }
        if ((!arrayList2.isEmpty()) != false) {
            String str3 = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "in") ? "dan" : "and";
            List distinct = CollectionsKt.distinct(arrayList2);
            String joinToString$default = CollectionsKt.joinToString$default(distinct.subList(0, distinct.size() - 1), ", ", null, null, 0, null, null, 62, null);
            EnIn enIn2 = userConsentAgreementContent.getAuthRequestContext;
            String[] strArr2 = Intrinsics.areEqual(Locale.getDefault().getLanguage(), "in") ? enIn2.MyBillsEntityDataFactory : enIn2.PlaceComponentResult;
            ArrayList arrayList3 = new ArrayList(strArr2.length);
            for (String str4 : strArr2) {
                if (distinct.size() == 1) {
                    obj = (String) CollectionsKt.first(distinct);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(joinToString$default);
                    sb.append(InputCardNumberView.DIVIDER);
                    sb.append(str3);
                    sb.append(InputCardNumberView.DIVIDER);
                    sb.append((String) CollectionsKt.last(distinct));
                    obj = sb.toString();
                }
                arrayList3.add(StringsKt.replace$default(str4, "{userData}", obj, false, 4, (Object) null));
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                mutableList.add(new ScopeOrder(4, (String) it2.next()));
            }
        }
        List sortedWith = CollectionsKt.sortedWith(mutableList, new Comparator() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$buildAgreementContent$lambda-31$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((UserConsentEntityRepository.ScopeOrder) t).BuiltInFictitiousFunctionClassFactory), Integer.valueOf(((UserConsentEntityRepository.ScopeOrder) t2).BuiltInFictitiousFunctionClassFactory));
            }
        });
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        Iterator it3 = sortedWith.iterator();
        while (it3.hasNext()) {
            arrayList4.add(StringsKt.replace$default(((ScopeOrder) it3.next()).PlaceComponentResult, "{appName}", str, false, 4, (Object) null));
        }
        return new ArrayList(arrayList4);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(UserConsentEntityRepository userConsentEntityRepository, String str, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        UserEntityRepository userEntityRepository = userConsentEntityRepository.PlaceComponentResult;
        if (str2 == null || !z) {
            str2 = null;
        }
        return userEntityRepository.checkUserInfo(str, str2, str3);
    }

    public static /* synthetic */ List getAuthRequestContext(Set set, Map map) {
        String str;
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(map, "");
        String language = Locale.getDefault().getLanguage();
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map map2 = (Map) map.get((String) it.next());
            if (map2 != null) {
                str = (String) map2.get(Intrinsics.areEqual(language, "in") ? "id" : "en");
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ GetEmptyUserInfo.UserInfo KClassImpl$Data$declaredNonStaticMembers$2(UserConsentPreference.LastCheck lastCheck, UserConsentEntityRepository userConsentEntityRepository, String str, Map map) {
        GetEmptyUserInfo.Status status;
        Intrinsics.checkNotNullParameter(lastCheck, "");
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        if (map.containsValue("") || map.containsValue("[]")) {
            status = GetEmptyUserInfo.Status.INCOMPLETE;
        } else {
            status = Intrinsics.areEqual(map.get("USER_CONTACTINFO_EMAIL_STATUS"), "false") ? GetEmptyUserInfo.Status.EMAIL_UNVERIFIED : GetEmptyUserInfo.Status.COMPLETE;
        }
        lastCheck.PlaceComponentResult = status.ordinal();
        lastCheck.MyBillsEntityDataFactory = System.currentTimeMillis();
        userConsentEntityRepository.getAuthRequestContext.MyBillsEntityDataFactory(str, lastCheck);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if ((str2.length() == 0) || Intrinsics.areEqual(str2, "[]")) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new GetEmptyUserInfo.UserInfo(status, linkedHashMap.keySet());
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(FetchScopesResult fetchScopesResult) {
        Intrinsics.checkNotNullParameter(fetchScopesResult, "");
        List split$default = StringsKt.split$default((CharSequence) fetchScopesResult.getScopes(), new char[]{','}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            String str = (String) obj;
            if ((StringsKt.isBlank(str) ^ true) && !TextUtils.isDigitsOnly(str)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(arrayList), ",", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ ConsultAgreementResponse MyBillsEntityDataFactory(UserConsentPreference.LastCheck lastCheck, String str, UserConsentEntityRepository userConsentEntityRepository, String str2, ConsultAgreementResult consultAgreementResult) {
        Intrinsics.checkNotNullParameter(lastCheck, "");
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(consultAgreementResult, "");
        lastCheck.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
        lastCheck.KClassImpl$Data$declaredNonStaticMembers$2 = !consultAgreementResult.getNeedUserAgreement();
        if (lastCheck.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            lastCheck.getAuthRequestContext = str;
        }
        userConsentEntityRepository.getAuthRequestContext.MyBillsEntityDataFactory(str2, lastCheck);
        return new ConsultAgreementResponse(consultAgreementResult.getNeedUserAgreement(), consultAgreementResult.getAgreementInfos());
    }

    public static /* synthetic */ UserConsentPreference.LastCheck MyBillsEntityDataFactory(UserConsentEntityRepository userConsentEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        UserConsentPreference.LastCheck lastCheck = userConsentEntityRepository.getAuthRequestContext.getAuthRequestContext().get(str);
        Intrinsics.checkNotNull(lastCheck);
        return lastCheck;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        for (Object obj : objArr) {
            if (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    public static /* synthetic */ io.reactivex.ObservableSource BuiltInFictitiousFunctionClassFactory(io.reactivex.Observable r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.reactivex.ObservableSource r1 = (io.reactivex.ObservableSource) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository.BuiltInFictitiousFunctionClassFactory(io.reactivex.Observable):io.reactivex.ObservableSource");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (r22.KClassImpl$Data$declaredNonStaticMembers$2(r16) == false) goto L19;
     */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ io.reactivex.Observable MyBillsEntityDataFactory(java.lang.String r14, final id.dana.data.userconsent.repository.UserConsentEntityRepository r15, final java.lang.String r16, final java.util.List r17, final java.lang.String r18, final boolean r19, final java.lang.String r20, id.dana.data.userconsent.repository.UserConsentEntityRepository.UserConsentThreshold r21, final id.dana.data.userconsent.repository.source.local.UserConsentPreference.LastCheck r22) {
        /*
            r0 = r14
            r1 = r15
            r6 = r16
            r2 = r21
            r5 = r22
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r3)
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = r5.BuiltInFictitiousFunctionClassFactory
            int r2 = r2.MyBillsEntityDataFactory
            int r2 = r2 * 1000
            long r12 = (long) r2
            long r10 = r10 + r12
            r2 = 0
            r12 = 1
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 <= 0) goto L31
            r8 = 1
            goto L32
        L31:
            r8 = 0
        L32:
            boolean r9 = r22.getKClassImpl$Data$declaredNonStaticMembers$2()
            if (r9 == 0) goto L50
            if (r8 != 0) goto L50
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L47
            int r8 = r8.length()
            if (r8 == 0) goto L47
            r8 = 0
            goto L48
        L47:
            r8 = 1
        L48:
            if (r8 != 0) goto L50
            boolean r8 = r5.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            if (r8 == 0) goto L51
        L50:
            r2 = 1
        L51:
            if (r2 == 0) goto L7a
            if (r0 == 0) goto L5a
            io.reactivex.Observable r0 = r15.getScopes(r14)
            goto L61
        L5a:
            io.reactivex.Observable r0 = io.reactivex.Observable.just(r16)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L61:
            r8 = r0
            id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda7 r9 = new id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda7
            r0 = r9
            r1 = r15
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r16
            r7 = r20
            r0.<init>()
            io.reactivex.Observable r0 = r8.flatMap(r9)
            goto L89
        L7a:
            id.dana.domain.useragreement.model.ConsultAgreementResponse r0 = new id.dana.domain.useragreement.model.ConsultAgreementResponse
            boolean r1 = r22.getKClassImpl$Data$declaredNonStaticMembers$2()
            r2 = 2
            r3 = 0
            r0.<init>(r1, r3, r2, r3)
            io.reactivex.Observable r0 = io.reactivex.Observable.just(r0)
        L89:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository.MyBillsEntityDataFactory(java.lang.String, id.dana.data.userconsent.repository.UserConsentEntityRepository, java.lang.String, java.util.List, java.lang.String, boolean, java.lang.String, id.dana.data.userconsent.repository.UserConsentEntityRepository$UserConsentThreshold, id.dana.data.userconsent.repository.source.local.UserConsentPreference$LastCheck):io.reactivex.Observable");
    }

    public static /* synthetic */ Unit MyBillsEntityDataFactory(List list, final String str, UserConsentEntityRepository userConsentEntityRepository, String str2, final boolean z, final String str3, final String str4, final String str5, final String str6, UserConsentPreference.LastCheck lastCheck) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(lastCheck, "");
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Iterator it = list2.iterator(); it.hasNext(); it = it) {
            final String str7 = (String) it.next();
            NetworkUserConsentEntityData networkUserConsentEntityData = userConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullParameter(str7, "");
            Intrinsics.checkNotNullParameter(str, "");
            ObservableSource wrapper = networkUserConsentEntityData.wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.userconsent.repository.source.network.NetworkUserConsentEntityData$$ExternalSyntheticLambda2
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    return NetworkUserConsentEntityData.getAuthRequestContext(str7, z, str3, str, str4, str5, str6, (UserConsentFacade) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(wrapper, "");
            arrayList.add(wrapper);
        }
        Boolean r_ = Observable.fromIterable(arrayList).flatMap(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda5
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.data.userconsent.repository.UserConsentEntityRepository.BuiltInFictitiousFunctionClassFactory(io.reactivex.Observable):io.reactivex.ObservableSource
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
                Caused by: java.lang.NullPointerException
                */
            @Override // io.reactivex.functions.Function
            public final java.lang.Object apply(java.lang.Object r1) {
                /*
                    r0 = this;
                    io.reactivex.Observable r1 = (io.reactivex.Observable) r1
                    io.reactivex.ObservableSource r1 = id.dana.data.userconsent.repository.UserConsentEntityRepository.BuiltInFictitiousFunctionClassFactory(r1)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda5.apply(java.lang.Object):java.lang.Object");
            }
        }).all(new Predicate() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean authRequestContext;
                authRequestContext = UserConsentEntityRepository.getAuthRequestContext((BaseRpcResult) obj);
                return authRequestContext;
            }
        }).r_();
        Intrinsics.checkNotNullExpressionValue(r_, "");
        lastCheck.KClassImpl$Data$declaredNonStaticMembers$2 = r_.booleanValue();
        lastCheck.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
        if (r_.booleanValue()) {
            lastCheck.getAuthRequestContext = str;
        }
        userConsentEntityRepository.getAuthRequestContext.MyBillsEntityDataFactory(str2, lastCheck);
        if (!r_.booleanValue()) {
            throw new Exception("Cannot record agreement keys");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ConsultAgreementResponse PlaceComponentResult(ConsultAgreementResult consultAgreementResult) {
        Intrinsics.checkNotNullParameter(consultAgreementResult, "");
        return new ConsultAgreementResponse(consultAgreementResult.getNeedUserAgreement(), consultAgreementResult.getAgreementInfos());
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    public static /* synthetic */ io.reactivex.ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(io.reactivex.Observable r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.reactivex.ObservableSource r1 = (io.reactivex.ObservableSource) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(io.reactivex.Observable):io.reactivex.ObservableSource");
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        */
    public static /* synthetic */ io.reactivex.ObservableSource PlaceComponentResult(io.reactivex.Observable r1) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.reactivex.ObservableSource r1 = (io.reactivex.ObservableSource) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconsent.repository.UserConsentEntityRepository.PlaceComponentResult(io.reactivex.Observable):io.reactivex.ObservableSource");
    }

    public static /* synthetic */ Observable getAuthRequestContext(final String str, final UserConsentEntityRepository userConsentEntityRepository, final String str2, final boolean z, final String str3, UserConsentThreshold userConsentThreshold, final UserConsentPreference.LastCheck lastCheck) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(userConsentEntityRepository, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(userConsentThreshold, "");
        Intrinsics.checkNotNullParameter(lastCheck, "");
        boolean z2 = false;
        boolean z3 = lastCheck.PlaceComponentResult == GetEmptyUserInfo.Status.COMPLETE.ordinal();
        if (z3 && System.currentTimeMillis() > lastCheck.MyBillsEntityDataFactory + (userConsentThreshold.BuiltInFictitiousFunctionClassFactory * 1000)) {
            z2 = true;
        }
        if (!z3 || z2 || lastCheck.KClassImpl$Data$declaredNonStaticMembers$2(str)) {
            return userConsentEntityRepository.MyBillsEntityDataFactory.getUserId().flatMap(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda20
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserConsentEntityRepository.MyBillsEntityDataFactory(UserConsentEntityRepository.this, str, str2, z, (String) obj);
                }
            }).map(new Function() { // from class: id.dana.data.userconsent.repository.UserConsentEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return UserConsentEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(UserConsentPreference.LastCheck.this, userConsentEntityRepository, str3, (Map) obj);
                }
            });
        }
        return Observable.just(new GetEmptyUserInfo.UserInfo(GetEmptyUserInfo.Status.values()[lastCheck.PlaceComponentResult], SetsKt.emptySet()));
    }
}
