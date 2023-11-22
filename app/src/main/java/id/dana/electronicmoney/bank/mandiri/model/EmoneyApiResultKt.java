package id.dana.electronicmoney.bank.mandiri.model;

import id.dana.electronicmoney.bank.mandiri.MandiriApduCommand;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import id.dana.electronicmoney.bank.mandiri.applet.CardApplet;
import id.dana.electronicmoney.bank.mandiri.applet.NewApplet;
import id.dana.electronicmoney.bank.mandiri.applet.OldApplet;
import id.dana.electronicmoney.bank.mandiri.constants.EmoneyMandiriCardType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a)\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;", "", "MyBillsEntityDataFactory", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;)Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "p0", "Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;", "p1", "Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "p2", "Lid/dana/electronicmoney/bank/mandiri/applet/CardApplet;", "getAuthRequestContext", "(Lid/dana/electronicmoney/bank/mandiri/model/EmoneyApiResult;Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;Lid/dana/electronicmoney/bank/mandiri/MandiriApduCommand;Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;)Lid/dana/electronicmoney/bank/mandiri/applet/CardApplet;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmoneyApiResultKt {
    public static final String MyBillsEntityDataFactory(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.getAuthRequestContext;
        return str == null ? "" : str;
    }

    public static final String PlaceComponentResult(EmoneyApiResult emoneyApiResult) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        String str = emoneyApiResult.PlaceComponentResult.get("amount");
        return str == null ? emoneyApiResult.PlaceComponentResult.get("pendingTopup") : str;
    }

    public static final CardApplet getAuthRequestContext(EmoneyApiResult emoneyApiResult, MandiriEmoneyManager mandiriEmoneyManager, MandiriApduCommand mandiriApduCommand, EmoneyCardAttribute emoneyCardAttribute) {
        Intrinsics.checkNotNullParameter(emoneyApiResult, "");
        Intrinsics.checkNotNullParameter(mandiriEmoneyManager, "");
        Intrinsics.checkNotNullParameter(mandiriApduCommand, "");
        Intrinsics.checkNotNullParameter(emoneyCardAttribute, "");
        if (Intrinsics.areEqual(emoneyApiResult.lookAheadTest, EmoneyMandiriCardType.OLD)) {
            return new OldApplet(mandiriEmoneyManager, emoneyCardAttribute, mandiriApduCommand);
        }
        return new NewApplet(mandiriEmoneyManager, emoneyCardAttribute, mandiriApduCommand);
    }
}
