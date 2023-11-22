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

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000f\u000eB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Landroidx/credentials/provider/AuthenticationAction;", "", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "getPendingIntent", "()Landroid/app/PendingIntent;", "", "title", "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "<init>", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V", "Companion", "Builder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AuthenticationAction {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.authenticationAction.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.authenticationAction.SLICE_HINT_TITLE";
    private static final int SLICE_SPEC_REVISION = 0;
    private static final String SLICE_SPEC_TYPE = "AuthenticationAction";
    private static final String TAG = "AuthenticationAction";
    private final PendingIntent pendingIntent;
    private final CharSequence title;

    @JvmStatic
    public static final AuthenticationAction fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(AuthenticationAction authenticationAction) {
        return INSTANCE.toSlice(authenticationAction);
    }

    public AuthenticationAction(CharSequence charSequence, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        this.title = charSequence;
        this.pendingIntent = pendingIntent;
        if (!(charSequence.length() > 0)) {
            throw new IllegalArgumentException("title must not be empty".toString());
        }
    }

    @JvmName(name = "getTitle")
    public final CharSequence getTitle() {
        return this.title;
    }

    @JvmName(name = "getPendingIntent")
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/credentials/provider/AuthenticationAction$Builder;", "", "Landroidx/credentials/provider/AuthenticationAction;", "build", "()Landroidx/credentials/provider/AuthenticationAction;", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "", "title", "Ljava/lang/CharSequence;", "<init>", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private final PendingIntent pendingIntent;
        private final CharSequence title;

        public Builder(CharSequence charSequence, PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(charSequence, "");
            Intrinsics.checkNotNullParameter(pendingIntent, "");
            this.title = charSequence;
            this.pendingIntent = pendingIntent;
        }

        public final AuthenticationAction build() {
            return new AuthenticationAction(this.title, this.pendingIntent);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\f"}, d2 = {"Landroidx/credentials/provider/AuthenticationAction$Companion;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/AuthenticationAction;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/AuthenticationAction;", "authenticationAction", "toSlice", "(Landroidx/credentials/provider/AuthenticationAction;)Landroid/app/slice/Slice;", "", "SLICE_HINT_PENDING_INTENT", "Ljava/lang/String;", "SLICE_HINT_TITLE", "", "SLICE_SPEC_REVISION", "I", "SLICE_SPEC_TYPE", "TAG", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(AuthenticationAction authenticationAction) {
            Intrinsics.checkNotNullParameter(authenticationAction, "");
            CharSequence title = authenticationAction.getTitle();
            PendingIntent pendingIntent = authenticationAction.getPendingIntent();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("AuthenticationAction", 0));
            builder.addAction(pendingIntent, new Slice.Builder(builder).addHints(Collections.singletonList(AuthenticationAction.SLICE_HINT_PENDING_INTENT)).build(), null).addText(title, null, CollectionsKt.listOf(AuthenticationAction.SLICE_HINT_TITLE));
            Slice build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        @JvmStatic
        public final AuthenticationAction fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            CharSequence charSequence = null;
            PendingIntent pendingIntent = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(AuthenticationAction.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(AuthenticationAction.SLICE_HINT_TITLE)) {
                    charSequence = sliceItem.getText();
                }
            }
            try {
                Intrinsics.checkNotNull(charSequence);
                Intrinsics.checkNotNull(pendingIntent);
                return new AuthenticationAction(charSequence, pendingIntent);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fromSlice failed with: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_i("AuthenticationAction", sb.toString());
                return null;
            }
        }
    }
}
