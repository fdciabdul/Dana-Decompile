package id.dana.data.twilio;

import com.twilio.verify.TwilioVerify;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeList;
import com.twilio.verify.models.ChallengeListOrder;
import com.twilio.verify.models.ChallengeListPayload;
import com.twilio.verify.models.ChallengeStatus;
import com.twilio.verify.models.Detail;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.PushFactorPayload;
import com.twilio.verify.models.UpdatePushChallengePayload;
import com.twilio.verify.models.UpdatePushFactorPayload;
import com.twilio.verify.models.VerifyPushFactorPayload;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\b\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010!\u0012\u0006\u0010\u000b\u001a\u00020\u001d¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\nJ5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\nJ1\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00022\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00022\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\nJ#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001b0\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\nR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\""}, d2 = {"Lid/dana/data/twilio/TwilioSdkEntityRepository;", "Lid/dana/domain/twilio/TwilioSdkRepository;", "Lio/reactivex/Single;", "", "checkEnrollmentStatus", "()Lio/reactivex/Single;", "", "", "checkPendingChallenge", "p0", "(Ljava/lang/String;)Lio/reactivex/Single;", "p1", "p2", "p3", "createFactor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "deleteLocalFactor", "getChallenge", "getChallengeDetails", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "getChallengeHiddenDetails", "Lio/reactivex/Observable;", "saveTwilioChallengeAttempt", "(Ljava/lang/String;)Lio/reactivex/Observable;", "updateChallenge", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "updatePushToken", "", "verifyFactor", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/TwilioVerify;", "Lcom/twilio/verify/TwilioVerify;", "PlaceComponentResult", "<init>", "(Lcom/twilio/verify/TwilioVerify;Lid/dana/data/account/repository/source/AccountEntityDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioSdkEntityRepository implements TwilioSdkRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final TwilioVerify PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AccountEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    @Inject
    public TwilioSdkEntityRepository(TwilioVerify twilioVerify, AccountEntityDataFactory accountEntityDataFactory) {
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        this.PlaceComponentResult = twilioVerify;
        this.BuiltInFictitiousFunctionClassFactory = accountEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Boolean> checkEnrollmentStatus() {
        Single<Boolean> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.getAuthRequestContext(TwilioSdkEntityRepository.this, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<String> createFactor(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Single<String> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.PlaceComponentResult(TwilioSdkEntityRepository.this, p0, p1, p2, p3, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Map<String, String>> checkPendingChallenge(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final ChallengeListPayload challengeListPayload = new ChallengeListPayload(p0, 1, ChallengeStatus.Pending, ChallengeListOrder.Desc, null, 16, null);
        Single<Map<String, String>> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.MyBillsEntityDataFactory(TwilioSdkEntityRepository.this, challengeListPayload, p0, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<List<String>> verifyFactor(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Single<List<String>> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.MyBillsEntityDataFactory(TwilioSdkEntityRepository.this, p0, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Boolean> updateChallenge(String p0, String p1, String p2) {
        ChallengeStatus challengeStatus;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (Intrinsics.areEqual(p2, "approved")) {
            challengeStatus = ChallengeStatus.Approved;
        } else {
            challengeStatus = ChallengeStatus.Denied;
        }
        final UpdatePushChallengePayload updatePushChallengePayload = new UpdatePushChallengePayload(p0, p1, challengeStatus);
        Single<Boolean> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository.this, updatePushChallengePayload, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Map<String, String>> getChallengeHiddenDetails(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Single<Map<String, String>> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.MyBillsEntityDataFactory(TwilioSdkEntityRepository.this, p0, p1, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Map<String, String>> getChallengeDetails(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Single<Map<String, String>> MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository.this, p0, p1, linkedHashMap, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ SingleSource getAuthRequestContext(TwilioSdkEntityRepository twilioSdkEntityRepository, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.PlaceComponentResult(TwilioSdkEntityRepository.this, str2, str, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return accountEntity.getPhoneNumber();
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.FALSE;
    }

    public static /* synthetic */ SingleSource BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository twilioSdkEntityRepository, String str) {
        Single MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() == 0) {
            MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        } else {
            MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda10
                @Override // io.reactivex.SingleOnSubscribe
                public final void subscribe(SingleEmitter singleEmitter) {
                    TwilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository.this, singleEmitter);
                }
            });
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        }
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ SingleSource BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository twilioSdkEntityRepository, final String str, final String str2) {
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                TwilioSdkEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository.this, str, str2, singleEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static /* synthetic */ void PlaceComponentResult(TwilioSdkEntityRepository twilioSdkEntityRepository, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.getAuthRequestContext(new Function1<List<? extends Factor>, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getFactorSid$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Factor> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends Factor> list) {
                    Intrinsics.checkNotNullParameter(list, "");
                    if ((!list.isEmpty()) != false) {
                        singleEmitter.onSuccess(list.get(0).getLookAheadTest());
                    } else {
                        singleEmitter.onSuccess("");
                    }
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getFactorSid$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess("");
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess("");
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TwilioSdkEntityRepository twilioSdkEntityRepository, String str, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.KClassImpl$Data$declaredNonStaticMembers$2(new VerifyPushFactorPayload(str), new Function1<Factor, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$verifyFactor$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
                    invoke2(factor);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Factor factor) {
                    Intrinsics.checkNotNullParameter(factor, "");
                    if (factor.getLookAheadTest().length() > 0) {
                        singleEmitter.onSuccess(CollectionsKt.listOf((Object[]) new String[]{factor.getLookAheadTest(), factor.getBuiltInFictitiousFunctionClassFactory()}));
                    } else {
                        singleEmitter.onSuccess(CollectionsKt.emptyList());
                    }
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$verifyFactor$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess(CollectionsKt.emptyList());
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(CollectionsKt.emptyList());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(TwilioSdkEntityRepository twilioSdkEntityRepository, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.getAuthRequestContext(new Function1<List<? extends Factor>, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$checkEnrollmentStatus$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Factor> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends Factor> list) {
                    Intrinsics.checkNotNullParameter(list, "");
                    if ((!list.isEmpty()) != false) {
                        singleEmitter.onSuccess(Boolean.TRUE);
                    } else {
                        singleEmitter.onSuccess(Boolean.FALSE);
                    }
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$checkEnrollmentStatus$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess(Boolean.FALSE);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(Boolean.FALSE);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(TwilioSdkEntityRepository twilioSdkEntityRepository, String str, String str2, String str3, String str4, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            String str5 = (String) twilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory.createData2("local").getAccount().map(new Function() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return TwilioSdkEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((AccountEntity) obj);
                }
            }).blockingFirst();
            Intrinsics.checkNotNullExpressionValue(str5, "");
            twilioVerify.BuiltInFictitiousFunctionClassFactory(new PushFactorPayload(str5, str, str2, str3, str4), new Function1<Factor, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$createFactor$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
                    invoke2(factor);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Factor factor) {
                    Intrinsics.checkNotNullParameter(factor, "");
                    if (factor.getLookAheadTest().length() > 0) {
                        singleEmitter.onSuccess(factor.getLookAheadTest());
                    } else {
                        singleEmitter.onSuccess("");
                    }
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$createFactor$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess("");
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess("");
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository twilioSdkEntityRepository, UpdatePushChallengePayload updatePushChallengePayload, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(updatePushChallengePayload, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.MyBillsEntityDataFactory(updatePushChallengePayload, new Function0<Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$updateChallenge$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    singleEmitter.onSuccess(Boolean.TRUE);
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$updateChallenge$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess(Boolean.FALSE);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(Boolean.FALSE);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository twilioSdkEntityRepository, String str, String str2, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, new Function1<Challenge, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getChallengeStatus$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge) {
                    invoke2(challenge);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Challenge challenge) {
                    Intrinsics.checkNotNullParameter(challenge, "");
                    singleEmitter.onSuccess(challenge.getScheduleImpl().getValue());
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getChallengeStatus$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess("");
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess("");
        }
    }

    public static /* synthetic */ void PlaceComponentResult(TwilioSdkEntityRepository twilioSdkEntityRepository, String str, String str2, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.getAuthRequestContext(new UpdatePushFactorPayload(str, str2), new Function1<Factor, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$updateFactor$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
                    invoke2(factor);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Factor factor) {
                    Intrinsics.checkNotNullParameter(factor, "");
                    singleEmitter.onSuccess(Boolean.TRUE);
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$updateFactor$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess(Boolean.FALSE);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(Boolean.FALSE);
        }
    }

    public static /* synthetic */ SingleSource KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository twilioSdkEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return twilioSdkEntityRepository.checkPendingChallenge(str);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TwilioSdkEntityRepository twilioSdkEntityRepository, String str, String str2, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, new Function1<Challenge, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getChallengeHiddenDetails$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge) {
                    invoke2(challenge);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Challenge challenge) {
                    Intrinsics.checkNotNullParameter(challenge, "");
                    Map<String, String> MyBillsEntityDataFactory = challenge.MyBillsEntityDataFactory();
                    if (MyBillsEntityDataFactory != null) {
                        singleEmitter.onSuccess(MyBillsEntityDataFactory);
                    }
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getChallengeHiddenDetails$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess(MapsKt.emptyMap());
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(MapsKt.emptyMap());
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository twilioSdkEntityRepository, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$deleteFactor$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    singleEmitter.onSuccess(Boolean.TRUE);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(Boolean.FALSE);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TwilioSdkEntityRepository twilioSdkEntityRepository, ChallengeListPayload challengeListPayload, final String str, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(challengeListPayload, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.KClassImpl$Data$declaredNonStaticMembers$2(challengeListPayload, new Function1<ChallengeList, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$checkPendingChallenge$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ChallengeList challengeList) {
                    invoke2(challengeList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ChallengeList challengeList) {
                    Intrinsics.checkNotNullParameter(challengeList, "");
                    if ((!challengeList.BuiltInFictitiousFunctionClassFactory().isEmpty()) != false) {
                        singleEmitter.onSuccess(MapsKt.mapOf(TuplesKt.to(TwilioIdentityVerificationActivity.FACTOR_SID, str), TuplesKt.to(TwilioIdentityVerificationActivity.CHALLENGE_SID, ((Challenge) CollectionsKt.first((List) challengeList.BuiltInFictitiousFunctionClassFactory())).getGetErrorConfigVersion())));
                    } else {
                        singleEmitter.onSuccess(MapsKt.emptyMap());
                    }
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$checkPendingChallenge$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onError(twilioVerifyException);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onError(new NullPointerException());
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final TwilioSdkEntityRepository twilioSdkEntityRepository, final String str, String str2, final Map map, final SingleEmitter singleEmitter) {
        Unit unit;
        Intrinsics.checkNotNullParameter(twilioSdkEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        TwilioVerify twilioVerify = twilioSdkEntityRepository.PlaceComponentResult;
        if (twilioVerify != null) {
            twilioVerify.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, new Function1<Challenge, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getChallengeDetails$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Challenge challenge) {
                    invoke2(challenge);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Challenge challenge) {
                    Intrinsics.checkNotNullParameter(challenge, "");
                    List<Detail> list = challenge.getGetAuthRequestContext().PlaceComponentResult;
                    Map<String, String> map2 = map;
                    TwilioSdkEntityRepository twilioSdkEntityRepository2 = twilioSdkEntityRepository;
                    String str3 = str;
                    for (Detail detail : list) {
                        if (Intrinsics.areEqual(detail.PlaceComponentResult, TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT)) {
                            map2.put(detail.PlaceComponentResult, TwilioSdkEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(twilioSdkEntityRepository2, detail.getAuthRequestContext, str3));
                        } else {
                            map2.put(detail.PlaceComponentResult, detail.getAuthRequestContext);
                        }
                    }
                    singleEmitter.onSuccess(map);
                }
            }, new Function1<TwilioVerifyException, Unit>() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$getChallengeDetails$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TwilioVerifyException twilioVerifyException) {
                    invoke2(twilioVerifyException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TwilioVerifyException twilioVerifyException) {
                    Intrinsics.checkNotNullParameter(twilioVerifyException, "");
                    singleEmitter.onSuccess(MapsKt.emptyMap());
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            singleEmitter.onSuccess(MapsKt.emptyMap());
        }
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository twilioSdkEntityRepository, String str, String str2) {
        String lastChallengeSid = twilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory.createData2("local").getLastChallengeSid();
        Intrinsics.checkNotNullExpressionValue(lastChallengeSid, "");
        return ((lastChallengeSid.length() > 0) && Intrinsics.areEqual(twilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory.createData2("local").getLastChallengeSid(), str2)) ? String.valueOf((Integer.parseInt(str) * 2) + 15) : str;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Map<String, String>> checkPendingChallenge() {
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory((SingleOnSubscribe) new TwilioSdkEntityRepository$$ExternalSyntheticLambda8(this));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        Function function = new Function() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioSdkEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(TwilioSdkEntityRepository.this, (String) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single<Map<String, String>> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(MyBillsEntityDataFactory, function));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Boolean> deleteLocalFactor() {
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory((SingleOnSubscribe) new TwilioSdkEntityRepository$$ExternalSyntheticLambda8(this));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        Function function = new Function() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository.this, (String) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(MyBillsEntityDataFactory, function));
        Function function2 = new Function() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioSdkEntityRepository.MyBillsEntityDataFactory((Throwable) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function2, "resumeFunction is null");
        Single<Boolean> BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(BuiltInFictitiousFunctionClassFactory, function2, null));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return BuiltInFictitiousFunctionClassFactory2;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<String> getChallenge(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory((SingleOnSubscribe) new TwilioSdkEntityRepository$$ExternalSyntheticLambda8(this));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        Function function = new Function() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioSdkEntityRepository.BuiltInFictitiousFunctionClassFactory(TwilioSdkEntityRepository.this, p0, (String) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single<String> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(MyBillsEntityDataFactory, function));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Observable<Boolean> saveTwilioChallengeAttempt(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> just = Observable.just(this.BuiltInFictitiousFunctionClassFactory.createData2("local").setLastChallengeSid(p0));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.twilio.TwilioSdkRepository
    public final Single<Boolean> updatePushToken(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory((SingleOnSubscribe) new TwilioSdkEntityRepository$$ExternalSyntheticLambda8(this));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        Function function = new Function() { // from class: id.dana.data.twilio.TwilioSdkEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TwilioSdkEntityRepository.getAuthRequestContext(TwilioSdkEntityRepository.this, p0, (String) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single<Boolean> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(MyBillsEntityDataFactory, function));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }
}
