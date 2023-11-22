package id.dana.pushverify.view.verificationdetail;

import id.dana.domain.pushverify.interactor.GetPushVerifyChallenge;
import id.dana.domain.pushverify.interactor.GetVerifyPushChallenge;
import id.dana.domain.pushverify.model.PushVerifyChallenge;
import id.dana.domain.pushverify.model.PushVerifyParam;
import id.dana.domain.pushverify.model.VerifyPushChallenge;
import id.dana.network.exception.NetworkException;
import id.dana.pushverify.constant.PushVerifyConstants;
import id.dana.pushverify.constant.PushVerifyErrorCode;
import id.dana.pushverify.mapper.PushVerifyModelMapperKt;
import id.dana.pushverify.model.PushVerifyChallengeModel;
import id.dana.pushverify.model.VerifyPushChallengeParamModel;
import id.dana.pushverify.tracker.PushVerifyTimer;
import id.dana.pushverify.tracker.PushVerifyTracker;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u0013\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u0002X\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/pushverify/view/verificationdetail/PushVerifyPresenter;", "Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$Presenter;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "", "", "PlaceComponentResult", "(Ljava/lang/Throwable;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "onDestroy", "()V", "Lid/dana/pushverify/model/VerifyPushChallengeParamModel;", "(Lid/dana/pushverify/model/VerifyPushChallengeParamModel;Ljava/lang/String;)V", "Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;", "getAuthRequestContext", "Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;", "Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;", "Lid/dana/pushverify/model/PushVerifyChallengeModel;", "Lid/dana/pushverify/model/PushVerifyChallengeModel;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "scheduleImpl", "Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$View;", "moveToNextValue", "Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$View;", "getErrorConfigVersion", "p2", "p3", "<init>", "(Lid/dana/pushverify/view/verificationdetail/PushVerifyContract$View;Lid/dana/pushverify/tracker/PushVerifyTracker;Lid/dana/domain/pushverify/interactor/GetPushVerifyChallenge;Lid/dana/domain/pushverify/interactor/GetVerifyPushChallenge;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyPresenter implements PushVerifyContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetPushVerifyChallenge getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PushVerifyTracker BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetVerifyPushChallenge KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private PushVerifyChallengeModel MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final PushVerifyContract.View getErrorConfigVersion;

    @Inject
    public PushVerifyPresenter(PushVerifyContract.View view, PushVerifyTracker pushVerifyTracker, GetPushVerifyChallenge getPushVerifyChallenge, GetVerifyPushChallenge getVerifyPushChallenge) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(pushVerifyTracker, "");
        Intrinsics.checkNotNullParameter(getPushVerifyChallenge, "");
        Intrinsics.checkNotNullParameter(getVerifyPushChallenge, "");
        this.getErrorConfigVersion = view;
        this.BuiltInFictitiousFunctionClassFactory = pushVerifyTracker;
        this.getAuthRequestContext = getPushVerifyChallenge;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getVerifyPushChallenge;
        this.scheduleImpl = "";
        this.PlaceComponentResult = Reflection.getOrCreateKotlinClass(PushVerifyPresenter.class).getSimpleName();
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.Presenter
    public final void PlaceComponentResult(final VerifyPushChallengeParamModel p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PushVerifyTimer.BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, p0.PlaceComponentResult ? "Allow" : PushVerifyConstants.REJECT, p1);
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(PushVerifyModelMapperKt.PlaceComponentResult(p0, this.scheduleImpl), new Function1<VerifyPushChallenge, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyPresenter$verifyPushChallenge$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyPushChallenge verifyPushChallenge) {
                invoke2(verifyPushChallenge);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyPushChallenge verifyPushChallenge) {
                PushVerifyContract.View view;
                Intrinsics.checkNotNullParameter(verifyPushChallenge, "");
                view = PushVerifyPresenter.this.getErrorConfigVersion;
                view.onSuccessVerifyPushChallenge();
                PushVerifyPresenter.BuiltInFictitiousFunctionClassFactory(PushVerifyPresenter.this, p0, true, p1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyPresenter$verifyPushChallenge$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                boolean PlaceComponentResult;
                Intrinsics.checkNotNullParameter(th, "");
                PushVerifyPresenter pushVerifyPresenter = PushVerifyPresenter.this;
                VerifyPushChallengeParamModel verifyPushChallengeParamModel = p0;
                PlaceComponentResult = PushVerifyPresenter.PlaceComponentResult(th);
                PushVerifyPresenter.BuiltInFictitiousFunctionClassFactory(pushVerifyPresenter, verifyPushChallengeParamModel, PlaceComponentResult, p1);
                PushVerifyPresenter.MyBillsEntityDataFactory(PushVerifyPresenter.this, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(Throwable p0) {
        return (p0 instanceof NetworkException) && Intrinsics.areEqual(((NetworkException) p0).getErrorCode(), PushVerifyErrorCode.USER_REJECT);
    }

    @Override // id.dana.pushverify.view.verificationdetail.PushVerifyContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PushVerifyTimer.PlaceComponentResult();
        this.getAuthRequestContext.execute(new PushVerifyParam(p0, p1), new Function1<PushVerifyChallenge, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyPresenter$getPushVerifyChallenge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PushVerifyChallenge pushVerifyChallenge) {
                invoke2(pushVerifyChallenge);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PushVerifyChallenge pushVerifyChallenge) {
                PushVerifyContract.View view;
                PushVerifyChallengeModel pushVerifyChallengeModel;
                PushVerifyTracker pushVerifyTracker;
                PushVerifyChallengeModel pushVerifyChallengeModel2;
                Intrinsics.checkNotNullParameter(pushVerifyChallenge, "");
                PushVerifyTimer.moveToNextValue();
                PushVerifyPresenter pushVerifyPresenter = PushVerifyPresenter.this;
                String tokenPair = pushVerifyChallenge.getTokenPair();
                Intrinsics.checkNotNullParameter(tokenPair, "");
                pushVerifyPresenter.scheduleImpl = tokenPair;
                PushVerifyPresenter.this.MyBillsEntityDataFactory = PushVerifyModelMapperKt.BuiltInFictitiousFunctionClassFactory(pushVerifyChallenge);
                view = PushVerifyPresenter.this.getErrorConfigVersion;
                pushVerifyChallengeModel = PushVerifyPresenter.this.MyBillsEntityDataFactory;
                view.onSuccessGetPushVerifyChallenge(pushVerifyChallengeModel);
                pushVerifyTracker = PushVerifyPresenter.this.BuiltInFictitiousFunctionClassFactory;
                pushVerifyChallengeModel2 = PushVerifyPresenter.this.MyBillsEntityDataFactory;
                pushVerifyTracker.MyBillsEntityDataFactory(pushVerifyChallengeModel2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.pushverify.view.verificationdetail.PushVerifyPresenter$getPushVerifyChallenge$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                PushVerifyTimer.moveToNextValue();
                str = PushVerifyPresenter.this.PlaceComponentResult;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                PushVerifyPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyPresenter.this, th);
            }
        });
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return Intrinsics.areEqual(p0, PushVerifyErrorCode.CACHE_NOT_EXIST) || Intrinsics.areEqual(p0, PushVerifyErrorCode.HAS_COMPLETED) || Intrinsics.areEqual(p0, PushVerifyErrorCode.INVALID_TRX_ID);
    }

    private static boolean PlaceComponentResult(String p0) {
        return Intrinsics.areEqual(p0, PushVerifyErrorCode.INVALID_USER_SESSION);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        PushVerifyTimer.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyPresenter pushVerifyPresenter, Throwable th) {
        if (th instanceof NetworkException) {
            String errorCode = ((NetworkException) th).getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            if (KClassImpl$Data$declaredNonStaticMembers$2(errorCode)) {
                pushVerifyPresenter.getErrorConfigVersion.onExpiredGetPushVerifyChallenge();
                pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(th);
                return;
            } else if (PlaceComponentResult(errorCode)) {
                pushVerifyPresenter.getErrorConfigVersion.onInvalidSessionGetPushVerifyChallenge();
                pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(th);
                return;
            } else {
                pushVerifyPresenter.getErrorConfigVersion.onErrorGetPushVerifyChallenge(th);
                pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(th);
                return;
            }
        }
        pushVerifyPresenter.getErrorConfigVersion.onErrorGetPushVerifyChallenge(th);
        pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(th);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(PushVerifyPresenter pushVerifyPresenter, Throwable th) {
        if (th instanceof NetworkException) {
            String errorCode = ((NetworkException) th).getErrorCode();
            Intrinsics.checkNotNullExpressionValue(errorCode, "");
            if (Intrinsics.areEqual(errorCode, PushVerifyErrorCode.USER_REJECT)) {
                pushVerifyPresenter.getErrorConfigVersion.onRejectVerifyPushChallenge();
                return;
            }
            pushVerifyPresenter.getErrorConfigVersion.onErrorVerifyPushChallenge(th);
            pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(th);
            return;
        }
        pushVerifyPresenter.getErrorConfigVersion.onErrorVerifyPushChallenge(th);
        pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(th);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PushVerifyPresenter pushVerifyPresenter, VerifyPushChallengeParamModel verifyPushChallengeParamModel, boolean z, String str) {
        PushVerifyTimer.scheduleImpl();
        pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(pushVerifyPresenter.MyBillsEntityDataFactory, verifyPushChallengeParamModel.PlaceComponentResult ? "Allow" : PushVerifyConstants.REJECT, z);
        pushVerifyPresenter.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(pushVerifyPresenter.MyBillsEntityDataFactory, verifyPushChallengeParamModel.PlaceComponentResult ? "Allow" : PushVerifyConstants.REJECT, z, str);
    }
}
