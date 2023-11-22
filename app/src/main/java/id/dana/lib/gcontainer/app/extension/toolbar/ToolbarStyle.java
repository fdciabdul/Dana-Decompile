package id.dana.lib.gcontainer.app.extension.toolbar;

import com.alibaba.griver.api.constants.GriverEvents;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.lib.gcontainer.R;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0003#$%B9\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d"}, d2 = {"Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle;", "", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$BackButton;", "backButton", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$BackButton;", "getBackButton", "()Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$BackButton;", "setBackButton", "(Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$BackButton;)V", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$CloseButton;", "closeButton", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$CloseButton;", "getCloseButton", "()Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$CloseButton;", "setCloseButton", "(Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$CloseButton;)V", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$Title;", "title", "Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$Title;", "getTitle", "()Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$Title;", GriverEvents.EVENT_SET_TITLE, "(Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$Title;)V", "", "toolbarBackgroundColor", "I", "getToolbarBackgroundColor", "()I", "setToolbarBackgroundColor", "(I)V", "toolbarBackgroundDrawable", "getToolbarBackgroundDrawable", "setToolbarBackgroundDrawable", "<init>", "(IILid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$Title;Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$BackButton;Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$CloseButton;)V", "BackButton", "CloseButton", "Title"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ToolbarStyle {
    private BackButton backButton;
    private CloseButton closeButton;
    private Title title;
    private int toolbarBackgroundColor;
    private int toolbarBackgroundDrawable;

    public ToolbarStyle() {
        this(0, 0, null, null, null, 31, null);
    }

    public ToolbarStyle(int i, int i2, Title title, BackButton backButton, CloseButton closeButton) {
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(backButton, "");
        Intrinsics.checkNotNullParameter(closeButton, "");
        this.toolbarBackgroundColor = i;
        this.toolbarBackgroundDrawable = i2;
        this.title = title;
        this.backButton = backButton;
        this.closeButton = closeButton;
    }

    @JvmName(name = "getToolbarBackgroundColor")
    public final int getToolbarBackgroundColor() {
        return this.toolbarBackgroundColor;
    }

    @JvmName(name = "setToolbarBackgroundColor")
    public final void setToolbarBackgroundColor(int i) {
        this.toolbarBackgroundColor = i;
    }

    @JvmName(name = "getToolbarBackgroundDrawable")
    public final int getToolbarBackgroundDrawable() {
        return this.toolbarBackgroundDrawable;
    }

    @JvmName(name = "setToolbarBackgroundDrawable")
    public final void setToolbarBackgroundDrawable(int i) {
        this.toolbarBackgroundDrawable = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ToolbarStyle(int r12, int r13, id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle.Title r14, id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle.BackButton r15, id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle.CloseButton r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r11 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L8
            r0 = 17170443(0x106000b, float:2.4611944E-38)
            goto L9
        L8:
            r0 = r12
        L9:
            r1 = r17 & 2
            r2 = 0
            if (r1 == 0) goto L10
            r1 = 0
            goto L11
        L10:
            r1 = r13
        L11:
            r3 = r17 & 4
            if (r3 == 0) goto L1d
            id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$Title r3 = new id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$Title
            r4 = 3
            r5 = 0
            r3.<init>(r5, r2, r4, r5)
            goto L1e
        L1d:
            r3 = r14
        L1e:
            r2 = r17 & 8
            if (r2 == 0) goto L2e
            id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$BackButton r2 = new id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$BackButton
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            goto L2f
        L2e:
            r2 = r15
        L2f:
            r4 = r17 & 16
            if (r4 == 0) goto L4a
            id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$CloseButton r4 = new id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$CloseButton
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 15
            r10 = 0
            r12 = r4
            r13 = r5
            r14 = r6
            r15 = r7
            r16 = r8
            r17 = r9
            r18 = r10
            r12.<init>(r13, r14, r15, r16, r17, r18)
            goto L4c
        L4a:
            r4 = r16
        L4c:
            r12 = r11
            r13 = r0
            r14 = r1
            r15 = r3
            r16 = r2
            r17 = r4
            r12.<init>(r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle.<init>(int, int, id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$Title, id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$BackButton, id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle$CloseButton, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getTitle")
    public final Title getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(Title title) {
        Intrinsics.checkNotNullParameter(title, "");
        this.title = title;
    }

    @JvmName(name = "getBackButton")
    public final BackButton getBackButton() {
        return this.backButton;
    }

    @JvmName(name = "setBackButton")
    public final void setBackButton(BackButton backButton) {
        Intrinsics.checkNotNullParameter(backButton, "");
        this.backButton = backButton;
    }

    @JvmName(name = "getCloseButton")
    public final CloseButton getCloseButton() {
        return this.closeButton;
    }

    @JvmName(name = "setCloseButton")
    public final void setCloseButton(CloseButton closeButton) {
        Intrinsics.checkNotNullParameter(closeButton, "");
        this.closeButton = closeButton;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$Title;", "", "", "preloadTitle", "Ljava/lang/String;", "getPreloadTitle", "()Ljava/lang/String;", "setPreloadTitle", "(Ljava/lang/String;)V", "", CdpConstants.CONTENT_TEXT_COLOR, "I", "getTextColor", "()I", "setTextColor", "(I)V", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Title {
        private String preloadTitle;
        private int textColor;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Title() {
            /*
                r3 = this;
                r0 = 0
                r1 = 0
                r2 = 3
                r3.<init>(r0, r1, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.extension.toolbar.ToolbarStyle.Title.<init>():void");
        }

        public Title(String str, int i) {
            this.preloadTitle = str;
            this.textColor = i;
        }

        public /* synthetic */ Title(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 17170444 : i);
        }

        @JvmName(name = "getPreloadTitle")
        public final String getPreloadTitle() {
            return this.preloadTitle;
        }

        @JvmName(name = "setPreloadTitle")
        public final void setPreloadTitle(String str) {
            this.preloadTitle = str;
        }

        @JvmName(name = "getTextColor")
        public final int getTextColor() {
            return this.textColor;
        }

        @JvmName(name = "setTextColor")
        public final void setTextColor(int i) {
            this.textColor = i;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$BackButton;", "", "", "color", "I", "getColor", "()I", "setColor", "(I)V", "icon", "getIcon", "setIcon", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;II)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BackButton {
        private int color;
        private int icon;
        private String text;

        public BackButton() {
            this(null, 0, 0, 7, null);
        }

        public BackButton(String str, int i, int i2) {
            this.text = str;
            this.color = i;
            this.icon = i2;
        }

        @JvmName(name = "getText")
        public final String getText() {
            return this.text;
        }

        @JvmName(name = "setText")
        public final void setText(String str) {
            this.text = str;
        }

        public /* synthetic */ BackButton(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? R.color.griver_blueColor : i, (i3 & 4) != 0 ? 0 : i2);
        }

        @JvmName(name = "getColor")
        public final int getColor() {
            return this.color;
        }

        @JvmName(name = "setColor")
        public final void setColor(int i) {
            this.color = i;
        }

        @JvmName(name = "getIcon")
        public final int getIcon() {
            return this.icon;
        }

        @JvmName(name = "setIcon")
        public final void setIcon(int i) {
            this.icon = i;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/lib/gcontainer/app/extension/toolbar/ToolbarStyle$CloseButton;", "", "", "color", "I", "getColor", "()I", "setColor", "(I)V", "icon", "getIcon", "setIcon", "", ContainerUIProvider.KEY_SHOW, "Z", "getShow", "()Z", "setShow", "(Z)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "<init>", "(ZLjava/lang/String;II)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CloseButton {
        private int color;
        private int icon;
        private boolean show;
        private String text;

        public CloseButton() {
            this(false, null, 0, 0, 15, null);
        }

        public CloseButton(boolean z, String str, int i, int i2) {
            this.show = z;
            this.text = str;
            this.color = i;
            this.icon = i2;
        }

        @JvmName(name = "getShow")
        public final boolean getShow() {
            return this.show;
        }

        @JvmName(name = "setShow")
        public final void setShow(boolean z) {
            this.show = z;
        }

        @JvmName(name = "getText")
        public final String getText() {
            return this.text;
        }

        @JvmName(name = "setText")
        public final void setText(String str) {
            this.text = str;
        }

        public /* synthetic */ CloseButton(boolean z, String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? R.color.griver_blueColor : i, (i3 & 8) != 0 ? 0 : i2);
        }

        @JvmName(name = "getColor")
        public final int getColor() {
            return this.color;
        }

        @JvmName(name = "setColor")
        public final void setColor(int i) {
            this.color = i;
        }

        @JvmName(name = "getIcon")
        public final int getIcon() {
            return this.icon;
        }

        @JvmName(name = "setIcon")
        public final void setIcon(int i) {
            this.icon = i;
        }
    }
}
