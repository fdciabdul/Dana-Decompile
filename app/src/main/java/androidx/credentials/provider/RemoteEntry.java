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
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0002\n\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/credentials/provider/RemoteEntry;", "", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "getPendingIntent", "()Landroid/app/PendingIntent;", "<init>", "(Landroid/app/PendingIntent;)V", "Companion", "Builder"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RemoteEntry {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.remoteEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_SPEC_TYPE = "RemoteEntry";
    private static final String TAG = "RemoteEntry";
    private final PendingIntent pendingIntent;

    @JvmStatic
    public static final RemoteEntry fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(RemoteEntry remoteEntry) {
        return INSTANCE.toSlice(remoteEntry);
    }

    public RemoteEntry(PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        this.pendingIntent = pendingIntent;
    }

    @JvmName(name = "getPendingIntent")
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/credentials/provider/RemoteEntry$Builder;", "", "Landroidx/credentials/provider/RemoteEntry;", "build", "()Landroidx/credentials/provider/RemoteEntry;", "Landroid/app/PendingIntent;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "<init>", "(Landroid/app/PendingIntent;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private final PendingIntent pendingIntent;

        public Builder(PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(pendingIntent, "");
            this.pendingIntent = pendingIntent;
        }

        public final RemoteEntry build() {
            return new RemoteEntry(this.pendingIntent);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f"}, d2 = {"Landroidx/credentials/provider/RemoteEntry$Companion;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/RemoteEntry;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "toSlice", "(Landroidx/credentials/provider/RemoteEntry;)Landroid/app/slice/Slice;", "", "REVISION_ID", "I", "", "SLICE_HINT_PENDING_INTENT", "Ljava/lang/String;", "SLICE_SPEC_TYPE", "TAG", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(RemoteEntry remoteEntry) {
            Intrinsics.checkNotNullParameter(remoteEntry, "");
            PendingIntent pendingIntent = remoteEntry.getPendingIntent();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("RemoteEntry", 1));
            builder.addAction(pendingIntent, new Slice.Builder(builder).addHints(Collections.singletonList(RemoteEntry.SLICE_HINT_PENDING_INTENT)).build(), null);
            Slice build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        @JvmStatic
        public final RemoteEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            PendingIntent pendingIntent = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(RemoteEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                }
            }
            try {
                Intrinsics.checkNotNull(pendingIntent);
                return new RemoteEntry(pendingIntent);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fromSlice failed with: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_i("RemoteEntry", sb.toString());
                return null;
            }
        }
    }
}
