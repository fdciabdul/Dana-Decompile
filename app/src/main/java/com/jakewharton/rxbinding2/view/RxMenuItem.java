package com.jakewharton.rxbinding2.view;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/* loaded from: classes8.dex */
public final class RxMenuItem {
    public static Observable<Object> clicks(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new MenuItemClickOnSubscribe(menuItem, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<Object> clicks(MenuItem menuItem, Predicate<? super MenuItem> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new MenuItemClickOnSubscribe(menuItem, predicate);
    }

    public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new MenuItemActionViewEventObservable(menuItem, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<MenuItemActionViewEvent> actionViewEvents(MenuItem menuItem, Predicate<? super MenuItemActionViewEvent> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new MenuItemActionViewEventObservable(menuItem, predicate);
    }

    @Deprecated
    public static Consumer<? super Boolean> checked(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<Boolean>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Boolean bool) {
                menuItem.setChecked(bool.booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> enabled(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<Boolean>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Boolean bool) {
                menuItem.setEnabled(bool.booleanValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Drawable> icon(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<Drawable>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Drawable drawable) {
                menuItem.setIcon(drawable);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> iconRes(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<Integer>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Integer num) {
                menuItem.setIcon(num.intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super CharSequence> title(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<CharSequence>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.5
            @Override // io.reactivex.functions.Consumer
            public final void accept(CharSequence charSequence) {
                menuItem.setTitle(charSequence);
            }
        };
    }

    @Deprecated
    public static Consumer<? super Integer> titleRes(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<Integer>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Integer num) {
                menuItem.setTitle(num.intValue());
            }
        };
    }

    @Deprecated
    public static Consumer<? super Boolean> visible(final MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new Consumer<Boolean>() { // from class: com.jakewharton.rxbinding2.view.RxMenuItem.7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Boolean bool) {
                menuItem.setVisible(bool.booleanValue());
            }
        };
    }

    private RxMenuItem() {
        throw new AssertionError("No instances.");
    }
}
