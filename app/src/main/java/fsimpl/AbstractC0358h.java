package fsimpl;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import com.fullstory.util.Log;
import java.lang.reflect.Field;

/* renamed from: fsimpl.h  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0358h extends CompoundButton {

    /* renamed from: a  reason: collision with root package name */
    static final Field f7994a = eV.a(28, -1, CompoundButton.class, "mButtonDrawable");
    static final Field b = eV.a(28, -1, CompoundButton.class, "mOnCheckedChangeListener");

    public static Drawable a(CompoundButton compoundButton) {
        return compoundButton.getButtonDrawable();
    }

    public static CompoundButton.OnCheckedChangeListener b(CompoundButton compoundButton) {
        Field field = b;
        if (field == null) {
            Log.d("CompoundButtonViolator: mOnCheckedChangeListener field was null");
            return null;
        }
        try {
            return (CompoundButton.OnCheckedChangeListener) field.get(compoundButton);
        } catch (Throwable th) {
            Log.e("Could not get mOnCheckedChangeListener on given CompoundButton", th);
            return null;
        }
    }
}
