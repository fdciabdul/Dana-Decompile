package id.dana.cardbinding.data.repository.source.split;

import android.view.ViewConfiguration;
import id.dana.cardbinding.data.model.BindingCardAddResult;
import id.dana.cardbinding.data.model.SupportedCardEntity;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import id.dana.cardbinding.data.repository.source.CardBindingEntityData;
import id.dana.cardbinding.data.util.CardBindingDefaultConfigGenerator;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxConvertKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import org.json.JSONArray;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005R\u0014\u0010\b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000e"}, d2 = {"Lid/dana/cardbinding/data/repository/source/split/SplitCardBindingEntityData;", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cardbinding/data/model/BindingCardAddResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/flow/Flow;", "", "", "PlaceComponentResult", "Lid/dana/cardbinding/data/model/SupportedCardsConfigEntity;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "p0", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplitCardBindingEntityData implements CardBindingEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int lookAheadTest;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SplitFacade PlaceComponentResult;
    private static char[] PlaceComponentResult = {39478, 39480, 39465, 39479, 39482, 39481, 39472, 39469, 39474, 39462, 39460, 39467, 39466, 39463, 39476, 39477, 39461, 39913};
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    private static boolean getAuthRequestContext = true;
    private static int MyBillsEntityDataFactory = 909155227;

    public static /* synthetic */ SupportedCardsConfigEntity BuiltInFictitiousFunctionClassFactory(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
        lookAheadTest = i % 128;
        char c = i % 2 != 0 ? 'G' : Typography.greater;
        SupportedCardsConfigEntity KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(baseTrafficType);
        if (c != '>') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
            return KClassImpl$Data$declaredNonStaticMembers$22;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
        lookAheadTest = i % 128;
        char c = i % 2 != 0 ? 'Q' : (char) 4;
        Boolean PlaceComponentResult2 = PlaceComponentResult(baseTrafficType);
        if (c != 4) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
        lookAheadTest = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int i3 = 30 / 0;
            return PlaceComponentResult2;
        }
        return PlaceComponentResult2;
    }

    @Inject
    public SplitCardBindingEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.PlaceComponentResult = splitFacade;
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<Boolean> getAuthRequestContext() {
        ObservableSource map = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.cardbinding.data.repository.source.split.SplitCardBindingEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitCardBindingEntityData.MyBillsEntityDataFactory((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Flow<Boolean> asFlow = RxConvertKt.asFlow(map);
        try {
            int i = lookAheadTest + 117;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return asFlow;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final Boolean PlaceComponentResult(BaseTrafficType baseTrafficType) {
        int i = lookAheadTest + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 126, new byte[]{-110, -111, -123, -119, -120, -121, -124, -120, -121, -122, -123, -124, -125, -126, -127, -123, -113, -125, -117, -114, -126, -113, -112}, null, null, objArr);
        Boolean valueOf = Boolean.valueOf(BaseTrafficType.getAuthRequestContext(baseTrafficType, ((String) objArr[0]).intern(), false, 4));
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return valueOf;
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<SupportedCardsConfigEntity> BuiltInFictitiousFunctionClassFactory() {
        try {
            ObservableSource map = this.PlaceComponentResult.PlaceComponentResult().map(new Function() { // from class: id.dana.cardbinding.data.repository.source.split.SplitCardBindingEntityData$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitCardBindingEntityData.BuiltInFictitiousFunctionClassFactory((BaseTrafficType) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            Flow<SupportedCardsConfigEntity> asFlow = RxConvertKt.asFlow(map);
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 19;
                lookAheadTest = i % 128;
                if ((i % 2 != 0 ? '\f' : Typography.greater) != '\f') {
                    return asFlow;
                }
                int i2 = 76 / 0;
                return asFlow;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final SupportedCardsConfigEntity KClassImpl$Data$declaredNonStaticMembers$2(BaseTrafficType baseTrafficType) {
        ArrayList<SupportedCardEntity> arrayListOf;
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        CardBindingDefaultConfigGenerator cardBindingDefaultConfigGenerator = CardBindingDefaultConfigGenerator.INSTANCE;
        arrayListOf = CollectionsKt.arrayListOf(new SupportedCardEntity("https://a.m.dana.id/resource/icons/mastw7id.png", "Mastercard"), new SupportedCardEntity("https://a.m.dana.id/resource/icons/visaw7id.png", "Visa"), new SupportedCardEntity("https://a.m.dana.id/resource/icons/jcbw7id.png", "JCB"), new SupportedCardEntity("https://a.m.dana.id/resource/icons/amexw7id.png", "AMEX"), new SupportedCardEntity("https://a.m.dana.id/resource/icons/gpn.png", "GPN tersedia untuk BRI, Panin, dan Mandiri"));
        Object supportedCardsConfigEntity = new SupportedCardsConfigEntity("Jenis kartu yang didukung", "Kamu bisa pakai jenis kartu debit/kredit ini untuk bayar transaksi di DANA:", arrayListOf, "Kartu GPN lain akan segera tersedia. Ditunggu ya!", "MENGERTI");
        Object[] objArr = new Object[1];
        Object obj = null;
        a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 127, new byte[]{-124, -125, -126, -127, -123, -124, -113, -114, -125, -115, -116, -116, -117, -118, -123, -119, -120, -121, -124, -120, -121, -122, -123, -124, -125, -126, -127}, null, null, objArr);
        String authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), false);
        if ((SupportedCardsConfigEntity.class.isAssignableFrom(JSONArray.class) ? 'S' : (char) 3) != 'S') {
            if ((authRequestContext != null ? '*' : (char) 15) != 15) {
                int i = lookAheadTest + 83;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) SupportedCardsConfigEntity.class);
                } catch (Exception unused) {
                }
                if (obj != null) {
                    supportedCardsConfigEntity = obj;
                }
            }
        } else {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 3;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            supportedCardsConfigEntity = (SupportedCardsConfigEntity) new JSONArray((authRequestContext == null ? 'J' : ';') != 'J' ? authRequestContext : "");
        }
        return (SupportedCardsConfigEntity) supportedCardsConfigEntity;
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<List<String>> PlaceComponentResult() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<BindingCardAddResult> KClassImpl$Data$declaredNonStaticMembers$2() {
        throw new UnsupportedOperationException();
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = PlaceComponentResult;
        if (cArr3 != null) {
            int i3 = $11 + 123;
            $10 = i3 % 128;
            if (i3 % 2 != 0) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            for (int i4 = 0; i4 < length; i4++) {
                cArr2[i4] = (char) (cArr3[i4] ^ 4571606982258105150L);
            }
            int i5 = $11 + 99;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cArr3 = cArr2;
        }
        int i7 = (int) (4571606982258105150L ^ MyBillsEntityDataFactory);
        try {
            if (getAuthRequestContext) {
                int i8 = $11 + 21;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    try {
                        if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                            objArr[0] = new String(cArr4);
                            return;
                        } else {
                            cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i7);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } else if (KClassImpl$Data$declaredNonStaticMembers$2) {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i10 = $10 + 105;
                    $11 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i7);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    int i12 = $10 + 87;
                    $11 = i12 % 128;
                    if (!(i12 % 2 == 0)) {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i7);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) % bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] % i7);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory - 0;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
