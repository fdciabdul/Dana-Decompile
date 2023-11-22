package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {
    private static TimeInterpolator DatabaseTableConfigUtil;
    private ArrayList<RecyclerView.ViewHolder> isLayoutRequested = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList<>();
    private ArrayList<MoveInfo> NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList<>();
    private ArrayList<ChangeInfo> NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> PlaceComponentResult = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> scheduleImpl = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> MyBillsEntityDataFactory = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> getErrorConfigVersion = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> getAuthRequestContext = new ArrayList<>();

    /* loaded from: classes6.dex */
    static class MoveInfo {
        public int BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public RecyclerView.ViewHolder PlaceComponentResult;
        public int getAuthRequestContext;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.PlaceComponentResult = viewHolder;
            this.MyBillsEntityDataFactory = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.getAuthRequestContext = i3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ChangeInfo {
        public RecyclerView.ViewHolder BuiltInFictitiousFunctionClassFactory;
        public RecyclerView.ViewHolder KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        public int getAuthRequestContext;
        public int scheduleImpl;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = viewHolder;
            this.BuiltInFictitiousFunctionClassFactory = viewHolder2;
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.getAuthRequestContext = i;
            this.MyBillsEntityDataFactory = i2;
            this.PlaceComponentResult = i3;
            this.scheduleImpl = i4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", newHolder=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", fromX=");
            sb.append(this.getAuthRequestContext);
            sb.append(", fromY=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", toX=");
            sb.append(this.PlaceComponentResult);
            sb.append(", toY=");
            sb.append(this.scheduleImpl);
            sb.append('}');
            return sb.toString();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        boolean z = !this.isLayoutRequested.isEmpty();
        boolean z2 = !this.NetworkUserEntityData$$ExternalSyntheticLambda7.isEmpty();
        boolean z3 = !this.NetworkUserEntityData$$ExternalSyntheticLambda8.isEmpty();
        boolean z4 = !this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.isLayoutRequested.iterator();
            while (it.hasNext()) {
                final RecyclerView.ViewHolder next = it.next();
                final View view = next.itemView;
                final ViewPropertyAnimator animate = view.animate();
                this.getErrorConfigVersion.add(next);
                animate.setDuration(this.GetContactSyncConfig).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        animate.setListener(null);
                        view.setAlpha(1.0f);
                        DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                        RecyclerView.ViewHolder viewHolder = next;
                        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = defaultItemAnimator.lookAheadTest;
                        if (itemAnimatorListener != null) {
                            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
                        }
                        DefaultItemAnimator.this.getErrorConfigVersion.remove(next);
                        DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                        if (defaultItemAnimator2.getAuthRequestContext()) {
                            return;
                        }
                        defaultItemAnimator2.MyBillsEntityDataFactory();
                    }
                }).start();
            }
            this.isLayoutRequested.clear();
            if (z2) {
                final ArrayList<MoveInfo> arrayList = new ArrayList<>();
                arrayList.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                this.scheduleImpl.add(arrayList);
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                            final RecyclerView.ViewHolder viewHolder = moveInfo.PlaceComponentResult;
                            int i = moveInfo.MyBillsEntityDataFactory;
                            int i2 = moveInfo.BuiltInFictitiousFunctionClassFactory;
                            int i3 = moveInfo.getAuthRequestContext;
                            int i4 = moveInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                            final View view2 = viewHolder.itemView;
                            final int i5 = i3 - i;
                            final int i6 = i4 - i2;
                            if (i5 != 0) {
                                view2.animate().translationX(0.0f);
                            }
                            if (i6 != 0) {
                                view2.animate().translationY(0.0f);
                            }
                            final ViewPropertyAnimator animate2 = view2.animate();
                            defaultItemAnimator.MyBillsEntityDataFactory.add(viewHolder);
                            animate2.setDuration(defaultItemAnimator.initRecordTimeStamp).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                    if (i5 != 0) {
                                        view2.setTranslationX(0.0f);
                                    }
                                    if (i6 != 0) {
                                        view2.setTranslationY(0.0f);
                                    }
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    animate2.setListener(null);
                                    DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = defaultItemAnimator2.lookAheadTest;
                                    if (itemAnimatorListener != null) {
                                        itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder2);
                                    }
                                    DefaultItemAnimator.this.MyBillsEntityDataFactory.remove(viewHolder);
                                    DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                    if (defaultItemAnimator3.getAuthRequestContext()) {
                                        return;
                                    }
                                    defaultItemAnimator3.MyBillsEntityDataFactory();
                                }
                            }).start();
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.scheduleImpl.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.PlaceComponentResult(arrayList.get(0).PlaceComponentResult.itemView, runnable, this.GetContactSyncConfig);
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<ChangeInfo> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                this.BuiltInFictitiousFunctionClassFactory.add(arrayList2);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            final ChangeInfo changeInfo = (ChangeInfo) it2.next();
                            final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                            RecyclerView.ViewHolder viewHolder = changeInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                            final View view2 = viewHolder == null ? null : viewHolder.itemView;
                            RecyclerView.ViewHolder viewHolder2 = changeInfo.BuiltInFictitiousFunctionClassFactory;
                            final View view3 = viewHolder2 != null ? viewHolder2.itemView : null;
                            if (view2 != null) {
                                final ViewPropertyAnimator duration = view2.animate().setDuration(defaultItemAnimator.moveToNextValue);
                                defaultItemAnimator.getAuthRequestContext.add(changeInfo.KClassImpl$Data$declaredNonStaticMembers$2);
                                duration.translationX(changeInfo.PlaceComponentResult - changeInfo.getAuthRequestContext);
                                duration.translationY(changeInfo.scheduleImpl - changeInfo.MyBillsEntityDataFactory);
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationStart(Animator animator) {
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                                    }

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
                                        duration.setListener(null);
                                        view2.setAlpha(1.0f);
                                        view2.setTranslationX(0.0f);
                                        view2.setTranslationY(0.0f);
                                        DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                                        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = defaultItemAnimator2.lookAheadTest;
                                        if (itemAnimatorListener != null) {
                                            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder3);
                                        }
                                        DefaultItemAnimator.this.getAuthRequestContext.remove(changeInfo.KClassImpl$Data$declaredNonStaticMembers$2);
                                        DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                        if (defaultItemAnimator3.getAuthRequestContext()) {
                                            return;
                                        }
                                        defaultItemAnimator3.MyBillsEntityDataFactory();
                                    }
                                }).start();
                            }
                            if (view3 != null) {
                                final ViewPropertyAnimator animate2 = view3.animate();
                                defaultItemAnimator.getAuthRequestContext.add(changeInfo.BuiltInFictitiousFunctionClassFactory);
                                animate2.translationX(0.0f).translationY(0.0f).setDuration(defaultItemAnimator.moveToNextValue).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.8
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationStart(Animator animator) {
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.BuiltInFictitiousFunctionClassFactory;
                                    }

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
                                        animate2.setListener(null);
                                        view3.setAlpha(1.0f);
                                        view3.setTranslationX(0.0f);
                                        view3.setTranslationY(0.0f);
                                        DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                        RecyclerView.ViewHolder viewHolder3 = changeInfo.BuiltInFictitiousFunctionClassFactory;
                                        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = defaultItemAnimator2.lookAheadTest;
                                        if (itemAnimatorListener != null) {
                                            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder3);
                                        }
                                        DefaultItemAnimator.this.getAuthRequestContext.remove(changeInfo.BuiltInFictitiousFunctionClassFactory);
                                        DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                        if (defaultItemAnimator3.getAuthRequestContext()) {
                                            return;
                                        }
                                        defaultItemAnimator3.MyBillsEntityDataFactory();
                                    }
                                }).start();
                            }
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.BuiltInFictitiousFunctionClassFactory.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.PlaceComponentResult(arrayList2.get(0).KClassImpl$Data$declaredNonStaticMembers$2.itemView, runnable2, this.GetContactSyncConfig);
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                this.PlaceComponentResult.add(arrayList3);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it2.next();
                            final DefaultItemAnimator defaultItemAnimator = DefaultItemAnimator.this;
                            final View view2 = viewHolder.itemView;
                            final ViewPropertyAnimator animate2 = view2.animate();
                            defaultItemAnimator.KClassImpl$Data$declaredNonStaticMembers$2.add(viewHolder);
                            animate2.alpha(1.0f).setDuration(defaultItemAnimator.NetworkUserEntityData$$ExternalSyntheticLambda0).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.5
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                    view2.setAlpha(1.0f);
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    animate2.setListener(null);
                                    DefaultItemAnimator defaultItemAnimator2 = DefaultItemAnimator.this;
                                    RecyclerView.ViewHolder viewHolder2 = viewHolder;
                                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = defaultItemAnimator2.lookAheadTest;
                                    if (itemAnimatorListener != null) {
                                        itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder2);
                                    }
                                    DefaultItemAnimator.this.KClassImpl$Data$declaredNonStaticMembers$2.remove(viewHolder);
                                    DefaultItemAnimator defaultItemAnimator3 = DefaultItemAnimator.this;
                                    if (defaultItemAnimator3.getAuthRequestContext()) {
                                        return;
                                    }
                                    defaultItemAnimator3.MyBillsEntityDataFactory();
                                }
                            }).start();
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.PlaceComponentResult.remove(arrayList3);
                    }
                };
                if (!z && !z2 && !z3) {
                    runnable3.run();
                    return;
                }
                ViewCompat.PlaceComponentResult(arrayList3.get(0).itemView, runnable3, (z ? this.GetContactSyncConfig : 0L) + Math.max(z2 ? this.initRecordTimeStamp : 0L, z3 ? this.moveToNextValue : 0L));
            }
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder) {
        scheduleImpl(viewHolder);
        this.isLayoutRequested.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean PlaceComponentResult(RecyclerView.ViewHolder viewHolder) {
        scheduleImpl(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(viewHolder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = i + ((int) viewHolder.itemView.getTranslationX());
        int translationY = i2 + ((int) viewHolder.itemView.getTranslationY());
        scheduleImpl(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 != 0 || i6 != 0) {
            if (i5 != 0) {
                view.setTranslationX(-i5);
            }
            if (i6 != 0) {
                view.setTranslationY(-i6);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
            return true;
        }
        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            return false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        scheduleImpl(viewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            scheduleImpl(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i5);
            viewHolder2.itemView.setTranslationY(-i6);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (MyBillsEntityDataFactory(changeInfo, viewHolder) && changeInfo.KClassImpl$Data$declaredNonStaticMembers$2 == null && changeInfo.BuiltInFictitiousFunctionClassFactory == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void MyBillsEntityDataFactory(ChangeInfo changeInfo) {
        if (changeInfo.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            MyBillsEntityDataFactory(changeInfo, changeInfo.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (changeInfo.BuiltInFictitiousFunctionClassFactory != null) {
            MyBillsEntityDataFactory(changeInfo, changeInfo.BuiltInFictitiousFunctionClassFactory);
        }
    }

    private boolean MyBillsEntityDataFactory(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        if (changeInfo.BuiltInFictitiousFunctionClassFactory == viewHolder) {
            changeInfo.BuiltInFictitiousFunctionClassFactory = null;
        } else if (changeInfo.KClassImpl$Data$declaredNonStaticMembers$2 != viewHolder) {
            return false;
        } else {
            changeInfo.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            return true;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(size).PlaceComponentResult == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
                if (itemAnimatorListener != null) {
                    itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda7.remove(size);
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda8, viewHolder);
        if (this.isLayoutRequested.remove(viewHolder)) {
            view.setAlpha(1.0f);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener2 = this.lookAheadTest;
            if (itemAnimatorListener2 != null) {
                itemAnimatorListener2.BuiltInFictitiousFunctionClassFactory(viewHolder);
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(viewHolder)) {
            view.setAlpha(1.0f);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener3 = this.lookAheadTest;
            if (itemAnimatorListener3 != null) {
                itemAnimatorListener3.BuiltInFictitiousFunctionClassFactory(viewHolder);
            }
        }
        for (int size2 = this.BuiltInFictitiousFunctionClassFactory.size() - 1; size2 >= 0; size2--) {
            ArrayList<ChangeInfo> arrayList = this.BuiltInFictitiousFunctionClassFactory.get(size2);
            KClassImpl$Data$declaredNonStaticMembers$2(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.BuiltInFictitiousFunctionClassFactory.remove(size2);
            }
        }
        for (int size3 = this.scheduleImpl.size() - 1; size3 >= 0; size3--) {
            ArrayList<MoveInfo> arrayList2 = this.scheduleImpl.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).PlaceComponentResult == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
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
        for (int size5 = this.PlaceComponentResult.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.PlaceComponentResult.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener5 = this.lookAheadTest;
                if (itemAnimatorListener5 != null) {
                    itemAnimatorListener5.BuiltInFictitiousFunctionClassFactory(viewHolder);
                }
                if (arrayList3.isEmpty()) {
                    this.PlaceComponentResult.remove(size5);
                }
            }
        }
        this.getErrorConfigVersion.remove(viewHolder);
        this.KClassImpl$Data$declaredNonStaticMembers$2.remove(viewHolder);
        this.getAuthRequestContext.remove(viewHolder);
        this.MyBillsEntityDataFactory.remove(viewHolder);
        if (getAuthRequestContext()) {
            return;
        }
        MyBillsEntityDataFactory();
    }

    private void scheduleImpl(RecyclerView.ViewHolder viewHolder) {
        if (DatabaseTableConfigUtil == null) {
            DatabaseTableConfigUtil = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(DatabaseTableConfigUtil);
        KClassImpl$Data$declaredNonStaticMembers$2(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean getAuthRequestContext() {
        return (this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty() && this.NetworkUserEntityData$$ExternalSyntheticLambda8.isEmpty() && this.NetworkUserEntityData$$ExternalSyntheticLambda7.isEmpty() && this.isLayoutRequested.isEmpty() && this.MyBillsEntityDataFactory.isEmpty() && this.getErrorConfigVersion.isEmpty() && this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() && this.getAuthRequestContext.isEmpty() && this.scheduleImpl.isEmpty() && this.PlaceComponentResult.isEmpty() && this.BuiltInFictitiousFunctionClassFactory.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void PlaceComponentResult() {
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(size);
            View view = moveInfo.PlaceComponentResult.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            RecyclerView.ViewHolder viewHolder = moveInfo.PlaceComponentResult;
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener = this.lookAheadTest;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.BuiltInFictitiousFunctionClassFactory(viewHolder);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.remove(size);
        }
        for (int size2 = this.isLayoutRequested.size() - 1; size2 >= 0; size2--) {
            RecyclerView.ViewHolder viewHolder2 = this.isLayoutRequested.get(size2);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener2 = this.lookAheadTest;
            if (itemAnimatorListener2 != null) {
                itemAnimatorListener2.BuiltInFictitiousFunctionClassFactory(viewHolder2);
            }
            this.isLayoutRequested.remove(size2);
        }
        int size3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(size3);
            viewHolder3.itemView.setAlpha(1.0f);
            RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener3 = this.lookAheadTest;
            if (itemAnimatorListener3 != null) {
                itemAnimatorListener3.BuiltInFictitiousFunctionClassFactory(viewHolder3);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(size3);
        }
        for (int size4 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.size() - 1; size4 >= 0; size4--) {
            MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8.get(size4));
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.clear();
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
            for (int size7 = this.PlaceComponentResult.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.PlaceComponentResult.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder5 = arrayList2.get(size8);
                    viewHolder5.itemView.setAlpha(1.0f);
                    RecyclerView.ItemAnimator.ItemAnimatorListener itemAnimatorListener5 = this.lookAheadTest;
                    if (itemAnimatorListener5 != null) {
                        itemAnimatorListener5.BuiltInFictitiousFunctionClassFactory(viewHolder5);
                    }
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.PlaceComponentResult.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.BuiltInFictitiousFunctionClassFactory.size() - 1; size9 >= 0; size9--) {
                ArrayList<ChangeInfo> arrayList3 = this.BuiltInFictitiousFunctionClassFactory.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    MyBillsEntityDataFactory(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.BuiltInFictitiousFunctionClassFactory.remove(arrayList3);
                    }
                }
            }
            BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion);
            BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            MyBillsEntityDataFactory();
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.BuiltInFictitiousFunctionClassFactory(viewHolder, list);
    }
}
