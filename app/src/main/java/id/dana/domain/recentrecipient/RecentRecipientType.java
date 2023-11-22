package id.dana.domain.recentrecipient;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface RecentRecipientType {
    public static final int BANK = 1;
    public static final int CONTACT = 0;
    public static final int GROUP_BANK = 3;
    public static final int GROUP_CONTACT = 2;
}
