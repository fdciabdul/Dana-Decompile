package id.dana.sendmoney.recipient;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface RecipientIdType {
    public static final String INSTITUTION = "inst";
    public static final String PHONENUMBER = "phonenumber";
    public static final String USERID = "userid";
}
