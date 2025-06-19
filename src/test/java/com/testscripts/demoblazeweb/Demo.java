package com.testscripts.demoblazeweb;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblazeweb.Base;
import com.listeners.demoblazeweb.EventList;


@Listeners(EventList.class)
public class Demo extends Base {

	@Test
	public void DemoTest() {
		
	}
}
