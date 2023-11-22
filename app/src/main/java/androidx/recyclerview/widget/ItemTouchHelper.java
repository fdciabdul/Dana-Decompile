package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    RecyclerView GetContactSyncConfig;
    Callback KClassImpl$Data$declaredNonStaticMembers$2;
    private float NetworkUserEntityData$$ExternalSyntheticLambda3;
    private float NetworkUserEntityData$$ExternalSyntheticLambda4;
    private ItemTouchHelperGestureListener NetworkUserEntityData$$ExternalSyntheticLambda5;
    private float NetworkUserEntityData$$ExternalSyntheticLambda6;
    private long NetworkUserEntityData$$ExternalSyntheticLambda7;
    float PlaceComponentResult;
    private List<Integer> PrepareContext;
    private Rect SubSequence;
    float getAuthRequestContext;
    float getErrorConfigVersion;
    private int getSupportButtonTintMode;
    int isLayoutRequested;
    float lookAheadTest;
    GestureDetectorCompat moveToNextValue;
    VelocityTracker newProxyInstance;
    private List<RecyclerView.ViewHolder> readMicros;
    private float whenAvailable;
    final List<View> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayList();
    private final float[] getCallingPid = new float[2];
    RecyclerView.ViewHolder DatabaseTableConfigUtil = null;
    int MyBillsEntityDataFactory = -1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    List<RecoverAnimation> initRecordTimeStamp = new ArrayList();
    final Runnable NetworkUserEntityData$$ExternalSyntheticLambda1 = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (ItemTouchHelper.this.DatabaseTableConfigUtil == null || !ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2()) {
                return;
            }
            if (ItemTouchHelper.this.DatabaseTableConfigUtil != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.PlaceComponentResult(itemTouchHelper.DatabaseTableConfigUtil);
            }
            ItemTouchHelper.this.GetContactSyncConfig.removeCallbacks(ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            ViewCompat.PlaceComponentResult(ItemTouchHelper.this.GetContactSyncConfig, this);
        }
    };
    RecyclerView.ChildDrawingOrderCallback BuiltInFictitiousFunctionClassFactory = null;
    View scheduleImpl = null;
    int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private final RecyclerView.OnItemTouchListener FragmentBottomSheetPaymentSettingBinding = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final boolean MyBillsEntityDataFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            ItemTouchHelper.this.moveToNextValue.MyBillsEntityDataFactory(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            RecoverAnimation recoverAnimation = null;
            if (actionMasked == 0) {
                ItemTouchHelper.this.MyBillsEntityDataFactory = motionEvent.getPointerId(0);
                ItemTouchHelper.this.lookAheadTest = motionEvent.getX();
                ItemTouchHelper.this.getErrorConfigVersion = motionEvent.getY();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                VelocityTracker velocityTracker = itemTouchHelper.newProxyInstance;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                itemTouchHelper.newProxyInstance = VelocityTracker.obtain();
                if (ItemTouchHelper.this.DatabaseTableConfigUtil == null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    if (!itemTouchHelper2.initRecordTimeStamp.isEmpty()) {
                        View MyBillsEntityDataFactory = itemTouchHelper2.MyBillsEntityDataFactory(motionEvent);
                        int size = itemTouchHelper2.initRecordTimeStamp.size() - 1;
                        while (true) {
                            if (size < 0) {
                                break;
                            }
                            RecoverAnimation recoverAnimation2 = itemTouchHelper2.initRecordTimeStamp.get(size);
                            if (recoverAnimation2.DatabaseTableConfigUtil.itemView == MyBillsEntityDataFactory) {
                                recoverAnimation = recoverAnimation2;
                                break;
                            }
                            size--;
                        }
                    }
                    if (recoverAnimation != null) {
                        ItemTouchHelper.this.lookAheadTest -= recoverAnimation.isLayoutRequested;
                        ItemTouchHelper.this.getErrorConfigVersion -= recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        ItemTouchHelper.this.getAuthRequestContext(recoverAnimation.DatabaseTableConfigUtil, true);
                        if (ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(recoverAnimation.DatabaseTableConfigUtil.itemView)) {
                            ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2.clearView(ItemTouchHelper.this.GetContactSyncConfig, recoverAnimation.DatabaseTableConfigUtil);
                        }
                        ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(recoverAnimation.DatabaseTableConfigUtil, recoverAnimation.BuiltInFictitiousFunctionClassFactory);
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.BuiltInFictitiousFunctionClassFactory(motionEvent, itemTouchHelper3.isLayoutRequested, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.MyBillsEntityDataFactory = -1;
                ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(null, 0);
            } else if (ItemTouchHelper.this.MyBillsEntityDataFactory != -1 && (findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.MyBillsEntityDataFactory)) >= 0) {
                ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(actionMasked, motionEvent, findPointerIndex);
            }
            if (ItemTouchHelper.this.newProxyInstance != null) {
                ItemTouchHelper.this.newProxyInstance.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.DatabaseTableConfigUtil != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.moveToNextValue.MyBillsEntityDataFactory(motionEvent);
            if (ItemTouchHelper.this.newProxyInstance != null) {
                ItemTouchHelper.this.newProxyInstance.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.MyBillsEntityDataFactory == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.MyBillsEntityDataFactory);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(actionMasked, motionEvent, findPointerIndex);
            }
            RecyclerView.ViewHolder viewHolder = ItemTouchHelper.this.DatabaseTableConfigUtil;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.BuiltInFictitiousFunctionClassFactory(motionEvent, itemTouchHelper.isLayoutRequested, findPointerIndex);
                        ItemTouchHelper.this.PlaceComponentResult(viewHolder);
                        ItemTouchHelper.this.GetContactSyncConfig.removeCallbacks(ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda1.run();
                        ItemTouchHelper.this.GetContactSyncConfig.invalidate();
                        return;
                    }
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.MyBillsEntityDataFactory) {
                            ItemTouchHelper.this.MyBillsEntityDataFactory = motionEvent.getPointerId(actionIndex != 0 ? 0 : 1);
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            itemTouchHelper2.BuiltInFictitiousFunctionClassFactory(motionEvent, itemTouchHelper2.isLayoutRequested, actionIndex);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (ItemTouchHelper.this.newProxyInstance != null) {
                    ItemTouchHelper.this.newProxyInstance.clear();
                }
            }
            ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(null, 0);
            ItemTouchHelper.this.MyBillsEntityDataFactory = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            if (z) {
                ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(null, 0);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void MyBillsEntityDataFactory(View view) {
    }

    public ItemTouchHelper(Callback callback) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
    }

    private static boolean PlaceComponentResult(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.GetContactSyncConfig;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.GetContactSyncConfig.removeOnItemTouchListener(this.FragmentBottomSheetPaymentSettingBinding);
            this.GetContactSyncConfig.removeOnChildAttachStateChangeListener(this);
            int size = this.initRecordTimeStamp.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                RecoverAnimation recoverAnimation = this.initRecordTimeStamp.get(0);
                recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda2.cancel();
                this.KClassImpl$Data$declaredNonStaticMembers$2.clearView(this.GetContactSyncConfig, recoverAnimation.DatabaseTableConfigUtil);
            }
            this.initRecordTimeStamp.clear();
            this.scheduleImpl = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
            VelocityTracker velocityTracker = this.newProxyInstance;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.newProxyInstance = null;
            }
            ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            if (itemTouchHelperGestureListener != null) {
                itemTouchHelperGestureListener.getAuthRequestContext = false;
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
            }
            if (this.moveToNextValue != null) {
                this.moveToNextValue = null;
            }
        }
        this.GetContactSyncConfig = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.whenAvailable = resources.getDimension(R.dimen.lookAheadTest);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = resources.getDimension(R.dimen.PlaceComponentResult);
            this.getSupportButtonTintMode = ViewConfiguration.get(this.GetContactSyncConfig.getContext()).getScaledTouchSlop();
            this.GetContactSyncConfig.addItemDecoration(this);
            this.GetContactSyncConfig.addOnItemTouchListener(this.FragmentBottomSheetPaymentSettingBinding);
            this.GetContactSyncConfig.addOnChildAttachStateChangeListener(this);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ItemTouchHelperGestureListener();
            this.moveToNextValue = new GestureDetectorCompat(this.GetContactSyncConfig.getContext(), this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        }
    }

    private void MyBillsEntityDataFactory(float[] fArr) {
        if ((this.isLayoutRequested & 12) != 0) {
            fArr[0] = (this.NetworkUserEntityData$$ExternalSyntheticLambda4 + this.PlaceComponentResult) - this.DatabaseTableConfigUtil.itemView.getLeft();
        } else {
            fArr[0] = this.DatabaseTableConfigUtil.itemView.getTranslationX();
        }
        if ((this.isLayoutRequested & 3) != 0) {
            fArr[1] = (this.NetworkUserEntityData$$ExternalSyntheticLambda6 + this.getAuthRequestContext) - this.DatabaseTableConfigUtil.itemView.getTop();
        } else {
            fArr[1] = this.DatabaseTableConfigUtil.itemView.getTranslationY();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.DatabaseTableConfigUtil != null) {
            MyBillsEntityDataFactory(this.getCallingPid);
            float[] fArr = this.getCallingPid;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.onDrawOver(canvas, recyclerView, this.DatabaseTableConfigUtil, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda8, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        if (this.DatabaseTableConfigUtil != null) {
            MyBillsEntityDataFactory(this.getCallingPid);
            float[] fArr = this.getCallingPid;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.onDraw(canvas, recyclerView, this.DatabaseTableConfigUtil, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda8, f, f2);
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        boolean z;
        RecyclerView.ViewHolder viewHolder2;
        float signum;
        float f;
        if (viewHolder == this.DatabaseTableConfigUtil && i == this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = Long.MIN_VALUE;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        getAuthRequestContext(viewHolder, true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
        if (i == 2) {
            if (viewHolder == null) {
                throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
            }
            this.scheduleImpl = viewHolder.itemView;
            PlaceComponentResult();
        }
        final RecyclerView.ViewHolder viewHolder3 = this.DatabaseTableConfigUtil;
        if (viewHolder3 != null) {
            if (viewHolder3.itemView.getParent() != null) {
                int MyBillsEntityDataFactory = i3 == 2 ? 0 : MyBillsEntityDataFactory(viewHolder3);
                VelocityTracker velocityTracker = this.newProxyInstance;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.newProxyInstance = null;
                }
                if (MyBillsEntityDataFactory != 1 && MyBillsEntityDataFactory != 2) {
                    f = (MyBillsEntityDataFactory == 4 || MyBillsEntityDataFactory == 8 || MyBillsEntityDataFactory == 16 || MyBillsEntityDataFactory == 32) ? Math.signum(this.PlaceComponentResult) * this.GetContactSyncConfig.getWidth() : 0.0f;
                    signum = 0.0f;
                } else {
                    signum = Math.signum(this.getAuthRequestContext) * this.GetContactSyncConfig.getHeight();
                    f = 0.0f;
                }
                int i4 = i3 == 2 ? 8 : MyBillsEntityDataFactory > 0 ? 2 : 4;
                MyBillsEntityDataFactory(this.getCallingPid);
                float[] fArr = this.getCallingPid;
                float f2 = fArr[0];
                float f3 = fArr[1];
                final int i5 = MyBillsEntityDataFactory;
                i2 = 0;
                RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder3, i4, i3, f2, f3, f, signum) { // from class: androidx.recyclerview.widget.ItemTouchHelper.3
                    @Override // androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.lookAheadTest) {
                            return;
                        }
                        if (i5 <= 0) {
                            ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2.clearView(ItemTouchHelper.this.GetContactSyncConfig, viewHolder3);
                        } else {
                            ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(viewHolder3.itemView);
                            this.moveToNextValue = true;
                            final int i6 = i5;
                            if (i6 > 0) {
                                final ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                                itemTouchHelper.GetContactSyncConfig.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ItemTouchHelper.this.GetContactSyncConfig == null || !ItemTouchHelper.this.GetContactSyncConfig.isAttachedToWindow() || this.lookAheadTest || this.DatabaseTableConfigUtil.getAbsoluteAdapterPosition() == -1) {
                                            return;
                                        }
                                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.GetContactSyncConfig.getItemAnimator();
                                        if ((itemAnimator == null || !itemAnimator.BuiltInFictitiousFunctionClassFactory()) && !ItemTouchHelper.this.getAuthRequestContext()) {
                                            ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2.onSwiped(this.DatabaseTableConfigUtil, i6);
                                        } else {
                                            ItemTouchHelper.this.GetContactSyncConfig.post(this);
                                        }
                                    }
                                });
                            }
                        }
                        if (ItemTouchHelper.this.scheduleImpl == viewHolder3.itemView) {
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            if (viewHolder3.itemView == itemTouchHelper2.scheduleImpl) {
                                itemTouchHelper2.scheduleImpl = null;
                                if (itemTouchHelper2.BuiltInFictitiousFunctionClassFactory != null) {
                                    itemTouchHelper2.GetContactSyncConfig.setChildDrawingOrderCallback(null);
                                }
                            }
                        }
                    }
                };
                recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda2.setDuration(this.KClassImpl$Data$declaredNonStaticMembers$2.getAnimationDuration(this.GetContactSyncConfig, i4, f - f2, signum - f3));
                this.initRecordTimeStamp.add(recoverAnimation);
                recoverAnimation.DatabaseTableConfigUtil.setIsRecyclable(false);
                recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda2.start();
                viewHolder2 = null;
                z = true;
            } else {
                i2 = 0;
                if (viewHolder3.itemView == this.scheduleImpl) {
                    viewHolder2 = null;
                    this.scheduleImpl = null;
                    if (this.BuiltInFictitiousFunctionClassFactory != null) {
                        this.GetContactSyncConfig.setChildDrawingOrderCallback(null);
                    }
                } else {
                    viewHolder2 = null;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.clearView(this.GetContactSyncConfig, viewHolder3);
                z = false;
            }
            this.DatabaseTableConfigUtil = viewHolder2;
        } else {
            i2 = 0;
            z = false;
        }
        if (viewHolder != null) {
            this.isLayoutRequested = (this.KClassImpl$Data$declaredNonStaticMembers$2.getAbsoluteMovementFlags(this.GetContactSyncConfig, viewHolder) & ((1 << ((i * 8) + 8)) - 1)) >> (this.NetworkUserEntityData$$ExternalSyntheticLambda8 * 8);
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = viewHolder.itemView.getLeft();
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = viewHolder.itemView.getTop();
            this.DatabaseTableConfigUtil = viewHolder;
            if (i == 2) {
                viewHolder.itemView.performHapticFeedback(i2);
            }
        }
        ViewParent parent = this.GetContactSyncConfig.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.DatabaseTableConfigUtil != null);
        }
        if (!z) {
            this.GetContactSyncConfig.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.onSelectedChanged(this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.GetContactSyncConfig.invalidate();
    }

    final boolean getAuthRequestContext() {
        int size = this.initRecordTimeStamp.size();
        for (int i = 0; i < size; i++) {
            if (!this.initRecordTimeStamp.get(i).NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c4, code lost:
    
        if (r1 <= 0) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.KClassImpl$Data$declaredNonStaticMembers$2():boolean");
    }

    final void PlaceComponentResult(RecyclerView.ViewHolder viewHolder) {
        int i;
        int i2;
        int i3;
        if (!this.GetContactSyncConfig.isLayoutRequested() && this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 2) {
            float moveThreshold = this.KClassImpl$Data$declaredNonStaticMembers$2.getMoveThreshold(viewHolder);
            int i4 = (int) (this.NetworkUserEntityData$$ExternalSyntheticLambda4 + this.PlaceComponentResult);
            int i5 = (int) (this.NetworkUserEntityData$$ExternalSyntheticLambda6 + this.getAuthRequestContext);
            if (Math.abs(i5 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i4 - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.ViewHolder> list = this.readMicros;
                if (list == null) {
                    this.readMicros = new ArrayList();
                    this.PrepareContext = new ArrayList();
                } else {
                    list.clear();
                    this.PrepareContext.clear();
                }
                int boundingBoxMargin = this.KClassImpl$Data$declaredNonStaticMembers$2.getBoundingBoxMargin();
                int round = Math.round(this.NetworkUserEntityData$$ExternalSyntheticLambda4 + this.PlaceComponentResult) - boundingBoxMargin;
                int round2 = Math.round(this.NetworkUserEntityData$$ExternalSyntheticLambda6 + this.getAuthRequestContext) - boundingBoxMargin;
                int i6 = boundingBoxMargin * 2;
                int width = viewHolder.itemView.getWidth() + round + i6;
                int height = viewHolder.itemView.getHeight() + round2 + i6;
                int i7 = (round + width) / 2;
                int i8 = (round2 + height) / 2;
                RecyclerView.LayoutManager layoutManager = this.GetContactSyncConfig.getLayoutManager();
                int childCount = layoutManager.getChildCount();
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt = layoutManager.getChildAt(i9);
                    if (childAt == viewHolder.itemView || childAt.getBottom() < round2 || childAt.getTop() > height || childAt.getRight() < round || childAt.getLeft() > width) {
                        i = i7;
                        i2 = round;
                        i3 = round2;
                    } else {
                        RecyclerView.ViewHolder childViewHolder = this.GetContactSyncConfig.getChildViewHolder(childAt);
                        i2 = round;
                        i3 = round2;
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.canDropOver(this.GetContactSyncConfig, this.DatabaseTableConfigUtil, childViewHolder)) {
                            int abs = Math.abs(i7 - ((childAt.getLeft() + childAt.getRight()) / 2));
                            int abs2 = Math.abs(i8 - ((childAt.getTop() + childAt.getBottom()) / 2));
                            int i10 = (abs * abs) + (abs2 * abs2);
                            int size = this.readMicros.size();
                            int i11 = 0;
                            int i12 = 0;
                            while (true) {
                                i = i7;
                                if (i12 >= size || i10 <= this.PrepareContext.get(i12).intValue()) {
                                    break;
                                }
                                i11++;
                                i12++;
                                i7 = i;
                            }
                            this.readMicros.add(i11, childViewHolder);
                            this.PrepareContext.add(i11, Integer.valueOf(i10));
                        } else {
                            i = i7;
                        }
                    }
                    i9++;
                    round = i2;
                    round2 = i3;
                    i7 = i;
                }
                List<RecyclerView.ViewHolder> list2 = this.readMicros;
                if (list2.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder chooseDropTarget = this.KClassImpl$Data$declaredNonStaticMembers$2.chooseDropTarget(viewHolder, list2, i4, i5);
                if (chooseDropTarget == null) {
                    this.readMicros.clear();
                    this.PrepareContext.clear();
                    return;
                }
                int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
                int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.onMove(this.GetContactSyncConfig, viewHolder, chooseDropTarget)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.onMoved(this.GetContactSyncConfig, viewHolder, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i4, i5);
                }
            }
        }
    }

    final void getAuthRequestContext(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.initRecordTimeStamp.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.initRecordTimeStamp.get(size);
            if (recoverAnimation.DatabaseTableConfigUtil == viewHolder) {
                recoverAnimation.lookAheadTest |= z;
                if (!recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda2.cancel();
                }
                this.initRecordTimeStamp.remove(size);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    final void KClassImpl$Data$declaredNonStaticMembers$2(int i, MotionEvent motionEvent, int i2) {
        int absoluteMovementFlags;
        View MyBillsEntityDataFactory;
        if (this.DatabaseTableConfigUtil == null && i == 2 && this.NetworkUserEntityData$$ExternalSyntheticLambda8 != 2 && this.KClassImpl$Data$declaredNonStaticMembers$2.isItemViewSwipeEnabled() && this.GetContactSyncConfig.getScrollState() != 1) {
            RecyclerView.LayoutManager layoutManager = this.GetContactSyncConfig.getLayoutManager();
            int i3 = this.MyBillsEntityDataFactory;
            RecyclerView.ViewHolder viewHolder = null;
            if (i3 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i3);
                float x = motionEvent.getX(findPointerIndex);
                float f = this.lookAheadTest;
                float y = motionEvent.getY(findPointerIndex);
                float f2 = this.getErrorConfigVersion;
                float abs = Math.abs(x - f);
                float abs2 = Math.abs(y - f2);
                float f3 = this.getSupportButtonTintMode;
                if ((abs >= f3 || abs2 >= f3) && ((abs <= abs2 || !layoutManager.canScrollHorizontally()) && ((abs2 <= abs || !layoutManager.canScrollVertically()) && (MyBillsEntityDataFactory = MyBillsEntityDataFactory(motionEvent)) != null))) {
                    viewHolder = this.GetContactSyncConfig.getChildViewHolder(MyBillsEntityDataFactory);
                }
            }
            if (viewHolder == null || (absoluteMovementFlags = (this.KClassImpl$Data$declaredNonStaticMembers$2.getAbsoluteMovementFlags(this.GetContactSyncConfig, viewHolder) & 65280) >> 8) == 0) {
                return;
            }
            float x2 = motionEvent.getX(i2);
            float y2 = motionEvent.getY(i2);
            float f4 = x2 - this.lookAheadTest;
            float f5 = y2 - this.getErrorConfigVersion;
            float abs3 = Math.abs(f4);
            float abs4 = Math.abs(f5);
            float f6 = this.getSupportButtonTintMode;
            if (abs3 >= f6 || abs4 >= f6) {
                if (abs3 > abs4) {
                    if (f4 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                        return;
                    }
                    if (f4 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                        return;
                    }
                } else if (f5 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                } else {
                    if (f5 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                        return;
                    }
                }
                this.getAuthRequestContext = 0.0f;
                this.PlaceComponentResult = 0.0f;
                this.MyBillsEntityDataFactory = motionEvent.getPointerId(0);
                KClassImpl$Data$declaredNonStaticMembers$2(viewHolder, 1);
            }
        }
    }

    final View MyBillsEntityDataFactory(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.DatabaseTableConfigUtil;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (PlaceComponentResult(view, x, y, this.NetworkUserEntityData$$ExternalSyntheticLambda4 + this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda6 + this.getAuthRequestContext)) {
                return view;
            }
        }
        for (int size = this.initRecordTimeStamp.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.initRecordTimeStamp.get(size);
            View view2 = recoverAnimation.DatabaseTableConfigUtil.itemView;
            if (PlaceComponentResult(view2, x, y, recoverAnimation.isLayoutRequested, recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
                return view2;
            }
        }
        return this.GetContactSyncConfig.findChildViewUnder(x, y);
    }

    final void BuiltInFictitiousFunctionClassFactory(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.lookAheadTest;
        this.PlaceComponentResult = f;
        this.getAuthRequestContext = y - this.getErrorConfigVersion;
        if ((i & 4) == 0) {
            this.PlaceComponentResult = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.PlaceComponentResult = Math.min(0.0f, this.PlaceComponentResult);
        }
        if ((i & 1) == 0) {
            this.getAuthRequestContext = Math.max(0.0f, this.getAuthRequestContext);
        }
        if ((i & 2) == 0) {
            this.getAuthRequestContext = Math.min(0.0f, this.getAuthRequestContext);
        }
    }

    private int MyBillsEntityDataFactory(RecyclerView.ViewHolder viewHolder) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 2) {
            return 0;
        }
        int movementFlags = this.KClassImpl$Data$declaredNonStaticMembers$2.getMovementFlags(this.GetContactSyncConfig, viewHolder);
        int convertToAbsoluteDirection = (this.KClassImpl$Data$declaredNonStaticMembers$2.convertToAbsoluteDirection(movementFlags, ViewCompat.initRecordTimeStamp(this.GetContactSyncConfig)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.PlaceComponentResult) > Math.abs(this.getAuthRequestContext)) {
            int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(viewHolder, convertToAbsoluteDirection);
            if (BuiltInFictitiousFunctionClassFactory > 0) {
                return (i & BuiltInFictitiousFunctionClassFactory) == 0 ? Callback.convertToRelativeDirection(BuiltInFictitiousFunctionClassFactory, ViewCompat.initRecordTimeStamp(this.GetContactSyncConfig)) : BuiltInFictitiousFunctionClassFactory;
            }
            int authRequestContext = getAuthRequestContext(viewHolder, convertToAbsoluteDirection);
            if (authRequestContext > 0) {
                return authRequestContext;
            }
        } else {
            int authRequestContext2 = getAuthRequestContext(viewHolder, convertToAbsoluteDirection);
            if (authRequestContext2 > 0) {
                return authRequestContext2;
            }
            int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(viewHolder, convertToAbsoluteDirection);
            if (BuiltInFictitiousFunctionClassFactory2 > 0) {
                return (i & BuiltInFictitiousFunctionClassFactory2) == 0 ? Callback.convertToRelativeDirection(BuiltInFictitiousFunctionClassFactory2, ViewCompat.initRecordTimeStamp(this.GetContactSyncConfig)) : BuiltInFictitiousFunctionClassFactory2;
            }
        }
        return 0;
    }

    private int BuiltInFictitiousFunctionClassFactory(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) != 0) {
            int i2 = this.PlaceComponentResult > 0.0f ? 8 : 4;
            VelocityTracker velocityTracker = this.newProxyInstance;
            if (velocityTracker != null && this.MyBillsEntityDataFactory >= 0) {
                velocityTracker.computeCurrentVelocity(1000, this.KClassImpl$Data$declaredNonStaticMembers$2.getSwipeVelocityThreshold(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
                float xVelocity = this.newProxyInstance.getXVelocity(this.MyBillsEntityDataFactory);
                float yVelocity = this.newProxyInstance.getYVelocity(this.MyBillsEntityDataFactory);
                int i3 = xVelocity > 0.0f ? 8 : 4;
                float abs = Math.abs(xVelocity);
                if ((i3 & i) != 0 && i2 == i3 && abs >= this.KClassImpl$Data$declaredNonStaticMembers$2.getSwipeEscapeVelocity(this.whenAvailable) && abs > Math.abs(yVelocity)) {
                    return i3;
                }
            }
            float width = this.GetContactSyncConfig.getWidth();
            float swipeThreshold = this.KClassImpl$Data$declaredNonStaticMembers$2.getSwipeThreshold(viewHolder);
            if ((i & i2) == 0 || Math.abs(this.PlaceComponentResult) <= width * swipeThreshold) {
                return 0;
            }
            return i2;
        }
        return 0;
    }

    private int getAuthRequestContext(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) != 0) {
            int i2 = this.getAuthRequestContext > 0.0f ? 2 : 1;
            VelocityTracker velocityTracker = this.newProxyInstance;
            if (velocityTracker != null && this.MyBillsEntityDataFactory >= 0) {
                velocityTracker.computeCurrentVelocity(1000, this.KClassImpl$Data$declaredNonStaticMembers$2.getSwipeVelocityThreshold(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
                float xVelocity = this.newProxyInstance.getXVelocity(this.MyBillsEntityDataFactory);
                float yVelocity = this.newProxyInstance.getYVelocity(this.MyBillsEntityDataFactory);
                int i3 = yVelocity > 0.0f ? 2 : 1;
                float abs = Math.abs(yVelocity);
                if ((i3 & i) != 0 && i3 == i2 && abs >= this.KClassImpl$Data$declaredNonStaticMembers$2.getSwipeEscapeVelocity(this.whenAvailable) && abs > Math.abs(xVelocity)) {
                    return i3;
                }
            }
            float height = this.GetContactSyncConfig.getHeight();
            float swipeThreshold = this.KClassImpl$Data$declaredNonStaticMembers$2.getSwipeThreshold(viewHolder);
            if ((i & i2) == 0 || Math.abs(this.getAuthRequestContext) <= height * swipeThreshold) {
                return 0;
            }
            return i2;
        }
        return 0;
    }

    private void PlaceComponentResult() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new RecyclerView.ChildDrawingOrderCallback() { // from class: androidx.recyclerview.widget.ItemTouchHelper.5
                @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
                public final int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
                    if (ItemTouchHelper.this.scheduleImpl == null) {
                        return i2;
                    }
                    int i3 = ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (i3 == -1) {
                        i3 = ItemTouchHelper.this.GetContactSyncConfig.indexOfChild(ItemTouchHelper.this.scheduleImpl);
                        ItemTouchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3;
                    }
                    return i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
                }
            };
        }
        this.GetContactSyncConfig.setChildDrawingOrderCallback(this.BuiltInFictitiousFunctionClassFactory);
    }

    /* loaded from: classes3.dex */
    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f * f * f * f * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i5 | i3;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & RELATIVE_DIR_FLAGS;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i5 | i3;
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.MyBillsEntityDataFactory;
        }

        public static int makeMovementFlags(int i, int i2) {
            int makeFlag = makeFlag(0, i2 | i);
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.initRecordTimeStamp(recyclerView));
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 16711680) != 0;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = viewHolder.itemView.getWidth();
            int height = viewHolder.itemView.getHeight();
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i4);
                if (left2 > 0 && (right = viewHolder3.itemView.getRight() - (i + width)) < 0 && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i2) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - (i2 + height)) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i3) {
                    viewHolder2 = viewHolder3;
                    i3 = abs;
                }
            }
            return viewHolder2;
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                ItemTouchUIUtil itemTouchUIUtil = ItemTouchUIUtilImpl.MyBillsEntityDataFactory;
                View view = viewHolder.itemView;
            }
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.getAuthRequestContext);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                float f3 = recoverAnimation.scheduleImpl;
                float f4 = recoverAnimation.initRecordTimeStamp;
                if (f3 == f4) {
                    recoverAnimation.isLayoutRequested = recoverAnimation.DatabaseTableConfigUtil.itemView.getTranslationX();
                } else {
                    recoverAnimation.isLayoutRequested = f3 + (recoverAnimation.getErrorConfigVersion * (f4 - f3));
                }
                float f5 = recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda1;
                float f6 = recoverAnimation.GetContactSyncConfig;
                if (f5 == f6) {
                    recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda7 = recoverAnimation.DatabaseTableConfigUtil.itemView.getTranslationY();
                } else {
                    recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda7 = f5 + (recoverAnimation.getErrorConfigVersion * (f6 - f5));
                }
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.DatabaseTableConfigUtil, recoverAnimation.isLayoutRequested, recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda7, recoverAnimation.BuiltInFictitiousFunctionClassFactory, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.DatabaseTableConfigUtil, recoverAnimation.isLayoutRequested, recoverAnimation.NetworkUserEntityData$$ExternalSyntheticLambda7, recoverAnimation.BuiltInFictitiousFunctionClassFactory, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                RecoverAnimation recoverAnimation2 = list.get(i3);
                if (recoverAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0 && !recoverAnimation2.moveToNextValue) {
                    list.remove(i3);
                } else if (!recoverAnimation2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.MyBillsEntityDataFactory.PlaceComponentResult(viewHolder.itemView);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            ItemTouchUIUtilImpl.MyBillsEntityDataFactory.MyBillsEntityDataFactory(recyclerView, viewHolder.itemView, f, f2, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            ItemTouchUIUtil itemTouchUIUtil = ItemTouchUIUtilImpl.MyBillsEntityDataFactory;
            View view = viewHolder.itemView;
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200L : 250L;
            } else if (i == 8) {
                return itemAnimator.initRecordTimeStamp;
            } else {
                return itemAnimator.GetContactSyncConfig;
            }
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int signum = (int) (((int) (((int) Math.signum(i2)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * sDragScrollInterpolator.getInterpolation(j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? ((float) j) / 2000.0f : 1.0f));
            return signum == 0 ? i2 > 0 ? 1 : -1 : signum;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.mDefaultSwipeDirs = i;
        }

        public void setDefaultDragDirs(int i) {
            this.mDefaultDragDirs = i;
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        boolean getAuthRequestContext = true;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        ItemTouchHelperGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View MyBillsEntityDataFactory;
            RecyclerView.ViewHolder childViewHolder;
            if (this.getAuthRequestContext && (MyBillsEntityDataFactory = ItemTouchHelper.this.MyBillsEntityDataFactory(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.GetContactSyncConfig.getChildViewHolder(MyBillsEntityDataFactory)) != null && ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2.hasDragFlag(ItemTouchHelper.this.GetContactSyncConfig, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.MyBillsEntityDataFactory) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.MyBillsEntityDataFactory);
                float x = motionEvent.getX(findPointerIndex);
                float y = motionEvent.getY(findPointerIndex);
                ItemTouchHelper.this.lookAheadTest = x;
                ItemTouchHelper.this.getErrorConfigVersion = y;
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                itemTouchHelper.getAuthRequestContext = 0.0f;
                itemTouchHelper.PlaceComponentResult = 0.0f;
                if (ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2.isLongPressDragEnabled()) {
                    ItemTouchHelper.this.KClassImpl$Data$declaredNonStaticMembers$2(childViewHolder, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RecoverAnimation implements Animator.AnimatorListener {
        final int BuiltInFictitiousFunctionClassFactory;
        final RecyclerView.ViewHolder DatabaseTableConfigUtil;
        final float GetContactSyncConfig;
        final float NetworkUserEntityData$$ExternalSyntheticLambda1;
        final ValueAnimator NetworkUserEntityData$$ExternalSyntheticLambda2;
        float NetworkUserEntityData$$ExternalSyntheticLambda7;
        final int PlaceComponentResult;
        float getErrorConfigVersion;
        final float initRecordTimeStamp;
        float isLayoutRequested;
        boolean moveToNextValue;
        final float scheduleImpl;
        boolean lookAheadTest = false;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.PlaceComponentResult = i;
            this.DatabaseTableConfigUtil = viewHolder;
            this.scheduleImpl = f;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = f2;
            this.initRecordTimeStamp = f3;
            this.GetContactSyncConfig = f4;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.getErrorConfigVersion = valueAnimator.getAnimatedFraction();
                }
            });
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            this.getErrorConfigVersion = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                this.DatabaseTableConfigUtil.setIsRecyclable(true);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.getErrorConfigVersion = 1.0f;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void getAuthRequestContext(View view) {
        if (view == this.scheduleImpl) {
            this.scheduleImpl = null;
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                this.GetContactSyncConfig.setChildDrawingOrderCallback(null);
            }
        }
        RecyclerView.ViewHolder childViewHolder = this.GetContactSyncConfig.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.DatabaseTableConfigUtil;
        if (viewHolder != null && childViewHolder == viewHolder) {
            KClassImpl$Data$declaredNonStaticMembers$2(null, 0);
            return;
        }
        getAuthRequestContext(childViewHolder, false);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.remove(childViewHolder.itemView)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.clearView(this.GetContactSyncConfig, childViewHolder);
        }
    }
}
