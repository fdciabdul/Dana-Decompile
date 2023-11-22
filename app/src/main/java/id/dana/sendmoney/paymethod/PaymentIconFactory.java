package id.dana.sendmoney.paymethod;

import id.dana.R;
import id.dana.domain.payasset.model.CardScheme;
import id.dana.domain.payasset.model.Institution;

/* loaded from: classes5.dex */
public class PaymentIconFactory {
    private PaymentIconFactory() {
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (str != null) {
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
                case -653221436:
                    if (str.equals(Institution.CITIBANK)) {
                        c = 3;
                        break;
                    }
                    break;
                case -604796681:
                    if (str.equals(Institution.MANDIRI)) {
                        c = 4;
                        break;
                    }
                    break;
                case 425928201:
                    if (str.equals(Institution.BCA)) {
                        c = 5;
                        break;
                    }
                    break;
                case 748237030:
                    if (str.equals(Institution.BNI)) {
                        c = 6;
                        break;
                    }
                    break;
                case 862753634:
                    if (str.equals(Institution.BRI)) {
                        c = 7;
                        break;
                    }
                    break;
                case 924629541:
                    if (str.equals(Institution.BTN)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1295109578:
                    if (str.equals(Institution.BCA_ONEKLIK)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1529712766:
                    if (str.equals(Institution.OCBC)) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1560597964:
                    if (str.equals(Institution.DANAMON)) {
                        c = 11;
                        break;
                    }
                    break;
                case 1812453426:
                    if (str.equals(Institution.PERMATA)) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1846606677:
                    if (str.equals(Institution.PANIN)) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1872811166:
                    if (str.equals(Institution.SINARMAS)) {
                        c = 14;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return R.drawable.ic_bank_dbsc1id_mini;
                case 1:
                    return R.drawable.ic_bank_cimbc1id_mini;
                case 2:
                    return R.drawable.ic_bank_jenic1id_mini;
                case 3:
                    return R.drawable.ic_bank_citic1id_mini;
                case 4:
                    return R.drawable.ic_bank_mdric1d_mini;
                case 5:
                case '\t':
                    return R.drawable.ic_bank_bcac1id_mini;
                case 6:
                    return R.drawable.ic_bank_bnic1id_mini;
                case 7:
                    return R.drawable.ic_bank_bric1id_mini;
                case '\b':
                    return R.drawable.ic_bank_btnc1id_mini;
                case '\n':
                    return R.drawable.ic_bank_ocbcc1id_mini;
                case 11:
                    return R.drawable.ic_bank_bdmnc1id_mini;
                case '\f':
                    return R.drawable.ic_bank_permatac1id_mini;
                case '\r':
                    return R.drawable.ic_paninc1id_mini;
                case 14:
                    return R.drawable.ic_bank_sinarmasc1id_mini;
                default:
                    return R.drawable.defaultbank_mini;
            }
        }
        return R.drawable.defaultbank_mini;
    }

    public static int getAuthRequestContext(String str) {
        if (str != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1934979172:
                    if (str.equals(CardScheme.VISA)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1062451836:
                    if (str.equals(CardScheme.JCB)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1003810246:
                    if (str.equals(CardScheme.AMERICAN_EXPRESS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 70789:
                    if (str.equals(CardScheme.GPN)) {
                        c = 3;
                        break;
                    }
                    break;
                case 425933967:
                    if (str.equals(CardScheme.BCA)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1067049040:
                    if (str.equals(CardScheme.MASTERCARD)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            return c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c != 5 ? R.drawable.defaultbank_mini : R.drawable.mastercard_with_border : R.drawable.ic_card_payment_bca : R.drawable.gpn_with_border : R.drawable.american_express_with_border : R.drawable.jcb_with_border : R.drawable.visa_with_border;
        }
        return R.drawable.defaultbank_mini;
    }

    public static int MyBillsEntityDataFactory(String str) {
        if (str != null) {
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
                    return R.drawable.ic_card_payment_dbs;
                case 1:
                    return R.drawable.ic_card_payment_cimb;
                case 2:
                    return R.drawable.ic_card_payment_jenius;
                case 3:
                    return R.drawable.ic_card_payment_hsbc;
                case 4:
                    return R.drawable.ic_card_payment_citibank;
                case 5:
                    return R.drawable.ic_card_payment_mandiri;
                case 6:
                    return R.drawable.ic_card_payment_bukopin;
                case 7:
                    return R.drawable.ic_card_payment_standard_chartered;
                case '\b':
                case 16:
                    return R.drawable.ic_card_payment_bca;
                case '\t':
                    return R.drawable.ic_card_payment_uob;
                case '\n':
                    return R.drawable.ic_card_payment_maybank;
                case 11:
                    return R.drawable.ic_card_payment_mega;
                case '\f':
                    return R.drawable.ic_card_payment_bni;
                case '\r':
                    return R.drawable.ic_card_payment_bri;
                case 14:
                    return R.drawable.ic_card_payment_btn;
                case 15:
                    return R.drawable.ic_card_payment_mnc;
                case 17:
                    return R.drawable.ic_card_payment_ocbc;
                case 18:
                    return R.drawable.ic_card_payment_danamon;
                case 19:
                    return R.drawable.ic_card_payment_permata;
                case 20:
                    return R.drawable.ic_card_payment_panin_bank;
                case 21:
                    return R.drawable.ic_card_payment_sinarmas;
                default:
                    return R.drawable.ic_default_card_v2;
            }
        }
        return R.drawable.ic_default_card_v2;
    }
}
