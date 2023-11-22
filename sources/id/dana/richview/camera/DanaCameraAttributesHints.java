package id.dana.richview.camera;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/richview/camera/DanaCameraAttributesHints;", "", "<init>", "()V", "Companion", "ActionButton"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DanaCameraAttributesHints {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/richview/camera/DanaCameraAttributesHints$ActionButton;", "", "", "visibility", "I", "getVisibility", "()I", "<init>", "(Ljava/lang/String;II)V", "SHOW", "HIDE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public enum ActionButton {
        SHOW(1),
        HIDE(0);

        private final int visibility;

        ActionButton(int i) {
            this.visibility = i;
        }

        @JvmName(name = "getVisibility")
        public final int getVisibility() {
            return this.visibility;
        }
    }
}
