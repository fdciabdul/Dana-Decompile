package id.dana.permissionprompt.mapper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.permissionprompt.constant.PermissionPromptSource;
import id.dana.permissionprompt.model.PermissionPromptContentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/permissionprompt/mapper/PermissionPromptContentMapper;", "", "Landroid/content/Context;", "p0", "", "p1", "Lid/dana/permissionprompt/model/PermissionPromptContentModel;", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)Lid/dana/permissionprompt/model/PermissionPromptContentModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionPromptContentMapper {
    public static final PermissionPromptContentMapper INSTANCE = new PermissionPromptContentMapper();

    private PermissionPromptContentMapper() {
    }

    public static PermissionPromptContentModel PlaceComponentResult(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        int hashCode = p1.hashCode();
        if (hashCode != 36608773) {
            if (hashCode != 1030432420) {
                if (hashCode == 1132954547 && p1.equals(PermissionPromptSource.IMAGE_CAPTURE_GALLERY)) {
                    Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(p0, (int) R.drawable.ic_gallery_prompt);
                    String string = p0.getString(R.string.gallery_permission_prompt_image_capture_title);
                    String string2 = p0.getString(R.string.gallery_permission_prompt_image_capture_desc);
                    String string3 = p0.getString(R.string.image_capture_bottom_sheet_gallery_permission);
                    String string4 = p0.getString(R.string.image_capture_bottom_sheet_lbl_title_gallery);
                    String string5 = p0.getString(R.string.image_capture_bottom_sheet_lbl_desc_gallery);
                    String string6 = p0.getString(R.string.image_capture_bottom_sheet_btn_allow_gallery);
                    String string7 = p0.getString(R.string.image_capture_bottom_sheet_btn_later_gallery);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    Intrinsics.checkNotNullExpressionValue(string5, "");
                    Intrinsics.checkNotNullExpressionValue(string6, "");
                    Intrinsics.checkNotNullExpressionValue(string7, "");
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    return new PermissionPromptContentModel(PlaceComponentResult, string, string2, string4, string5, string6, string7, string3);
                }
            } else if (p1.equals(PermissionPromptSource.IMAGE_CAPTURE_CAMERA)) {
                Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(p0, (int) R.drawable.ic_camera_prompt);
                String string8 = p0.getString(R.string.camera_permission_prompt_image_capture_title);
                String string9 = p0.getString(R.string.camera_permission_prompt_image_capture_desc);
                String string10 = p0.getString(R.string.image_capture_bottom_sheet_camera_permission);
                String string11 = p0.getString(R.string.image_capture_bottom_sheet_lbl_title_camera);
                String string12 = p0.getString(R.string.image_capture_bottom_sheet_lbl_desc_camera);
                String string13 = p0.getString(R.string.image_capture_bottom_sheet_btn_allow_camera);
                String string14 = p0.getString(R.string.image_capture_bottom_sheet_btn_later_camera);
                Intrinsics.checkNotNullExpressionValue(string8, "");
                Intrinsics.checkNotNullExpressionValue(string9, "");
                Intrinsics.checkNotNullExpressionValue(string11, "");
                Intrinsics.checkNotNullExpressionValue(string12, "");
                Intrinsics.checkNotNullExpressionValue(string13, "");
                Intrinsics.checkNotNullExpressionValue(string14, "");
                Intrinsics.checkNotNullExpressionValue(string10, "");
                return new PermissionPromptContentModel(PlaceComponentResult2, string8, string9, string11, string12, string13, string14, string10);
            }
        } else if (p1.equals(PermissionPromptSource.NEARBY_WIDGET)) {
            Drawable PlaceComponentResult3 = ContextCompat.PlaceComponentResult(p0, (int) R.drawable.ic_location_prompt_nearby_widget);
            String string15 = p0.getString(R.string.location_permission_prompt_nearby_title);
            Intrinsics.checkNotNullExpressionValue(string15, "");
            String string16 = p0.getString(R.string.location_permission_prompt_nearby_desc);
            Intrinsics.checkNotNullExpressionValue(string16, "");
            String string17 = p0.getString(R.string.txt_title_nearby_location);
            Intrinsics.checkNotNullExpressionValue(string17, "");
            return new PermissionPromptContentModel(PlaceComponentResult3, string15, string16, string17, null, null, null, null, 240, null);
        }
        Drawable PlaceComponentResult4 = ContextCompat.PlaceComponentResult(p0, (int) R.drawable.ic_location_prompt_home);
        String string18 = p0.getString(R.string.location_permission_prompt_home_title);
        Intrinsics.checkNotNullExpressionValue(string18, "");
        String string19 = p0.getString(R.string.location_permission_prompt_home_desc);
        Intrinsics.checkNotNullExpressionValue(string19, "");
        String string20 = p0.getString(R.string.txt_title_home_location);
        Intrinsics.checkNotNullExpressionValue(string20, "");
        return new PermissionPromptContentModel(PlaceComponentResult4, string18, string19, string20, null, null, null, null, 240, null);
    }
}
