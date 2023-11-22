package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.credentials.CredentialOption;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.R;
import androidx.credentials.provider.BeginGetPublicKeyCredentialOption;
import com.alibaba.ariver.kernel.RVParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.BaseGmsClient;
import id.dana.danah5.constant.BridgeName;
import id.dana.domain.social.ExtendInfoUtilKt;
import j$.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0007\u0018\u0000 #2\u00020\u0001:\u0003!\"#BS\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011B_\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001aR\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u0006$"}, d2 = {"Landroidx/credentials/provider/PublicKeyCredentialEntry;", "Landroidx/credentials/provider/CredentialEntry;", HummerConstants.CONTEXT, "Landroid/content/Context;", "username", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "beginGetPublicKeyCredentialOption", "Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "lastUsedTime", "Ljava/time/Instant;", "icon", "Landroid/graphics/drawable/Icon;", "isAutoSelectAllowed", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Z)V", "typeDisplayName", "autoSelectAllowedFromOption", "isDefaultIcon", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroid/graphics/drawable/Icon;Ljava/time/Instant;ZLandroidx/credentials/provider/BeginGetPublicKeyCredentialOption;ZZ)V", "getDisplayName", "()Ljava/lang/CharSequence;", "getIcon", "()Landroid/graphics/drawable/Icon;", "()Z", "getLastUsedTime", "()Ljava/time/Instant;", "getPendingIntent", "()Landroid/app/PendingIntent;", "getTypeDisplayName", BridgeName.GET_USERNAME, "Api28Impl", "Builder", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PublicKeyCredentialEntry extends CredentialEntry {
    private static final String AUTO_SELECT_FALSE_STRING = "false";
    private static final String AUTO_SELECT_TRUE_STRING = "true";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_AUTO_ALLOWED = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED";
    private static final String SLICE_HINT_AUTO_SELECT_FROM_OPTION = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION";
    private static final String SLICE_HINT_DEFAULT_ICON_RES_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID";
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON";
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";
    private static final String SLICE_HINT_OPTION_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID";
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_SUBTITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME";
    private static final String SLICE_HINT_TYPE_DISPLAY_NAME = "androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME";
    private static final String TAG = "PublicKeyCredEntry";
    private final boolean autoSelectAllowedFromOption;
    private final CharSequence displayName;
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isDefaultIcon;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;
    private final CharSequence typeDisplayName;
    private final CharSequence username;

    @JvmStatic
    public static final PublicKeyCredentialEntry fromSlice(Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    public static final Slice toSlice(PublicKeyCredentialEntry publicKeyCredentialEntry) {
        return INSTANCE.toSlice(publicKeyCredentialEntry);
    }

    public /* synthetic */ PublicKeyCredentialEntry(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, PendingIntent pendingIntent, Icon icon, Instant instant, boolean z, BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, charSequence2, charSequence3, pendingIntent, icon, instant, z, beginGetPublicKeyCredentialOption, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? false : z3);
    }

    public final CharSequence getUsername() {
        return this.username;
    }

    public final CharSequence getDisplayName() {
        return this.displayName;
    }

    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    /* renamed from: isAutoSelectAllowed  reason: from getter */
    public final boolean getIsAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublicKeyCredentialEntry(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, PendingIntent pendingIntent, Icon icon, Instant instant, boolean z, BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption, boolean z2, boolean z3) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, beginGetPublicKeyCredentialOption);
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence3, "");
        Intrinsics.checkNotNullParameter(pendingIntent, "");
        Intrinsics.checkNotNullParameter(icon, "");
        Intrinsics.checkNotNullParameter(beginGetPublicKeyCredentialOption, "");
        this.username = charSequence;
        this.displayName = charSequence2;
        this.typeDisplayName = charSequence3;
        this.pendingIntent = pendingIntent;
        this.icon = icon;
        this.lastUsedTime = instant;
        this.isAutoSelectAllowed = z;
        this.autoSelectAllowedFromOption = z2;
        this.isDefaultIcon = z3;
        if (!(charSequence.length() > 0)) {
            throw new IllegalArgumentException("username must not be empty".toString());
        }
        if (!(charSequence3.length() > 0)) {
            throw new IllegalArgumentException("typeDisplayName must not be empty".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ PublicKeyCredentialEntry(android.content.Context r13, java.lang.CharSequence r14, android.app.PendingIntent r15, androidx.credentials.provider.BeginGetPublicKeyCredentialOption r16, java.lang.CharSequence r17, j$.time.Instant r18, android.graphics.drawable.Icon r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L9
            r8 = r2
            goto Lb
        L9:
            r8 = r17
        Lb:
            r1 = r0 & 32
            if (r1 == 0) goto L11
            r9 = r2
            goto L13
        L11:
            r9 = r18
        L13:
            r1 = r0 & 64
            if (r1 == 0) goto L25
            int r1 = androidx.credentials.R.drawable.ic_passkey
            r2 = r13
            android.graphics.drawable.Icon r1 = android.graphics.drawable.Icon.createWithResource(r13, r1)
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r10 = r1
            goto L28
        L25:
            r2 = r13
            r10 = r19
        L28:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L2f
            r0 = 0
            r11 = 0
            goto L31
        L2f:
            r11 = r20
        L31:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PublicKeyCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPublicKeyCredentialOption, java.lang.CharSequence, j$.time.Instant, android.graphics.drawable.Icon, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PublicKeyCredentialEntry(android.content.Context r16, java.lang.CharSequence r17, android.app.PendingIntent r18, androidx.credentials.provider.BeginGetPublicKeyCredentialOption r19, java.lang.CharSequence r20, j$.time.Instant r21, android.graphics.drawable.Icon r22, boolean r23) {
        /*
            r15 = this;
            r0 = r16
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            r6 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            r10 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            int r2 = androidx.credentials.R.string.androidx_credentials_TYPE_PUBLIC_KEY_CREDENTIAL
            java.lang.String r0 = r0.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r11 = 0
            r12 = 0
            r13 = 768(0x300, float:1.076E-42)
            r14 = 0
            r2 = r15
            r4 = r20
            r8 = r21
            r9 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PublicKeyCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPublicKeyCredentialOption, java.lang.CharSequence, j$.time.Instant, android.graphics.drawable.Icon, boolean):void");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/credentials/provider/PublicKeyCredentialEntry$Api28Impl;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/PublicKeyCredentialEntry;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/PublicKeyCredentialEntry;", RVParams.LONG_URL_WITH_ENTRY_KEY, "toSlice", "(Landroidx/credentials/provider/PublicKeyCredentialEntry;)Landroid/app/slice/Slice;", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Api28Impl {
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        public static final Slice toSlice(PublicKeyCredentialEntry r12) {
            Intrinsics.checkNotNullParameter(r12, "");
            String type = r12.getType();
            CharSequence username = r12.getUsername();
            CharSequence displayName = r12.getDisplayName();
            PendingIntent pendingIntent = r12.getPendingIntent();
            CharSequence typeDisplayName = r12.getTypeDisplayName();
            Instant lastUsedTime = r12.getLastUsedTime();
            Icon icon = r12.getIcon();
            boolean isAutoSelectAllowed = r12.getIsAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = r12.getBeginGetCredentialOption();
            Slice.Builder addIcon = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(username, null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_TITLE)).addText(displayName, null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_SUBTITLE)).addText(isAutoSelectAllowed ? "true" : "false", null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_OPTION_ID)).addIcon(icon, null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_ICON));
            try {
                if (icon.getResId() == R.drawable.ic_passkey) {
                    addIcon.addInt(1, null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (CredentialOption.INSTANCE.extractAutoSelectValue$credentials_release(beginGetCredentialOption.getCandidateQueryData())) {
                addIcon.addInt(1, null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                addIcon.addLong(lastUsedTime.toEpochMilli(), null, CollectionsKt.listOf(PublicKeyCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            addIcon.addAction(pendingIntent, new Slice.Builder(addIcon).addHints(Collections.singletonList(PublicKeyCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), null);
            Slice build = addIcon.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        @JvmStatic
        public static final PublicKeyCredentialEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            CharSequence charSequence = null;
            CharSequence charSequence2 = null;
            CharSequence charSequence3 = null;
            CharSequence charSequence4 = null;
            PendingIntent pendingIntent = null;
            Icon icon = null;
            Instant instant = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    charSequence4 = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_TITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    charSequence3 = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                    if (Intrinsics.areEqual(sliceItem.getText(), "true")) {
                        z = true;
                    }
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                    z2 = true;
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                    z3 = true;
                }
            }
            try {
                Intrinsics.checkNotNull(charSequence2);
                Intrinsics.checkNotNull(charSequence4);
                Intrinsics.checkNotNull(pendingIntent);
                Intrinsics.checkNotNull(icon);
                BeginGetPublicKeyCredentialOption.Companion companion = BeginGetPublicKeyCredentialOption.INSTANCE;
                Bundle bundle = new Bundle();
                Intrinsics.checkNotNull(charSequence);
                return new PublicKeyCredentialEntry(charSequence2, charSequence3, charSequence4, pendingIntent, icon, instant, z, companion.createFromEntrySlice$credentials_release(bundle, charSequence.toString()), z2, z3);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("fromSlice failed with: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_i(PublicKeyCredentialEntry.TAG, sb.toString());
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\f"}, d2 = {"Landroidx/credentials/provider/PublicKeyCredentialEntry$Companion;", "", "Landroid/app/slice/Slice;", "slice", "Landroidx/credentials/provider/PublicKeyCredentialEntry;", "fromSlice", "(Landroid/app/slice/Slice;)Landroidx/credentials/provider/PublicKeyCredentialEntry;", RVParams.LONG_URL_WITH_ENTRY_KEY, "toSlice", "(Landroidx/credentials/provider/PublicKeyCredentialEntry;)Landroid/app/slice/Slice;", "", "AUTO_SELECT_FALSE_STRING", "Ljava/lang/String;", "AUTO_SELECT_TRUE_STRING", "", "REVISION_ID", "I", "SLICE_HINT_AUTO_ALLOWED", "SLICE_HINT_AUTO_SELECT_FROM_OPTION", "SLICE_HINT_DEFAULT_ICON_RES_ID", "SLICE_HINT_ICON", "SLICE_HINT_LAST_USED_TIME_MILLIS", "SLICE_HINT_OPTION_ID", "SLICE_HINT_PENDING_INTENT", "SLICE_HINT_SUBTITLE", "SLICE_HINT_TITLE", "SLICE_HINT_TYPE_DISPLAY_NAME", "TAG", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Slice toSlice(PublicKeyCredentialEntry r3) {
            Intrinsics.checkNotNullParameter(r3, "");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(r3);
            }
            return null;
        }

        @JvmStatic
        public final PublicKeyCredentialEntry fromSlice(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/credentials/provider/PublicKeyCredentialEntry$Builder;", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "username", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "beginGetPublicKeyCredentialOption", "Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetPublicKeyCredentialOption;)V", "autoSelectAllowed", "", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "icon", "Landroid/graphics/drawable/Icon;", "lastUsedTime", "Ljava/time/Instant;", "build", "Landroidx/credentials/provider/PublicKeyCredentialEntry;", "setAutoSelectAllowed", "setDisplayName", "setIcon", "setLastUsedTime", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private boolean autoSelectAllowed;
        private final BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption;
        private final Context context;
        private CharSequence displayName;
        private Icon icon;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private final CharSequence username;

        public Builder(Context context, CharSequence charSequence, PendingIntent pendingIntent, BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(charSequence, "");
            Intrinsics.checkNotNullParameter(pendingIntent, "");
            Intrinsics.checkNotNullParameter(beginGetPublicKeyCredentialOption, "");
            this.context = context;
            this.username = charSequence;
            this.pendingIntent = pendingIntent;
            this.beginGetPublicKeyCredentialOption = beginGetPublicKeyCredentialOption;
        }

        public final Builder setDisplayName(CharSequence r1) {
            this.displayName = r1;
            return this;
        }

        public final Builder setIcon(Icon icon) {
            Intrinsics.checkNotNullParameter(icon, "");
            this.icon = icon;
            return this;
        }

        public final Builder setAutoSelectAllowed(boolean autoSelectAllowed) {
            this.autoSelectAllowed = autoSelectAllowed;
            return this;
        }

        public final Builder setLastUsedTime(Instant instant) {
            this.lastUsedTime = instant;
            return this;
        }

        public final PublicKeyCredentialEntry build() {
            if (this.icon == null && Build.VERSION.SDK_INT >= 23) {
                this.icon = Icon.createWithResource(this.context, R.drawable.ic_passkey);
            }
            String string = this.context.getString(R.string.androidx_credentials_TYPE_PUBLIC_KEY_CREDENTIAL);
            Intrinsics.checkNotNullExpressionValue(string, "");
            PendingIntent pendingIntent = this.pendingIntent;
            Icon icon = this.icon;
            Intrinsics.checkNotNull(icon);
            return new PublicKeyCredentialEntry(this.username, this.displayName, string, pendingIntent, icon, this.lastUsedTime, this.autoSelectAllowed, this.beginGetPublicKeyCredentialOption, false, false, 768, null);
        }
    }
}
