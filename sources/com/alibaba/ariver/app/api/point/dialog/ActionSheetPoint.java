package com.alibaba.ariver.app.api.point.dialog;

import android.app.Dialog;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface ActionSheetPoint extends Extension {
    Dialog getActionSheet(CreateActionSheetParam createActionSheetParam);

    void onRelease();

    void updateActionSheetContent(ArrayList<String> arrayList);
}
