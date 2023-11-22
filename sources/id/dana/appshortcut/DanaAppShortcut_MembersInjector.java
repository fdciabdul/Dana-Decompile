package id.dana.appshortcut;

import dagger.MembersInjector;
import id.dana.appshortcut.DanaAppShortcutContract;

/* loaded from: classes4.dex */
public final class DanaAppShortcut_MembersInjector implements MembersInjector<DanaAppShortcut> {
    public static void getAuthRequestContext(DanaAppShortcut danaAppShortcut, DanaAppShortcutContract.Presenter presenter) {
        danaAppShortcut.danaAppShortcutPresenter = presenter;
    }
}
