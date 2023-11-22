package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.net.Uri;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0002\u0011\u0010B#\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Landroidx/credentials/provider/Action;", "", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "getPendingIntent", "()Landroid/app/PendingIntent;", "", "subtitle", "Ljava/lang/CharSequence;", "getSubtitle", "()Ljava/lang/CharSequence;", "title", "getTitle", "<init>", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;Ljava/lang/CharSequence;)V", "Companion", "Builder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Action {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.action.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_SUBTITLE = "androidx.credentials.provider.action.HINT_ACTION_SUBTEXT";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.action.HINT_ACTION_TITLE";
    private static final int SLICE_SPEC_REVISION = 0;
    private static final String SLICE_SPEC_TYPE = "Action";
    private static final String TAG = "Action";
    private final PendingIntent pendingIntent;
    private final CharSequence subtitle;
    private final CharSequence title;

    @JvmStatic
    public static final Action fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(Action action) {
        return INSTANCE.toSlice(action);
    }

    public Action(CharSequence charSequence, PendingIntent pendingIntent, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        this.title = charSequence;
        this.pendingIntent = pendingIntent;
        this.subtitle = charSequence2;
        if (!(charSequence.length() > 0)) {
            throw new IllegalArgumentException("title must not be empty".toString());
        }
    }

    public /* synthetic */ Action(CharSequence charSequence, PendingIntent pendingIntent, CharSequence charSequence2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, pendingIntent, (i & 4) != 0 ? null : charSequence2);
    }

    @JvmName(name = "getTitle")
    public final CharSequence getTitle() {
        return this.title;
    }

    @JvmName(name = "getPendingIntent")
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    @JvmName(name = "getSubtitle")
    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f"}, d2 = {"Landroidx/credentials/provider/Action$Builder;", "", "Landroidx/credentials/provider/Action;", "build", "()Landroidx/credentials/provider/Action;", "", "subtitle", "setSubtitle", "(Ljava/lang/CharSequence;)Landroidx/credentials/provider/Action$Builder;", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "Ljava/lang/CharSequence;", "title", "<init>", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private final PendingIntent pendingIntent;
        private CharSequence subtitle;
        private final CharSequence title;

        public Builder(CharSequence charSequence, PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(charSequence, "");
            Intrinsics.checkNotNullParameter(pendingIntent, "");
            this.title = charSequence;
            this.pendingIntent = pendingIntent;
        }

        public final Builder setSubtitle(CharSequence subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public final Action build() {
            return new Action(this.title, this.pendingIntent, this.subtitle);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\f"}, d2 = {"Landroidx/credentials/provider/Action$Companion;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/Action;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/Action;", "action", "toSlice", "(Landroidx/credentials/provider/Action;)Landroid/app/slice/Slice;", "", "SLICE_HINT_PENDING_INTENT", "Ljava/lang/String;", "SLICE_HINT_SUBTITLE", "SLICE_HINT_TITLE", "", "SLICE_SPEC_REVISION", "I", "SLICE_SPEC_TYPE", "TAG", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(Action action) {
            Intrinsics.checkNotNullParameter(action, "");
            CharSequence title = action.getTitle();
            CharSequence subtitle = action.getSubtitle();
            PendingIntent pendingIntent = action.getPendingIntent();
            Slice.Builder addText = new Slice.Builder(Uri.EMPTY, new SliceSpec("Action", 0)).addText(title, null, CollectionsKt.listOf(Action.SLICE_HINT_TITLE)).addText(subtitle, null, CollectionsKt.listOf(Action.SLICE_HINT_SUBTITLE));
            addText.addAction(pendingIntent, new Slice.Builder(addText).addHints(Collections.singletonList(Action.SLICE_HINT_PENDING_INTENT)).build(), null);
            Slice build = addText.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        @JvmStatic
        public final Action fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            CharSequence charSequence = "";
            PendingIntent pendingIntent = null;
            CharSequence charSequence2 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(Action.SLICE_HINT_TITLE)) {
                    charSequence = sliceItem.getText();
                    Intrinsics.checkNotNullExpressionValue(charSequence, "");
                } else if (sliceItem.hasHint(Action.SLICE_HINT_SUBTITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(Action.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                }
            }
            try {
                CharSequence charSequence3 = charSequence;
                Intrinsics.checkNotNull(pendingIntent);
                return new Action(charSequence, pendingIntent, charSequence2);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fromSlice failed with: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_i("Action", sb.toString());
                return null;
            }
        }
    }
}
