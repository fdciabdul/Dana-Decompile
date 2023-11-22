package io.reactivex.disposables;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CompositeDisposable implements Disposable, DisposableContainer {
    volatile boolean KClassImpl$Data$declaredNonStaticMembers$2;
    OpenHashSet<Disposable> MyBillsEntityDataFactory;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            OpenHashSet<Disposable> openHashSet = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = null;
            getAuthRequestContext(openHashSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // io.reactivex.internal.disposables.DisposableContainer
    public final boolean getAuthRequestContext(Disposable disposable) {
        ObjectHelper.PlaceComponentResult(disposable, "disposable is null");
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
            synchronized (this) {
                if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    OpenHashSet<Disposable> openHashSet = this.MyBillsEntityDataFactory;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.MyBillsEntityDataFactory = openHashSet;
                    }
                    openHashSet.BuiltInFictitiousFunctionClassFactory(disposable);
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
        ObjectHelper.PlaceComponentResult(disposable, "disposables is null");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return false;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            OpenHashSet<Disposable> openHashSet = this.MyBillsEntityDataFactory;
            if (openHashSet != null) {
                if (openHashSet.getAuthRequestContext(disposable)) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            OpenHashSet<Disposable> openHashSet = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = null;
            getAuthRequestContext(openHashSet);
        }
    }

    public final int getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return 0;
        }
        synchronized (this) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return 0;
            }
            OpenHashSet<Disposable> openHashSet = this.MyBillsEntityDataFactory;
            return openHashSet != null ? openHashSet.MyBillsEntityDataFactory : 0;
        }
    }

    private static void getAuthRequestContext(OpenHashSet<Disposable> openHashSet) {
        if (openHashSet == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Disposable disposable : openHashSet.PlaceComponentResult) {
            if (disposable instanceof Disposable) {
                try {
                    disposable.dispose();
                } catch (Throwable th) {
                    Exceptions.MyBillsEntityDataFactory(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
