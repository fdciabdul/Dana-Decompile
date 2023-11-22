package id.dana.pay;

import id.dana.R;
import id.dana.domain.payasset.model.Institution;
import id.dana.pay.PayCardViewItem;
import id.dana.pay.card.BukopinCard;
import id.dana.pay.card.HsbcCard;
import id.dana.pay.card.MaybankCard;
import id.dana.pay.card.MegaCard;
import id.dana.pay.card.MncCard;
import id.dana.pay.card.StandardcharteredCard;
import id.dana.pay.card.UobCard;
import id.dana.wallet_v3.factory.WalletCardViewItemFactory;

/* loaded from: classes5.dex */
public class PayCardViewItemFactory {
    private PayCardViewItemFactory() {
        throw new UnsupportedOperationException();
    }

    public static PayCardViewItem getAuthRequestContext(String str, String str2, boolean z) {
        if ("DEBIT_CARD".equals(str2)) {
            return WalletCardViewItemFactory.INSTANCE.getDebitCard(str, z);
        }
        if ("CREDIT_CARD".equals(str2)) {
            return WalletCardViewItemFactory.INSTANCE.getCreditCard(str, z);
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2106037506:
                if (str.equals(Institution.DBS)) {
                    c = 0;
                    break;
                }
                break;
            case -860090140:
                if (str.equals(Institution.CIMB)) {
                    c = 1;
                    break;
                }
                break;
            case -765273313:
                if (str.equals(Institution.JENIUS)) {
                    c = 2;
                    break;
                }
                break;
            case -764867979:
                if (str.equals(Institution.HSBC)) {
                    c = 3;
                    break;
                }
                break;
            case -653221436:
                if (str.equals(Institution.CITIBANK)) {
                    c = 4;
                    break;
                }
                break;
            case -604796681:
                if (str.equals(Institution.MANDIRI)) {
                    c = 5;
                    break;
                }
                break;
            case -269820658:
                if (str.equals(Institution.BUKOPIN)) {
                    c = 6;
                    break;
                }
                break;
            case -81592318:
                if (str.equals(Institution.STANDARDCHARTERED)) {
                    c = 7;
                    break;
                }
                break;
            case 425928201:
                if (str.equals(Institution.BCA)) {
                    c = '\b';
                    break;
                }
                break;
            case 453102289:
                if (str.equals(Institution.UOB)) {
                    c = '\t';
                    break;
                }
                break;
            case 571440198:
                if (str.equals(Institution.MAYBANK)) {
                    c = '\n';
                    break;
                }
                break;
            case 717760837:
                if (str.equals(Institution.MEGA)) {
                    c = 11;
                    break;
                }
                break;
            case 748237030:
                if (str.equals(Institution.BNI)) {
                    c = '\f';
                    break;
                }
                break;
            case 862753634:
                if (str.equals(Institution.BRI)) {
                    c = '\r';
                    break;
                }
                break;
            case 924629541:
                if (str.equals(Institution.BTN)) {
                    c = 14;
                    break;
                }
                break;
            case 976666921:
                if (str.equals(Institution.MNC)) {
                    c = 15;
                    break;
                }
                break;
            case 1295109578:
                if (str.equals(Institution.BCA_ONEKLIK)) {
                    c = 16;
                    break;
                }
                break;
            case 1529712766:
                if (str.equals(Institution.OCBC)) {
                    c = 17;
                    break;
                }
                break;
            case 1560597964:
                if (str.equals(Institution.DANAMON)) {
                    c = 18;
                    break;
                }
                break;
            case 1812453426:
                if (str.equals(Institution.PERMATA)) {
                    c = 19;
                    break;
                }
                break;
            case 1846606677:
                if (str.equals(Institution.PANIN)) {
                    c = 20;
                    break;
                }
                break;
            case 1872811166:
                if (str.equals(Institution.SINARMAS)) {
                    c = 21;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                PayCardViewItem.Builder PlaceComponentResult = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult.getErrorConfigVersion = R.drawable.bg_dbsc1id_vertical;
                PlaceComponentResult.PlaceComponentResult = R.drawable.bg_dbsc1id_horizontal;
                PlaceComponentResult.MyBillsEntityDataFactory = R.drawable.logo_dbsc1id;
                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
                PlaceComponentResult.lookAheadTest = R.color.f23352131099861;
                return PlaceComponentResult.PlaceComponentResult();
            case 1:
                PayCardViewItem.Builder PlaceComponentResult2 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult2.getErrorConfigVersion = R.drawable.bg_cimbc1id_vertical;
                PlaceComponentResult2.PlaceComponentResult = R.drawable.bg_cimbc1id_horizontal;
                PlaceComponentResult2.MyBillsEntityDataFactory = R.drawable.logo_cimbc1id;
                PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult2.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult2.PlaceComponentResult();
            case 2:
                PayCardViewItem.Builder PlaceComponentResult3 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult3.getErrorConfigVersion = R.drawable.bg_jenic1id_vertical;
                PlaceComponentResult3.PlaceComponentResult = R.drawable.bg_jenic1id_horizontal;
                PlaceComponentResult3.MyBillsEntityDataFactory = R.drawable.logo_jenic1id;
                PlaceComponentResult3.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult3.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult3.PlaceComponentResult();
            case 3:
                return HsbcCard.PlaceComponentResult();
            case 4:
                PayCardViewItem.Builder PlaceComponentResult4 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult4.getErrorConfigVersion = R.drawable.bg_citic1id_vectical;
                PlaceComponentResult4.PlaceComponentResult = R.drawable.bg_citic1id_horizontal;
                PlaceComponentResult4.MyBillsEntityDataFactory = R.drawable.logo_citic1id;
                PlaceComponentResult4.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult4.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult4.PlaceComponentResult();
            case 5:
                PayCardViewItem.Builder PlaceComponentResult5 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult5.getErrorConfigVersion = R.drawable.bg_mdric1id_vertical;
                PlaceComponentResult5.PlaceComponentResult = R.drawable.bg_mdric1id_horizontal;
                PlaceComponentResult5.MyBillsEntityDataFactory = R.drawable.logo_mdric1id;
                PlaceComponentResult5.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult5.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult5.PlaceComponentResult();
            case 6:
                return BukopinCard.PlaceComponentResult();
            case 7:
                return StandardcharteredCard.PlaceComponentResult();
            case '\b':
                PayCardViewItem.Builder PlaceComponentResult6 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult6.getErrorConfigVersion = R.drawable.bg_bcac1id_vertical;
                PlaceComponentResult6.PlaceComponentResult = R.drawable.bg_bcac1id_horizontal;
                PlaceComponentResult6.MyBillsEntityDataFactory = R.drawable.logo_bcac1id;
                PlaceComponentResult6.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult6.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult6.PlaceComponentResult();
            case '\t':
                return UobCard.MyBillsEntityDataFactory();
            case '\n':
                return MaybankCard.getAuthRequestContext();
            case 11:
                return MegaCard.KClassImpl$Data$declaredNonStaticMembers$2();
            case '\f':
                PayCardViewItem.Builder PlaceComponentResult7 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult7.getErrorConfigVersion = R.drawable.bg_bnic1id_vertical;
                PlaceComponentResult7.PlaceComponentResult = R.drawable.bg_bnic1id_horizontal;
                PlaceComponentResult7.MyBillsEntityDataFactory = R.drawable.logo_bnic1id;
                PlaceComponentResult7.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult7.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult7.PlaceComponentResult();
            case '\r':
                PayCardViewItem.Builder PlaceComponentResult8 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult8.getErrorConfigVersion = R.drawable.bg_bric1id_vertical;
                PlaceComponentResult8.PlaceComponentResult = R.drawable.bg_bric1id_horizontal;
                PlaceComponentResult8.MyBillsEntityDataFactory = R.drawable.logo_bric1id;
                PlaceComponentResult8.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult8.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult8.PlaceComponentResult();
            case 14:
                PayCardViewItem.Builder PlaceComponentResult9 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult9.getErrorConfigVersion = R.drawable.bg_btnc1id_vertical;
                PlaceComponentResult9.PlaceComponentResult = R.drawable.bg_btnc1id_horizontal;
                PlaceComponentResult9.MyBillsEntityDataFactory = R.drawable.logo_btnc1id;
                PlaceComponentResult9.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
                PlaceComponentResult9.lookAheadTest = R.color.f23342131099859;
                return PlaceComponentResult9.PlaceComponentResult();
            case 15:
                return MncCard.MyBillsEntityDataFactory();
            case 16:
                PayCardViewItem.Builder PlaceComponentResult10 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult10.getErrorConfigVersion = R.drawable.bg_bcac1id_vertical;
                PlaceComponentResult10.PlaceComponentResult = R.drawable.bg_bcac1id_horizontal;
                PlaceComponentResult10.MyBillsEntityDataFactory = R.drawable.logo_bcac1id;
                PlaceComponentResult10.getAuthRequestContext = R.drawable.ic_oneklik_white;
                PlaceComponentResult10.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult10.PlaceComponentResult();
            case 17:
                PayCardViewItem.Builder PlaceComponentResult11 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult11.getErrorConfigVersion = R.drawable.bg_ocbcc1id_vertical;
                PlaceComponentResult11.PlaceComponentResult = R.drawable.bg_ocbcc1id_horizontal;
                PlaceComponentResult11.MyBillsEntityDataFactory = R.drawable.logo_ocbcc1id;
                PlaceComponentResult11.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult11.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult11.PlaceComponentResult();
            case 18:
                PayCardViewItem.Builder PlaceComponentResult12 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult12.getErrorConfigVersion = R.drawable.bg_bdmnc1id_vertical;
                PlaceComponentResult12.PlaceComponentResult = R.drawable.bg_bdmnc1id_horizontal;
                PlaceComponentResult12.MyBillsEntityDataFactory = R.drawable.logo_bdmnc1id;
                PlaceComponentResult12.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
                PlaceComponentResult12.lookAheadTest = R.color.f23352131099861;
                return PlaceComponentResult12.PlaceComponentResult();
            case 19:
                PayCardViewItem.Builder PlaceComponentResult13 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult13.getErrorConfigVersion = R.drawable.bg_bnlic1id_vertical;
                PlaceComponentResult13.PlaceComponentResult = R.drawable.bg_bnlic1id_horizontal;
                PlaceComponentResult13.MyBillsEntityDataFactory = R.drawable.logo_bnlic1id;
                PlaceComponentResult13.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult13.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult13.PlaceComponentResult();
            case 20:
                PayCardViewItem.Builder PlaceComponentResult14 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult14.getErrorConfigVersion = R.drawable.bg_panic1id_vertical;
                PlaceComponentResult14.PlaceComponentResult = R.drawable.bg_panic1id_horizontal;
                PlaceComponentResult14.MyBillsEntityDataFactory = R.drawable.logo_panic1id;
                PlaceComponentResult14.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult14.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult14.PlaceComponentResult();
            case 21:
                PayCardViewItem.Builder PlaceComponentResult15 = PayCardViewItem.PlaceComponentResult();
                PlaceComponentResult15.getErrorConfigVersion = R.drawable.bg_bsimc1id_vertical;
                PlaceComponentResult15.PlaceComponentResult = R.drawable.bg_bsimc1id_horizontal;
                PlaceComponentResult15.MyBillsEntityDataFactory = R.drawable.logo_bsimc1id;
                PlaceComponentResult15.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
                PlaceComponentResult15.lookAheadTest = R.color.f27072131100488;
                return PlaceComponentResult15.PlaceComponentResult();
            default:
                return PayCardViewItem.MyBillsEntityDataFactory().PlaceComponentResult();
        }
    }
}
