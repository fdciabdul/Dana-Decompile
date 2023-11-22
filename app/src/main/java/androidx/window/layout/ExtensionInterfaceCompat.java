package androidx.window.layout;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/window/layout/ExtensionInterfaceCompat;", "", "Landroid/app/Activity;", "p0", "", "PlaceComponentResult", "(Landroid/app/Activity;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getAuthRequestContext", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "ExtensionCallbackInterface"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface ExtensionInterfaceCompat {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "", "Landroid/app/Activity;", "p0", "Landroidx/window/layout/WindowLayoutInfo;", "p1", "", "PlaceComponentResult", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface ExtensionCallbackInterface {
        void PlaceComponentResult(Activity p0, WindowLayoutInfo p1);
    }

    void BuiltInFictitiousFunctionClassFactory(Activity p0);

    void PlaceComponentResult(Activity p0);

    void getAuthRequestContext(ExtensionCallbackInterface p0);
}
