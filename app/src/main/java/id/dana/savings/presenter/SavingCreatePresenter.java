package id.dana.savings.presenter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import id.dana.R;
import id.dana.data.util.NumberUtils;
import id.dana.domain.DefaultObserver;
import id.dana.domain.saving.interactor.CreateSaving;
import id.dana.domain.saving.interactor.InitSavingCreate;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.contract.SavingCreateContract;
import id.dana.savings.ext.SavingErrorHandler;
import id.dana.savings.mapper.SavingModelMapperKt;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J/\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\f\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001a"}, d2 = {"Lid/dana/savings/presenter/SavingCreatePresenter;", "Lid/dana/savings/contract/SavingCreateContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "onDestroy", "", "p0", "p1", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/saving/interactor/CreateSaving;", "Lid/dana/domain/saving/interactor/CreateSaving;", "getAuthRequestContext", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/saving/interactor/InitSavingCreate;", "Lid/dana/domain/saving/interactor/InitSavingCreate;", "PlaceComponentResult", "Lid/dana/savings/contract/SavingCreateContract$View;", "Lid/dana/savings/contract/SavingCreateContract$View;", "p4", "<init>", "(Landroid/content/Context;Lid/dana/savings/contract/SavingCreateContract$View;Lid/dana/domain/saving/interactor/InitSavingCreate;Lid/dana/domain/saving/interactor/CreateSaving;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingCreatePresenter implements SavingCreateContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final InitSavingCreate PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CreateSaving getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SavingCreateContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetUserInfoWithKyc MyBillsEntityDataFactory;

    @Inject
    public SavingCreatePresenter(Context context, SavingCreateContract.View view, InitSavingCreate initSavingCreate, CreateSaving createSaving, GetUserInfoWithKyc getUserInfoWithKyc) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(initSavingCreate, "");
        Intrinsics.checkNotNullParameter(createSaving, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = initSavingCreate;
        this.getAuthRequestContext = createSaving;
        this.MyBillsEntityDataFactory = getUserInfoWithKyc;
    }

    @Override // id.dana.savings.contract.SavingCreateContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.savings.presenter.SavingCreatePresenter$getKycStatus$1

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            public boolean BuiltInFictitiousFunctionClassFactory;

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                this.BuiltInFictitiousFunctionClassFactory = userInfoResponse.isKycCertified();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                SavingCreateContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onError(p0);
                view = SavingCreatePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                SavingCreatePresenter.BuiltInFictitiousFunctionClassFactory(SavingCreatePresenter.this, p0);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onComplete() {
                SavingCreateContract.View view;
                SavingCreateContract.View view2;
                super.onComplete();
                view = SavingCreatePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = SavingCreatePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            }
        }, GetUserInfoWithKyc.Params.forParams(true));
    }

    @Override // id.dana.savings.contract.SavingCreateContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, MoneyViewModel p2, MoneyViewModel p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (StringsKt.isBlank(p1) || p2.getAuthRequestContext(p3)) {
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            return;
        }
        String cleanAll = NumberUtils.getCleanAll(p2.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(cleanAll, "");
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.getAuthRequestContext.execute(new CreateSaving.Param(p0, p1, cleanAll), new Function1<SavingGoalView, Unit>() { // from class: id.dana.savings.presenter.SavingCreatePresenter$createSaving$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingGoalView savingGoalView) {
                invoke2(savingGoalView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingGoalView savingGoalView) {
                SavingCreateContract.View view;
                SavingCreateContract.View view2;
                Intrinsics.checkNotNullParameter(savingGoalView, "");
                view = SavingCreatePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = SavingCreatePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.MyBillsEntityDataFactory(SavingModelMapperKt.BuiltInFictitiousFunctionClassFactory(savingGoalView));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingCreatePresenter$createSaving$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $moveToNextValue = 0;
            private static int $scheduleImpl = 1;
            private static int BuiltInFictitiousFunctionClassFactory = -99861381;
            private static short[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
            private static int PlaceComponentResult = 1257195761;
            private static byte[] getAuthRequestContext = {7, 65, 117, 71, 101, 108};
            private static int MyBillsEntityDataFactory = 1109077655;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                try {
                    int i = $moveToNextValue + 59;
                    $scheduleImpl = i % 128;
                    int i2 = i % 2;
                    try {
                        invoke2(th);
                        Unit unit = Unit.INSTANCE;
                        int i3 = $moveToNextValue + 55;
                        $scheduleImpl = i3 % 128;
                        int i4 = i3 % 2;
                        return unit;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingCreateContract.View view;
                int i = $moveToNextValue + 73;
                $scheduleImpl = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingCreatePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                SavingCreatePresenter.BuiltInFictitiousFunctionClassFactory(SavingCreatePresenter.this, th);
                Object[] objArr = new Object[1];
                a((-150234633) - MotionEvent.axisFromString(""), Color.alpha(0) - 111, (short) (27 - Gravity.getAbsoluteGravity(0, 0)), 1327270767 - (ViewConfiguration.getScrollBarSize() >> 8), (byte) (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to create saving", th);
                int i3 = $scheduleImpl + 93;
                $moveToNextValue = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    Object[] objArr2 = null;
                    int length = objArr2.length;
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:58:0x00ff, code lost:
            
                if ((r3 ? 15 : '_') != 15) goto L65;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x0105, code lost:
            
                if (r3 != false) goto L64;
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x0107, code lost:
            
                r8 = id.dana.savings.presenter.SavingCreatePresenter$createSaving$2.getAuthRequestContext;
                r0.getAuthRequestContext = r0.getAuthRequestContext - 1;
                r0.MyBillsEntityDataFactory = (char) (r0.PlaceComponentResult + (((byte) (((byte) (r8[r9] ^ 3097486228508854431L)) + r15)) ^ r17));
             */
            /* JADX WARN: Code restructure failed: missing block: B:65:0x0120, code lost:
            
                r8 = id.dana.savings.presenter.SavingCreatePresenter$createSaving$2.KClassImpl$Data$declaredNonStaticMembers$2;
                r0.getAuthRequestContext = r0.getAuthRequestContext - 1;
                r0.MyBillsEntityDataFactory = (char) (r0.PlaceComponentResult + (((short) (((short) (r8[r9] ^ 3097486228508854431L)) + r15)) ^ r17));
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
                /*
                    Method dump skipped, instructions count: 336
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.presenter.SavingCreatePresenter$createSaving$2.a(int, int, short, int, byte, java.lang.Object[]):void");
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SavingCreatePresenter savingCreatePresenter, Throwable th) {
        SavingErrorHandler savingErrorHandler = SavingErrorHandler.INSTANCE;
        String BuiltInFictitiousFunctionClassFactory = SavingErrorHandler.BuiltInFictitiousFunctionClassFactory(th);
        switch (BuiltInFictitiousFunctionClassFactory.hashCode()) {
            case -879828873:
                if (BuiltInFictitiousFunctionClassFactory.equals("NETWORK_ERROR")) {
                    String string = savingCreatePresenter.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.error_saving_default);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    savingCreatePresenter.BuiltInFictitiousFunctionClassFactory.onError(string);
                    savingCreatePresenter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(th, "", string, "");
                    return;
                }
                break;
            case 1665786589:
                if (BuiltInFictitiousFunctionClassFactory.equals("DE13113048999200")) {
                    savingCreatePresenter.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                    SavingCreateContract.View view = savingCreatePresenter.BuiltInFictitiousFunctionClassFactory;
                    String string2 = savingCreatePresenter.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.error_saving_DE13113048999200);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    view.KClassImpl$Data$declaredNonStaticMembers$2(th, "", string2, "");
                    return;
                }
                break;
            case 1665786590:
                if (BuiltInFictitiousFunctionClassFactory.equals("DE13113048999201")) {
                    savingCreatePresenter.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                    SavingCreateContract.View view2 = savingCreatePresenter.BuiltInFictitiousFunctionClassFactory;
                    String string3 = savingCreatePresenter.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.error_saving_DE13113048999201);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(th, "", string3, "");
                    return;
                }
                break;
        }
        SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
        String PlaceComponentResult = SavingErrorParser.PlaceComponentResult(savingCreatePresenter.KClassImpl$Data$declaredNonStaticMembers$2, th.getLocalizedMessage());
        savingCreatePresenter.BuiltInFictitiousFunctionClassFactory.onError(PlaceComponentResult);
        savingCreatePresenter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(th, "", PlaceComponentResult, "");
    }
}
