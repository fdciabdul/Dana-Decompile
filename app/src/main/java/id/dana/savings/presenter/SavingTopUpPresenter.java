package id.dana.savings.presenter;

import android.content.Context;
import android.text.TextUtils;
import id.dana.R;
import id.dana.core.ui.model.UiTextModel;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.saving.interactor.InitSavingTopUp;
import id.dana.domain.saving.interactor.TopUpSaving;
import id.dana.domain.saving.model.SavingTopUpInit;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.savings.contract.SavingTopUpContract;
import id.dana.savings.mapper.SavingTopUpInitMapperKt;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\n\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/savings/presenter/SavingTopUpPresenter;", "Lid/dana/savings/contract/SavingTopUpContract$Presenter;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "onDestroy", "()V", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "getAuthRequestContext", "Lid/dana/domain/saving/interactor/InitSavingTopUp;", "Lid/dana/domain/saving/interactor/InitSavingTopUp;", "Lid/dana/domain/saving/interactor/TopUpSaving;", "Lid/dana/domain/saving/interactor/TopUpSaving;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/savings/contract/SavingTopUpContract$View;", "Lid/dana/savings/contract/SavingTopUpContract$View;", "p1", "p2", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/savings/contract/SavingTopUpContract$View;Lid/dana/domain/saving/interactor/InitSavingTopUp;Lid/dana/domain/saving/interactor/TopUpSaving;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SavingTopUpPresenter implements SavingTopUpContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetUserInfoWithKyc getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final SavingTopUpContract.View MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final TopUpSaving KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final InitSavingTopUp BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SavingTopUpPresenter(Context context, SavingTopUpContract.View view, InitSavingTopUp initSavingTopUp, TopUpSaving topUpSaving, GetUserInfoWithKyc getUserInfoWithKyc) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(initSavingTopUp, "");
        Intrinsics.checkNotNullParameter(topUpSaving, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = initSavingTopUp;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = topUpSaving;
        this.getAuthRequestContext = getUserInfoWithKyc;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(p0, new Function1<SavingTopUpInit, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpPresenter$initSavingTopUp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingTopUpInit savingTopUpInit) {
                invoke2(savingTopUpInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingTopUpInit savingTopUpInit) {
                SavingTopUpContract.View view;
                SavingTopUpContract.View view2;
                Intrinsics.checkNotNullParameter(savingTopUpInit, "");
                view = SavingTopUpPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingTopUpPresenter.this.MyBillsEntityDataFactory;
                view2.BuiltInFictitiousFunctionClassFactory(SavingTopUpInitMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(savingTopUpInit));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpPresenter$initSavingTopUp$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $getAuthRequestContext = 0;
            private static int $moveToNextValue = 1;
            private static char[] BuiltInFictitiousFunctionClassFactory = {39919, 39905, 39882, 39897, 39890, 39899};
            private static boolean MyBillsEntityDataFactory = true;
            private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
            private static int PlaceComponentResult = 909155136;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                Unit unit;
                try {
                    int i = $moveToNextValue + 87;
                    try {
                        $getAuthRequestContext = i % 128;
                        Object[] objArr = null;
                        if (i % 2 == 0) {
                            invoke2(th);
                            unit = Unit.INSTANCE;
                        } else {
                            invoke2(th);
                            unit = Unit.INSTANCE;
                            int length = objArr.length;
                        }
                        int i2 = $getAuthRequestContext + 27;
                        $moveToNextValue = i2 % 128;
                        if (i2 % 2 != 0) {
                            return unit;
                        }
                        int length2 = objArr.length;
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
                int i = $moveToNextValue + 85;
                $getAuthRequestContext = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                SavingTopUpPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SavingTopUpPresenter.this, th);
                Object[] objArr = new Object[1];
                a(127 - TextUtils.indexOf("", ""), new byte[]{-122, -123, -124, -125, -126, -127}, null, null, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to init top up", th);
                int i3 = $moveToNextValue + 35;
                $getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
                BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
                char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
                if (!(cArr2 == null)) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
                    }
                    cArr2 = cArr3;
                }
                int i3 = (int) (4571606982258105150L ^ PlaceComponentResult);
                if (KClassImpl$Data$declaredNonStaticMembers$2) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                    char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                            objArr[0] = new String(cArr4);
                            return;
                        }
                        int i4 = $11 + 43;
                        $10 = i4 % 128;
                        int i5 = i4 % 2;
                        cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                } else {
                    if ((MyBillsEntityDataFactory ? Typography.amp : '[') == '&') {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                        char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                        while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                            int i6 = $10 + 17;
                            $11 = i6 % 128;
                            int i7 = i6 % 2;
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                        String str = new String(cArr5);
                        int i8 = $10 + 111;
                        $11 = i8 % 128;
                        if (i8 % 2 != 0) {
                            objArr[0] = str;
                            return;
                        }
                        int i9 = 13 / 0;
                        objArr[0] = str;
                        return;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'C' : '6') == '6') {
                            objArr[0] = new String(cArr6);
                            return;
                        }
                        try {
                            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(final SavingTopUpPresenter savingTopUpPresenter, Throwable th) {
        SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
        if (!Intrinsics.areEqual(SavingErrorParser.BuiltInFictitiousFunctionClassFactory(th.getLocalizedMessage()), "DE13113048999207")) {
            SavingTopUpContract.View view = savingTopUpPresenter.MyBillsEntityDataFactory;
            SavingErrorParser savingErrorParser2 = SavingErrorParser.INSTANCE;
            view.onError(SavingErrorParser.PlaceComponentResult(savingTopUpPresenter.PlaceComponentResult, th.getLocalizedMessage()));
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        savingTopUpPresenter.getAuthRequestContext.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.savings.presenter.SavingTopUpPresenter$getMessageByKycLevel$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                Ref.BooleanRef.this.element = userInfoResponse.isKycCertified();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onComplete() {
                SavingTopUpContract.View view2;
                SavingTopUpContract.View view3;
                Context context;
                SavingTopUpContract.View view4;
                Context context2;
                super.onComplete();
                view2 = savingTopUpPresenter.MyBillsEntityDataFactory;
                view2.dismissProgress();
                if (Ref.BooleanRef.this.element) {
                    view4 = savingTopUpPresenter.MyBillsEntityDataFactory;
                    context2 = savingTopUpPresenter.PlaceComponentResult;
                    view4.onError(context2.getString(R.string.error_saving_DE13113048999207));
                    return;
                }
                view3 = savingTopUpPresenter.MyBillsEntityDataFactory;
                context = savingTopUpPresenter.PlaceComponentResult;
                String string = context.getString(R.string.error_saving_amount_limit_non_kyc);
                Intrinsics.checkNotNullExpressionValue(string, "");
                view3.KClassImpl$Data$declaredNonStaticMembers$2(string);
            }
        }, GetUserInfoWithKyc.Params.forParams(true));
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SavingTopUpPresenter savingTopUpPresenter, Throwable th) {
        UiTextModel.StringResource stringResource;
        if (th instanceof NoInternetConnectionException) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            stringResource = new UiTextModel.DynamicString(message);
        } else {
            ?? r3 = 0;
            stringResource = new UiTextModel.StringResource(R.string.saving_unable_to_top_up_error_message, r3, 2, r3);
        }
        savingTopUpPresenter.MyBillsEntityDataFactory.dismissProgress();
        savingTopUpPresenter.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(stringResource);
        savingTopUpPresenter.MyBillsEntityDataFactory.getAuthRequestContext(th, "dana.saving.topup.init", stringResource, "Goals Top Up Init");
    }
}
