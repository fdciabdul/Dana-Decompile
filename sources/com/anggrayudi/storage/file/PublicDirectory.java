package com.anggrayudi.storage.file;

import android.os.Environment;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DOWNLOADS' uses external variables
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068G¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a"}, d2 = {"Lcom/anggrayudi/storage/file/PublicDirectory;", "", "", "getAbsolutePath", "()Ljava/lang/String;", "absolutePath", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "getFile$annotations", "()V", "file", "folderName", "Ljava/lang/String;", "getFolderName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DOWNLOADS", "MUSIC", "PODCASTS", "RINGTONES", "ALARMS", "NOTIFICATIONS", "PICTURES", "MOVIES", "DCIM", "DOCUMENTS"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PublicDirectory {
    private static final /* synthetic */ PublicDirectory[] $VALUES;
    public static final PublicDirectory ALARMS;
    public static final PublicDirectory DCIM;
    public static final PublicDirectory DOCUMENTS;
    public static final PublicDirectory DOWNLOADS;
    public static final PublicDirectory MOVIES;
    public static final PublicDirectory MUSIC;
    public static final PublicDirectory NOTIFICATIONS;
    public static final PublicDirectory PICTURES;
    public static final PublicDirectory PODCASTS;
    public static final PublicDirectory RINGTONES;
    private final String folderName;

    private static final /* synthetic */ PublicDirectory[] $values() {
        return new PublicDirectory[]{DOWNLOADS, MUSIC, PODCASTS, RINGTONES, ALARMS, NOTIFICATIONS, PICTURES, MOVIES, DCIM, DOCUMENTS};
    }

    public static /* synthetic */ void getFile$annotations() {
    }

    public static PublicDirectory valueOf(String str) {
        return (PublicDirectory) Enum.valueOf(PublicDirectory.class, str);
    }

    public static PublicDirectory[] values() {
        return (PublicDirectory[]) $VALUES.clone();
    }

    private PublicDirectory(String str, int i, String str2) {
        this.folderName = str2;
    }

    @JvmName(name = "getFolderName")
    public final String getFolderName() {
        return this.folderName;
    }

    static {
        String str = Environment.DIRECTORY_DOWNLOADS;
        Intrinsics.checkNotNullExpressionValue(str, "");
        DOWNLOADS = new PublicDirectory("DOWNLOADS", 0, str);
        String str2 = Environment.DIRECTORY_MUSIC;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        MUSIC = new PublicDirectory("MUSIC", 1, str2);
        String str3 = Environment.DIRECTORY_PODCASTS;
        Intrinsics.checkNotNullExpressionValue(str3, "");
        PODCASTS = new PublicDirectory("PODCASTS", 2, str3);
        String str4 = Environment.DIRECTORY_RINGTONES;
        Intrinsics.checkNotNullExpressionValue(str4, "");
        RINGTONES = new PublicDirectory("RINGTONES", 3, str4);
        String str5 = Environment.DIRECTORY_ALARMS;
        Intrinsics.checkNotNullExpressionValue(str5, "");
        ALARMS = new PublicDirectory("ALARMS", 4, str5);
        String str6 = Environment.DIRECTORY_NOTIFICATIONS;
        Intrinsics.checkNotNullExpressionValue(str6, "");
        NOTIFICATIONS = new PublicDirectory("NOTIFICATIONS", 5, str6);
        String str7 = Environment.DIRECTORY_PICTURES;
        Intrinsics.checkNotNullExpressionValue(str7, "");
        PICTURES = new PublicDirectory("PICTURES", 6, str7);
        String str8 = Environment.DIRECTORY_MOVIES;
        Intrinsics.checkNotNullExpressionValue(str8, "");
        MOVIES = new PublicDirectory("MOVIES", 7, str8);
        String str9 = Environment.DIRECTORY_DCIM;
        Intrinsics.checkNotNullExpressionValue(str9, "");
        DCIM = new PublicDirectory("DCIM", 8, str9);
        String str10 = Environment.DIRECTORY_DOCUMENTS;
        Intrinsics.checkNotNullExpressionValue(str10, "");
        DOCUMENTS = new PublicDirectory("DOCUMENTS", 9, str10);
        $VALUES = $values();
    }

    @JvmName(name = "getFile")
    public final File getFile() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(this.folderName);
        Intrinsics.checkNotNullExpressionValue(externalStoragePublicDirectory, "");
        return externalStoragePublicDirectory;
    }

    @JvmName(name = "getAbsolutePath")
    public final String getAbsolutePath() {
        String absolutePath = getFile().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "");
        return absolutePath;
    }
}
