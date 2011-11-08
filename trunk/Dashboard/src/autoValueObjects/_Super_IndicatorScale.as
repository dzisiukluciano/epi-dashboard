/**
 * This is a generated class and is not intended for modification.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - IndicatorScale.as.
 */

package autoValueObjects
{
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
public class _Super_IndicatorScale extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void
    {
        try
        {
            if (flash.net.getClassByAlias("com.epidataconsulting.metrics.common.domain.IndicatorScale") == null)
            {
                flash.net.registerClassAlias("com.epidataconsulting.metrics.common.domain.IndicatorScale", cz);
            }
        }
        catch (e:Error)
        {
            flash.net.registerClassAlias("com.epidataconsulting.metrics.common.domain.IndicatorScale", cz);
        }
    }

    model_internal static function initRemoteClassAliasAllRelated() : void
    {
    }

    model_internal var _dminternal_model : _IndicatorScaleEntityMetadata;

    /**
     * properties
     */
    private var _internal_id : int;
    private var _internal_reverse : Boolean;
    private var _internal_posicionregBuena : Number;
    private var _internal_regular : Number;
    private var _internal_posicionminReg : Number;
    private var _internal_bueno : Number;
    private var _internal_code : String;
    private var _internal_maximo : Number;
    private var _internal_posicionbuenaMax : Number;
    private var _internal_minimo : Number;

    private static var emptyArray:Array = new Array();

    // Change this value according to your application's floating-point precision
    private static var epsilon:Number = 0.0001;

    /**
     * derived property cache initialization
     */
    model_internal var _cacheInitialized_isValid:Boolean = false;

    model_internal var _changeWatcherArray:Array = new Array();

    public function _Super_IndicatorScale()
    {
        _model = new _IndicatorScaleEntityMetadata(this);

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
    public function get reverse() : Boolean
    {
        return _internal_reverse;
    }

    [Bindable(event="propertyChange")]
    public function get posicionregBuena() : Number
    {
        return _internal_posicionregBuena;
    }

    [Bindable(event="propertyChange")]
    public function get regular() : Number
    {
        return _internal_regular;
    }

    [Bindable(event="propertyChange")]
    public function get posicionminReg() : Number
    {
        return _internal_posicionminReg;
    }

    [Bindable(event="propertyChange")]
    public function get bueno() : Number
    {
        return _internal_bueno;
    }

    [Bindable(event="propertyChange")]
    public function get code() : String
    {
        return _internal_code;
    }

    [Bindable(event="propertyChange")]
    public function get maximo() : Number
    {
        return _internal_maximo;
    }

    [Bindable(event="propertyChange")]
    public function get posicionbuenaMax() : Number
    {
        return _internal_posicionbuenaMax;
    }

    [Bindable(event="propertyChange")]
    public function get minimo() : Number
    {
        return _internal_minimo;
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

    public function set reverse(value:Boolean) : void
    {
        var oldValue:Boolean = _internal_reverse;
        if (oldValue !== value)
        {
            _internal_reverse = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "reverse", oldValue, _internal_reverse));
        }
    }

    public function set posicionregBuena(value:Number) : void
    {
        var oldValue:Number = _internal_posicionregBuena;
        if (isNaN(_internal_posicionregBuena) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_posicionregBuena = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "posicionregBuena", oldValue, _internal_posicionregBuena));
        }
    }

    public function set regular(value:Number) : void
    {
        var oldValue:Number = _internal_regular;
        if (isNaN(_internal_regular) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_regular = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "regular", oldValue, _internal_regular));
        }
    }

    public function set posicionminReg(value:Number) : void
    {
        var oldValue:Number = _internal_posicionminReg;
        if (isNaN(_internal_posicionminReg) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_posicionminReg = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "posicionminReg", oldValue, _internal_posicionminReg));
        }
    }

    public function set bueno(value:Number) : void
    {
        var oldValue:Number = _internal_bueno;
        if (isNaN(_internal_bueno) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_bueno = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bueno", oldValue, _internal_bueno));
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

    public function set maximo(value:Number) : void
    {
        var oldValue:Number = _internal_maximo;
        if (isNaN(_internal_maximo) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_maximo = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "maximo", oldValue, _internal_maximo));
        }
    }

    public function set posicionbuenaMax(value:Number) : void
    {
        var oldValue:Number = _internal_posicionbuenaMax;
        if (isNaN(_internal_posicionbuenaMax) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_posicionbuenaMax = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "posicionbuenaMax", oldValue, _internal_posicionbuenaMax));
        }
    }

    public function set minimo(value:Number) : void
    {
        var oldValue:Number = _internal_minimo;
        if (isNaN(_internal_minimo) == true || Math.abs(oldValue - value) > epsilon)
        {
            _internal_minimo = value;
            this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "minimo", oldValue, _internal_minimo));
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
    public function get _model() : _IndicatorScaleEntityMetadata
    {
        return model_internal::_dminternal_model;
    }

    public function set _model(value : _IndicatorScaleEntityMetadata) : void
    {
        var oldValue : _IndicatorScaleEntityMetadata = model_internal::_dminternal_model;
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
