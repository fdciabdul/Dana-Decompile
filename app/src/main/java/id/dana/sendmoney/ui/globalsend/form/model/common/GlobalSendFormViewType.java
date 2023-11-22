package id.dana.sendmoney.ui.globalsend.form.model.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormViewType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface GlobalSendFormViewType {
    public static final int ADDRESS_FORM = 18;
    public static final int BANK_ACCOUNT_NO_FORM = 11;
    public static final int BANK_NAME_FORM = 9;
    public static final int BANK_TYPE_FORM = 12;
    public static final int CITY_FORM = 17;
    public static final int COUNTRY_FORM = 4;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final int DEBIT_CARD_NUMBER_FORM = 13;
    public static final int DEFAULT_FORM = 5;
    public static final int DISABLED_TRANSFER_DESTINATION = 14;
    public static final int EMAIL_FORM = 7;
    public static final int ENABLED_TRANSFER_TO_DEBIT = 15;
    public static final int FUND_SOURCE = 0;
    public static final int NOTES = 2;
    public static final int NUMBER_FORM = 8;
    public static final int PROVINCE_FORM = 16;
    public static final int ROUTING_NUMBER_FORM = 10;
    public static final int SPINNER_FORM = 6;
    public static final int TNC = 3;
    public static final int TRANSACTION_PURPOSE = 1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormViewType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
