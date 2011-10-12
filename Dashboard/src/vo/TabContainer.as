package vo
{
	
	import spark.components.NavigatorContent;

	public class TabContainer extends NavigatorContent
	{
		public function TabContainer()
		{
		}
		
		[Embed(source="/assets/plus.png")]
		private var plusIcon:Class;
		
		private var _newTab:Boolean = false;
		
		public function set newTab(value:Boolean):void{
			this._newTab = value;
			if(value){
				this.icon = plusIcon;
			}else{
				this.icon = null;
			}
		}
		
		public function get newTab():Boolean{
			return this._newTab;
		}

	}
}