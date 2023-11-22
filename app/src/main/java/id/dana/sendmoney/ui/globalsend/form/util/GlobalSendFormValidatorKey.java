package id.dana.sendmoney.ui.globalsend.form.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0002\u0002\u0003B\u0000"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/util/GlobalSendFormValidatorKey;", "", "ReceiverForm", "TransferDestination"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface GlobalSendFormValidatorKey {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/util/GlobalSendFormValidatorKey$ReceiverForm;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class ReceiverForm {
        public static final ReceiverForm INSTANCE = new ReceiverForm();

        private ReceiverForm() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/util/GlobalSendFormValidatorKey$TransferDestination;", "", "<init>", "()V", "ToDebitCard"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class TransferDestination {
        public static final TransferDestination INSTANCE = new TransferDestination();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/util/GlobalSendFormValidatorKey$TransferDestination$ToDebitCard;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes9.dex */
        public static final class ToDebitCard {
            public static final ToDebitCard INSTANCE = new ToDebitCard();

            private ToDebitCard() {
            }
        }

        private TransferDestination() {
        }
    }
}
