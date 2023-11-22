package id.dana.savings.presenter;

import android.content.Context;
import android.media.AudioTrack;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import id.dana.R;
import id.dana.core.ui.model.UiTextModel;
import id.dana.di.PerActivity;
import id.dana.domain.saving.interactor.GetSavingDetail;
import id.dana.domain.saving.interactor.RevokeSaving;
import id.dana.domain.saving.model.SavingDetail;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.savings.contract.SavingDetailContract;
import id.dana.savings.mapper.SavingDetailModelMapperKt;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.A;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\f\u001a\u00020\u0012X\u0096\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0014\u0010\b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\n\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001a"}, d2 = {"Lid/dana/savings/presenter/SavingDetailPresenter;", "Lid/dana/savings/contract/SavingDetailContract$Presenter;", "", "p0", "", "p1", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)J", "PlaceComponentResult", "onDestroy", "()V", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "", "I", "Lid/dana/domain/saving/interactor/GetSavingDetail;", "Lid/dana/domain/saving/interactor/GetSavingDetail;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/saving/interactor/RevokeSaving;", "Lid/dana/domain/saving/interactor/RevokeSaving;", "Lid/dana/savings/contract/SavingDetailContract$View;", "Lid/dana/savings/contract/SavingDetailContract$View;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/savings/contract/SavingDetailContract$View;Lid/dana/domain/saving/interactor/GetSavingDetail;Lid/dana/domain/saving/interactor/RevokeSaving;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SavingDetailPresenter implements SavingDetailContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final SavingDetailContract.View MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetSavingDetail BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final RevokeSaving KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context getAuthRequestContext;

    @Inject
    public SavingDetailPresenter(Context context, SavingDetailContract.View view, GetSavingDetail getSavingDetail, RevokeSaving revokeSaving) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSavingDetail, "");
        Intrinsics.checkNotNullParameter(revokeSaving, "");
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = getSavingDetail;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = revokeSaving;
        this.PlaceComponentResult = 1;
    }

    public final void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new GetSavingDetail.Param(str, 0L, 20L), new Function1<SavingDetail, Unit>() { // from class: id.dana.savings.presenter.SavingDetailPresenter$getSavingDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingDetail savingDetail) {
                invoke2(savingDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingDetail savingDetail) {
                SavingDetailContract.View view;
                SavingDetailContract.View view2;
                Intrinsics.checkNotNullParameter(savingDetail, "");
                view = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view2.getAuthRequestContext(SavingDetailModelMapperKt.MyBillsEntityDataFactory(savingDetail));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingDetailPresenter$getSavingDetail$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            private static int $MyBillsEntityDataFactory;
            private static char[] BuiltInFictitiousFunctionClassFactory = {35502, 35573, 35569, 35573, 35572, 35523};

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Throwable th) {
                int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                $MyBillsEntityDataFactory = i % 128;
                char c = i % 2 != 0 ? 'O' : '9';
                invoke2(th);
                Unit unit = Unit.INSTANCE;
                if (c != '9') {
                    Object obj = null;
                    obj.hashCode();
                }
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                int i = $KClassImpl$Data$declaredNonStaticMembers$2 + 31;
                $MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                SavingDetailPresenter.MyBillsEntityDataFactory(SavingDetailPresenter.this, th);
                Object[] objArr = new Object[1];
                a(new int[]{0, 6, 0, 5}, false, new byte[]{1, 1, 1, 1, 1, 0}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to get saving history top up", th);
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 81;
                $MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            }

            private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                int i;
                int i2;
                VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                int i3 = iArr[0];
                int i4 = iArr[1];
                int i5 = iArr[2];
                int i6 = iArr[3];
                try {
                    char[] cArr = BuiltInFictitiousFunctionClassFactory;
                    if (cArr != null) {
                        int length = cArr.length;
                        char[] cArr2 = new char[length];
                        int i7 = 0;
                        while (i7 < length) {
                            int i8 = $11 + 79;
                            $10 = i8 % 128;
                            if (i8 % 2 != 0) {
                                i2 = i5;
                                cArr2[i7] = (char) (cArr[i7] * 5097613533456403102L);
                                i7 /= 1;
                            } else {
                                i2 = i5;
                                cArr2[i7] = (char) (cArr[i7] ^ 5097613533456403102L);
                                i7++;
                            }
                            i5 = i2;
                        }
                        i = i5;
                        cArr = cArr2;
                    } else {
                        i = i5;
                    }
                    char[] cArr3 = new char[i4];
                    System.arraycopy(cArr, i3, cArr3, 0, i4);
                    if (bArr != null) {
                        char[] cArr4 = new char[i4];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        char c = 0;
                        while (true) {
                            try {
                                if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4 ? '/' : '^') == '^') {
                                    break;
                                }
                                if (!(bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1)) {
                                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                                    int i9 = $11 + 123;
                                    $10 = i9 % 128;
                                    int i10 = i9 % 2;
                                } else {
                                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                                }
                                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        cArr3 = cArr4;
                    }
                    if (i6 > 0) {
                        int i11 = $11 + 33;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                        char[] cArr5 = new char[i4];
                        System.arraycopy(cArr3, 0, cArr5, 0, i4);
                        int i13 = i4 - i6;
                        System.arraycopy(cArr5, 0, cArr3, i13, i6);
                        System.arraycopy(cArr5, i6, cArr3, 0, i13);
                    }
                    if (z) {
                        int i14 = $10 + 97;
                        $11 = i14 % 128;
                        int i15 = i14 % 2;
                        char[] cArr6 = new char[i4];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (true) {
                            if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4 ? 'J' : (char) 16) != 'J') {
                                break;
                            }
                            cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i4 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                        cArr3 = cArr6;
                    }
                    if (i > 0) {
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                            cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                    }
                    objArr[0] = new String(cArr3);
                } catch (Exception e2) {
                    throw e2;
                }
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new GetSavingDetail.Param(str, this.PlaceComponentResult, 20L), new Function1<SavingDetail, Unit>() { // from class: id.dana.savings.presenter.SavingDetailPresenter$fetchingMoreTopUpHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SavingDetail savingDetail) {
                invoke2(savingDetail);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SavingDetail savingDetail) {
                SavingDetailContract.View view;
                SavingDetailContract.View view2;
                Intrinsics.checkNotNullParameter(savingDetail, "");
                SavingDetailPresenter.this.PlaceComponentResult++;
                view = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view2.PlaceComponentResult(SavingDetailModelMapperKt.MyBillsEntityDataFactory(savingDetail).getAuthRequestContext);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingDetailPresenter$fetchingMoreTopUpHistory$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            private static int $PlaceComponentResult = 1;
            private static int BuiltInFictitiousFunctionClassFactory = 269894845;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                Unit unit;
                try {
                    int i = $PlaceComponentResult + 37;
                    $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    if (i % 2 == 0) {
                        try {
                            invoke2(th);
                            unit = Unit.INSTANCE;
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        invoke2(th);
                        unit = Unit.INSTANCE;
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                    int i2 = $KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                    $PlaceComponentResult = i2 % 128;
                    int i3 = i2 % 2;
                    return unit;
                } catch (Exception e2) {
                    throw e2;
                }
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingDetailContract.View view;
                SavingDetailContract.View view2;
                Context context;
                int i = $PlaceComponentResult + 65;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                view.PlaceComponentResult();
                view2 = SavingDetailPresenter.this.MyBillsEntityDataFactory;
                SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                context = SavingDetailPresenter.this.getAuthRequestContext;
                view2.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
                Object[] objArr = new Object[1];
                a(new char[]{3, 16, 65531, 65517, 1, '\b'}, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 254, (ViewConfiguration.getJumpTapTimeout() >> 16) + 6, true, ((byte) KeyEvent.getModifierMetaStateMask()) + 5, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to get saving history top up", th);
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 109;
                $PlaceComponentResult = i3 % 128;
                if ((i3 % 2 == 0 ? 'K' : (char) 4) != 'K') {
                    return;
                }
                int i4 = 57 / 0;
            }

            private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
                A a2 = new A();
                char[] cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                try {
                    int i4 = $10 + 59;
                    try {
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        while (a2.MyBillsEntityDataFactory < i2) {
                            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                            int i6 = a2.MyBillsEntityDataFactory;
                            cArr2[i6] = (char) (cArr2[i6] - ((int) (BuiltInFictitiousFunctionClassFactory ^ (-5694784870793460699L))));
                            a2.MyBillsEntityDataFactory++;
                        }
                        if (i3 > 0) {
                            int i7 = $11 + 5;
                            $10 = i7 % 128;
                            int i8 = i7 % 2;
                            a2.BuiltInFictitiousFunctionClassFactory = i3;
                            char[] cArr3 = new char[i2];
                            System.arraycopy(cArr2, 0, cArr3, 0, i2);
                            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                        }
                        if (!(!z)) {
                            char[] cArr4 = new char[i2];
                            a2.MyBillsEntityDataFactory = 0;
                            while (a2.MyBillsEntityDataFactory < i2) {
                                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                                a2.MyBillsEntityDataFactory++;
                                int i9 = $11 + 67;
                                $10 = i9 % 128;
                                int i10 = i9 % 2;
                            }
                            cArr2 = cArr4;
                        }
                        objArr[0] = new String(cArr2);
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        });
    }

    public static long MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return TimeUnit.DAYS.convert(Long.parseLong(p0) - Long.parseLong(p1), TimeUnit.MILLISECONDS);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ void MyBillsEntityDataFactory(SavingDetailPresenter savingDetailPresenter, Throwable th) {
        UiTextModel.StringResource stringResource;
        if (th instanceof NoInternetConnectionException) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            stringResource = new UiTextModel.DynamicString(message);
        } else {
            ?? r3 = 0;
            stringResource = new UiTextModel.StringResource(R.string.saving_unable_to_load_error_message, r3, 2, r3);
        }
        savingDetailPresenter.MyBillsEntityDataFactory.dismissProgress();
        savingDetailPresenter.MyBillsEntityDataFactory.getAuthRequestContext(th, "dana.saving.summary.detail", stringResource, "Goals Summary Detail");
        savingDetailPresenter.MyBillsEntityDataFactory.getAuthRequestContext(stringResource);
    }
}
