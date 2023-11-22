package id.dana.sendmoney.recipient;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface RecipientType {
    public static final String BANK = "bank";
    public static final String CONTACT = "contact";
    public static final String GROUP_BANK = "groupBank";
    public static final String GROUP_CONTACT = "groupContact";
    public static final String LINK = "link";
    public static final String OTC = "otc";
    public static final String RECENT_CONTACTS = "recentContacts";
    public static final String SCANNER = "scanner";
}
