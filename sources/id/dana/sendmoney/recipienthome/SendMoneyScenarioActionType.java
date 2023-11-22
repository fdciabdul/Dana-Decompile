package id.dana.sendmoney.recipienthome;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface SendMoneyScenarioActionType {
    public static final String BANK = "bank";
    public static final String CHAT = "chat";
    public static final String EXTERNAL = "external";
    public static final String GLOBAL = "globalTransfer";
    public static final String GROUP = "group";
    public static final String OTHER = "other";
    public static final String OUTLET = "outlet";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String SALDO_DIGITAL = "saldoDigital";
}
