package androidx.emoji.widget;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji.text.EmojiCompat;

/* loaded from: classes6.dex */
final class EmojiKeyListener implements KeyListener {
    private final KeyListener MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiKeyListener(KeyListener keyListener) {
        this.MyBillsEntityDataFactory = keyListener;
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.MyBillsEntityDataFactory.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return EmojiCompat.getAuthRequestContext(editable, i, keyEvent) || this.MyBillsEntityDataFactory.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.MyBillsEntityDataFactory.onKeyUp(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.MyBillsEntityDataFactory.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.MyBillsEntityDataFactory.clearMetaKeyState(view, editable, i);
    }
}
