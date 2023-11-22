package id.dana.sendmoney.ui.groupsend.recipient.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.sendmoney.databinding.ActivityGroupRecipientBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\r\u001a\u00020\f@\u0007X\u0086\n¢\u0006\f\n\u0004\b\u000f\u0010\u0010\"\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/util/GroupRecipientKeyboardHelper;", "", "Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;", "p0", "", "getAuthRequestContext", "(Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;)V", "Landroid/app/Activity;", "Landroid/view/MotionEvent;", "p1", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;Landroid/app/Activity;Landroid/view/MotionEvent;)V", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;Landroid/view/MotionEvent;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "(Z)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupRecipientKeyboardHelper {
    public static final GroupRecipientKeyboardHelper INSTANCE = new GroupRecipientKeyboardHelper();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static boolean MyBillsEntityDataFactory;

    private GroupRecipientKeyboardHelper() {
    }

    public static boolean MyBillsEntityDataFactory(ActivityGroupRecipientBinding activityGroupRecipientBinding, MotionEvent motionEvent) {
        return MyBillsEntityDataFactory && activityGroupRecipientBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.isClearImageViewRect((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && motionEvent.getAction() == 0;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ActivityGroupRecipientBinding activityGroupRecipientBinding, Activity activity, MotionEvent motionEvent) {
        View findFocus = activityGroupRecipientBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.findFocus();
        EditText editText = findFocus instanceof EditText ? (EditText) findFocus : null;
        if (editText != null) {
            Rect rect = new Rect();
            editText.getGlobalVisibleRect(rect);
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                return;
            }
            editText.clearFocus();
            KeyboardHelper.PlaceComponentResult(activity);
        }
    }

    public static void getAuthRequestContext(ActivityGroupRecipientBinding p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.util.GroupRecipientKeyboardHelper$setupKeyboardListener$1
            @Override // id.dana.core.ui.util.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                GroupRecipientKeyboardHelper groupRecipientKeyboardHelper = GroupRecipientKeyboardHelper.INSTANCE;
                GroupRecipientKeyboardHelper.MyBillsEntityDataFactory = true;
            }

            @Override // id.dana.core.ui.util.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                GroupRecipientKeyboardHelper groupRecipientKeyboardHelper = GroupRecipientKeyboardHelper.INSTANCE;
                GroupRecipientKeyboardHelper.MyBillsEntityDataFactory = false;
            }
        });
    }
}
