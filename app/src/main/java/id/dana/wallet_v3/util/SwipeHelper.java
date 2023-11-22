package id.dana.wallet_v3.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.extension.view.ViewExtKt;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.util.SwipeHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 M2\u00020\u0001:\u0003MNOB=\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u000e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\t\u0012\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00020=¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ)\u0010 \u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001eH&¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010$JG\u0010(\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b(\u0010)J'\u0010+\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u0010\u0004J\u001b\u00103\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\t¢\u0006\u0004\b3\u00104R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R&\u00108\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001e078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010CR\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u00106"}, d2 = {"Lid/dana/wallet_v3/util/SwipeHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "", "attachSwipe", "()V", "Landroid/graphics/Canvas;", "c", "Landroid/view/View;", "itemView", "", "Lid/dana/wallet_v3/util/SwipeHelper$UnderlayButton;", "buffer", "", "pos", "", "dX", "drawButtons", "(Landroid/graphics/Canvas;Landroid/view/View;Ljava/util/List;IF)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "getSwipeDirs", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "defaultValue", "getSwipeEscapeVelocity", "(F)F", "getSwipeThreshold", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)F", "getSwipeVelocityThreshold", "", "underlayButtons", "instantiateUnderlayButton", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "", "isVoucherCode", "(I)Z", "dY", "actionState", "isCurrentlyActive", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "target", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "direction", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "recoverSwipedItem", "Lid/dana/wallet_v3/model/VoucherAndTicketCardModel;", "list", "updateVoucherList", "(Ljava/util/List;)V", "buttons", "Ljava/util/List;", "", "buttonsBuffer", "Ljava/util/Map;", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "Lkotlin/Function1;", "onSwipe", "Lkotlin/jvm/functions/Function1;", "Ljava/util/Queue;", "recoverQueue", "Ljava/util/Queue;", "Landroidx/recyclerview/widget/RecyclerView;", "swipeThreshold", LogConstants.RESULT_FALSE, "swipedPos", "I", "voucherList", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Companion", "UnderlayButton", "UnderlayButtonClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class SwipeHelper extends ItemTouchHelper.SimpleCallback {
    public static final int BUTTON_WIDTH = 200;
    private List<UnderlayButton> buttons;
    private final Map<Integer, List<UnderlayButton>> buttonsBuffer;
    private final GestureDetector gestureDetector;
    private final Function1<Boolean, Unit> onSwipe;
    private Queue<Integer> recoverQueue;
    private final RecyclerView recyclerView;
    private float swipeThreshold;
    private int swipedPos;
    private List<? extends VoucherAndTicketCardModel> voucherList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/util/SwipeHelper$UnderlayButtonClickListener;", "", "", "pos", "", "onClick", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface UnderlayButtonClickListener {
        void onClick(int pos);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeEscapeVelocity(float defaultValue) {
        return defaultValue * 0.1f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeVelocityThreshold(float defaultValue) {
        return defaultValue * 5.0f;
    }

    public abstract void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons);

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(viewHolder, "");
        Intrinsics.checkNotNullParameter(target, "");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SwipeHelper(Context context, final RecyclerView recyclerView, List<? extends VoucherAndTicketCardModel> list, Function1<? super Boolean, Unit> function1) {
        super(0, 4);
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.voucherList = list;
        this.onSwipe = function1;
        this.swipedPos = -1;
        this.swipeThreshold = 0.5f;
        this.recyclerView = recyclerView;
        this.buttons = new ArrayList();
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: id.dana.wallet_v3.util.SwipeHelper$gestureListener$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onSingleTapConfirmed(MotionEvent e) {
                List list2;
                Intrinsics.checkNotNullParameter(e, "");
                list2 = SwipeHelper.this.buttons;
                Iterator it = list2.iterator();
                while (it.hasNext() && !((SwipeHelper.UnderlayButton) it.next()).onClick(e.getX(), e.getY())) {
                }
                return true;
            }
        });
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.wallet_v3.util.SwipeHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean m3029_init_$lambda0;
                m3029_init_$lambda0 = SwipeHelper.m3029_init_$lambda0(SwipeHelper.this, recyclerView, view, motionEvent);
                return m3029_init_$lambda0;
            }
        });
        this.buttonsBuffer = new HashMap();
        this.recoverQueue = new LinkedList<Integer>() { // from class: id.dana.wallet_v3.util.SwipeHelper.1
            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public final /* synthetic */ boolean add(Object obj) {
                return add(((Number) obj).intValue());
            }

            public final /* bridge */ boolean contains(Integer num) {
                return super.contains((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public final /* bridge */ boolean contains(Object obj) {
                if (obj instanceof Integer) {
                    return contains((Integer) obj);
                }
                return false;
            }

            public final int getSize() {
                return super.size();
            }

            public final /* bridge */ int indexOf(Integer num) {
                return super.indexOf((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
            public final /* bridge */ int indexOf(Object obj) {
                if (obj instanceof Integer) {
                    return indexOf((Integer) obj);
                }
                return -1;
            }

            public final /* bridge */ int lastIndexOf(Integer num) {
                return super.lastIndexOf((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.List
            public final /* bridge */ int lastIndexOf(Object obj) {
                if (obj instanceof Integer) {
                    return lastIndexOf((Integer) obj);
                }
                return -1;
            }

            @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public final Integer remove(int i) {
                return removeAt(i);
            }

            public final /* bridge */ boolean remove(Integer num) {
                return super.remove((Object) num);
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public final /* bridge */ boolean remove(Object obj) {
                if (obj == null ? true : obj instanceof Integer) {
                    return remove((Integer) obj);
                }
                return false;
            }

            public final Integer removeAt(int i) {
                return (Integer) super.remove(i);
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public final int size() {
                return getSize();
            }

            public final boolean add(int o2) {
                if (contains((Object) Integer.valueOf(o2))) {
                    return false;
                }
                return super.add((AnonymousClass1) Integer.valueOf(o2));
            }
        };
        attachSwipe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final boolean m3029_init_$lambda0(SwipeHelper swipeHelper, RecyclerView recyclerView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(swipeHelper, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        if (swipeHelper.swipedPos < 0) {
            return false;
        }
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(swipeHelper.swipedPos);
        View view2 = findViewHolderForAdapterPosition != null ? findViewHolderForAdapterPosition.itemView : null;
        if (view2 != null) {
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            boolean z = true;
            if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 2) {
                z = false;
            }
            if (z && rect.top < point.y && rect.bottom > point.y) {
                swipeHelper.gestureDetector.onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "");
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        if (this.swipedPos != absoluteAdapterPosition) {
            Queue<Integer> queue = this.recoverQueue;
            if (queue == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                queue = null;
            }
            queue.add(Integer.valueOf(this.swipedPos));
        }
        this.swipedPos = absoluteAdapterPosition;
        this.onSwipe.invoke(Boolean.TRUE);
        if (this.buttonsBuffer.containsKey(Integer.valueOf(this.swipedPos))) {
            List<UnderlayButton> list = this.buttonsBuffer.get(Integer.valueOf(this.swipedPos));
            if (list != null) {
                this.buttons = list;
            }
        } else {
            this.buttons.clear();
        }
        this.buttonsBuffer.clear();
        this.swipeThreshold = this.buttons.size() * 0.5f * 200.0f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
    public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(viewHolder, "");
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition < 0 || isVoucherCode(absoluteAdapterPosition)) {
            return super.getSwipeDirs(recyclerView, viewHolder);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "");
        return this.swipeThreshold;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        float f;
        Intrinsics.checkNotNullParameter(c, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(viewHolder, "");
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "");
        if (absoluteAdapterPosition < 0) {
            return;
        }
        if (actionState == 1) {
            if (dX < 0.0f) {
                List<UnderlayButton> arrayList = new ArrayList();
                if (!this.buttonsBuffer.containsKey(Integer.valueOf(absoluteAdapterPosition))) {
                    instantiateUnderlayButton(viewHolder, arrayList);
                    this.buttonsBuffer.put(Integer.valueOf(absoluteAdapterPosition), arrayList);
                } else {
                    List<UnderlayButton> list = this.buttonsBuffer.get(Integer.valueOf(absoluteAdapterPosition));
                    Intrinsics.checkNotNull(list);
                    arrayList = list;
                }
                float size = ((r3.size() * dX) * 200.0f) / view.getWidth();
                drawButtons(c, view, arrayList, absoluteAdapterPosition, size);
                if (this.swipedPos != absoluteAdapterPosition) {
                    Queue<Integer> queue = this.recoverQueue;
                    if (queue == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        queue = null;
                    }
                    queue.add(Integer.valueOf(this.swipedPos));
                }
                this.swipedPos = absoluteAdapterPosition;
                this.onSwipe.invoke(Boolean.TRUE);
                f = size;
                super.onChildDraw(c, recyclerView, viewHolder, f, dY, actionState, isCurrentlyActive);
            }
            this.swipedPos = -1;
            recoverSwipedItem();
            if (dX == 0.0f) {
                this.onSwipe.invoke(Boolean.FALSE);
            }
        }
        f = dX;
        super.onChildDraw(c, recyclerView, viewHolder, f, dY, actionState, isCurrentlyActive);
    }

    private final boolean isVoucherCode(int pos) {
        String couponCode;
        VoucherAndTicketCardModel voucherAndTicketCardModel = this.voucherList.get(pos);
        VoucherAndTicketCardModel.VoucherCard voucherCard = voucherAndTicketCardModel instanceof VoucherAndTicketCardModel.VoucherCard ? (VoucherAndTicketCardModel.VoucherCard) voucherAndTicketCardModel : null;
        return (voucherCard == null || (couponCode = voucherCard.getCouponCode()) == null || couponCode.length() <= 0) ? false : true;
    }

    private final void recoverSwipedItem() {
        synchronized (this) {
            while (true) {
                Queue<Integer> queue = this.recoverQueue;
                Queue<Integer> queue2 = null;
                if (queue == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    queue = null;
                }
                if (!queue.isEmpty()) {
                    Queue<Integer> queue3 = this.recoverQueue;
                    if (queue3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        queue2 = queue3;
                    }
                    Integer poll = queue2.poll();
                    if (poll != null && poll.intValue() >= 0) {
                        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
                        Intrinsics.checkNotNull(adapter);
                        adapter.notifyItemChanged(poll.intValue());
                    }
                }
            }
        }
    }

    private final void drawButtons(Canvas c, View itemView, List<UnderlayButton> buffer, int pos, float dX) {
        float right = itemView.getRight();
        float size = (dX * (-1.0f)) / buffer.size();
        Iterator<UnderlayButton> it = buffer.iterator();
        while (it.hasNext()) {
            float f = right - size;
            it.next().onDraw(c, new RectF(f, itemView.getTop(), right, itemView.getBottom()), pos, itemView);
            right = f;
        }
    }

    private final void attachSwipe() {
        new ItemTouchHelper(this).KClassImpl$Data$declaredNonStaticMembers$2(this.recyclerView);
    }

    public final void updateVoucherList(List<? extends VoucherAndTicketCardModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.voucherList = list;
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014"}, d2 = {"Lid/dana/wallet_v3/util/SwipeHelper$UnderlayButton;", "", "", "x", "y", "", "onClick", "(FF)Z", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/RectF;", "rect", "", "pos", "Landroid/view/View;", "itemView", "", "onDraw", "(Landroid/graphics/Canvas;Landroid/graphics/RectF;ILandroid/view/View;)V", "buttonBackgroundcolor", "I", "Lid/dana/wallet_v3/util/SwipeHelper$UnderlayButtonClickListener;", "clickListener", "Lid/dana/wallet_v3/util/SwipeHelper$UnderlayButtonClickListener;", "clickRegion", "Landroid/graphics/RectF;", "", "contentDescription", "Ljava/lang/String;", "Landroid/graphics/drawable/Drawable;", "imageResId", "Landroid/graphics/drawable/Drawable;", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILid/dana/wallet_v3/util/SwipeHelper$UnderlayButtonClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class UnderlayButton {
        private final int buttonBackgroundcolor;
        private final UnderlayButtonClickListener clickListener;
        private RectF clickRegion;
        private final String contentDescription;
        private final Drawable imageResId;
        private int pos;

        public UnderlayButton(String str, Drawable drawable, int i, UnderlayButtonClickListener underlayButtonClickListener) {
            Intrinsics.checkNotNullParameter(underlayButtonClickListener, "");
            this.contentDescription = str;
            this.imageResId = drawable;
            this.buttonBackgroundcolor = i;
            this.clickListener = underlayButtonClickListener;
        }

        public /* synthetic */ UnderlayButton(String str, Drawable drawable, int i, UnderlayButtonClickListener underlayButtonClickListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, drawable, i, underlayButtonClickListener);
        }

        public final boolean onClick(float x, float y) {
            RectF rectF = this.clickRegion;
            if (rectF != null) {
                Intrinsics.checkNotNull(rectF);
                if (rectF.contains(x, y)) {
                    this.clickListener.onClick(this.pos);
                    return true;
                }
                return false;
            }
            return false;
        }

        public final void onDraw(Canvas canvas, RectF rect, int pos, View itemView) {
            Intrinsics.checkNotNullParameter(canvas, "");
            Intrinsics.checkNotNullParameter(rect, "");
            Intrinsics.checkNotNullParameter(itemView, "");
            Paint paint = new Paint();
            paint.setColor(this.buttonBackgroundcolor);
            canvas.drawRect(rect, paint);
            paint.setTextAlign(Paint.Align.LEFT);
            if (this.imageResId != null) {
                int PlaceComponentResult = ViewExtKt.PlaceComponentResult(10.0f);
                int top = itemView.getTop() + ((itemView.getHeight() - this.imageResId.getIntrinsicHeight()) / 2);
                int intrinsicHeight = this.imageResId.getIntrinsicHeight();
                int right = itemView.getRight();
                this.imageResId.setBounds((right - PlaceComponentResult) - this.imageResId.getIntrinsicWidth(), top, itemView.getRight() - PlaceComponentResult, intrinsicHeight + top);
                this.imageResId.draw(canvas);
            }
            String str = this.contentDescription;
            if (str != null) {
                itemView.setContentDescription(str);
            }
            this.clickRegion = rect;
            this.pos = pos;
        }
    }
}
