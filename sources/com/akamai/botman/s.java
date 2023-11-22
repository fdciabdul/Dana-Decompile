package com.akamai.botman;

import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.Observable;

/* loaded from: classes3.dex */
public final class s extends Observable implements TextWatcher {
    private boolean MyBillsEntityDataFactory;
    private final int getAuthRequestContext;
    private int BuiltInFictitiousFunctionClassFactory = 0;
    private boolean PlaceComponentResult = false;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public s(int i, boolean z) {
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = z;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() - this.BuiltInFictitiousFunctionClassFactory > 1) {
            this.PlaceComponentResult = true;
        } else {
            this.PlaceComponentResult = false;
        }
        setChanged();
        notifyObservers(new g(SystemClock.uptimeMillis(), "2", this.getAuthRequestContext, this.PlaceComponentResult));
        this.BuiltInFictitiousFunctionClassFactory = charSequence.length();
    }
}
