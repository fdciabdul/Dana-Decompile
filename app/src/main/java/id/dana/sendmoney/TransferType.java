package id.dana.sendmoney;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface TransferType {
    public static final String ATM_TRANSFER = "ATM_TRANSFER";
    public static final String BALANCE = "BALANCE";
    public static final String BANK = "BANK_TRANSFER";
    public static final String LINK = "LINK";
    public static final String OTC = "OTC";
    public static final String SINGLE_GENERAL_TRANSFER = "SINGLE_GENERAL_TRANSFER";
}
