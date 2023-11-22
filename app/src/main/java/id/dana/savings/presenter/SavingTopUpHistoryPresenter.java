package id.dana.savings.presenter;

import android.content.Context;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import id.dana.di.PerActivity;
import id.dana.domain.saving.interactor.GetSavingDetail;
import id.dana.domain.saving.model.SavingDetail;
import id.dana.savings.contract.SavingTopUpHistoryContract;
import id.dana.savings.mapper.SavingDetailModelMapperKt;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.C;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u00118\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\b\u0010\u0013R\u0014\u0010\u000e\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\b\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018"}, d2 = {"Lid/dana/savings/presenter/SavingTopUpHistoryPresenter;", "Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "", "p0", "", "p1", "p2", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "PlaceComponentResult", "onDestroy", "()V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "I", "()I", "Lid/dana/domain/saving/interactor/GetSavingDetail;", "getAuthRequestContext", "Lid/dana/domain/saving/interactor/GetSavingDetail;", "Lid/dana/savings/contract/SavingTopUpHistoryContract$View;", "Lid/dana/savings/contract/SavingTopUpHistoryContract$View;", "<init>", "(Landroid/content/Context;Lid/dana/savings/contract/SavingTopUpHistoryContract$View;Lid/dana/domain/saving/interactor/GetSavingDetail;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes9.dex */
public final class SavingTopUpHistoryPresenter implements SavingTopUpHistoryContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SavingTopUpHistoryContract.View MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetSavingDetail BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SavingTopUpHistoryPresenter(Context context, SavingTopUpHistoryContract.View view, GetSavingDetail getSavingDetail) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSavingDetail, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = getSavingDetail;
        this.PlaceComponentResult = 1;
    }

    @Override // id.dana.savings.contract.SavingTopUpHistoryContract.Presenter
    public final void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new GetSavingDetail.Param(str, 0L, 40L), new Function1<SavingDetail, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpHistoryPresenter$getSavingTopUpHistory$1
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
                SavingTopUpHistoryContract.View view;
                SavingTopUpHistoryContract.View view2;
                Intrinsics.checkNotNullParameter(savingDetail, "");
                view = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(SavingDetailModelMapperKt.MyBillsEntityDataFactory(savingDetail));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpHistoryPresenter$getSavingTopUpHistory$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $PlaceComponentResult = 0;
            private static int $scheduleImpl = 1;
            private static char BuiltInFictitiousFunctionClassFactory = 12876;
            private static char KClassImpl$Data$declaredNonStaticMembers$2 = 39432;
            private static char MyBillsEntityDataFactory = 24262;
            private static char getAuthRequestContext = 1375;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $PlaceComponentResult + 113;
                $scheduleImpl = i % 128;
                boolean z = i % 2 != 0;
                invoke2(th);
                Unit unit = Unit.INSTANCE;
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = $PlaceComponentResult + 41;
                $scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingTopUpHistoryContract.View view;
                SavingTopUpHistoryContract.View view2;
                Context context;
                int i = $PlaceComponentResult + 85;
                $scheduleImpl = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                context = SavingTopUpHistoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
                Object[] objArr = new Object[1];
                a(5 - ((byte) KeyEvent.getModifierMetaStateMask()), new char[]{43881, 1012, 16868, 18767, 25731, 14690}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to get saving history top up", th);
                int i3 = $PlaceComponentResult + 125;
                $scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
            }

            private static void a(int i, char[] cArr, Object[] objArr) {
                C c = new C();
                char[] cArr2 = new char[cArr.length];
                c.BuiltInFictitiousFunctionClassFactory = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? (char) 11 : Typography.dollar) == 11) {
                        cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                        cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                        int i2 = 58224;
                        int i3 = 0;
                        while (i3 < 16) {
                            int i4 = $11 + 59;
                            $10 = i4 % 128;
                            int i5 = i4 % 2;
                            cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                            cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                            i2 -= 40503;
                            i3++;
                            int i6 = $10 + 77;
                            $11 = i6 % 128;
                            int i7 = i6 % 2;
                        }
                        cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                        cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                        c.BuiltInFictitiousFunctionClassFactory += 2;
                    } else {
                        objArr[0] = new String(cArr2, 0, i);
                        return;
                    }
                }
            }
        });
    }

    @Override // id.dana.savings.contract.SavingTopUpHistoryContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new GetSavingDetail.Param(str, this.PlaceComponentResult, 40L), new Function1<SavingDetail, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpHistoryPresenter$fetchingMoreTopUpHistory$1
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
                SavingTopUpHistoryContract.View view;
                SavingTopUpHistoryContract.View view2;
                Intrinsics.checkNotNullParameter(savingDetail, "");
                SavingTopUpHistoryPresenter.this.PlaceComponentResult++;
                view = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                view2.PlaceComponentResult(SavingDetailModelMapperKt.MyBillsEntityDataFactory(savingDetail).getAuthRequestContext);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingTopUpHistoryPresenter$fetchingMoreTopUpHistory$2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int $KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            private static int $PlaceComponentResult = 1;
            private static int[] MyBillsEntityDataFactory = {1232277905, -1472094715, -679276246, -1451900252, 361823093, -1275267851, -716784180, 237843169, -527001345, 851129488, 1320411857, 937871745, 1881882362, 1884553014, -1102651387, 786307022, -874649847, 601289957};

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                int i = $PlaceComponentResult + 65;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                invoke2(th);
                Unit unit = Unit.INSTANCE;
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 41;
                $PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return unit;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SavingTopUpHistoryContract.View view;
                SavingTopUpHistoryContract.View view2;
                Context context;
                int i = $PlaceComponentResult + 103;
                $KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(th, "");
                view = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                view.getAuthRequestContext();
                view2 = SavingTopUpHistoryPresenter.this.MyBillsEntityDataFactory;
                SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                context = SavingTopUpHistoryPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
                Object[] objArr = new Object[1];
                a(7 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), new int[]{1415098761, -491716874, 148799373, 351744542}, objArr);
                DanaLog.BuiltInFictitiousFunctionClassFactory(((String) objArr[0]).intern(), "Fail to get saving history top up", th);
                int i3 = $KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                $PlaceComponentResult = i3 % 128;
                if ((i3 % 2 == 0 ? 'I' : 'B') != 'I') {
                    return;
                }
                int i4 = 25 / 0;
            }

            private static void a(int i, int[] iArr, Object[] objArr) {
                int length;
                int[] iArr2;
                int i2;
                VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length * 2];
                int[] iArr3 = MyBillsEntityDataFactory;
                boolean z = true;
                if (!(iArr3 == null)) {
                    int i3 = $11 + 37;
                    $10 = i3 % 128;
                    if (i3 % 2 == 0) {
                        length = iArr3.length;
                        iArr2 = new int[length];
                        i2 = 0;
                    } else {
                        length = iArr3.length;
                        iArr2 = new int[length];
                        i2 = 1;
                    }
                    while (i2 < length) {
                        iArr2[i2] = (int) (iArr3[i2] ^ (-3152031022165484798L));
                        i2++;
                    }
                    iArr3 = iArr2;
                }
                int length2 = iArr3.length;
                int[] iArr4 = new int[length2];
                int[] iArr5 = MyBillsEntityDataFactory;
                if (!(iArr5 == null)) {
                    int length3 = iArr5.length;
                    int[] iArr6 = new int[length3];
                    int i4 = 0;
                    while (true) {
                        if ((i4 >= length3) == z) {
                            break;
                        }
                        iArr6[i4] = (int) (iArr5[i4] ^ (-3152031022165484798L));
                        i4++;
                        z = true;
                    }
                    int i5 = $11 + 81;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    iArr5 = iArr6;
                }
                System.arraycopy(iArr5, 0, iArr4, 0, length2);
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                    int i7 = $10 + 35;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    try {
                        cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                        cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                        cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                        cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                        VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                        for (int i9 = 0; i9 < 16; i9++) {
                            int i10 = $10 + 1;
                            $11 = i10 % 128;
                            int i11 = i10 % 2;
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                        }
                        int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                        int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                        cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                        cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                        cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                        cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                        cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                        cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                objArr[0] = new String(cArr2, 0, i);
            }
        });
    }

    @Override // id.dana.savings.contract.SavingTopUpHistoryContract.Presenter
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
