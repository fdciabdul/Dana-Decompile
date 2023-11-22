package id.dana.wallet_v3.factory;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.R;
import id.dana.domain.payasset.model.Institution;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.pay.PayCardViewItem;
import id.dana.pay.card.BukopinCard;
import id.dana.pay.card.HsbcCard;
import id.dana.pay.card.MaybankCard;
import id.dana.pay.card.MncCard;
import id.dana.pay.card.StandardcharteredCard;
import id.dana.pay.card.UobCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u0006*\u00020\u00070\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/wallet_v3/factory/WalletCardViewItemFactory;", "", "", "institutionId", "assetType", "", "isDirectDebit", "Lid/dana/pay/PayCardViewItem;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/pay/PayCardViewItem;", "", "horizontalBackground", "bankLogo", "createPayCardView", "(II)Lid/dana/pay/PayCardViewItem;", "getCreditCard", "(Ljava/lang/String;Z)Lid/dana/pay/PayCardViewItem;", "getDebitCard", "otherBank", "(Ljava/lang/String;)Lid/dana/pay/PayCardViewItem;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WalletCardViewItemFactory {
    public static final WalletCardViewItemFactory INSTANCE = new WalletCardViewItemFactory();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardAssetType.values().length];
            iArr[CardAssetType.EMAS.ordinal()] = 1;
            iArr[CardAssetType.GOALS.ordinal()] = 2;
            iArr[CardAssetType.BALANCE.ordinal()] = 3;
            iArr[CardAssetType.PAYLATER.ordinal()] = 4;
            iArr[CardAssetType.DANA_PLUS.ordinal()] = 5;
            iArr[CardAssetType.CREDIT_CARD.ordinal()] = 6;
            iArr[CardAssetType.DEBIT_CARD.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private WalletCardViewItemFactory() {
    }

    private final PayCardViewItem createPayCardView(int horizontalBackground, int bankLogo) {
        PayCardViewItem.Builder PlaceComponentResult = PayCardViewItem.PlaceComponentResult();
        PlaceComponentResult.PlaceComponentResult = horizontalBackground;
        PlaceComponentResult.MyBillsEntityDataFactory = bankLogo;
        PlaceComponentResult.lookAheadTest = R.color.f27072131100488;
        return PlaceComponentResult.PlaceComponentResult();
    }

    public final PayCardViewItem create(String institutionId, String assetType, boolean isDirectDebit) {
        Intrinsics.checkNotNullParameter(institutionId, "");
        Intrinsics.checkNotNullParameter(assetType, "");
        CardAssetType value = CardAssetType.INSTANCE.getValue(assetType);
        switch (value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                PayCardViewItem createPayCardView = createPayCardView(R.drawable.bg_emas_wallet, R.drawable.ic_emas_wallet_logo);
                Intrinsics.checkNotNullExpressionValue(createPayCardView, "");
                return createPayCardView;
            case 2:
                PayCardViewItem createPayCardView2 = createPayCardView(R.drawable.bg_dana_goals, R.drawable.ic_dana_goals);
                Intrinsics.checkNotNullExpressionValue(createPayCardView2, "");
                return createPayCardView2;
            case 3:
                PayCardViewItem createPayCardView3 = createPayCardView(R.drawable.bg_dana_balance_horizontal, R.drawable.dana_logo_white_png);
                Intrinsics.checkNotNullExpressionValue(createPayCardView3, "");
                return createPayCardView3;
            case 4:
                PayCardViewItem createPayCardView4 = createPayCardView(R.drawable.bg_paylater, R.drawable.ic_paylater_logo);
                Intrinsics.checkNotNullExpressionValue(createPayCardView4, "");
                return createPayCardView4;
            case 5:
                PayCardViewItem createPayCardView5 = createPayCardView(R.drawable.bg_dana_plus, R.drawable.ic_dana_plus_logo);
                Intrinsics.checkNotNullExpressionValue(createPayCardView5, "");
                return createPayCardView5;
            case 6:
                return getCreditCard(institutionId, isDirectDebit);
            case 7:
                return getDebitCard(institutionId, isDirectDebit);
            default:
                PayCardViewItem PlaceComponentResult = PayCardViewItem.MyBillsEntityDataFactory().PlaceComponentResult();
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                return PlaceComponentResult;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0193, code lost:
    
        if (r8.equals(id.dana.domain.payasset.model.Institution.DBS2) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x019c, code lost:
    
        if (r8.equals(id.dana.domain.payasset.model.Institution.DBS) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x019e, code lost:
    
        r8 = id.dana.pay.PayCardViewItem.PlaceComponentResult();
        r8.getErrorConfigVersion = id.dana.R.drawable.bg_dbs_debit_v;
        r8.PlaceComponentResult = id.dana.R.drawable.bg_dbs_debit_h;
        r8.MyBillsEntityDataFactory = id.dana.R.drawable.ic_dbs_white_logo;
        r8.KClassImpl$Data$declaredNonStaticMembers$2 = id.dana.R.drawable.expresspay_light;
        r8.lookAheadTest = id.dana.R.color.f27072131100488;
        r8 = r8.PlaceComponentResult();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.pay.PayCardViewItem getDebitCard(java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.factory.WalletCardViewItemFactory.getDebitCard(java.lang.String, boolean):id.dana.pay.PayCardViewItem");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0193, code lost:
    
        if (r8.equals(id.dana.domain.payasset.model.Institution.DBS2) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x019c, code lost:
    
        if (r8.equals(id.dana.domain.payasset.model.Institution.DBS) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x019e, code lost:
    
        r8 = id.dana.pay.PayCardViewItem.PlaceComponentResult();
        r8.getErrorConfigVersion = id.dana.R.drawable.bg_dbs_credit_v;
        r8.PlaceComponentResult = id.dana.R.drawable.bg_dbs_credit_h;
        r8.MyBillsEntityDataFactory = id.dana.R.drawable.ic_dbs_white_logo;
        r8.KClassImpl$Data$declaredNonStaticMembers$2 = id.dana.R.drawable.expresspay_light;
        r8.lookAheadTest = id.dana.R.color.f27072131100488;
        r8 = r8.PlaceComponentResult();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.pay.PayCardViewItem getCreditCard(java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.factory.WalletCardViewItemFactory.getCreditCard(java.lang.String, boolean):id.dana.pay.PayCardViewItem");
    }

    private final PayCardViewItem otherBank(String institutionId) {
        switch (institutionId.hashCode()) {
            case -765273313:
                if (institutionId.equals(Institution.JENIUS)) {
                    PayCardViewItem.Builder PlaceComponentResult = PayCardViewItem.PlaceComponentResult();
                    PlaceComponentResult.getErrorConfigVersion = R.drawable.bg_jenic1id_vertical;
                    PlaceComponentResult.PlaceComponentResult = R.drawable.bg_jenic1id_horizontal;
                    PlaceComponentResult.MyBillsEntityDataFactory = R.drawable.logo_jenic1id;
                    PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                    PlaceComponentResult.lookAheadTest = R.color.f27072131100488;
                    PayCardViewItem PlaceComponentResult2 = PlaceComponentResult.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
                    return PlaceComponentResult2;
                }
                break;
            case -764867979:
                if (institutionId.equals(Institution.HSBC)) {
                    PayCardViewItem PlaceComponentResult3 = HsbcCard.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
                    return PlaceComponentResult3;
                }
                break;
            case -269820658:
                if (institutionId.equals(Institution.BUKOPIN)) {
                    PayCardViewItem PlaceComponentResult4 = BukopinCard.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
                    return PlaceComponentResult4;
                }
                break;
            case -81592318:
                if (institutionId.equals(Institution.STANDARDCHARTERED)) {
                    PayCardViewItem PlaceComponentResult5 = StandardcharteredCard.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult5, "");
                    return PlaceComponentResult5;
                }
                break;
            case 453102289:
                if (institutionId.equals(Institution.UOB)) {
                    PayCardViewItem MyBillsEntityDataFactory = UobCard.MyBillsEntityDataFactory();
                    Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                    return MyBillsEntityDataFactory;
                }
                break;
            case 571440198:
                if (institutionId.equals(Institution.MAYBANK)) {
                    PayCardViewItem authRequestContext = MaybankCard.getAuthRequestContext();
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    return authRequestContext;
                }
                break;
            case 924629541:
                if (institutionId.equals(Institution.BTN)) {
                    PayCardViewItem.Builder PlaceComponentResult6 = PayCardViewItem.PlaceComponentResult();
                    PlaceComponentResult6.getErrorConfigVersion = R.drawable.bg_btnc1id_vertical;
                    PlaceComponentResult6.PlaceComponentResult = R.drawable.bg_btnc1id_horizontal;
                    PlaceComponentResult6.MyBillsEntityDataFactory = R.drawable.logo_btnc1id;
                    PlaceComponentResult6.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
                    PlaceComponentResult6.lookAheadTest = R.color.f23342131099859;
                    PayCardViewItem PlaceComponentResult7 = PlaceComponentResult6.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult7, "");
                    return PlaceComponentResult7;
                }
                break;
            case 976666921:
                if (institutionId.equals(Institution.MNC)) {
                    PayCardViewItem MyBillsEntityDataFactory2 = MncCard.MyBillsEntityDataFactory();
                    Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
                    return MyBillsEntityDataFactory2;
                }
                break;
            case 1529712766:
                if (institutionId.equals(Institution.OCBC)) {
                    PayCardViewItem.Builder PlaceComponentResult8 = PayCardViewItem.PlaceComponentResult();
                    PlaceComponentResult8.getErrorConfigVersion = R.drawable.bg_ocbcc1id_vertical;
                    PlaceComponentResult8.PlaceComponentResult = R.drawable.bg_ocbcc1id_horizontal;
                    PlaceComponentResult8.MyBillsEntityDataFactory = R.drawable.logo_ocbcc1id;
                    PlaceComponentResult8.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                    PlaceComponentResult8.lookAheadTest = R.color.f27072131100488;
                    PayCardViewItem PlaceComponentResult9 = PlaceComponentResult8.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult9, "");
                    return PlaceComponentResult9;
                }
                break;
            case 1560597964:
                if (institutionId.equals(Institution.DANAMON)) {
                    PayCardViewItem.Builder PlaceComponentResult10 = PayCardViewItem.PlaceComponentResult();
                    PlaceComponentResult10.getErrorConfigVersion = R.drawable.bg_bdmnc1id_vertical;
                    PlaceComponentResult10.PlaceComponentResult = R.drawable.bg_bdmnc1id_horizontal;
                    PlaceComponentResult10.MyBillsEntityDataFactory = R.drawable.logo_bdmnc1id;
                    PlaceComponentResult10.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
                    PlaceComponentResult10.lookAheadTest = R.color.f23352131099861;
                    PayCardViewItem PlaceComponentResult11 = PlaceComponentResult10.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult11, "");
                    return PlaceComponentResult11;
                }
                break;
            case 1846606677:
                if (institutionId.equals(Institution.PANIN)) {
                    PayCardViewItem.Builder PlaceComponentResult12 = PayCardViewItem.PlaceComponentResult();
                    PlaceComponentResult12.getErrorConfigVersion = R.drawable.bg_panic1id_vertical;
                    PlaceComponentResult12.PlaceComponentResult = R.drawable.bg_panic1id_horizontal;
                    PlaceComponentResult12.MyBillsEntityDataFactory = R.drawable.logo_panic1id;
                    PlaceComponentResult12.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                    PlaceComponentResult12.lookAheadTest = R.color.f27072131100488;
                    PayCardViewItem PlaceComponentResult13 = PlaceComponentResult12.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult13, "");
                    return PlaceComponentResult13;
                }
                break;
            case 1872811166:
                if (institutionId.equals(Institution.SINARMAS)) {
                    PayCardViewItem.Builder PlaceComponentResult14 = PayCardViewItem.PlaceComponentResult();
                    PlaceComponentResult14.getErrorConfigVersion = R.drawable.bg_bsimc1id_vertical;
                    PlaceComponentResult14.PlaceComponentResult = R.drawable.bg_bsimc1id_horizontal;
                    PlaceComponentResult14.MyBillsEntityDataFactory = R.drawable.logo_bsimc1id;
                    PlaceComponentResult14.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                    PlaceComponentResult14.lookAheadTest = R.color.f27072131100488;
                    PayCardViewItem PlaceComponentResult15 = PlaceComponentResult14.PlaceComponentResult();
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult15, "");
                    return PlaceComponentResult15;
                }
                break;
        }
        PayCardViewItem PlaceComponentResult16 = PayCardViewItem.MyBillsEntityDataFactory().PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult16, "");
        return PlaceComponentResult16;
    }
}
