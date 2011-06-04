package com.beandirt.livepaper.test;

import android.content.Intent;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import com.beandirt.livepaper.LivePaper;

public class LivePaperTest extends ServiceTestCase<LivePaper> {

	public LivePaperTest() {
		super(LivePaper.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent startIntent = new Intent();
		startIntent.setClass(getContext(), LivePaper.class);
		startService(startIntent);
	}
	
	/**
	 * Test service itself isn't null
	 */
	
	@SmallTest
	public void testService(){
		assertNotNull(this.getService());
	}
}
