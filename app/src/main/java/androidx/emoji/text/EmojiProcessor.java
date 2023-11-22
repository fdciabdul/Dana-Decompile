package androidx.emoji.text;

import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.core.graphics.PaintCompat;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.MetadataRepo;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class EmojiProcessor {
    private final int[] BuiltInFictitiousFunctionClassFactory;
    private final EmojiCompat.SpanFactory KClassImpl$Data$declaredNonStaticMembers$2;
    private final MetadataRepo MyBillsEntityDataFactory;
    private GlyphChecker PlaceComponentResult = new GlyphChecker();
    private final boolean getAuthRequestContext;

    private static boolean getAuthRequestContext(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, boolean z, int[] iArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spanFactory;
        this.MyBillsEntityDataFactory = metadataRepo;
        this.getAuthRequestContext = z;
        this.BuiltInFictitiousFunctionClassFactory = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:206:0x012a, code lost:
    
        r7 = new android.text.SpannableString(r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0173, code lost:
    
        if (KClassImpl$Data$declaredNonStaticMembers$2(r17, r10, r0, r9.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext) == false) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x019c, code lost:
    
        r0 = (androidx.emoji.widget.SpannableBuilder) r17;
        r0.KClassImpl$Data$declaredNonStaticMembers$2();
        r0.PlaceComponentResult();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.CharSequence PlaceComponentResult(java.lang.CharSequence r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji.text.EmojiProcessor.PlaceComponentResult(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Editable editable, int i, KeyEvent keyEvent) {
        boolean authRequestContext;
        if (i == 67) {
            authRequestContext = getAuthRequestContext(editable, keyEvent, false);
        } else {
            authRequestContext = i != 112 ? false : getAuthRequestContext(editable, keyEvent, true);
        }
        if (authRequestContext) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    private static boolean getAuthRequestContext(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (KClassImpl$Data$declaredNonStaticMembers$2(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!getAuthRequestContext(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (getAuthRequestContext(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                max = CodepointIndexFinder.getAuthRequestContext(editable, selectionStart, Math.max(i, 0));
                min = CodepointIndexFinder.PlaceComponentResult(editable, selectionEnd, Math.max(i2, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i, 0);
                min = Math.min(selectionEnd + i2, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(max, min, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2, EmojiMetadata emojiMetadata) {
        if (Build.VERSION.SDK_INT >= 23 || emojiMetadata.KClassImpl$Data$declaredNonStaticMembers$2() <= Build.VERSION.SDK_INT) {
            if (emojiMetadata.PlaceComponentResult == 0) {
                emojiMetadata.PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(charSequence, i, i2) ? 2 : 1;
            }
            return emojiMetadata.PlaceComponentResult == 2;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public static final class ProcessorSm {
        MetadataRepo.Node BuiltInFictitiousFunctionClassFactory;
        MetadataRepo.Node KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        final MetadataRepo.Node PlaceComponentResult;
        int getAuthRequestContext;
        private final boolean lookAheadTest;
        int moveToNextValue = 1;
        private final int[] scheduleImpl;

        static boolean MyBillsEntityDataFactory(int i) {
            return i == 65038;
        }

        static boolean getAuthRequestContext(int i) {
            return i == 65039;
        }

        ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
            this.PlaceComponentResult = node;
            this.BuiltInFictitiousFunctionClassFactory = node;
            this.lookAheadTest = z;
            this.scheduleImpl = iArr;
        }

        final boolean MyBillsEntityDataFactory() {
            return this.moveToNextValue == 2 && this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext != null && (this.MyBillsEntityDataFactory > 1 || PlaceComponentResult());
        }

        final boolean PlaceComponentResult() {
            if (this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext() || getAuthRequestContext(this.getAuthRequestContext)) {
                return true;
            }
            if (this.lookAheadTest) {
                if (this.scheduleImpl == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class CodepointIndexFinder {
        private CodepointIndexFinder() {
        }

        static int getAuthRequestContext(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z = true;
                    }
                }
                return i;
            }
        }

        static int PlaceComponentResult(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (i >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                        i++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                        i++;
                    } else if (Character.isLowSurrogate(charAt)) {
                        return -1;
                    } else {
                        i++;
                        z = true;
                    }
                }
                return i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class GlyphChecker {
        private static final ThreadLocal<StringBuilder> KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadLocal<>();
        private final TextPaint BuiltInFictitiousFunctionClassFactory;

        GlyphChecker() {
            TextPaint textPaint = new TextPaint();
            this.BuiltInFictitiousFunctionClassFactory = textPaint;
            textPaint.setTextSize(10.0f);
        }

        public final boolean PlaceComponentResult(CharSequence charSequence, int i, int i2) {
            ThreadLocal<StringBuilder> threadLocal = KClassImpl$Data$declaredNonStaticMembers$2;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            return PaintCompat.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, sb.toString());
        }
    }
}
