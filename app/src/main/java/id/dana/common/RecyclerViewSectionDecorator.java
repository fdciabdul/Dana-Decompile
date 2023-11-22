package id.dana.common;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;

/* loaded from: classes4.dex */
public class RecyclerViewSectionDecorator extends RecyclerView.ItemDecoration {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final SectionCallback MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private final int getAuthRequestContext;
    private View getErrorConfigVersion;
    private TextView lookAheadTest;
    private int scheduleImpl;

    /* loaded from: classes4.dex */
    public interface SectionCallback {
        CharSequence BuiltInFictitiousFunctionClassFactory(int i);

        boolean PlaceComponentResult(int i);
    }

    public RecyclerViewSectionDecorator(RecyclerView recyclerView, int i, SectionCallback sectionCallback, int i2) {
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: id.dana.common.RecyclerViewSectionDecorator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView2, MotionEvent motionEvent) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean MyBillsEntityDataFactory(RecyclerView recyclerView2, MotionEvent motionEvent) {
                return motionEvent.getY() <= ((float) RecyclerViewSectionDecorator.this.scheduleImpl);
            }
        });
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = sectionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }

    public RecyclerViewSectionDecorator(RecyclerView recyclerView, int i, SectionCallback sectionCallback) {
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: id.dana.common.RecyclerViewSectionDecorator.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView2, MotionEvent motionEvent) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean MyBillsEntityDataFactory(RecyclerView recyclerView2, MotionEvent motionEvent) {
                return motionEvent.getY() <= ((float) RecyclerViewSectionDecorator.this.scheduleImpl);
            }
        });
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = sectionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.PlaceComponentResult = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        View inflate;
        super.onDrawOver(canvas, recyclerView, state);
        if (this.getErrorConfigVersion == null) {
            if (this.PlaceComponentResult) {
                inflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.layout_section_header_sendmoney_v2, (ViewGroup) recyclerView, false);
            } else {
                inflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.layout_section_header, (ViewGroup) recyclerView, false);
            }
            this.getErrorConfigVersion = inflate;
            this.lookAheadTest = (TextView) inflate.findViewById(R.id.res_0x7f0a18be_otpchallengeuistate_verifyinvalidotp);
            View view = this.getErrorConfigVersion;
            view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0), recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), view.getLayoutParams().height));
            this.scheduleImpl = view.getMeasuredHeight();
            view.layout(0, 0, view.getMeasuredWidth(), this.scheduleImpl + 5);
            this.getErrorConfigVersion.setBackgroundColor(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.lookAheadTest.setBackgroundColor(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        String str = "";
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i));
            if (this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(childAdapterPosition) != null) {
                String upperCase = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(childAdapterPosition).toString().toUpperCase();
                this.lookAheadTest.setText(upperCase);
                if (upperCase != null && (!str.equals(upperCase) || this.MyBillsEntityDataFactory.PlaceComponentResult(childAdapterPosition))) {
                    View view2 = this.getErrorConfigVersion;
                    canvas.save();
                    if (this.BuiltInFictitiousFunctionClassFactory) {
                        canvas.translate(0.0f, Math.max(0, r2.getTop() - view2.getHeight()));
                    } else {
                        canvas.translate(0.0f, r2.getTop() - view2.getHeight());
                    }
                    view2.draw(canvas);
                    canvas.restore();
                    str = upperCase;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (this.MyBillsEntityDataFactory.PlaceComponentResult(recyclerView.getChildAdapterPosition(view))) {
            rect.top = this.getAuthRequestContext;
        }
    }
}
