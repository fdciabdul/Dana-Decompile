package id.dana.mybills.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/tracker/MyBillsTrackerKey;", "", "MyBillsEvent", "MyBillsProperties"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface MyBillsTrackerKey {

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/mybills/tracker/MyBillsTrackerKey$MyBillsEvent;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface MyBillsEvent {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
        public static final String MY_BILLS_BUTTON_ACTION = "Subscription List Button Action";
        public static final String MY_BILLS_CONFIRMATION_ACTION = "Bill Confirmation Action";
        public static final String MY_BILLS_CREATE_DETAIL_OPEN = "Subscription Create Detail Open";
        public static final String MY_BILLS_CREATE_SUCCESS = "Bill Create Success";
        public static final String MY_BILLS_EDIT_ACTION = "Bill Edit Action";
        public static final String MY_BILLS_LIST_OPEN = "Bill List Open";
        public static final String MY_BILLS_PAYMENT_RESULT = "Bill Payment Result";
        public static final String MY_BILLS_PRODUCT_RESULT = "Check Product ID Result";
        public static final String MY_BILLS_RECENT_BILL_BUTTON_ACTION = "Recent Bill Button Action";
        public static final String MY_BILLS_SERVICE_SELECTION = "Subscription Service Selection";
        public static final String MY_BILLS_SUBSCRIPTION_BUTTON_ACTION = "Subscription Detail Button Action";
        public static final String MY_BILLS_SUBSCRIPTION_DETAIL_OPEN = "Subscription Detail Open";
        public static final String MY_BILLS_SUBSCRIPTION_LIST_OPEN = "Subscription List Open";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/tracker/MyBillsTrackerKey$MyBillsEvent$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        public static final class Companion {
            static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

            private Companion() {
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/mybills/tracker/MyBillsTrackerKey$MyBillsProperties;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface MyBillsProperties {
        public static final String ACTION = "Action";
        public static final String BILL_FAILED = "BillFailed";
        public static final String BILL_SUCCESS = "BillSuccess";
        public static final String BILL_TYPE = "Bill Type";
        public static final String CHECK_STATUS = "Check Status";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.getAuthRequestContext;
        public static final String FREQUENCY = "Frequency";
        public static final String GOODS_TYPE = "Goods Type";
        public static final String IS_PAYMENT = "isPayment";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String PAYMENT_METHOD = "Payment Method";
        public static final String PRODUCT_NAME = "Product Name";
        public static final String PROVIDER_NAME = "Provider Name";
        public static final String PURPOSE = "Purpose";
        public static final String REMINDER_BILL = "ReminderBill";
        public static final String RESULT_OPEN = "Result Open";
        public static final String SERVICES_NAME = "Services Name";
        public static final String SERVICE_NAME = "Service Name";
        public static final String SOURCE = "Source";
        public static final String STATUS = "Status";
        public static final String SUBSCRIPTION_BILL = "SubscriptionBill";
        public static final String SUBSCRIPTION_ID = "Subscription ID";
        public static final String SUBSCRIPTION_TYPE = "Subscription Type";
        public static final String SUM_BILLS = "Sum Bills";
        public static final String TOTAL_BILL = "Total Bill";
        public static final String TOTAL_EXECUTION_TIME = "Total Execution Time";
        public static final String TYPE = "Type";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/tracker/MyBillsTrackerKey$MyBillsProperties$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        public static final class Companion {
            static final /* synthetic */ Companion getAuthRequestContext = new Companion();

            private Companion() {
            }
        }
    }
}
