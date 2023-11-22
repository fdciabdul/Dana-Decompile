package id.dana.base;

import com.alibaba.griver.api.constants.GriverEvents;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0006J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0019\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/base/MenuItemFacade;", "", "", "icon", "", "setMenuLeftButton", "(I)V", "", "leftButtonText", "(Ljava/lang/String;)V", "contentDescription", "setMenuLeftContentDescription", "setMenuRightButton", "rightButtonText", "setMenuRightButtonContentDescription", "", Constants.ENABLE_DISABLE, "setMenuRightButtonEnabled", "(Z)V", "isProgress", "setMenuRightProgressBar", "title", GriverEvents.EVENT_SET_TITLE, "drawableRes", "setToolbarImage", "setToolbarTitleContentDescription"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MenuItemFacade {
    void setMenuLeftButton(int icon);

    void setMenuLeftButton(String leftButtonText);

    void setMenuLeftContentDescription(String contentDescription);

    void setMenuRightButton(int icon);

    void setMenuRightButton(String rightButtonText);

    void setMenuRightButtonContentDescription(String rightButtonText);

    void setMenuRightButtonEnabled(boolean isEnabled);

    void setMenuRightProgressBar(boolean isProgress);

    void setTitle(String title);

    void setToolbarImage(int drawableRes);

    void setToolbarTitleContentDescription(String contentDescription);
}
