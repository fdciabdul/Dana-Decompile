package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes3.dex */
final class EmojiKeyListener implements KeyListener {
    private final EmojiCompatHandleKeyDownHelper BuiltInFictitiousFunctionClassFactory;
    private final KeyListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    private EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = keyListener;
        this.BuiltInFictitiousFunctionClassFactory = emojiCompatHandleKeyDownHelper;
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(editable, i, keyEvent) || this.KClassImpl$Data$declaredNonStaticMembers$2.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.onKeyUp(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clearMetaKeyState(view, editable, i);
    }

    /* loaded from: classes3.dex */
    public static class EmojiCompatHandleKeyDownHelper {
        public boolean PlaceComponentResult(Editable editable, int i, KeyEvent keyEvent) {
            return EmojiCompat.BuiltInFictitiousFunctionClassFactory(editable, i, keyEvent);
        }
    }
}
