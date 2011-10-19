package events
{
	import autoValueObjects.Pod;
	
	import components.podButton;
	
	import flash.events.Event;
	
	public class PodEvent extends Event
	{
		
		public static var SELECT:String = "POD_SELECT";
		
		public var item:Pod;
		public var container:podButton;
		
		public function PodEvent(type:String)
		{
			super(type, true, true);
		}
	}
}