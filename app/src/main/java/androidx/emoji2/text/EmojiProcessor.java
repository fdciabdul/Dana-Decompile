package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EmojiProcessor {
    private EmojiCompat.GlyphChecker BuiltInFictitiousFunctionClassFactory;
    private final MetadataRepo KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private final int[] PlaceComponentResult;
    private final EmojiCompat.SpanFactory getAuthRequestContext;

    private static boolean BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z, int[] iArr) {
        this.getAuthRequestContext = spanFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = metadataRepo;
        this.BuiltInFictitiousFunctionClassFactory = glyphChecker;
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x012f, code lost:
    
        r7 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable((android.text.Spannable) new android.text.SpannableString(r17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x01b2, code lost:
    
        r0 = (androidx.emoji2.text.SpannableBuilder) r17;
        r0.MyBillsEntityDataFactory();
        r0.PlaceComponentResult();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.CharSequence MyBillsEntityDataFactory(java.lang.CharSequence r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.MyBillsEntityDataFactory(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    public static boolean getAuthRequestContext(Editable editable, int i, KeyEvent keyEvent) {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 67) {
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(editable, keyEvent, false);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = i != 112 ? false : KClassImpl$Data$declaredNonStaticMembers$2(editable, keyEvent, true);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Editable editable, KeyEvent keyEvent, boolean z) {
        EmojiSpan[] emojiSpanArr;
        if (getAuthRequestContext(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!BuiltInFictitiousFunctionClassFactory(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
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
            if (BuiltInFictitiousFunctionClassFactory(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                max = CodepointIndexFinder.PlaceComponentResult(editable, selectionStart, Math.max(i, 0));
                min = CodepointIndexFinder.MyBillsEntityDataFactory(editable, selectionEnd, Math.max(i2, 0));
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

    private static boolean getAuthRequestContext(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* loaded from: classes6.dex */
    public static final class ProcessorSm {
        final MetadataRepo.Node BuiltInFictitiousFunctionClassFactory;
        MetadataRepo.Node KClassImpl$Data$declaredNonStaticMembers$2;
        MetadataRepo.Node MyBillsEntityDataFactory;
        private final int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        int getAuthRequestContext;
        int getErrorConfigVersion = 1;
        private final boolean scheduleImpl;

        static boolean BuiltInFictitiousFunctionClassFactory(int i) {
            return i == 65038;
        }

        static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return i == 65039;
        }

        ProcessorSm(MetadataRepo.Node node, boolean z, int[] iArr) {
            this.BuiltInFictitiousFunctionClassFactory = node;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = node;
            this.scheduleImpl = z;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = iArr;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getErrorConfigVersion == 2 && this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory != null && (this.getAuthRequestContext > 1 || MyBillsEntityDataFactory());
        }

        final boolean MyBillsEntityDataFactory() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getAuthRequestContext() || KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult)) {
                return true;
            }
            if (this.scheduleImpl) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.MyBillsEntityDataFactory().MyBillsEntityDataFactory(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class CodepointIndexFinder {
        private CodepointIndexFinder() {
        }

        static int PlaceComponentResult(CharSequence charSequence, int i, int i2) {
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

        static int MyBillsEntityDataFactory(CharSequence charSequence, int i, int i2) {
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

    private boolean BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i, int i2, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.BuiltInFictitiousFunctionClassFactory == 0) {
            emojiMetadata.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(charSequence, i, i2, emojiMetadata.BuiltInFictitiousFunctionClassFactory()) ? 2 : 1;
        }
        return emojiMetadata.BuiltInFictitiousFunctionClassFactory == 2;
    }
}
