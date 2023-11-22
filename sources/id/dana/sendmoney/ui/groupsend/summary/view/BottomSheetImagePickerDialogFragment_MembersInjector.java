package id.dana.sendmoney.ui.groupsend.summary.view;

import dagger.MembersInjector;
import id.dana.sendmoney.util.GroupSendTrackerHelper;

/* loaded from: classes5.dex */
public final class BottomSheetImagePickerDialogFragment_MembersInjector implements MembersInjector<BottomSheetImagePickerDialogFragment> {
    public static void PlaceComponentResult(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment, GroupSendTrackerHelper groupSendTrackerHelper) {
        bottomSheetImagePickerDialogFragment.groupSendTrackerHelper = groupSendTrackerHelper;
    }
}
