package id.dana.electronicmoney.bank.mandiri;

import com.alipay.mobile.security.bio.api.BioError;
import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriErrorMessage;
import id.dana.electronicmoney.bank.mandiri.constants.MandiriApdu;
import id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/CardAttributeGenerator;", "", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "p0", "", "p1", "p2", "PlaceComponentResult", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Ljava/lang/String;Ljava/lang/String;)Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "p3", "getAuthRequestContext", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;Ljava/lang/String;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;)Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "MyBillsEntityDataFactory", "(Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;)Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;Ljava/lang/String;)Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CardAttributeGenerator {
    public static final CardAttributeGenerator INSTANCE = new CardAttributeGenerator();

    private CardAttributeGenerator() {
    }

    public static EmoneyCardAttribute PlaceComponentResult(EmoneyCardAttribute p0, String p1, String p2) {
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str2 = !Intrinsics.areEqual(p1, "NEW") ? "" : p2;
        String str3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str3 != null) {
            str = str3.substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = null;
        }
        return new EmoneyCardAttribute("CONFIRM", str2, p1, null, null, str == null ? "" : str, null, null, null, null, null, BioError.RESULT_PAY_FAIL, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x005d, code lost:
    
        if (r13 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0070, code lost:
    
        if (r13 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0072, code lost:
    
        r13 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute getAuthRequestContext(id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute r12, id.dana.electronicmoney.bank.mandiri.MandiriApduCommand r13, java.lang.String r14, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult r15) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.electronicmoney.bank.mandiri.CardAttributeGenerator.getAuthRequestContext(id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute, id.dana.electronicmoney.bank.mandiri.MandiriApduCommand, java.lang.String, id.dana.electronicmoney.bank.mandiri.model.EmoneyApiResult):id.dana.electronicmoney.bank.mandiri.model.EmoneyCardAttribute");
    }

    public static EmoneyCardAttribute MyBillsEntityDataFactory(MandiriApduCommand p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String PlaceComponentResult = p0.PlaceComponentResult(MandiriApdu.CARD_ATTRIBUTE);
        String substring = p0.PlaceComponentResult(MandiriApdu.CARD_INFO).substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return new EmoneyCardAttribute("INQUIRY_BALANCE", null, null, null, PlaceComponentResult, substring, p0.PlaceComponentResult(), p0.PlaceComponentResult(MandiriApdu.CARD_INFO), p0.BuiltInFictitiousFunctionClassFactory(), null, null, 1550, null);
    }

    public static EmoneyCardAttribute BuiltInFictitiousFunctionClassFactory(EmoneyCardAttribute p0, MandiriApduCommand p1, String p2) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        String str3 = p0.getAuthRequestContext;
        String str4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str4 != null) {
            str = str4.substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = null;
        }
        String str5 = str == null ? "" : str;
        String str6 = p0.moveToNextValue;
        String PlaceComponentResult = p1.PlaceComponentResult(MandiriApdu.CARD_INFO);
        String str7 = p0.getErrorConfigVersion;
        if (Intrinsics.areEqual(p2, "NEW")) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringsKt.dropLast(p1.PlaceComponentResult(MandiriApdu.REVERSAL_DATA_TO_CREATE_SAM), 4));
            sb.append(StringsKt.dropLast(p1.PlaceComponentResult(MandiriApdu.CERTIFICATE), 4));
            str2 = sb.toString();
        } else {
            str2 = "";
        }
        return new EmoneyCardAttribute(EmoneyMandiriErrorMessage.REVERSAL, null, p2, null, str3, str5, str6, PlaceComponentResult, str7, str2, null, 1034, null);
    }
}
