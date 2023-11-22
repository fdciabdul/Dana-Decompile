package id.dana.data.h5event.changephone;

import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0006*\u00020\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR*\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/h5event/changephone/ChangePhoneNumberEventManager;", "", "Lid/dana/data/h5event/changephone/ChangePhoneFinishEntity;", "changePhoneFinishEntity", "", "processEvent", "(Lid/dana/data/h5event/changephone/ChangePhoneFinishEntity;)V", "", "TAG", "Ljava/lang/String;", "Lid/dana/data/h5event/changephone/ChangePhoneNumberEventManager$ChangePhoneFinishCallback;", "changePhoneFinishCallback", "Lid/dana/data/h5event/changephone/ChangePhoneNumberEventManager$ChangePhoneFinishCallback;", "getChangePhoneFinishCallback", "()Lid/dana/data/h5event/changephone/ChangePhoneNumberEventManager$ChangePhoneFinishCallback;", "setChangePhoneFinishCallback", "(Lid/dana/data/h5event/changephone/ChangePhoneNumberEventManager$ChangePhoneFinishCallback;)V", "getChangePhoneFinishCallback$annotations", "()V", "<init>", "ChangePhoneFinishCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChangePhoneNumberEventManager {
    public static final ChangePhoneNumberEventManager INSTANCE = new ChangePhoneNumberEventManager();
    private static final String TAG = "ChangePhoneNumberEventManager";
    private static ChangePhoneFinishCallback changePhoneFinishCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/h5event/changephone/ChangePhoneNumberEventManager$ChangePhoneFinishCallback;", "", "Lid/dana/data/h5event/changephone/ChangePhoneFinishEntity;", "result", "", "onChangePhoneFinished", "(Lid/dana/data/h5event/changephone/ChangePhoneFinishEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface ChangePhoneFinishCallback {
        void onChangePhoneFinished(ChangePhoneFinishEntity result);
    }

    @JvmStatic
    public static /* synthetic */ void getChangePhoneFinishCallback$annotations() {
    }

    private ChangePhoneNumberEventManager() {
    }

    @JvmName(name = "getChangePhoneFinishCallback")
    public static final ChangePhoneFinishCallback getChangePhoneFinishCallback() {
        return changePhoneFinishCallback;
    }

    @JvmName(name = "setChangePhoneFinishCallback")
    public static final void setChangePhoneFinishCallback(ChangePhoneFinishCallback changePhoneFinishCallback2) {
        changePhoneFinishCallback = changePhoneFinishCallback2;
    }

    @JvmStatic
    public static final void processEvent(ChangePhoneFinishEntity changePhoneFinishEntity) {
        String str = TAG;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(changePhoneFinishCallback != null);
        String format = String.format("checkout finish callback exist: %s", Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        DanaLog.MyBillsEntityDataFactory(str, format);
        Object[] objArr2 = new Object[1];
        objArr2[0] = Boolean.valueOf(changePhoneFinishEntity != null);
        String format2 = String.format("checkout finish entity exists: %s", Arrays.copyOf(objArr2, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        DanaLog.MyBillsEntityDataFactory(str, format2);
        ChangePhoneFinishCallback changePhoneFinishCallback2 = changePhoneFinishCallback;
        if (changePhoneFinishCallback2 != null) {
            changePhoneFinishCallback2.onChangePhoneFinished(changePhoneFinishEntity);
        }
        changePhoneFinishCallback = null;
    }
}
