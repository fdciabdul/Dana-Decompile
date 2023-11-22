package id.co.bri.brizzi.exception;

/* loaded from: classes8.dex */
public class ExceptionList {
    public static final String apiParamsEmpty = "64";
    public static final String cardReadFailed = "03";
    public static final String closedCard = "06";
    public static final String connectionTimeout = "91";
    public static final String duplicateReffNum = "93";
    public static final String emptyVariable = "92";
    public static final String expiredCard = "08";
    public static final String failedOverTopup = "05";
    public static final String generalError = "99";
    public static final String invalidRandom = "96";
    public static final String invalidResponse = "98";
    public static final String invalidSDKVersion = "97";
    public static final String noNFCOnDevice = "81";
    public static final String notFound = "09";
    public static final String zeroPendingBalance = "04";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(String str) {
        char c;
        str.hashCode();
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == 1544) {
            if (str.equals("08")) {
                c = 4;
            }
            c = 65535;
        } else if (hashCode == 1545) {
            if (str.equals("09")) {
                c = 5;
            }
            c = 65535;
        } else if (hashCode == 1726) {
            if (str.equals("64")) {
                c = 6;
            }
            c = 65535;
        } else if (hashCode != 1785) {
            switch (hashCode) {
                case 1539:
                    if (str.equals("03")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1540:
                    if (str.equals("04")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1541:
                    if (str.equals("05")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1542:
                    if (str.equals("06")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 1816:
                            if (str.equals("91")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1817:
                            if (str.equals("92")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1818:
                            if (str.equals("93")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            switch (hashCode) {
                                case 1821:
                                    if (str.equals("96")) {
                                        c = 11;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1822:
                                    if (str.equals("97")) {
                                        c = '\f';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1823:
                                    if (str.equals("98")) {
                                        c = '\r';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                    }
            }
        } else {
            if (str.equals("81")) {
                c = 7;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return "Card Read Failed";
            case 1:
                return "Zero Pending Balance";
            case 2:
                return "Failed over top up";
            case 3:
                return "Closed Card";
            case 4:
                return "Expired Card";
            case 5:
                return "Card Number Not Found";
            case 6:
                return "API Param Empty";
            case 7:
                return "No NFC On Device";
            case '\b':
                return "Connection Timeout";
            case '\t':
                return "Empty Variable";
            case '\n':
                return "Reff Num Duplikat";
            case 11:
                return "Invalid Random";
            case '\f':
                return "Error SDK Version";
            case '\r':
                return "Invalid Response";
            default:
                return "General Error";
        }
    }
}
