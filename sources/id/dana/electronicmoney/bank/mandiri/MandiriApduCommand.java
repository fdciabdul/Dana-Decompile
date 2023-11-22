package id.dana.electronicmoney.bank.mandiri;

import android.nfc.tech.IsoDep;
import android.os.Build;
import id.dana.electronicmoney.bank.mandiri.constants.MandiriApdu;
import id.dana.electronicmoney.base.ApduCommand;
import id.dana.electronicmoney.util.ElectronicMoneyUtils;
import id.dana.extension.IOExtKt;
import id.dana.utils.log.CrashlyticsLogUtil;
import j$.time.LocalDateTime;
import j$.time.format.DateTimeFormatter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0014\u0010\u0007\u001a\u00020\u000b8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "Lid/dana/electronicmoney/base/ApduCommand;", "", "p0", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "PlaceComponentResult", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "", "()Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "Landroid/nfc/tech/IsoDep;", "<init>", "(Landroid/nfc/tech/IsoDep;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MandiriApduCommand extends ApduCommand {
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public static int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 15000;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MandiriApduCommand(IsoDep isoDep) {
        super(isoDep);
        Intrinsics.checkNotNullParameter(isoDep, "");
    }

    @JvmName(name = "getAuthRequestContext")
    public final boolean getAuthRequestContext() {
        return Intrinsics.areEqual(PlaceComponentResult(MandiriApdu.EMONEY_AVAILABILITY), "9000");
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final String BuiltInFictitiousFunctionClassFactory() {
        String PlaceComponentResult = PlaceComponentResult(MandiriApdu.CARD_UID);
        if (Intrinsics.areEqual(StringsKt.takeLast(PlaceComponentResult, 4), "9000")) {
            return PlaceComponentResult;
        }
        ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
        byte[] id2 = getGetAuthRequestContext().getTag().getId();
        Intrinsics.checkNotNullExpressionValue(id2, "");
        return ElectronicMoneyUtils.PlaceComponentResult(id2);
    }

    public final String MyBillsEntityDataFactory(String p0, String p1) {
        String format;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        try {
            StringBuilder sb = new StringBuilder();
            if (!getGetAuthRequestContext().isConnected()) {
                getGetAuthRequestContext().connect();
            }
            String dropLast = StringsKt.dropLast(PlaceComponentResult(MandiriApdu.CERTIFICATE), 4);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MandiriApdu.DATA_TO_CREATE_SAM);
            sb2.append("46");
            StringBuilder sb3 = new StringBuilder();
            Intrinsics.checkNotNullParameter("ddmmyyhhmmss", "");
            if (Build.VERSION.SDK_INT >= 26) {
                format = LocalDateTime.now().format(DateTimeFormatter.MyBillsEntityDataFactory("ddmmyyhhmmss"));
                Intrinsics.checkNotNullExpressionValue(format, "");
            } else {
                format = new SimpleDateFormat("ddmmyyhhmmss").format(new Date());
                Intrinsics.checkNotNullExpressionValue(format, "");
            }
            sb3.append(format);
            sb3.append("0000000000000000");
            sb3.append("000000000000");
            sb3.append(p0);
            sb3.append("0000000000000000");
            sb3.append("00000000000000000000");
            ByteBuffer putInt = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(Integer.parseInt(p1));
            ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
            byte[] array = putInt.array();
            Intrinsics.checkNotNullExpressionValue(array, "");
            sb3.append(ElectronicMoneyUtils.PlaceComponentResult(array));
            sb3.append("0000000000000000000000000000000000000000");
            String obj = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            sb2.append(obj);
            String obj2 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            sb.append(StringsKt.dropLast(PlaceComponentResult(obj2), 4));
            sb.append(dropLast);
            String obj3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj3, "");
            return obj3;
        } catch (Exception e) {
            CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory("mandiri_apdu_command_fail", "[GetDataToSam]", e);
            IOExtKt.getAuthRequestContext(getGetAuthRequestContext());
            return "";
        }
    }

    @JvmName(name = "PlaceComponentResult")
    public final String PlaceComponentResult() {
        String PlaceComponentResult = PlaceComponentResult(MandiriApdu.LAST_BALANCE);
        if (Intrinsics.areEqual(StringsKt.takeLast(PlaceComponentResult, 4), "9000")) {
            ElectronicMoneyUtils electronicMoneyUtils = ElectronicMoneyUtils.INSTANCE;
            String substring = PlaceComponentResult.substring(0, 8);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return String.valueOf(ByteBuffer.wrap(ElectronicMoneyUtils.BuiltInFictitiousFunctionClassFactory(substring)).order(ByteOrder.LITTLE_ENDIAN).getInt());
        }
        return PlaceComponentResult;
    }
}
