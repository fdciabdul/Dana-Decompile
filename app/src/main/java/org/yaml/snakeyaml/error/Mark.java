package org.yaml.snakeyaml.error;

import java.io.Serializable;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes6.dex */
public final class Mark implements Serializable {
    private final int[] buffer;
    private final int column;
    private final int index;
    private final int line;
    private final String name;
    private final int pointer;

    private static int[] toCodePoints(char[] cArr) {
        int i = 0;
        int[] iArr = new int[Character.codePointCount(cArr, 0, cArr.length)];
        int i2 = 0;
        while (i < cArr.length) {
            int codePointAt = Character.codePointAt(cArr, i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    public Mark(String str, int i, int i2, int i3, char[] cArr, int i4) {
        this(str, i, i2, i3, toCodePoints(cArr), i4);
    }

    public Mark(String str, int i, int i2, int i3, int[] iArr, int i4) {
        this.name = str;
        this.index = i;
        this.line = i2;
        this.column = i3;
        this.buffer = iArr;
        this.pointer = i4;
    }

    private boolean isLineBreak(int i) {
        return Constant.lookAheadTest.PlaceComponentResult(i);
    }

    public final String get_snippet(int i, int i2) {
        String str;
        String str2;
        float f = (i2 / 2.0f) - 1.0f;
        int i3 = this.pointer;
        while (true) {
            str = "";
            if (i3 <= 0) {
                break;
            }
            int i4 = i3 - 1;
            if (isLineBreak(this.buffer[i4])) {
                break;
            } else if (this.pointer - i4 > f) {
                i3 = i4 + 5;
                str2 = " ... ";
                break;
            } else {
                i3 = i4;
            }
        }
        str2 = "";
        int i5 = this.pointer;
        while (true) {
            int[] iArr = this.buffer;
            if (i5 >= iArr.length || isLineBreak(iArr[i5])) {
                break;
            }
            i5++;
            if (i5 - this.pointer > f) {
                i5 -= 5;
                str = " ... ";
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < i; i6++) {
            sb.append(" ");
        }
        sb.append(str2);
        for (int i7 = i3; i7 < i5; i7++) {
            sb.appendCodePoint(this.buffer[i7]);
        }
        sb.append(str);
        sb.append("\n");
        for (int i8 = 0; i8 < ((this.pointer + i) - i3) + str2.length(); i8++) {
            sb.append(" ");
        }
        sb.append("^");
        return sb.toString();
    }

    public final String get_snippet() {
        return get_snippet(4, 75);
    }

    public final String toString() {
        String str = get_snippet();
        StringBuilder sb = new StringBuilder();
        sb.append(" in ");
        sb.append(this.name);
        sb.append(", line ");
        sb.append(this.line + 1);
        sb.append(", column ");
        sb.append(this.column + 1);
        sb.append(":\n");
        sb.append(str);
        return sb.toString();
    }

    public final String getName() {
        return this.name;
    }

    public final int getLine() {
        return this.line;
    }

    public final int getColumn() {
        return this.column;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int[] getBuffer() {
        return this.buffer;
    }

    public final int getPointer() {
        return this.pointer;
    }
}
