## AutocompleteMultiselect
Widget that can be used to select one or many options from a dropdown. The user can search in the dropdown for the option he is looking for. Widget is based on https://material-ui.com/components/autocomplete/.

## Features
- Select multiple options out of a list
- Use as single select
- User can search easily for the correct option
- Limit the tags to show in the front-end
- Styling options
- Load data only after opening the dropdown
- Load data only after filling in x chars

## Usage
The widget needs a context object to work to be able to store the response. You can choose to make this object non-persistent. Configure the data source to retrieve the options to show in the dropdown and select which attribute can be used as title. If you want some options to be selected when rendering the widget, also choose the attribute that can be used for the default selection property. Sometimes you need the options to be non-persistent, e.g. when the default selected attribute is user specific and can therefore not be stored in the database. After these options are configured, the onchange event can be setup when needed and other options can be set that influence the behavior and layout of the widget. When the value(s) in the dropdown are changed, the response attribute is set and can be used to do what you want, e.g. set an association. If "No close on select" is set to true, the onchange action is triggered many times in a short time and can interfere. Therefore it is adviced in this case to map the response only when needed, e.g. when hitting save.

## Configuration
### General
- Default mendix behavior for labeling and visibility.
- Editable: Expression that can be used to indicate whether the widget is editable or not. If left empty, the widget will be editable.
- Data source: Should return the options to be rendered.
- Title: The attribute that is used to show as dropdown option. Should be unique to be able to make a distinction between the items.
- Key: Attribute where the key is stored. This key is only used in the response and can be used when the title does not suffice to find the object in mendix. The new JSON will be for example [{"title":"example1", "key":"1234"}] for multiselect when a string key is used.
- Default selected: Boolean attribute where is stored whether this option should be selected by default when loading the widget for the first time.
- Default selected string: **Advanced,** Can be used instead of Default selected. If this one is used, the default selected property is ignored. This property links to a string where the default selected titles are stored in the json format ["title1","title2"]. This option can be used when the default attribute cannot be stored in the database and you do not want to create a list of non-persistent entities to be used in the dropdown.
- Multi-select: If set to true, multiple options can be selected. Otherwise, the widget can be used as single-select.

### Events
- On Change Action: Action to trigger when an option is selected or deselected. Since this action is triggered for every change and this can happen quite fast if "No close on select" is set to true, it is wise to keep this action very short. If this combination is used, the response can best be mapped when used e.g. on save.
- Response: Attribute where the selected items are stored in json format ([{"title":"example1"}] for multiselect and {"title":"example1"} for single select). User needs write access on this attribute.
- Refresh: Set to true to refresh the widget back to the default values, widget will set the value back to false. Make sure the user has got write access. Widget will only be reset when the context object is refreshed.


### Behavior
- No close on select: Whether or not to close the list when an item is selected. Set to true to not close the list when an item is selected.
- Filter selected options: Whether or not to filter the options out of the list that are already selected.
- Limit Tags: Maximum number of selected tags to show if the dropdown is closed. If more options are selected, there will be an indication how many options are selected (e.g. +2) If set to 0, there is no limit.

### Layout
- No Options: Text to show when no options found.
- Placeholder: Default value to show as placeholder.
- Label: Other way to display the label, within the widget.
- Variant: How the text field will be styled, either standard or outlined.
- Checkboxes: Whether or not to show checkboxes in front of the options.

### Data source attribute
- Data source attribute: This property will overrule the data source and default selected properties. Attribute should contain the list of items to be shown in the widget in the JSON format ([{"title":"title1", "key":"key1", "default":true}]), where default and key are optional.
Can be used when the items are non-persistent and you don't want to keep them in cache or when you only want to load items when the widget is selected or X chars are filled in.

****Below properties are only available if this property is used.****
- Loading text: Text to show when loading
- On Open Action: Action to trigger when the widget is opened, this flow has to fill in the data source attribute. Make sure to refresh the object, otherwise the loading state will remain visible when options did not change.

**_Custom search_**
- On input change: Action to trigger when the input value is changed, this flow has to fill in the JSON attribute. Make sure to refresh the object, otherwise the loading state will remain visible when options did not change. Note that this action is also executed after an option is selected or when the dropdown is closed, since the input value will be cleared. 
If you use this property and Search after X chars is set to 0, you might want to also use the on open action.
- Search value: attribute used to store the input value that can be used in the on input change action. Make sure the user has got write access.
- Search after X chars: Only execute "on input change" after X chars or more are filled in. If less chars a filled in, no options are shown and a text is shown. For every char added, the action is executed.
- To few chars text: Text to show when to few chars are filled
- Input change delay: Determines how many ms to wait after the last input change to execute the action. Used to determine whether a person is still typing.

#### Known issues
- Loading indicator keeps showing: Make sure you refresh the object in the on open action and on input change. This is needed since in some cases the option list won't change. Refreshing the object lets the widget know it is done loading.
