// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package myfirstmodule.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the MyFirstModule module
	public static void aCT_Book_Deselect(IContext context, myfirstmodule.proxies.Book _book, myfirstmodule.proxies.Collection _collection)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Book", _book == null ? null : _book.getMendixObject());
		params.put("Collection", _collection == null ? null : _collection.getMendixObject());
		Core.microflowCall("MyFirstModule.ACT_Book_Deselect").withParams(params).execute(context);
	}
	public static void aCT_Book_Save(IContext context, myfirstmodule.proxies.Book _book)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Book", _book == null ? null : _book.getMendixObject());
		Core.microflowCall("MyFirstModule.ACT_Book_Save").withParams(params).execute(context);
	}
	public static void aCT_Book_Select(IContext context, myfirstmodule.proxies.Book _book, myfirstmodule.proxies.Collection _collection)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Book", _book == null ? null : _book.getMendixObject());
		params.put("Collection", _collection == null ? null : _collection.getMendixObject());
		Core.microflowCall("MyFirstModule.ACT_Book_Select").withParams(params).execute(context);
	}
	public static void aCT_Collection_DeselectAll(IContext context, myfirstmodule.proxies.Collection _collection)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Collection", _collection == null ? null : _collection.getMendixObject());
		Core.microflowCall("MyFirstModule.ACT_Collection_DeselectAll").withParams(params).execute(context);
	}
	public static java.util.List<myfirstmodule.proxies.Book> dS_Collection_GetBooks(IContext context, myfirstmodule.proxies.Collection _collection)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Collection", _collection == null ? null : _collection.getMendixObject());
		java.util.List<IMendixObject> objs = Core.microflowCall("MyFirstModule.DS_Collection_GetBooks").withParams(params).execute(context);
		java.util.List<myfirstmodule.proxies.Book> result = null;
		if (objs != null)
		{
			result = new java.util.ArrayList<>();
			for (IMendixObject obj : objs)
				result.add(myfirstmodule.proxies.Book.initialize(context, obj));
		}
		return result;
	}
}