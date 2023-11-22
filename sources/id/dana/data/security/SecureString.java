package id.dana.data.security;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/security/SecureString;", "", "", "clear", "()V", "", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "", "chars", "[C", "getLength", "()I", "length", "<init>", "([C)V", "start", "end", "([CII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SecureString implements CharSequence {
    private final char[] chars;

    public SecureString(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "");
        this.chars = ArraysKt.copyOfRange(cArr, i, i2);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return get(i);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return getLength();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SecureString(char[] cArr) {
        this(cArr, 0, cArr.length);
        Intrinsics.checkNotNullParameter(cArr, "");
    }

    @JvmName(name = "getLength")
    public final int getLength() {
        return this.chars.length;
    }

    public final char get(int index) {
        return this.chars[index];
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int startIndex, int endIndex) {
        return new SecureString(this.chars, startIndex, endIndex);
    }

    public final void clear() {
        ArraysKt.fill$default(this.chars, '0', 0, 0, 6, (Object) null);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return StringsKt.concatToString(this.chars);
    }
}
