package com.anggrayudi.storage.file;

import id.dana.animation.view.QrRefreshNotification;
import id.dana.promocenter.model.PromoActionType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lcom/anggrayudi/storage/file/StorageType;", "", "actualStorageType", "", "isExpected", "(Lcom/anggrayudi/storage/file/StorageType;)Z", "<init>", "(Ljava/lang/String;I)V", "Companion", "EXTERNAL", QrRefreshNotification.DATA, "SD_CARD", "UNKNOWN"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum StorageType {
    EXTERNAL,
    DATA,
    SD_CARD,
    UNKNOWN;


    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final StorageType fromStorageId(String str) {
        return Companion.PlaceComponentResult(str);
    }

    public final boolean isExpected(StorageType actualStorageType) {
        Intrinsics.checkNotNullParameter(actualStorageType, "");
        return this == UNKNOWN || this == actualStorageType;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/anggrayudi/storage/file/StorageType$Companion;", "", "", "p0", "Lcom/anggrayudi/storage/file/StorageType;", "PlaceComponentResult", "(Ljava/lang/String;)Lcom/anggrayudi/storage/file/StorageType;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static StorageType PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (Intrinsics.areEqual(p0, PromoActionType.PRIMARY)) {
                return StorageType.EXTERNAL;
            }
            if (Intrinsics.areEqual(p0, "data")) {
                return StorageType.DATA;
            }
            return new Regex("[A-Z0-9]{4}-[A-Z0-9]{4}").matches(p0) ? StorageType.SD_CARD : StorageType.UNKNOWN;
        }
    }
}
