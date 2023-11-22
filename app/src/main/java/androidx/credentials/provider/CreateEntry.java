package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.BaseGmsClient;
import j$.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003$%&Bi\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011BS\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015J\r\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!J\r\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!J\r\u0010#\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Landroidx/credentials/provider/CreateEntry;", "", "accountName", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "description", "lastUsedTime", "Ljava/time/Instant;", "icon", "Landroid/graphics/drawable/Icon;", "passwordCredentialCount", "", "publicKeyCredentialCount", "totalCredentialCount", "isAutoSelectAllowed", "", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "credentialCountInformationMap", "", "", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroid/graphics/drawable/Icon;Ljava/lang/CharSequence;Ljava/time/Instant;Ljava/util/Map;Z)V", "getAccountName", "()Ljava/lang/CharSequence;", "getDescription", "getIcon", "()Landroid/graphics/drawable/Icon;", "()Z", "getLastUsedTime", "()Ljava/time/Instant;", "getPendingIntent", "()Landroid/app/PendingIntent;", "getPasswordCredentialCount", "()Ljava/lang/Integer;", "getPublicKeyCredentialCount", "getTotalCredentialCount", "Api28Impl", "Builder", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CreateEntry {
    private static final String AUTO_SELECT_FALSE_STRING = "false";
    private static final String AUTO_SELECT_TRUE_STRING = "true";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESCRIPTION_MAX_CHAR_LIMIT = 300;
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_ACCOUNT_NAME = "androidx.credentials.provider.createEntry.SLICE_HINT_USER_PROVIDER_ACCOUNT_NAME";
    private static final String SLICE_HINT_AUTO_SELECT_ALLOWED = "androidx.credentials.provider.createEntry.SLICE_HINT_AUTO_SELECT_ALLOWED";
    private static final String SLICE_HINT_CREDENTIAL_COUNT_INFORMATION = "androidx.credentials.provider.createEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION";
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.createEntry.SLICE_HINT_PROFILE_ICON";
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.createEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";
    private static final String SLICE_HINT_NOTE = "androidx.credentials.provider.createEntry.SLICE_HINT_NOTE";
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.createEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_SPEC_TYPE = "CreateEntry";
    private static final String TAG = "CreateEntry";
    public static final String TYPE_TOTAL_CREDENTIAL = "TOTAL_CREDENTIAL_COUNT_TYPE";
    private final CharSequence accountName;
    private final Map<String, Integer> credentialCountInformationMap;
    private final CharSequence description;
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;

    @JvmStatic
    public static final CreateEntry fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(CreateEntry createEntry) {
        return INSTANCE.toSlice(createEntry);
    }

    public CreateEntry(CharSequence charSequence, PendingIntent pendingIntent, Icon icon, CharSequence charSequence2, Instant instant, Map<String, Integer> map, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.accountName = charSequence;
        this.pendingIntent = pendingIntent;
        this.icon = icon;
        this.description = charSequence2;
        this.lastUsedTime = instant;
        this.credentialCountInformationMap = map;
        this.isAutoSelectAllowed = z;
        if (!(charSequence.length() > 0)) {
            throw new IllegalArgumentException("accountName must not be empty".toString());
        }
        if (charSequence2 != null) {
            if (!(charSequence2.length() <= 300)) {
                throw new IllegalArgumentException("Description must follow a limit of 300 characters.".toString());
            }
        }
    }

    public final CharSequence getAccountName() {
        return this.accountName;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    /* renamed from: isAutoSelectAllowed  reason: from getter */
    public final boolean getIsAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public /* synthetic */ CreateEntry(CharSequence charSequence, PendingIntent pendingIntent, CharSequence charSequence2, Instant instant, Icon icon, Integer num, Integer num2, Integer num3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, pendingIntent, (i & 4) != 0 ? null : charSequence2, (i & 8) != 0 ? null : instant, (i & 16) != 0 ? null : icon, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateEntry(CharSequence charSequence, PendingIntent pendingIntent, CharSequence charSequence2, Instant instant, Icon icon, Integer num, Integer num2, Integer num3, boolean z) {
        this(charSequence, pendingIntent, icon, charSequence2, instant, MapsKt.mutableMapOf(TuplesKt.to(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, num), TuplesKt.to(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, num2), TuplesKt.to(TYPE_TOTAL_CREDENTIAL, num3)), z);
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
    }

    public final Integer getPasswordCredentialCount() {
        return this.credentialCountInformationMap.get(PasswordCredential.TYPE_PASSWORD_CREDENTIAL);
    }

    public final Integer getPublicKeyCredentialCount() {
        return this.credentialCountInformationMap.get(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL);
    }

    public final Integer getTotalCredentialCount() {
        return this.credentialCountInformationMap.get(TYPE_TOTAL_CREDENTIAL);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006 "}, d2 = {"Landroidx/credentials/provider/CreateEntry$Builder;", "", "accountName", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V", "autoSelectAllowed", "", "credentialCountInformationMap", "", "", "", "description", "icon", "Landroid/graphics/drawable/Icon;", "lastUsedTime", "Ljava/time/Instant;", "passwordCredentialCount", "Ljava/lang/Integer;", "publicKeyCredentialCount", "totalCredentialCount", "build", "Landroidx/credentials/provider/CreateEntry;", "setAutoSelectAllowed", "setDescription", "setIcon", "setLastUsedTime", "setPasswordCredentialCount", "count", "setPublicKeyCredentialCount", "setTotalCredentialCount", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private final CharSequence accountName;
        private boolean autoSelectAllowed;
        private Map<String, Integer> credentialCountInformationMap;
        private CharSequence description;
        private Icon icon;
        private Instant lastUsedTime;
        private Integer passwordCredentialCount;
        private final PendingIntent pendingIntent;
        private Integer publicKeyCredentialCount;
        private Integer totalCredentialCount;

        public Builder(CharSequence charSequence, PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(charSequence, "");
            Intrinsics.checkNotNullParameter(pendingIntent, "");
            this.accountName = charSequence;
            this.pendingIntent = pendingIntent;
            this.credentialCountInformationMap = new LinkedHashMap();
        }

        public final Builder setAutoSelectAllowed(boolean autoSelectAllowed) {
            this.autoSelectAllowed = autoSelectAllowed;
            return this;
        }

        public final Builder setPasswordCredentialCount(int count) {
            this.passwordCredentialCount = Integer.valueOf(count);
            this.credentialCountInformationMap.put(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, Integer.valueOf(count));
            return this;
        }

        public final Builder setPublicKeyCredentialCount(int count) {
            this.publicKeyCredentialCount = Integer.valueOf(count);
            this.credentialCountInformationMap.put(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, Integer.valueOf(count));
            return this;
        }

        public final Builder setTotalCredentialCount(int count) {
            this.totalCredentialCount = Integer.valueOf(count);
            this.credentialCountInformationMap.put(CreateEntry.TYPE_TOTAL_CREDENTIAL, Integer.valueOf(count));
            return this;
        }

        public final Builder setIcon(Icon icon) {
            this.icon = icon;
            return this;
        }

        public final Builder setDescription(CharSequence description) {
            if ((description != null ? Integer.valueOf(description.length()) : null) != null && description.length() > 300) {
                throw new IllegalArgumentException("Description must follow a limit of 300 characters.");
            }
            this.description = description;
            return this;
        }

        public final Builder setLastUsedTime(Instant instant) {
            this.lastUsedTime = instant;
            return this;
        }

        public final CreateEntry build() {
            return new CreateEntry(this.accountName, this.pendingIntent, this.icon, this.description, this.lastUsedTime, this.credentialCountInformationMap, this.autoSelectAllowed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u0004\u0018\u00010\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/credentials/provider/CreateEntry$Api28Impl;", "", "Landroid/os/Bundle;", HummerConstants.BUNDLE, "", "", "", "convertBundleToCredentialCountInfo$credentials_release", "(Landroid/os/Bundle;)Ljava/util/Map;", "credentialCountInformationMap", "convertCredentialCountInfoToBundle$credentials_release", "(Ljava/util/Map;)Landroid/os/Bundle;", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/CreateEntry;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/CreateEntry;", "createEntry", "toSlice", "(Landroidx/credentials/provider/CreateEntry;)Landroid/app/slice/Slice;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final Slice toSlice(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "");
            CharSequence accountName = createEntry.getAccountName();
            Icon icon = createEntry.getIcon();
            CharSequence description = createEntry.getDescription();
            Instant lastUsedTime = createEntry.getLastUsedTime();
            Map map = createEntry.credentialCountInformationMap;
            PendingIntent pendingIntent = createEntry.getPendingIntent();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("CreateEntry", 1));
            String str = createEntry.getIsAutoSelectAllowed() ? "true" : "false";
            builder.addText(accountName, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_ACCOUNT_NAME));
            if (lastUsedTime != null) {
                builder.addLong(lastUsedTime.toEpochMilli(), null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            if (description != null) {
                builder.addText(description, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_NOTE));
            }
            if (icon != null) {
                builder.addIcon(icon, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_ICON));
            }
            if (convertCredentialCountInfoToBundle$credentials_release(map) != null) {
                builder.addBundle(convertCredentialCountInfoToBundle$credentials_release(map), null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION));
            }
            builder.addAction(pendingIntent, new Slice.Builder(builder).addHints(Collections.singletonList(CreateEntry.SLICE_HINT_PENDING_INTENT)).build(), null).addText(str, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_AUTO_SELECT_ALLOWED));
            Slice build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        @JvmStatic
        public static final CreateEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            Map linkedHashMap = new LinkedHashMap();
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            CharSequence charSequence = null;
            PendingIntent pendingIntent = null;
            Icon icon = null;
            CharSequence charSequence2 = null;
            Instant instant = null;
            Map map = linkedHashMap;
            boolean z = false;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(CreateEntry.SLICE_HINT_ACCOUNT_NAME)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION)) {
                    Map<String, Integer> convertBundleToCredentialCountInfo$credentials_release = convertBundleToCredentialCountInfo$credentials_release(sliceItem.getBundle());
                    Intrinsics.checkNotNull(convertBundleToCredentialCountInfo$credentials_release);
                    map = TypeIntrinsics.asMutableMap(convertBundleToCredentialCountInfo$credentials_release);
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_NOTE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_AUTO_SELECT_ALLOWED) && Intrinsics.areEqual(sliceItem.getText(), "true")) {
                    z = true;
                }
            }
            try {
                Intrinsics.checkNotNull(charSequence);
                Intrinsics.checkNotNull(pendingIntent);
                return new CreateEntry(charSequence, pendingIntent, icon, charSequence2, instant, map, z);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fromSlice failed with: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_i("CreateEntry", sb.toString());
                return null;
            }
        }

        @JvmStatic
        public static final Map<String, Integer> convertBundleToCredentialCountInfo$credentials_release(Bundle bundle) {
            HashMap hashMap = new HashMap();
            if (bundle == null) {
                return hashMap;
            }
            Set<String> keySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "");
            for (String str : keySet) {
                try {
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    hashMap.put(str, Integer.valueOf(bundle.getInt(str)));
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Issue unpacking credential count info bundle: ");
                    sb.append(e.getMessage());
                    InstrumentInjector.log_i("CreateEntry", sb.toString());
                }
            }
            return hashMap;
        }

        @JvmStatic
        public static final Bundle convertCredentialCountInfoToBundle$credentials_release(Map<String, Integer> credentialCountInformationMap) {
            Intrinsics.checkNotNullParameter(credentialCountInformationMap, "");
            Bundle bundle = new Bundle();
            boolean z = false;
            for (Map.Entry<String, Integer> entry : credentialCountInformationMap.entrySet()) {
                if (entry.getValue() != null) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    Intrinsics.checkNotNull(value);
                    bundle.putInt(key, value.intValue());
                    z = true;
                }
            }
            if (z) {
                return bundle;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\f"}, d2 = {"Landroidx/credentials/provider/CreateEntry$Companion;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/CreateEntry;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/CreateEntry;", "createEntry", "toSlice", "(Landroidx/credentials/provider/CreateEntry;)Landroid/app/slice/Slice;", "", "AUTO_SELECT_FALSE_STRING", "Ljava/lang/String;", "AUTO_SELECT_TRUE_STRING", "", "DESCRIPTION_MAX_CHAR_LIMIT", "I", "REVISION_ID", "SLICE_HINT_ACCOUNT_NAME", "SLICE_HINT_AUTO_SELECT_ALLOWED", "SLICE_HINT_CREDENTIAL_COUNT_INFORMATION", "SLICE_HINT_ICON", "SLICE_HINT_LAST_USED_TIME_MILLIS", "SLICE_HINT_NOTE", "SLICE_HINT_PENDING_INTENT", "SLICE_SPEC_TYPE", "TAG", "TYPE_TOTAL_CREDENTIAL", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(createEntry);
            }
            return null;
        }

        @JvmStatic
        public final CreateEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }
    }
}
