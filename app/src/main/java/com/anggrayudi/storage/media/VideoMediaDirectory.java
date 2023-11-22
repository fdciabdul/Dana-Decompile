package com.anggrayudi.storage.media;

import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'MOVIES' uses external variables
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lcom/anggrayudi/storage/media/VideoMediaDirectory;", "", "", "folderName", "Ljava/lang/String;", "getFolderName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MOVIES", "DCIM"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VideoMediaDirectory {
    private static final /* synthetic */ VideoMediaDirectory[] $VALUES;
    public static final VideoMediaDirectory DCIM;
    public static final VideoMediaDirectory MOVIES;
    private final String folderName;

    private static final /* synthetic */ VideoMediaDirectory[] $values() {
        return new VideoMediaDirectory[]{MOVIES, DCIM};
    }

    public static VideoMediaDirectory valueOf(String str) {
        return (VideoMediaDirectory) Enum.valueOf(VideoMediaDirectory.class, str);
    }

    public static VideoMediaDirectory[] values() {
        return (VideoMediaDirectory[]) $VALUES.clone();
    }

    private VideoMediaDirectory(String str, int i, String str2) {
        this.folderName = str2;
    }

    @JvmName(name = "getFolderName")
    public final String getFolderName() {
        return this.folderName;
    }

    static {
        String str = Environment.DIRECTORY_MOVIES;
        Intrinsics.checkNotNullExpressionValue(str, "");
        MOVIES = new VideoMediaDirectory("MOVIES", 0, str);
        String str2 = Environment.DIRECTORY_DCIM;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        DCIM = new VideoMediaDirectory("DCIM", 1, str2);
        $VALUES = $values();
    }
}
