package com.anggrayudi.storage.media;

import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'MUSIC' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r"}, d2 = {"Lcom/anggrayudi/storage/media/AudioMediaDirectory;", "", "", "folderName", "Ljava/lang/String;", "getFolderName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MUSIC", "PODCASTS", "RINGTONES", "ALARMS", "NOTIFICATIONS"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioMediaDirectory {
    private static final /* synthetic */ AudioMediaDirectory[] $VALUES;
    public static final AudioMediaDirectory ALARMS;
    public static final AudioMediaDirectory MUSIC;
    public static final AudioMediaDirectory NOTIFICATIONS;
    public static final AudioMediaDirectory PODCASTS;
    public static final AudioMediaDirectory RINGTONES;
    private final String folderName;

    private static final /* synthetic */ AudioMediaDirectory[] $values() {
        return new AudioMediaDirectory[]{MUSIC, PODCASTS, RINGTONES, ALARMS, NOTIFICATIONS};
    }

    public static AudioMediaDirectory valueOf(String str) {
        return (AudioMediaDirectory) Enum.valueOf(AudioMediaDirectory.class, str);
    }

    public static AudioMediaDirectory[] values() {
        return (AudioMediaDirectory[]) $VALUES.clone();
    }

    private AudioMediaDirectory(String str, int i, String str2) {
        this.folderName = str2;
    }

    @JvmName(name = "getFolderName")
    public final String getFolderName() {
        return this.folderName;
    }

    static {
        String str = Environment.DIRECTORY_MUSIC;
        Intrinsics.checkNotNullExpressionValue(str, "");
        MUSIC = new AudioMediaDirectory("MUSIC", 0, str);
        String str2 = Environment.DIRECTORY_PODCASTS;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        PODCASTS = new AudioMediaDirectory("PODCASTS", 1, str2);
        String str3 = Environment.DIRECTORY_RINGTONES;
        Intrinsics.checkNotNullExpressionValue(str3, "");
        RINGTONES = new AudioMediaDirectory("RINGTONES", 2, str3);
        String str4 = Environment.DIRECTORY_ALARMS;
        Intrinsics.checkNotNullExpressionValue(str4, "");
        ALARMS = new AudioMediaDirectory("ALARMS", 3, str4);
        String str5 = Environment.DIRECTORY_NOTIFICATIONS;
        Intrinsics.checkNotNullExpressionValue(str5, "");
        NOTIFICATIONS = new AudioMediaDirectory("NOTIFICATIONS", 4, str5);
        $VALUES = $values();
    }
}
