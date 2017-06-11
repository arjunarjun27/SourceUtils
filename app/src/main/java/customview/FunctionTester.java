package customview;

import android.content.Context;

import Interface.IReportBack;

/**
 * Created by arjun27 on 6/11/2017.
 */

public class FunctionTester extends BaseTester {

    private static String tag = "FunctionTester";

    public FunctionTester(Context ctx, IReportBack target) {
        super(ctx, target);
    }

    public void testToast()
    {
        this.mReportTo.reportTransient(tag, "Test Toast Message");
        this.mReportTo.reportTransient(tag, "22: Test Toast Message");
        this.mReportTo.reportTransient(tag, "33: Test Toast Message");
        this.mReportTo.reportTransient(tag, "44: Test Toast Message");
    }
}
