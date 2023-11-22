package id.dana.common.recyclerviewanimator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import id.dana.common.recyclerviewanimator.BaseItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class BaseItemAnimator<T> extends SimpleItemAnimator {
    Interpolator MyBillsEntityDataFactory;
    private TimeInterpolator newProxyInstance;
    ArrayList<RecyclerView.ViewHolder> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> PlaceComponentResult = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> getAuthRequestContext = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> getErrorConfigVersion = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> scheduleImpl = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList<>();
    private ArrayList<ChangeInfo> DatabaseTableConfigUtil = new ArrayList<>();
    private ArrayList<MoveInfo> isLayoutRequested = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> PrepareContext = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList<>();

    public abstract ViewPropertyAnimatorCompat GetContactSyncConfig(RecyclerView.ViewHolder viewHolder);

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda0(RecyclerView.ViewHolder viewHolder);

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda1(RecyclerView.ViewHolder viewHolder);

    public abstract ViewPropertyAnimatorCompat PlaceComponentResult(RecyclerView.ViewHolder viewHolder, ChangeInfo changeInfo);

    public abstract ViewPropertyAnimatorCompat getErrorConfigVersion(RecyclerView.ViewHolder viewHolder);

    public abstract void lookAheadTest(RecyclerView.ViewHolder viewHolder);

    public abstract ViewPropertyAnimatorCompat moveToNextValue(RecyclerView.ViewHolder viewHolder);

    abstract void scheduleImpl(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        boolean z = !this.PrepareContext.isEmpty();
        boolean z2 = !this.isLayoutRequested.isEmpty();
        boolean z3 = !this.DatabaseTableConfigUtil.isEmpty();
        boolean z4 = !this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.PrepareContext.iterator();
            while (it.hasNext()) {
                final RecyclerView.ViewHolder next = it.next();
                final ViewPropertyAnimatorCompat GetContactSyncConfig = GetContactSyncConfig(next);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.add(next);
                GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(new VpaListenerAdapter() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator.4
                    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void MyBillsEntityDataFactory(View view) {
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super((byte) 0);
                    }

                    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public void getAuthRequestContext(View view) {
                        GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2((ViewPropertyAnimatorListener) null);
                        BaseItemAnimator.this.NetworkUserEntityData$$ExternalSyntheticLambda1(next);
                        BaseItemAnimator baseItemAnimator = BaseItemAnimator.this;
                        RecyclerView.ViewHolder viewHolder = next;
                        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = baseItemAnimator.lookAheadTest;
                        if (itemAnimatorListener != null) {
                            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
                        }
                        BaseItemAnimator.this.NetworkUserEntityData$$ExternalSyntheticLambda8.remove(next);
                        BaseItemAnimator.MyBillsEntityDataFactory(BaseItemAnimator.this);
                    }
                }).PlaceComponentResult();
            }
            this.PrepareContext.clear();
            if (z2) {
                final ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.isLayoutRequested);
                this.scheduleImpl.add(arrayList);
                this.isLayoutRequested.clear();
                Runnable runnable = new Runnable() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final BaseItemAnimator baseItemAnimator = BaseItemAnimator.this;
                        ArrayList arrayList2 = arrayList;
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            BaseItemAnimator.MoveInfo moveInfo = (BaseItemAnimator.MoveInfo) it2.next();
                            final RecyclerView.ViewHolder viewHolder = moveInfo.PlaceComponentResult;
                            int i = moveInfo.getAuthRequestContext;
                            int i2 = moveInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                            int i3 = moveInfo.MyBillsEntityDataFactory;
                            int i4 = moveInfo.BuiltInFictitiousFunctionClassFactory;
                            View view = viewHolder.itemView;
                            final int i5 = i3 - i;
                            final int i6 = i4 - i2;
                            if (i5 != 0) {
                                ViewCompat.MyBillsEntityDataFactory(view).MyBillsEntityDataFactory(0.0f);
                            }
                            if (i6 != 0) {
                                ViewCompat.MyBillsEntityDataFactory(view).PlaceComponentResult(0.0f);
                            }
                            final ViewPropertyAnimatorCompat MyBillsEntityDataFactory = ViewCompat.MyBillsEntityDataFactory(view);
                            baseItemAnimator.getErrorConfigVersion.add(viewHolder);
                            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(baseItemAnimator.initRecordTimeStamp).KClassImpl$Data$declaredNonStaticMembers$2(new BaseItemAnimator.VpaListenerAdapter() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator.1
                                @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                public void MyBillsEntityDataFactory(View view2) {
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super((byte) 0);
                                }

                                @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                public void getAuthRequestContext(View view2) {
                                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2((ViewPropertyAnimatorListener) null);
                                    BaseItemAnimator baseItemAnimator2 = BaseItemAnimator.this;
                                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = baseItemAnimator2.lookAheadTest;
                                    if (itemAnimatorListener != null) {
                                        itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder2);
                                    }
                                    BaseItemAnimator.this.getErrorConfigVersion.remove(viewHolder);
                                    BaseItemAnimator.MyBillsEntityDataFactory(BaseItemAnimator.this);
                                }

                                @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                public void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                                    if (i5 != 0) {
                                        view2.setTranslationX(0.0f);
                                    }
                                    if (i6 != 0) {
                                        view2.setTranslationY(0.0f);
                                    }
                                }
                            }).PlaceComponentResult();
                        }
                        arrayList2.clear();
                        baseItemAnimator.scheduleImpl.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.PlaceComponentResult(arrayList.get(0).PlaceComponentResult.itemView, runnable, 0L);
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.DatabaseTableConfigUtil);
                this.getAuthRequestContext.add(arrayList2);
                this.DatabaseTableConfigUtil.clear();
                Runnable runnable2 = new Runnable() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        final BaseItemAnimator baseItemAnimator = BaseItemAnimator.this;
                        ArrayList arrayList3 = arrayList2;
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            final BaseItemAnimator.ChangeInfo changeInfo = (BaseItemAnimator.ChangeInfo) it2.next();
                            final RecyclerView.ViewHolder viewHolder = changeInfo.MyBillsEntityDataFactory;
                            View view = viewHolder == null ? null : viewHolder.itemView;
                            final RecyclerView.ViewHolder viewHolder2 = changeInfo.getAuthRequestContext;
                            final View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
                            if (view != null) {
                                final ViewPropertyAnimatorCompat PlaceComponentResult = baseItemAnimator.PlaceComponentResult(viewHolder, changeInfo);
                                baseItemAnimator.PlaceComponentResult.add(changeInfo.MyBillsEntityDataFactory);
                                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(new BaseItemAnimator.VpaListenerAdapter() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator.2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super((byte) 0);
                                    }

                                    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void MyBillsEntityDataFactory(View view3) {
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.MyBillsEntityDataFactory;
                                    }

                                    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void getAuthRequestContext(View view3) {
                                        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2((ViewPropertyAnimatorListener) null);
                                        BaseItemAnimator.this.NetworkUserEntityData$$ExternalSyntheticLambda0(viewHolder);
                                        view3.setTranslationX(0.0f);
                                        view3.setTranslationY(0.0f);
                                        BaseItemAnimator baseItemAnimator2 = BaseItemAnimator.this;
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.MyBillsEntityDataFactory;
                                        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = baseItemAnimator2.lookAheadTest;
                                        if (itemAnimatorListener != null) {
                                            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder3);
                                        }
                                        BaseItemAnimator.this.PlaceComponentResult.remove(changeInfo.MyBillsEntityDataFactory);
                                        BaseItemAnimator.MyBillsEntityDataFactory(BaseItemAnimator.this);
                                    }
                                }).PlaceComponentResult();
                            }
                            if (view2 != null) {
                                final ViewPropertyAnimatorCompat moveToNextValue = baseItemAnimator.moveToNextValue(viewHolder2);
                                baseItemAnimator.PlaceComponentResult.add(changeInfo.getAuthRequestContext);
                                moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(new BaseItemAnimator.VpaListenerAdapter() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator.3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super((byte) 0);
                                    }

                                    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void MyBillsEntityDataFactory(View view3) {
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.getAuthRequestContext;
                                    }

                                    @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                    public void getAuthRequestContext(View view3) {
                                        moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2((ViewPropertyAnimatorListener) null);
                                        BaseItemAnimator.this.NetworkUserEntityData$$ExternalSyntheticLambda0(viewHolder2);
                                        view2.setTranslationX(0.0f);
                                        view2.setTranslationY(0.0f);
                                        BaseItemAnimator baseItemAnimator2 = BaseItemAnimator.this;
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.getAuthRequestContext;
                                        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = baseItemAnimator2.lookAheadTest;
                                        if (itemAnimatorListener != null) {
                                            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder3);
                                        }
                                        BaseItemAnimator.this.PlaceComponentResult.remove(changeInfo.getAuthRequestContext);
                                        BaseItemAnimator.MyBillsEntityDataFactory(BaseItemAnimator.this);
                                    }
                                }).PlaceComponentResult();
                            }
                        }
                        arrayList3.clear();
                        baseItemAnimator.getAuthRequestContext.remove(arrayList3);
                    }
                };
                if (z) {
                    ViewCompat.PlaceComponentResult(arrayList2.get(0).MyBillsEntityDataFactory.itemView, runnable2, getAuthRequestContext(this.GetContactSyncConfig, z2 ? this.initRecordTimeStamp : 0L, this.moveToNextValue));
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                this.BuiltInFictitiousFunctionClassFactory.add(arrayList3);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                Runnable runnable3 = new Runnable() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        final BaseItemAnimator baseItemAnimator = BaseItemAnimator.this;
                        ArrayList arrayList4 = arrayList3;
                        Iterator it2 = arrayList4.iterator();
                        while (it2.hasNext()) {
                            final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it2.next();
                            final ViewPropertyAnimatorCompat errorConfigVersion = baseItemAnimator.getErrorConfigVersion(viewHolder);
                            baseItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2.add(viewHolder);
                            errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(new BaseItemAnimator.VpaListenerAdapter() { // from class: id.dana.common.recyclerviewanimator.BaseItemAnimator.5
                                @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                public void MyBillsEntityDataFactory(View view) {
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super((byte) 0);
                                }

                                @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                public void getAuthRequestContext(View view) {
                                    errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2((ViewPropertyAnimatorListener) null);
                                    BaseItemAnimator baseItemAnimator2 = BaseItemAnimator.this;
                                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = baseItemAnimator2.lookAheadTest;
                                    if (itemAnimatorListener != null) {
                                        itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder2);
                                    }
                                    BaseItemAnimator.this.KClassImpl$Data$declaredNonStaticMembers$2.remove(viewHolder);
                                    BaseItemAnimator.MyBillsEntityDataFactory(BaseItemAnimator.this);
                                    BaseItemAnimator.this.scheduleImpl(viewHolder);
                                }

                                @Override // id.dana.common.recyclerviewanimator.BaseItemAnimator.VpaListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                                public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
                                    BaseItemAnimator.this.scheduleImpl(viewHolder);
                                }
                            }).PlaceComponentResult();
                        }
                        arrayList4.clear();
                        baseItemAnimator.BuiltInFictitiousFunctionClassFactory.remove(arrayList4);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.PlaceComponentResult(arrayList3.get(0).itemView, runnable3, BuiltInFictitiousFunctionClassFactory(z ? this.GetContactSyncConfig : 0L, z2 ? this.initRecordTimeStamp : 0L, z3 ? this.moveToNextValue : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.MyBillsEntityDataFactory(viewHolder.itemView).BuiltInFictitiousFunctionClassFactory();
        int size = this.isLayoutRequested.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.isLayoutRequested.get(size).PlaceComponentResult == viewHolder) {
                viewHolder.itemView.setTranslationY(0.0f);
                viewHolder.itemView.setTranslationX(0.0f);
                RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
                if (itemAnimatorListener != null) {
                    itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
                }
                this.isLayoutRequested.remove(size);
            }
        }
        PlaceComponentResult(this.DatabaseTableConfigUtil, viewHolder);
        if (this.PrepareContext.remove(viewHolder)) {
            NetworkUserEntityData$$ExternalSyntheticLambda1(viewHolder);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener2 = this.lookAheadTest;
            if (itemAnimatorListener2 != null) {
                itemAnimatorListener2.BuiltInFictitiousFunctionClassFactory(viewHolder);
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(viewHolder)) {
            scheduleImpl(viewHolder);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener3 = this.lookAheadTest;
            if (itemAnimatorListener3 != null) {
                itemAnimatorListener3.BuiltInFictitiousFunctionClassFactory(viewHolder);
            }
        }
        for (int size2 = this.getAuthRequestContext.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.getAuthRequestContext.get(size2);
            PlaceComponentResult(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.getAuthRequestContext.remove(size2);
            }
        }
        for (int size3 = this.scheduleImpl.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.scheduleImpl.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).PlaceComponentResult == viewHolder) {
                    viewHolder.itemView.setTranslationY(0.0f);
                    viewHolder.itemView.setTranslationX(0.0f);
                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener4 = this.lookAheadTest;
                    if (itemAnimatorListener4 != null) {
                        itemAnimatorListener4.BuiltInFictitiousFunctionClassFactory(viewHolder);
                    }
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.scheduleImpl.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.BuiltInFictitiousFunctionClassFactory.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.BuiltInFictitiousFunctionClassFactory.get(size5);
            if (arrayList3.remove(viewHolder)) {
                scheduleImpl(viewHolder);
                RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener5 = this.lookAheadTest;
                if (itemAnimatorListener5 != null) {
                    itemAnimatorListener5.BuiltInFictitiousFunctionClassFactory(viewHolder);
                }
                if (arrayList3.isEmpty()) {
                    this.BuiltInFictitiousFunctionClassFactory.remove(size5);
                }
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.remove(viewHolder);
        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(viewHolder);
        this.PlaceComponentResult.remove(viewHolder);
        this.getErrorConfigVersion.remove(viewHolder);
        if (getAuthRequestContext()) {
            return;
        }
        MyBillsEntityDataFactory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean getAuthRequestContext() {
        return (this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty() && this.DatabaseTableConfigUtil.isEmpty() && this.isLayoutRequested.isEmpty() && this.PrepareContext.isEmpty() && this.getErrorConfigVersion.isEmpty() && this.NetworkUserEntityData$$ExternalSyntheticLambda8.isEmpty() && this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() && this.PlaceComponentResult.isEmpty() && this.scheduleImpl.isEmpty() && this.BuiltInFictitiousFunctionClassFactory.isEmpty() && this.getAuthRequestContext.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.BuiltInFictitiousFunctionClassFactory(viewHolder, list);
    }

    private void PlaceComponentResult(ChangeInfo changeInfo) {
        if (changeInfo.MyBillsEntityDataFactory != null) {
            PlaceComponentResult(changeInfo, changeInfo.MyBillsEntityDataFactory);
        }
        if (changeInfo.getAuthRequestContext != null) {
            PlaceComponentResult(changeInfo, changeInfo.getAuthRequestContext);
        }
    }

    private static void getAuthRequestContext(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.MyBillsEntityDataFactory(list.get(size).itemView).BuiltInFictitiousFunctionClassFactory();
        }
    }

    private boolean PlaceComponentResult(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        if (changeInfo.getAuthRequestContext == viewHolder) {
            changeInfo.getAuthRequestContext = null;
        } else if (changeInfo.MyBillsEntityDataFactory != viewHolder) {
            return false;
        } else {
            changeInfo.MyBillsEntityDataFactory = null;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0(viewHolder);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            return true;
        }
        return true;
    }

    public long getAuthRequestContext(long j, long j2, long j3) {
        return j + Math.max(j2, j3);
    }

    public long BuiltInFictitiousFunctionClassFactory(long j, long j2, long j3) {
        return j + Math.max(j2, j3);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder) {
        DatabaseTableConfigUtil(viewHolder);
        this.PrepareContext.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder) {
        DatabaseTableConfigUtil(viewHolder);
        lookAheadTest(viewHolder);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        DatabaseTableConfigUtil(viewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            DatabaseTableConfigUtil(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i5);
            viewHolder2.itemView.setTranslationY(-i6);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.DatabaseTableConfigUtil.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4, (byte) 0));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = (int) (i + viewHolder.itemView.getTranslationX());
        int translationY = (int) (i2 + viewHolder.itemView.getTranslationY());
        DatabaseTableConfigUtil(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 != 0 || i6 != 0) {
            if (i5 != 0) {
                view.setTranslationX(-i5);
            }
            if (i6 != 0) {
                view.setTranslationY(-i6);
            }
            this.isLayoutRequested.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4, (byte) 0));
            return true;
        }
        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            return false;
        }
        return false;
    }

    private void DatabaseTableConfigUtil(RecyclerView.ViewHolder viewHolder) {
        if (this.newProxyInstance == null) {
            this.newProxyInstance = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(this.newProxyInstance);
        KClassImpl$Data$declaredNonStaticMembers$2(viewHolder);
    }

    private void PlaceComponentResult(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (PlaceComponentResult(changeInfo, viewHolder) && changeInfo.MyBillsEntityDataFactory == null && changeInfo.getAuthRequestContext == null) {
                list.remove(changeInfo);
            }
        }
    }

    /* loaded from: classes4.dex */
    static class MoveInfo {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        RecyclerView.ViewHolder PlaceComponentResult;
        int getAuthRequestContext;

        /* synthetic */ MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4, byte b) {
            this(viewHolder, i, i2, i3, i4);
        }

        private MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.PlaceComponentResult = viewHolder;
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.MyBillsEntityDataFactory = i3;
            this.BuiltInFictitiousFunctionClassFactory = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class ChangeInfo {
        int BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        RecyclerView.ViewHolder MyBillsEntityDataFactory;
        int NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        RecyclerView.ViewHolder getAuthRequestContext;

        /* synthetic */ ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4, byte b) {
            this(viewHolder, viewHolder2, i, i2, i3, i4);
        }

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.PlaceComponentResult = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.BuiltInFictitiousFunctionClassFactory = i3;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i4;
        }

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.MyBillsEntityDataFactory = viewHolder;
            this.getAuthRequestContext = viewHolder2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", newHolder=");
            sb.append(this.getAuthRequestContext);
            sb.append(", fromX=");
            sb.append(this.PlaceComponentResult);
            sb.append(", fromY=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", toX=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", toY=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void MyBillsEntityDataFactory(View view) {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void getAuthRequestContext(View view) {
        }

        private VpaListenerAdapter() {
        }

        /* synthetic */ VpaListenerAdapter(byte b) {
            this();
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(BaseItemAnimator baseItemAnimator) {
        if (baseItemAnimator.getAuthRequestContext()) {
            return;
        }
        baseItemAnimator.MyBillsEntityDataFactory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void PlaceComponentResult() {
        int size = this.isLayoutRequested.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.isLayoutRequested.get(size);
            View view = moveInfo.PlaceComponentResult.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            RecyclerView.ViewHolder viewHolder = moveInfo.PlaceComponentResult;
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            }
            this.isLayoutRequested.remove(size);
        }
        for (int size2 = this.PrepareContext.size() - 1; size2 >= 0; size2--) {
            RecyclerView.ViewHolder viewHolder2 = this.PrepareContext.get(size2);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener2 = this.lookAheadTest;
            if (itemAnimatorListener2 != null) {
                itemAnimatorListener2.BuiltInFictitiousFunctionClassFactory(viewHolder2);
            }
            this.PrepareContext.remove(size2);
        }
        for (int size3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(size3);
            scheduleImpl(viewHolder3);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener3 = this.lookAheadTest;
            if (itemAnimatorListener3 != null) {
                itemAnimatorListener3.BuiltInFictitiousFunctionClassFactory(viewHolder3);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(size3);
        }
        for (int size4 = this.DatabaseTableConfigUtil.size() - 1; size4 >= 0; size4--) {
            PlaceComponentResult(this.DatabaseTableConfigUtil.get(size4));
        }
        this.DatabaseTableConfigUtil.clear();
        if (getAuthRequestContext()) {
            for (int size5 = this.scheduleImpl.size() - 1; size5 >= 0; size5--) {
                ArrayList<MoveInfo> arrayList = this.scheduleImpl.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = arrayList.get(size6);
                    View view2 = moveInfo2.PlaceComponentResult.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    RecyclerView.ViewHolder viewHolder4 = moveInfo2.PlaceComponentResult;
                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener4 = this.lookAheadTest;
                    if (itemAnimatorListener4 != null) {
                        itemAnimatorListener4.BuiltInFictitiousFunctionClassFactory(viewHolder4);
                    }
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.scheduleImpl.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.BuiltInFictitiousFunctionClassFactory.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.BuiltInFictitiousFunctionClassFactory.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder5 = arrayList2.get(size8);
                    scheduleImpl(viewHolder5);
                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener5 = this.lookAheadTest;
                    if (itemAnimatorListener5 != null) {
                        itemAnimatorListener5.BuiltInFictitiousFunctionClassFactory(viewHolder5);
                    }
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.BuiltInFictitiousFunctionClassFactory.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.getAuthRequestContext.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.getAuthRequestContext.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    PlaceComponentResult(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.getAuthRequestContext.remove(arrayList3);
                    }
                }
            }
            getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            getAuthRequestContext(this.getErrorConfigVersion);
            getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            getAuthRequestContext(this.PlaceComponentResult);
            MyBillsEntityDataFactory();
        }
    }
}
