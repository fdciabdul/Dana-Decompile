package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    List<Disposable> BuiltInFictitiousFunctionClassFactory;
    volatile boolean PlaceComponentResult;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.PlaceComponentResult) {
            return;
        }
        synchronized (this) {
            if (this.PlaceComponentResult) {
                return;
            }
            this.PlaceComponentResult = true;
            List<Disposable> list = this.BuiltInFictitiousFunctionClassFactory;
            ArrayList arrayList = null;
            this.BuiltInFictitiousFunctionClassFactory = null;
            if (list != null) {
                Iterator<Disposable> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().dispose();
                    } catch (Throwable th) {
                        Exceptions.MyBillsEntityDataFactory(th);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th);
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() == 1) {
                        throw ExceptionHelper.MyBillsEntityDataFactory((Throwable) arrayList.get(0));
                    }
                    throw new CompositeException(arrayList);
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.PlaceComponentResult;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean getAuthRequestContext(Disposable disposable) {
        ObjectHelper.PlaceComponentResult(disposable, "d is null");
        if (!this.PlaceComponentResult) {
            synchronized (this) {
                if (!this.PlaceComponentResult) {
                    List list = this.BuiltInFictitiousFunctionClassFactory;
                    if (list == null) {
                        list = new LinkedList();
                        this.BuiltInFictitiousFunctionClassFactory = list;
                    }
                    list.add(disposable);
                    return true;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean PlaceComponentResult(Disposable disposable) {
        if (MyBillsEntityDataFactory(disposable)) {
            disposable.dispose();
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean MyBillsEntityDataFactory(Disposable disposable) {
        ObjectHelper.PlaceComponentResult(disposable, "Disposable item is null");
        if (this.PlaceComponentResult) {
            return false;
        }
        synchronized (this) {
            if (this.PlaceComponentResult) {
                return false;
            }
            List<Disposable> list = this.BuiltInFictitiousFunctionClassFactory;
            if (list != null) {
                if (list.remove(disposable)) {
                    return true;
                }
            }
            return false;
        }
    }
}
