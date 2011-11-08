/*
* Base class for pod content.
*/

package com.esria.samples.dashboard.view
{
import autoServices.PodDataService;

import autoValueObjects.Pod;

import flash.xml.XMLNode;

import spark.components.VGroup;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.events.FlexEvent;
import mx.events.IndexChangedEvent;
import mx.utils.ObjectProxy;

public class PodContentBase extends VGroup
{
	[Bindable]
	public var pod:Pod;
	
	function PodContentBase()
	{
		super();
		percentWidth = 100;
		percentHeight = 100;
	}
	
	// abstract.
	protected function retrievePodDataResultHandler(e:*):void	{}
	
	
	// Dispatches an event when the ViewStack index changes, which triggers a state save.
	// ViewStacks are only in ChartContent and FormContent.
	protected function dispatchViewStackChange(newIndex:Number):void
	{
		dispatchEvent(new IndexChangedEvent(IndexChangedEvent.CHANGE, true, false, null, -1, newIndex));
	}
}
}