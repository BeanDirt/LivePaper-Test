package com.beandirt.livepaper.test;

import com.beandirt.livepaper.BitmapManager;
import com.beandirt.livepaper.TimeCalculator;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

public class BitmapManagerTest extends AndroidTestCase {
	
	private BitmapManager bitmapManager;
	private TimeCalculator timeCalculator;
	
	@Override
	protected void setUp() throws Exception {
		timeCalculator = new TimeCalculator();
		bitmapManager = new BitmapManager(timeCalculator, getContext().getResources());
	}

	/**
	 * Test that day resources isn't null
	 */
	
	@SmallTest
	public void testDayResources(){
		assertNotNull(bitmapManager.getDayResources());
	}
	
	/**
	 * Test that night resources isn't null
	 */
	
	@SmallTest
	public void testNightResources(){
		assertNotNull(bitmapManager.getNightResources());
	}
	
	/**
	 * Test that there are 14 day resources
	 */
	
	@MediumTest
	public void testDayResourcesLength(){
		assertEquals(bitmapManager.getDayResources().length,14);
	}
	
	/**
	 * Test that there are 10 night resources
	 */
	
	@MediumTest
	public void testNightResourcesLength(){
		assertEquals(bitmapManager.getNightResources().length,10);
	}
	
	@MediumTest
	public void testCorrectDayInterval(){
		assertEquals(2777.0, Math.floor(bitmapManager.getDayInterval()));
	}
	
	@MediumTest
	public void testCorrectNightInterval(){
		assertEquals(4752.0, Math.floor(bitmapManager.getNightInterval()));
	}
	
	@MediumTest
	public void testCorrectPhotoCounter(){
		
		/******
		 * Testing Scenarios
		 * *asterisk denotes change in photo
		 * 
		 * Day Interval: 00:46:17
		 * Night Interval: 01:19:11
		 * 
		 * Day Time----------------
		 * 07:12:00 - 0*
		 * 07:58:17 - 1*
		 * 08:00:00 - 1
		 * 08:44:34 - 2*
		 * 09:00:00 - 2
		 * 09:30:51 - 3*
		 * 10:00:00 - 3
		 * 10:17:08 - 4*
		 * 11:00:00 - 4
		 * 11:03:25 - 5*
		 * 11:49:42 - 6*
		 * 12:00:00 - 6
		 * 12:35:59 - 7*
		 * 13:00:00 - 7
		 * 13:22:16 - 8*
		 * 14:00:00 - 8
		 * 14:08:33 - 9*
		 * 14:54:50 - 10*
		 * 15:00:00 - 10
		 * 15:41:07 - 11*
		 * 16:00:00 - 11
		 * 16:27:24 - 12*
		 * 17:00:00 - 12
		 * 17:13:41 - 13*
		 * 17:59:58 - 14* <-- Problem here for 2 seconds
		 * 18:00:00 - 0*
		 * 19:00:00 - 0
		 * 19:19:11 - 1*
		 * 20:00:00 - 1
		 * 20:38:22 - 2*
		 * 21:00:00 - 2
		 * 21:57:33 - 3*
		 * 22:00:00 - 3
		 * 23:00:00 - 3
		 * 23:16:44 - 4*
		 * 00:00:00 - 4
		 * 00:35:55 - 5*
		 * 01:00:00 - 5
		 * 01:55:06 - 6*
		 * 02:00:00 - 6
		 * 03:00:00 - 6
		 * 03:14:17 - 7*
		 * 04:00:00 - 7
		 * 04:33:28 - 8*
		 * 05:00:00 - 8
		 * 05:52:39 - 9*
		 * 06:00:00 - 9
		 * 07:00:00 - 9
		 * 07:11:50 - 10* < -- Problem here for 10 seconds
		 * 
		 * 
		 */
		
		int eightOClock = (0 * 60 * 60) + 48 * 60;
		assertEquals(1,bitmapManager.getBitmap(eightOClock));
		
		int nineOClock = (1 * 60 * 60) + (48 * 60);
		assertEquals(2,bitmapManager.getBitmap(nineOClock));
		
		int tenOClock = (2 * 60 * 60) + (48 * 60);
		assertEquals(3,bitmapManager.getBitmap(tenOClock));
		
		int elevenOClock = 3 * 60 * 60 + (48 * 60);
		assertEquals(4,bitmapManager.getBitmap(elevenOClock));
		
		int twelveOClock = 4 * 60 * 60 + (48 * 60);
		assertEquals(6,bitmapManager.getBitmap(twelveOClock));
		
		int thirteenOClock = 5 * 60 * 60 + (48 * 60);
		assertEquals(7,bitmapManager.getBitmap(thirteenOClock));
		
		int fourteenOClock = 6 * 60 * 60 + (48 * 60);
		assertEquals(8,bitmapManager.getBitmap(fourteenOClock));
		
		int fifteenOClock = 7 * 60 * 60 + (48 * 60);
		assertEquals(10,bitmapManager.getBitmap(fifteenOClock));
		
		int sixteenOClock = 8 * 60 * 60 + (48 * 60);
		assertEquals(11,bitmapManager.getBitmap(sixteenOClock));
		
		int seventeenOClock = 9 * 60 * 60 + (48 * 60);
		assertEquals(12,bitmapManager.getBitmap(seventeenOClock));
		
		int eighteenOClock = 10 * 60 * 60 + (48 * 60);
		assertEquals(0,bitmapManager.getBitmap(eighteenOClock));
		
		int nineteenOClock = 11 * 60 * 60 + (48 * 60);
		assertEquals(0,bitmapManager.getBitmap(nineteenOClock));
		
		int twentyOClock = 12 * 60 * 60 + (48 * 60);
		assertEquals(1,bitmapManager.getBitmap(twentyOClock));
		
		int twentyOneOClock = 13 * 60 * 60 + (48 * 60);
		assertEquals(2,bitmapManager.getBitmap(twentyOneOClock));
		
		int twentyTwoOClock = 14 * 60 * 60 + (48 * 60);
		assertEquals(3,bitmapManager.getBitmap(twentyTwoOClock));
		
		int twentyThreeOClock = 15 * 60 * 60 + (48 * 60);
		assertEquals(3,bitmapManager.getBitmap(twentyThreeOClock));
		
		int zeroOClock = 16 * 60 * 60 + (48 * 60);
		assertEquals(4,bitmapManager.getBitmap(zeroOClock));
		
		int oneOClock = 17 * 60 * 60 + (48 * 60);
		assertEquals(5,bitmapManager.getBitmap(oneOClock));

		int twoOClock = 18 * 60 * 60 + (48 * 60);
		assertEquals(6,bitmapManager.getBitmap(twoOClock));

		int threeOClock = 19 * 60 * 60 + (48 * 60);
		assertEquals(6,bitmapManager.getBitmap(threeOClock));
		
		int fourOClock = 20 * 60 * 60 + (48 * 60);
		assertEquals(7,bitmapManager.getBitmap(fourOClock));
		
		int fiveOClock = 21 * 60 * 60 + (48 * 60);
		assertEquals(8,bitmapManager.getBitmap(fiveOClock));

		int sixOClock = 22 * 60 * 60 + (48 * 60);
		assertEquals(9,bitmapManager.getBitmap(sixOClock));

		int sevenOClock = 23 * 60 * 60 + (48 * 60);
		assertEquals(9,bitmapManager.getBitmap(sevenOClock));
	}
}
