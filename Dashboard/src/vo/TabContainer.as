package vo
{
	
	import autoValueObjects.Tab;
	
	import mx.binding.utils.BindingUtils;
	
	import spark.components.NavigatorContent;

	public class TabContainer extends NavigatorContent
	{
		public function TabContainer(tab:Tab)
		{
			this.tab = tab;
			BindingUtils.bindProperty(this,"label",this.tab,"name");
		}
		
		[Embed(source="/assets/plus.png")]
		private var plusIcon:Class;
		
		private var _newTab:Boolean = false;
		
		public var tab:Tab;
		
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