/**
 * This is a generated class and is not intended for modification.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - Pod.as.
 */

package autoValueObjects
{
import autoValueObjects.PodType;
import com.adobe.fiber.services.IFiberManagingService;
import com.adobe.fiber.valueobjects.IValueObject;
import flash.events.EventDispatcher;
import mx.events.PropertyChangeEvent;

import flash.net.registerClassAlias;
import flash.net.getClassByAlias;
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.valueobjects.IPropertyIterator;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

use namespace model_internal;

[ExcludeClass]
public class _Super_Pod extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void
    {
        try
        {
            if (flash.net.getClassByAlias("com.epidataconsulting.metrics.server.domain.Pod") == null)
            {
                flash.net.registerClassAlias("com.epidataconsulting.metrics.server.domain.Pod", cz);
            }
        }
        catch (e:Error)
        {
            flash.net.registerClassAlias("com.epidataconsulting.metrics.server.domain.Pod", cz);
        }
    }

    model_internal static function initRemoteClassAliasAllRelated() : void
    {
        autoValueObjects.PodType.initRemoteClassAliasSingleChild();
    }

    model_internal var _dminternal_model : _PodEntityMetadata;

    /**
     * properties
     */
    private var _internal_id : int;
    private var _internal_dataSource : String;
    private var _internal_title : String;
    private var _internal_valueField : String;
    private var _internal_code : String;
    private var _internal_type : autoValueObjects.PodType;
    private var _internal_categoryField : String;
    private var _internal_joinTable : String;

    private static var emptyArray:Array = new Array();


    /**
     * derived property cache initialization
     */
    model_internal var _cacheInitialized_isValid:Boolean = false;

    model_internal var _changeWatcherArray:Array = new Array();

    public function _Super_Pod()
    {
        _model = new _PodEntityMetadata(this);

        // Bind to own data properties for cache invalidation triggering

    }

    /**
     * data property getters
     */

    [Bindable(event="propertyChange")]
    public function get id() : int
    {
        return _internal_id;
    }

    [Bindable(event="propertyChange")]
    public function get dataSource() : String
    {
        return _internal_dataSource;
    }

    [Bindable(event="propertyChange")]
    public function get title() : String
    {
        return _internal_title;
    }

    [Bindable(event="propertyChange")]
    public function get valueField() : String
    {
        return _internal_valueField;
    }

    [Bindable(event="propertyChange")]
    public function get code() : String
    {
        return _internal_code;
    }

    [Bindable(event="propertyChange")]
    public function get type() : autoValueObjects.PodType
    {
        return _internal_type;
    }

    [Bindable(event="propertyChange")]
    public function get categoryField() : String
    {
        return _internal_categoryField;
    }

    [Bindable(event="propertyChange")]
    public function get joinTable() : String
    {
        return _internal_joinTable;
    }

    /**
     * data property setters
     */

    public function set id(value:int) : void
    {
        var oldValue:int = _internal_id;
        if (oldValue !== value)
        {
            _internal_id = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "id", oldValue, _internal_id));
        }
    }

    public function set dataSource(value:String) : void
    {
        var oldValue:String = _internal_dataSource;
        if (oldValue !== value)
        {
            _internal_dataSource = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "dataSource", oldValue, _internal_dataSource));
        }
    }

    public function set title(value:String) : void
    {
        var oldValue:String = _internal_title;
        if (oldValue !== value)
        {
            _internal_title = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "title", oldValue, _internal_title));
        }
    }

    public function set valueField(value:String) : void
    {
        var oldValue:String = _internal_valueField;
        if (oldValue !== value)
        {
            _internal_valueField = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "valueField", oldValue, _internal_valueField));
        }
    }

    public function set code(value:String) : void
    {
        var oldValue:String = _internal_code;
        if (oldValue !== value)
        {
            _internal_code = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "code", oldValue, _internal_code));
        }
    }

    public function set type(value:autoValueObjects.PodType) : void
    {
        var oldValue:autoValueObjects.PodType = _internal_type;
        if (oldValue !== value)
        {
            _internal_type = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "type", oldValue, _internal_type));
        }
    }

    public function set categoryField(value:String) : void
    {
        var oldValue:String = _internal_categoryField;
        if (oldValue !== value)
        {
            _internal_categoryField = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "categoryField", oldValue, _internal_categoryField));
        }
    }

    public function set joinTable(value:String) : void
    {
        var oldValue:String = _internal_joinTable;
        if (oldValue !== value)
        {
            _internal_joinTable = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "joinTable", oldValue, _internal_joinTable));
        }
    }

    /**
     * Data property setter listeners
     *
     * Each data property whose value affects other properties or the validity of the entity
     * needs to invalidate all previously calculated artifacts. These include:
     *  - any derived properties or constraints that reference the given data property.
     *  - any availability guards (variant expressions) that reference the given data property.
     *  - any style validations, message tokens or guards that reference the given data property.
     *  - the validity of the property (and the containing entity) if the given data property has a length restriction.
     *  - the validity of the property (and the containing entity) if the given data property is required.
     */


    /**
     * valid related derived properties
     */
    model_internal var _isValid : Boolean;
    model_internal var _invalidConstraints:Array = new Array();
    model_internal var _validationFailureMessages:Array = new Array();

    /**
     * derived property calculators
     */

    /**
     * isValid calculator
     */
    model_internal function calculateIsValid():Boolean
    {
        var violatedConsts:Array = new Array();
        var validationFailureMessages:Array = new Array();

        var propertyValidity:Boolean = true;

        model_internal::_cacheInitialized_isValid = true;
        model_internal::invalidConstraints_der = violatedConsts;
        model_internal::validationFailureMessages_der = validationFailureMessages;
        return violatedConsts.length == 0 && propertyValidity;
    }

    /**
     * derived property setters
     */

    model_internal function set isValid_der(value:Boolean) : void
    {
        var oldValue:Boolean = model_internal::_isValid;
        if (oldValue !== value)
        {
            model_internal::_isValid = value;
            _model.model_internal::fireChangeEvent("isValid", oldValue, model_internal::_isValid);
        }
    }

    /**
     * derived property getters
     */

    [Transient]
    [Bindable(event="propertyChange")]
    public function get _model() : _PodEntityMetadata
    {
        return model_internal::_dminternal_model;
    }

    public function set _model(value : _PodEntityMetadata) : void
    {
        var oldValue : _PodEntityMetadata = model_internal::_dminternal_model;
        if (oldValue !== value)
        {
            model_internal::_dminternal_model = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "_model", oldValue, model_internal::_dminternal_model));
        }
    }

    /**
     * methods
     */


    /**
     *  services
     */
    private var _managingService:com.adobe.fiber.services.IFiberManagingService;

    public function set managingService(managingService:com.adobe.fiber.services.IFiberManagingService):void
    {
        _managingService = managingService;
    }

    model_internal function set invalidConstraints_der(value:Array) : void
    {
        var oldValue:Array = model_internal::_invalidConstraints;
        // avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_invalidConstraints = value;
            _model.model_internal::fireChangeEvent("invalidConstraints", oldValue, model_internal::_invalidConstraints);
        }
    }

    model_internal function set validationFailureMessages_der(value:Array) : void
    {
        var oldValue:Array = model_internal::_validationFailureMessages;
        // avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_validationFailureMessages = value;
            _model.model_internal::fireChangeEvent("validationFailureMessages", oldValue, model_internal::_validationFailureMessages);
        }
    }


}

}
