package id.dana.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class DialogPermission_ViewBinding implements Unbinder {
    private DialogPermission KClassImpl$Data$declaredNonStaticMembers$2;

    public DialogPermission_ViewBinding(DialogPermission dialogPermission, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dialogPermission;
        dialogPermission.btnCheckPermission = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_check_permission, "field 'btnCheckPermission'", Button.class);
        dialogPermission.btnCheckPermissionHorizontal = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_check_permission_horizontal, "field 'btnCheckPermissionHorizontal'", Button.class);
        dialogPermission.btnNotNowHorizontal = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_not_now_horizontal, "field 'btnNotNowHorizontal'", Button.class);
        dialogPermission.ivPermission = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_permission, "field 'ivPermission'", ImageView.class);
        dialogPermission.tvAdditionalText = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_additional_text, "field 'tvAdditionalText'", TextView.class);
        dialogPermission.tvPermissionDesc = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_permission_desc, "field 'tvPermissionDesc'", TextView.class);
        dialogPermission.tvPermissionTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_permission_title, "field 'tvPermissionTitle'", TextView.class);
        dialogPermission.btnNotNow = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_not_now, "field 'btnNotNow'", Button.class);
        dialogPermission.btnHorizontalGroup = (Group) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_horizontal_group, "field 'btnHorizontalGroup'", Group.class);
        dialogPermission.btnVerticalGroup = (Group) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_vertical_group, "field 'btnVerticalGroup'", Group.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DialogPermission dialogPermission = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (dialogPermission == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        dialogPermission.btnCheckPermission = null;
        dialogPermission.btnCheckPermissionHorizontal = null;
        dialogPermission.btnNotNowHorizontal = null;
        dialogPermission.ivPermission = null;
        dialogPermission.tvAdditionalText = null;
        dialogPermission.tvPermissionDesc = null;
        dialogPermission.tvPermissionTitle = null;
        dialogPermission.btnNotNow = null;
        dialogPermission.btnHorizontalGroup = null;
        dialogPermission.btnVerticalGroup = null;
    }
}
